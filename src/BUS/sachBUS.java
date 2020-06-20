/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.sachDAO;
import DTO.nhanvienDTO;
import DTO.sachDTO;
import interfaces.QueryCallBack;
import java.util.ArrayList;

/**
 *
 * @author cdphuc
 */
public class sachBUS {

    public static ArrayList<sachDTO> getSach() {
        return sachDAO.getSach();
    }

    public static void themSach(sachDTO s, QueryCallBack q) {
        sachDAO.themSach(s, q);
    }

    public static void xoaSach(String masach, QueryCallBack q) {
        sachDAO.xoaSach(masach, q);
    }

    public static void suaSach(sachDTO s, QueryCallBack q) {
        sachDAO.suaSach(s, q);
    }
     public static void suaSach(sachDTO s) {
        sachDAO.suaSach(s);
    }
     public static void suaSach(String masach, int sl) {
         ArrayList<sachDTO> arr = getSach();
         for (int i = 0; i < arr.size(); i++) {
             if(arr.get(i).getMaSach().equals(masach)){
                 sachDTO a = new sachDTO();
                 a.setDongia(arr.get(i).getDongia());
                 a.setMaSach(arr.get(i).getMaSach());
                 a.setNhaXuatBan(arr.get(i).getNhaXuatBan());
                 a.setSoLuongCon(arr.get(i).getSoLuongCon()+sl);
                 a.setSoLuongHienCo(arr.get(i).getSoLuongHienCo()+sl);
                 a.setTenSach(arr.get(i).getTenSach());
                 a.setTenTacGia(arr.get(i).getTenTacGia());
                 a.setTheLoai(arr.get(i).getTheLoai());
                 
                 sachDAO.suaSach(a);
                 System.err.println("OKE");
                 return;
             }
             
         }
                 System.err.println("FAIL");
    }

    public static ArrayList<sachDTO> thongkesach(String theloai, String nhaXuatBan, String tacGia) {
        System.err.println(""+theloai+"/"+nhaXuatBan+"/"+tacGia);
        ArrayList<sachDTO> temp = new ArrayList<>();
        ArrayList<sachDTO> nv = getSach();
        for (int i = 0; i < nv.size(); i++) {
            if (nv.get(i).getTheLoai().toLowerCase().contains(theloai.toLowerCase())
                    && nv.get(i).getNhaXuatBan().toLowerCase().contains(nhaXuatBan.toLowerCase())
                    && nv.get(i).getTenTacGia().toLowerCase().contains(tacGia.toLowerCase())) {
                temp.add(nv.get(i));
            }
        }
        return temp;
    }

    public static ArrayList<sachDTO> timkiemSach(String key, String query) {
        ArrayList<sachDTO> temp = new ArrayList<>();
        ArrayList<sachDTO> nv = getSach();
        if (key.equals("Mã Sách")) {
            for (int i = 0; i < nv.size(); i++) {
                if (nv.get(i).getMaSach().toLowerCase().contains(query)) {
                    temp.add(nv.get(i));
                }

            }
            return temp;
        }
        if (key.equals("Tên Sách")) {
            for (int i = 0; i < nv.size(); i++) {
                if (nv.get(i).getTenSach().toLowerCase().contains(query)) {
                    temp.add(nv.get(i));
                }

            }
            return temp;
        }
        if (key.equals("Tên Tác Giả")) {
            for (int i = 0; i < nv.size(); i++) {
                if (nv.get(i).getTenTacGia().toLowerCase().contains(query)) {
                    temp.add(nv.get(i));
                }

            }
            return temp;
        }
        if (key.equals("Thể Loại")) {
            for (int i = 0; i < nv.size(); i++) {
                if (nv.get(i).getTheLoai().toLowerCase().contains(query)) {
                    temp.add(nv.get(i));
                }

            }
            return temp;
        }
        if (key.equals("Nhà Xuất Bản")) {
            for (int i = 0; i < nv.size(); i++) {
                if (nv.get(i).getNhaXuatBan().toLowerCase().contains(query)) {
                    temp.add(nv.get(i));
                }

            }
            return temp;
        }

        return null;

    }

    public static ArrayList<sachDTO> timkiemSach(String key, String query, int from, int to) {
        ArrayList<sachDTO> temp = new ArrayList<>();
        ArrayList<sachDTO> nv = getSach();
        if (key.equals("Số Lượng")) {
            for (int i = 0; i < nv.size(); i++) {
                if (nv.get(i).getSoLuongHienCo() >= from && nv.get(i).getSoLuongHienCo() <= to) {
                    temp.add(nv.get(i));
                }

            }
            return temp;
        }
        if (key.equals("Số Lượng Còn")) {
            for (int i = 0; i < nv.size(); i++) {
                if (nv.get(i).getSoLuongCon() >= from && nv.get(i).getSoLuongCon() <= to) {
                    temp.add(nv.get(i));
                }

            }
            return temp;
        }
        return null;

    }

    public static int getSoLuongMax(int type) {
        int max = 0;
        int max2 = 0;
        ArrayList<sachDTO> arr = getSach();
        for (int i = 0; i < arr.size(); i++) {

            if (arr.get(i).getSoLuongHienCo() > max) {
                max = arr.get(i).getSoLuongHienCo();
            }
            if (arr.get(i).getSoLuongCon() > max2) {
                max2 = arr.get(i).getSoLuongCon();
            }
        }
        if (type == 1) {
            return max2;
        }
        return max;
    }

    public static String getTenSach(String query) {
        ArrayList<sachDTO> arr = getSach();
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i).getMaSach().contains(query)) {
                return arr.get(i).getTenSach();
            }
        }
        return "";
    }
     public static int getDonGia(String query) {
        ArrayList<sachDTO> arr = getSach();
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i).getMaSach().contains(query)) {
                return arr.get(i).getDongia();
            }
        }
        return 0;
    }
     public static int getSoluong(String query)
     {  
         
          ArrayList<sachDTO> arr = getSach();
        for (int i = 0; i < arr.size(); i++) {
        if(arr.get(i).getMaSach().equals(query)) {return arr.get(i).getSoLuongCon();}   
     }
        return 0;
}
}
