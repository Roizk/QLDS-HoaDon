package src.Domain.Model;

import java.util.Date;

public class HoaDonTienDienVN extends HoaDonTienDien {

    private double dinhMuc;

    private enum doiTuongKH {
        sinhHoat,
        kinhDoanh,
        sanXuat
    };

    public HoaDonTienDienVN(int idKh, String hoTen, Date ngayHD, int soLuong, double donGia, double dinhMuc) {
        super(idKh, hoTen, ngayHD, soLuong, donGia);
        this.dinhMuc = dinhMuc;
    }

    public double thanhTien() {
        if (soLuong <= dinhMuc) {
            return soLuong * donGia;
        } else
            return soLuong * donGia * dinhMuc + (soLuong - dinhMuc) * donGia * 2.5;
    }
}
