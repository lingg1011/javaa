package GUI;

import BUS.chitietphieuBUS;
import BUS.nhanvienBUS;
import BUS.phieumuontraBUS;
import BUS.sachBUS;
import BUS.thongkeBUS;
import DTO.chitietphieuDTO;
import DTO.nhanvienDTO;
import DTO.phieumuontraDTO;
import DTO.sachDTO;
import DTO.thongKeNhanVienDTO;
import interfaces.QueryCallBack;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.shape.Path;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;
import untils.DateLabelFormatter;
import untils.OutFile;

public class PanelStatistical extends javax.swing.JPanel implements QueryCallBack {

    //Phiếu mượn trả
    UtilDateModel model = new UtilDateModel();
    UtilDateModel model2 = new UtilDateModel();

    UtilDateModel mode21 = new UtilDateModel();
    UtilDateModel mode22 = new UtilDateModel();

    JDatePickerImpl datePicker;
    JDatePickerImpl datePicker2;
    JDatePickerImpl datePicker3;
    JDatePickerImpl datePicker4;

    //Nhân viên
    JDatePickerImpl datePicker5;
    JDatePickerImpl datePicker6;

    UtilDateModel mode31 = new UtilDateModel();
    UtilDateModel mode32 = new UtilDateModel();

    // Don't know about the formatter, but there it is...
    public PanelStatistical() {
        initComponents();
        loadPhieuMuonTra();
        setView();

//        panelNhanVien.setBounds(230, 70, 570, 100);
//        panelMuonTra.setBounds(230, 70, 570, 100);
//        panelSach.setBounds(230, 70, 570, 100);
        panelNhanVien.setVisible(false);
        panelSach.setVisible(false);

        Properties p = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");
        JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
        JDatePanelImpl datePane2 = new JDatePanelImpl(model2, p);
        JDatePanelImpl datePane3 = new JDatePanelImpl(mode21, p);
        JDatePanelImpl datePane4 = new JDatePanelImpl(mode22, p);

        JDatePanelImpl datePane5 = new JDatePanelImpl(mode31, p);
        JDatePanelImpl datePane6 = new JDatePanelImpl(mode32, p);

        datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());

        panelMuonTra.add(datePicker);
        datePicker.setBounds(220, 20, 130, 30);

        datePicker2 = new JDatePickerImpl(datePane2, new DateLabelFormatter());

        panelMuonTra.add(datePicker2);
        datePicker2.setBounds(400, 20, 130, 30);

        datePicker3 = new JDatePickerImpl(datePane3, new DateLabelFormatter());

        panelMuonTra.add(datePicker3);
        datePicker3.setBounds(220, 60, 130, 30);

        datePicker4 = new JDatePickerImpl(datePane4, new DateLabelFormatter());

        panelMuonTra.add(datePicker4);
        datePicker4.setBounds(400, 60, 130, 30);

        datePicker5 = new JDatePickerImpl(datePane5, new DateLabelFormatter());

        panelNhanVien.add(datePicker5);
        datePicker5.setBounds(230, 40, 120, 30);

        datePicker6 = new JDatePickerImpl(datePane6, new DateLabelFormatter());

