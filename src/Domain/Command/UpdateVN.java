package Domain.Command;

import Domain.HoaDonTienDienChucNang;
import Domain.Model.HoaDonTienDienVN;

public class UpdateVN extends Command {
    private HoaDonTienDienVN hoaDonTienDienVN;
    private HoaDonTienDienChucNang hoaDonTienDienChucNang;

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
