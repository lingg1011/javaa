/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import static DAO.docgiaDAO.getDocGia;
import DTO.docgiaDTO;
import DTO.nhanvienDTO;
import interfaces.QueryCallBack;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import untils.MysqlDataAccessHelper;

/**
 *
 * @author cdphuc
 */
public class nhanvienDAO {
    

    public static ArrayList<nhanvienDTO> getNhanVien(){

        ArrayList<nhanvienDTO> arr = new ArrayList<nhanvienDTO>();
        String sql = "select * from nhanvien";
        MysqlDataAccessHelper my = new MysqlDataAccessHelper();
      
        try {
            ResultSet rs = my.excuteQuery(sql);
            while(rs.next()){
                nhanvienDTO nv = new nhanvienDTO();
                nv.setMaNV(rs.getString("manv"));
                nv.setTenNhanVien(rs.getString("tennv"));
                nv.setNgaysinh(rs.getDate("ngaysinh"));
                nv.setSdt(rs.getString("sdt"));
                nv.setDiaChi(rs.getString("diachi"));
                nv.setPassword(rs.getString("password"));
                nv.setRole(rs.getInt("role"));
                arr.add(nv);
            }
        } catch (SQLException ex) {
            my.displayError(ex);
        } finally{
            my.close();
        }
        return arr;
    }
    public static void themNhanVien(nhanvienDTO nv,QueryCallBack q) {
           // create the mysql insert preparedstatement
           ArrayList<nhanvienDTO> arr =getNhanVien();
           for (int i = 0; i < arr.size(); i++) {
               if(arr.get(i).getMaNV()==nv.getMaNV()){
                   q.onFailed("Mã nhân viên đã tồn tại");
                   return;
               }
        }
      String sql = "insert into nhanvien (manv,tennv,ngaysinh,sdt,diachi) values (?,?,?,?,?)";
      MysqlDataAccessHelper my = new MysqlDataAccessHelper();
      PreparedStatement preparedStmt;
        try {
            preparedStmt = my.conn.prepareStatement(sql);
            preparedStmt.setString(1,nv.getMaNV());
            preparedStmt.setString(2,nv.getTenNhanVien());
            preparedStmt.setDate(3,new Date(nv.getNgaysinh().getTime()));
            preparedStmt.setString(4,nv.getSdt());
            preparedStmt.setString(5,nv.getDiaChi());
            preparedStmt.execute();
            q.onSuccess();
        } catch (SQLException ex) {
            my.displayError(ex);
            q.onFailed(ex.toString());
        }finally{
            my.close();
        }

    }
     public static void xoaNhanVien(String maNV,QueryCallBack q) {
           // create the mysql insert preparedstatement
      String query = "delete from nhanvien where manv=?";
      MysqlDataAccessHelper my = new MysqlDataAccessHelper();
      PreparedStatement preparedStmt;
       try {
            preparedStmt = my.conn.prepareStatement(query);
            preparedStmt.setString(1,String.valueOf(maNV));
            preparedStmt.execute();
            q.onSuccess();
        } catch (SQLException ex) {
            my.displayError(ex);
            q.onFailed(ex.toString());
        }finally{
            my.close();
        }
    }
       public static void suaNhanVien(nhanvienDTO nv,QueryCallBack q) {
           // create the mysql insert preparedstatement
      String query = "UPDATE nhanvien SET tennv = ?,ngaysinh=?, sdt = ?, diachi = ? WHERE manv = ?";
  
      MysqlDataAccessHelper my = new MysqlDataAccessHelper();
      PreparedStatement preparedStmt;
       try {
            preparedStmt = my.conn.prepareStatement(query);
            preparedStmt.setString(1,nv.getTenNhanVien());
            preparedStmt.setDate(2,new Date(nv.getNgaysinh().getTime()));
            preparedStmt.setString(3,nv.getSdt());
            preparedStmt.setString(4,nv.getDiaChi());
            preparedStmt.setString(5,nv.getMaNV());
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
