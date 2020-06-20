/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BUS.tacgiaBUS;
import DTO.tacgiaDTO;
import interfaces.InTacGiaSelect;
import interfaces.QueryCallBack;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class PanelTacGia extends javax.swing.JPanel implements QueryCallBack{
    DefaultTableModel dtm;
    ArrayList<tacgiaDTO> arr= new ArrayList<tacgiaDTO>();
    tacgiaDTO current = new tacgiaDTO();
    InTacGiaSelect inTacGiaSelect;
    /**
     * Creates new form PanelTacGia
     */
    public PanelTacGia(InTacGiaSelect inTacGiaSelect) {
        initComponents();
        loadTacGia();
        initEvent();
        buttonChon.setVisible(false);
        this.inTacGiaSelect = inTacGiaSelect;
        
    }
    private void initEvent() {
        jTable1.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
        public void valueChanged(ListSelectionEvent event) {
            // do some actions here, for example
            // print first column value from selected row
            try {
                
            current.setMatg(arr.get(jTable1.getSelectedRow()).getMatg());
            current.setTentg(arr.get(jTable1.getSelectedRow()).getTentg());
            } catch (Exception e) {
            }
           if(!buttonChon.isVisible()){
               buttonChon.setVisible(true);
           }
        }
        });
    }
    
    public void loadTacGia(){
        String[] header = {"Mã Tác Giả","Tên Tác Giả"};
        
        dtm = new DefaultTableModel(header,0);
        arr = tacgiaBUS.getTacgia();
        tacgiaDTO s = new tacgiaDTO();
        for(int i = 0; i < arr.size(); i++){
            s = arr.get(i);
            String matg =  s.getMatg();
            String tentg = s.getTentg();
            Object[] row = {matg,tentg};
            dtm.addRow(row);
        }
        jTable1.setModel(dtm);
//        setView(arr.get(0));
       
         
       
       

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        buttonChon = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(855, 560));
        setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thực hiện", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 51, 0))); // NOI18N
        jPanel1.setLayout(null);

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton2.setText("Thêm");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(10, 60, 160, 80);

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton3.setText("Xóa");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3);
        jButton3.setBounds(10, 150, 160, 80);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton1.setText("Sửa");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(10, 240, 160, 80);

        buttonChon.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        buttonChon.setText("Chọn");
        buttonChon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonChonActionPerformed(evt);
            }
        });
        jPanel1.add(buttonChon);
        buttonChon.setBounds(10, 330, 160, 80);
        jPanel1.add(jLabel1);
        jLabel1.setBounds(20, 610, 130, 111);

        add(jPanel1);
        jPanel1.setBounds(0, 0, 180, 760);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh sách tác giả", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(204, 0, 102))); // NOI18N

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
        jTable1.setRowHeight(40);
        jTable1.setRowMargin(10);
        jTable1.setSelectionBackground(new java.awt.Color(255, 255, 255));
        jTable1.setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 798, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(129, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        add(jPanel2);
        jPanel2.setBounds(183, 0, 830, 590);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonChonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonChonActionPerformed
        // TODO add your handling code here:
        inTacGiaSelect.tacgia(current);
    }//GEN-LAST:event_buttonChonActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
          String name = JOptionPane.showInputDialog(this, "Nhập Tên Tác Giả");
          if(name.trim().length()>0){
              current.setTentg(name.trim());
             ArrayList<tacgiaDTO> arr = tacgiaBUS.getTacgia();
              current.setMatg((Integer.parseInt(arr.get(arr.size()-1).getMatg())+1)+"");
              tacgiaBUS.themTacgia(current, this);
          }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        if(current.getMatg().length()>0){
            tacgiaBUS.xoaTacgia(current.getMatg(), this);
            System.err.println("okme");
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
          String name = JOptionPane.showInputDialog(this, "Nhập Tên Tác Giả",current.getTentg());
          if(name!= null){
              current.setTentg(name.trim());
              tacgiaBUS.suaTacgia(current, this);
          }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonChon;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void onSuccess() {
        loadTacGia();
    }

    @Override
    public void onFailed(String error) {
        System.err.println(""+error);
    }
}
