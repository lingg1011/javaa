/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.docgiaDTO;
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
 * @author Administrator
 */
public class docgiaDAO {
    public static ArrayList<docgiaDTO> getDocGia(){

        ArrayList<docgiaDTO> arr = new ArrayList<docgiaDTO>();
        String sql = "select * from docgia";
        MysqlDataAccessHelper my = new MysqlDataAccessHelper();
      
        try {
            ResultSet rs = my.excuteQuery(sql);
            while(rs.next()){
                docgiaDTO dg=new docgiaDTO();
                dg.setMaDocGia(rs.getString("madocgia"));
                dg.setTenDocGia(rs.getString("tendocgia"));
                dg.setDiaChi(rs.getString("diachi"));
                dg.setSdt(rs.getString("sdt"));
                dg.setNgayCap(rs.getDate("ngaycap"));
                arr.add(dg);
            }
        } catch (SQLException ex) {
            my.displayError(ex);
        } finally{
            my.close();
        }
        return arr;
    }

    public static void themDocGia(docgiaDTO dg,QueryCallBack q) {
           // create the mysql insert preparedstatement
           ArrayList<docgiaDTO> arr =getDocGia();
           for (int i = 0; i < arr.size(); i++) {
               if(arr.get(i).getMaDocGia().equals(dg.getMaDocGia())){
                   q.onFailed("Mã đọc giả đã tồn tại");
                   return;
               }
        }
      String sql = "insert into docgia (madocgia,tendocgia,diachi,sdt,ngaycap) values (?, ?,?,?,?)";
      MysqlDataAccessHelper my = new MysqlDataAccessHelper();
      PreparedStatement preparedStmt;
        try {
            preparedStmt = my.conn.prepareStatement(sql);
            preparedStmt.setString(1,dg.getMaDocGia());
            preparedStmt.setString(2,dg.getTenDocGia());
            preparedStmt.setString(3,dg.getDiaChi());
            preparedStmt.setString(4,dg.getSdt());
            preparedStmt.setDate(5, new Date(dg.getNgayCap().getTime()));
            preparedStmt.execute();
            q.onSuccess();
        } catch (SQLException ex) {
            my.displayError(ex);
            q.onFailed(ex.toString());
        }finally{
            my.close();
        }

    }
     public static void xoaDocGia(String madocgia,QueryCallBack q) {
           // create the mysql insert preparedstatement
      String query = "delete from docgia where madocgia=?";
      MysqlDataAccessHelper my = new MysqlDataAccessHelper();
      PreparedStatement preparedStmt;
       try {
            preparedStmt = my.conn.prepareStatement(query);
            preparedStmt.setString(1,madocgia);
            preparedStmt.execute();
            q.onSuccess();
        } catch (SQLException ex) {
            my.displayError(ex);
            q.onFailed(ex.toString());
        }finally{
            my.close();
        }
    }
       public static void suaDocGia(docgiaDTO dg,QueryCallBack q) {
           // create the mysql insert preparedstatement
      String query = "UPDATE docgia SET tendocgia = ?, diachi = ?, sdt = ?, ngaycap = ? WHERE madocgia = ?";
  
      MysqlDataAccessHelper my = new MysqlDataAccessHelper();
      PreparedStatement preparedStmt;
       try {
            preparedStmt = my.conn.prepareStatement(query);
            preparedStmt.setString(1,dg.getTenDocGia());
            preparedStmt.setString(2,dg.getDiaChi());
            preparedStmt.setString(3,dg.getSdt());
            java.util.Date utilStartDate = dg.getNgayCap();
            preparedStmt.setDate(4, new Date(utilStartDate.getTime()));
            preparedStmt.setString(5,dg.getMaDocGia());
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
