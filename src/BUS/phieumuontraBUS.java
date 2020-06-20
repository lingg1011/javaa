/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import static BUS.nhanvienBUS.getNhanVien;
import DAO.phieumuontraDAO;
import DTO.nhanvienDTO;
import DTO.phieumuontraDTO;
import DTO.thongKeNhanVienDTO;
import interfaces.QueryCallBack;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Administrator
 */
public class phieumuontraBUS {

    public static ArrayList<phieumuontraDTO> getPhieuMuonTra() {
        return phieumuontraDAO.getPhieuMuonTra();
    }

    public static void themPhieuMuonTra(phieumuontraDTO pmt, QueryCallBack q) {
        phieumuontraDAO.themPhieuMuonTra(pmt, q);
    }

    public static void xoaPhieuMuonTra(String mamuontra, QueryCallBack q) {
        phieumuontraDAO.xoaPhieuMuonTra(mamuontra, q);
    }

    public static void suaPhieuMuonTra(phieumuontraDTO pmt, QueryCallBack q) {
        phieumuontraDAO.suaPhieuMuonTra(pmt, q);
    }

    public static ArrayList<phieumuontraDTO> timkiemPhieuMuonTra(String key, String query) {
        ArrayList<phieumuontraDTO> temp = new ArrayList<>();
        ArrayList<phieumuontraDTO> nv = getPhieuMuonTra();
        if (key.equals("Mã Mượn Trả")) {
            for (int i = 0; i < nv.size(); i++) {
                if (nv.get(i).getMaMuonTra().toLowerCase().contains(query)) {
                    temp.add(nv.get(i));
                }

            }
            return temp;
        }
        if (key.equals("Đọc Giả")) {
            for (int i = 0; i < nv.size(); i++) {
                if (docgiaBUS.getTenDocGia(nv.get(i).getMaDocGia().toLowerCase()).toLowerCase().contains(query)) {
                    temp.add(nv.get(i));
                }

            }
            return temp;
        }
        if (key.equals("Nhân Viên")) {
            for (int i = 0; i < nv.size(); i++) {
                if (nhanvienBUS.getTenNhanVien(nv.get(i).getMaNhanVien().toLowerCase()).toLowerCase().contains(query)) {
                    temp.add(nv.get(i));
                }

            }
            return temp;
        }

        if (key.equals("Ghi Chú")) {
            for (int i = 0; i < nv.size(); i++) {
                if (nv.get(i).getGhiChu().toLowerCase().contains(query)) {
                    temp.add(nv.get(i));
                }

            }
            return temp;
        }
        return null;

    }
    
    public static ArrayList<phieumuontraDTO> timkiemphieuNM(Date from,Date to){
        ArrayList<phieumuontraDTO> temp=new ArrayList<>();
        ArrayList<phieumuontraDTO> p = getPhieuMuonTra();
            for (int i = 0; i < p.size(); i++) {
                if(!p.get(i).getNgayMuon().before(from)&&!p.get(i).getNgayMuon().after(to)){
                    temp.add(p.get(i));
                }
                
            }
            return temp;
    }
    
    public static ArrayList<thongKeNhanVienDTO> thongKeNhanVien(Date from,Date to){
        ArrayList<phieumuontraDTO> p = getPhieuMuonTra();
        ArrayList<nhanvienDTO> nv=getNhanVien();
        ArrayList<thongKeNhanVienDTO> dsnv = new ArrayList<>();
            for (int i = 0; i < p.size(); i++) {
                if(!p.get(i).getNgayMuon().before(from)&&!p.get(i).getNgayMuon().after(to)){
                    for (int j = 0; j < nv.size(); j++) {
                        if(nv.get(j).getMaNV().equals(p.get(i).getMaNhanVien())){
                            thongKeNhanVienDTO a = new thongKeNhanVienDTO();
                            a.setMaNV(p.get(i).getMaNhanVien());
                            a.setTenNhanVien(nv.get(j).getTenNhanVien());
                            a.setNgaylap(p.get(i).getNgayMuon());
                            a.setMaphieumuon(p.get(i).getMaMuonTra());
                            dsnv.add(a);
                        }
                        
                    }
                } 
            }
        return dsnv;
    }
    
//    public static ArrayList<phieumuontraDTO> timkiemphieuHT(Date from,Date to){
//        ArrayList<phieumuontraDTO> temp=new ArrayList<>();
//        ArrayList<phieumuontraDTO> p = getPhieuMuonTra();
//            for (int i = 0; i < p.size(); i++) {
//                if(!p.get(i).getNgayTra().before(from)&&!p.get(i).getNgayTra().after(to)){
//                    temp.add(p.get(i));
//                }
//                
//            }
//            return temp;
//    }

}
