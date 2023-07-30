package Domain.Command;

import Domain.HoaDonTienDienChucNang;
import Domain.Model.HoaDonTienDienNN;

public class UpdateNN extends Command{
    private HoaDonTienDienNN hoaDonTienDienNN;
    private HoaDonTienDienChucNang hoaDonTienDienChucNang;

    public UpdateNN(HoaDonTienDienChucNang hoaDonTienDienChucNang) {
        this.hoaDonTienDienChucNang = hoaDonTienDienChucNang;
    }

    @Override
    public void execute() {
        update(hoaDonTienDienChucNang);
    }

    public void update(HoaDonTienDienChucNang hoaDonTienDiencChucNang) {
        hoaDonTienDiencChucNang.updateHoaDonTienDienNN(hoaDonTienDienNN);
    }
}
