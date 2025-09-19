package iuh.fit.se.daos.impls;

import iuh.fit.se.daos.DienThoaiDAO;
import iuh.fit.se.entities.DienThoai;
import iuh.fit.se.entities.NhaCungCap;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DienThoaiDAOImpl implements DienThoaiDAO {

    private final DataSource dataSource;

    public DienThoaiDAOImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<DienThoai> findByNhaCungCap(String maNCC) {
        List<DienThoai> list = new ArrayList<>();
        String sql = "SELECT * FROM dienthoai WHERE mancc = ?";
        try (Connection con = (Connection) this.dataSource.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, maNCC);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                DienThoai dt = new DienThoai();
                dt.setMaDT(rs.getString("MADT"));
                dt.setTenDT(rs.getString("TENDT"));
                dt.setNamSanXuat(rs.getInt("NAMSANXUAT"));
                dt.setCauHinh(rs.getString("CAUHINH"));
                dt.setHinhAnh(rs.getString("HINHANH"));

                // Tạo đối tượng NhaCungCap chỉ chứa maNCC
                NhaCungCap ncc = new NhaCungCap();
                ncc.setMaNCC(rs.getString("MANCC"));
                dt.setNhaCungCap(ncc);

                list.add(dt);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<DienThoai> findAll() {
        String sql = "SELECT * FROM dienthoai";
        List<DienThoai> list = new ArrayList<>();
        try (
                Connection con = (Connection) this.dataSource.getConnection();
                PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
        ) {
            while (rs.next()) {
                DienThoai dt = new DienThoai();
                dt.setMaDT(rs.getString("MADT"));
                dt.setTenDT(rs.getString("TENDT"));
                dt.setNamSanXuat(rs.getInt("NAMSANXUAT"));
                dt.setCauHinh(rs.getString("CAUHINH"));
                dt.setHinhAnh(rs.getString("HINHANH"));

                // Tạo đối tượng NhaCungCap chỉ chứa maNCC
                NhaCungCap ncc = new NhaCungCap();
                ncc.setMaNCC(rs.getString("MANCC"));
                dt.setNhaCungCap(ncc);
                list.add(dt);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
