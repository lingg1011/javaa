/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.phieumuontraDTO;
import DTO.phieuphatDTO;
import interfaces.QueryCallBack;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import untils.MysqlDataAccessHelper;

/**
 *
 * @author Administrator
 */
public class phieuphatDAO {
    public static ArrayList<phieuphatDTO> getPhieuPhat(){

        ArrayList<phieuphatDTO> arr = new ArrayList<phieuphatDTO>();
        String sql = "select * from phieuphat";
        MysqlDataAccessHelper my = new MysqlDataAccessHelper();
      
        try {
            ResultSet rs = my.excuteQuery(sql);
            while(rs.next()){
                phieuphatDTO pmt=new phieuphatDTO();
                pmt.setMaphieuphat(rs.getString("maphieuphat"));
                pmt.setMamuontra(rs.getString("mamuontra"));
                pmt.setManv(rs.getString("manv"));
                pmt.setNgaylap(rs.getDate("ngaylap"));
                pmt.setTongtien(rs.getInt("tongtien"));
                arr.add(pmt);
            }
        } catch (SQLException ex) {
            my.displayError(ex);
        } finally{
            my.close();
        }
        return arr;
    }

    public static void themPhieuPhat(phieuphatDTO pmt,QueryCallBack q) {
           // create the mysql insert preparedstatement
           ArrayList<phieuphatDTO> arr =getPhieuPhat();
           for (int i = 0; i < arr.size(); i++) {
               if(arr.get(i).getMaphieuphat().equals(pmt.getMaphieuphat())){
                   q.onFailed("Mã phieu phat đã tồn tại");
                   return;
               }
        }
      String sql = "insert into phieuphat (maphieuphat,mamuontra,manv,ngaylap,tongtien) values (?,?, ?, ?, ?)";
      MysqlDataAccessHelper my = new MysqlDataAccessHelper();
      PreparedStatement preparedStmt;
        try {
            preparedStmt = my.conn.prepareStatement(sql);
            preparedStmt.setString(1,pmt.getMaphieuphat());
            preparedStmt.setString(2,pmt.getMamuontra());
            preparedStmt.setString(3,pmt.getManv());
            preparedStmt.setDate(4,new Date(pmt.getNgaylap().getTime()));
            preparedStmt.setInt(5,pmt.getTongtien());
            preparedStmt.execute();
            q.onSuccess();
        } catch (SQLException ex) {
            my.displayError(ex);
            q.onFailed(ex.toString());
        }finally{
            my.close();
        }

    }
     public static void xoaPhieuPhat(String maphieuphat,QueryCallBack q) {
           // create the mysql insert preparedstatement
      String query = "delete from phieuphat where maphieuphat=?";
      MysqlDataAccessHelper my = new MysqlDataAccessHelper();
      PreparedStatement preparedStmt;
       try {
            preparedStmt = my.conn.prepareStatement(query);
            preparedStmt.setString(1,String.valueOf(maphieuphat));
            preparedStmt.execute();
            q.onSuccess();
        } catch (SQLException ex) {
            my.displayError(ex);
            q.onFailed(ex.toString());
        }finally{
            my.close();
        }
    }
       public static void suaPhieuPhat(phieuphatDTO pmt,QueryCallBack q) {
           // create the mysql insert preparedstatement
      String query = "UPDATE phieuphat SET mamuontra=?, manv = ?, ngaylap = ?, tongtien = ? WHERE maphieuphat = ?";
  
      MysqlDataAccessHelper my = new MysqlDataAccessHelper();
      PreparedStatement preparedStmt;
       try {
            preparedStmt = my.conn.prepareStatement(query);
            preparedStmt.setString(1,pmt.getMamuontra());
            preparedStmt.setString(2,pmt.getManv());
            preparedStmt.setDate(3,new Date(pmt.getNgaylap().getTime()));
            preparedStmt.setInt(4,pmt.getTongtien());
            preparedStmt.setString(5,pmt.getMaphieuphat());
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
