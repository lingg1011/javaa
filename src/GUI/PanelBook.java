package GUI;

import BUS.nhanvienBUS;
import BUS.sachBUS;
import DTO.nhanvienDTO;
import DTO.nxbDTO;
import DTO.sachDTO;
import DTO.tacgiaDTO;
import DTO.theloaiDTO;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import interfaces.InNXBSelect;
import interfaces.InTacGiaSelect;
import interfaces.InTheLoaiSelect;
import interfaces.QueryCallBack;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import untils.CheckData;
import untils.OutFile;

public class PanelBook extends javax.swing.JPanel implements QueryCallBack, InNXBSelect, InTacGiaSelect, InTheLoaiSelect {

    PanelTacGia panelTg;
    PanelTheLoai panelTl;
    PanelNXB panelNXB;
    DefaultTableModel dtm;
    ArrayList<sachDTO> arr = new ArrayList<sachDTO>();
    ArrayList<sachDTO> tempsearch = new ArrayList<sachDTO>();

    public PanelBook() {
        initComponents();
        initEvent();
        initData();
        loadSach();

        buttonAddTL.setVisible(false);
        buttonAddTG.setVisible(false);
        buttonAddNXB.setVisible(false);
        //Panel Tác Giả
        panelTg = new PanelTacGia(this);

        panelTg.setBackground(new java.awt.Color(102, 102, 102));
        panelTg.setForeground(new java.awt.Color(0, 204, 204));
        panelTg.setLayout(null);
        panelTg.setBounds(0, 0, 1024, 768);
        panelTg.setVisible(false);
        add(panelTg);

        //Panel Thể Loại
        panelTl = new PanelTheLoai(this);
        panelTl.setBackground(new java.awt.Color(102, 102, 102));
        panelTl.setForeground(new java.awt.Color(0, 204, 204));
        panelTl.setLayout(null);
        panelTl.setBounds(0, 0, 1024, 768);
        panelTl.setVisible(false);
        add(panelTl);

        //Panel NXB
        panelNXB = new PanelNXB(this);
        panelNXB.setBackground(new java.awt.Color(102, 102, 102));
        panelNXB.setForeground(new java.awt.Color(0, 204, 204));
        panelNXB.setLayout(null);
        panelNXB.setBounds(0, 0, 1024, 768);
        panelNXB.setVisible(false);
        add(panelNXB);

    }

