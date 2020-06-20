/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.docgiaDAO;
import DAO.phieumuontraDAO;
import DAO.tacgiaDAO;
import DAO.theloaiDAO;
import DTO.docgiaDTO;
import DTO.phieumuontraDTO;
import DTO.tacgiaDTO;
import DTO.theloaiDTO;
import interfaces.QueryCallBack;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Administrator
 */
public class theloaiBus {

    public static ArrayList<theloaiDTO> getTheloaiu() {
        return theloaiDAO.getTheloai();
    }

    public static void themTheloai(theloaiDTO dg, QueryCallBack q) {
        theloaiDAO.themTheloai(dg, q);
    }

    public static void xoaTheLoai(String matl, QueryCallBack q) {
        theloaiDAO.xoaTheloai(matl, q);
    }

    public static void suaTheLoai(theloaiDTO dg, QueryCallBack q) {
        theloaiDAO.suaTheloai(dg, q);
    }


}
