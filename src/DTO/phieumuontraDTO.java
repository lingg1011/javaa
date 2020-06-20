/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.util.Date;

/**
 *
 * @author Administrator
 */
public class phieumuontraDTO {

    private String maMuonTra;
    private String maDocGia;
    private String tenDocGia;
    private String maNhanVien;
    private String tenNhanVien;
    private Date ngayMuon;
//    private Date ngayTra;
    private String ghiChu;
//    private Date hanTra;

    public String getMaMuonTra() {
        return maMuonTra;
    }

    public String getMaDocGia() {
        return maDocGia;
    }

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public Date getNgayMuon() {
        return ngayMuon;
    }

    public void setNgayMuon(Date ngayMuon) {
        this.ngayMuon = ngayMuon;
    }

//    public Date getNgayTra() {
//        return ngayTra;
//    }
//
//    public void setNgayTra(Date ngayTra) {
//        this.ngayTra = ngayTra;
//    }

//    public Date getHanTra() {
//        return hanTra;
//    }
//
//    public void setHanTra(Date hanTra) {
//        this.hanTra = hanTra;
//    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setMaMuonTra(String mamuontra) {
        this.maMuonTra = mamuontra;
    }

    public String getTenDocGia() {
        return tenDocGia;
    }

    public void setTenDocGia(String tenDocGia) {
        this.tenDocGia = tenDocGia;
    }

    public String getTenNhanVien() {
        return tenNhanVien;
    }

    public void setTenNhanVien(String tenNhanVien) {
        this.tenNhanVien = tenNhanVien;
    }

    public void setMaDocGia(String madocgia) {
        this.maDocGia = madocgia;
    }

    public void setMaNhanVien(String manhanvien) {
        this.maNhanVien = manhanvien;
    }

    public void setGhiChu(String ghichu) {
        this.ghiChu = ghichu;
    }

}
