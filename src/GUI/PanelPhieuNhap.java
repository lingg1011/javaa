
package GUI;

import BUS.chitietphieunhapBUS;
import BUS.nhaccBUS;
import BUS.nhanvienBUS;
import BUS.phieumuontraBUS;
import BUS.phieunhapBUS;
import BUS.sachBUS;
import DTO.chitietphieunhapDTO;
import DTO.nhaccDTO;
import DTO.nhanvienDTO;
import DTO.phieunhapDTO;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.sun.webkit.ThemeClient;
import interfaces.InChangePanelDeal;
import interfaces.InDocGiaSelect;
import interfaces.InNhaCCSelect;
import interfaces.InNhanVienSelect;
import interfaces.QueryCallBack;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
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
public class PanelPhieuNhap extends javax.swing.JPanel implements QueryCallBack, InNhanVienSelect, InNhaCCSelect {

    DefaultTableModel dtm;
    ArrayList<phieunhapDTO> arr = new ArrayList<>();
    JDatePickerImpl datePicker;
    JDatePickerImpl datePicker2;
    JDatePickerImpl datePickerngaynhap;
    UtilDateModel model = new UtilDateModel();
    UtilDateModel model2 = new UtilDateModel();
    UtilDateModel modelngaynhap = new UtilDateModel();
    Panelchoosenhanvien panelNv;
    PanelNhaCC panelNcc;
    InChangePanelDeal inChangePanelDeal;
    phieunhapDTO current = new phieunhapDTO();

