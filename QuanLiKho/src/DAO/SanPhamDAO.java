/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.SanPham;

/**
 *
 * @author Dai
 */
public class SanPhamDAO {

    static Connection con = KetNoiCSDL.getConnection();

    static public List<SanPham> getSanPhamAll() throws SQLException {
        List<SanPham> sanPhams = new ArrayList<>();
        String query = "use QlKHO \n"
                + "select * from sanpham"
                + "";

        PreparedStatement ps = con.prepareStatement(query);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            sanPhams.add(new SanPham(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)));
        }
        return sanPhams;
    }

    static public boolean insertData(SanPham sp){

        String query = "use QlKHO \n"
                + "exec dbo.insertSanPham_pr ?, ?, ?, ?, ? ";

        PreparedStatement ps;
        try {
            ps = con.prepareStatement(query);
             ps.setString(1, sp.getTenSachString());
        ps.setString(2, sp.getMaDanhMucString());
        ps.setString(3, sp.getTacGiaString());
        ps.setString(4, sp.getNhaXuatBanString());
        ps.setString(5, sp.getNgaySanXuatString());
        ps.execute();
        return false;
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
       

    }

    static public boolean deleteData(SanPham sp) throws SQLException {

        String query = "use QlKHO \n"
                + "delete from sanpham where maSach = ?";

        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, sp.getMaSachString());

        return ps.execute();

    }
      static public boolean upData(SanPham sp) throws SQLException {

        String query = "use QlKHO \n"
                + "update SANPHAM set tenSach = ?, maDM = ?, tacgia = ?,NXB = ?,ngayXuatBang = ?  where maSach = ?";

        PreparedStatement ps = con.prepareStatement(query);
        
        ps.setString(1, sp.getTenSachString());
        ps.setString(2, sp.getMaDanhMucString());
        ps.setString(3, sp.getTacGiaString());
        ps.setString(4, sp.getNhaXuatBanString());
        ps.setString(5, sp.getNgaySanXuatString());
        ps.setString(6, sp.getMaSachString());

        return ps.execute();

    }
}
