/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.docgiaDAO;
import DAO.nxbDAO;
import DAO.phieumuontraDAO;
import DAO.tacgiaDAO;
import DAO.theloaiDAO;
import DTO.docgiaDTO;
import DTO.nxbDTO;
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
public class nxbBUS {

    public static ArrayList<nxbDTO> getNXB() {
        return nxbDAO.getNXB();
    }

    public static void themNXB(nxbDTO dg, QueryCallBack q) {
        nxbDAO.themNXB(dg, q);
    }

    public static void xoaNXB(String manxb, QueryCallBack q) {
        nxbDAO.xoaNXB(manxb, q);
    }

    public static void suaNXB(nxbDTO dg, QueryCallBack q) {
        nxbDAO.suaNXB(dg, q);
    }


}
