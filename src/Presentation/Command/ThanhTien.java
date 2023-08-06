package Presentation.Command;

import Domain.HoaDonTienDienChucNang;
import Domain.Model.HoaDonTienDien;
import Presentation.HoaDonTienDienController;

public class ThanhTien extends Command {

    public ThanhTien(HoaDonTienDien hoaDonTienDien,
            HoaDonTienDienChucNang hoaDonTienDienChucNang,
            HoaDonTienDienController hoaDonTienDienController) {
        super(hoaDonTienDien, hoaDonTienDienChucNang, hoaDonTienDienController);
        this.hoaDonTienDien = hoaDonTienDien;
    }

    @Override
    public void execute() {
        hoaDonTienDien.thanhTien();
    }
}