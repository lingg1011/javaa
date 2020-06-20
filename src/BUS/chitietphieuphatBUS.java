/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import static BUS.chitietphieunhapBUS.getChiTietPhieuNhap;
import DAO.chitietphieuphatDAO;
import DTO.chitietphieunhapDTO;
import DTO.chitietphieuphatDTO;
import DTO.phieumuontraDTO;
import DTO.phieuphatDTO;
import DTO.sachDTO;
import interfaces.QueryCallBack;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Admin
 */
public class chitietphieuphatBUS {

    public static ArrayList<chitietphieuphatDTO> getChiTietPhieuPhat() {
        return chitietphieuphatDAO.getChiTietPhieuPhat();
    }

    public static void themChiTietPhieuPhat(chitietphieuphatDTO pmt, QueryCallBack q) {
        if(pmt.getTinhtrangsach()==1){
            sachDTO a=sachBUS.timkiemSach("Mã Sách", pmt.getMasach()).get(0);
            a.setSoLuongHienCo(a.getSoLuongHienCo()-pmt.getSoluong());
            sachBUS.suaSach(a);
        }
        
        chitietphieuphatDAO.themChiTietPhieuPhat(pmt, q);
    }

    public static void xoaChiTietPhieuPhat(String mamuontra, QueryCallBack q) {
        chitietphieuphatDTO d =timkiemChiTietPhieuPhat("Mã Chi Tiết",mamuontra.trim()).get(0);
        phieuphatDTO a =phieuphatBUS.timkiemPhieuMuonTra("Mã Phiếu Phạt",d.getMaphieuphat()).get(0);
        a.setTongtien(a.getTongtien()-d.getTienphat());
        phieuphatBUS.suaPhieuMuonTra(a, q);
        if(d.getTinhtrangsach()==1){
             sachDTO s=sachBUS.timkiemSach("Mã Sách", d.getMasach()).get(0);
            s.setSoLuongHienCo(s.getSoLuongHienCo()+d.getSoluong());
            sachBUS.suaSach(s);
        }
        chitietphieuphatDAO.xoaChiTietPhieuPhat(mamuontra, q);
    }

    public static void suaChiTietPhieuPhat(chitietphieuphatDTO pmt, QueryCallBack q) {
          chitietphieuphatDTO s=chitietphieuphatBUS.timkiemChiTietPhieuPhat("Mã Chi Tiết",pmt.getMachitiet()).get(0);
            
        if(s.getTinhtrangsach()==1&&pmt.getTinhtrangsach()==1){
            int sl=s.getSoluong()-pmt.getSoluong();
            sachDTO a=sachBUS.timkiemSach("Mã Sách", pmt.getMasach()).get(0);
            a.setSoLuongHienCo(a.getSoLuongHienCo()+sl);
            sachBUS.suaSach(a);
        }else if(s.getTinhtrangsach()==1&&pmt.getTinhtrangsach()!=1){
            sachDTO a=sachBUS.timkiemSach("Mã Sách", pmt.getMasach()).get(0);
            a.setSoLuongHienCo(a.getSoLuongHienCo()+s.getSoluong());
            sachBUS.suaSach(a);
        }else if(pmt.getTinhtrangsach()==1){
            sachDTO a=sachBUS.timkiemSach("Mã Sách", pmt.getMasach()).get(0);
            a.setSoLuongHienCo(a.getSoLuongHienCo()-pmt.getSoluong());
            sachBUS.suaSach(a);
        }
        phieuphatDTO a =phieuphatBUS.timkiemPhieuMuonTra("Mã Phiếu Phạt",pmt.getMaphieuphat()).get(0);
        int tien=pmt.getTienphat()-s.getTienphat();
        a.setTongtien(a.getTongtien()+tien);
        phieuphatBUS.suaPhieuMuonTra(a, q);
        chitietphieuphatDAO.suaChiTietPhieuPhat(pmt, q);
    }
     public static int getTongTien(String maphieunhap){
        int tongtien =0;
        ArrayList<chitietphieuphatDTO> arr = getChiTietPhieuPhat();
        for (int i = 0; i < arr.size(); i++) {
            if(arr.get(i).getMaphieuphat().equals(maphieunhap)){
                tongtien+=arr.get(i).getTienphat();
            }
            
        }
        return tongtien;
      
    }

    public static ArrayList<chitietphieuphatDTO> timkiemChiTietPhieuPhat(String key, String query) {
        ArrayList<chitietphieuphatDTO> temp = new ArrayList<>();
        ArrayList<chitietphieuphatDTO> nv = getChiTietPhieuPhat();
        if (key.equals("Mã Chi Tiết")) {
            for (int i = 0; i < nv.size(); i++) {
                if (nv.get(i).getMachitiet().equals(query)) {
                    temp.add(nv.get(i));
                }

            }
            return temp;
        }
        if (key.equals("Mã Phiếu Phạt")) {
            for (int i = 0; i < nv.size(); i++) {
                if (nv.get(i).getMaphieuphat().contains(query)) {
                    temp.add(nv.get(i));
                }

            }
            return temp;
        }
         if (key.equals("Tên Sách")) {
            for (int i = 0; i < nv.size(); i++) {
                if (sachBUS.getTenSach(nv.get(i).getMasach()).toLowerCase().contains(query)) {
                    temp.add(nv.get(i));
                }

            }
            return temp;
        }
       
        return null;

    }

   

}
