# 🌤️ Aplikasi Cek Cuaca Sederhana

Sebuah aplikasi desktop Java yang elegan untuk memeriksa kondisi cuaca secara real-time dengan antarmuka yang user-friendly.

## ✨ Fitur Utama

### 🔍 Pencarian Cuaca
- Input nama kota untuk mendapatkan informasi cuaca terkini
- Tampilan suhu dalam Celsius
- Deskripsi kondisi cuaca dalam Bahasa Indonesia
- Ikon cuaca yang dinamis sesuai kondisi

### 📌 Manajemen Kota Favorit
- Penyimpanan otomatis kota yang sering dicek (setelah 3x pengecekan)
- Akses cepat melalui dropdown menu
- Penambahan manual ke daftar favorit

### 🔄 Riwayat & Penyimpanan
- Tabel riwayat 10 pencarian terakhir
- Penyimpanan data ke file CSV
- Loading otomatis data tersimpan saat startup

### 🎨 Tampilan Visual
- Ikon cuaca yang intuitif untuk setiap kondisi:
  - ☀️ Cerah
  - ⛅ Berawan
  - 🌧️ Hujan
  - ⛈️ Badai
  - 🌫️ Berkabut
  - Dan lainnya

## 🛠️ Teknologi

- Java Swing untuk GUI
- OpenWeatherMap API untuk data cuaca
- JSON parsing untuk pengolahan data
- File handling untuk penyimpanan lokal

## 📋 Prasyarat

- Java Development Kit (JDK) 8+
- Koneksi Internet aktif
- API Key OpenWeatherMap

## 🚀 Cara Penggunaan

1. **Memulai Aplikasi**
   - Jalankan aplikasi
   - Tunggu loading data tersimpan (jika ada)

2. **Mengecek Cuaca**
   - Masukkan nama kota di field input
   - Klik "Cek Cuaca"
   - Lihat hasil di panel informasi

3. **Menyimpan Data**
   - Klik "Simpan" untuk menyimpan hasil ke CSV
   - Data akan otomatis dimuat saat aplikasi dibuka kembali

4. **Menggunakan Favorit**
   - Pilih kota dari dropdown untuk pengecekan cepat
   - Kota akan otomatis masuk favorit setelah 3x dicek

## ⚙️ Konfigurasi

