/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.sachDAO;
import DAO.tinhtrangsachDAO;
import DTO.nhanvienDTO;
import DTO.sachDTO;
import DTO.tinhtrangsachDTO;
import interfaces.QueryCallBack;
import java.util.ArrayList;

/**
 *
 * @author cdphuc
 */
public class tinhtrangsachBUS {

    public static ArrayList<tinhtrangsachDTO> gettinhtrang() {
        return tinhtrangsachDAO.gettinhtrang();
    }


    public static String getTinhTrang(int query) {
        ArrayList<tinhtrangsachDTO> arr = gettinhtrang();
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i).getMatinhtrang()==query) {
                return arr.get(i).getTentinhtrang();
            }
        }
        return "";
    }
     public static int getGiaPhat(int query) {
        ArrayList<tinhtrangsachDTO> arr = gettinhtrang();
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i).getMatinhtrang()==query) {
                return arr.get(i).getGiaphat();
            }
        }
        return 0;
    }

}
