package Presentation.Command;

import Domain.HoaDonTienDienChucNang;
import Domain.Model.HoaDonTienDien;
import Presentation.HoaDonTienDienController;

public abstract class Command {

    protected HoaDonTienDien hoaDonTienDien;

    protected HoaDonTienDienChucNang hoaDonTienDienChucNang;
    protected HoaDonTienDienController hoaDonTienDienController;

    public Command(HoaDonTienDien hoaDonTienDien,
            HoaDonTienDienChucNang hoaDonTienDienChucNang, HoaDonTienDienController hoaDonTienDienController) {
        this.hoaDonTienDien = hoaDonTienDien;
        this.hoaDonTienDienChucNang = hoaDonTienDienChucNang;
        this.hoaDonTienDienController = hoaDonTienDienController;
    }

    public abstract void execute();
}
