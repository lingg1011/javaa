/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.util.Date;

/**
 *
 * @author Admin
 */
public class chitietphieuDTO {
    private String maChitiet;
    private String maMuonTra;
    private String maSach;
    private String tenSach;
    private Integer soLuong;
    private String ghiChu;
    private Integer daTra;
    private String daTras;
    private Date hanTra;
    private Date ngayTra;

    public chitietphieuDTO() {
    }

    public String getMaChitiet() {
        return maChitiet;
    }

    public void setMaChitiet(String maChitiet) {
        this.maChitiet = maChitiet;
    }
    

    public String getMaMuonTra() {
        return maMuonTra;
    }

    public void setMaMuonTra(String maMuonTra) {
        this.maMuonTra = maMuonTra;
    }

    public String getMaSach() {
        return maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public Integer getDaTra() {
        return daTra;
    }

    public void setDaTra(Integer daTra) {
        this.daTra = daTra;
        if(this.daTra == 1){
            this.daTras = "Đã Trả";
        } else {
            this.daTras = "Chưa Trả";
        }
    }

    public String getDaTras() {
        return daTras;
    }

    public void setDaTras(String daTras) {
        this.daTras = daTras;
    }

    public Date getHanTra() {
        return hanTra;
    }

    public void setHanTra(Date hanTra) {
        this.hanTra = hanTra;
    }

    public Date getNgayTra() {
        return ngayTra;
    }

    public void setNgayTra(Date ngayTra) {
        this.ngayTra = ngayTra;
    }
}
