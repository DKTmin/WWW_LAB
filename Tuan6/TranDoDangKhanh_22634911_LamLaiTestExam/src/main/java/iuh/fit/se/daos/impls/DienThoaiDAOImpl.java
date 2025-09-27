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
    public List<DienThoai> findAll() {
        List<DienThoai>list = new ArrayList<>();
        String sql = "SELECT MADT, TENDT, NAMSANXUAT, CAUHINH, MANCC, HINHANH FROM dienthoai";

        try (Connection con = this.dataSource.getConnection();
             PreparedStatement ps =con.prepareStatement(sql);
             ResultSet rs =ps.executeQuery();
        ){
            while (rs.next()){
                String madt = rs.getString("MADT");
                String ten = rs.getString("TENDT");
                int namsanxuat = rs.getInt("NAMSANXUAT");
                String cauhinh = rs.getString("CAUHINH");
                String mancc = rs.getString("MANCC");
                String hinhanh = rs.getString("HINHANH");
                NhaCungCap ncc = new NhaCungCap(mancc);
                DienThoai dt = new DienThoai(madt, ten,namsanxuat,cauhinh,hinhanh,ncc);
                list.add(dt);
            }
        } catch (SQLException eq){
            eq.printStackTrace();
        }
        return list;
    }

    @Override
    public List<DienThoai> findByMaNCC(String maNCC) {
        return null;
    }
}
