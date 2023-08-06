package Presentation.Command;

import Domain.HoaDonTienDienChucNang;
import Domain.Model.HoaDonTienDien;

import Presentation.HoaDonTienDienController;

public class TinhTrungBinhThanhTien extends Command {

    double tBThanhTien ;
    private HoaDonTienDien hoaDonTienDien; 
    public TinhTrungBinhThanhTien(HoaDonTienDien hoaDonTienDien, 
            HoaDonTienDienChucNang hoaDonTienDienChucNang,
            HoaDonTienDienController hoaDonTienDienController) {
        super(hoaDonTienDien, hoaDonTienDienChucNang, hoaDonTienDienController);
        this.hoaDonTienDienChucNang = hoaDonTienDienChucNang;
        this.hoaDonTienDien = hoaDonTienDien;
    }

    @Override
    public void execute() {
        
        tinhTrungBinhThanhTien();

    }

    private void tinhTrungBinhThanhTien() {
       setTBThanhTien( hoaDonTienDien.tinhTrungBinhThanhTienKhachNuocNgoai(hoaDonTienDienChucNang.getAllHoaDonTienDien(hoaDonTienDien.getQuocTich())));
    }

    public double getTBThanhTien() {
        return this.tBThanhTien;
    }

    public void setTBThanhTien(double tBThanhTien) {
        this.tBThanhTien = tBThanhTien;
    }

}
