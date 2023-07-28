package src.Domain.Model;

import java.util.Date;


public abstract class HoaDonTienDien {

    protected int idKh;
    protected String hoTen;
    protected Date ngayHD;
    protected int soLuong;
    protected double donGia;

    public HoaDonTienDien() {
    }

    public HoaDonTienDien(int idKh, String hoTen, Date ngayHD, int soLuong, double donGia) {
        this.idKh = idKh;
        this.hoTen = hoTen;
        this.ngayHD = ngayHD;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }

    public abstract double thanhTien();

}
