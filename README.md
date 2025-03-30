# TP5DPBO2025C1

## Janji
_Saya, **Hafsah Hamidah** dengan NIM **2311474**, mengerjakan **Tugas Praktikum 5** dalam mata kuliah **DPBO** dengan sebaik-baiknya demi keberkahan-Nya.  
Saya berjanji tidak melakukan kecurangan sebagaimana yang telah dispesifikasikan. **Aamiin.**_

## Deskripsi Program

Program ini adalah aplikasi berbasis **Java Swing** yang digunakan untuk mengelola data mahasiswa dengan terhubung ke database **MySQL**. Aplikasi ini menggunakan berbagai komponen GUI seperti **JTextField**, **JComboBox**, **JSlider**, **JButton**, dan **JTable** untuk menampilkan dan mengedit data mahasiswa. Program ini memungkinkan pengguna untuk melakukan **CRUD** (Create, Read, Update, Delete) pada data mahasiswa, serta menampilkan informasi terkait mahasiswa di dalam tabel.

Program ini dilengkapi dengan slider untuk mengukur **Kehadiran Mahasiswa** dan memungkinkan interaksi dengan pengguna melalui form untuk menambah, memperbarui, dan menghapus data mahasiswa yang terhubung langsung dengan **database MySQL**.

### Fitur utama:
1. Menampilkan data mahasiswa dalam tabel yang terhubung ke database.
2. Menambahkan mahasiswa baru ke dalam database.
3. Memperbarui data mahasiswa yang sudah ada.
4. Menghapus data mahasiswa dari database.
5. Menggunakan **JSlider** untuk mengukur kehadiran mahasiswa dan memperbarui label setiap kali nilai slider berubah.
6. Validasi input untuk memastikan data tidak kosong dan NIM unik.

## Alur Program

**Main Program (Menu)**:
- Saat program dimulai, jendela aplikasi akan muncul dengan form kosong dan tabel mahasiswa.
- **Tabel Mahasiswa**: Data mahasiswa di-load dari database menggunakan **db_mahasiswa.sql*.
- **Add/Update**:
  - Pengguna dapat memasukkan data mahasiswa baru atau memperbarui data mahasiswa yang sudah ada.
  - Jika tombol **Add** ditekan, data akan dimasukkan ke dalam database dan tabel diperbarui.
  - Jika tombol **Update** ditekan, data yang dipilih pada tabel akan diperbarui dengan data yang dimasukkan dalam form dan disimpan ke database.
  
**Tabel Mahasiswa**:
- Tabel menampilkan data mahasiswa yang tersimpan dalam database.
- Pengguna dapat memilih salah satu baris tabel untuk mengedit atau menghapus data mahasiswa tersebut.

**Delete**:
- Setelah memilih baris pada tabel, pengguna dapat menghapus data mahasiswa yang terpilih.

### 3. Komponen GUI
- **JTextField**: Digunakan untuk input **NIM** dan **Nama** mahasiswa.
- **JComboBox**: Untuk memilih **Jenis Kelamin** mahasiswa.
- **JSlider**: Untuk input **Kehadiran** mahasiswa, dengan nilai yang bisa dilihat di **JLabel**.
- **JButton**: Digunakan untuk tombol **Add**, **Update**, **Delete**, dan **Cancel**.
- **JTable**: Menampilkan data mahasiswa yang ada dalam database.

## Alur Kerja

### 1. Start Program
- Program dimulai dengan membuat objek dari kelas **Menu** yang menginisialisasi komponen-komponen GUI seperti **JTextField**, **JComboBox**, **JSlider**, **JButton**, dan **JTable**.
- Data mahasiswa yang ada dimasukkan dari **database** ke dalam **listMahasiswa** dan kemudian ditampilkan dalam tabel.

### 2. Menambahkan Mahasiswa
- Pengguna mengisi **NIM**, **Nama**, dan memilih **Jenis Kelamin** serta **Kehadiran** menggunakan **JSlider**.
- Data mahasiswa baru akan ditambahkan ke dalam **database** dan tabel diperbarui dengan memanggil **setTable()**.

### 3. Memperbarui Mahasiswa
- Pengguna memilih baris dalam tabel dan mengedit data mahasiswa pada form.
- Setelah menekan **Update**, data mahasiswa yang dipilih pada tabel akan diperbarui di **database**.

### 4. Menghapus Mahasiswa
- Pengguna memilih baris dalam tabel yang ingin dihapus.
- Setelah menekan tombol **Delete**, mahasiswa yang dipilih akan dihapus dari **database** dan tabel diperbarui.

### 5. Reset Form
- Tombol **Cancel** akan menghapus data yang dimasukkan dan reset form kembali ke keadaan semula.

### 6. Validasi Input
- Ketika data dimasukkan oleh pengguna, program memeriksa apakah ada input yang kosong.
- Jika ada **NIM** yang duplikat atau input kosong, program menampilkan dialog error untuk masing-masing field yang bermasalah.
- Proses **CRUD** hanya dapat dilakukan jika semua field telah diisi dengan benar dan tidak ada duplikasi **NIM**.

## Dokumentasi

https://github.com/user-attachments/assets/d84cc076-0c2e-4947-98f9-1113fd3bfe5f
