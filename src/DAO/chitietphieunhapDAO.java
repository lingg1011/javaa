/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.chitietphieunhapDTO;
import interfaces.QueryCallBack;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import untils.MysqlDataAccessHelper;

/**
 *
 * @author Admin
 */
public class chitietphieunhapDAO {
    public static ArrayList<chitietphieunhapDTO> getChiTietPhieuNhap(){
        ArrayList<chitietphieunhapDTO> arr = new ArrayList<>();
        String sql = "select * from chitietphieunhap";
        MysqlDataAccessHelper my = new MysqlDataAccessHelper();
        try {
            ResultSet rs = my.excuteQuery(sql);
            while(rs.next()){
                chitietphieunhapDTO ctp = new chitietphieunhapDTO();
                ctp.setMachitiet(rs.getString("chitietphieunhap"));
                ctp.setMaphieunhap(rs.getString("maphieunhap"));
                ctp.setMasach(rs.getString("masach"));
                ctp.setSoluong(rs.getInt("soluong"));
                ctp.setDongia(rs.getInt("dongia"));
                ctp.setThanhtien(rs.getInt("thanhtien"));
                arr.add(ctp);
            }
        } catch (SQLException ex) {
            my.displayError(ex);
        } finally{
            my.close();
        }
        return arr;
    }

    public static void themChiTietPhieuNhap(chitietphieunhapDTO pmt,QueryCallBack q) {
           // create the mysql insert preparedstatement
           ArrayList<chitietphieunhapDTO> arr = getChiTietPhieuNhap();
           for (int i = 0; i < arr.size(); i++) {
               if(arr.get(i).getMachitiet().equals(pmt.getMachitiet())){
                   q.onFailed("Mã chi tiet đã tồn tại");
                   return;
               }
        }
      String sql = "insert into chitietphieunhap (chitietphieunhap,maphieunhap,masach,soluong,dongia,thanhtien) values (?,?, ?, ?,?,?)";
      MysqlDataAccessHelper my = new MysqlDataAccessHelper();
      PreparedStatement preparedStmt;
        try {
            preparedStmt = my.conn.prepareStatement(sql);
            preparedStmt.setString(1,pmt.getMachitiet());
            preparedStmt.setString(2,pmt.getMaphieunhap());
            preparedStmt.setString(3,pmt.getMasach());
            preparedStmt.setInt(4,pmt.getSoluong());
            preparedStmt.setInt(5,pmt.getDongia());
            preparedStmt.setInt(6,pmt.getThanhtien());
            preparedStmt.execute();
            q.onSuccess();
        } catch (SQLException ex) {
            my.displayError(ex);
            q.onFailed(ex.toString());
        }finally{
            my.close();
        }

    }
     public static void xoaChiTietPhieuNhap(String chitietphieuphat,QueryCallBack q) {
           // create the mysql insert preparedstatement
      String query = "delete from chitietphieunhap where chitietphieunhap=?";
      MysqlDataAccessHelper my = new MysqlDataAccessHelper();
      PreparedStatement preparedStmt;
       try {
            preparedStmt = my.conn.prepareStatement(query);
            preparedStmt.setString(1,String.valueOf(chitietphieuphat));
            preparedStmt.execute();
            q.onSuccess();
        } catch (SQLException ex) {
            my.displayError(ex);
            q.onFailed(ex.toString());
        }finally{
            my.close();
        }
    }
       public static void suaChiTietPhieuNhap(chitietphieunhapDTO pmt,QueryCallBack q) {
           // create the mysql insert preparedstatement
      String query = "UPDATE chitietphieunhap SET maphieunhap = ?,masach = ?, soluong = ?, dongia = ?, thanhtien = ? WHERE chitietphieunhap = ?";
  
      MysqlDataAccessHelper my = new MysqlDataAccessHelper();
      PreparedStatement preparedStmt;
       try {
            preparedStmt = my.conn.prepareStatement(query);
            System.err.println(""+pmt.getMaphieunhap());
            System.err.println(""+pmt.getMasach());
            System.err.println(""+pmt.getSoluong());
            System.err.println(""+pmt.getDongia());
            System.err.println(""+pmt.getThanhtien());
            System.err.println(""+pmt.getMachitiet());
            preparedStmt.setString(1,pmt.getMaphieunhap());
            preparedStmt.setString(2,pmt.getMasach());
            preparedStmt.setInt(3,pmt.getSoluong());
            preparedStmt.setInt(4,pmt.getDongia());
            preparedStmt.setInt(5,pmt.getThanhtien());
            preparedStmt.setString(6,pmt.getMachitiet());
            preparedStmt.execute();
            q.onSuccess();
            
        } catch (SQLException ex) {
            my.displayError(ex);
            q.onFailed(ex.toString());
        }finally{
            my.close();
        }
    }
}
