/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.ConnectionDatabase;
import Model.Pegawai;
import Model.TableModel;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.io.File;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author User
 */
public class EmployeeForm extends javax.swing.JFrame {

    /**
     * Creates new form EmployeeForm
     */
    Pegawai pgw = new Pegawai();
    private String nip;
    private String nama;
    private Date tanggal;
    private String pekerjaan;
    private String status;
    private String agama;
    private String idbagian;
    private String alamat;
    private String jabatan;

    TableModel tbl = new TableModel();
    private String rs[][];
    String[] namaKolom = {"Nip", "Nama", "Tanggal", "Pekerjaan", "Status", "Agama", "Id Bagian", "Jabatan", "Alamat"};
    int jmlKolom = namaKolom.length;
    int[] lebar = {200, 500, 300, 300, 300, 400, 300, 300, 500};

    public EmployeeForm() {
        initComponents();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (dim.width - getWidth()) / 2;
        int y = (dim.height - getHeight()) / 2;
        setLocation(x, y);
        ShowBagian();
        Refresh();
    }

    private void Refresh() {
        //txtNik.requestFocus();
        txtNik.setText("");
        txtNama.setText("");
        txtNama.requestFocus();
        jDateChooser1.setDate(null);
        cbStPekerjaan.setSelectedIndex(0);
        cbStPerkawinan.setSelectedIndex(0);
        cbAgama.setSelectedIndex(0);
        cbBagian.setSelectedIndex(0);
        cbJabatan.setSelectedIndex(0);
        txtAlamat.setText("");
        jTextField1.setText("");
        btnSave.setEnabled(true);
        btnUpdate.setEnabled(false);
        NIP();
    }

    private void ShowBagian() {
        java.sql.Connection conn = new ConnectionDatabase().connect();
        try {
            java.sql.Statement stmt = conn.createStatement();
            java.sql.ResultSet res = stmt.executeQuery("select *from tb_bagian");
            while (res.next()) {
                cbBagian.addItem(res.getString("nama"));

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Data Bagian Tidak Bisa di Tampilkan");
        }
    }

    private void ShowNamaBagian() {
        java.sql.Connection conn = new ConnectionDatabase().connect();
        try {
            java.sql.Statement stmt = conn.createStatement();
            java.sql.ResultSet res = stmt.executeQuery("select *from tb_bagian where idbagian = '" + pgw.getIdbagian() + "'");
            while (res.next()) {
                cbBagian.setSelectedItem(res.getString("nama"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Data Bagian Tidak Bisa di Tampilkan");
        }
    }

    private void NIP() {
        java.sql.Connection conn = new ConnectionDatabase().connect();
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select *from tb_pegawai ORDER BY nip DESC");
            if (rs.first() == false) {
                txtNik.setText("PGW0001");
            } else {
                rs.first();
                System.out.println("COT: " + rs.getString("nip").substring(3, 7));
                int nokirim = Integer.valueOf(rs.getString("nip").substring(3, 7)) + 1;
                System.out.println(nokirim);
                if (nokirim < 10) {
                    txtNik.setText("PGW000" + nokirim);
                } else if (nokirim >= 10 && nokirim < 100) {
                    txtNik.setText("PGW00" + nokirim);
                } else if (nokirim >= 100 && nokirim < 1000) {
                    txtNik.setText("PGW0" + nokirim);
                } else if (nokirim >= 1000 && nokirim < 9999) {
                    txtNik.setText("PGW" + nokirim);
                }
            }
            rs.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Data tidak ditemukan");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtNik = new javax.swing.JTextField();
        txtNama = new javax.swing.JTextField();
        cbStPekerjaan = new javax.swing.JComboBox();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        cbStPerkawinan = new javax.swing.JComboBox();
        cbAgama = new javax.swing.JComboBox();
        cbBagian = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAlamat = new javax.swing.JTextArea();
        btnSave = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();
        btnCetak = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        cbJabatan = new javax.swing.JComboBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 255, 204));
        jLabel1.setText("EMPLOYEE OF BLK FORM ONLY");

        jPanel2.setBackground(new java.awt.Color(153, 255, 204));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("NIK");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("NAMA");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("TGL. LAHIR");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("STATUS PEKERJAAN");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("STATUS PERKAWINAN");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("AGAMA");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("NAMA BAGIAN");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("ALAMAT");

        txtNik.setEditable(false);
        txtNik.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtNik.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNikKeyTyped(evt);
            }
        });

