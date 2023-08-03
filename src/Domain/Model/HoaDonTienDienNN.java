package Domain.Model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Presentation.Subcriber;

public class HoaDonTienDienNN extends HoaDonTienDien {

    private String quocTich;
   
    public HoaDonTienDienNN() {
        hoaDonTienDiensubcriber = new ArrayList<>();
    }

    public HoaDonTienDienNN(int idKh, String hoTen, Date ngayHD, double soLuong, double donGia, String quocTich,
            double thanhTien) {
        super(idKh, hoTen, ngayHD, soLuong, donGia, thanhTien);

        this.quocTich = quocTich;
        // hoaDonTienDiensubcriber = new ArrayList<>();
    }

    public double thanhTien() {
        return soLuong * donGia;
    }

    public double tinhTrungBinhThanhTienKhachNuocNgoai(List<HoaDonTienDienNN> hoaDonNNList) {
        double tongThanhTien = 0;
        int soLuongHoaDon = hoaDonNNList.size();
        for (HoaDonTienDienNN hoaDonNN : hoaDonNNList) {
            tongThanhTien += hoaDonNN.thanhTien();
        }
        return soLuongHoaDon == 0 ? 0 : tongThanhTien / soLuongHoaDon;
    }

    public void notifySubcriber() {
        for (Subcriber subcriber : hoaDonTienDiensubcriber) {
            subcriber.update();
        }
    }

    @Override
    public String toString() {
        return " " + thanhTien();
    }

    public String getQuocTich() {
        return this.quocTich;
    }

    public void setQuocTich(String qt) {
        this.quocTich = qt;

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

    public void setSoLuong(double soLuong) {
        this.soLuong = soLuong;
    }

    public double getDonGia() {
        return this.donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public double tinhTrungBinhThanhTienKhachNuocNgoai() {
        return 0;
    }

}