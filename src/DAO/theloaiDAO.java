/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.docgiaDTO;
import DTO.phieumuontraDTO;
import DTO.tacgiaDTO;
import DTO.theloaiDTO;
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
public class theloaiDAO {
    public static ArrayList<theloaiDTO> getTheloai(){

        ArrayList<theloaiDTO> arr = new ArrayList<theloaiDTO>();
        String sql = "select * from theloai";
        MysqlDataAccessHelper my = new MysqlDataAccessHelper();
      
        try {
            ResultSet rs = my.excuteQuery(sql);
            while(rs.next()){
                theloaiDTO dg=new theloaiDTO();
                dg.setMatl(rs.getString("matl"));
                dg.setTentl(rs.getString("tentl"));
                arr.add(dg);
            }
        } catch (SQLException ex) {
            my.displayError(ex);
        } finally{
            my.close();
        }
        return arr;
    }

    public static void themTheloai(theloaiDTO dg,QueryCallBack q) {
           // create the mysql insert preparedstatement
           ArrayList<theloaiDTO> arr =getTheloai();
           for (int i = 0; i < arr.size(); i++) {
               if(arr.get(i).getMatl().equals(dg.getMatl())){
                   q.onFailed("Mã the loai đã tồn tại");
                   return;
               }
        }
      String sql = "insert into theloai (matl,tentl) values (?,?)";
      MysqlDataAccessHelper my = new MysqlDataAccessHelper();
      PreparedStatement preparedStmt;
        try {
            preparedStmt = my.conn.prepareStatement(sql);
            preparedStmt.setString(1,dg.getMatl());
            preparedStmt.setString(2,dg.getTentl());
            preparedStmt.execute();
            q.onSuccess();
        } catch (SQLException ex) {
            my.displayError(ex);
            q.onFailed(ex.toString());
        }finally{
            my.close();
        }

    }
     public static void xoaTheloai(String matl,QueryCallBack q) {
           // create the mysql insert preparedstatement
      String query = "delete from theloai where matl=?";
      MysqlDataAccessHelper my = new MysqlDataAccessHelper();
      PreparedStatement preparedStmt;
       try {
            preparedStmt = my.conn.prepareStatement(query);
            preparedStmt.setString(1,matl);
            preparedStmt.execute();
            q.onSuccess();
        } catch (SQLException ex) {
            my.displayError(ex);
            q.onFailed(ex.toString());
        }finally{
            my.close();
        }
    }
       public static void suaTheloai(theloaiDTO dg,QueryCallBack q) {
           // create the mysql insert preparedstatement
      String query = "UPDATE theloai SET tentl = ? WHERE matl = ?";
  
      MysqlDataAccessHelper my = new MysqlDataAccessHelper();
      PreparedStatement preparedStmt;
       try {
            preparedStmt = my.conn.prepareStatement(query);
            preparedStmt.setString(1,dg.getTentl());
            preparedStmt.setString(2,dg.getMatl());
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
