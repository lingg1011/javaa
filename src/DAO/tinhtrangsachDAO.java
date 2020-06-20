/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import DTO.nhanvienDTO;
import DTO.sachDTO;
import DTO.tinhtrangsachDTO;
import interfaces.QueryCallBack;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import untils.MysqlDataAccessHelper;

/**
 *
 * @author cdphuc
 */
public class tinhtrangsachDAO {
    

    public static ArrayList<tinhtrangsachDTO> gettinhtrang(){

        ArrayList<tinhtrangsachDTO> arr = new ArrayList<tinhtrangsachDTO>();
        String sql = "select * from tinhtrangsach";
        MysqlDataAccessHelper my = new MysqlDataAccessHelper();
      
        try {
            ResultSet rs = my.excuteQuery(sql);
            while(rs.next()){
                tinhtrangsachDTO sach = new tinhtrangsachDTO();
                sach.setMatinhtrang(rs.getInt("matinhtrang"));
                sach.setTentinhtrang(rs.getString("tentinhtrang"));
                sach.setGiaphat(rs.getInt("giaphat"));
               
                arr.add(sach);
            }
        } catch (SQLException ex) {
            my.displayError(ex);
        } finally{
            my.close();
        }
        return arr;
    }

  
}
