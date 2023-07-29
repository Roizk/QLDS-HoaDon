package Domain.Model;

import java.util.Date;

public class HoaDonTienDienVN extends HoaDonTienDien {

    private double dinhMuc;

    private enum doiTuongKH {
        sinhHoat,
        kinhDoanh,
        sanXuat
    };

    private doiTuongKH doiTuong;

    public HoaDonTienDienVN(int idKh, String hoTen, Date ngayHD, int soLuong, double donGia, double dinhMuc,double thanhTien) {
        super(idKh, hoTen, ngayHD, soLuong, donGia,thanhTien);
        this.dinhMuc = dinhMuc;
    }

    public double thanhTien() {
        if (soLuong <= dinhMuc) {
            return soLuong * donGia;
        } else
            return soLuong * donGia * dinhMuc + (soLuong - dinhMuc) * donGia * 2.5;
    }

    public double getDinhMuc() {
        return this.dinhMuc;
    }

    public int getIdKh() {
        return this.idKH;
    }

    public void setIdKh(int idKh) {
        this.idKH = idKh;
    }

    public String getHoTen() {
        return this.hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public Date getNgayHD() {
        return this.ngayHD;
    }

    public void setNgayHD(Date ngayHD) {
        this.ngayHD = ngayHD;
    }

    public double getSoLuong() {
        return this.soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double getDonGia() {
        return this.donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public doiTuongKH getDoiTuongKH() {
        return doiTuong;
    }

}
