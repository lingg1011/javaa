package GUI;

import BUS.docgiaBUS;
import BUS.nhanvienBUS;
import BUS.sachBUS;
import DTO.nhanvienDTO;
import DTO.sachDTO;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import interfaces.QueryCallBack;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
//import com.itextpdf.text.Document;
//import com.itextpdf.text.DocumentException;
//import com.itextpdf.text.Font;
//import com.itextpdf.text.Paragraph;
//import com.itextpdf.text.pdf.BaseFont;
//import com.itextpdf.text.pdf.PdfWriter;
//import com.itextpdf.text.pdf.PdfPCell;
//import com.itextpdf.text.pdf.PdfPTable;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JOptionPane;
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

public class PanelEmployees extends javax.swing.JPanel implements QueryCallBack {

    DefaultTableModel dtm;
    ArrayList<nhanvienDTO> arr = new ArrayList<nhanvienDTO>();
    UtilDateModel model = new UtilDateModel();
    UtilDateModel model2 = new UtilDateModel();
    UtilDateModel model3 = new UtilDateModel();
    JDatePickerImpl datePicker;
    JDatePickerImpl datePicker2;
    JDatePickerImpl datePicker3;

    public PanelEmployees() {
        initComponents();
        Properties p = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");
        JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
        JDatePanelImpl datePane2 = new JDatePanelImpl(model2, p);
        JDatePanelImpl datePane3 = new JDatePanelImpl(model3, p);
        // Don't know about the formatter, but there it is...

        datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());

        datePicker.setBounds(500, 230, 120, 30);
        jPanel2.add(datePicker);

        datePicker2 = new JDatePickerImpl(datePane2, new DateLabelFormatter());
        datePicker2.setBounds(660, 230, 120, 30);
        jPanel2.add(datePicker2);

        datePicker3 = new JDatePickerImpl(datePane3, new DateLabelFormatter());

