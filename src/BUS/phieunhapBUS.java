/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import static BUS.nhanvienBUS.getNhanVien;
import DAO.phieunhapDAO;
import DTO.chitietphieunhapDTO;
import DTO.phieunhapDTO;
import interfaces.QueryCallBack;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Administrator
 */
public class phieunhapBUS {

    public static ArrayList<phieunhapDTO> getPhieuNhap() {
        return phieunhapDAO.getPhieuNhap();
    }

    public static void themPhieuNhap(phieunhapDTO pmt, QueryCallBack q) {
        phieunhapDAO.themPhieuNhap(pmt, q);
    }

    public static void xoaPhieuNhap(String mamuontra, QueryCallBack q) {
        ArrayList<chitietphieunhapDTO> arr =chitietphieunhapBUS.getChiTietPhieuNhap();
        for (int i = 0; i < arr.size(); i++) {
            if(arr.get(i).getMaphieunhap().equals(mamuontra)){
                chitietphieunhapBUS.xoaChiTietPhieuPhat(arr.get(i).getMachitiet(),q);
            }
            
        }
        
        phieunhapDAO.xoaPhieuNhap(mamuontra, q);
    }

    public static void suaPhieuNhap(phieunhapDTO pmt, QueryCallBack q) {
        phieunhapDAO.suaPhieuNhap(pmt, q);
    }

    public static ArrayList<phieunhapDTO> timkiemPhieuNhap(String key, String query) {
        ArrayList<phieunhapDTO> temp = new ArrayList<>();
        ArrayList<phieunhapDTO> nv = getPhieuNhap();
        if (key.equals("Mã Phiếu Nhập")) {
            for (int i = 0; i < nv.size(); i++) {
                
            System.err.println("OKE1"+query+"/"+nv.get(i).getMaphieuphap());
                if (nv.get(i).getMaphieuphap().equals(query)) {
                    temp.add(nv.get(i));
                    
            System.err.println("OKE2");
                }

            }
            return temp;
        }
        if (key.equals("Nhân Viên")) {
            for (int i = 0; i < nv.size(); i++) {
                if (nhanvienBUS.getTenNhanVien(nv.get(i).getManv()).toLowerCase().contains(query)) {
                    temp.add(nv.get(i));
                }

            }
            return temp;
        }
        
         if (key.equals("Nhà Cung Cấp")) {
            for (int i = 0; i < nv.size(); i++) {
                if (nhaccBUS.gettenNhacc(nv.get(i).getManhacc()).toLowerCase().contains(query)) {
                    temp.add(nv.get(i));
                }

            }
            return temp;
        }
         
        
     
        return null;

    }
    public static ArrayList<phieunhapDTO> timkiemphieuNM(Date from,Date to){
        ArrayList<phieunhapDTO> temp=new ArrayList<>();
        ArrayList<phieunhapDTO> p = getPhieuNhap();
            for (int i = 0; i < p.size(); i++) {
                if(!p.get(i).getNgaynhap().before(from)&&!p.get(i).getNgaynhap().after(to)){
                    temp.add(p.get(i));
                }
                
            }
            return temp;
    }
}
