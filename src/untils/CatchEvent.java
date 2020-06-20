package untils;

import GUI.ItemRoot;
import GUI.PanelBook;
import GUI.PanelDeal;
import GUI.PanelEmployees;
import GUI.PanelLoanSlipDetails;
import GUI.PanelMember;
import GUI.PanelPhieuPhat;
import GUI.PanelQuanlynhap;
import GUI.PanelQuanlyphat;
import GUI.PanelStatistical;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.List;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CatchEvent {

    private JPanel pnRoot;
    private ArrayList<ItemRoot> menu = null;

    public CatchEvent(JPanel pnRoot) {
        this.pnRoot = pnRoot;
    }

    public void setMenu(ArrayList<ItemRoot> menu) {
        this.menu = menu;
        for (ItemRoot itemRoot : menu) {
             itemRoot.getPn_Item().addMouseListener(new Events(itemRoot.getNameItem(), itemRoot.getPn_Item(), itemRoot.getLb_Item()));
        }
    }

    class Events implements MouseListener {

        private JPanel pnNode;
        private String select;
        private JPanel pnItem;
        private JLabel lbItem;

        @Override
        public void mouseClicked(MouseEvent e) {
            switch (select) {
                case "book":
                    pnNode = new PanelBook();
                    break;
                case "employees":
                    pnNode = new PanelEmployees();
                    break;
                case "member":
                    pnNode = new PanelMember();
                    break;
                case "deal":
                    pnNode = new PanelDeal();
                    break;
                case "phieuphat":
                    pnNode = new PanelQuanlyphat();
                    break;
                    
                case "phieunhap":
                    pnNode = new PanelQuanlynhap();
                    break;
                case "statistical":
                    pnNode = new PanelStatistical();
                    break;
                default:
                    break;
            }
            pnRoot.removeAll();
            pnRoot.setLayout(new BorderLayout());
            pnRoot.add(pnNode);
            pnRoot.validate();
            pnRoot.repaint();
            setBackgroudSeclect(select);
        }

        public Events(String select, JPanel pnItem, JLabel lbItem) {
            this.select = select;
            this.pnItem = pnItem;
            this.lbItem = lbItem;
        }

        @Override
        public void mousePressed(MouseEvent e) {
            
        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {
    
        }

        @Override
        public void mouseExited(MouseEvent e) {
        
        }

    }
    
    private void setBackgroudSeclect(String select){
       for(ItemRoot itemRoot : menu) {
           if(!itemRoot.getNameItem().equalsIgnoreCase(select)) {
               itemRoot.getPn_Item().setBackground(new Color(153,153,153));
               itemRoot.getLb_Item().setBackground(new Color(153,153,153));
           } else {
               itemRoot.getLb_Item().setBackground(new Color(51,51,51));
               itemRoot.getPn_Item().setBackground(new Color(51,51,51));
           }
       }
    }
}