    public PanelPhieuNhap(InChangePanelDeal inChangePanelDeal) {
        initComponents();
        this.inChangePanelDeal = inChangePanelDeal;
        buttonAddnhanvien.setVisible(false);
        buttonAddnhacc.setVisible(false);
        tftongtien.setEditable(false);
        tfnv.setEditable(false);
        tfncc.setEditable(false);
//        jButton13.setVisible(false);

        panelNv = new Panelchoosenhanvien(this);
        panelNv.setBackground(new java.awt.Color(102, 102, 102));
        panelNv.setForeground(new java.awt.Color(0, 204, 204));
        panelNv.setLayout(null);
        panelNv.setBounds(0, 0, 1024, 768);
        panelNv.setVisible(false);
        add(panelNv);

        panelNcc = new PanelNhaCC(this);
        panelNcc.setBackground(new java.awt.Color(102, 102, 102));
        panelNcc.setForeground(new java.awt.Color(0, 204, 204));
        panelNcc.setLayout(null);
        panelNcc.setBounds(0, 0, 1024, 768);
        panelNcc.setVisible(false);
        add(panelNcc);

        Properties p = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");

        JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
        JDatePanelImpl datePane2 = new JDatePanelImpl(model2, p);
        JDatePanelImpl datePanengaynhap = new JDatePanelImpl(modelngaynhap, p);

        datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
//        datePicker.setBounds(10, 130, 120, 25);

        datePicker.setBounds(50, 0, 150, 40);
        jPanel1.add(datePicker);

        datePicker2 = new JDatePickerImpl(datePane2, new DateLabelFormatter());
//        datePicker2.setBounds(280, 130, 120, 25);

        datePicker2.setBounds(250, 0, 170, 40);
        jPanel1.add(datePicker2);

        datePickerngaynhap = new JDatePickerImpl(datePanengaynhap, new DateLabelFormatter());
//        datePickerngaynhap.setBounds(767, 10, 20, 25);

        datePickerngaynhap.setBounds(380, 200, 33, 30);
        jPanel3.add(datePickerngaynhap);
        datePickerngaynhap.setVisible(false);
        datePickerngaynhap.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Date today = new Date();
                today.getTime();
                if (modelngaynhap.getValue().before(today)) {
                    tfngaynhap.setText(new SimpleDateFormat("yyyy-MM-dd").format(modelngaynhap.getValue()));
                } else {
                    tfngaynhap.setText(new SimpleDateFormat("yyyy-MM-dd").format(today));
                }
//                tfngaynhap.setText(new SimpleDateFormat("yyyy-MM-dd").format(modelngaynhap.getValue()));
            }
        });

        loadPhieuNhap();
        initData();
        initEvent();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jButton11 = new javax.swing.JButton();
        tfphieunhap = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        tfnv = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        tfncc = new javax.swing.JTextField();
        buttonAddnhanvien = new javax.swing.JButton();
        buttonAddnhacc = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        tfngaynhap = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        tftongtien = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jTextField7 = new javax.swing.JTextField();
        jButton9 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        buttonThemChiTiet = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setPreferredSize(new java.awt.Dimension(685, 795));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(685, 795));
        jPanel2.setLayout(null);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin phiếu nhập", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 102, 102))); // NOI18N
        jPanel3.setForeground(new java.awt.Color(0, 102, 102));
        jPanel3.setLayout(null);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 0, 0));
        jLabel3.setText("Phiếu Nhập");
        jPanel3.add(jLabel3);
        jLabel3.setBounds(16, 16, 223, 22);

        jButton11.setText("Mã Phiếu Nhập");
        jPanel3.add(jButton11);
        jButton11.setBounds(16, 70, 130, 23);
        jPanel3.add(tfphieunhap);
        tfphieunhap.setBounds(152, 69, 212, 25);

        jButton2.setText("Nhân Viên");
        jPanel3.add(jButton2);
        jButton2.setBounds(16, 113, 130, 23);
        jPanel3.add(tfnv);
        tfnv.setBounds(152, 112, 212, 25);

        jButton4.setText("Nhà Cung Cấp");
        jPanel3.add(jButton4);
        jButton4.setBounds(16, 156, 130, 23);

        tfncc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfnccActionPerformed(evt);
            }
        });
        jPanel3.add(tfncc);
        tfncc.setBounds(152, 155, 212, 25);

        buttonAddnhanvien.setText("jButton13");
        buttonAddnhanvien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAddnhanvienActionPerformed(evt);
            }
        });
        jPanel3.add(buttonAddnhanvien);
        buttonAddnhanvien.setBounds(380, 110, 33, 30);

        buttonAddnhacc.setText("jButton13");
        buttonAddnhacc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAddnhaccActionPerformed(evt);
            }
        });
        jPanel3.add(buttonAddnhacc);
        buttonAddnhacc.setBounds(380, 153, 33, 30);

        jButton3.setText("Ngày Nhập");
        jPanel3.add(jButton3);
        jButton3.setBounds(16, 199, 130, 23);
        jPanel3.add(tfngaynhap);
        tfngaynhap.setBounds(152, 198, 212, 25);

        jButton5.setText("Tổng Tiền");
        jPanel3.add(jButton5);
        jButton5.setBounds(16, 242, 130, 23);
        jPanel3.add(tftongtien);
        tftongtien.setBounds(152, 241, 212, 25);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        jLabel2.setText("Đến");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(210, 0, 50, 40);

        jLabel4.setText("Từ");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(0, 0, 40, 40);

        jPanel3.add(jPanel1);
        jPanel1.setBounds(20, 320, 420, 40);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mã Phiếu Nhập", "Nhân Viên", "Nhà Cung Cấp", "Ngày Nhập" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        jPanel3.add(jComboBox1);
        jComboBox1.setBounds(16, 284, 96, 30);
        jPanel3.add(jTextField7);
        jTextField7.setBounds(136, 284, 228, 30);

        jButton9.setText("Tìm Kiếm");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton9);
        jButton9.setBounds(370, 284, 90, 30);

        jButton13.setText("Xuất Excel");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton13);
        jButton13.setBounds(20, 40, 110, 23);

        jButton14.setText("Xuất PDF");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton14);
        jButton14.setBounds(150, 30, 90, 23);

        jButton15.setText("Đọc Excel");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton15);
        jButton15.setBounds(270, 30, 100, 23);

        jButton1.setText("Lưu ĐTB");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton1);
        jButton1.setBounds(390, 30, 73, 23);

        jPanel2.add(jPanel3);
        jPanel3.setBounds(0, 0, 490, 380);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thực hiện", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 0, 51))); // NOI18N

        jButton6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton6.setText("Thêm");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton7.setText("Xóa");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton8.setText("Sửa");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        buttonThemChiTiet.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        buttonThemChiTiet.setText("Thêm Chi Tiết");
        buttonThemChiTiet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonThemChiTietActionPerformed(evt);
            }
        });

        jButton10.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton10.setText("Back");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jButton7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonThemChiTiet, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jButton6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                    .addComponent(jButton8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonThemChiTiet, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel4);
        jPanel4.setBounds(486, 0, 180, 380);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh sách phiếu nhập", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 0, 102))); // NOI18N

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

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 634, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 365, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.add(jPanel5);
        jPanel5.setBounds(0, 386, 666, 410);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 793, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 11, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonAddnhaccActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAddnhaccActionPerformed
        jPanel2.setVisible(false);
        panelNcc.setVisible(true);
        revalidate();
    }//GEN-LAST:event_buttonAddnhaccActionPerformed

    private void tfnccActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfnccActionPerformed

    }//GEN-LAST:event_tfnccActionPerformed

    private void buttonAddnhanvienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAddnhanvienActionPerformed
    jPanel2.setVisible(false);
        panelNv.setVisible(true);
        revalidate();
    }//GEN-LAST:event_buttonAddnhanvienActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        jTable1.setModel(dtm);
        jButton10.setVisible(false);
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed

        String[] header = {"Mã Phiếu Nhập", "Nhân Viên", "Nhà Cung Cấp", "Ngày Nhập", "Tổng Tiền"};
        DefaultTableModel dtmsearch = new DefaultTableModel(header, 0);
        ArrayList<phieunhapDTO> s;
        if (jComboBox1.getSelectedItem().equals("Ngày Nhập")) {
            s = phieunhapBUS.timkiemphieuNM(model.getValue(), model2.getValue());
        } else {
            if (jComboBox1.getSelectedItem().equals("Mã Phiếu Nhập")) {
                if (CheckData.checkNumber(jTextField7.getText().toString().trim())) {
                    s = phieunhapBUS.timkiemPhieuNhap(String.valueOf(jComboBox1.getSelectedItem()), jTextField7.getText().toLowerCase().trim());
                } else {
                    JOptionPane.showMessageDialog(null, "Bạn phải nhập số!");
                }
            }
            s = phieunhapBUS.timkiemPhieuNhap(String.valueOf(jComboBox1.getSelectedItem()), jTextField7.getText().toLowerCase().trim());
        }
        if (s.size() != 0) {
            phieunhapDTO pmt = new phieunhapDTO();
            for (int i = 0; i < s.size(); i++) {
                pmt = s.get(i);
                String mapn = pmt.getMaphieuphap();
                String manv = pmt.getManv();
                String mancc = pmt.getManhacc();
                int tongtien = pmt.getTongtien();
                Date ngaynhap = pmt.getNgaynhap();
                //            System.out.println("ngày hẹn trả" + ngayhentra);
                Object[] row = {mapn, nhanvienBUS.getTenNhanVien(manv), nhaccBUS.gettenNhacc(mancc), ngaynhap, tongtien};
                dtmsearch.addRow(row);
            }
            jTable1.setModel(dtmsearch);
            setView(s.get(0));
            jButton10.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Không có kết quả phù hợp!");
        }
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        if (jButton8.getText().toString().equals("Sửa")) {
//            buttonAddnhanvien.setVisible(true);
            buttonAddnhacc.setVisible(true);
            datePickerngaynhap.setVisible(true);
            //        jButton13.setVisible(true);
            jButton8.setText("Xác nhận sửa");
            buttonThemChiTiet.setVisible(true);

            jButton6.setVisible(false);
            jButton7.setVisible(false);
//            tfphieunhap.setEditable(false);
        } else {

            buttonAddnhanvien.setVisible(false);
            buttonAddnhacc.setVisible(false);
            datePickerngaynhap.setVisible(false);
//            tfphieunhap.setEditable(true);
            buttonThemChiTiet.setVisible(false);

            jButton6.setVisible(true);
            jButton7.setVisible(true);
            jButton8.setText("Sửa");
            phieunhapDTO ctp = new phieunhapDTO();
            ctp.setMaphieuphap(tfphieunhap.getText().trim());
            ctp.setManv(current.getManv());
            ctp.setManhacc(current.getManhacc());
            ctp.setTongtien(Integer.parseInt(tftongtien.getText().trim()));
            Date date1 = null, date2 = null;
            try {
                date1 = new SimpleDateFormat("yyyy-MM-dd").parse(tfngaynhap.getText().trim());
                //               date2 = new SimpleDateFormat("dd/MM/yyyy").parse(jTextField5.getText().trim());
            } catch (ParseException ex) {
                Logger.getLogger(PanelLoanSlipDetails.class.getName()).log(Level.SEVERE, null, ex);
            }
            ctp.setNgaynhap(date1);
            //            ctp.setNgayTra(date2);
            phieunhapBUS.suaPhieuNhap(ctp, this);
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        phieunhapBUS.xoaPhieuNhap(tfphieunhap.getText().toString().trim(), this);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        if (jButton6.getText().toString().equals("Thêm")) {

//            buttonAddnhanvien.setVisible(true);
            buttonAddnhacc.setVisible(true);
            datePickerngaynhap.setVisible(true);
            jButton7.setVisible(false);
            jButton8.setVisible(false);
            //        jButton13.setVisible(true);
            ArrayList<phieunhapDTO> arr = phieunhapBUS.getPhieuNhap();
            tfphieunhap.setText("" + (Integer.parseInt(arr.get(arr.size() - 1).getMaphieuphap()) + 1));
            jButton6.setText("Xác nhận thêm");
            buttonThemChiTiet.setVisible(true);
            Date today = new Date();
            today.getTime();
            tfngaynhap.setText(new SimpleDateFormat("yyyy-MM-dd").format(today));
            tfnv.setText(cons.nv.getTenNhanVien());
            current.setManv(cons.nv.getMaNV());
            tfncc.setText("");
            tftongtien.setText("");
            //        jTextField5.setText("");
        } else {
            if (tftongtien.getText().length() != 0) {

                buttonAddnhanvien.setVisible(false);
                buttonAddnhacc.setVisible(false);
                datePickerngaynhap.setVisible(false);
                buttonThemChiTiet.setVisible(false);
                jButton6.setText("Thêm");
                jButton7.setVisible(true);
                jButton8.setVisible(true);
                phieunhapDTO ctp = new phieunhapDTO();
                ctp.setMaphieuphap(tfphieunhap.getText().trim());
                ctp.setManv(current.getManv());
                ctp.setManhacc(current.getManhacc());
                ctp.setTongtien(Integer.parseInt(tftongtien.getText().trim()));
                Date date1 = null, date2 = null;
                try {
                    date1 = new SimpleDateFormat("yyyy-MM-dd").parse(tfngaynhap.getText().trim());
                    //               date2 = new SimpleDateFormat("dd/MM/yyyy").parse(jTextField5.getText().trim());
                } catch (ParseException ex) {
                    Logger.getLogger(PanelLoanSlipDetails.class.getName()).log(Level.SEVERE, null, ex);
                }
                ctp.setNgaynhap(date1);
                //            ctp.setNgayTra(date2);
                phieunhapBUS.themPhieuNhap(ctp, this);
            } else {
                JOptionPane.showMessageDialog(null, "Bạn cần nhập vào chi tiết phiếu nhập");

            }
        }
    }//GEN-LAST:event_jButton6ActionPerformed

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
                tftongtien.setText(chitietphieunhapBUS.getTongTien(tfphieunhap.getText().toString().trim()) + "");

            }
        });
