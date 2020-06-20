/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BUS;

import static BUS.docgiaBUS.getDocGia;
import static BUS.sachBUS.getSach;
import DAO.nhanvienDAO;
import DAO.phieumuontraDAO;
import DTO.docgiaDTO;
import DTO.nhanvienDTO;
import DTO.phieumuontraDTO;
import DTO.sachDTO;
import interfaces.QueryCallBack;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author cdphuc
 */
public class nhanvienBUS {

    public static ArrayList<nhanvienDTO> getNhanVien(){
        return nhanvienDAO.getNhanVien();
    }
    public static nhanvienDTO kiemtradangnhap(String manv,String password){
        ArrayList<nhanvienDTO> arr = getNhanVien();
        for (int i = 0; i < arr.size(); i++) {
            if(arr.get(i).getMaNV().trim().toLowerCase().equals(manv.trim().toLowerCase())){
                if(arr.get(i).getPassword().trim().equals(password.trim())){
                    
                    return arr.get(i);
                }
            }
            
        }
        return null;
    }
    public static void themNhanVien(nhanvienDTO nv,QueryCallBack q){
        nhanvienDAO.themNhanVien(nv, q);
    }
    public static void xoaNhanVien(String manv,QueryCallBack q){
        nhanvienDAO.xoaNhanVien(manv, q);
    }
    public static void suaNhanVien(nhanvienDTO nv,QueryCallBack q){
        nhanvienDAO.suaNhanVien(nv, q);
    }
    public static String getTenNhanVien(String query) {
        ArrayList<nhanvienDTO> nv = getNhanVien();
        for (int i = 0; i < nv.size(); i++) {
            if (nv.get(i).getMaNV().contains(query)) {
                return nv.get(i).getTenNhanVien();
            }
        }
        return "";
    }
    
    public static nhanvienDTO thongkeNhanVien(String query) {
        ArrayList<nhanvienDTO> nv = getNhanVien();
        for (int i = 0; i < nv.size(); i++) {
            if (nv.get(i).getMaNV().contains(query)) {
                return nv.get(i);
            }
        }
        return null;
    }
    
     public static ArrayList<nhanvienDTO> timkiemnhanvien(String key,String query){
        ArrayList<nhanvienDTO> temp=new ArrayList<>();
        ArrayList<nhanvienDTO> nv = getNhanVien();
        if(key.equals("Mã Nhân Viên")){
            for (int i = 0; i < nv.size(); i++) {
                if(nv.get(i).getMaNV().toLowerCase().contains(query)){
                    temp.add(nv.get(i));
                }
                
            }
            return temp;
        }
          if(key.equals("Tên Nhân Viên")){
               for (int i = 0; i < nv.size(); i++) {
                if(nv.get(i).getTenNhanVien().toLowerCase().contains(query)){
                    temp.add(nv.get(i));
                }
                
            }
            return temp;
        }
           
              if(key.equals("SĐT")){
                   for (int i = 0; i < nv.size(); i++) {
                if(nv.get(i).getSdt().toLowerCase().contains(query)){
                    temp.add(nv.get(i));
                }
                
            }
            return temp;
        }
                if(key.equals("Địa Chỉ")){
                     for (int i = 0; i < nv.size(); i++) {
                if(nv.get(i).getDiaChi().toLowerCase().contains(query)){
                    temp.add(nv.get(i));
                }
                
            }
            return temp;
        }
            return null;
            
 
    }
       public static ArrayList<nhanvienDTO> timkiemnhanvien(Date from,Date to){
        ArrayList<nhanvienDTO> temp=new ArrayList<>();
        ArrayList<nhanvienDTO> nv = getNhanVien();
            for (int i = 0; i < nv.size(); i++) {
                if(!nv.get(i).getNgaysinh().before(from)&&!nv.get(i).getNgaysinh().after(to)){
                    temp.add(nv.get(i));
                }
                
            }
            return temp;
        
 
    }
   
   

}
