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
public class phieuphatDTO {
    private String maphieuphat;
    private String mamuontra;
    private Date ngaylap;
    private String manv;
    private int tongtien;

    public String getMamuontra() {
        return mamuontra;
    }

    public void setMamuontra(String mamuontra) {
        this.mamuontra = mamuontra;
    }
    

    public String getMaphieuphat() {
        return maphieuphat;
    }

    public void setMaphieuphat(String maphieuphat) {
        this.maphieuphat = maphieuphat;
    }

    public Date getNgaylap() {
        return ngaylap;
    }

    public void setNgaylap(Date ngaylap) {
        this.ngaylap = ngaylap;
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
    
    
    
    
}
