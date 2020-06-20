/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

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
public class phieumuontraDAO {
    public static ArrayList<phieumuontraDTO> getPhieuMuonTra(){

        ArrayList<phieumuontraDTO> arr = new ArrayList<phieumuontraDTO>();
        String sql = "select * from phieumuontra";
        MysqlDataAccessHelper my = new MysqlDataAccessHelper();
      
        try {
            ResultSet rs = my.excuteQuery(sql);
            while(rs.next()){
                phieumuontraDTO pmt=new phieumuontraDTO();
                pmt.setMaMuonTra(rs.getString("mamuontra"));
                pmt.setMaDocGia(rs.getString("madocgia"));
                pmt.setMaNhanVien(rs.getString("manhanvien"));
                pmt.setNgayMuon(rs.getDate("ngaymuon"));
//                pmt.setNgayTra(rs.getDate("ngaytra"));
                pmt.setGhiChu(rs.getString("ghichu"));
                arr.add(pmt);
            }
        } catch (SQLException ex) {
            my.displayError(ex);
        } finally{
            my.close();
        }
        return arr;
    }

    public static void themPhieuMuonTra(phieumuontraDTO pmt,QueryCallBack q) {
           // create the mysql insert preparedstatement
           ArrayList<phieumuontraDTO> arr =getPhieuMuonTra();
           for (int i = 0; i < arr.size(); i++) {
               if(arr.get(i).getMaMuonTra().equals(pmt.getMaMuonTra())){
                   q.onFailed("Mã mượn trả đã tồn tại");
                   return;
               }
        }
      String sql = "insert into phieumuontra (mamuontra,madocgia,manhanvien,ngaymuon,ghichu) values (?, ?, ?, ?, ?)";
      MysqlDataAccessHelper my = new MysqlDataAccessHelper();
      PreparedStatement preparedStmt;
        try {
            preparedStmt = my.conn.prepareStatement(sql);
            preparedStmt.setString(1,pmt.getMaMuonTra());
            preparedStmt.setString(2,pmt.getMaDocGia());
            preparedStmt.setString(3,pmt.getMaNhanVien());
            preparedStmt.setDate(4,new Date(pmt.getNgayMuon().getTime()));
//            preparedStmt.setDate(5,new Date(pmt.getNgayTra().getTime()));
            preparedStmt.setString(5,pmt.getGhiChu());
            preparedStmt.execute();
            q.onSuccess();
        } catch (SQLException ex) {
            my.displayError(ex);
            q.onFailed(ex.toString());
        }finally{
            my.close();
        }

    }
     public static void xoaPhieuMuonTra(String mamuontra,QueryCallBack q) {
           // create the mysql insert preparedstatement
      String query = "delete from phieumuontra where mamuontra=?";
      MysqlDataAccessHelper my = new MysqlDataAccessHelper();
      PreparedStatement preparedStmt;
       try {
            preparedStmt = my.conn.prepareStatement(query);
            preparedStmt.setString(1,String.valueOf(mamuontra));
            preparedStmt.execute();
            q.onSuccess();
        } catch (SQLException ex) {
            my.displayError(ex);
            q.onFailed(ex.toString());
        }finally{
            my.close();
        }
    }
       public static void suaPhieuMuonTra(phieumuontraDTO pmt,QueryCallBack q) {
           // create the mysql insert preparedstatement
      String query = "UPDATE phieumuontra SET madocgia = ?, manhanvien = ?, ngaymuon = ?, ghichu = ? WHERE mamuontra = ?";
  
      MysqlDataAccessHelper my = new MysqlDataAccessHelper();
      PreparedStatement preparedStmt;
       try {
            preparedStmt = my.conn.prepareStatement(query);
            preparedStmt.setString(1,pmt.getMaDocGia());
            preparedStmt.setString(2,pmt.getMaNhanVien());
            preparedStmt.setDate(3,new Date(pmt.getNgayMuon().getTime()));
//            preparedStmt.setDate(5,new Date(pmt.getNgayTra().getTime()));
            preparedStmt.setString(4,pmt.getGhiChu());
            preparedStmt.setString(5,pmt.getMaMuonTra());
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
