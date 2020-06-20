/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import DTO.nhaccDTO;
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
public class nhaccDAO {
    public static ArrayList<nhaccDTO> getNhaCC(){

        ArrayList<nhaccDTO> arr = new ArrayList<nhaccDTO>();
        String sql = "select * from nhacc";
        MysqlDataAccessHelper my = new MysqlDataAccessHelper();
      
        try {
            ResultSet rs = my.excuteQuery(sql);
            while(rs.next()){
                nhaccDTO dg=new nhaccDTO();
                dg.setMancc(rs.getString("mancc"));
                dg.setTenncc(rs.getString("tenncc"));
                dg.setDiachi(rs.getString("diachi"));
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

    public static void themNhaCC(nhaccDTO dg,QueryCallBack q) {
           // create the mysql insert preparedstatement
           ArrayList<nhaccDTO> arr =getNhaCC();
           for (int i = 0; i < arr.size(); i++) {
               if(arr.get(i).getMancc().equals(dg.getMancc())){
                   q.onFailed("Mã tác giả đã tồn tại");
                   return;
               }
        }
      String sql = "insert into nhacc (mancc,tenncc,diachi,sdt) values (?,?,?,?)";
      MysqlDataAccessHelper my = new MysqlDataAccessHelper();
      PreparedStatement preparedStmt;
        try {
            preparedStmt = my.conn.prepareStatement(sql);
            preparedStmt.setString(1,dg.getMancc());
            preparedStmt.setString(2,dg.getTenncc());
            preparedStmt.setString(3,dg.getDiachi());
            preparedStmt.setString(4,dg.getSdt());
            preparedStmt.execute();
            q.onSuccess();
        } catch (SQLException ex) {
            my.displayError(ex);
            q.onFailed(ex.toString());
        }finally{
            my.close();
        }

    }
     public static void xoaNhaCC(String matg,QueryCallBack q) {
           // create the mysql insert preparedstatement
      String query = "delete from nhacc where mancc=?";
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
       public static void suaNhaCC(nhaccDTO dg,QueryCallBack q) {
           // create the mysql insert preparedstatement
      String query = "UPDATE nhacc SET tenncc = ?,diachi = ?,sdt = ? WHERE mancc = ?";
  
      MysqlDataAccessHelper my = new MysqlDataAccessHelper();
      PreparedStatement preparedStmt;
       try {
            preparedStmt = my.conn.prepareStatement(query);
            preparedStmt.setString(1,dg.getTenncc());
            preparedStmt.setString(2,dg.getDiachi());
            preparedStmt.setString(3,dg.getSdt());
            preparedStmt.setString(4,dg.getMancc());
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
