/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.docgiaDAO;
import DAO.phieumuontraDAO;
import DTO.docgiaDTO;
import DTO.phieumuontraDTO;
import interfaces.QueryCallBack;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Administrator
 */
public class docgiaBUS {

    public static ArrayList<docgiaDTO> getDocGia() {
        return docgiaDAO.getDocGia();
    }

    public static void themDocGia(docgiaDTO dg, QueryCallBack q) {
        docgiaDAO.themDocGia(dg, q);
    }

    public static void xoaDocGia(String madocgia, QueryCallBack q) {
        docgiaDAO.xoaDocGia(madocgia, q);
    }

    public static void suaDocGia(docgiaDTO dg, QueryCallBack q) {
        docgiaDAO.suaDocGia(dg, q);
    }

    public static ArrayList<docgiaDTO> timkiemDocGia(String key, String query) {
        ArrayList<docgiaDTO> temp = new ArrayList<>();
        ArrayList<docgiaDTO> nv = getDocGia();
        if (key.equals("Mã Đọc Giả")) {
            for (int i = 0; i < nv.size(); i++) {
                if (nv.get(i).getMaDocGia().toLowerCase().contains(query)) {
                    temp.add(nv.get(i));
                }

            }
            return temp;
        }
        if (key.equals("Tên Đọc Giả")) {
            for (int i = 0; i < nv.size(); i++) {
                if (nv.get(i).getTenDocGia().toLowerCase().contains(query)) {
                    temp.add(nv.get(i));
                }

            }
            return temp;
        }
        if (key.equals("Địa Chỉ")) {
            for (int i = 0; i < nv.size(); i++) {
                if (nv.get(i).getDiaChi().toLowerCase().contains(query)) {
                    temp.add(nv.get(i));
                }

            }
            return temp;
        }
        if (key.equals("Sđt")) {
            for (int i = 0; i < nv.size(); i++) {
                if (nv.get(i).getSdt().toLowerCase().contains(query)) {
                    temp.add(nv.get(i));
                }

            }
            return temp;
        }

        return null;

    }

    public static String getTenDocGia(String query) {
        ArrayList<docgiaDTO> nv = getDocGia();
        for (int i = 0; i < nv.size(); i++) {
            if (nv.get(i).getMaDocGia().contains(query)) {
                return nv.get(i).getTenDocGia();
            }
        }
        return "";
    }

    public static ArrayList<docgiaDTO> timkiemDocGia(Date from, Date to) {
        ArrayList<docgiaDTO> temp = new ArrayList<>();
        ArrayList<docgiaDTO> nv = getDocGia();
        for (int i = 0; i < nv.size(); i++) {
            if (!nv.get(i).getNgayCap().before(from) && !nv.get(i).getNgayCap().after(to)) {
                temp.add(nv.get(i));
            }

        }
        return temp;

    }

}