        panelNhanVien.add(datePicker6);
        datePicker6.setBounds(400, 40, 120, 30);

    }

    public void loadPhieuMuonTra() {
        String[] header = {"Mã Mượn Trả", "Mã Sách", "Số Lượng", "Đã Trả", "Ngày Trả", "Hạn Trả"};
        DefaultTableModel dtm;
        ArrayList<chitietphieuDTO> arr = new ArrayList<chitietphieuDTO>();
        dtm = new DefaultTableModel(header, 0);
        arr = chitietphieuBUS.getChiTietPhieu();
        chitietphieuDTO ctp = new chitietphieuDTO();
        for (int i = 0; i < arr.size(); i++) {
            ctp = arr.get(i);
            String mamuontra = ctp.getMaMuonTra();
            String tensach = sachBUS.getTenSach(ctp.getMaSach());
            int soluong = ctp.getSoLuong();
            String datra = ctp.getDaTras();
            Date ngaytra = ctp.getNgayTra();
            Date hantra = ctp.getHanTra();
            System.out.println(mamuontra + tensach + soluong + datra + ngaytra + hantra);
            Object[] row = {mamuontra, tensach, soluong, datra, ngaytra, hantra};
            dtm.addRow(row);
        }
        jTable1.setModel(dtm);

    }

    public void setView() {
        jLabel3.setText("Tổng số đọc giả :" + thongkeBUS.TongSoDocGia());
        jLabel4.setText("Tổng số sách :" + thongkeBUS.TongSoSach());
        jLabel5.setText("Tổng số phiếu mượn :" + thongkeBUS.TongSoPhieuMuon());
        jLabel6.setText("Tổng số người mượn :" + thongkeBUS.TongSoNguoiMuonSach());
        jLabel7.setText("Tổng số người trả quá hạn :" + thongkeBUS.TongSoTraQuaHan());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        panelMuonTra = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        panelNhanVien = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        panelSach = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jComboBoxtacgia = new javax.swing.JComboBox<>();
        jCombotheloai = new javax.swing.JComboBox<>();
        jComboBoxnxb = new javax.swing.JComboBox<>();
        xemthongke = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.setLayout(null);

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel9.setText("Kết quả");

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
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1010, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel9)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel9)
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 493, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3);
        jPanel3.setBounds(10, 231, 1010, 530);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setText("Thống kê nhanh");

        jLabel3.setText("jLabel3");

        jLabel4.setText("jLabel4");

        jLabel5.setText("jLabel5");

        jLabel6.setText("jLabel6");

        jLabel7.setText("jLabel7");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(9, 9, 9)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addContainerGap(59, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel4);
        jPanel4.setBounds(10, 10, 210, 210);

        jRadioButton1.setText("Nhân Viên");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jRadioButton1);
        jRadioButton1.setBounds(680, 30, 120, 30);

        jRadioButton2.setSelected(true);
        jRadioButton2.setText("Phiếu Mượn Trả");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jRadioButton2);
        jRadioButton2.setBounds(230, 30, 120, 30);

        jRadioButton3.setText("Sách");
        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jRadioButton3);
        jRadioButton3.setBounds(460, 30, 120, 30);

        jButton1.setText("Xem Thống Kê");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(420, 190, 200, 40);

        panelMuonTra.setLayout(null);

        jLabel1.setText("Đến");
        panelMuonTra.add(jLabel1);
        jLabel1.setBounds(360, 20, 40, 30);

        jLabel8.setText("Hạn Trả");
        panelMuonTra.add(jLabel8);
        jLabel8.setBounds(70, 20, 58, 30);

        jLabel10.setText("Từ");
        panelMuonTra.add(jLabel10);
        jLabel10.setBounds(190, 20, 30, 30);

        jLabel11.setText("Ngày Trả");
        panelMuonTra.add(jLabel11);
        jLabel11.setBounds(70, 60, 58, 30);

        jLabel12.setText("Đến");
        panelMuonTra.add(jLabel12);
        jLabel12.setBounds(360, 60, 40, 30);

        jLabel13.setText("Từ");
        panelMuonTra.add(jLabel13);
        jLabel13.setBounds(190, 60, 30, 30);

        jPanel1.add(panelMuonTra);
        panelMuonTra.setBounds(230, 70, 570, 100);

        panelNhanVien.setLayout(null);

        jLabel32.setText("Đến");
        panelNhanVien.add(jLabel32);
        jLabel32.setBounds(360, 40, 40, 30);

        jLabel34.setText("Từ");
        panelNhanVien.add(jLabel34);
        jLabel34.setBounds(190, 40, 30, 30);

        jLabel35.setText("Ngày Lập Phiếu");
        panelNhanVien.add(jLabel35);
        jLabel35.setBounds(30, 40, 90, 30);

        jPanel1.add(panelNhanVien);
        panelNhanVien.setBounds(230, 70, 570, 100);
        panelNhanVien.getAccessibleContext().setAccessibleDescription("");

        panelSach.setLayout(null);

        jLabel15.setText("Thể loại");
        panelSach.add(jLabel15);
        jLabel15.setBounds(60, 20, 58, 30);

        jLabel16.setText("Tác Giả");
        panelSach.add(jLabel16);
        jLabel16.setBounds(450, 20, 60, 30);

        jLabel17.setText("Nhà Xuất Bản");
        panelSach.add(jLabel17);
        jLabel17.setBounds(260, 20, 70, 30);

        jComboBoxtacgia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "Bùi Hiền", "Diệp Lạc Vô Tâm", "Kim Dung", "Bộ giáo dục và đào tạo" }));
        jComboBoxtacgia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxtacgiaActionPerformed(evt);
            }
        });
        panelSach.add(jComboBoxtacgia);
        jComboBoxtacgia.setBounds(440, 50, 70, 20);

        jCombotheloai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "Chính Trị", "Văn Học", "Khoa Học", "Nấu Ăn", "Toán Học" }));
        panelSach.add(jCombotheloai);
        jCombotheloai.setBounds(50, 50, 70, 20);

        jComboBoxnxb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "Sự Thật", "Kim Đồng", "Giáo Dục", "Lao Động", "Chính Trị Quốc Gia", "Thanh Niên", "Phụ Nữ" }));
        panelSach.add(jComboBoxnxb);
        jComboBoxnxb.setBounds(260, 50, 70, 20);

        jPanel1.add(panelSach);
        panelSach.setBounds(230, 70, 570, 100);
        panelSach.getAccessibleContext().setAccessibleParent(jPanel1);

        xemthongke.setText("Xuất Excel");
        xemthongke.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xemthongkeActionPerformed(evt);
            }
        });
        jPanel1.add(xemthongke);
        xemthongke.setBounds(670, 200, 130, 23);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1024, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 768, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        // TODO add your handling code here:
        jRadioButton1.setSelected(false);
        jRadioButton2.setSelected(true);
        jRadioButton3.setSelected(false);
        panelMuonTra.setVisible(true);
        panelNhanVien.setVisible(false);
        panelSach.setVisible(false);
        loadPhieuMuonTra();
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton3ActionPerformed
        // TODO add your handling code here:
        jRadioButton1.setSelected(false);
        jRadioButton2.setSelected(false);
        jRadioButton3.setSelected(true);
        panelMuonTra.setVisible(false);
        panelNhanVien.setVisible(false);
        panelSach.setVisible(true);
        loadSach();
    }//GEN-LAST:event_jRadioButton3ActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        // TODO add your handling code here:
        jRadioButton1.setSelected(true);
        jRadioButton2.setSelected(false);
        jRadioButton3.setSelected(false);
        panelMuonTra.setVisible(false);
        panelNhanVien.setVisible(true);
        panelSach.setVisible(false);
        loadNhanVien();
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if (jRadioButton1.isSelected()) {
            String[] header = {"Mã Nhân Viên", "Tên Nhân Viên", "Ngày Lập Phiếu", "Mã Phiếu"};
            if (mode31.getValue() != null && mode32.getValue() != null) {
                ArrayList<thongKeNhanVienDTO> nhanVien = phieumuontraBUS.thongKeNhanVien(mode31.getValue(), mode32.getValue());
                if (nhanVien.size() != 0) {
                    thongKeNhanVienDTO nv = new thongKeNhanVienDTO();
                    DefaultTableModel dtm;
                    dtm = new DefaultTableModel(header, 0);
                    for (int i = 0; i < nhanVien.size(); i++) {
                        nv = nhanVien.get(i);
                        String manv = nv.getMaNV();
                        String tennv = nv.getTenNhanVien();
                        Date ngaylap = nv.getNgaylap();
                        String mamuontra = nv.getMaphieumuon();

                        Object[] row = {manv, tennv, ngaylap, mamuontra};
                        dtm.addRow(row);
                    }
                    jTable1.setModel(dtm);
                } else {
                    JOptionPane.showMessageDialog(null, "Không có kết quả phù hợp!");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Bạn cần nhập đủ dữ liệu!");
            }
        }
        if (jRadioButton3.isSelected()) {
            if (jComboBoxnxb.getSelectedItem() == "" && jCombotheloai.getSelectedItem() == "" && jComboBoxtacgia.getSelectedItem() == "") {
                JOptionPane.showMessageDialog(null, "Bạn cần nhập một dữ liệu!");
            } else {
                String[] header = {"Mã Sách", "Tên Sách", "Tác Giả", "Thể Loại", "NXB", "SL", "SL Còn"};
                ArrayList<sachDTO> sach = sachBUS.thongkesach(String.valueOf(jCombotheloai.getSelectedItem()),
                        String.valueOf(jComboBoxnxb.getSelectedItem()), String.valueOf(jComboBoxtacgia.getSelectedItem()));
                if (sach.size() != 0) {
                    sachDTO s = new sachDTO();
                    DefaultTableModel dtm;
                    dtm = new DefaultTableModel(header, 0);
                    for (int i = 0; i < sach.size(); i++) {
                        s = sach.get(i);
                        String masach = s.getMaSach();
                        String tensach = s.getTenSach();
                        String tacgia = s.getTenTacGia();
                        String theloai = s.getTheLoai();
                        String nxb = s.getNhaXuatBan();
                        int sl = s.getSoLuongHienCo();
                        int slc = s.getSoLuongCon();
                        Object[] row = {masach, tensach, tacgia, theloai, nxb, sl, slc};
                        dtm.addRow(row);
                    }
                    jTable1.setModel(dtm);
                } else {
                    JOptionPane.showMessageDialog(null, "Không có kết quả phù hợp!");
                }
            }
        }
        if (jRadioButton2.isSelected()) {
            String[] header = {"Mã Mượn Trả", "Mã Sách", "Số Lượng", "Đã Trả", "Ngày Trả", "Hạn Trả"};
            if (model.getValue() != null && model2.getValue() != null && mode21.getValue() != null && mode22.getValue() != null) {
                ArrayList<chitietphieuDTO> phieumuontra = chitietphieuBUS.thongkePhieuMuonTra(model.getValue(), model2.getValue(), mode21.getValue(), mode22.getValue());

                if (phieumuontra.size() != 0) {
                    chitietphieuDTO ctp = new chitietphieuDTO();
                    DefaultTableModel dtm;
                    dtm = new DefaultTableModel(header, 0);
                    for (int i = 0; i < phieumuontra.size(); i++) {
                        ctp = phieumuontra.get(i);
                        String mamuontra = ctp.getMaMuonTra();
                        String tensach = sachBUS.getTenSach(ctp.getMaSach());
                        int soluong = ctp.getSoLuong();
                        String datra = ctp.getDaTras();
                        Date ngaytra = ctp.getNgayTra();
                        Date hantra = ctp.getHanTra();
                        System.out.println(mamuontra + tensach + soluong + datra + ngaytra + hantra);
                        Object[] row = {mamuontra, tensach, soluong, datra, ngaytra, hantra};
                        dtm.addRow(row);
                    }
                    jTable1.setModel(dtm);
                } else {
                    JOptionPane.showMessageDialog(null, "Không có kết quả phù hợp!");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Bạn cần nhập đủ dữ liệu!");
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBoxtacgiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxtacgiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxtacgiaActionPerformed

    private void xemthongkeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xemthongkeActionPerformed
        try {
            OutFile.writeExcel(jTable1, "system\\file\\excel\\thongke\\", true);
        } catch (IOException ex) {
            Logger.getLogger(PanelBook.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_xemthongkeActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBoxnxb;
    private javax.swing.JComboBox<String> jComboBoxtacgia;
    private javax.swing.JComboBox<String> jCombotheloai;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JPanel panelMuonTra;
    private javax.swing.JPanel panelNhanVien;
    private javax.swing.JPanel panelSach;
    private javax.swing.JButton xemthongke;
    // End of variables declaration//GEN-END:variables

    @Override
    public void onSuccess() {
        loadPhieuMuonTra();
    }

    @Override
    public void onFailed(String error) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void loadSach() {
        String[] header = {"Mã Sách", "Tên Sách", "Tác Giả", "Thể Loại", "NXB", "SL", "SL Còn"};
        DefaultTableModel dtm;
        dtm = new DefaultTableModel(header, 0);
        ArrayList<sachDTO> arr = new ArrayList<sachDTO>();
        arr = sachBUS.getSach();
        sachDTO s = new sachDTO();
        for (int i = 0; i < arr.size(); i++) {
            s = arr.get(i);
            String masach = s.getMaSach();
            String tensach = s.getTenSach();
            String tacgia = s.getTenTacGia();
            String theloai = s.getTheLoai();
            String nxb = s.getNhaXuatBan();
            int sl = s.getSoLuongHienCo();
            int slc = s.getSoLuongCon();
            Object[] row = {masach, tensach, tacgia, theloai, nxb, sl, slc};
            dtm.addRow(row);
        }
        jTable1.setModel(dtm);
    }

    private void loadNhanVien() {
        String[] header = {"Mã Nhân Viên", "Tên Nhân Viên", "Ngày Sinh", "SĐT", "Địa Chỉ"};
        DefaultTableModel dtm;
        dtm = new DefaultTableModel(header, 0);
        ArrayList<nhanvienDTO> arr = new ArrayList<nhanvienDTO>();
        arr = nhanvienBUS.getNhanVien();
        nhanvienDTO nv = new nhanvienDTO();
        for (int i = 0; i < arr.size(); i++) {
            nv = arr.get(i);
            String manv = nv.getMaNV();
            String tennv = nv.getTenNhanVien();
            Date ngaysinh = nv.getNgaysinh();
            String sdt = nv.getSdt();
            String diachi = nv.getDiaChi();
            String matkhau = nv.getPassword();
            String quyen = nv.getRole() + "";
            Object[] row = {manv, tennv, ngaysinh, sdt, diachi, matkhau, quyen};
            dtm.addRow(row);
        }
        jTable1.setModel(dtm);
    }
}
