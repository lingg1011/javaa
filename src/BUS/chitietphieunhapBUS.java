/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import static BUS.chitietphieuphatBUS.timkiemChiTietPhieuPhat;
import DAO.chitietphieunhapDAO;
import DTO.chitietphieunhapDTO;
import DTO.chitietphieuphatDTO;
import DTO.phieunhapDTO;
import DTO.phieuphatDTO;
import DTO.sachDTO;
import interfaces.QueryCallBack;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Admin
 */
public class chitietphieunhapBUS {

    public static ArrayList<chitietphieunhapDTO> getChiTietPhieuNhap() {
        return chitietphieunhapDAO.getChiTietPhieuNhap();
    }

    public static void themChiTietPhieuNhap(chitietphieunhapDTO pmt, QueryCallBack q) {
        chitietphieunhapDAO.themChiTietPhieuNhap(pmt, q);
         sachDTO s=sachBUS.timkiemSach("Mã Sách", pmt.getMasach()).get(0);
            s.setSoLuongHienCo(s.getSoLuongHienCo()+pmt.getSoluong());
            s.setSoLuongCon(s.getSoLuongCon()+pmt.getSoluong());
            sachBUS.suaSach(s);
    }

    public static void xoaChiTietPhieuPhat(String mamuontra, QueryCallBack q) {
        
         chitietphieunhapDTO d =timkiemChiTietPhieuNhap("Mã Chi Tiết",mamuontra.trim()).get(0);
        phieunhapDTO a =phieunhapBUS.timkiemPhieuNhap("Mã Phiếu Nhập",d.getMaphieunhap()).get(0);
        a.setTongtien(a.getTongtien()-d.getThanhtien());
        phieunhapBUS.suaPhieuNhap(a, q);
        
            sachDTO s=sachBUS.timkiemSach("Mã Sách", d.getMasach()).get(0);
            s.setSoLuongHienCo(s.getSoLuongHienCo()-d.getSoluong());
            s.setSoLuongCon(s.getSoLuongCon()-d.getSoluong());
            sachBUS.suaSach(s);
        chitietphieunhapDAO.xoaChiTietPhieuNhap(mamuontra, q);
    }

    public static void suaChiTietPhieuPhat(chitietphieunhapDTO pmt, QueryCallBack q) {
        ArrayList<chitietphieunhapDTO> aa = getChiTietPhieuNhap();
        for (int i = 0; i < aa.size(); i++) {
            if(aa.get(i).getMachitiet().equals(pmt.getMachitiet())){
                int price=pmt.getThanhtien()-aa.get(i).getThanhtien();
                phieunhapDTO a = phieunhapBUS.timkiemPhieuNhap("Mã Phiếu Nhập",pmt.getMaphieunhap()).get(0);
//                if(price>0){
                    a.setTongtien(a.getTongtien()+price);
//                }
                phieunhapBUS.suaPhieuNhap(a, q);
                break;
            }
            
        }
        chitietphieunhapDTO a = timkiemChiTietPhieuNhap("Mã Chi Tiết", pmt.getMachitiet()).get(0);
        if(!pmt.getMasach().equals(a.getMasach())){
            sachDTO s=sachBUS.timkiemSach("Mã Sách", a.getMasach()).get(0);
            s.setSoLuongHienCo(s.getSoLuongHienCo()-a.getSoluong());
            s.setSoLuongCon(s.getSoLuongCon()-a.getSoluong());
            sachBUS.suaSach(s);
            
            sachDTO d=sachBUS.timkiemSach("Mã Sách", pmt.getMasach()).get(0);
            d.setSoLuongHienCo(d.getSoLuongHienCo()+pmt.getSoluong());
            d.setSoLuongCon(d.getSoLuongCon()+pmt.getSoluong());
            sachBUS.suaSach(d);
            
        chitietphieunhapDAO.suaChiTietPhieuNhap(pmt,q);
            
        }else{
        int sl=pmt.getSoluong()-a.getSoluong();
        sachDTO s=sachBUS.timkiemSach("Mã Sách", pmt.getMasach()).get(0);
            s.setSoLuongHienCo(s.getSoLuongHienCo()+sl);
            s.setSoLuongCon(s.getSoLuongCon()+sl);
            sachBUS.suaSach(s);
        chitietphieunhapDAO.suaChiTietPhieuNhap(pmt,q);
        }
        
    }
    public static int getTongTien(String maphieunhap){
        int tongtien =0;
        ArrayList<chitietphieunhapDTO> arr = getChiTietPhieuNhap();
        for (int i = 0; i < arr.size(); i++) {
            if(arr.get(i).getMaphieunhap().equals(maphieunhap)){
                tongtien+=arr.get(i).getThanhtien();
            }
            
        }
        return tongtien;
      
    }

    public static ArrayList<chitietphieunhapDTO> timkiemChiTietPhieuNhap(String key, String query) {
        ArrayList<chitietphieunhapDTO> temp = new ArrayList<>();
        ArrayList<chitietphieunhapDTO> nv = getChiTietPhieuNhap();
        if (key.equals("Mã Chi Tiết")) {
            for (int i = 0; i < nv.size(); i++) {
                if (nv.get(i).getMachitiet().contains(query)) {
                    temp.add(nv.get(i));
                }

            }
            return temp;
        }
        if (key.equals("Mã Phiếu Nhập")) {
            for (int i = 0; i < nv.size(); i++) {
                if (nv.get(i).getMaphieunhap().contains(query)) {
                    temp.add(nv.get(i));
                }

            }
            return temp;
        }
         if (key.equals("Mã Sách")) {
            for (int i = 0; i < nv.size(); i++) {
                if (nv.get(i).getMasach().contains(query)) {
                    temp.add(nv.get(i));
                }

            }
            return temp;
        }
       
        return null;

    }

   

}
