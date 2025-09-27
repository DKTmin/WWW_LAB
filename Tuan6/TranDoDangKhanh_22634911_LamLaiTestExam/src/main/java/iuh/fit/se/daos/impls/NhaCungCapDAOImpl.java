package iuh.fit.se.daos.impls;

import iuh.fit.se.daos.NhaCungCapDAO;
import iuh.fit.se.entities.NhaCungCap;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NhaCungCapDAOImpl implements NhaCungCapDAO {
    private final DataSource dataSource;

    public NhaCungCapDAOImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<NhaCungCap> findAll() {
        List<NhaCungCap>list = new ArrayList<>();
        String sql = "SELECT MANCC, TENNHACC, DIACHI, SODIENTHOAI FROM nhacungcap";

        try (Connection con = this.dataSource.getConnection();
             PreparedStatement ps =con.prepareStatement(sql);
             ResultSet rs =ps.executeQuery();
        ){
        while (rs.next()){
            String mancc = rs.getString("MANCC");
            String ten = rs.getString("TENNHACC");
            String diachi = rs.getString("DIACHI");
            String sodienthoai = rs.getString("SODIENTHOAI");
            list.add(new NhaCungCap(mancc, ten, diachi, sodienthoai));
        }
        } catch (SQLException eq){
            eq.printStackTrace();
        }
    return list;
    }

}
