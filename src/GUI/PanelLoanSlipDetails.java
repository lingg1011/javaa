/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BUS.chitietphieuBUS;
import BUS.chitietphieuphatBUS;
import BUS.docgiaBUS;
import BUS.nhanvienBUS;
import BUS.phieumuontraBUS;
import BUS.sachBUS;
import DTO.chitietphieuDTO;
import DTO.chitietphieuphatDTO;
import DTO.phieumuontraDTO;
import DTO.sachDTO;
import interfaces.InSachSelect;
import interfaces.QueryCallBack;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.SwingUtilities;
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

/**
 *
 * @author Admin
 */
public class PanelLoanSlipDetails extends javax.swing.JPanel implements QueryCallBack, InSachSelect {

    /**
     * Creates new form PanelLoanSlip
     */
    DefaultTableModel dtm;
    ArrayList<chitietphieuDTO> arr = new ArrayList<chitietphieuDTO>();
    JDatePickerImpl datePicker;
    JDatePickerImpl datePicker2;
    JDatePickerImpl datePickerngaytra;
    JDatePickerImpl datePickerhantra;
    UtilDateModel model = new UtilDateModel();
    UtilDateModel model2 = new UtilDateModel();
    UtilDateModel modelngaytra = new UtilDateModel();
    UtilDateModel modelhantra = new UtilDateModel();
    Panelchoosesach panelS;
    String mamuontra;
    chitietphieuDTO current = new chitietphieuDTO();

    int type = 0;

    public PanelLoanSlipDetails(String mamuontra, int type) {
        this.mamuontra = mamuontra;
        this.type = type;
        arr = chitietphieuBUS.getChiTietPhieu();
        initComponents();
        buttonlapphat.setVisible(false);

        panelS = new Panelchoosesach(this);
        panelS.setBackground(new java.awt.Color(102, 102, 102));
        panelS.setForeground(new java.awt.Color(0, 204, 204));
        panelS.setLayout(null);
        panelS.setBounds(0, 0, 1024, 768);
        panelS.setVisible(false);
        add(panelS);

        Properties p = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");

        JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
        JDatePanelImpl datePane2 = new JDatePanelImpl(model2, p);
        JDatePanelImpl datePanengaytra = new JDatePanelImpl(modelngaytra, p);
        JDatePanelImpl datePanehantra = new JDatePanelImpl(modelhantra, p);

        datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
        datePicker.setBounds(10, 130, 120, 25);
        jPanel2.add(datePicker);

        datePicker2 = new JDatePickerImpl(datePane2, new DateLabelFormatter());
        datePicker2.setBounds(280, 130, 120, 25);
        jPanel2.add(datePicker2);

        datePickerhantra = new JDatePickerImpl(datePanehantra, new DateLabelFormatter());

        datePickerhantra.setBounds(760, 10, 30, 30);
        jPanel2.add(datePickerhantra);
        datePickerhantra.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Date today = new Date();
                today.getTime();
                if (modelhantra.getValue().after(today)) {
                    tfhantra.setText(new SimpleDateFormat("yyyy-MM-dd").format(modelhantra.getValue()));
                } else {
                    tfhantra.setText(new SimpleDateFormat("yyyy-MM-dd").format(today));
                }
            }
        });
        datePickerhantra.setVisible(false);

        datePickerngaytra = new JDatePickerImpl(datePanengaytra, new DateLabelFormatter());

        datePickerngaytra.setBounds(760, 90, 30, 30);
        jPanel2.add(datePickerngaytra);
        datePickerngaytra.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
//                try {
                Date today = new Date();
                today.getTime();
//                    if(modelngaytra.getValue().after(new SimpleDateFormat("yyyy-MM-dd").parse(tfhantra.getText().trim()))){
//                        tfngaytra.setText(new SimpleDateFormat("yyyy-MM-dd").format(modelngaytra.getValue()));
//                    }else {
                tfngaytra.setText(new SimpleDateFormat("yyyy-MM-dd").format(today));
