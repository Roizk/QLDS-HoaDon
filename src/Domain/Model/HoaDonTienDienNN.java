package Domain.Model;

import java.util.Date;

public class HoaDonTienDienNN extends HoaDonTienDien {

    private String quocTich;

    public HoaDonTienDienNN() {
    }

    public HoaDonTienDienNN(int idKh, String hoTen, Date ngayHD, int soLuong, double donGia, String quocTich) {
        super(idKh, hoTen, ngayHD, soLuong, donGia);
        this.quocTich = quocTich;
    }

    public double thanhTien() {
        return soLuong * donGia;
    }

    @Override
    public String toString() {
        return " " + thanhTien();
    }

}