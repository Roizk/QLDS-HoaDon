package Domain.Model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Domain.Publisher;
import Presentation.Subcriber;

public abstract class HoaDonTienDien implements Publisher  {

    protected int idKH;
    protected String hoTen;
    protected Date ngayHD;
    protected double soLuong;
    protected double donGia;
    protected List<Subcriber> hoaDonTienDiensubcriber;

    public HoaDonTienDien() {
        hoaDonTienDiensubcriber = new ArrayList<>();
    }

    public HoaDonTienDien(int idKh, String hoTen, Date ngayHD, double soLuong, double donGia, double thanhTien) {
        this.idKH = idKh;
        this.hoTen = hoTen;
        this.ngayHD = ngayHD;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }

    public abstract double thanhTien();

    @Override
    public void attach(Subcriber subscriber) {
        hoaDonTienDiensubcriber.add(subscriber);
    }

    @Override
    public void detach(Subcriber subscriber) {
        hoaDonTienDiensubcriber.remove(subscriber);
    }

    @Override
    public void notifySubcriber() {
        for (Subcriber subcriber : hoaDonTienDiensubcriber) {
            subcriber.update();
        }
    }

}
