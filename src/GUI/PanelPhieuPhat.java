/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BUS.chitietphieuphatBUS;
import BUS.docgiaBUS;
import BUS.nhanvienBUS;
import BUS.phieumuontraBUS;
import BUS.phieuphatBUS;
import BUS.sachBUS;
import DTO.chitietphieuDTO;
import DTO.chitietphieunhapDTO;
import DTO.chitietphieuphatDTO;
import DTO.docgiaDTO;
import DTO.nhanvienDTO;
import DTO.phieumuontraDTO;
import DTO.phieuphatDTO;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import interfaces.InChangePanelDeal;
import interfaces.InDocGiaSelect;
import interfaces.InNhanVienSelect;
import interfaces.QueryCallBack;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;
import untils.CheckData;
import untils.DateLabelFormatter;
import untils.OutFile;
import untils.cons;

/**
 *
 * @author Admin
 */
public class PanelPhieuPhat extends javax.swing.JPanel implements QueryCallBack, InNhanVienSelect {

    DefaultTableModel dtm;
    ArrayList<phieuphatDTO> arr = new ArrayList<>();
    JDatePickerImpl datePicker;
    JDatePickerImpl datePicker2;
    JDatePickerImpl datePickerngaymuon;
    UtilDateModel model = new UtilDateModel();
    UtilDateModel model2 = new UtilDateModel();
    UtilDateModel modelngaymuon = new UtilDateModel();
    Panelchoosenhanvien panelNv;
    InChangePanelDeal inChangePanelDeal;
    phieuphatDTO current = new phieuphatDTO();
    chitietphieuDTO chitiet;