        txtNama.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtNama.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNamaKeyTyped(evt);
            }
        });

        cbStPekerjaan.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cbStPekerjaan.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "PILIH", "PNS", "NON PNS" }));

        jDateChooser1.setDateFormatString("yyyy-MM-dd");

        cbStPerkawinan.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cbStPerkawinan.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "PILIH", "KAWIN", "BELUM KAWIN" }));

        cbAgama.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cbAgama.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "PILIH", "ISLAM", "KRISTEN PROTESTAN", "KRISTEN KATOLIK", "BUDDHA", "HINDU", "LAIN-LAIN", " " }));

        cbBagian.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cbBagian.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "PILIH" }));
        cbBagian.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbBagianItemStateChanged(evt);
            }
        });

        txtAlamat.setColumns(20);
        txtAlamat.setRows(5);
        txtAlamat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAlamatKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(txtAlamat);

        btnSave.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnSave.setText("SAVE");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnUpdate.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnUpdate.setText("UPDATE");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnRefresh.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnRefresh.setText("REFRESH");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        btnCetak.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnCetak.setText("CETAK");
        btnCetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCetakActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("JABATAN");

        cbJabatan.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cbJabatan.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "PILIH", "Ka. UPT BLKPP", "Instruktur Ahli Madya", "Instruktur Penyelia", "Kepala Tata Usaha BLK", "Kasi. Pelatihan Kerja", "Kasi. Pengembangan Produktifitas", "INSTRUKTUR", "Penyusun Bahan Materi Bimbingan", "Instruktur Ahli Muda", "Instruktur Ahli Pertama", "Penyusun Bahan Kerjasama Pelatihan", "Penyusun Bahan Materi Bimbingan", "Instruktur Ahli Pertama", "Instruktur Terampil", "Staff" }));
        cbJabatan.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbJabatanItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel9)
                    .addComponent(jLabel4)
                    .addComponent(jLabel8)
                    .addComponent(jLabel2)
                    .addComponent(jLabel11))
                .addGap(95, 95, 95)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbJabatan, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCetak, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtNik)
                    .addComponent(cbStPekerjaan, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(btnSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnUpdate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnRefresh))
                    .addComponent(txtNama, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbStPerkawinan, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbAgama, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbBagian, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNik, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(cbStPekerjaan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cbStPerkawinan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cbAgama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cbBagian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(cbJabatan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave)
                    .addComponent(btnUpdate)
                    .addComponent(btnRefresh))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCetak)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTable1.setBackground(new java.awt.Color(102, 255, 204));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jTable1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTable1KeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);

        jTextField1.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1KeyTyped(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(102, 255, 204));
        jLabel10.setText("PENCARIAN");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 801, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        // TODO add your handling code here:
        Refresh();
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        nip = txtNik.getText().trim();
        nama = txtNama.getText().toUpperCase().trim();
        pekerjaan = cbStPekerjaan.getSelectedItem().toString();
        status = cbStPerkawinan.getSelectedItem().toString();
        agama = cbAgama.getSelectedItem().toString();
        idbagian = pgw.getIdbagian();
        alamat = txtAlamat.getText();
        jabatan = cbJabatan.getSelectedItem().toString();

        if (nip.equals("")) {
            JOptionPane.showMessageDialog(null, "Nip Kosong !!, Silahkan di Isi Dahulu");
            txtNik.requestFocus();
        } else if (nama.equals("")) {
            JOptionPane.showMessageDialog(null, "Nama Kosong !!, Silahkan di Isi Dahulu");
            txtNama.requestFocus();
        } else if (jDateChooser1.getDate() == null) {
            JOptionPane.showMessageDialog(null, "Tanggal Kosong !!, Silahkan di Isi Dahulu");
            jDateChooser1.requestFocus();
        } else if (cbStPekerjaan.getSelectedItem().equals("")) {
            JOptionPane.showMessageDialog(null, "Pekerjaan Kosong !!, Silahkan di Isi Dahulu");
            cbStPekerjaan.requestFocus();
        } else if (cbStPekerjaan.getSelectedItem().equals("")) {
            JOptionPane.showMessageDialog(null, "11Pekerjaan Belum di Pilih !!, Silahkan di Pilih Dahulu");
            cbStPekerjaan.requestFocus();
        } else if (cbStPerkawinan.getSelectedItem().equals("PILIH")) {
            JOptionPane.showMessageDialog(null, "Status Belum di Pilih !!, Silahkan di Pilih Dahulu");
            cbStPerkawinan.requestFocus();
        } else if (cbAgama.getSelectedItem().equals("PILIH")) {
            JOptionPane.showMessageDialog(null, "Agama Belum di Pilih !!, Silahkan di Pilih Dahulu");
            cbStPekerjaan.requestFocus();
        } else if (cbBagian.getSelectedItem().equals("PILIH")) {
            JOptionPane.showMessageDialog(null, "Bagian Belum di Pilih !!, Silahkan di Pilih Dahulu");
            cbBagian.requestFocus();
        } else if (alamat.equals("")) {
            JOptionPane.showMessageDialog(null, "Alamat Kosong !!, Silahkan di Isi Dahulu");
            txtAlamat.requestFocus();
        } else if (cbJabatan.getSelectedItem().equals("PILIH")) {
            JOptionPane.showMessageDialog(null, "Jabatan Belum di Pilih !!, Silahkan di Pilih Dahulu");
            cbJabatan.requestFocus();
        } else {
            SimpleDateFormat spf = new SimpleDateFormat("yyyy-MM-dd");
            Date tgl = Date.valueOf(spf.format(jDateChooser1.getDate()));
            pgw.Save(nip, nama, tgl, pekerjaan, status, agama, idbagian, jabatan, alamat);
            Refresh();
        }

    }//GEN-LAST:event_btnSaveActionPerformed

    private void cbBagianItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbBagianItemStateChanged
        // TODO add your handling code here:
        java.sql.Connection conn = new ConnectionDatabase().connect();
        try {
            java.sql.Statement stmt = conn.createStatement();
            java.sql.ResultSet res = stmt.executeQuery("select *from tb_bagian where nama = '" + cbBagian.getSelectedItem() + "'");
            while (res.next()) {
                pgw.setIdbagian(res.getString("idbagian"));

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Data Bagian Tidak Bisa di Tampilkan");
        }
    }//GEN-LAST:event_cbBagianItemStateChanged

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
        rs = pgw.ShowData();
        tbl.SetTabel(jTable1, rs, namaKolom, jmlKolom, lebar);
    }//GEN-LAST:event_formWindowActivated

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        int baris = jTable1.getSelectedRow();
        btnSave.setEnabled(false);
        txtNik.setText(jTable1.getValueAt(baris, 0).toString());
        txtNama.setText(jTable1.getValueAt(baris, 1).toString());
        jDateChooser1.setDate(Date.valueOf(jTable1.getValueAt(baris, 2).toString()));
        cbStPekerjaan.setSelectedItem(jTable1.getValueAt(baris, 3).toString());
        cbStPerkawinan.setSelectedItem(jTable1.getValueAt(baris, 4).toString());
        cbAgama.setSelectedItem(jTable1.getValueAt(baris, 5).toString());
        pgw.setIdbagian(jTable1.getValueAt(baris, 6).toString());
        ShowNamaBagian();
        cbJabatan.setSelectedItem(jTable1.getValueAt(baris, 7).toString());
        txtAlamat.setText(jTable1.getValueAt(baris, 8).toString());
        btnUpdate.setEnabled(true);
    }//GEN-LAST:event_jTable1MouseClicked

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        nip = txtNik.getText().trim();
        nama = txtNama.getText().trim();
        pekerjaan = cbStPekerjaan.getSelectedItem().toString();
        status = cbStPerkawinan.getSelectedItem().toString();
        agama = cbAgama.getSelectedItem().toString();
        idbagian = pgw.getIdbagian();
        alamat = txtAlamat.getText();
        jabatan = cbJabatan.getSelectedItem().toString();

        if (nip.equals("")) {
            JOptionPane.showMessageDialog(null, "Nip Kosong !!, Silahkan di Isi Dahulu");
            txtNik.requestFocus();
        } else if (nama.equals("")) {
            JOptionPane.showMessageDialog(null, "Nama Kosong !!, Silahkan di Isi Dahulu");
            txtNama.requestFocus();
        } else if (jDateChooser1.getDate() == null) {
            JOptionPane.showMessageDialog(null, "Tanggal Kosong !!, Silahkan di Isi Dahulu");
            jDateChooser1.requestFocus();
        } else if (cbStPekerjaan.getSelectedItem().equals("")) {
            JOptionPane.showMessageDialog(null, "Pekerjaan Kosong !!, Silahkan di Isi Dahulu");
            cbStPekerjaan.requestFocus();
        } else if (cbStPekerjaan.getSelectedItem().equals("")) {
            JOptionPane.showMessageDialog(null, "11Pekerjaan Belum di Pilih !!, Silahkan di Pilih Dahulu");
            cbStPekerjaan.requestFocus();
        } else if (cbStPerkawinan.getSelectedItem().equals("PILIH")) {
            JOptionPane.showMessageDialog(null, "Status Belum di Pilih !!, Silahkan di Pilih Dahulu");
            cbStPerkawinan.requestFocus();
        } else if (cbAgama.getSelectedItem().equals("PILIH")) {
            JOptionPane.showMessageDialog(null, "Agama Belum di Pilih !!, Silahkan di Pilih Dahulu");
            cbStPekerjaan.requestFocus();
        } else if (cbBagian.getSelectedItem().equals("PILIH")) {
            JOptionPane.showMessageDialog(null, "Bagian Belum di Pilih !!, Silahkan di Pilih Dahulu");
            cbBagian.requestFocus();
        } else if (alamat.equals("")) {
            JOptionPane.showMessageDialog(null, "Alamat Kosong !!, Silahkan di Isi Dahulu");
            txtAlamat.requestFocus();
        } else if (cbJabatan.getSelectedItem().equals("PILIH")) {
            JOptionPane.showMessageDialog(null, "Jabatan Belum di Pilih !!, Silahkan di Pilih Dahulu");
            cbJabatan.requestFocus();
        } else {
            SimpleDateFormat spf = new SimpleDateFormat("yyyy-MM-dd");
            Date tgl = Date.valueOf(spf.format(jDateChooser1.getDate()));
            pgw.Update(nip, nama, tgl, pekerjaan, status, agama, idbagian, jabatan, alamat);
            Refresh();
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void jTable1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyPressed
        // TODO add your handling code here:
        nip = txtNik.getText().trim();
        if (evt.getKeyChar() == KeyEvent.VK_DELETE) {
            int ok = JOptionPane.showConfirmDialog(null, "Apakah Anda Yakin Ingin Menghapus ?", "Konnfirmasi", JOptionPane.YES_NO_OPTION);
            if (ok == 0) {
                pgw.Delete(nip);
                Refresh();
            } else {

            }
        }
    }//GEN-LAST:event_jTable1KeyPressed

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
        // TODO add your handling code here:
        String search = jTextField1.getText().trim();
        rs = pgw.SearchData(search);
        tbl.SetTabel(jTable1, rs, namaKolom, jmlKolom, lebar);
    }//GEN-LAST:event_jTextField1KeyReleased

    private void txtNamaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNamaKeyTyped
        // TODO add your handling code here:
        char karakter = evt.getKeyChar();

        if ((((karakter >= '0') && (karakter <= '9') || (karakter == KeyEvent.VK_BACK_SPACE) || (karakter == KeyEvent.VK_DELETE) || (karakter == KeyEvent.VK_ENTER)))) {
            getToolkit().beep();
            evt.consume();
        }

        if (txtNama.getText().length() == 0 && karakter == KeyEvent.VK_SPACE) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtNamaKeyTyped

    private void txtNikKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNikKeyTyped
        // TODO add your handling code here:
        char karakter = evt.getKeyChar();

        if (txtNik.getText().length() == 0 && karakter == KeyEvent.VK_SPACE) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtNikKeyTyped

    private void txtAlamatKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAlamatKeyTyped
        // TODO add your handling code here:
        char karakter = evt.getKeyChar();

        if (txtAlamat.getText().length() == 0 && karakter == KeyEvent.VK_SPACE) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtAlamatKeyTyped

    private void jTextField1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyTyped
        // TODO add your handling code here:
        char karakter = evt.getKeyChar();

        if (jTextField1.getText().length() == 0 && karakter == KeyEvent.VK_SPACE) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_jTextField1KeyTyped

    private void btnCetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCetakActionPerformed
        // TODO add your handling code here:
        java.sql.Connection conn = new ConnectionDatabase().connect();
        try {
            HashMap parameter = new HashMap();
            File file = new File("src/Report/LaporanDataPegawai.jasper");
            JasperReport jp = (JasperReport) JRLoader.loadObject(file);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jp, parameter, conn);
            JasperViewer.viewReport(jasperPrint, false);
            JasperViewer.setDefaultLookAndFeelDecorated(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_btnCetakActionPerformed

    private void cbJabatanItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbJabatanItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cbJabatanItemStateChanged

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
            java.util.logging.Logger.getLogger(EmployeeForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EmployeeForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EmployeeForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EmployeeForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EmployeeForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCetak;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox cbAgama;
    private javax.swing.JComboBox cbBagian;
    private javax.swing.JComboBox cbJabatan;
    private javax.swing.JComboBox cbStPekerjaan;
    private javax.swing.JComboBox cbStPerkawinan;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextArea txtAlamat;
    private javax.swing.JTextField txtNama;
    private javax.swing.JTextField txtNik;
    // End of variables declaration//GEN-END:variables
}
