/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InpisView;

import InpisController.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.WindowConstants;
//import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Goronald
 */

public class UI_Utama_v2 extends javax.swing.JFrame {

    /**
     * Creates new form UI_Utama
     */
    
//    private DefaultTableModel tablePersonil;
    
    ControlMaster controlMaster = new ControlMaster();
    ControlPencarian controlPencarian = new ControlPencarian();
    UI_Edit_Personil jtRowData = new UI_Edit_Personil();
    
    public UI_Utama_v2() {
        initComponents();
        getAllData();
//        tabelModel = new DefaultTableModel();
//        tabelPersonil.setModel(tabelModel);
//        tabelModel.addColumn("NRP");
//        tabelModel.addColumn("Nama_Personil");
//        tabelModel.addColumn("Agama");
//        
//        loadTabelPersonil();
    }
    
    private void getAllData(){
        tablePersonil.setModel(DbUtils.resultSetToTableModel(controlMaster.getPersonilData()));
    }
 
    private void cariPersonilByKeyword(String filter, String keyword) {
        tablePersonil.setModel(DbUtils.resultSetToTableModel(controlPencarian.ambilDataPersonil(filter, keyword)));
    }
//    private void loadTabelPersonil() {
//        Connection connection = Database.getConnection();
//        String sql = "SELECT * from Personil";
//        try {
//            PreparedStatement statement = (PreparedStatement) connection.prepareStatement(sql);
//            ResultSet result = statement.executeQuery();
//            while(result.next()) {
//                Object[] o = new Object[3];
//                o[0] = result.getString("NRP");
//                o[1] = result.getString("Nama_Personil");
//                o[2] = result.getString("Agama_Personil");
//                
//                tabelModel.addRow(o);
//            }
//        }catch(SQLException e) {
//            System.out.println(e);
//        }
//                
//    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        label_datapersonil = new javax.swing.JLabel();
        comboFilter = new javax.swing.JComboBox<>();
        textSearch = new javax.swing.JTextField();
        btnTambahPersonil = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablePersonil = new javax.swing.JTable();
        btnCari = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("UI_Utama");
        setName("UI_Utama"); // NOI18N
        setSize(new java.awt.Dimension(1024, 768));

        label_datapersonil.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        label_datapersonil.setText("DATA PERSONIL");

