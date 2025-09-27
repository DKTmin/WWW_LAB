package iuh.fit.se.daos;

import iuh.fit.se.entities.DienThoai;

import java.util.List;

public interface DienThoaiDAO {
    public List<DienThoai> findAll();

    public List<DienThoai> findByMaNCC(String maNCC);
}
