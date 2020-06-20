/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.docgiaDTO;
import DTO.nxbDTO;
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
public class nxbDAO {
    public static ArrayList<nxbDTO> getNXB(){

        ArrayList<nxbDTO> arr = new ArrayList<nxbDTO>();
        String sql = "select * from nxb";
        MysqlDataAccessHelper my = new MysqlDataAccessHelper();
      
        try {
            ResultSet rs = my.excuteQuery(sql);
            while(rs.next()){
                nxbDTO dg=new nxbDTO();
                dg.setManxb(rs.getString("manxb"));
                dg.setTennxb(rs.getString("tennxb"));
                dg.setDiachi(rs.getString("diachi"));
                dg.setEmail(rs.getString("email"));
                dg.setSdt(rs.getString("sdt"));
                arr.add(dg);
            }
        } catch (SQLException ex) {
            my.displayError(ex);
        } finally{
            my.close();
        }
        return arr;
    }

    public static void themNXB(nxbDTO dg,QueryCallBack q) {
           // create the mysql insert preparedstatement
           ArrayList<nxbDTO> arr =getNXB();
           for (int i = 0; i < arr.size(); i++) {
               if(arr.get(i).getManxb().equals(dg.getManxb())){
                   q.onFailed("Mã nhà xb đã tồn tại");
                   return;
                }
        }
      String sql = "insert into nxb (manxb,tennxb,diachi,email,sdt) values (?,?,?,?,?)";
      MysqlDataAccessHelper my = new MysqlDataAccessHelper();
      PreparedStatement preparedStmt;
        try {
            preparedStmt = my.conn.prepareStatement(sql);
            preparedStmt.setString(1,dg.getManxb());
            preparedStmt.setString(2,dg.getTennxb());
            preparedStmt.setString(3,dg.getDiachi());
            preparedStmt.setString(4,dg.getEmail());
            preparedStmt.setString(5,dg.getSdt());
            preparedStmt.execute();
            q.onSuccess();
        } catch (SQLException ex) {
            my.displayError(ex);
            q.onFailed(ex.toString());
        }finally{
            my.close();
        }

    }
     public static void xoaNXB(String manxb,QueryCallBack q) {
           // create the mysql insert preparedstatement
      String query = "delete from nxb where manxb=?";
      MysqlDataAccessHelper my = new MysqlDataAccessHelper();
      PreparedStatement preparedStmt;
       try {
            preparedStmt = my.conn.prepareStatement(query);
            preparedStmt.setString(1,manxb);
            preparedStmt.execute();
            q.onSuccess();
        } catch (SQLException ex) {
            my.displayError(ex);
            q.onFailed(ex.toString());
        }finally{
            my.close();
        }
    }
       public static void suaNXB(nxbDTO dg,QueryCallBack q) {
           // create the mysql insert preparedstatement
      String query = "UPDATE nxb SET tennxb = ?,diachi = ?,email = ?,sdt = ? WHERE manxb = ?";
  
      MysqlDataAccessHelper my = new MysqlDataAccessHelper();
      PreparedStatement preparedStmt;
       try {
            preparedStmt = my.conn.prepareStatement(query);
            preparedStmt.setString(1,dg.getTennxb());
            preparedStmt.setString(2,dg.getDiachi());
            preparedStmt.setString(3,dg.getEmail());
            preparedStmt.setString(4,dg.getSdt());
            preparedStmt.setString(5,dg.getManxb());
            preparedStmt.execute();
            q.onSuccess();
            System.err.println("dg"+dg.getManxb());
        } catch (SQLException ex) {
            my.displayError(ex);
            q.onFailed(ex.toString());
        }finally{
            my.close();
        }
    }
}
