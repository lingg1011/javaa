/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BUS.nxbBUS;
import BUS.tacgiaBUS;
import BUS.theloaiBus;
import DTO.nxbDTO;
import DTO.tacgiaDTO;
import DTO.theloaiDTO;
import interfaces.InNXBSelect;
import interfaces.InTacGiaSelect;
import interfaces.InTheLoaiSelect;
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
public class PanelNXB extends javax.swing.JPanel implements QueryCallBack{
    DefaultTableModel dtm;
    ArrayList<nxbDTO> arr= new ArrayList<nxbDTO>();
    nxbDTO current = new nxbDTO();
    InNXBSelect inNXBSelect;
    /**
     * Creates new form PanelTacGia
     */
    public PanelNXB(InNXBSelect inNXBSelect) {
        initComponents();
        loadNXB();
        initEvent();
        buttonChon.setVisible(false);
        this.inNXBSelect = inNXBSelect;
        
    }
    private void initEvent() {
        jTable1.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
        public void valueChanged(ListSelectionEvent event) {
            // do some actions here, for example
            // print first column value from selected row
            try {
                
            current.setManxb(arr.get(jTable1.getSelectedRow()).getManxb());
            current.setTennxb(arr.get(jTable1.getSelectedRow()).getTennxb());
            current.setDiachi(arr.get(jTable1.getSelectedRow()).getDiachi());
            current.setEmail(arr.get(jTable1.getSelectedRow()).getEmail());
            current.setSdt(arr.get(jTable1.getSelectedRow()).getSdt());
            } catch (Exception e) {
            }
           if(!buttonChon.isVisible()){
               buttonChon.setVisible(true);
           }
        }
        });
     
    }
    
    public void loadNXB(){
        String[] header = {"Mã NXB","Tên NXB","Địa Chỉ","Email","Sđt"};
        
        dtm = new DefaultTableModel(header,0);
        arr = nxbBUS.getNXB();
        nxbDTO s = new nxbDTO();
        for(int i = 0; i < arr.size(); i++){
            s = arr.get(i);
            String manxb =  s.getManxb();
            String tennxb = s.getTennxb();
            String diachi = s.getDiachi();
            String email = s.getEmail();
            String sdt = s.getSdt();
            Object[] row = {manxb,tennxb,diachi,email,sdt};
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
        setPreferredSize(new java.awt.Dimension(699, 506));
        setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thực hiện", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(204, 0, 51))); // NOI18N

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setText("Thêm");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton3.setText("Xóa");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setText("Sửa");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        buttonChon.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        buttonChon.setText("Chọn");
        buttonChon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonChonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonChon, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(58, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonChon, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(242, Short.MAX_VALUE))
        );

        add(jPanel1);
        jPanel1.setBounds(0, 11, 190, 580);
        add(jLabel1);
        jLabel1.setBounds(986, 374, 0, 0);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh sách nhà xuất bản", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 153, 102))); // NOI18N

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 798, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 535, Short.MAX_VALUE)
                .addContainerGap())
        );

        add(jPanel2);
        jPanel2.setBounds(187, 11, 830, 580);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonChonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonChonActionPerformed
        inNXBSelect.nxb(current);
    }//GEN-LAST:event_buttonChonActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    String name = JOptionPane.showInputDialog(this, "Nhập Tên Nhà Xuất Bản");
          if(name !=null){
              current.setTennxb(name.trim());
             ArrayList<nxbDTO> arr = nxbBUS.getNXB();
              current.setManxb((Integer.parseInt(arr.get(arr.size()-1).getManxb())+1)+"");
//              nxbBUS.themNXB(current, this);
             String diachi = JOptionPane.showInputDialog(this, "Nhập Địa Chỉ Nhà Xuất Bản");
            if(diachi!=null){
              current.setDiachi(diachi.trim());
              String email = JOptionPane.showInputDialog(this, "Nhập Email Nhà Xuất Bản");
             if(email!=null){
              current.setEmail(email.trim());
               String sdt = JOptionPane.showInputDialog(this, "Nhập Sđt Nhà Xuất Bản");
             if(sdt!=null){
              current.setSdt(sdt.trim());
                nxbBUS.themNXB(current, this);
            }
            }
            }
          }
          
           
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        if(current.getManxb().length()>0){
            nxbBUS.xoaNXB(current.getManxb(), this);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
            String name = JOptionPane.showInputDialog(this, "Nhập Tên Nhà Xuất Bản",current.getTennxb());
            if(name != null){
              current.setTennxb(name.trim());
             String diachi = JOptionPane.showInputDialog(this, "Nhập Địa Chỉ Nhà Xuất Bản",current.getDiachi());
            if(diachi!= null){
              current.setDiachi(diachi.trim());
              String email = JOptionPane.showInputDialog(this, "Nhập Email Nhà Xuất Bản",current.getEmail());
             if(email!= null){
              current.setEmail(email.trim());
               String sdt = JOptionPane.showInputDialog(this, "Nhập Sđt Nhà Xuất Bản",current.getSdt());
             if(sdt!= null){
              current.setSdt(sdt.trim());
              nxbBUS.suaNXB(current, this);
            }
            }
            }
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
        loadNXB();
    }

    @Override
    public void onFailed(String error) {
        System.err.println(""+error);
    }
}
