package GUI;

import untils.DateLabelFormatter;
import BUS.docgiaBUS;
import BUS.nhanvienBUS;
import BUS.sachBUS;
import DTO.docgiaDTO;
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
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;
import untils.CheckData;
import untils.OutFile;

public class PanelMember extends javax.swing.JPanel implements QueryCallBack {

    DefaultTableModel dtm;
    ArrayList<docgiaDTO> arr;
    ArrayList<docgiaDTO> tempsearch = new ArrayList<>();
    UtilDateModel model = new UtilDateModel();
    UtilDateModel model2 = new UtilDateModel();
    UtilDateModel model3 = new UtilDateModel();
    JDatePickerImpl datePicker;
    JDatePickerImpl datePicker2;
    JDatePickerImpl datePicker3;

    public PanelMember() {
        initComponents();
//model.setDate(20,04,2014);
// Need this...
        Properties p = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");
        JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
        JDatePanelImpl datePane2 = new JDatePanelImpl(model2, p);
        JDatePanelImpl datePane3 = new JDatePanelImpl(model3, p);
        // Don't know about the formatter, but there it is...

        datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());

        datePicker.setBounds(560, 223, 110, 30);
        add(datePicker);

        datePicker2 = new JDatePickerImpl(datePane2, new DateLabelFormatter());

        datePicker2.setBounds(720, 220, 110, 30);
        add(datePicker2);

        datePicker3 = new JDatePickerImpl(datePane3, new DateLabelFormatter());

