import java.sql.*;

public class Database {
    private Connection connection;
    private Statement statement;

    // constructor
    public Database() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_mahasiswa", "root", "");
            statement = connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // digunakan untuk SELECT
    public ResultSet selectQuery(String sql) {
        try {
            statement.executeQuery(sql);
            return statement.getResultSet();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // digunakan untuk INSERT, UPDATE, dan DELETE
    public int insertUpdateDeleteQuery(String sql) {
        try {
            return statement.executeUpdate(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // getter
    public Statement getStatement() {
        return statement;
    }

    // Method untuk memeriksa apakah NIM sudah ada di database
    public boolean isNimExist(String nim) {
        String sql = "SELECT COUNT(*) FROM mahasiswa WHERE nim = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, nim);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt(1) > 0;
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error checking NIM existence: " + e.getMessage());
        }
        return false;
    }

    // Method untuk menyimpan data mahasiswa ke database
    public void saveMahasiswaToDatabase(String nim, String nama, String jenisKelamin, int kehadiran) {
        String sql = "INSERT INTO mahasiswa (nim, nama, jenis_kelamin, kehadiran) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, nim);
            preparedStatement.setString(2, nama);
            preparedStatement.setString(3, jenisKelamin);
            preparedStatement.setInt(4, kehadiran);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error INSERT Mahasiswa: " + e.getMessage());
        }
    }

    // Method untuk mendapatkan data mahasiswa berdasarkan NIM
    public ResultSet getMahasiswaByNim(String nim) {
        String sql = "SELECT * FROM mahasiswa WHERE nim = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, nim);
            return preparedStatement.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException("Error fetching mahasiswa by NIM: " + e.getMessage());
        }
    }

    // Method untuk update data mahasiswa berdasarkan NIM
    public void updateMahasiswa(String nim, String nama, String jenisKelamin, int kehadiran) {
        String sql = "UPDATE mahasiswa SET nama = ?, jenis_kelamin = ?, kehadiran = ? WHERE nim = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, nama);
            preparedStatement.setString(2, jenisKelamin);
            preparedStatement.setInt(3, kehadiran);
            preparedStatement.setString(4, nim);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error updating mahasiswa: " + e.getMessage());
        }
    }

    // Method untuk delete data mahasiswa berdasarkan NIM
    public void deleteMahasiswa(String nim) {
        String sql = "DELETE FROM mahasiswa WHERE nim = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, nim);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error deleting mahasiswa: " + e.getMessage());
        }
    }

    // Menutup koneksi database
    public void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error closing connection: " + e.getMessage());
        }
    }
}
