/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.docgiaDTO;
import DTO.phieumuontraDTO;
import DTO.tacgiaDTO;
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
public class tacgiaDAO {
    public static ArrayList<tacgiaDTO> getTacgia(){

        ArrayList<tacgiaDTO> arr = new ArrayList<tacgiaDTO>();
        String sql = "select * from tacgia";
        MysqlDataAccessHelper my = new MysqlDataAccessHelper();
      
        try {
            ResultSet rs = my.excuteQuery(sql);
            while(rs.next()){
                tacgiaDTO dg=new tacgiaDTO();
                dg.setMatg(rs.getString("matg"));
                dg.setTentg(rs.getString("tentg"));
                arr.add(dg);
            }
        } catch (SQLException ex) {
            my.displayError(ex);
        } finally{
            my.close();
        }
        return arr;
    }

    public static void themtacgia(tacgiaDTO dg,QueryCallBack q) {
           // create the mysql insert preparedstatement
           ArrayList<tacgiaDTO> arr =getTacgia();
           for (int i = 0; i < arr.size(); i++) {
               if(arr.get(i).getMatg().equals(dg.getMatg())){
                   q.onFailed("Mã tác giả đã tồn tại");
                   return;
               }
        }
      String sql = "insert into tacgia (matg,tentg) values (?,?)";
      MysqlDataAccessHelper my = new MysqlDataAccessHelper();
      PreparedStatement preparedStmt;
        try {
            preparedStmt = my.conn.prepareStatement(sql);
            preparedStmt.setString(1,dg.getMatg());
            preparedStmt.setString(2,dg.getTentg());
            preparedStmt.execute();
            q.onSuccess();
        } catch (SQLException ex) {
            my.displayError(ex);
            q.onFailed(ex.toString());
        }finally{
            my.close();
        }

    }
     public static void xoaTacgia(String matg,QueryCallBack q) {
           // create the mysql insert preparedstatement
      String query = "delete from tacgia where matg=?";
      MysqlDataAccessHelper my = new MysqlDataAccessHelper();
      PreparedStatement preparedStmt;
       try {
            preparedStmt = my.conn.prepareStatement(query);
            preparedStmt.setString(1,matg);
            preparedStmt.execute();
            q.onSuccess();
        } catch (SQLException ex) {
            my.displayError(ex);
            q.onFailed(ex.toString());
        }finally{
            my.close();
        }
    }
       public static void suaTacgia(tacgiaDTO dg,QueryCallBack q) {
           // create the mysql insert preparedstatement
      String query = "UPDATE tacgia SET tentg = ? WHERE matg = ?";
  
      MysqlDataAccessHelper my = new MysqlDataAccessHelper();
      PreparedStatement preparedStmt;
       try {
            preparedStmt = my.conn.prepareStatement(query);
            preparedStmt.setString(1,dg.getTentg());
            preparedStmt.setString(2,dg.getMatg());
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
