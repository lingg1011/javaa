/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import static BUS.sachBUS.getSach;
import DAO.docgiaDAO;
import DAO.nhaccDAO;
import DAO.phieumuontraDAO;
import DAO.tacgiaDAO;
import DTO.docgiaDTO;
import DTO.nhaccDTO;
import DTO.phieumuontraDTO;
import DTO.sachDTO;
import DTO.tacgiaDTO;
import interfaces.QueryCallBack;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Administrator
 */
public class nhaccBUS {

    public static ArrayList<nhaccDTO> getNhaCC() {
        return nhaccDAO.getNhaCC();
    }

    public static void themTacgia(nhaccDTO dg, QueryCallBack q) {
        nhaccDAO.themNhaCC(dg, q);
    }

    public static void xoaTacgia(String matg, QueryCallBack q) {
        nhaccDAO.xoaNhaCC(matg, q);
    }

    public static void suaTacgia(nhaccDTO dg, QueryCallBack q) {
        nhaccDAO.suaNhaCC(dg, q);
    }
      public static String gettenNhacc(String query) {
        ArrayList<nhaccDTO> arr = getNhaCC();
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i).getMancc().contains(query)) {
                return arr.get(i).getTenncc();
            }
        }
        return "";
    }


}
