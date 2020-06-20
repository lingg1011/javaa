/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.chitietphieuDAO;
import DAO.phieumuontraDAO;
import DTO.chitietphieuDTO;
import DTO.chitietphieuphatDTO;
import DTO.phieumuontraDTO;
import DTO.sachDTO;
import interfaces.QueryCallBack;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Admin
 */
public class chitietphieuBUS {

    public static ArrayList<chitietphieuDTO> getChiTietPhieu() {
        return chitietphieuDAO.getChiTietPhieu();
    }

    public static void themChiTietPhieu(chitietphieuDTO pmt, QueryCallBack q) {
         sachDTO a=sachBUS.timkiemSach("Mã Sách", pmt.getMaSach()).get(0);
            a.setSoLuongCon(a.getSoLuongCon()-pmt.getSoLuong());
            sachBUS.suaSach(a);
        chitietphieuDAO.themChiTietPhieu(pmt, q);
    }

    public static void xoaChiTietPhieu(String mamuontra, QueryCallBack q) {
        chitietphieuDAO.xoaChiTietPhieu(mamuontra, q);
    }

    public static void suaPhieuMuonTra(chitietphieuDTO pmt, QueryCallBack q) {
         chitietphieuDTO s=chitietphieuBUS.timkiemChiTietPhieu("Mã Chi Tiết",pmt.getMaChitiet()).get(0);
            if(s.getDaTra()==0&&pmt.getDaTra()==0){
            int sl=s.getSoLuong()-pmt.getSoLuong();
            sachDTO a=sachBUS.timkiemSach("Mã Sách", pmt.getMaSach()).get(0);
            a.setSoLuongCon(a.getSoLuongCon()+sl);
           sachBUS.suaSach(a);
            }else if(pmt.getDaTra()==1){
                sachDTO a=sachBUS.timkiemSach("Mã Sách", pmt.getMaSach()).get(0);
            a.setSoLuongCon(a.getSoLuongCon()+pmt.getSoLuong());
           sachBUS.suaSach(a);
            }
        chitietphieuDAO.suaChiTietPhieu(pmt, q);
    }

    public static ArrayList<chitietphieuDTO> timkiemChiTietPhieu(String key, String query) {
        ArrayList<chitietphieuDTO> temp = new ArrayList<>();
        ArrayList<chitietphieuDTO> nv = getChiTietPhieu();
        if (key.equals("Mã Chi Tiết")) {
            for (int i = 0; i < nv.size(); i++) {
                if (nv.get(i).getMaChitiet().contains(query)) {
                    temp.add(nv.get(i));
                }

            }
            return temp;
        }
        if (key.equals("Mã Mượn Trả")) {
            for (int i = 0; i < nv.size(); i++) {
                if (nv.get(i).getMaMuonTra().contains(query)) {
                    temp.add(nv.get(i));
                }

            }
            return temp;
        }
        if (key.equals("Sách")) {
            for (int i = 0; i < nv.size(); i++) {
                if (nv.get(i).getMaSach().contains(query)) {
                    temp.add(nv.get(i));
                }

            }
            return temp;
        }
        if (key.equals("Số Lượng")) {
            for (int i = 0; i < nv.size(); i++) {
                if (nv.get(i).getSoLuong() == Integer.parseInt(query)) {
                    temp.add(nv.get(i));
                }

            }
            return temp;
        }

        if (key.equals("Đã Trả")) {
            for (int i = 0; i < nv.size(); i++) {
                if (nv.get(i).getDaTra() == Integer.parseInt(query)) {
                    temp.add(nv.get(i));
                }

            }
            return temp;
        }
        return null;

    }

    public static ArrayList<chitietphieuDTO> timkiemphieuNT(Date from, Date to) {
        ArrayList<chitietphieuDTO> temp = new ArrayList<>();
        ArrayList<chitietphieuDTO> p = getChiTietPhieu();
        for (int i = 0; i < p.size(); i++) {
            if (!p.get(i).getNgayTra().before(from) && !p.get(i).getNgayTra().after(to)) {
                temp.add(p.get(i));
            }

        }
        return temp;
    }

    public static ArrayList<chitietphieuDTO> thongkePhieuMuonTra(Date hanTraFrom, Date hanTraTo, Date ngayTraFrom, Date ngayTraTo) {
        ArrayList<chitietphieuDTO> temp = new ArrayList<>();
        ArrayList<chitietphieuDTO> p = getChiTietPhieu();
        for (int i = 0; i < p.size(); i++) {
            if(p.get(i).getNgayTra()!=null && ngayTraFrom !=null&&ngayTraTo!=null)
            {
            if (!p.get(i).getNgayTra().before(ngayTraFrom) && !p.get(i).getNgayTra().after(ngayTraTo)
                    && !p.get(i).getHanTra().after(hanTraTo) && !p.get(i).getHanTra().before(hanTraFrom)) {
                temp.add(p.get(i));
            }
            }
        }
        return temp;
    }

    public static ArrayList<chitietphieuDTO> timkiemphieuHT(Date from, Date to) {
        ArrayList<chitietphieuDTO> temp = new ArrayList<>();
        ArrayList<chitietphieuDTO> p = getChiTietPhieu();
        for (int i = 0; i < p.size(); i++) {
            if (!p.get(i).getHanTra().before(from) && !p.get(i).getHanTra().after(to)) {
                temp.add(p.get(i));
            }

        }
        return temp;
    }

}