    public PanelPhieuPhat(InChangePanelDeal inChangePanelDeal) {
        initComponents();
        this.inChangePanelDeal = inChangePanelDeal;
        buttonAddnhanvien.setVisible(false);
        jButton6.setVisible(false);

//        jButton12.setVisible(false);
//        jButton13.setVisible(false);
        panelNv = new Panelchoosenhanvien(this);
        panelNv.setBackground(new java.awt.Color(102, 102, 102));
        panelNv.setForeground(new java.awt.Color(0, 204, 204));
        panelNv.setLayout(null);
        panelNv.setBounds(0, 0, 1024, 768);
        panelNv.setVisible(false);
        add(panelNv);

        Properties p = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");

        JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
        JDatePanelImpl datePane2 = new JDatePanelImpl(model2, p);
        JDatePanelImpl datePanengaymuon = new JDatePanelImpl(modelngaymuon, p);

        datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
        datePicker.setBounds(10, 130, 120, 25);
        jPanel2.add(datePicker);

        datePicker2 = new JDatePickerImpl(datePane2, new DateLabelFormatter());
        datePicker2.setBounds(280, 130, 120, 25);
        jPanel2.add(datePicker2);

        datePickerngaymuon = new JDatePickerImpl(datePanengaymuon, new DateLabelFormatter());
        datePickerngaymuon.setBounds(280, 130, 120, 25);
        jPanel2.add(datePickerngaymuon);
        datePickerngaymuon.setBounds(767, 10, 20, 25);
        datePickerngaymuon.setVisible(false);
        datePickerngaymuon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Date today = new Date();
                today.getTime();
                if (modelngaymuon.getValue().before(today)) {
                    jTextField4.setText(new SimpleDateFormat("yyyy-MM-dd").format(modelngaymuon.getValue()));
                } else {
                    jTextField4.setText(new SimpleDateFormat("yyyy-MM-dd").format(today));
                }
//                jTextField4.setText(new SimpleDateFormat("yyyy-MM-dd").format(modelngaymuon.getValue()));
            }
        });
        loadPhieuPhat();
        initData();
        initEvent();
    }

    public PanelPhieuPhat(chitietphieuDTO ctphieu) {
        initComponents();
        this.chitiet = ctphieu;
        this.inChangePanelDeal = inChangePanelDeal;
        buttonAddnhanvien.setVisible(false);
        jButton6.setVisible(false);

//        jButton12.setVisible(false);
//        jButton13.setVisible(false);
        panelNv = new Panelchoosenhanvien(this);
        panelNv.setBackground(new java.awt.Color(102, 102, 102));
        panelNv.setForeground(new java.awt.Color(0, 204, 204));
        panelNv.setLayout(null);
        panelNv.setBounds(0, 0, 1024, 768);
        panelNv.setVisible(false);
        add(panelNv);

        Properties p = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");

        JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
        JDatePanelImpl datePane2 = new JDatePanelImpl(model2, p);
        JDatePanelImpl datePanengaymuon = new JDatePanelImpl(modelngaymuon, p);

        datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
        datePicker.setBounds(10, 130, 120, 25);
        jPanel2.add(datePicker);

        datePicker2 = new JDatePickerImpl(datePane2, new DateLabelFormatter());
        datePicker2.setBounds(280, 130, 120, 25);
        jPanel2.add(datePicker2);

        datePickerngaymuon = new JDatePickerImpl(datePanengaymuon, new DateLabelFormatter());
        datePickerngaymuon.setBounds(280, 130, 120, 25);
        jPanel2.add(datePickerngaymuon);
        datePickerngaymuon.setBounds(767, 10, 20, 25);
        datePickerngaymuon.setVisible(false);
        datePickerngaymuon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Date today = new Date();
                today.getTime();
                if (modelngaymuon.getValue().before(today)) {
                    jTextField4.setText(new SimpleDateFormat("yyyy-MM-dd").format(modelngaymuon.getValue()));
                } else {
                    jTextField4.setText(new SimpleDateFormat("yyyy-MM-dd").format(today));
                }
//                jTextField4.setText(new SimpleDateFormat("yyyy-MM-dd").format(modelngaymuon.getValue()));
            }
        });
        loadPhieuPhat();
        initData();
        initEvent();
        if (ctphieu != null) {
            boolean has = false;
            for (int i = 0; i < arr.size(); i++) {
                if (arr.get(i).getMamuontra().equals(ctphieu.getMaMuonTra())) {
                    setView(arr.get(i));
                    jButton8.doClick();
                    has = true;
                    break;
                }

            }
            if (!has) {
                jButton6.doClick();
                tfmuontra.setText(ctphieu.getMaMuonTra());
            }

            tfmuontra.setEditable(false);
            datePickerngaymuon.setVisible(false);
            buttonAddnhanvien.setVisible(false);

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

        jTextField9 = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jButton11 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        tfphieuphat = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jTextField4 = new javax.swing.JTextField();
        tftongtien = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<String>();
        jTextField7 = new javax.swing.JTextField();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jButton14 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButton15 = new javax.swing.JButton();
        buttonAddnhanvien = new javax.swing.JButton();
        buttonThemChiTiet = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        tfmuontra = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setLayout(null);

        jButton11.setText("Mã Phiếu Phạt");
        jPanel2.add(jButton11);
        jButton11.setBounds(10, 10, 130, 25);

        jButton2.setText("Nhân Viên");
        jPanel2.add(jButton2);
        jButton2.setBounds(10, 90, 130, 25);
        jPanel2.add(tfphieuphat);
        tfphieuphat.setBounds(146, 10, 212, 25);

        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });
        jPanel2.add(jTextField3);
        jTextField3.setBounds(150, 90, 212, 25);

        jButton3.setText("Ngày Lập");
        jPanel2.add(jButton3);
        jButton3.setBounds(403, 10, 130, 25);

        jButton5.setText("Tổng Tiền");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton5);
        jButton5.setBounds(402, 53, 130, 25);
        jPanel2.add(jTextField4);
        jTextField4.setBounds(539, 10, 222, 25);
        jPanel2.add(tftongtien);
        tftongtien.setBounds(538, 53, 222, 25);

        jButton6.setText("Thêm");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton6);
        jButton6.setBounds(805, 11, 170, 50);

        jButton7.setText("Xóa");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton7);
        jButton7.setBounds(805, 70, 170, 50);

        jButton8.setText("Sửa");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton8);
        jButton8.setBounds(805, 124, 170, 50);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Mã Phiếu Phạt", "Nhân Viên", "Ngày Lập" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        jPanel2.add(jComboBox1);
        jComboBox1.setBounds(10, 202, 120, 30);
        jPanel2.add(jTextField7);
        jTextField7.setBounds(140, 202, 320, 30);

        jButton9.setText("Tìm Kiếm");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton9);
        jButton9.setBounds(470, 202, 100, 30);

        jButton10.setText("Back");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton10);
        jButton10.setBounds(915, 196, 60, 23);

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

        jPanel2.add(jScrollPane1);
        jScrollPane1.setBounds(10, 238, 965, 402);

        jLabel1.setText("Từ");

        jButton14.setText("jButton14");

        jLabel2.setText("Đến");

        jButton15.setText("jButton15");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(5, 5, 5)
                .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(100, 100, 100)
                .addComponent(jLabel2)
                .addGap(110, 110, 110)
                .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel2.add(jPanel1);
        jPanel1.setBounds(10, 154, 393, 30);

        buttonAddnhanvien.setText("jButton13");
        buttonAddnhanvien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAddnhanvienActionPerformed(evt);
            }
        });
        jPanel2.add(buttonAddnhanvien);
        buttonAddnhanvien.setBounds(370, 90, 20, 25);

        buttonThemChiTiet.setText("Thêm Chi Tiết");
        buttonThemChiTiet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonThemChiTietActionPerformed(evt);
            }
        });
        jPanel2.add(buttonThemChiTiet);
        buttonThemChiTiet.setBounds(400, 100, 120, 50);

        jButton12.setText("Mã Mượn Trả");
        jPanel2.add(jButton12);
        jButton12.setBounds(10, 50, 130, 25);
        jPanel2.add(tfmuontra);
        tfmuontra.setBounds(150, 50, 212, 25);

        jButton1.setText("Xuất Excell");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1);
        jButton1.setBounds(610, 90, 120, 23);

        jButton4.setText("Xuất PDF");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton4);
        jButton4.setBounds(610, 130, 120, 23);

        jButton13.setText("Lưu ĐTB");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton13);
        jButton13.setBounds(610, 210, 120, 23);

        jButton16.setText("Đọc Excel");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton16);
        jButton16.setBounds(610, 170, 120, 23);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1024, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 768, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        String[] header = {"Mã Phiếu Phạt", "Nhân Viên", "Ngày Lập", "Tổng Tiền"};
        DefaultTableModel dtmsearch = new DefaultTableModel(header, 0);
        ArrayList<phieuphatDTO> s;
        if (jComboBox1.getSelectedItem().equals("Ngày Lập")) {
            s = phieuphatBUS.timkiemNL(model.getValue(), model2.getValue());
        } else {
            if (jComboBox1.getSelectedItem() == "Mã Phiếu Phạt") {
                if (CheckData.checkNumber(jTextField7.getText().toString().trim())) {
                    s = phieuphatBUS.timkiemPhieuMuonTra(String.valueOf(jComboBox1.getSelectedItem()), jTextField7.getText().toLowerCase().trim());
                } else {
                    JOptionPane.showMessageDialog(null, "Bạn phải nhập số!");
                }
            }
            s = phieuphatBUS.timkiemPhieuMuonTra(String.valueOf(jComboBox1.getSelectedItem()), jTextField7.getText().toLowerCase().trim());
        }
        if (s.size() != 0) {
            phieuphatDTO pmt = new phieuphatDTO();
            for (int i = 0; i < s.size(); i++) {
                pmt = s.get(i);
                String mapp = pmt.getMaphieuphat();
                String manv = pmt.getManv();
                int tongtien = pmt.getTongtien();
                String tennv = nhanvienBUS.getTenNhanVien(manv);
                Date ngaylap = pmt.getNgaylap();
//            System.out.println("ngày hẹn trả" + ngayhentra);
                Object[] row = {mapp, tennv, ngaylap, tongtien};
                dtmsearch.addRow(row);
            }
            jTable1.setModel(dtmsearch);
            setView(s.get(0));
            jButton10.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Không có kết quả phù hợp!");
        }
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        jTable1.setModel(dtm);
        jButton10.setVisible(false);
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        phieuphatBUS.xoaPhieuMuonTra(tfphieuphat.getText().toString().trim(), this);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        if (jButton8.getText().toString().equals("Sửa")) {
//        buttonAddnhanvien.setVisible(true);
            datePickerngaymuon.setVisible(true);
            buttonThemChiTiet.setVisible(false);

            jButton6.setVisible(false);
            jButton7.setVisible(false);

            jButton8.setText("Xác nhận sửa");
        } else {
            if (jTextField3.getText().length() == 0 || jTextField4.getText().length() == 0 || tftongtien.getText().length() == 0) {
                JOptionPane.showMessageDialog(null, "Vui lòng điền đủ thông tin vào bảng");
            } else {

                jButton7.setVisible(true);
                buttonThemChiTiet.setVisible(false);
                buttonAddnhanvien.setVisible(false);
                datePickerngaymuon.setVisible(false);
                jButton8.setText("Sửa");
                phieuphatDTO ctp = new phieuphatDTO();
                ctp.setMamuontra(tfmuontra.getText().trim());
                ctp.setMaphieuphat(tfphieuphat.getText().trim());
                ctp.setManv(current.getManv());
                ctp.setTongtien(Integer.parseInt(tftongtien.getText().trim()));
                Date date1 = null, date2 = null;
                try {
                    date1 = new SimpleDateFormat("yyyy-MM-dd").parse(jTextField4.getText().trim());
//               date2 = new SimpleDateFormat("dd/MM/yyyy").parse(jTextField5.getText().trim());
                } catch (ParseException ex) {
                    Logger.getLogger(PanelLoanSlipDetails.class.getName()).log(Level.SEVERE, null, ex);
                }
                ctp.setNgaylap(date1);
//            ctp.setNgayTra(date2);
                phieuphatBUS.suaPhieuMuonTra(ctp, this);
            }
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        if (jButton6.getText().toString().equals("Thêm")) {
            jButton6.setVisible(true);
            buttonThemChiTiet.setVisible(true);
//        buttonAddnhanvien.setVisible(true);
            datePickerngaymuon.setVisible(true);
//        jButton13.setVisible(true);
            ArrayList<phieuphatDTO> arr = phieuphatBUS.getPhieuPhat();
            tfphieuphat.setText("" + (Integer.parseInt(arr.get(arr.size() - 1).getMaphieuphat()) + 1));
            jButton6.setText("Xác nhận thêm");
            jButton11.setText("Mã Phiếu Phạt");
            jButton2.setText("Mã Nhân Viên");
            jTextField3.setText(cons.nv.getTenNhanVien());
            current.setManv(cons.nv.getMaNV());
            Date today = new Date();
            today.getTime();
            jTextField4.setText(new SimpleDateFormat("yyyy-MM-dd").format(today));
            tftongtien.setText("");

            jButton7.setVisible(false);
            jButton8.setVisible(false);
//        jTextField5.setText("");
        } else {
            if (jTextField3.getText().length() == 0 || jTextField4.getText().length() == 0 || tftongtien.getText().length() == 0) {
                JOptionPane.showMessageDialog(null, "Vui lòng điền đủ thông tin vào bảng");
            } else {

                jButton6.setVisible(false);
                jButton7.setVisible(true);
                jButton8.setVisible(true);
                buttonThemChiTiet.setVisible(false);
                datePickerngaymuon.setVisible(false);
                buttonAddnhanvien.setVisible(false);
                jButton6.setText("Thêm");
                phieuphatDTO ctp = new phieuphatDTO();
                ctp.setMamuontra(tfmuontra.getText().trim());
                ctp.setMaphieuphat(tfphieuphat.getText().trim());
                ctp.setManv(current.getManv());
                ctp.setTongtien(Integer.parseInt(tftongtien.getText().trim()));
                Date date1 = null, date2 = null;
                try {
                    date1 = new SimpleDateFormat("yyyy-MM-dd").parse(jTextField4.getText().trim());
//               date2 = new SimpleDateFormat("dd/MM/yyyy").parse(jTextField5.getText().trim());
                } catch (ParseException ex) {
                }
                ctp.setNgaylap(date1);
//            ctp.setNgayTra(date2);
                phieuphatBUS.themPhieuPhat(ctp, this);
            }
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void buttonAddnhanvienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAddnhanvienActionPerformed
        // TODO add your handling code here:
        jPanel2.setVisible(false);
        panelNv.setVisible(true);
        revalidate();
    }//GEN-LAST:event_buttonAddnhanvienActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void buttonThemChiTietActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonThemChiTietActionPerformed
        // TODO add your handling code here:
        JFrame themchitiet = new JFrame();
        themchitiet.setVisible(true);
//         Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
//         themchitiet.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        themchitiet.setSize(1044, 768);
        themchitiet.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent windowEvent) {
                // your code
                buttonThemChiTiet.setVisible(false);
                tftongtien.setText(chitietphieuphatBUS.getTongTien(tfphieuphat.getText().toString().trim()) + "");

            }
        });
