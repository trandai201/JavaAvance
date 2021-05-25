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
public class DanhMuc {
        private String maDanhMucString,tendanhMucString;

    public DanhMuc(String maDanhMucString, String tendanhMucString) {
        this.maDanhMucString = maDanhMucString;
        this.tendanhMucString = tendanhMucString;
    }

    public String getMaDanhMucString() {
        return maDanhMucString;
    }

    public void setMaDanhMucString(String maDanhMucString) {
        this.maDanhMucString = maDanhMucString;
    }

    public String getTendanhMucString() {
        return tendanhMucString;
    }

    public void setTendanhMucString(String tendanhMucString) {
        this.tendanhMucString = tendanhMucString;
    }
}
