/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.util.Date;

/**
 *
 * @author User
 */
public class phieunhapDTO {
    private String maphieuphap;
    private String manhacc;
    private String manv;
    private int tongtien;
    private Date ngaynhap;
    
    public String getMaphieuphap() {
        return maphieuphap;
    }

    public void setMaphieuphap(String maphieuphap) {
        this.maphieuphap = maphieuphap;
    }

    public String getManhacc() {
        return manhacc;
    }

    public void setManhacc(String manhacc) {
        this.manhacc = manhacc;
    }

    public String getManv() {
        return manv;
    }

    public void setManv(String manv) {
        this.manv = manv;
    }

    public int getTongtien() {
        return tongtien;
    }

    public void setTongtien(int tongtien) {
        this.tongtien = tongtien;
    }

    public Date getNgaynhap() {
        return ngaynhap;
    }

    public void setNgaynhap(Date ngaynhap) {
        this.ngaynhap = ngaynhap;
    }
    
    
}
