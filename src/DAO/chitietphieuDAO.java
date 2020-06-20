/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.chitietphieuDTO;
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
public class chitietphieuDAO {
    public static ArrayList<chitietphieuDTO> getChiTietPhieu(){
        ArrayList<chitietphieuDTO> arr = new ArrayList<>();
        String sql = "select * from chitietmuontra";
        MysqlDataAccessHelper my = new MysqlDataAccessHelper();
        try {
            ResultSet rs = my.excuteQuery(sql);
            while(rs.next()){
                chitietphieuDTO ctp = new chitietphieuDTO();
                ctp.setMaChitiet(rs.getString("chitietmuontra"));
                ctp.setMaMuonTra(rs.getString("mamuontra"));
                ctp.setMaSach(rs.getString("masach"));
                ctp.setSoLuong(rs.getInt("soluong"));
                ctp.setDaTra(rs.getInt("datra"));
                ctp.setNgayTra(rs.getDate("ngaytra"));
                ctp.setHanTra(rs.getDate("hantra"));
                arr.add(ctp);
            }
        } catch (SQLException ex) {
            my.displayError(ex);
        } finally{
            my.close();
        }
        return arr;
    }

    public static void themChiTietPhieu(chitietphieuDTO pmt,QueryCallBack q) {
           // create the mysql insert preparedstatement
           ArrayList<chitietphieuDTO> arr = getChiTietPhieu();
           for (int i = 0; i < arr.size(); i++) {
               if(arr.get(i).getMaChitiet().equals(pmt.getMaChitiet())){
                   q.onFailed("Mã chi tiet đã tồn tại");
                   return;
               }
        }
      String sql = "insert into chitietmuontra (chitietmuontra,mamuontra,masach,soluong,datra,ngaytra,hantra) values (?,?, ?, ?, ?, ?,?)";
      MysqlDataAccessHelper my = new MysqlDataAccessHelper();
      PreparedStatement preparedStmt;
        try {
            preparedStmt = my.conn.prepareStatement(sql);
            preparedStmt.setString(1,pmt.getMaChitiet());
            preparedStmt.setString(2,pmt.getMaMuonTra());
            preparedStmt.setString(3,pmt.getMaSach());
            preparedStmt.setInt(4,pmt.getSoLuong());
            preparedStmt.setInt(5,pmt.getDaTra());
            if(pmt.getNgayTra()==null){
                preparedStmt.setDate(6,null);
            }else{
                preparedStmt.setDate(6,new Date(pmt.getNgayTra().getTime()));
            }
             if(pmt.getHanTra()==null){
                preparedStmt.setDate(7,null);
            }else{
                preparedStmt.setDate(7,new Date(pmt.getHanTra().getTime()));
            }
            preparedStmt.execute();
            q.onSuccess();
        } catch (SQLException ex) {
            my.displayError(ex);
            q.onFailed(ex.toString());
        }finally{
            my.close();
        }

    }
     public static void xoaChiTietPhieu(String machitiet,QueryCallBack q) {
           // create the mysql insert preparedstatement
      String query = "delete from chitietmuontra where chitietmuontra=?";
      MysqlDataAccessHelper my = new MysqlDataAccessHelper();
      PreparedStatement preparedStmt;
       try {
            preparedStmt = my.conn.prepareStatement(query);
            preparedStmt.setString(1,String.valueOf(machitiet));
            preparedStmt.execute();
            q.onSuccess();
        } catch (SQLException ex) {
            my.displayError(ex);
            q.onFailed(ex.toString());
        }finally{
            my.close();
        }
    }
       public static void suaChiTietPhieu(chitietphieuDTO pmt,QueryCallBack q) {
           // create the mysql insert preparedstatement
      String query = "UPDATE chitietmuontra SET mamuontra = ?,masach = ?, soluong = ?, datra = ?, ngaytra = ?, hantra = ? WHERE chitietmuontra = ?";
  
      MysqlDataAccessHelper my = new MysqlDataAccessHelper();
      PreparedStatement preparedStmt;
       try {
            preparedStmt = my.conn.prepareStatement(query);
            preparedStmt.setString(1,pmt.getMaMuonTra());
            preparedStmt.setString(2,pmt.getMaSach());
            preparedStmt.setInt(3,pmt.getSoLuong());
            preparedStmt.setInt(4,pmt.getDaTra());
            preparedStmt.setDate(5,new Date(pmt.getNgayTra().getTime()));
            preparedStmt.setDate(6,new Date(pmt.getHanTra().getTime()));
            preparedStmt.setString(7,pmt.getMaChitiet());
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
