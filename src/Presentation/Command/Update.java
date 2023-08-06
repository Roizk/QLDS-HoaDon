package Presentation.Command;

import Domain.HoaDonTienDienChucNang;
import Domain.Model.HoaDonTienDien;

import Presentation.HoaDonTienDienController;

public class Update extends Command {

    public Update(HoaDonTienDien hoaDonTienDien,
            HoaDonTienDienChucNang hoaDonTienDienChucNang,
            HoaDonTienDienController hoaDonTienDienController) {
        super(hoaDonTienDien, hoaDonTienDienChucNang, hoaDonTienDienController);

        this.hoaDonTienDienChucNang = hoaDonTienDienChucNang;
    }

    @Override
    public void execute() {

        hoaDonTienDienChucNang.updateHoaDonTienDien(hoaDonTienDien);
    }

}
