package GUI;

import GUI.ItemRoot;
import java.util.ArrayList;
import javax.swing.JFrame;
import untils.CatchEvent;
import untils.cons;

public class FrameMain extends javax.swing.JFrame {

    public FrameMain() {
        initComponents();
//        setExtendedState(JFrame.MAXIMIZED_BOTH); 
        initView();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        CatchEvent catchEvent = new CatchEvent(pn_view);
        ArrayList<ItemRoot> menu = new ArrayList<>();
        menu.add(new ItemRoot("book", pn_book, lb_book));
        menu.add(new ItemRoot("deal", pn_deal, lb_deal));
        menu.add(new ItemRoot("phieuphat", pn_phieuphat, lb_phieuphat));
        menu.add(new ItemRoot("phieunhap", pn_phieunhap, lb_phieunhap));
        menu.add(new ItemRoot("member", pn_member, lb_member));
        menu.add(new ItemRoot("statistical", pn_statistical, lb_statistical));
        menu.add(new ItemRoot("employees", pn_employees, lb_employees));
        catchEvent.setMenu(menu);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pn_root = new javax.swing.JPanel();
        pn_menu = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        pn_book = new javax.swing.JPanel();
        lb_book = new javax.swing.JLabel();
        pn_phieuphat = new javax.swing.JPanel();
        lb_phieuphat = new javax.swing.JLabel();
        pn_member = new javax.swing.JPanel();
        lb_member = new javax.swing.JLabel();
        pn_deal = new javax.swing.JPanel();
        lb_deal = new javax.swing.JLabel();
        pn_phieunhap = new javax.swing.JPanel();
        lb_phieunhap = new javax.swing.JLabel();
        pn_employees = new javax.swing.JPanel();
        lb_employees = new javax.swing.JLabel();
        pn_statistical = new javax.swing.JPanel();
        lb_statistical = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        pn_view = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pn_root.setBackground(new java.awt.Color(255, 255, 255));
        pn_root.setLayout(null);

        pn_menu.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 51, 0)));

        jPanel4.setBackground(new java.awt.Color(0, 0, 102));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("QUẢN LÝ THƯ VIỆN");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
                .addContainerGap())
        );

        pn_book.setBackground(new java.awt.Color(0, 102, 102));
        pn_book.setForeground(new java.awt.Color(102, 102, 102));

        lb_book.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lb_book.setForeground(new java.awt.Color(255, 255, 255));
        lb_book.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lb_book.setText("Quản Lý Sách");

        javax.swing.GroupLayout pn_bookLayout = new javax.swing.GroupLayout(pn_book);
        pn_book.setLayout(pn_bookLayout);
        pn_bookLayout.setHorizontalGroup(
            pn_bookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_bookLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(lb_book, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pn_bookLayout.setVerticalGroup(
            pn_bookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_bookLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lb_book)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pn_phieuphat.setBackground(new java.awt.Color(0, 102, 102));

        lb_phieuphat.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lb_phieuphat.setForeground(new java.awt.Color(255, 255, 255));
        lb_phieuphat.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lb_phieuphat.setText("Quản Lý Phiếu Phạt");

        javax.swing.GroupLayout pn_phieuphatLayout = new javax.swing.GroupLayout(pn_phieuphat);
        pn_phieuphat.setLayout(pn_phieuphatLayout);
        pn_phieuphatLayout.setHorizontalGroup(
            pn_phieuphatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_phieuphatLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(lb_phieuphat)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pn_phieuphatLayout.setVerticalGroup(
            pn_phieuphatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_phieuphatLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lb_phieuphat)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pn_member.setBackground(new java.awt.Color(0, 102, 102));

        lb_member.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lb_member.setForeground(new java.awt.Color(255, 255, 255));
        lb_member.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lb_member.setText("Quản Lý Đọc Giả");

        javax.swing.GroupLayout pn_memberLayout = new javax.swing.GroupLayout(pn_member);
        pn_member.setLayout(pn_memberLayout);
        pn_memberLayout.setHorizontalGroup(
            pn_memberLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_memberLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(lb_member)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pn_memberLayout.setVerticalGroup(
            pn_memberLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_memberLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lb_member)
                .addGap(10, 10, 10))
        );

        pn_deal.setBackground(new java.awt.Color(0, 102, 102));

        lb_deal.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lb_deal.setForeground(new java.awt.Color(255, 255, 255));
        lb_deal.setText("Quản Lý Mượn - Trả Sách");

        javax.swing.GroupLayout pn_dealLayout = new javax.swing.GroupLayout(pn_deal);
        pn_deal.setLayout(pn_dealLayout);
        pn_dealLayout.setHorizontalGroup(
            pn_dealLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_dealLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(lb_deal)
                .addContainerGap(13, Short.MAX_VALUE))
        );
        pn_dealLayout.setVerticalGroup(
            pn_dealLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_dealLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lb_deal)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pn_phieunhap.setBackground(new java.awt.Color(0, 102, 102));

        lb_phieunhap.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lb_phieunhap.setForeground(new java.awt.Color(255, 255, 255));
        lb_phieunhap.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lb_phieunhap.setText("Quản Lý Phiếu Nhập");

        javax.swing.GroupLayout pn_phieunhapLayout = new javax.swing.GroupLayout(pn_phieunhap);
        pn_phieunhap.setLayout(pn_phieunhapLayout);
        pn_phieunhapLayout.setHorizontalGroup(
            pn_phieunhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_phieunhapLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lb_phieunhap)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pn_phieunhapLayout.setVerticalGroup(
            pn_phieunhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_phieunhapLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lb_phieunhap)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pn_employees.setBackground(new java.awt.Color(0, 102, 102));

        lb_employees.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lb_employees.setForeground(new java.awt.Color(255, 255, 255));
        lb_employees.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lb_employees.setText("Quản Lý Nhân Viên");

        javax.swing.GroupLayout pn_employeesLayout = new javax.swing.GroupLayout(pn_employees);
        pn_employees.setLayout(pn_employeesLayout);
        pn_employeesLayout.setHorizontalGroup(
            pn_employeesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_employeesLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(lb_employees)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pn_employeesLayout.setVerticalGroup(
            pn_employeesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_employeesLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lb_employees)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pn_statistical.setBackground(new java.awt.Color(0, 102, 102));

        lb_statistical.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lb_statistical.setForeground(new java.awt.Color(255, 255, 255));
        lb_statistical.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lb_statistical.setText("Thống Kê");

        javax.swing.GroupLayout pn_statisticalLayout = new javax.swing.GroupLayout(pn_statistical);
        pn_statistical.setLayout(pn_statisticalLayout);
        pn_statisticalLayout.setHorizontalGroup(
            pn_statisticalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_statisticalLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(lb_statistical)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pn_statisticalLayout.setVerticalGroup(
            pn_statisticalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_statisticalLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lb_statistical)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(pn_statistical, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pn_employees, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pn_phieunhap, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pn_phieuphat, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pn_deal, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pn_member, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pn_book, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pn_book, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pn_member, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pn_deal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pn_phieuphat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(pn_phieunhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pn_employees, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pn_statistical, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pn_menuLayout = new javax.swing.GroupLayout(pn_menu);
        pn_menu.setLayout(pn_menuLayout);
        pn_menuLayout.setHorizontalGroup(
            pn_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pn_menuLayout.setVerticalGroup(
            pn_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pn_root.add(pn_menu);
        pn_menu.setBounds(0, 0, 300, 770);

        pn_view.setBackground(new java.awt.Color(0, 204, 51));

        javax.swing.GroupLayout pn_viewLayout = new javax.swing.GroupLayout(pn_view);
        pn_view.setLayout(pn_viewLayout);
        pn_viewLayout.setHorizontalGroup(
            pn_viewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_viewLayout.createSequentialGroup()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 1038, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pn_viewLayout.setVerticalGroup(
            pn_viewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 770, Short.MAX_VALUE)
        );

        pn_root.add(pn_view);
        pn_view.setBounds(315, 0, 1010, 770);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pn_root, javax.swing.GroupLayout.DEFAULT_SIZE, 1326, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pn_root, javax.swing.GroupLayout.DEFAULT_SIZE, 768, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel lb_book;
    private javax.swing.JLabel lb_deal;
    private javax.swing.JLabel lb_employees;
    private javax.swing.JLabel lb_member;
    private javax.swing.JLabel lb_phieunhap;
    private javax.swing.JLabel lb_phieuphat;
    private javax.swing.JLabel lb_statistical;
    private javax.swing.JPanel pn_book;
    private javax.swing.JPanel pn_deal;
    private javax.swing.JPanel pn_employees;
    private javax.swing.JPanel pn_member;
    private javax.swing.JPanel pn_menu;
    private javax.swing.JPanel pn_phieunhap;
    private javax.swing.JPanel pn_phieuphat;
    private javax.swing.JPanel pn_root;
    private javax.swing.JPanel pn_statistical;
    private javax.swing.JPanel pn_view;
    // End of variables declaration//GEN-END:variables

    private void initView() {

        if (cons.nv.getRole()==1) {
            pn_employees.setVisible(false);
            pn_statistical.setVisible(false);
        }
    }
}