        datePicker3.setBounds(320, 180, 30, 30);
        jPanel2.add(datePicker3);
        datePicker3.setVisible(false);
        datePicker3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                jTextField4.setText(new SimpleDateFormat("yyyy-MM-dd").format(model3.getValue()));
            }
        });
        jButton9.setVisible(true);
        loadNhanVien();
        initData();
        initEvent();
    }

    private void initData() {
        jTextField3.setEnabled(false);
        jTextField5.setEnabled(false);
        jTextField7.setEnabled(false);
        jButton16.setVisible(false);
        jTextField4.setEditable(false);
        jTextField2.setEditable(false);
        jButton12.setVisible(false);
        jLabel1.setVisible(false);
        jLabel2.setVisible(false);
        datePicker.setVisible(false);
        datePicker2.setVisible(false);
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
        jComboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (jComboBox1.getSelectedItem().equals("Ngày Sinh")) {
                    jTextField1.setEnabled(false);
                    jLabel1.setVisible(true);
                    jLabel2.setVisible(true);
                    datePicker.setVisible(true);
                    datePicker2.setVisible(true);
                    return;
                }

                jTextField1.setEditable(true);
                jLabel1.setVisible(false);
                jLabel2.setVisible(false);
                datePicker.setVisible(false);
                datePicker2.setVisible(false);

            }
        });

    }

    public void loadNhanVien() {
        String[] header = {"Mã Nhân Viên", "Tên Nhân Viên", "Ngày Sinh", "SĐT", "Địa Chỉ"};

        dtm = new DefaultTableModel(header, 0);
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
        setView(arr.get(0));

    }

    public void setView(nhanvienDTO nv) {
        if (jButton1.getText().equals("Thêm") && jButton3.getText().equals("Sửa")) {
            jTextField2.setText(nv.getMaNV() + "");
        }
        jTextField3.setText(nv.getTenNhanVien());
        jTextField4.setText(nv.getNgaysinh().toString());
        jTextField5.setText(nv.getSdt());
        jTextField7.setText(nv.getDiaChi() + "");
    }

    @Override
    public void onSuccess() {
        loadNhanVien();
    }

    @Override
    public void onFailed(String error) {

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        jTextField3 = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();
        jTextField4 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<String>();
        jTextField1 = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jTextField5 = new javax.swing.JTextField();
        jButton10 = new javax.swing.JButton();
        jTextField7 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton14 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton11 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(0, 204, 204));
        jPanel1.setPreferredSize(new java.awt.Dimension(649, 820));
        jPanel1.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin nhân viên", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(51, 0, 153))); // NOI18N
        jPanel2.setLayout(null);

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 0, 51));
        jLabel3.setText("Nhân Viên");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(164, 16, 268, 29);

        jButton5.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jButton5.setText("Mã Nhân Viên");
        jPanel2.add(jButton5);
        jButton5.setBounds(16, 82, 130, 38);

        jTextField2.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        jPanel2.add(jTextField2);
        jTextField2.setBounds(152, 85, 160, 25);

        jButton6.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jButton6.setText("Tên Nhân Viên");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton6);
        jButton6.setBounds(16, 138, 130, 34);

        jTextField3.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jPanel2.add(jTextField3);
        jTextField3.setBounds(152, 138, 160, 25);

        jButton7.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jButton7.setText("Ngày Sinh");
        jPanel2.add(jButton7);
        jButton7.setBounds(16, 181, 130, 38);

        jTextField4.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jPanel2.add(jTextField4);
        jTextField4.setBounds(152, 178, 160, 30);

        jComboBox1.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Mã Nhân Viên", "Tên Nhân Viên", "Ngày Sinh", "SĐT", "Địa Chỉ" }));
        jPanel2.add(jComboBox1);
        jComboBox1.setBounds(20, 230, 120, 35);

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jPanel2.add(jTextField1);
        jTextField1.setBounds(150, 230, 160, 30);

        jButton4.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jButton4.setText("Tìm Kiếm");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton4);
        jButton4.setBounds(340, 230, 120, 30);

        jButton8.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jButton8.setText("Số Điện Thoại");
        jPanel2.add(jButton8);
        jButton8.setBounds(360, 80, 130, 36);

        jTextField5.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jPanel2.add(jTextField5);
        jTextField5.setBounds(510, 90, 150, 25);

        jButton10.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jButton10.setText("Địa Chỉ");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton10);
        jButton10.setBounds(360, 130, 130, 33);

        jTextField7.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jPanel2.add(jTextField7);
        jTextField7.setBounds(510, 130, 150, 25);

        jLabel1.setText("Từ");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(480, 230, 20, 30);

        jLabel2.setText("Đến");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(630, 230, 20, 30);

        jButton14.setText("Xuất Excel");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton14);
        jButton14.setBounds(20, 290, 110, 23);

        jButton9.setText("Xuất PDF");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton9);
        jButton9.setBounds(170, 290, 120, 23);

        jButton15.setText("Đọc Excel");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton15);
        jButton15.setBounds(320, 290, 110, 23);

        jButton16.setText("Lưu ĐTB");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton16);
        jButton16.setBounds(460, 290, 110, 23);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 0, 810, 410);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thực hiện", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 0, 153))); // NOI18N

        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButton1.setText("Thêm");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButton2.setText("Xóa");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButton3.setText("Sửa");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton12.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton12.setText("Back");
        jButton12.setDefaultCapable(false);
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(jLabel4)
                .addContainerGap(49, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3);
        jPanel3.setBounds(810, 0, 200, 400);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh sách nhân viên", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(204, 51, 0))); // NOI18N

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
        jTable1.setSelectionBackground(new java.awt.Color(204, 255, 255));
        jTable1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 998, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel4);
        jPanel4.setBounds(0, 420, 1010, 340);

        jButton11.setText("Xuất File PDF");
        jPanel1.add(jButton11);
        jButton11.setBounds(0, 760, 150, 50);

        jButton13.setText("Xuất File Excel");
        jPanel1.add(jButton13);
        jButton13.setBounds(160, 760, 160, 50);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1014, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 799, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 20, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed

        Document document = new Document();

        try {
            // khởi tạo một PdfWriter truyền vào document và FileOutputStream
            PdfWriter.getInstance(document, new FileOutputStream(OutFile.createFilePDF("system\\file\\pdf\\nhanvien\\")));

            // mở file để thực hiện viết
            document.open();
            // thêm nội dung sử dụng add function
            document.add(new Paragraph(OutFile.removeAccent("Thông Tin Nhân Viên")));
            document.add(new Paragraph(OutFile.removeAccent("Mã nhân viên: " + jTextField2.getText())));
            document.add(new Paragraph(OutFile.removeAccent("Tên nhân viên: " + jTextField3.getText())));
            document.add(new Paragraph(OutFile.removeAccent("Ngày sinh: " + jTextField4.getText())));
            document.add(new Paragraph(OutFile.removeAccent("Số điện thoại: " + jTextField5.getText())));
            document.add(new Paragraph(OutFile.removeAccent("Địa chỉ: " + jTextField7.getText())));
                //Khởi tạo 3 ô header

            //Thêm 3 ô header vào table
            document.close();
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PanelEmployees.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        String[] header = {"Mã Nhân Viên", "Tên Nhân Viên", "Ngày Sinh", "SĐT", "Địa Chỉ"};
        DefaultTableModel dtmsearch = new DefaultTableModel(header, 0);
        ArrayList<nhanvienDTO> s;
        if (jComboBox1.getSelectedItem().equals("Ngày Sinh")) {
            s = nhanvienBUS.timkiemnhanvien(model.getValue(), model2.getValue());
        } else {
            if (jComboBox1.getSelectedItem().equals("Số Điện Thoại") || jComboBox1.getSelectedItem().equals("Mã Nhân Viên")) {
                if (CheckData.checkNumber(jTextField1.getText().toLowerCase().trim())) {
                    s = nhanvienBUS.timkiemnhanvien(String.valueOf(jComboBox1.getSelectedItem()), jTextField1.getText().toLowerCase().trim());
                } else {
                    JOptionPane.showMessageDialog(null, "Bạn phải nhập số!");
                }
            }
            s = nhanvienBUS.timkiemnhanvien(String.valueOf(jComboBox1.getSelectedItem()), jTextField1.getText().toLowerCase().trim());
        }
        if (s.size() != 0) {
            for (int i = 0; i < s.size(); i++) {
                Object[] row = {s.get(i).getMaNV(), s.get(i).getTenNhanVien(), s.get(i).getNgaysinh(), s.get(i).getSdt(), s.get(i).getDiaChi()
                };
                dtmsearch.addRow(row);
            }
            jTable1.setModel(dtmsearch);
            jButton12.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Không có kết quả phù hợp!");
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        // TODO add your handling code here:
        jTable1.setModel(dtm);
        jButton12.setVisible(false);
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        if (jButton3.getText().toString().equals("Sửa")) {
            jButton3.setText("Xác nhận sửa");
            datePicker3.setVisible(true);
            jTextField2.setEditable(false);
            datePicker3.setVisible(true);
            jButton1.setVisible(false);
            jButton2.setVisible(false);
            jTextField3.setEnabled(true);
            jTextField5.setEnabled(true);
            jTextField7.setEnabled(true);
        } else {
            if (jTextField2.getText().length() == 0 || jTextField3.getText().length() == 0 || jTextField4.getText().length() == 0
                    || jTextField5.getText().length() == 0
                    || jTextField7.getText().length() == 0) {
                JOptionPane.showMessageDialog(null, "Vui lòng điền đủ thông tin vào bảng");
            } else {
                if (CheckData.checkSoDienThoai(jTextField5.getText().toString().trim())) {
                    jTextField3.setEnabled(false);
                    jTextField5.setEnabled(false);
                    jTextField7.setEnabled(false);
                    jButton2.setVisible(true);
                    jButton3.setVisible(true);
                    datePicker3.setVisible(false);
                    try {
                        datePicker3.setVisible(false);
                        jButton1.setText("Thêm");
                        nhanvienDTO nv = new nhanvienDTO();
                        nv.setMaNV(jTextField2.getText().trim());
                        nv.setTenNhanVien(jTextField3.getText().trim());
                        nv.setNgaysinh(new SimpleDateFormat("yyyy-MM-dd").parse(jTextField4.getText().trim()));
                        nv.setSdt(jTextField5.getText().trim());
                        nv.setDiaChi(jTextField7.getText().trim());
                        nhanvienBUS.suaNhanVien(nv, this);
                    } catch (ParseException ex) {
                        Logger.getLogger(PanelEmployees.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Số điện thoại không hợp lệ, cần có 10 số!");
                }
            }
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        nhanvienBUS.xoaNhanVien(jTextField2.getText().toString().trim(), this);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if (jButton1.getText().toString().equals("Thêm")) {
            datePicker3.setVisible(true);
            ArrayList<nhanvienDTO> arr = nhanvienBUS.getNhanVien();
            jTextField2.setText("" + (Integer.parseInt(arr.get(arr.size() - 1).getMaNV()) + 1));
            jButton1.setText("Xác nhận thêm");
            datePicker3.setVisible(true);
            jTextField3.setText("");
            jTextField4.setText("");
            jTextField5.setText("");
            jTextField7.setText("");
            jButton2.setVisible(false);
            jButton3.setVisible(false);
            jTextField3.setEnabled(true);
            jTextField5.setEnabled(true);
            jTextField7.setEnabled(true);

        } else {
            if (jTextField2.getText().length() == 0 || jTextField3.getText().length() == 0 || jTextField4.getText().length() == 0
                    || jTextField5.getText().length() == 0
                    || jTextField7.getText().length() == 0) {
                JOptionPane.showMessageDialog(null, "Vui lòng điền đủ thông tin vào bảng");
            } else {
                if (CheckData.checkSoDienThoai(jTextField5.getText().toString().trim())) {
                    jTextField3.setEnabled(false);
                    jTextField5.setEnabled(false);
                    jTextField7.setEnabled(false);
                    jButton2.setVisible(true);
                    jButton3.setVisible(true);
                    datePicker3.setVisible(false);
                    try {
                        datePicker3.setVisible(false);
                        jButton1.setText("Thêm");
                        nhanvienDTO nv = new nhanvienDTO();
                        nv.setMaNV(jTextField2.getText().trim());
                        nv.setTenNhanVien(jTextField3.getText().trim());
                        nv.setNgaysinh(new SimpleDateFormat("yyyy-MM-dd").parse(jTextField4.getText().trim()));
                        nv.setSdt(jTextField5.getText().trim());
                        nv.setDiaChi(jTextField7.getText().trim());
                        nhanvienBUS.themNhanVien(nv, this);
                    } catch (ParseException ex) {
                        Logger.getLogger(PanelEmployees.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Số điện thoại không hợp lệ, cần có 10 số!");
                }
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        // TODO add your handling code here:
        try {
            OutFile.writeExcel(jTable1, "system\\file\\excel\\nhanvien\\", true);
        } catch (IOException ex) {
            Logger.getLogger(PanelBook.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        try {
            // TODO add your handling code here:
            jTable1.setModel(OutFile.readExcel("system\\database\\data\\employees.xls"));
            jButton16.setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(PanelEmployees.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        TableModel model = jTable1.getModel();
        for (int i = 0; i < model.getRowCount(); i++) {
            nhanvienDTO nv = new nhanvienDTO();
            nv.setTenNhanVien(model.getValueAt(i, 1) + "");
            try {
                Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(model.getValueAt(i, 2) + "");
                nv.setNgaysinh(date1);
            } catch (ParseException ex) {
                Logger.getLogger(PanelEmployees.class.getName()).log(Level.SEVERE, null, ex);
            }
            nv.setSdt(model.getValueAt(i, 3) + "");
            nv.setDiaChi(model.getValueAt(i, 4) + "");
            nhanvienBUS.themNhanVien(nv, this);

        }
        // TODO add your handling code here:
        jButton16.setVisible(false);
    }//GEN-LAST:event_jButton16ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField7;
    // End of variables declaration//GEN-END:variables

}
