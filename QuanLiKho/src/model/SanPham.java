/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Dai
 */
public class SanPham {
    String maSachString,tenSachString,maDanhMucString,tacGiaString,nhaXuatBanString,ngaySanXuatString;

    public SanPham(String maSachString, String tenSachString, String maDanhMucString, String tacGiaString, String nhaXuatBanString, String ngaySanXuatString) {
        this.maSachString = maSachString;
        this.tenSachString = tenSachString;
        this.maDanhMucString = maDanhMucString;
        this.tacGiaString = tacGiaString;
        this.nhaXuatBanString = nhaXuatBanString;
        this.ngaySanXuatString = ngaySanXuatString;
    }

    public String getNhaXuatBanString() {
        return nhaXuatBanString;
    }

    public void setNhaXuatBanString(String nhaXuatBanString) {
        this.nhaXuatBanString = nhaXuatBanString;
    }



    public String getMaSachString() {
        return maSachString;
    }

    public void setMaSachString(String maSachString) {
        this.maSachString = maSachString;
    }

    public String getTenSachString() {
        return tenSachString;
    }

    public void setTenSachString(String tenSachString) {
        this.tenSachString = tenSachString;
    }

    public String getMaDanhMucString() {
        return maDanhMucString;
    }

    public void setMaDanhMucString(String maDanhMucString) {
        this.maDanhMucString = maDanhMucString;
    }

    public String getTacGiaString() {
        return tacGiaString;
    }

    public void setTacGiaString(String tacGiaString) {
        this.tacGiaString = tacGiaString;
    }

    public String getNgaySanXuatString() {
        return ngaySanXuatString;
    }

    public void setNgaySanXuatString(String ngaySanXuatString) {
        this.ngaySanXuatString = ngaySanXuatString;
    }
    
}