//                    }
//                } catch (ParseException ex) {
//                }
            }
        });

        datePickerngaytra.setVisible(false);
        initData();
        initEvent();
        loadChiTiet(mamuontra);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        tfmuontra = new javax.swing.JTextField();
        tfms = new javax.swing.JTextField();
        tfsl = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        tfhantra = new javax.swing.JTextField();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<String>();
        jTextField6 = new javax.swing.JTextField();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        buttonAddSach = new javax.swing.JButton();
        tfmct = new javax.swing.JTextField();
        jButton12 = new javax.swing.JButton();
        tfngaytra = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        buttonlapphat = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(984, 651));

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setLayout(null);

        jButton1.setText("Mã Mượn Trả");
        jPanel2.add(jButton1);
        jButton1.setBounds(10, 53, 130, 25);

        jButton2.setText("Tên Sách");
        jPanel2.add(jButton2);
        jButton2.setBounds(10, 89, 130, 25);

        jButton3.setText("Số  Lượng");
        jPanel2.add(jButton3);
        jButton3.setBounds(10, 125, 130, 25);
        jPanel2.add(tfmuontra);
        tfmuontra.setBounds(143, 53, 221, 25);
        jPanel2.add(tfms);
        tfms.setBounds(146, 89, 221, 25);
        jPanel2.add(tfsl);
        tfsl.setBounds(146, 125, 221, 25);

        jButton4.setText("Hạn Trả");
        jPanel2.add(jButton4);
        jButton4.setBounds(403, 10, 130, 25);
        jPanel2.add(tfhantra);
        tfhantra.setBounds(539, 10, 210, 25);

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setSelected(true);
        jRadioButton1.setText("Chưa Trả");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jRadioButton1);
        jRadioButton1.setBounds(406, 45, 130, 25);

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("Đã Trả");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jRadioButton2);
        jRadioButton2.setBounds(620, 50, 130, 25);

        jButton6.setText("Thêm");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton6);
        jButton6.setBounds(804, 11, 170, 50);

        jButton7.setText("Xóa");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton7);
        jButton7.setBounds(804, 67, 170, 50);

        jButton8.setText("Sửa");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton8);
        jButton8.setBounds(804, 123, 170, 50);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Mã Mượn Trả", "Sách", "Số Lượng", "Đã Trả", "Ngày Trả", "Hạn Trả" }));
        jPanel2.add(jComboBox1);
        jComboBox1.setBounds(10, 184, 120, 30);

        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });
        jPanel2.add(jTextField6);
        jTextField6.setBounds(136, 184, 320, 30);

        jButton10.setText("Tìm Kiếm");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton10);
        jButton10.setBounds(462, 184, 100, 30);

        jButton11.setText("Back");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton11);
        jButton11.setBounds(919, 188, 55, 23);

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
        jScrollPane1.setBounds(10, 220, 964, 402);

        buttonAddSach.setText("jButton9");
        buttonAddSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAddSachActionPerformed(evt);
            }
        });
        jPanel2.add(buttonAddSach);
        buttonAddSach.setBounds(373, 89, 27, 25);
        jPanel2.add(tfmct);
        tfmct.setBounds(146, 10, 221, 25);

        jButton12.setText("Mã Chi Tiết");
        jPanel2.add(jButton12);
        jButton12.setBounds(10, 10, 130, 25);
        jPanel2.add(tfngaytra);
        tfngaytra.setBounds(550, 90, 200, 25);

        jButton5.setText("Ngày Trả");
        jPanel2.add(jButton5);
        jButton5.setBounds(410, 90, 130, 25);

        buttonlapphat.setText("Lập Phiếu Phạt");
        buttonlapphat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonlapphatActionPerformed(evt);
            }
        });
        jPanel2.add(buttonlapphat);
        buttonlapphat.setBounds(470, 130, 220, 40);

        jButton9.setText("Xuất Excel");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton9);
        jButton9.setBounds(10, 160, 110, 23);

        jButton14.setText("Đọc Excel");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton14);
        jButton14.setBounds(140, 160, 110, 23);

        jButton13.setText("Lưu ĐTB");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton13);
        jButton13.setBounds(270, 160, 90, 23);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        if (jButton6.getText().toString().equals("Thêm")) {
            tfsl.setEnabled(true);
            ArrayList<chitietphieuDTO> arr = chitietphieuBUS.getChiTietPhieu();
            tfmct.setText("" + (Integer.parseInt(arr.get(arr.size() - 1).getMaChitiet()) + 1));
            tfmuontra.setText(mamuontra);
            jButton6.setText("Xác nhận thêm");
            jButton6.setVisible(true);
            jButton2.setText("Mã Sách");
            buttonAddSach.setVisible(true);
            jRadioButton1.setSelected(true);
            jRadioButton2.setSelected(false);
            jRadioButton1.setVisible(false);
            jRadioButton2.setVisible(false);
            jButton5.setVisible(false);
//            datePickerngaytra.setVisible(true);
            datePickerhantra.setVisible(true);
            tfngaytra.setVisible(false);
            tfms.setText("");
            tfsl.setEditable(true);
            tfsl.setText("");
            tfhantra.setText("");
            tfngaytra.setText("");
            buttonlapphat.setVisible(false);
        } else {
            if (tfms.getText().length() == 0 || tfsl.getText().length() == 0 || tfhantra.getText().length() == 0) {
                JOptionPane.showMessageDialog(null, "Vui lòng điền đủ thông tin vào bảng");
            } else {
                if(Integer.parseInt(tfsl.getText())<sachBUS.getSoluong(current.getMaSach()))
                {
                    
                tfsl.setEnabled(false);
                buttonlapphat.setVisible(true);
                tfsl.setEditable(false);
                jRadioButton1.setVisible(true);
                jRadioButton2.setVisible(true);
                jButton5.setVisible(true);
                datePickerngaytra.setVisible(false);
                tfngaytra.setVisible(true);

                jButton6.setText("Thêm");
                jButton2.setText("Tên Sách");
                chitietphieuDTO ctp = new chitietphieuDTO();
                ctp.setMaChitiet(tfmct.getText().trim());
                ctp.setMaMuonTra(tfmuontra.getText().trim());
                ctp.setMaSach(current.getMaSach());
                ctp.setSoLuong(Integer.parseInt(tfsl.getText().trim()));
                Date date1 = null, date2 = null;
                try {
                    date1 = new SimpleDateFormat("yyyy-MM-dd").parse(tfhantra.getText().trim());
                    date2 = new SimpleDateFormat("yyyy-MM-dd").parse(tfngaytra.getText().trim());
                } catch (ParseException ex) {

                }
                if (jRadioButton1.isSelected()) {
                    ctp.setDaTra(0);
                } else {
                    ctp.setDaTra(1);
                }
                ctp.setHanTra(date1);
                ctp.setNgayTra(date2);
                chitietphieuBUS.themChiTietPhieu(ctp, this);
                type=1;
                }
                else {
                JOptionPane.showMessageDialog(null, "Không đủ số lượng để cho mượn!");
                type=0;
                }
                if (type == 1) {
                    JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
                    topFrame.dispose();
                }
            
            }

        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        chitietphieuBUS.xoaChiTietPhieu(tfmuontra.getText().trim(), this);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        if (jButton8.getText().toString().equals("Sửa")) {
            tfsl.setEnabled(true);
            if (jRadioButton2.isSelected()) {
                jRadioButton1.setEnabled(false);
                jRadioButton2.setEnabled(false);
                datePickerngaytra.setVisible(false);
                datePickerhantra.setVisible(false);
            } else {

                jRadioButton1.setEnabled(true);
                jRadioButton2.setEnabled(true);
                buttonAddSach.setVisible(true);
                datePickerhantra.setVisible(true);
            }
            jButton8.setText("Xác nhận sửa");
            tfmuontra.setEditable(false);

        } else {
            if (tfms.getText().length() == 0 || tfsl.getText().length() == 0 || tfhantra.getText().length() == 0) {
                JOptionPane.showMessageDialog(null, "Vui lòng điền đủ thông tin vào bảng");
            } else {
                tfsl.setEnabled(false);
                datePickerngaytra.setVisible(false);
                datePickerhantra.setVisible(false);
                buttonAddSach.setVisible(false);

                jButton8.setText("Sửa");
                chitietphieuDTO ctp = new chitietphieuDTO();
                ctp.setMaChitiet(tfmct.getText().trim());
                ctp.setMaMuonTra(tfmuontra.getText().trim());
                ctp.setMaSach(current.getMaSach());
                ctp.setSoLuong(Integer.parseInt(tfsl.getText().trim()));
                Date date1 = null, date2 = null;
                try {
                    date1 = new SimpleDateFormat("yyyy-MM-dd").parse(tfhantra.getText().trim());
                    date2 = new SimpleDateFormat("yyyy-MM-dd").parse(tfngaytra.getText().trim());
                } catch (ParseException ex) {
                }
                if (jRadioButton1.isSelected()) {
                    ctp.setDaTra(0);
                } else {
                    ctp.setDaTra(1);
                }
                ctp.setHanTra(date1);
                ctp.setNgayTra(date2);
                chitietphieuBUS.suaPhieuMuonTra(ctp, this);
            }
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
        loadChiTiet(mamuontra);
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed

        String[] header = {"Mã Mượn Trả", "Mã Sách", "Số Lượng", "Đã Trả", "Ngày Trả", "Hạn Trả"};
        DefaultTableModel dtmsearch = new DefaultTableModel(header, 0);
        ArrayList<chitietphieuDTO> s;
        if (jComboBox1.getSelectedItem().equals("Ngày Trả")) {
            s = chitietphieuBUS.timkiemphieuNT(model.getValue(), model2.getValue());
        } else if (jComboBox1.getSelectedItem().equals("Hạn Trả")) {
            s = chitietphieuBUS.timkiemphieuHT(model.getValue(), model2.getValue());
        } else {
            if (jComboBox1.getSelectedItem() == "Mã Mượn Trả" || jComboBox1.getSelectedItem() == "Số Lượng") {
                if (CheckData.checkNumber(jTextField6.getText().toString().trim())) {
                    s = chitietphieuBUS.timkiemChiTietPhieu(String.valueOf(jComboBox1.getSelectedItem()), jTextField6.getText().toLowerCase().trim());
                } else {
                    JOptionPane.showMessageDialog(null, "Bạn phải nhập số!");
                }
            }
            s = chitietphieuBUS.timkiemChiTietPhieu(String.valueOf(jComboBox1.getSelectedItem()), jTextField6.getText().toLowerCase().trim());
        }
        if (s.size() != 0) {
            chitietphieuDTO ctp = new chitietphieuDTO();
            for (int i = 0; i < s.size(); i++) {
                ctp = s.get(i);
                String chitietmuontra = ctp.getMaChitiet();
                String mamuontra = ctp.getMaMuonTra();
                String tensach = sachBUS.getTenSach(ctp.getMaSach());
                int soluong = ctp.getSoLuong();
                String datra = ctp.getDaTras();
                Date ngaytra = ctp.getNgayTra();
                Date hantra = ctp.getHanTra();
                System.out.println(mamuontra + tensach + soluong + datra + ngaytra + hantra);
                Object[] row = {chitietmuontra, mamuontra, tensach, soluong, datra, ngaytra, hantra};
                dtmsearch.addRow(row);
            }
            jTable1.setModel(dtmsearch);
            setView(s.get(0));
            jButton11.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Không có kết quả phù hợp!");
        }
    }//GEN-LAST:event_jButton10ActionPerformed

    private void buttonAddSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAddSachActionPerformed
        // TODO add your handling code here:
        jPanel2.setVisible(false);
        panelS.setVisible(true);
        revalidate();
    }//GEN-LAST:event_buttonAddSachActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        // TODO add your handling code here:
        tfngaytra.setEditable(false);
        jButton5.setVisible(false);
        datePickerngaytra.setVisible(false);
        tfngaytra.setVisible(false);
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        // TODO add your handling code here:

        tfngaytra.setEditable(false);
        jButton5.setVisible(true);
        datePickerngaytra.setVisible(true);
        tfngaytra.setVisible(true);
        tfhantra.setVisible(true);
        jButton5.setVisible(true);
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void buttonlapphatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonlapphatActionPerformed
        // TODO add your handling code here:
        JFrame phieuphat = new JFrame();
        phieuphat.setVisible(true);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        phieuphat.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
        phieuphat.setSize(1044, 768);
        phieuphat.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {

            }
        });
        PanelPhieuPhat pb = new PanelPhieuPhat(current);
        pb.setBounds(0, 0, 1024, 768);
        phieuphat.add(pb);
    }//GEN-LAST:event_buttonlapphatActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        try {
            OutFile.writeExcel(jTable1, "system\\file\\excel\\chitietphieumuon\\", true);
        } catch (IOException ex) {
            Logger.getLogger(PanelBook.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        try {
            // TODO add your handling code here:
            jTable1.setModel(OutFile.readExcel("system\\database\\data\\loanslipdetails.xls"));
            jButton13.setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(PanelLoanSlipDetails.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        TableModel model = jTable1.getModel();
        for (int i = 0; i < model.getRowCount(); i++) {
            chitietphieuDTO ctp = new chitietphieuDTO();
            ctp.setMaMuonTra(model.getValueAt(i, 1) + "");
            ctp.setMaSach(model.getValueAt(i, 2) + "");
            ctp.setSoLuong(Integer.parseInt(model.getValueAt(i, 3) + ""));
            ctp.setDaTra(Integer.parseInt(model.getValueAt(i, 4) + ""));
            try {
                Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(model.getValueAt(i, 5) + "");
                Date date2 = new SimpleDateFormat("yyyy-MM-dd").parse(model.getValueAt(i, 6) + "");
                ctp.setNgayTra(date1);
                ctp.setHanTra(date2);
            } catch (ParseException ex) {
                Logger.getLogger(PanelLoanSlipDetails.class.getName()).log(Level.SEVERE, null, ex);
            }
            chitietphieuBUS.themChiTietPhieu(ctp, this);

        }
        // TODO add your handling code here:
        jButton13.setVisible(false);
    }//GEN-LAST:event_jButton13ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAddSach;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton buttonlapphat;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField tfhantra;
    private javax.swing.JTextField tfmct;
    private javax.swing.JTextField tfms;
    private javax.swing.JTextField tfmuontra;
    private javax.swing.JTextField tfngaytra;
    private javax.swing.JTextField tfsl;
    // End of variables declaration//GEN-END:variables

    private void loadChiTiet(String mamuontr) {

        String[] header = {"Mã Chi Tiết", "Mã Mượn Trả", "Tên Sách", "Số Lượng", "Đã Trả", "Ngày Trả", "Hạn Trả"};

        dtm = new DefaultTableModel(header, 0);
        arr = chitietphieuBUS.getChiTietPhieu();
        chitietphieuDTO ctp = new chitietphieuDTO();
        if (mamuontr == null) {
            for (int i = 0; i < arr.size(); i++) {
                ctp = arr.get(i);
                String chitietmuontra = ctp.getMaChitiet();
                String mamuontra = ctp.getMaMuonTra();
                String tensach = sachBUS.getTenSach(ctp.getMaSach());
                int soluong = ctp.getSoLuong();
                String datra = ctp.getDaTras();
                Date ngaytra = ctp.getNgayTra();
                Date hantra = ctp.getHanTra();
                // System.out.println(mamuontra + tensach + soluong + datra + ngaytra + hantra);
                Object[] row = {chitietmuontra, mamuontra, tensach, soluong, datra, ngaytra, hantra};
                dtm.addRow(row);
            }
            jTable1.setModel(dtm);
            setView(arr.get(0));
        } else {
            if (type == 0) {
                for (int i = arr.size() - 1; i >= 0; i--) {
                    if (!arr.get(i).getMaMuonTra().equals(mamuontra)) {
                        arr.remove(i);
                    }

                }
                int k = -1;
                for (int i = 0; i < arr.size(); i++) {
                    ctp = arr.get(i);
                    String chitietmuontra = ctp.getMaChitiet();
                    String mamuontra = ctp.getMaMuonTra();
                    String tensach = sachBUS.getTenSach(ctp.getMaSach());
                    int soluong = ctp.getSoLuong();
                    String datra = ctp.getDaTras();
                    Date ngaytra = ctp.getNgayTra();
                    Date hantra = ctp.getHanTra();
                    // System.out.println(mamuontra + tensach + soluong + datra + ngaytra + hantra);
                    if (mamuontra.equals(mamuontr)) {
                        if (k == -1) {
                            k = i;
                        }
                        Object[] row = {chitietmuontra, mamuontra, ctp.getMaSach(), soluong, datra, ngaytra, hantra};
                        dtm.addRow(row);
                    }

                }
                jTable1.setModel(dtm);
                setView(arr.get(k));
            } else {

                jButton5.setVisible(false);
                datePickerngaytra.setVisible(false);
                tfngaytra.setVisible(false);
                for (int i = 0; i < arr.size(); i++) {
                    ctp = arr.get(i);
                    String chitietmuontra = ctp.getMaChitiet();
                    String mamuontra = ctp.getMaMuonTra();
                    String tensach = sachBUS.getTenSach(ctp.getMaSach());
                    int soluong = ctp.getSoLuong();
                    String datra = ctp.getDaTras();
                    Date ngaytra = ctp.getNgayTra();
                    Date hantra = ctp.getHanTra();
                    // System.out.println(mamuontra + tensach + soluong + datra + ngaytra + hantra);
                    Object[] row = {chitietmuontra, mamuontra, ctp.getMaSach(), soluong, datra, ngaytra, hantra};
                    dtm.addRow(row);
                }
                jTable1.setModel(dtm);
                setView(arr.get(0));
                jButton6.doClick();
                tfmuontra.setText(mamuontr);

            }

        }
    }

    public void setView(chitietphieuDTO ctp) {
        if (jButton6.getText().equals("Thêm") && jButton8.getText().equals("Sửa")) {
            tfmuontra.setText(ctp.getMaMuonTra() + "");

            tfmct.setText(ctp.getMaChitiet());
            tfmuontra.setText(ctp.getMaMuonTra());
            tfms.setText(sachBUS.getTenSach(ctp.getMaSach()));
            tfhantra.setText(ctp.getHanTra().toString());
            tfsl.setText(ctp.getSoLuong().toString());

            if (ctp.getDaTra() == 1) {

                tfngaytra.setText(ctp.getNgayTra().toString());
                jRadioButton2.setEnabled(false);
                jRadioButton1.setEnabled(false);
                jRadioButton2.setSelected(true);
                buttonlapphat.setVisible(true);

                jButton5.setVisible(true);
                tfngaytra.setVisible(true);
                tfngaytra.setEditable(false);
                tfhantra.setEditable(false);
            } else {

                buttonlapphat.setVisible(false);
                tfngaytra.setEditable(true);
                jButton5.setVisible(false);
                tfngaytra.setVisible(false);
                jRadioButton1.setSelected(true);
            }
            current.setSoLuong(ctp.getSoLuong());
            current.setMaMuonTra(ctp.getMaMuonTra());
            current.setMaSach(ctp.getMaSach());
        }
    }

    private void initData() {
        tfsl.setEnabled(false);
        jButton13.setVisible(false);
        tfngaytra.setEditable(false);
        tfhantra.setEditable(false);
        tfmct.setEnabled(false);
        tfms.setEnabled(false);
        tfmuontra.setEnabled(false);
        jButton6.setVisible(false);
        buttonAddSach.setVisible(false);
        jRadioButton1.setSelected(true);
        datePicker.setVisible(false);
        datePicker2.setVisible(false);
        datePickerngaytra.setVisible(false);
        jButton11.setVisible(false);
    }

    private void initEvent() {
        jTable1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent event) {
                try {
                    if (type == 0) {
                        setView(arr.get(jTable1.getSelectedRow()));
                    }
                } catch (Exception e) {
                }
            }
        });
        jComboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (jComboBox1.getSelectedItem().equals("Ngày Trả") || jComboBox1.getSelectedItem().equals("Hạn Trả")) {
                    jTextField6.setEnabled(false);
                    datePicker.setVisible(true);
                    datePicker2.setVisible(true);
                    jTextField6.setEnabled(false);
                    return;
                }

                jTextField6.setEnabled(true);
                jTextField6.setEnabled(true);
                //jPanel1.setVisible(false);
                datePicker.setVisible(false);
                datePicker2.setVisible(false);

            }
        });
    }

    @Override
    public void onSuccess() {
        loadChiTiet(mamuontra);
    }

    @Override
    public void onFailed(String error) {
        tfmuontra.setText(error);
    }

    @Override
    public void sach(sachDTO tg) {

        tfms.setText(tg.getTenSach());
        current.setMaSach(tg.getMaSach());
        jPanel2.setVisible(true);
        panelS.setVisible(false);
    }
}
