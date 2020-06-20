/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.docgiaDAO;
import DAO.phieumuontraDAO;
import DAO.sachDAO;
import DTO.chitietphieuDTO;
import DTO.docgiaDTO;
import DTO.phieumuontraDTO;
import DTO.sachDTO;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrator
 */
public class thongkeBUS {
    public static int TongSoSach()
    {
        ArrayList<sachDTO> arr= sachDAO.getSach();
        return arr.size();
    }
    public static int TongSoDocGia()
    {
        ArrayList<docgiaDTO> arr= docgiaDAO.getDocGia();
        return arr.size();
    }
    public static int TongSoPhieuMuon()
    {
        ArrayList<phieumuontraDTO> arr= phieumuontraDAO.getPhieuMuonTra();
        return arr.size();
    }
     public static int TongSoNguoiMuonSach()
    {   int tam=0;int dem=0;
        ArrayList<phieumuontraDTO> arr= phieumuontraDAO.getPhieuMuonTra();
        for(int i=0;i<arr.size();i++)
        {
            for(int j=i;j>0;j--)
            {   tam=0;
                 if(arr.get(i).getMaDocGia().equals(arr.get(j).getMaDocGia())) tam=1;
            }
            if(tam==1) dem++;
        }
        return dem;
    }
     public static ArrayList<chitietphieuDTO> getTraQuaHan ()
     {  ArrayList<chitietphieuDTO> arr= chitietphieuBUS.getChiTietPhieu();
        ArrayList<chitietphieuDTO> array = new ArrayList<chitietphieuDTO>();
        {for(int i=0;i<arr.size();i++)
        {
            if(arr.get(i).getNgayTra()!=null){
        if(arr.get(i).getHanTra().compareTo(arr.get(i).getNgayTra())>0) {array.add(arr.get(i));}
        }
        }
        
        return array;
     }
     }
     public static int TongSoTraQuaHan()
     {
         ArrayList<chitietphieuDTO> arr=getTraQuaHan();
         return arr.size();
     }
}
