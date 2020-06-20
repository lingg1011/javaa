package GUI;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class ItemRoot {

    private String nameItem;
    private JPanel pn_Item;
    private JLabel lb_Item;

    public ItemRoot() {
    }

    public ItemRoot(String nameItem, JPanel pn_Item, JLabel lb_Item) {
        this.nameItem = nameItem;
        this.pn_Item = pn_Item;
        this.lb_Item = lb_Item;
    }

    public String getNameItem() {
        return nameItem;
    }

    public void setNameItem(String nameItem) {
        this.nameItem = nameItem;
    }

    public JPanel getPn_Item() {
        return pn_Item;
    }

    public void setPn_Item(JPanel pn_Item) {
        this.pn_Item = pn_Item;
    }

    public JLabel getLb_Item() {
        return lb_Item;
    }

    public void setLb_Item(JLabel lb_Item) {
        this.lb_Item = lb_Item;
    }

}
