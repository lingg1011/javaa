/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.docgiaDAO;
import DAO.phieumuontraDAO;
import DAO.tacgiaDAO;
import DTO.docgiaDTO;
import DTO.phieumuontraDTO;
import DTO.tacgiaDTO;
import interfaces.QueryCallBack;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Administrator
 */
public class tacgiaBUS {

    public static ArrayList<tacgiaDTO> getTacgia() {
        return tacgiaDAO.getTacgia();
    }

    public static void themTacgia(tacgiaDTO dg, QueryCallBack q) {
        tacgiaDAO.themtacgia(dg, q);
    }

    public static void xoaTacgia(String matg, QueryCallBack q) {
        tacgiaDAO.xoaTacgia(matg, q);
    }

    public static void suaTacgia(tacgiaDTO dg, QueryCallBack q) {
        tacgiaDAO.suaTacgia(dg, q);
    }


}
