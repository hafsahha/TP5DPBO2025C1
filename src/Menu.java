import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.ArrayList;

public class Menu extends JFrame {
    private int selectedIndex = -1;
    private ArrayList<Mahasiswa> listMahasiswa;
    private Database database;
    private JPanel mainPanel;
    private JTextField nimField;
    private JTextField namaField;
    private JTable mahasiswaTable;
    private JButton addUpdateButton;
    private JButton cancelButton;
    private JComboBox<String> jenisKelaminComboBox;
    private JSlider kehadiranSlider;
    private JButton deleteButton;
    private JLabel titleLabel;
    private JLabel nimLabel;
    private JLabel namaLabel;
    private JLabel jenisKelaminLabel;
    private JLabel KehadiranLabel;

    public static void main(String[] args) {
        Menu window = new Menu();
        window.setSize(480, 560);
        window.setLocationRelativeTo(null);
        window.setContentPane(window.mainPanel);
        window.getContentPane().setBackground(Color.white);
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public Menu() {
        listMahasiswa = new ArrayList<>();
        database = new Database();

        mahasiswaTable.setModel(setTable());
        titleLabel.setFont(titleLabel.getFont().deriveFont(Font.BOLD, 20f));

        String[] jenisKelaminData = { "Laki-laki", "Perempuan" };
        jenisKelaminComboBox.setModel(new DefaultComboBoxModel<>(jenisKelaminData));

        deleteButton.setVisible(false);

        kehadiranSlider.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                int value = kehadiranSlider.getValue();
                KehadiranLabel.setText("Kehadiran: " + value + "%");
            }
        });

        addUpdateButton.addActionListener(e -> {
            if (selectedIndex == -1) {
                insertData();
            } else {
                updateData();
            }
        });

        deleteButton.addActionListener(e -> {
            if (selectedIndex >= 0) {
                deleteData();
            }
        });

        cancelButton.addActionListener(e -> clearForm());

        mahasiswaTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                selectedIndex = mahasiswaTable.getSelectedRow();
                String selectedNim = mahasiswaTable.getValueAt(selectedIndex, 1).toString();
                String selectedNama = mahasiswaTable.getValueAt(selectedIndex, 2).toString();
                String selectedJenisKelamin = mahasiswaTable.getValueAt(selectedIndex, 3).toString();

                nimField.setText(selectedNim);
                namaField.setText(selectedNama);
                jenisKelaminComboBox.setSelectedItem(selectedJenisKelamin);

                addUpdateButton.setText("Update");
                deleteButton.setVisible(true);
            }
        });
    }

    public final DefaultTableModel setTable() {
        Object[] column = { "No.", "NIM", "Nama", "Jenis Kelamin", "Kehadiran" };
        DefaultTableModel temp = new DefaultTableModel(null, column);

        try {
            ResultSet resultSet = database.selectQuery("SELECT * FROM mahasiswa");

            int i = 0;
            while (resultSet.next()) {
                Object[] row = new Object[5];
                row[0] = i + 1;
                row[1] = resultSet.getString("nim");
                row[2] = resultSet.getString("nama");
                row[3] = resultSet.getString("jenis_kelamin");
                row[4] = resultSet.getInt("kehadiran");
                temp.addRow(row);
                i++;
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error in SELECT query: " + e);
        }

        return temp;
    }

    public void insertData() {
        String nim = nimField.getText();
        String nama = namaField.getText();
        String jenisKelamin = jenisKelaminComboBox.getSelectedItem().toString();
        Integer kehadiran = kehadiranSlider.getValue();

        // Validasi input
        if (nim.isEmpty() || nama.isEmpty()) {
            JOptionPane.showMessageDialog(null, "NIM dan Nama tidak boleh kosong!");
            return;
        }

        // Validasi jika NIM sudah ada di database
        if (database.isNimExist(nim)) {
            JOptionPane.showMessageDialog(null, "NIM sudah ada!");
            return;
        }

        String sql = "INSERT INTO mahasiswa (nim, nama, jenis_kelamin, kehadiran) VALUES ('" + nim + "', '" + nama + "', '" + jenisKelamin + "', " + kehadiran + ")";
        int result = database.insertUpdateDeleteQuery(sql);
        if (result > 0) {
            JOptionPane.showMessageDialog(null, "Data berhasil ditambah!");
            refreshTable();
        }
    }

    public void updateData() {
        String nim = nimField.getText();
        String nama = namaField.getText();
        String jenisKelamin = jenisKelaminComboBox.getSelectedItem().toString();
        Integer kehadiran = kehadiranSlider.getValue();

        // Validasi input
        if (nim.isEmpty() || nama.isEmpty()) {
            JOptionPane.showMessageDialog(null, "NIM dan Nama tidak boleh kosong!");
            return;
        }

        // Update data mahasiswa
        String sql = "UPDATE mahasiswa SET nama = '" + nama + "', jenis_kelamin = '" + jenisKelamin + "', kehadiran = " + kehadiran + " WHERE nim = '" + nim + "'";
        int result = database.insertUpdateDeleteQuery(sql);
        if (result > 0) {
            JOptionPane.showMessageDialog(null, "Data berhasil diubah!");
            refreshTable();
        }
    }

    public void deleteData() {
        String nim = nimField.getText();
        String sql = "DELETE FROM mahasiswa WHERE nim = '" + nim + "'";

        int result = database.insertUpdateDeleteQuery(sql);
        if (result > 0) {
            JOptionPane.showMessageDialog(null, "Data berhasil dihapus!");
            refreshTable();
        }
    }

    public void refreshTable() {
        mahasiswaTable.setModel(setTable());
    }

    public void clearForm() {
        nimField.setText("");
        namaField.setText("");
        jenisKelaminComboBox.setSelectedItem("");
        kehadiranSlider.setValue(50);
        addUpdateButton.setText("Add");
        deleteButton.setVisible(false);
        selectedIndex = -1;
    }
}
