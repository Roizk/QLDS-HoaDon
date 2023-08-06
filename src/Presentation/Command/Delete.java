package Presentation.Command;

import Domain.HoaDonTienDienChucNang;
import Domain.Model.HoaDonTienDien;
import Presentation.HoaDonTienDienController;

public class Delete extends Command {

    public Delete(HoaDonTienDien hoaDonTienDien, 
            HoaDonTienDienChucNang hoaDonTienDienChucNang,
            HoaDonTienDienController hoaDonTienDienController) {
        super(hoaDonTienDien,  hoaDonTienDienChucNang, hoaDonTienDienController);

        this.hoaDonTienDienChucNang = hoaDonTienDienChucNang;
    }

    @Override
    public void execute() {
        hoaDonTienDienChucNang.deleteHoaDon(hoaDonTienDien);
    }

}
