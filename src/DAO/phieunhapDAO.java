/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.phieunhapDTO;
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
public class phieunhapDAO {
    public static ArrayList<phieunhapDTO> getPhieuNhap(){

        ArrayList<phieunhapDTO> arr = new ArrayList<phieunhapDTO>();
        String sql = "select * from phieunhap";
        MysqlDataAccessHelper my = new MysqlDataAccessHelper();
      
        try {
            ResultSet rs = my.excuteQuery(sql);
            while(rs.next()){
                phieunhapDTO pmt=new phieunhapDTO();
                pmt.setMaphieuphap(rs.getString("maphieunhap"));
                pmt.setManv(rs.getString("manv"));
                pmt.setManhacc(rs.getString("mancc"));
                pmt.setTongtien(rs.getInt("tongtien"));
                pmt.setNgaynhap(rs.getDate("ngaynhap"));
                arr.add(pmt);
            }
        } catch (SQLException ex) {
            my.displayError(ex);
        } finally{
            my.close();
        }
        return arr;
    }

    public static void themPhieuNhap(phieunhapDTO pmt,QueryCallBack q) {
           // create the mysql insert preparedstatement
           ArrayList<phieunhapDTO> arr =getPhieuNhap();
           for (int i = 0; i < arr.size(); i++) {
               if(arr.get(i).getMaphieuphap().equals(pmt.getMaphieuphap())){
                   q.onFailed("Mã phieu nhap đã tồn tại");
                   return;
               }
        }
      String sql = "insert into phieunhap (maphieunhap,manv,mancc,tongtien,ngaynhap) values (?, ?, ?, ?,?)";
      MysqlDataAccessHelper my = new MysqlDataAccessHelper();
      PreparedStatement preparedStmt;
        try {
            preparedStmt = my.conn.prepareStatement(sql);
            preparedStmt.setString(1,pmt.getMaphieuphap());
            preparedStmt.setString(2,pmt.getManv());
            preparedStmt.setString(3,pmt.getManhacc());
            preparedStmt.setInt(4,pmt.getTongtien());
            preparedStmt.setDate(5,new Date(pmt.getNgaynhap().getTime()));
            preparedStmt.execute();
            q.onSuccess();
        } catch (SQLException ex) {
            my.displayError(ex);
            q.onFailed(ex.toString());
        }finally{
            my.close();
        }

    }
     public static void xoaPhieuNhap(String maphieuphat,QueryCallBack q) {
           // create the mysql insert preparedstatement
      String query = "delete from phieunhap where maphieunhap=?";
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
       public static void suaPhieuNhap(phieunhapDTO pmt,QueryCallBack q) {
           // create the mysql insert preparedstatement
      String query = "UPDATE phieunhap SET manv = ?, mancc = ?, tongtien = ?, ngaynhap=? WHERE maphieunhap = ?";
  
      MysqlDataAccessHelper my = new MysqlDataAccessHelper();
      PreparedStatement preparedStmt;
       try {
            preparedStmt = my.conn.prepareStatement(query);
            preparedStmt.setString(1,pmt.getManv());
            preparedStmt.setString(2,pmt.getManhacc());
            preparedStmt.setInt(3,pmt.getTongtien());
            preparedStmt.setDate(4,new Date(pmt.getNgaynhap().getTime()));
            preparedStmt.setString(5,pmt.getMaphieuphap());
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
