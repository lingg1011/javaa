/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.chitietphieuDTO;
import DTO.chitietphieuphatDTO;
import DTO.phieumuontraDTO;
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
public class chitietphieuphatDAO {
    public static ArrayList<chitietphieuphatDTO> getChiTietPhieuPhat(){
        ArrayList<chitietphieuphatDTO> arr = new ArrayList<>();
        String sql = "select * from chitietphieuphat";
        MysqlDataAccessHelper my = new MysqlDataAccessHelper();
        try {
            ResultSet rs = my.excuteQuery(sql);
            while(rs.next()){
                chitietphieuphatDTO ctp = new chitietphieuphatDTO();
                ctp.setMachitiet(rs.getString("chitietphieuphat"));
                ctp.setMaphieuphat(rs.getString("maphieuphat"));
                ctp.setMasach(rs.getString("masach"));
                ctp.setSoluong(rs.getInt("soluong"));
                ctp.setTinhtrangsach(rs.getInt("tinhtrang"));
                ctp.setTienphat(rs.getInt("tienphat"));
                arr.add(ctp);
            }
        } catch (SQLException ex) {
            my.displayError(ex);
        } finally{
            my.close();
        }
        return arr;
    }

    public static void themChiTietPhieuPhat(chitietphieuphatDTO pmt,QueryCallBack q) {
           // create the mysql insert preparedstatement
           ArrayList<chitietphieuphatDTO> arr = getChiTietPhieuPhat();
           for (int i = 0; i < arr.size(); i++) {
               if(arr.get(i).getMachitiet().equals(pmt.getMachitiet())){
                   q.onFailed("Mã chi tiet đã tồn tại");
                   return;
               }
        }
      String sql = "insert into chitietphieuphat (chitietphieuphat,maphieuphat,masach,soluong,tinhtrang,tienphat) values (?,?, ?, ?,?,?)";
      MysqlDataAccessHelper my = new MysqlDataAccessHelper();
      PreparedStatement preparedStmt;
        try {
            preparedStmt = my.conn.prepareStatement(sql);
            preparedStmt.setString(1,pmt.getMachitiet());
            preparedStmt.setString(2,pmt.getMaphieuphat());
            preparedStmt.setString(3,pmt.getMasach());
            preparedStmt.setInt(4,pmt.getSoluong());
            preparedStmt.setInt(5,pmt.getTinhtrangsach());
            preparedStmt.setInt(6,pmt.getTienphat());
            preparedStmt.execute();
            q.onSuccess();
        } catch (SQLException ex) {
            my.displayError(ex);
            q.onFailed(ex.toString());
        }finally{
            my.close();
        }

    }
     public static void xoaChiTietPhieuPhat(String chitietphieuphat,QueryCallBack q) {
           // create the mysql insert preparedstatement
      String query = "delete from chitietphieuphat where chitietphieuphat=?";
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
       public static void suaChiTietPhieuPhat(chitietphieuphatDTO pmt,QueryCallBack q) {
           // create the mysql insert preparedstatement
      String query = "UPDATE chitietphieuphat SET maphieuphat = ?,masach = ?, soluong = ?, tinhtrang = ?, tienphat = ? WHERE chitietphieuphat = ?";
  
      MysqlDataAccessHelper my = new MysqlDataAccessHelper();
      PreparedStatement preparedStmt;
       try {
            preparedStmt = my.conn.prepareStatement(query);
            preparedStmt.setString(1,pmt.getMaphieuphat());
            preparedStmt.setString(2,pmt.getMasach());
            preparedStmt.setInt(3,pmt.getSoluong());
            preparedStmt.setInt(4,pmt.getTinhtrangsach());
            preparedStmt.setInt(5,pmt.getTienphat());
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