//          themchitiet.addWindowListener(new java.awt.event.WindowAdapter() {
//              
//        @Override
//        public void windowClosing(java.awt.event.WindowEvent windowEvent) {
//          }
//    });
        if (chitiet.getSoLuong() != null) {
            PanelChiTietPhieuPhat pb = new PanelChiTietPhieuPhat(chitiet, 1);
            pb.setBounds(0, 0, 1024, 768);
            themchitiet.add(pb);
        } else {
            chitietphieuDTO a = new chitietphieuDTO();
            a.setMaMuonTra(tfphieuphat.getText().trim());
            PanelChiTietPhieuPhat pb = new PanelChiTietPhieuPhat(a, 1);
            pb.setBounds(0, 0, 1024, 768);
            themchitiet.add(pb);
        }

    }//GEN-LAST:event_buttonThemChiTietActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        Document document = new Document();

        try {
            // khởi tạo một PdfWriter truyền vào document và FileOutputStream
            PdfWriter.getInstance(document, new FileOutputStream(OutFile.createFilePDF("system\\file\\pdf\\phieuphat\\")));

            // mở file để thực hiện viết
            document.open();
            // thêm nội dung sử dụng add function
            document.add(new Paragraph(OutFile.removeAccent("Phiếu Phạt")));
            document.add(new Paragraph(OutFile.removeAccent("Mã Phiếu phạt: " + tfphieuphat.getText())));
            document.add(new Paragraph(OutFile.removeAccent("Mã Mượn trả: " + tfmuontra.getText())));
            document.add(new Paragraph(OutFile.removeAccent("Nhân Viên: " + jTextField3.getText())));
            document.add(new Paragraph(OutFile.removeAccent("Ngày lập: " + jTextField4.getText())));
            document.add(new Paragraph("Danh sach:"));
            PdfPTable table = new PdfPTable(2);
            PdfPCell header1 = new PdfPCell(new Paragraph("Ten Sach"));
            PdfPCell header2 = new PdfPCell(new Paragraph("So Luong"));
            table.addCell(header1);
            table.addCell(header2);
            ArrayList<chitietphieuphatDTO> ctpp = chitietphieuphatBUS.getChiTietPhieuPhat();
            for (int i = 0; i < ctpp.size(); i++) {
                if (ctpp.get(i).getMaphieuphat().equals(tfphieuphat.getText())) {
                    String tensach = sachBUS.getTenSach(ctpp.get(i).getMasach());
                    PdfPCell data1 = new PdfPCell(new Paragraph(OutFile.removeAccent(tensach)));
                    PdfPCell data2 = new PdfPCell(new Paragraph(ctpp.get(i).getSoluong()));
                    table.addCell(data1);
                    table.addCell(data2);
                }
            }
            document.add(table);
            document.add(new Paragraph("Tong tien: " + tftongtien.getText()));
                //Khởi tạo 3 ô header

            //Thêm 3 ô header vào table
            document.close();
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PanelEmployees.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try {
            OutFile.writeExcel(jTable1, "system\\file\\excel\\phieuphat\\", true);
        } catch (IOException ex) {
            Logger.getLogger(PanelBook.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        TableModel model = jTable1.getModel();
        for (int i = 0; i < model.getRowCount(); i++) {
            phieuphatDTO pp = new phieuphatDTO();
            pp.setMamuontra(model.getValueAt(i, 1) + "");
            pp.setManv(model.getValueAt(i, 2) + "");
            try {
                Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(model.getValueAt(i, 3) + "");
                pp.setNgaylap(date1);
            } catch (ParseException ex) {
                Logger.getLogger(PanelPhieuPhat.class.getName()).log(Level.SEVERE, null, ex);
            }
            pp.setTongtien(Integer.parseInt(model.getValueAt(i, 4) + ""));
            phieuphatBUS.themPhieuPhat(pp, this);
        }
        // TODO add your handling code here:
        jButton13.setVisible(false);
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        try {
            // TODO add your handling code here:
            jTable1.setModel(OutFile.readExcel("system\\database\\data\\phieuphat.xls"));
            jButton13.setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(PanelPhieuPhat.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton16ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAddnhanvien;
    private javax.swing.JButton buttonThemChiTiet;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JTextField tfmuontra;
    private javax.swing.JTextField tfphieuphat;
    private javax.swing.JTextField tftongtien;
    // End of variables declaration//GEN-END:variables

    @Override
    public void onSuccess() {
        loadPhieuPhat();
    }

    @Override
    public void onFailed(String error) {

    }

    private void loadPhieuPhat() {
        String[] header = {"Mã Phiếu Phạt", "Mã Mượn Trả", "Nhân Viên", "Ngày Lập", "Tổng Tiền"};
        dtm = new DefaultTableModel(header, 0);
        arr = phieuphatBUS.getPhieuPhat();
        phieuphatDTO pmt = new phieuphatDTO();
        for (int i = 0; i < arr.size(); i++) {
            pmt = arr.get(i);
            String mapp = pmt.getMaphieuphat();
            String mamt = pmt.getMamuontra();
            String manv = pmt.getManv();
            String tennv = nhanvienBUS.getTenNhanVien(manv);
            int tongtien = pmt.getTongtien();

            Date ngaylap = pmt.getNgaylap();
//            System.out.println("ngày hẹn trả" + ngayhentra);
            Object[] row = {mapp, mamt, tennv, ngaylap, tongtien};
            dtm.addRow(row);
        }
        jTable1.setModel(dtm);
        setView(arr.get(0));
    }

    public void setView(phieuphatDTO pmt) {
        if (jButton6.getText().equals("Thêm") && jButton8.getText().equals("Sửa")) {
            tfphieuphat.setText(pmt.getMaphieuphat() + "");
            tfmuontra.setText(pmt.getMamuontra() + "");
            jTextField3.setText(nhanvienBUS.getTenNhanVien(pmt.getManv()));
            jTextField4.setText(pmt.getNgaylap().toString());
//        jTextField5.setText(pmt.getNgayTra().toString());
            tftongtien.setText(pmt.getTongtien() + "");
            current.setManv(pmt.getManv());
        }
    }

    private void initData() {
        tfmuontra.setEditable(false);
        buttonThemChiTiet.setVisible(false);
        tftongtien.setEditable(false);
        jTextField3.setEditable(false);
        tfphieuphat.setEditable(false);
        jTextField4.setEditable(false);
        tfphieuphat.setEditable(false);
        jButton10.setVisible(false);
        jPanel1.setVisible(false);
        datePicker.setVisible(false);
        datePicker2.setVisible(false);
        jButton13.setVisible(false);
    }

    private void initEvent() {
        jTable1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent event) {
                // do some actions here, for example
                // print first column value from selected row
                try {
                    setView(arr.get(jTable1.getSelectedRow()));
                } catch (Exception e) {
                }
            }
        });
        jTable1.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent mouseEvent) {
                JTable table = (JTable) mouseEvent.getSource();
                Point point = mouseEvent.getPoint();
                int row = table.rowAtPoint(point);
                if (mouseEvent.getClickCount() == 2 && table.getSelectedRow() != -1) {
                    inChangePanelDeal.onChange(arr.get(jTable1.getSelectedRow()).getMaphieuphat());
                }
            }
        });
        jComboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (jComboBox1.getSelectedItem().equals("Ngày Lập")) {
                    //jPanel1.setVisible(true);
                    datePicker.setVisible(true);
                    datePicker2.setVisible(true);
                    jTextField7.setEditable(false);
                    return;
                }

                jTextField7.setEnabled(true);
                //jPanel1.setVisible(false);
                datePicker.setVisible(false);
                datePicker2.setVisible(false);

            }
        });
    }

    @Override
    public void nhanvien(nhanvienDTO tg) {
        jTextField3.setText(tg.getTenNhanVien());
        current.setManv(tg.getMaNV());
        jPanel2.setVisible(true);
        panelNv.setVisible(false);
    }
}