        comboFilter.setEditable(true);
        comboFilter.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        comboFilter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NRP", "AGAMA_PERSONIL", "GOL_DARAH_PERSONIL", "JABATAN", "KORPS", "NAMA_PERSONIL", "NO_ASABRI", "NO_BPJS", "NO_KTA", "NO_NPWP", "NO_TELPON", "PANGKAT", "PENDIDIKAN_MILITER", "PENDIDIKAN_PENGEMBANG", "PENDIDIKAN_UMUM", "STATUS_KELUARGA", "STATUS_RUMAH", "TAMAT_JABATAN", "TAMAT_TNI", "TANGGAL_LAHIR_PERSONIL", "TEMPAT_LAHIR_PERSONIL", "TMT_PANGKAT_PERTAMA", "TMT_PANGKAT_TERAKHIR", "ALAMAT_PERSONIL" }));
        comboFilter.setToolTipText("pencarian berdasarkan :");
        comboFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboFilterActionPerformed(evt);
            }
        });

        textSearch.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        textSearch.setToolTipText("kata kunci pencarian");
        textSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textSearchActionPerformed(evt);
            }
        });
        textSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textSearchKeyReleased(evt);
            }
        });

        btnTambahPersonil.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnTambahPersonil.setText("TAMBAH PERSONIL");
        btnTambahPersonil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahPersonilActionPerformed(evt);
            }
        });

        tablePersonil.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, "Lihat", "Istri", "Anak", "Hapus"}
            },
            new String [] {
                "NRP", "Nama Personil", "Jabatan", "KORPS", "action #1", "action #2", "action #3", "action #4"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablePersonil.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tablePersonil.setCellSelectionEnabled(true);
        tablePersonil.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tablePersonil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablePersonilMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablePersonil);

        btnCari.setText("CARI");
        btnCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(label_datapersonil)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 185, Short.MAX_VALUE)
                        .addComponent(comboFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCari, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnTambahPersonil, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(19, 19, 19))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(label_datapersonil))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(comboFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnTambahPersonil)
                            .addComponent(btnCari))))
                .addGap(33, 33, 33)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(174, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnCari, btnTambahPersonil});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comboFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboFilterActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboFilterActionPerformed

    private void btnTambahPersonilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahPersonilActionPerformed
        UI_Insert_Personil ui_personil = new UI_Insert_Personil();
        ui_personil.setVisible(true);
    }//GEN-LAST:event_btnTambahPersonilActionPerformed

    private void textSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textSearchActionPerformed

    private void textSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textSearchKeyReleased

    }//GEN-LAST:event_textSearchKeyReleased

    private void btnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariActionPerformed
        String filter = comboFilter.getSelectedItem().toString();
        String keyword = textSearch.getText();
        cariPersonilByKeyword(filter, keyword);
    }//GEN-LAST:event_btnCariActionPerformed

    private void tablePersonilMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablePersonilMouseClicked
        // TODO add your handling code here:
         try{
            int row = tablePersonil.getSelectedRow();
            String table_click = (tablePersonil.getModel().getValueAt(row, 0).toString());
            List<String> Personil = controlPencarian.ambilDataPersonilbyID(table_click);
            
            //if(evt.getClickCount() == 2){
            //String tanggalLahir = Personil.get(10);
            //Date tanggalLahirPersonil = DATE(STR_TO_DATE(tanggalLahir, '%Y-%m-%d'));
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            String dateInString = Personil.get(10);
            String dateJabatan = Personil.get(5);
            String dateTNI = Personil.get(6);
            String datepertama = Personil.get(7);
            String dateterakhir = Personil.get(8);
            Date tanggalLahir = formatter.parse(dateInString);
            Date tmtjabatan = formatter.parse(dateJabatan);
            Date tmttni = formatter.parse(dateTNI);
            Date tmtpertama = formatter.parse(datepertama);
            Date tmtterakhir = formatter.parse(dateterakhir);
           //System.out.println("ini akhir:"+tanggalLahir);
            //System.out.println("ini atas:"+dateInString);
            
            
            this.jtRowData.setVisible(true);
            this.jtRowData.pack();
            //this.jtRowData.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            this.jtRowData.jTextField_Nama.setText(Personil.get(0));
            this.jtRowData.jTextField_Pangkat.setText(Personil.get(1));
            this.jtRowData.jTextField_Korps.setText(Personil.get(2));
            this.jtRowData.jTextField_NRP.setText(Personil.get(3));
            this.jtRowData.jTextField_Jabatan.setText(Personil.get(4));
            this.jtRowData.jabatan.setDate(tmtjabatan);
            this.jtRowData.tmttni.setDate(tmttni);
            this.jtRowData.pangkatpertama.setDate(tmtpertama);
            this.jtRowData.pangkatterakhir.setDate(tmtterakhir);
            this.jtRowData.jTextField_TempatLahir.setText(Personil.get(9));
            this.jtRowData.jDateChooser_tanggalLahir.setDate(tanggalLahir);
            this.jtRowData.jTextField_PendidikanUmum.setText(Personil.get(11));
            this.jtRowData.jTextField_PendidikanMiliter.setText(Personil.get(12));
            this.jtRowData.jTextField_PendidikanPengembang.setText(Personil.get(13));//ini pendidikan pengembangan
            this.jtRowData.jTextField_Agama.setText(Personil.get(14));
            this.jtRowData.jTextField_GolonganDarah.setText(Personil.get(15));
            this.jtRowData.jTextField_NoKTA.setText(Personil.get(16));
            this.jtRowData.jTextField_NoASABRI.setText(Personil.get(17));
            this.jtRowData.jTextField_NoBPJS.setText(Personil.get(18));
            this.jtRowData.jTextField_NoNPWP.setText(Personil.get(19));
            this.jtRowData.jTextField_Alamat.setText(Personil.get(20));
            this.jtRowData.jTextField_StatusRumah.setText(Personil.get(21));
            this.jtRowData.jTextField_NoTelpon.setText(Personil.get(22));
            this.jtRowData.jTextField_StatusKeluarga.setText(Personil.get(23));
            this.jtRowData.jTextField_Istri.setText(Personil.get(24));
            this.jtRowData.jTextField_Anak.setText(Personil.get(25));
            //}
            
            
            
        }catch(Exception e){
            
        }
    }//GEN-LAST:event_tablePersonilMouseClicked

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
            java.util.logging.Logger.getLogger(UI_Utama_v2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UI_Utama_v2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UI_Utama_v2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UI_Utama_v2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UI_Utama_v2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCari;
    private javax.swing.JButton btnTambahPersonil;
    private javax.swing.JComboBox<String> comboFilter;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label_datapersonil;
    private javax.swing.JTable tablePersonil;
    private javax.swing.JTextField textSearch;
    // End of variables declaration//GEN-END:variables
}
