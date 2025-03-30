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

Tentu! Berikut adalah penjelasan tambahan mengenai **kelas-kelas** yang ada di dalam program **TP5DPBO2025C1**.

## Penjelasan Kelas

### 1. **Kelas `Mahasiswa`**
Kelas ini digunakan untuk menyimpan informasi mengenai data mahasiswa. Kelas `Mahasiswa` terdiri dari atribut-atribut untuk menyimpan **NIM**, **Nama**, **Jenis Kelamin**, dan **Kehadiran** mahasiswa.

#### Atribut:
- `nim`: Menyimpan Nomor Induk Mahasiswa (NIM).
- `nama`: Menyimpan Nama Mahasiswa.
- `jenisKelamin`: Menyimpan Jenis Kelamin Mahasiswa (Laki-laki/Perempuan).
- `kehadiran`: Menyimpan nilai **Kehadiran** mahasiswa, yang digunakan untuk mengukur tingkat kehadiran mahasiswa dengan menggunakan **JSlider**.

#### Constructor:
Kelas ini memiliki konstruktor yang digunakan untuk menginisialisasi atribut `nim`, `nama`, `jenisKelamin`, dan `kehadiran`.

#### Metode:
- **Getter dan Setter**: Untuk mengakses dan memodifikasi atribut mahasiswa.
- **toString**: Digunakan untuk menampilkan representasi string dari objek `Mahasiswa`.

### 2. **Kelas `Database`**
Kelas `Database` berfungsi sebagai penghubung antara aplikasi dan **MySQL database**. Kelas ini menyediakan berbagai metode untuk melakukan operasi **CRUD** (Create, Read, Update, Delete) pada data mahasiswa yang disimpan dalam database.

#### Atribut:
- `connection`: Menyimpan koneksi ke database MySQL.
- `statement`: Digunakan untuk mengeksekusi query SQL.

#### Constructor:
Konstruktor ini digunakan untuk membuat koneksi ke database MySQL menggunakan **JDBC** dan membuat objek `statement` untuk mengeksekusi query SQL.

#### Metode:
- **selectQuery(String sql)**: Digunakan untuk mengeksekusi query SELECT dan mengembalikan hasilnya dalam bentuk `ResultSet`.
- **insertUpdateDeleteQuery(String sql)**: Digunakan untuk mengeksekusi query **INSERT**, **UPDATE**, atau **DELETE**.
- **isNimExist(String nim)**: Memeriksa apakah **NIM** yang diberikan sudah ada dalam database. Digunakan saat menambahkan mahasiswa baru untuk memastikan tidak ada **NIM** yang duplikat.
- **saveMahasiswaToDatabase(String nim, String nama, String jenisKelamin, int kehadiran)**: Digunakan untuk menambahkan data mahasiswa baru ke dalam database.
- **updateMahasiswa(String nim, String nama, String jenisKelamin, int kehadiran)**: Digunakan untuk memperbarui data mahasiswa yang sudah ada berdasarkan **NIM**.
- **deleteMahasiswa(String nim)**: Digunakan untuk menghapus data mahasiswa berdasarkan **NIM**.

### 3. **Kelas `Menu`**
Kelas `Menu` adalah kelas utama yang bertanggung jawab untuk menangani antarmuka pengguna (GUI) dan logika program yang terkait dengan **CRUD** data mahasiswa. Kelas ini berinteraksi dengan **JTextField**, **JComboBox**, **JSlider**, **JTable**, dan tombol-tombol (seperti **Add**, **Update**, **Delete**, dan **Cancel**) yang digunakan dalam aplikasi.

#### Atribut:
- **JPanel mainPanel**: Panel utama yang menampung semua komponen GUI.
- **JTextField nimField, namaField**: Digunakan untuk input **NIM** dan **Nama** mahasiswa.
- **JComboBox jenisKelaminComboBox**: Digunakan untuk memilih jenis kelamin mahasiswa (Laki-laki/Perempuan).
- **JSlider kehadiranSlider**: Digunakan untuk memilih nilai kehadiran mahasiswa.
- **JButton addUpdateButton, cancelButton, deleteButton**: Tombol untuk menambah, memperbarui, menghapus data mahasiswa, dan membatalkan input.
- **JTable mahasiswaTable**: Tabel untuk menampilkan data mahasiswa yang ada dalam database.
- **JLabel titleLabel, nimLabel, namaLabel, jenisKelaminLabel, KehadiranLabel**: Label untuk menampilkan judul dan informasi lainnya.

#### Metode:
- **setTable()**: Mengambil data mahasiswa dari database dan menampilkannya di dalam tabel **mahasiswaTable**.
- **insertData()**: Menambahkan data mahasiswa baru ke dalam database jika semua field telah diisi dengan benar.
- **updateData()**: Memperbarui data mahasiswa yang dipilih di dalam tabel, dan menyimpannya kembali ke database.
- **deleteData()**: Menghapus data mahasiswa yang dipilih di dalam tabel dari database.
- **clearForm()**: Mengosongkan form input dan mengatur ulang tombol dan status form.
- **refreshTable()**: Memperbarui tabel mahasiswa dengan data terbaru dari database.

#### Alur Kerja Kelas `Menu`:
1. **Start Program**:
   - Program dimulai dengan membuat objek `Menu`, yang menginisialisasi semua komponen GUI dan menghubungkannya dengan logika program.
   - Program akan menampilkan tabel mahasiswa dengan data yang diambil dari database.

2. **Menambahkan Mahasiswa**:
   - Pengguna dapat memasukkan data **NIM**, **Nama**, memilih **Jenis Kelamin**, dan menggunakan **JSlider** untuk menentukan **Kehadiran** mahasiswa.
   - Data mahasiswa yang dimasukkan akan ditambahkan ke dalam database, dan tabel akan diperbarui.

3. **Memperbarui Mahasiswa**:
   - Pengguna memilih salah satu baris dari tabel untuk mengedit data mahasiswa tersebut.
   - Setelah memilih baris dan mengubah data di form, pengguna dapat menekan tombol **Update** untuk menyimpan perubahan ke dalam database.

4. **Menghapus Mahasiswa**:
   - Pengguna memilih baris yang ingin dihapus, dan menekan tombol **Delete** untuk menghapus data dari database.

5. **Reset Form**:
   - Tombol **Cancel** digunakan untuk mengosongkan semua input di form dan mereset form ke keadaan awal.

## Alur Program

**Main Program (Menu)**:
- Saat program dimulai, jendela aplikasi akan muncul dengan form kosong dan tabel mahasiswa.
- **Tabel Mahasiswa**: Data mahasiswa di-load dari database menggunakan **db_mahasiswa.sql**.
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
