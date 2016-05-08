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
import java.awt.Toolkit;
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
    
    //private DefaultTableModel tablePersonil;
    
    ControlMaster controlMaster = new ControlMaster();
    ControlPencarian controlPencarian = new ControlPencarian();
    List<String> Personil;

   
    
    public UI_Utama_v2() {
        initComponents();
        Toolkit tk = Toolkit.getDefaultToolkit();
        int xsize = (int) tk.getScreenSize().getWidth();
        int ysize = (int) tk.getScreenSize().getHeight();
        this.setSize(xsize, ysize);
        getAllData();
    }
    
    public void getAllData(){
        tablePersonil.setModel(DbUtils.resultSetToTableModel(controlMaster.getPersonilData()));
    }
 
    private void cariPersonilByKeyword(String filter, String keyword) {
        tablePersonil.setModel(DbUtils.resultSetToTableModel(controlPencarian.ambilDataPersonil(filter, keyword)));
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
        label_datapersonil = new javax.swing.JLabel();
        comboFilter = new javax.swing.JComboBox<>();
        textSearch = new javax.swing.JTextField();
        btnTambahPersonil = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablePersonil = new javax.swing.JTable();
        btnCari = new javax.swing.JButton();
        buttonRefresh = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("UI_Utama");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
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

        tablePersonil.setAutoCreateRowSorter(true);
        tablePersonil.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tablePersonil.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
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

        buttonRefresh.setText("Refresh");
        buttonRefresh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonRefreshMouseClicked(evt);
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                        .addComponent(buttonRefresh)
                        .addGap(18, 18, 18)
                        .addComponent(comboFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCari)
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
                            .addComponent(btnCari)
                            .addComponent(buttonRefresh))))
                .addGap(33, 33, 33)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(216, Short.MAX_VALUE))
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
        this.dispose();
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
    
    private List<String> ambilPersonil(String nrp){
        //System.out.println("NRP yang di parsing: "+nrp);
        return new ControlPencarian().ambilDataPersonilbyID(nrp);
    }
    private void tablePersonilMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablePersonilMouseClicked
        // TODO add your handling code here:
         try{
            if(evt.getClickCount()==1){
                int row = tablePersonil.getSelectedRow();
                String table_click = (tablePersonil.getModel().getValueAt(row, 0).toString());
                
                Personil = this.ambilPersonil(table_click);
               
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
              
                
                UI_Edit_Personil jtRowData = new UI_Edit_Personil(table_click);
                jtRowData.cekPasangan(Personil.get(3));
                jtRowData.cekAnak(Personil.get(3));
                jtRowData.setVisible(true);
                jtRowData.pack();
                
                jtRowData.jTextField_Nama.setText(Personil.get(0));
                jtRowData.jTextField_Pangkat.setText(Personil.get(1));
                jtRowData.jTextField_Korps.setText(Personil.get(2));
                jtRowData.jTextField_NRP.setText(Personil.get(3));
                jtRowData.jTextField_Jabatan.setText(Personil.get(4));
                jtRowData.jabatan.setDate(tmtjabatan);
                jtRowData.tmttni.setDate(tmttni);
                jtRowData.pangkatpertama.setDate(tmtpertama);
                jtRowData.pangkatterakhir.setDate(tmtterakhir);
                jtRowData.jTextField_TempatLahir.setText(Personil.get(9));
                jtRowData.jDateChooser_tanggalLahir.setDate(tanggalLahir);
                jtRowData.jTextField_PendidikanUmum.setText(Personil.get(11));
                jtRowData.jTextField_PendidikanMiliter.setText(Personil.get(12));
                jtRowData.jTextField_PendidikanPengembang.setText(Personil.get(14));//ini pendidikan pengembangan
                jtRowData.jTextField_Agama.setText(Personil.get(13));
                jtRowData.jTextField_GolonganDarah.setText(Personil.get(15));
                jtRowData.jTextField_NoKTA.setText(Personil.get(16));
                jtRowData.jTextField_NoASABRI.setText(Personil.get(17));
                jtRowData.jTextField_NoBPJS.setText(Personil.get(18));
                jtRowData.jTextField_NoNPWP.setText(Personil.get(19));
                jtRowData.jTextField_Alamat.setText(Personil.get(20));
                jtRowData.jTextField_StatusRumah.setText(Personil.get(21));
                jtRowData.jTextField_NoTelpon.setText(Personil.get(22));
                jtRowData.jTextField_StatusKeluarga.setText(Personil.get(23));
                jtRowData.jTextField_Istri.setText(Personil.get(24));
            }  
        }catch(Exception e){
            
        }
    }//GEN-LAST:event_tablePersonilMouseClicked

    private void buttonRefreshMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonRefreshMouseClicked
        // TODO add your handling code here:
        getAllData();
      
    }//GEN-LAST:event_buttonRefreshMouseClicked

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
                if ("Windows".equals(info.getName())) {
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
    private javax.swing.JButton buttonRefresh;
    private javax.swing.JComboBox<String> comboFilter;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label_datapersonil;
    private javax.swing.JTable tablePersonil;
    private javax.swing.JTextField textSearch;
    // End of variables declaration//GEN-END:variables
}