//          themchitiet.addWindowListener(new java.awt.event.WindowAdapter() {
//              
//        @Override
//        public void windowClosing(java.awt.event.WindowEvent windowEvent) {
//          }
//    });
        PanelChiTietPhieuNhap pb = new PanelChiTietPhieuNhap(tfphieunhap.getText().trim(), 1);
        pb.setBounds(0, 0, 1024, 768);
        themchitiet.add(pb);
    }//GEN-LAST:event_buttonThemChiTietActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        // TODO add your handling code here:
        try {
            OutFile.writeExcel(jTable1, "system\\file\\excel\\phieunhap\\", true);
        } catch (IOException ex) {
            Logger.getLogger(PanelBook.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        // TODO add your handling code here:
        Document document = new Document();

        try {
            // khởi tạo một PdfWriter truyền vào document và FileOutputStream
            PdfWriter.getInstance(document, new FileOutputStream(OutFile.createFilePDF("system\\file\\pdf\\phieunhap\\")));

            // mở file để thực hiện viết
            document.open();
            // thêm nội dung sử dụng add function
            document.add(new Paragraph(OutFile.removeAccent("Phiếu Nhập ")));
            document.add(new Paragraph(OutFile.removeAccent("Mã Phiếu Nhập: " + tfphieunhap.getText())));
            document.add(new Paragraph(OutFile.removeAccent("Nhân Viên: " + tfnv.getText())));
            document.add(new Paragraph(OutFile.removeAccent("Nhà Cung Cấp: " + tfncc.getText())));
            document.add(new Paragraph(OutFile.removeAccent("Ngày Nhập: " + String.valueOf(tfngaynhap.getText()))));
            document.add(new Paragraph(OutFile.removeAccent("Danh sách các loại sách được nhập")));
            PdfPTable table = new PdfPTable(3);
            PdfPCell header1 = new PdfPCell(new Paragraph("Ten Sach"));
            PdfPCell header2 = new PdfPCell(new Paragraph("So Luong"));
            PdfPCell header3 = new PdfPCell(new Paragraph("Đon Gia"));
            table.addCell(header1);
            table.addCell(header2);
            table.addCell(header3);
            ArrayList<chitietphieunhapDTO> ctpn = chitietphieunhapBUS.getChiTietPhieuNhap();
            for (int i = 0; i < ctpn.size(); i++) {
                if (ctpn.get(i).getMaphieunhap().equals(tfphieunhap.getText())) {
                    String tensach = sachBUS.getTenSach(ctpn.get(i).getMasach());
                    PdfPCell data1 = new PdfPCell(new Paragraph(OutFile.removeAccent(tensach)));
                    PdfPCell data2 = new PdfPCell(new Paragraph(ctpn.get(i).getSoluong()));
                    PdfPCell data3 = new PdfPCell(new Paragraph(ctpn.get(i).getDongia()));
                    table.addCell(data1);
                    table.addCell(data2);
                    table.addCell(data3);
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
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        try {
            // TODO add your handling code here:
            jTable1.setModel(OutFile.readExcel("system\\database\\data\\phieunhap.xls"));
            jButton1.setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(PanelPhieuNhap.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        TableModel model = jTable1.getModel();
        for (int i = 0; i < model.getRowCount(); i++) {
            phieunhapDTO pn = new phieunhapDTO();
            pn.setManv(model.getValueAt(i, 1) + "");
            pn.setManhacc(model.getValueAt(i, 2) + "");
            try {
                Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(model.getValueAt(i, 3) + "");
                pn.setNgaynhap(date1);
            } catch (ParseException ex) {
                Logger.getLogger(PanelPhieuNhap.class.getName()).log(Level.SEVERE, null, ex);
            }
            pn.setTongtien(Integer.parseInt(model.getValueAt(i, 4) + ""));
            phieunhapBUS.themPhieuNhap(pn, this);
        }
        // TODO add your handling code here:
        jButton1.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAddnhacc;
    private javax.swing.JButton buttonAddnhanvien;
    private javax.swing.JButton buttonThemChiTiet;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField tfncc;
    private javax.swing.JTextField tfngaynhap;
    private javax.swing.JTextField tfnv;
    private javax.swing.JTextField tfphieunhap;
    private javax.swing.JTextField tftongtien;
    // End of variables declaration//GEN-END:variables

    @Override
    public void onSuccess() {
        loadPhieuNhap();
    }

    @Override
    public void onFailed(String error) {

    }

    private void loadPhieuNhap() {
        String[] header = {"Mã Phiếu Nhập", "Nhân Viên", "Nhà Cung Cấp", "Ngày Nhập", "Tổng Tiền"};
        dtm = new DefaultTableModel(header, 0);
        arr = phieunhapBUS.getPhieuNhap();
        phieunhapDTO pmt = new phieunhapDTO();
        for (int i = 0; i < arr.size(); i++) {
            pmt = arr.get(i);
            String mapp = pmt.getMaphieuphap();
            String manv = pmt.getManv();
            String mancc = pmt.getManhacc();
            int tongtien = pmt.getTongtien();

            Date ngaynhap = pmt.getNgaynhap();
//            System.out.println("ngày hẹn trả" + ngayhentra);
            Object[] row = {mapp, nhanvienBUS.getTenNhanVien(manv), nhaccBUS.gettenNhacc(mancc), ngaynhap, tongtien};
            dtm.addRow(row);
        }
        jTable1.setModel(dtm);
        setView(arr.get(0));
    }

    public void setView(phieunhapDTO pmt) {
        if (jButton6.getText().equals("Thêm") && jButton8.getText().equals("Sửa")) {
            tfphieunhap.setText(pmt.getMaphieuphap() + "");
            tfnv.setText(nhanvienBUS.getTenNhanVien(pmt.getManv()));
            tfncc.setText(nhaccBUS.gettenNhacc(pmt.getManhacc()));
            tfngaynhap.setText(pmt.getNgaynhap().toString());
//        jTextField5.setText(pmt.getNgayTra().toString());
            tftongtien.setText(pmt.getTongtien() + "");
            current.setManv(pmt.getManv());
            current.setManhacc(pmt.getManhacc());
        }
    }

    private void initData() {
        tfphieunhap.setEditable(false);
        buttonThemChiTiet.setVisible(false);
        tfphieunhap.setEditable(false);
        tfngaynhap.setEditable(false);
        jButton10.setVisible(false);
        jPanel1.setVisible(false);
        jButton1.setVisible(false);
//        datePicker.setVisible(false);
//        datePicker2.setVisible(false);
    }

    private void initEvent() {
        jTable1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent event) {
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
                    inChangePanelDeal.onChange(arr.get(jTable1.getSelectedRow()).getMaphieuphap());
                }
            }
        });
        jComboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                jTextField7.setEnabled(false);
                if (jComboBox1.getSelectedItem().equals("Ngày Nhập")) {
                    jPanel1.setVisible(true);
//                    datePicker.setVisible(true);
//                    datePicker2.setVisible(true);
//                    jTextField7.setEnabled(false);
                    return;
                }

                jTextField7.setEditable(true);
//                jTextField7.setEnabled(true);
                jPanel1.setVisible(false);
//                datePicker.setVisible(false);
//                datePicker2.setVisible(false);

            }
        });
    }

    @Override
    public void nhanvien(nhanvienDTO tg) {
        tfnv.setText(tg.getTenNhanVien());
        jPanel2.setVisible(true);
        panelNv.setVisible(false);
        current.setManv(tg.getMaNV());
    }

    @Override
    public void nhacc(nhaccDTO tg) {
        tfncc.setText(tg.getTenncc());
        jPanel2.setVisible(true);
        panelNcc.setVisible(false);
        current.setManhacc(tg.getMancc());
    }

}
