/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import static BUS.nhanvienBUS.getNhanVien;
import DAO.phieumuontraDAO;
import DAO.phieuphatDAO;
import DTO.chitietphieuphatDTO;
import DTO.nhanvienDTO;
import DTO.phieumuontraDTO;
import DTO.phieuphatDTO;
import DTO.thongKeNhanVienDTO;
import interfaces.QueryCallBack;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Administrator
 */
public class phieuphatBUS {

    public static ArrayList<phieuphatDTO> getPhieuPhat() {
        return phieuphatDAO.getPhieuPhat();
    }

    public static void themPhieuPhat(phieuphatDTO pmt, QueryCallBack q) {
        phieuphatDAO.themPhieuPhat(pmt, q);
    }

    public static void xoaPhieuMuonTra(String mamuontra, QueryCallBack q) {
        ArrayList<chitietphieuphatDTO> arr =chitietphieuphatBUS.getChiTietPhieuPhat();
        for (int i = 0; i < arr.size(); i++) {
            if(arr.get(i).getMaphieuphat().equals(mamuontra)){
                chitietphieuphatBUS.xoaChiTietPhieuPhat(arr.get(i).getMachitiet(),q);
            }
            
        }
        
        phieuphatDAO.xoaPhieuPhat(mamuontra, q);
    }

    public static void suaPhieuMuonTra(phieuphatDTO pmt, QueryCallBack q) {
        phieuphatDAO.suaPhieuPhat(pmt, q);
    }

    public static ArrayList<phieuphatDTO> timkiemPhieuMuonTra(String key, String query) {
        ArrayList<phieuphatDTO> temp = new ArrayList<>();
        ArrayList<phieuphatDTO> nv = getPhieuPhat();
        if (key.equals("Mã Phiếu Phạt")) {
            for (int i = 0; i < nv.size(); i++) {
                if (nv.get(i).getMaphieuphat().contains(query)) {
                    temp.add(nv.get(i));
                }

            }
            return temp;
        }
        if (key.equals("Mã Mượn Trả")) {
            for (int i = 0; i < nv.size(); i++) {
                if (nv.get(i).getMamuontra().contains(query)) {
                    temp.add(nv.get(i));
                }

            }
            return temp;
        }
        if (key.equals("Nhân Viên")) {
            for (int i = 0; i < nv.size(); i++) {
                if (nv.get(i).getManv().contains(query)) {
                    temp.add(nv.get(i));
                }

            }
            return temp;
        }
     
        return null;

    }
    
    public static ArrayList<phieuphatDTO> timkiemNL(Date from,Date to){
        ArrayList<phieuphatDTO> temp=new ArrayList<>();
        ArrayList<phieuphatDTO> p = getPhieuPhat();
            for (int i = 0; i < p.size(); i++) {
                if(!p.get(i).getNgaylap().before(from)&&!p.get(i).getNgaylap().after(to)){
                    temp.add(p.get(i));
                }
                
            }
            return temp;
    }
    
   
    

}