        datePicker3.setBounds(780, 140, 30, 30);
        add(datePicker3);
        datePicker3.setVisible(false);
        datePicker3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                jTextField6.setText(new SimpleDateFormat("yyyy-MM-dd").format(model3.getValue()));
            }
        });
        loadDocGia();
        initData();
        initEvent();
    }

    private void initData() {
        jTextField2.setEditable(false);
        jTextField3.setEnabled(false);
        jTextField4.setEnabled(false);
        jTextField5.setEnabled(false);
        jTextField6.setEditable(false);
        jTextField2.setEnabled(false);
        jButton12.setVisible(false);
        jLabel1.setVisible(false);
        jLabel2.setVisible(false);
        datePicker.setVisible(false);
        datePicker2.setVisible(false);
        jButton16.setVisible(false);
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
                if (jComboBox1.getSelectedItem().equals("Ngày Cấp")) {
                    jTextField1.setEnabled(false);
                    jLabel1.setVisible(true);
                    jLabel2.setVisible(true);
                    datePicker.setVisible(true);
                    datePicker2.setVisible(true);
                    jTextField1.setEnabled(false);
                    return;
                }
                jTextField1.setEnabled(true);
                jTextField1.setEnabled(true);
                jLabel1.setVisible(false);
                jLabel2.setVisible(false);
                datePicker.setVisible(false);
                datePicker2.setVisible(false);

            }
        });

    }

    public void loadDocGia() {
        String[] header = {"Mã Đọc Giả", "Tên Đọc Giả", "Địa Chỉ", "SĐT", "Ngày Cấp"};

        dtm = new DefaultTableModel(header, 0);
        arr = docgiaBUS.getDocGia();
        docgiaDTO nv = new docgiaDTO();
        for (int i = 0; i < arr.size(); i++) {
            nv = arr.get(i);
            String madg = nv.getMaDocGia();
            String tendg = nv.getTenDocGia();
            String diachi = nv.getDiaChi();
            String sdt = nv.getSdt();
            Date ngaycap = nv.getNgayCap();
            Object[] row = {madg, tendg, diachi, sdt, ngaycap};
            dtm.addRow(row);
        }
        jTable1.setModel(dtm);
        setView(arr.get(0));

    }

    public void setView(docgiaDTO nv) {
        if (jButton1.getText().equals("Thêm") && jButton3.getText().equals("Sửa")) {
            jTextField2.setText(nv.getMaDocGia() + "");
            jTextField3.setText(nv.getTenDocGia());
            jTextField4.setText(nv.getDiaChi());
            jTextField5.setText(nv.getSdt());
            jTextField6.setText(nv.getNgayCap().toString());
        }
    }

    @Override
    public void onSuccess() {
        loadDocGia();
    }

    @Override
    public void onFailed(String error) {

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        jTextField3 = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();
        jTextField4 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<String>();
        jTextField1 = new javax.swing.JTextField();
        jButton8 = new javax.swing.JButton();
        jTextField5 = new javax.swing.JTextField();
        jButton9 = new javax.swing.JButton();
        jTextField6 = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(610, 915));
        setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin độc giả", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 0, 255))); // NOI18N
        jPanel1.setForeground(new java.awt.Color(0, 204, 204));
        jPanel1.setLayout(null);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 0, 51));
        jLabel3.setText("Độc giả");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(170, 10, 150, 40);

        jButton5.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jButton5.setText("Mã Đọc Giả");
        jPanel1.add(jButton5);
        jButton5.setBounds(10, 70, 130, 40);

        jTextField2.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jPanel1.add(jTextField2);
        jTextField2.setBounds(150, 80, 242, 25);

        jButton6.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jButton6.setText("Tên Đọc Giả");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6);
        jButton6.setBounds(10, 120, 130, 40);

        jTextField3.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jPanel1.add(jTextField3);
        jTextField3.setBounds(150, 130, 242, 25);

        jButton7.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jButton7.setText("Địa Chỉ");
        jPanel1.add(jButton7);
        jButton7.setBounds(10, 170, 130, 40);

        jTextField4.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jPanel1.add(jTextField4);
        jTextField4.setBounds(150, 180, 242, 25);

        jComboBox1.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Mã Đọc Giả", "Tên Đọc Giả", "Địa Chỉ", "Số Điện Thoại", "Ngày Cấp" }));
        jPanel1.add(jComboBox1);
        jComboBox1.setBounds(10, 220, 130, 40);

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField1);
        jTextField1.setBounds(150, 220, 240, 30);

        jButton8.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jButton8.setText("Số Điện Thoại");
        jPanel1.add(jButton8);
        jButton8.setBounds(400, 70, 130, 40);

        jTextField5.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jPanel1.add(jTextField5);
        jTextField5.setBounds(530, 80, 240, 30);

        jButton9.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jButton9.setText("Ngày Cấp");
        jPanel1.add(jButton9);
        jButton9.setBounds(400, 130, 130, 40);

        jTextField6.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jPanel1.add(jTextField6);
        jTextField6.setBounds(530, 140, 242, 30);

        jButton4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton4.setText("Tìm Kiếm");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4);
        jButton4.setBounds(400, 210, 130, 50);

        jLabel1.setText("Từ");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(540, 220, 20, 30);

        jLabel2.setText("Đến");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(690, 220, 20, 30);

        jButton13.setText("Xuất Excel");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton13);
        jButton13.setBounds(10, 280, 110, 23);

        jButton14.setText("Xuất PDF");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton14);
        jButton14.setBounds(140, 280, 100, 23);

        jButton15.setText("Đọc Excel");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton15);
        jButton15.setBounds(260, 280, 100, 23);

        jButton16.setText("Lưu ĐTB");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton16);
        jButton16.setBounds(380, 280, 90, 23);

        add(jPanel1);
        jPanel1.setBounds(0, 0, 840, 320);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thực hiện", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 102, 51))); // NOI18N
        jPanel2.setLayout(null);

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton1.setText("Thêm");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1);
        jButton1.setBounds(16, 41, 67, 50);

        jButton2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton2.setText("Xóa");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2);
        jButton2.setBounds(16, 109, 67, 50);

        jButton3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton3.setText("Sửa");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3);
        jButton3.setBounds(16, 177, 67, 49);

        jButton12.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton12.setText("Back");
        jButton12.setDefaultCapable(false);
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton12);
        jButton12.setBounds(16, 244, 67, 53);
        jPanel2.add(jLabel4);
        jLabel4.setBounds(16, 315, 67, 0);

        add(jPanel2);
        jPanel2.setBounds(840, 0, 180, 320);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh sách độc giả", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(204, 0, 204))); // NOI18N
        jPanel3.setLayout(null);

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

        jPanel3.add(jScrollPane1);
        jScrollPane1.setBounds(6, 16, 1008, 367);

        add(jPanel3);
        jPanel3.setBounds(0, 320, 1020, 390);

        jButton10.setText("Xuất File PDF");
        add(jButton10);
        jButton10.setBounds(0, 710, 150, 50);

        jButton11.setText("Xuất File Excel");
        add(jButton11);
        jButton11.setBounds(150, 710, 150, 50);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if (jButton1.getText().toString().equals("Thêm")) {
            jTextField3.setEnabled(true);
            jTextField4.setEnabled(true);
            jTextField5.setEnabled(true);
            datePicker3.setVisible(true);
            ArrayList<docgiaDTO> arr = docgiaBUS.getDocGia();
            jTextField2.setText("" + (Integer.parseInt(arr.get(arr.size() - 1).getMaDocGia()) + 1));
            jButton1.setText("Xác nhận thêm");
            jTextField3.setText("");
            jTextField4.setText("");
            jTextField5.setText("");
            jTextField6.setText("");
        } else {
            if (jTextField3.getText().length() == 0 || jTextField6.getText().length() == 0 || jTextField4.getText().length() == 0 || jTextField5.getText().length() == 0) {
                JOptionPane.showMessageDialog(null, "Vui lòng điền đủ thông tin vào bảng");
            } else {
                if (CheckData.checkSoDienThoai(jTextField5.getText().toString().trim())) {
                    try {
                        jTextField3.setEnabled(false);
                        jTextField4.setEnabled(false);
                        jTextField5.setEnabled(false);
                        datePicker3.setVisible(false);
                        jButton1.setText("Thêm");
                        docgiaDTO nv = new docgiaDTO();
                        nv.setMaDocGia(jTextField2.getText().trim());
                        nv.setTenDocGia(jTextField3.getText().trim());
                        nv.setDiaChi(jTextField4.getText().trim());
                        nv.setSdt(jTextField5.getText().trim());
                        nv.setNgayCap(new SimpleDateFormat("yyyy-MM-dd").parse(jTextField6.getText().trim()));
                        docgiaBUS.themDocGia(nv, this);
                    } catch (ParseException ex) {
                        Logger.getLogger(PanelMember.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Số điện thoại không hợp lệ, cần có 10 số!");
                }
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:

        //Thêm dùm tui cái alert xác nhận bạn có muốn xóa hay ko
        docgiaBUS.xoaDocGia(jTextField2.getText().toString().trim(), this);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:

        if (jButton3.getText().toString().equals("Sửa")) {
            jTextField3.setEnabled(true);
            jTextField4.setEnabled(true);
            jTextField5.setEnabled(true);
            jButton3.setText("Xác nhận sửa");
            jTextField2.setEditable(false);
            datePicker3.setVisible(true);
        } else {
            if (jTextField3.getText().length() == 0 || jTextField6.getText().length() == 0 || jTextField4.getText().length() == 0 || jTextField5.getText().length() == 0) {
                JOptionPane.showMessageDialog(null, "Vui lòng điền đủ thông tin vào bảng");
            } else {
                if (CheckData.checkSoDienThoai(jTextField5.getText().toString().trim())) {
                    try {
                        jTextField3.setEnabled(false);
                        jTextField4.setEnabled(false);
                        jTextField5.setEnabled(false);
                        datePicker3.setVisible(false);
                        jTextField2.setEditable(true);
                        jButton3.setText("Sửa");
                        docgiaDTO s = new docgiaDTO();
                        s.setMaDocGia(jTextField2.getText().trim());
                        s.setTenDocGia(jTextField3.getText().trim());
                        s.setDiaChi(jTextField4.getText().trim());
                        s.setSdt(jTextField5.getText().trim());
                        s.setNgayCap(new SimpleDateFormat("yyyy-MM-dd").parse(jTextField6.getText().trim()));
                        docgiaBUS.suaDocGia(s, this);
                    } catch (ParseException ex) {
                        Logger.getLogger(PanelMember.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Số điện thoại không hợp lệ, cần có 10 số!");
                }
            }
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        // TODO add your handling code here:
        arr.clear();
        arr.addAll(tempsearch);
        tempsearch.clear();
        jTable1.setModel(dtm);
        jButton12.setVisible(false);
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:

        String[] header = {"Mã Đọc Giả", "Tên Đọc Giả", "Địa Chỉ", "SĐT", "Ngày Cấp"};
        DefaultTableModel dtmsearch = new DefaultTableModel(header, 0);
        ArrayList<docgiaDTO> s;
        if (jComboBox1.getSelectedItem().equals("Ngày Cấp")) {
            s = docgiaBUS.timkiemDocGia(model.getValue(), model2.getValue());
        } else {
            if (jComboBox1.getSelectedItem().equals("Số Điện Thoại") || jComboBox1.getSelectedItem().equals("Mã Đọc Giả")) {
                if (CheckData.checkNumber(jTextField1.getText().toLowerCase().trim())) {
                    s = docgiaBUS.timkiemDocGia(String.valueOf(jComboBox1.getSelectedItem()), jTextField1.getText().toLowerCase().trim());
                } else {
                    JOptionPane.showMessageDialog(null, "Bạn phải nhập số!");
                }
            }
            s = docgiaBUS.timkiemDocGia(String.valueOf(jComboBox1.getSelectedItem()), jTextField1.getText().toLowerCase().trim());
        }
        if (s.size() != 0) {
            for (int i = 0; i < s.size(); i++) {
                Object[] row = {s.get(i).getMaDocGia(), s.get(i).getTenDocGia(), s.get(i).getDiaChi(), s.get(i).getSdt(), s.get(i).getNgayCap()
                };
                dtmsearch.addRow(row);
            }
            tempsearch.addAll(arr);
            arr.clear();
            arr.addAll(s);
            jTable1.setModel(dtmsearch);
            jButton12.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Không có kết quả phù hợp!");
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        // TODO add your handling code here:
        try {
            OutFile.writeExcel(jTable1, "system\\file\\excel\\docgia\\", true);
        } catch (IOException ex) {
            Logger.getLogger(PanelBook.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        Document document = new Document();

        try {
            // khởi tạo một PdfWriter truyền vào document và FileOutputStream
            PdfWriter.getInstance(document, new FileOutputStream(OutFile.createFilePDF("system\\file\\pdf\\docgia\\")));

            // mở file để thực hiện viết
            document.open();
            // thêm nội dung sử dụng add function
            document.add(new Paragraph(OutFile.removeAccent("Thông tin đọc giả")));
            document.add(new Paragraph(OutFile.removeAccent("Mã Đọc Giả: " + jTextField2.getText())));
            document.add(new Paragraph(OutFile.removeAccent("Tên Đọc Giả: " + jTextField3.getText())));
            document.add(new Paragraph(OutFile.removeAccent("Địa Chỉ: " + jTextField4.getText())));
            document.add(new Paragraph(OutFile.removeAccent("Số Điện Thoại: " + jTextField5.getText())));
            document.add(new Paragraph(OutFile.removeAccent("Ngày Cấp: " + jTextField6.getText())));
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
            jTable1.setModel(OutFile.readExcel("system\\database\\data\\member.xls"));
            jButton16.setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(PanelMember.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        // TODO add your handling code here:
TableModel model=jTable1.getModel();
        for(int i=0;i<model.getRowCount();i++)
        {
            docgiaDTO dg=new docgiaDTO();
            dg.setTenDocGia(model.getValueAt(i,1)+"");
            dg.setDiaChi(model.getValueAt(i,2)+"");
            dg.setSdt(model.getValueAt(i,3)+"");
            try {
                Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(model.getValueAt(i,4)+"");
            dg.setNgayCap(date1);
            } catch (ParseException ex) {
                Logger.getLogger(PanelMember.class.getName()).log(Level.SEVERE, null, ex);
            }
            docgiaBUS.themDocGia(dg, this);
        }
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    // End of variables declaration//GEN-END:variables
}