    public void loadSach() {
        String[] header = {"Mã Sách", "Tên Sách", "Tác Giả", "Thể Loại", "NXB", "SL", "SL Còn", "Đơn Giá"};

        dtm = new DefaultTableModel(header, 0);
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
            int dg = s.getDongia();
            Object[] row = {masach, tensach, tacgia, theloai, nxb, sl, slc, dg};
            dtm.addRow(row);
        }
        jTable1.setModel(dtm);
        setView(arr.get(0));

    }

    private void initData() {
        jTextField2.setEnabled(false);
        jTextField2.setEditable(false);
        jTextField4.setEnabled(false);
        jTextField3.setEnabled(false);
        jTextField10.setEnabled(false);
        jTextField5.setEnabled(false);
        jTextField6.setEnabled(false);
        jTextField7.setEnabled(false);
        jTextField8.setEnabled(false);
        jButton12.setVisible(false);
        jPanel2.setVisible(false);
        jButton19.setVisible(false);
        jComboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (jComboBox1.getSelectedItem().equals("Số Lượng")) {
                    jTextField1.setText("");
                    jPanel2.setVisible(true);
                    for (int i = 0; i <= sachBUS.getSoLuongMax(0); i++) {
                        jComboBox2.addItem(i + "");
                        jComboBox3.addItem(i + "");

                    }
                } else if (jComboBox1.getSelectedItem().equals("Số Lượng Còn")) {
                    jTextField1.setText("");
                    jPanel2.setVisible(true);
                    for (int i = 0; i <= sachBUS.getSoLuongMax(1); i++) {
                        jComboBox2.addItem(i + "");
                        jComboBox3.addItem(i + "");

                    }
                } else {
                    jPanel2.setVisible(false);
                }
            }
        });
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

    }

    public void setView(sachDTO s) {
        if (jButton1.getText().equals("Thêm") && jButton3.getText().equals("Sửa")) {
            jTextField2.setText(s.getMaSach() + "");
            jTextField3.setText(s.getTenSach());
            jTextField4.setText(s.getTenTacGia());
            jTextField5.setText(s.getTheLoai());
            jTextField6.setText(s.getNhaXuatBan());
            jTextField7.setText(s.getSoLuongHienCo() + "");
            jTextField8.setText(s.getSoLuongCon() + "");
            jTextField10.setText(s.getDongia() + "");
        }
    }

    @Override
    public void onSuccess() {
        loadSach();
    }

    @Override
    public void onFailed(String error) {
        jTextField2.setText(error);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        jTextField3 = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();
        jTextField4 = new javax.swing.JTextField();
        buttonAddTG = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jTextField5 = new javax.swing.JTextField();
        buttonAddTL = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jTextField1 = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jButton9 = new javax.swing.JButton();
        jTextField6 = new javax.swing.JTextField();
        buttonAddNXB = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jTextField7 = new javax.swing.JTextField();
        jButton11 = new javax.swing.JButton();
        jTextField8 = new javax.swing.JTextField();
        jButton14 = new javax.swing.JButton();
        jTextField10 = new javax.swing.JTextField();
        jButton13 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        jButton19 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();

        jLabel5.setText("jLabel5");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(0, 204, 204));
        jPanel1.setPreferredSize(new java.awt.Dimension(924, 496));
        jPanel1.setLayout(null);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin sách", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 0, 153))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(153, 0, 51));
        jLabel3.setText("Thông tin sách");

        jButton5.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jButton5.setText("Mã Sách");

        jTextField2.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N

        jButton6.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jButton6.setText("Tên Sách");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jTextField3.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        jButton7.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jButton7.setText("Tên Tác Giả");

        jTextField4.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });

        buttonAddTG.setText("+");
        buttonAddTG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAddTGActionPerformed(evt);
            }
        });

        jButton8.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jButton8.setText("Thể Loại");

        jTextField5.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N

        buttonAddTL.setText("+");
        buttonAddTL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAddTLActionPerformed(evt);
            }
        });

        jComboBox1.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mã Sách", "Tên Sách", "Tên Tác Giả", "Thể Loại", "Nhà Xuất Bản", "Số Lượng", "Số Lượng Còn" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton4.setText("Tìm Kiếm");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Từ");

        jComboBox2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Đến");

        jComboBox3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jComboBox3, 0, 50, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(164, 164, 164)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jComboBox1, 0, 1, Short.MAX_VALUE)
                            .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField5, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                            .addComponent(jTextField1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonAddTL, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jButton5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(4, 4, 4)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jTextField2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonAddTG, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(13, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(buttonAddTG, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonAddTL, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jButton4))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3);
        jPanel3.setBounds(0, 0, 410, 340);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin chi tiết sách", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(102, 0, 0))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 51, 204));
        jLabel4.setText("Thông tin chi tiết sách");

        jButton9.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jButton9.setText("Nhà Xuât Bản");

        jTextField6.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N

        buttonAddNXB.setText("+");
        buttonAddNXB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAddNXBActionPerformed(evt);
            }
        });

        jButton10.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jButton10.setText("SL Hiện Có");

        jTextField7.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N

        jButton11.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jButton11.setText("SL Còn Lại");

        jTextField8.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N

        jButton14.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jButton14.setText("Đơn Giá");

        jTextField10.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N

        jButton13.setText("Xuất Excel");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jButton17.setText("Xuất PDF");
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });

        jButton18.setText("Đọc Excel");
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });

        jButton19.setText("Lưu ĐTB");
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buttonAddNXB, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jButton13)
                        .addGap(18, 18, 18)
                        .addComponent(jButton17)
                        .addGap(18, 18, 18)
                        .addComponent(jButton18)
                        .addGap(18, 18, 18)
                        .addComponent(jButton19)))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(32, 32, 32)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonAddNXB, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton10, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton11, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton13)
                    .addComponent(jButton17)
                    .addComponent(jButton18)
                    .addComponent(jButton19))
                .addContainerGap())
        );

        jPanel1.add(jPanel4);
        jPanel4.setBounds(410, 0, 470, 340);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thực hiện", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 102, 102))); // NOI18N

        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton1.setText("Thêm");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton2.setText("Xóa");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton3.setText("Sửa");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton12.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton12.setText("Back");
        jButton12.setDefaultCapable(false);
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                    .addComponent(jButton12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel1.add(jPanel5);
        jPanel5.setBounds(880, 0, 190, 340);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh sách Sách", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(204, 51, 0))); // NOI18N

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

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1036, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 339, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(jPanel6);
        jPanel6.setBounds(0, 350, 1070, 390);

        jButton15.setText("Xuất File Excel");
        jPanel1.add(jButton15);
        jButton15.setBounds(900, 740, 170, 50);

        jButton16.setText("Xuất PDF");
        jButton16.setActionCommand("Xuất File PDF");
        jPanel1.add(jButton16);
        jButton16.setBounds(720, 740, 170, 50);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1073, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 811, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        if (jButton3.getText().toString().equals("Sửa")) {
            jTextField3.setEnabled(true);
            jTextField10.setEnabled(true);
            buttonAddTL.setVisible(true);
            buttonAddTG.setVisible(true);
            buttonAddNXB.setVisible(true);
            jButton3.setText("Xác nhận sửa");
            jTextField2.setEditable(false);
        } else {
            if (jTextField3.getText().length() != 0 && jTextField4.getText().length() != 0
                    && jTextField5.getText().length() != 0 && jTextField6.getText().length() != 0
                    && jTextField7.getText().length() != 0 && jTextField8.getText().length() != 0
                    && jTextField10.getText().length() != 0) {
                if (CheckData.checkNumber(jTextField10.getText().toString().trim())) {
                    jButton3.setText("Sửa");
                    sachDTO s = new sachDTO();
                    s.setMaSach(jTextField2.getText().trim());
                    s.setMaSach(jTextField2.getText().trim());
                    s.setTenSach(jTextField3.getText().trim());
                    s.setTenTacGia(jTextField4.getText().trim());
                    s.setTheLoai(jTextField5.getText().trim());
                    s.setNhaXuatBan(jTextField6.getText().trim());
                    s.setSoLuongHienCo(Integer.parseInt(jTextField7.getText().trim()));
                    s.setSoLuongCon(Integer.parseInt(jTextField8.getText().trim()));
                    s.setDongia(Integer.parseInt(jTextField10.getText().trim()));
                    sachBUS.suaSach(s, this);
                } else {
                    JOptionPane.showMessageDialog(null, "Đơn giá phải nhập số!");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Bạn cần nhập đầy đủ thông tin vào bảng");

            }

        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    if (jButton1.getText().toString().equals("Thêm")) {
            jTextField3.setEnabled(true);
            jTextField10.setEnabled(true);
            buttonAddTL.setVisible(true);
            buttonAddTG.setVisible(true);
            buttonAddNXB.setVisible(true);
            ArrayList<sachDTO> arr = sachBUS.getSach();
            jTextField2.setText("" + (Integer.parseInt(arr.get(arr.size() - 1).getMaSach()) + 1));
            jButton1.setText("Xác nhận thêm");
            jTextField3.setText("");
            jTextField4.setText("");
            jTextField5.setText("");
            jTextField6.setText("");
            jTextField7.setText("0");
            jTextField8.setText("0");
            jTextField10.setText("");
        } else {
            if (jTextField3.getText().length() != 0 && jTextField4.getText().length() != 0
                    && jTextField5.getText().length() != 0 && jTextField6.getText().length() != 0
                    && jTextField7.getText().length() != 0 && jTextField8.getText().length() != 0
                    && jTextField10.getText().length() != 0) {
                if (CheckData.checkNumber(jTextField10.getText().toString().trim())) {
                    jButton1.setText("Thêm");
                    sachDTO s = new sachDTO();
                    s.setMaSach(jTextField2.getText().trim());
                    s.setMaSach(jTextField2.getText().trim());
                    s.setTenSach(jTextField3.getText().trim());
                    s.setTenTacGia(jTextField4.getText().trim());
                    s.setTheLoai(jTextField5.getText().trim());
                    s.setNhaXuatBan(jTextField6.getText().trim());
                    s.setSoLuongHienCo(Integer.parseInt(jTextField7.getText().trim()));
                    s.setSoLuongCon(Integer.parseInt(jTextField8.getText().trim()));
                    s.setDongia(Integer.parseInt(jTextField10.getText().trim()));
                    sachBUS.themSach(s, this);
                } else {
                    JOptionPane.showMessageDialog(null, "Đơn giá phải nhập số!");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Bạn cần nhập đầy đủ thông tin vào bảng");
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        sachBUS.xoaSach(jTextField2.getText().toString().trim(), this);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        String[] header = {"Mã Sách", "Tên Sách", "Tác Giả", "Thể Loại", "NXB", "SL", "SL Còn", "Đơn Giá"};
        DefaultTableModel dtmsearch = new DefaultTableModel(header, 0);
        ArrayList<sachDTO> s;
        if (jComboBox1.getSelectedItem().equals("Số Lượng") || jComboBox1.getSelectedItem().equals("Số Lượng Còn")) {
            s = sachBUS.timkiemSach(String.valueOf(jComboBox1.getSelectedItem()), jTextField1.getText().toLowerCase().trim(), Integer.parseInt(jComboBox2.getSelectedItem() + ""), Integer.parseInt(jComboBox3.getSelectedItem() + ""));
        } else {
            if (jComboBox1.getSelectedItem().equals("Mã Sách")) {
                if (CheckData.checkNumber(jTextField1.getText().toString().trim())) {
                    s = sachBUS.timkiemSach(String.valueOf(jComboBox1.getSelectedItem()), jTextField1.getText().toLowerCase().trim());
                } else {
                    JOptionPane.showMessageDialog(null, "Mã sách phải nhập số!");
                }
            }
            s = sachBUS.timkiemSach(String.valueOf(jComboBox1.getSelectedItem()), jTextField1.getText().toLowerCase().trim());
        }
        if (s.size() != 0) {
            for (int i = 0; i < s.size(); i++) {
                Object[] row = {s.get(i).getMaSach(), s.get(i).getTenSach(), s.get(i).getTenTacGia(), s.get(i).getTheLoai(), s.get(i).getNhaXuatBan(), s.get(i).getSoLuongHienCo(), s.get(i).getSoLuongCon(), s.get(i).getDongia()
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

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        arr.clear();
        arr.addAll(tempsearch);
        tempsearch.clear();
        jTable1.setModel(dtm);
        jButton12.setVisible(false);
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void buttonAddTGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAddTGActionPerformed
        // TODO add your handling code here:
        jPanel1.setVisible(false);
        panelTg.setVisible(true);
        revalidate();
    }//GEN-LAST:event_buttonAddTGActionPerformed

    private void buttonAddTLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAddTLActionPerformed
        // TODO add your handling code here:
        jPanel1.setVisible(false);
        panelTl.setVisible(true);
        revalidate();
    }//GEN-LAST:event_buttonAddTLActionPerformed

    private void buttonAddNXBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAddNXBActionPerformed
        // TODO add your handling code here:
        jPanel1.setVisible(false);

        panelNXB.setVisible(true);
        revalidate();
    }//GEN-LAST:event_buttonAddNXBActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed

    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        // TODO add your handling code here:
        try {
            OutFile.writeExcel(jTable1, "system\\file\\excel\\book\\", true);
        } catch (IOException ex) {
            Logger.getLogger(PanelBook.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        Document document = new Document();

        try {
            // khởi tạo một PdfWriter truyền vào document và FileOutputStream
            PdfWriter.getInstance(document, new FileOutputStream(OutFile.createFilePDF("system\\file\\pdf\\book\\")));

            // mở file để thực hiện viết
            document.open();
            // thêm nội dung sử dụng add function
            document.add(new Paragraph(OutFile.removeAccent("Thông tin sách")));
            document.add(new Paragraph(OutFile.removeAccent("Mã Sách: " + jTextField2.getText())));
            document.add(new Paragraph(OutFile.removeAccent("Tên Sách: " + jTextField3.getText())));
            document.add(new Paragraph(OutFile.removeAccent("Tên tác giả: " + jTextField4.getText())));
            document.add(new Paragraph(OutFile.removeAccent("Thể loại: " + jTextField5.getText())));
            document.add(new Paragraph(OutFile.removeAccent("Nhà Xuất Bản: " + jTextField6.getText())));
            document.add(new Paragraph(OutFile.removeAccent("Dơn Giá: " + jTextField10.getText())));
                //Khởi tạo 3 ô header

            //Thêm 3 ô header vào table
            document.close();
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PanelEmployees.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton17ActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        try {
            // TODO add your handling code here:
            jTable1.setModel(OutFile.readExcel("system\\database\\data\\book.xls"));
            jButton19.setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(PanelBook.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton18ActionPerformed

    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
        // TODO add your handling code here:
        TableModel model = jTable1.getModel();
        for (int i = 0; i < model.getRowCount(); i++) {
            sachDTO s = new sachDTO();
            s.setTenSach((String) model.getValueAt(i, 1));
            s.setTenTacGia((String) model.getValueAt(i, 2));
            s.setTheLoai((String) model.getValueAt(i, 3));
            s.setNhaXuatBan((String) model.getValueAt(i, 4));
            s.setSoLuongHienCo(Integer.parseInt(model.getValueAt(i, 5) + ""));
            s.setSoLuongCon(Integer.parseInt(model.getValueAt(i, 6) + ""));
            s.setDongia(Integer.parseInt(model.getValueAt(i, 7) + ""));
            sachBUS.themSach(s, this);
        }

        jButton19.setVisible(false);
    }//GEN-LAST:event_jButton19ActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAddNXB;
    private javax.swing.JButton buttonAddTG;
    private javax.swing.JButton buttonAddTL;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    // End of variables declaration//GEN-END:variables

    @Override
    public void tacgia(tacgiaDTO tg) {
        jPanel1.setVisible(true);
        panelTg.setVisible(false);
        jTextField4.setText(tg.getTentg());

    }

    @Override
    public void theloai(theloaiDTO tg) {
        jPanel1.setVisible(true);
        panelTl.setVisible(false);
        jTextField5.setText(tg.getTentl());
    }

    @Override
    public void nxb(nxbDTO tg) {

        jPanel1.setVisible(true);
        panelNXB.setVisible(false);
        jTextField6.setText(tg.getTennxb());
    }

}
