package Domain.Command;

import Domain.HoaDonTienDienChucNang;

public class UpdateVN extends Command {

    public UpdateVN(HoaDonTienDienChucNang hoaDonTienDienChucNang) {
        this.hoaDonTienDienChucNang = hoaDonTienDienChucNang;
    }

    @Override
    public void execute() {
        update(hoaDonTienDienChucNang);
    }

    public void update(HoaDonTienDienChucNang hoaDonTienDiencChucNang) {
        hoaDonTienDiencChucNang.updateHoaDonTienDienVN(hoaDonTienDienVN);
    }
}
