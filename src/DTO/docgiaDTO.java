/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.util.Date;
import java.util.logging.Logger;

/**
 *
 * @author Administrator
 */
public class docgiaDTO {
    private String maDocGia;
    private String tenDocGia;
    private String diaChi;
    private String sdt;
    private Date ngayCap;

    public String getMaDocGia() {
        return maDocGia;
    }

    public String getTenDocGia() {
        return tenDocGia;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public String getSdt() {
        return sdt;
    }


    public Date getNgayCap() {
        return ngayCap;
    }


    public void setMaDocGia(String maDocGia) {
        this.maDocGia = maDocGia;
    }

    public void setTenDocGia(String tenDocGia) {
        this.tenDocGia = tenDocGia;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public void setNgayCap(Date ngayCap) {
        this.ngayCap = ngayCap;
    }

    
}
