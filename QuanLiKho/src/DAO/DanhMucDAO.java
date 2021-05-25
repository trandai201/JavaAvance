/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import static DAO.SanPhamDAO.con;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.DanhMuc;
import model.SanPham;

/**
 *
 * @author Dai
 */
public class DanhMucDAO {

    static Connection con = KetNoiCSDL.getConnection();

    static public List<DanhMuc> getSanPhamAll() throws SQLException {
        List<DanhMuc> danhMucs = new ArrayList<>();
        String query = "use QlKHO \n"
                + "select * from danhmuc"
                + "";

        PreparedStatement ps = con.prepareStatement(query);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            danhMucs.add(new DanhMuc(rs.getString(1), rs.getString(2)));

        }
        return danhMucs;
    }
    
}
