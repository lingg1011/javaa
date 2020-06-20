/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import DTO.nhanvienDTO;
import DTO.sachDTO;
import interfaces.QueryCallBack;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import untils.MysqlDataAccessHelper;

public class sachDAO {
    public static ArrayList<sachDTO> getSach(){

        ArrayList<sachDTO> arr = new ArrayList<sachDTO>();
        String sql = "select * from sach";
        MysqlDataAccessHelper my = new MysqlDataAccessHelper();
      
        try {
            ResultSet rs = my.excuteQuery(sql);
            while(rs.next()){
                sachDTO sach = new sachDTO();
                sach.setMaSach(rs.getString("masach"));
                sach.setTenSach(rs.getString("tensach"));
                sach.setTenTacGia(rs.getString("tacgia"));
                sach.setNhaXuatBan(rs.getString("nhaxb"));
                sach.setTheLoai(rs.getString("theloai"));
                sach.setSoLuongHienCo(rs.getInt("sl"));
                sach.setSoLuongCon(rs.getInt("slcon"));
                sach.setDongia(rs.getInt("dongia"));
                arr.add(sach);
            }
        } catch (SQLException ex) {
            my.displayError(ex);
        } finally{
            my.close();
        }
        return arr;
    }

    public static void themSach(sachDTO s,QueryCallBack q) {
           ArrayList<sachDTO> arr =getSach();
           for (int i = 0; i < arr.size(); i++) {
               if(arr.get(i).getMaSach().equals(s.getMaSach())){
                   q.onFailed("Mã sách đã tồn tại");
                   return;
               }
        }
      String sql = "insert into sach (masach, tensach, tacgia, nhaxb, theloai,sl,slcon,dongia) values (?, ?, ?, ?, ?,?,?,?)";
      MysqlDataAccessHelper my = new MysqlDataAccessHelper();
      PreparedStatement preparedStmt;
        try {
            preparedStmt = my.conn.prepareStatement(sql);
            preparedStmt.setString (1, s.getMaSach());
            preparedStmt.setString (2, s.getTenSach());
            preparedStmt.setString (3, s.getTenTacGia());
            preparedStmt.setString (4, s.getNhaXuatBan());
            preparedStmt.setString (5, s.getTheLoai());
            preparedStmt.setInt    (6, s.getSoLuongHienCo());
            preparedStmt.setInt    (7, s.getSoLuongCon());
            preparedStmt.setInt    (8, s.getDongia());
            preparedStmt.execute();
            q.onSuccess();
        } catch (SQLException ex) {
            my.displayError(ex);
            q.onFailed(ex.toString());
        }finally{
            my.close();
        }

    }
     public static void xoaSach(String masach,QueryCallBack q) {
           // create the mysql insert preparedstatement
      String query = "delete from sach where masach =?";
      MysqlDataAccessHelper my = new MysqlDataAccessHelper();
      PreparedStatement preparedStmt;
       try {
            preparedStmt = my.conn.prepareStatement(query);
            preparedStmt.setString(1,masach);
            preparedStmt.execute();
            q.onSuccess();
        } catch (SQLException ex) {
            my.displayError(ex);
            q.onFailed(ex.toString());
        }finally{
            my.close();
        }
    }
       public static void suaSach(sachDTO s,QueryCallBack q) {
           // create the mysql insert preparedstatement
      String query = "UPDATE sach SET tensach = ?, tacgia = ?, nhaxb = ?, theloai = ?, sl = ?, slcon = ?,dongia=? WHERE masach = ?";
  
      MysqlDataAccessHelper my = new MysqlDataAccessHelper();
      PreparedStatement preparedStmt;
       try {
            preparedStmt = my.conn.prepareStatement(query);
            preparedStmt.setString(1,s.getTenSach());
            preparedStmt.setString(2,s.getTenTacGia());
            preparedStmt.setString(3,s.getNhaXuatBan());
            preparedStmt.setString(4,s.getTheLoai());
            preparedStmt.setInt(5,s.getSoLuongHienCo());
            preparedStmt.setInt(6,s.getSoLuongCon());
            preparedStmt.setInt(7,s.getDongia());
            preparedStmt.setString(8,s.getMaSach());
            preparedStmt.execute();
            q.onSuccess();
        } catch (SQLException ex) {
            my.displayError(ex);
            q.onFailed(ex.toString());
        }finally{
            my.close();
        }
    }
        public static void suaSach(sachDTO s) {
           // create the mysql insert preparedstatement
     String query = "UPDATE sach SET tensach = ?, tacgia = ?, nhaxb = ?, theloai = ?, sl = ?, slcon = ?,dongia=? WHERE masach = ?";
  
      MysqlDataAccessHelper my = new MysqlDataAccessHelper();
      PreparedStatement preparedStmt;
       try {
            preparedStmt = my.conn.prepareStatement(query);
            preparedStmt.setString(1,s.getTenSach());
            preparedStmt.setString(2,s.getTenTacGia());
            preparedStmt.setString(3,s.getNhaXuatBan());
            preparedStmt.setString(4,s.getTheLoai());
            preparedStmt.setInt(5,s.getSoLuongHienCo());
            preparedStmt.setInt(6,s.getSoLuongCon());
            preparedStmt.setInt(7,s.getDongia());
            preparedStmt.setString(8,s.getMaSach());
            preparedStmt.execute();
        } catch (SQLException ex) {
            my.displayError(ex);
        }finally{
            my.close();
        }
        }
      
}
