/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package untils;

import com.mysql.jdbc.Driver;
import com.mysql.jdbc.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author cdphuc
 */
public class MysqlDataAccessHelper {

   public Connection conn = null;
   // xu ly ngoai le khi tuong tac voi csdl
   public void displayError(SQLException ex){
       System.out.println(" Error Message:" + ex.getMessage());
       System.out.println(" SQL State:" + ex.getSQLState());
       System.out.println(" Error Code:" + ex.getErrorCode());
   }
   public Connection getCon(){
       return conn;
   }

    public MysqlDataAccessHelper() {
         try{
      Driver driver = new org.gjt.mm.mysql.Driver();// nap driver
       DriverManager.registerDriver(driver);// dang ky driver

       String url = "jdbc:mysql://localhost:3306/quanlythuvien?useUnicode=yes&characterEncoding=UTF-8";
       conn  = DriverManager.getConnection(url, "root", "");//tao ket noi den co so du lieu

       } catch(SQLException ex){// xu ly ngoai le
           displayError(ex);
       }
    }
    public MysqlDataAccessHelper(String servername,String username,String password,String databasename) {
         try{
      Driver driver = new org.gjt.mm.mysql.Driver();// nap driver
       DriverManager.registerDriver(driver);// dang ky driver

       String url = "jdbc:mysql://servername/"+"/"+databasename;
       conn  = DriverManager.getConnection(url, username,password);//tao ket noi den co so du lieu

       } catch(SQLException ex){// xu ly ngoai le
           displayError(ex);
       }
    }
   

   public void close(){// dong ket noi co so du lieu
       try {
           if(conn!=null)
               conn.close();
       } catch (SQLException ex) {
           displayError(ex);
       }
   }
   //tao va thuc thi cac cau lenh sql
   // cung cap thong tin trich rut tu csdl va cho phep truy xuat tung dong du lieu
   public ResultSet excuteQuery(String sql){// danh cho cau lenh secect
       ResultSet rs = null;
       try {
           Statement stm = (Statement) conn.createStatement();
           rs = stm.executeQuery(sql);
       } catch (SQLException ex) {
           displayError(ex);
       }
       return rs;
   }
//   public void excuteQuery(String sql,String path){// danh cho cau lenh secect
//       ResultSet rs = null;
//       try {
//           PreparedStatement preparedStmt = conn.prepareStatement(sql);
//           preparedStmt.setString (1, path);
//      preparedStmt.execute();
//       } catch (SQLException ex) {
//           displayError(ex);
//       }
//   }

}
