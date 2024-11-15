

import java.awt.Image;
import java.awt.event.ItemEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import org.json.JSONObject;

public class AplikasiCekCuacaSederhana extends javax.swing.JFrame {

    private static final int ICON_SIZE = 50;  // Ukuran ikon cuaca
    private Map<String, Integer> cityCheckCount = new HashMap<>(); // Menyimpan jumlah pengecekan per kota
    private DefaultTableModel tableModel; // Model untuk tabel data cuaca

    /**
     * Konstruktor untuk membuat form Aplikasi Cek Cuaca Sederhana
     */
    public AplikasiCekCuacaSederhana() {
        initComponents();
        loadWeatherData(); // Memuat data cuaca yang tersimpan saat aplikasi dimulai
    }

    // Method yang dihasilkan secara otomatis oleh GUI builder
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cuacaLabel = new javax.swing.JLabel();
        btnCek = new javax.swing.JButton();
        btnSimpan = new javax.swing.JButton();
        fieldKota = new javax.swing.JTextField();
        boxLokasi = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        dataTable = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jIcon = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Aplikasi Cek Cuaca!!!", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Poppins", 3, 14))); // NOI18N
        jPanel1.setForeground(new java.awt.Color(204, 255, 204));
        java.awt.GridBagLayout jPanel1Layout = new java.awt.GridBagLayout();
        jPanel1Layout.columnWidths = new int[] {0, 15, 0, 15, 0, 15, 0, 15, 0, 15, 0, 15, 0, 15, 0, 15, 0};
        jPanel1Layout.rowHeights = new int[] {0, 7, 0, 7, 0, 7, 0, 7, 0, 7, 0, 7, 0, 7, 0, 7, 0, 7, 0};
        jPanel1.setLayout(jPanel1Layout);

        jLabel1.setText("Masukan Kota");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel1.add(jLabel1, gridBagConstraints);

        jLabel2.setText("Pilih Kota");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 71);
        jPanel1.add(jLabel2, gridBagConstraints);

        cuacaLabel.setText("Hasil Cuaca");
        cuacaLabel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LAST_LINE_START;
        jPanel1.add(cuacaLabel, gridBagConstraints);

        btnCek.setText("Cek Cuaca");
        btnCek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCekActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel1.add(btnCek, gridBagConstraints);

        btnSimpan.setText("Simpan");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.ipadx = 13;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 43);
        jPanel1.add(btnSimpan, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 60;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel1.add(fieldKota, gridBagConstraints);

        boxLokasi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih Lokasi" }));
        boxLokasi.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                boxLokasiItemStateChanged(evt);
            }
        });
        boxLokasi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxLokasiActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 32;
        jPanel1.add(boxLokasi, gridBagConstraints);

        dataTable.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        dataTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Kota", "Cuaca", "Suhu"
            }
        ));
        dataTable.setEnabled(false);
        dataTable.setFocusable(false);
        dataTable.setShowGrid(false);
        dataTable.getTableHeader().setResizingAllowed(false);
        dataTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(dataTable);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 10;
        jPanel1.add(jScrollPane1, gridBagConstraints);

        jPanel2.setLayout(new java.awt.GridBagLayout());

        jIcon.setBackground(new java.awt.Color(204, 204, 204));
        jIcon.setForeground(new java.awt.Color(153, 153, 153));
        jIcon.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanel2.add(jIcon, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.ipadx = 150;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        jPanel1.add(jPanel2, gridBagConstraints);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 735, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 847, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void boxLokasiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxLokasiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boxLokasiActionPerformed

    /**
     * Event handler untuk item state changed pada combo box lokasi
     */
    private void boxLokasiItemStateChanged(java.awt.event.ItemEvent evt) {
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            String selectedCity = (String) boxLokasi.getSelectedItem();
            if (selectedCity != null && !selectedCity.equals("Pilih Lokasi")) {
                fieldKota.setText(selectedCity);
                // Otomatis mengecek cuaca untuk kota yang dipilih
                checkWeatherForCity(selectedCity);
            }
        }
    }

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        String kota = fieldKota.getText();
        String apiKey = "0c658518f42f53ff4747b5e29b3c6bb8"; // Ganti dengan API key Anda
        String url = "http://api.openweathermap.org/data/2.5/weather?q=" + kota + "&appid=" + apiKey + "&units=metric";

        try {
            // Mengambil data dari API
            String response = getWeatherData(url);
            JSONObject jsonResponse = new JSONObject(response);

            // Parsing data dari JSON
            String kondisiCuaca = jsonResponse.getJSONArray("weather").getJSONObject(0).getString("description");
            double suhu = jsonResponse.getJSONObject("main").getDouble("temp");

            // Menampilkan hasil
            cuacaLabel.setText("Cuaca: " + kondisiCuaca + ", Suhu: " + suhu + "°C");

            // Tambahkan kota ke daftar favorit jika belum ada
            boolean kotaSudahAda = false;
            for (int i = 0; i < boxLokasi.getItemCount(); i++) {
                if (boxLokasi.getItemAt(i).equalsIgnoreCase(kota)) {
                    kotaSudahAda = true;
                    break;
                }
            }
            if (!kotaSudahAda) {
                boxLokasi.addItem(kota); // Tambahkan kota ke JComboBox
            }

            // Menyimpan data ke file CSV
            try (FileWriter writer = new FileWriter("weatherData.csv", true)) {
                writer.append(kota).append(",").append(kondisiCuaca).append(",").append(String.valueOf(suhu)).append("\n");
                JOptionPane.showMessageDialog(this, "Data berhasil disimpan ke weatherData.csv.");
            } catch (IOException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Gagal menyimpan data ke file CSV.");
            }

        } catch (Exception e) {
            cuacaLabel.setText("Kota tidak ditemukan atau error API.");
        }
    }//GEN-LAST:event_btnSimpanActionPerformed

    /**
     * Event handler untuk tombol "Cek Cuaca"
     */
    private void btnCekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCekActionPerformed
        String kota = fieldKota.getText().trim();
        if (kota.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Silakan masukkan nama kota");
            return;
        }

        // Menambahkan jumlah pengecekan untuk kota tersebut
        cityCheckCount.put(kota, cityCheckCount.getOrDefault(kota, 0) + 1);
        if (cityCheckCount.get(kota) >= 3) { // Setelah 3 kali dicek
            addToFavorites(kota);
        }

        String apiKey = "0c658518f42f53ff4747b5e29b3c6bb8"; // Ganti dengan API key Anda
        String url = "http://api.openweathermap.org/data/2.5/weather?q=" + kota + "&appid=" + apiKey + "&units=metric&lang=id";

        try {
            // Mengambil data dari API
            String response = getWeatherData(url);
            JSONObject jsonResponse = new JSONObject(response);

            // Parsing data dari JSON
            String kondisiCuaca = jsonResponse.getJSONArray("weather").getJSONObject(0).getString("description");
            kondisiCuaca = translateWeatherDescription(kondisiCuaca); // Terjemahkan jika perlu
            double suhu = jsonResponse.getJSONObject("main").getDouble("temp");

            // Menampilkan hasil dalam Bahasa Indonesia
            cuacaLabel.setText("Cuaca: " + kondisiCuaca + ", Suhu: " + suhu + "°C");

            // Mengatur ikon cuaca
            setWeatherIcon(kondisiCuaca);

            // Memperbarui data tabel
            updateTableData(kota, kondisiCuaca, suhu);

        } catch (Exception e) {
            cuacaLabel.setText("Kota tidak ditemukan atau error API.");
        }
    }//GEN-LAST:event_btnCekActionPerformed

    // Method to get weather data from API
    private String getWeatherData(String apiUrl) throws Exception {
        URL url = new URL(apiUrl);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        StringBuilder response = new StringBuilder();
        String line;

        while ((line = reader.readLine()) != null) {
            response.append(line);
        }
        reader.close();

        return response.toString();
    }

    /**
     * Method untuk menerjemahkan deskripsi cuaca ke dalam Bahasa Indonesia
     * @param description Deskripsi cuaca dalam Bahasa Inggris
     * @return Deskripsi cuaca dalam Bahasa Indonesia
     */
    private String translateWeatherDescription(String description) {
        Map<String, String> translations = new HashMap<>();
        // Kondisi dasar
        translations.put("clear sky", "Cerah");
        translations.put("few clouds", "Berawan Ringan");
        translations.put("scattered clouds", "Berawan Sebagian");
        translations.put("broken clouds", "Berawan");
        translations.put("overcast clouds", "Berawan Tebal");
        // Kondisi hujan
        translations.put("light rain", "Hujan Ringan");
        translations.put("moderate rain", "Hujan Sedang");
        translations.put("heavy intensity rain", "Hujan Lebat");
        translations.put("very heavy rain", "Hujan Sangat Lebat");
        translations.put("extreme rain", "Hujan Ekstrem");
        translations.put("freezing rain", "Hujan Membeku");
        translations.put("light intensity shower rain", "Hujan Lokal Ringan");
        translations.put("shower rain", "Hujan Lokal");
        translations.put("heavy intensity shower rain", "Hujan Lokal Lebat");
        translations.put("ragged shower rain", "Hujan Lokal Tidak Merata");
        // Kondisi gerimis
        translations.put("light intensity drizzle", "Gerimis Ringan");
        translations.put("drizzle", "Gerimis");
        translations.put("heavy intensity drizzle", "Gerimis Lebat");
        translations.put("light intensity drizzle rain", "Hujan Gerimis Ringan");
        translations.put("drizzle rain", "Hujan Gerimis");
        translations.put("heavy intensity drizzle rain", "Hujan Gerimis Lebat");
        // Kondisi badai
        translations.put("thunderstorm with light rain", "Badai Petir dengan Hujan Ringan");
        translations.put("thunderstorm with rain", "Badai Petir dengan Hujan");
        translations.put("thunderstorm with heavy rain", "Badai Petir dengan Hujan Lebat");
        translations.put("light thunderstorm", "Badai Petir Ringan");
        translations.put("thunderstorm", "Badai Petir");
        translations.put("heavy thunderstorm", "Badai Petir Kuat");
        translations.put("ragged thunderstorm", "Badai Petir Tidak Merata");
        // Kondisi salju
        translations.put("light snow", "Salju Ringan");
        translations.put("snow", "Salju");
        translations.put("heavy snow", "Salju Lebat");
        translations.put("sleet", "Hujan Bercampur Salju");
        translations.put("light shower sleet", "Hujan Salju Ringan");
        translations.put("shower sleet", "Hujan Salju");
        // Kondisi atmosfer
        translations.put("mist", "Kabut Tipis");
        translations.put("smoke", "Berasap");
        translations.put("haze", "Berkabut");
        translations.put("sand/dust whirls", "Pusaran Debu");
        translations.put("fog", "Kabut Tebal");
        translations.put("sand", "Berpasir");
        translations.put("dust", "Berdebu");
        translations.put("volcanic ash", "Abu Vulkanik");
        translations.put("squalls", "Badai Angin");
        translations.put("tornado", "Tornado");

        return translations.getOrDefault(description.toLowerCase(), description);
    }

    /**
     * Method untuk mengatur ikon cuaca berdasarkan kondisi cuaca
     * @param condition Kondisi cuaca dalam Bahasa Indonesia
     */
    private void setWeatherIcon(String condition) {
        String iconPath = "src/icons/";
        condition = condition.toLowerCase();

        // Pemetaan ikon berdasarkan kondisi cuaca
        if (condition.contains("clear") || condition.contains("cerah")) {
            iconPath += "sunny.png";
        } else if (condition.contains("thunderstorm") || condition.contains("badai")) {
            iconPath += "strom.png";
        } else if (condition.contains("shower") || condition.contains("hujan lokal")) {
            iconPath += "partly-rain.png";
        } else if (condition.contains("light rain") || condition.contains("hujan ringan") ||
                   condition.contains("drizzle") || condition.contains("gerimis")) {
            iconPath += "light-rain.png";
        } else if (condition.contains("rain") || condition.contains("hujan")) {
            iconPath += "rain.png";
        } else if (condition.contains("snow") || condition.contains("salju")) {
            iconPath += "snow.png";
        } else if (condition.contains("fog") || condition.contains("mist") ||
                   condition.contains("haze") || condition.contains("kabut")) {
            iconPath += "fog.png";
        } else if (condition.contains("clouds") || condition.contains("berawan")) {
            iconPath += "cloudy.png";
        } else {
            iconPath += "sunny.png"; // Ikon default
        }

        try {
            ImageIcon originalIcon = new ImageIcon(iconPath);
            Image scaledImage = originalIcon.getImage().getScaledInstance(
                ICON_SIZE,
                ICON_SIZE,
                Image.SCALE_SMOOTH
            );
            jIcon.setIcon(new ImageIcon(scaledImage));
        } catch (Exception e) {
            System.out.println("Error loading icon: " + e.getMessage());
            // Menggunakan ikon default jika ikon spesifik tidak ditemukan
            try {
                ImageIcon defaultIcon = new ImageIcon("src/icons/sunny.png");
                Image scaledImage = defaultIcon.getImage().getScaledInstance(
                    ICON_SIZE,
                    ICON_SIZE,
                    Image.SCALE_SMOOTH
                );
                jIcon.setIcon(new ImageIcon(scaledImage));
            } catch (Exception ex) {
                System.out.println("Error loading default icon: " + ex.getMessage());
            }
        }
    }

    /**
     * Method untuk menambahkan kota ke daftar favorit jika belum ada
     * @param city Nama kota
     */
    private void addToFavorites(String city) {
        boolean exists = false;
        for (int i = 0; i < boxLokasi.getItemCount(); i++) {
            if (boxLokasi.getItemAt(i).equals(city)) {
                exists = true;
                break;
            }
        }

        if (!exists) {
            boxLokasi.addItem(city);
        }
    }

    /**
     * Method untuk mengecek cuaca pada kota tertentu
     * @param city Nama kota
     */
    private void checkWeatherForCity(String city) {
        // Mensimulasikan klik tombol untuk kota yang dipilih
        fieldKota.setText(city);
        btnCek.doClick();
    }

    /**
     * Method untuk memperbarui data tabel dengan data cuaca terbaru
     * @param city Nama kota
     * @param weather Deskripsi cuaca
     * @param temperature Suhu dalam derajat Celsius
     */
    private void updateTableData(String city, String weather, double temperature) {
        if (tableModel == null) {
            tableModel = (DefaultTableModel) dataTable.getModel();
        }

        // Menambahkan baris baru dengan data cuaca
        tableModel.addRow(new Object[]{city, weather, String.format("%.1f°C", temperature)});

        // Menjaga agar hanya 10 entri terakhir yang ditampilkan
        while (tableModel.getRowCount() > 10) {
            tableModel.removeRow(0);
        }
    }

    /**
     * Method untuk memuat data cuaca yang tersimpan dari file CSV
     */
    private void loadWeatherData() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("weatherData.csv"));
            String line;
            tableModel = (DefaultTableModel) dataTable.getModel();
            tableModel.setRowCount(0); // Menghapus data yang ada

            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 3) {
                    tableModel.addRow(data);
                }
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Data cuaca tersimpan tidak ditemukan.");
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AplikasiCekCuacaSederhana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AplikasiCekCuacaSederhana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AplikasiCekCuacaSederhana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AplikasiCekCuacaSederhana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AplikasiCekCuacaSederhana().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> boxLokasi;
    private javax.swing.JButton btnCek;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JLabel cuacaLabel;
    private javax.swing.JTable dataTable;
    private javax.swing.JTextField fieldKota;
    private javax.swing.JLabel jIcon;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
