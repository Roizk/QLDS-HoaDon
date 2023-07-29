package Domain.Model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

<<<<<<< HEAD
public abstract class HoaDonTienDien {
=======
import Domain.Publisher;
import Presentation.Subcriber;

public abstract class HoaDonTienDien implements Publisher {
>>>>>>> 227f3b26c54e9412f221f778849950dc3c94043f

    protected int idKH;
    protected String hoTen;
    protected Date ngayHD;
    protected double soLuong;
    protected double donGia;
    protected List<Subcriber> hoaDonTienDiensubcriber;

    public HoaDonTienDien() {
    }

    public HoaDonTienDien(int idKh, String hoTen, Date ngayHD, double soLuong, double donGia, double thanhTien) {
        this.idKH = idKh;
        this.hoTen = hoTen;
        this.ngayHD = ngayHD;
        this.soLuong = soLuong;
        this.donGia = donGia;
        hoaDonTienDiensubcriber = new ArrayList<>();
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
            subcriber.notify();
        }
    }

}
