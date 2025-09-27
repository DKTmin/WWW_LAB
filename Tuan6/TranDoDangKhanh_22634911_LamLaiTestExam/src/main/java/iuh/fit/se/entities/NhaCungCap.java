package iuh.fit.se.entities;

import java.util.List;

public class NhaCungCap {
    private String maNCC;
    private String tenNhaCC;
    private String diaChi;
    private String soDienThoai;
    private List<DienThoai> dienThoaiList;

    public NhaCungCap(String maNCC) {
        this.maNCC = maNCC;
    }

    public NhaCungCap(String maNCC, String tenNhaCC, String diaChi, String soDienThoai) {
        this.maNCC = maNCC;
        this.tenNhaCC = tenNhaCC;
        this.diaChi = diaChi;
        this.soDienThoai = soDienThoai;

    }

    public String getMaNCC() {
        return maNCC;
    }

    public void setMaNCC(String maNCC) {
        this.maNCC = maNCC;
    }

    public String getTenNhaCC() {
        return tenNhaCC;
    }

    public void setTenNhaCC(String tenNhaCC) {
        this.tenNhaCC = tenNhaCC;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public List<DienThoai> getDienThoaiList() {
        return dienThoaiList;
    }

    public void setDienThoaiList(List<DienThoai> dienThoaiList) {
        this.dienThoaiList = dienThoaiList;
    }
}
