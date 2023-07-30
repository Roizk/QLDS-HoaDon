package Domain.Command;

import Domain.HoaDonTienDienChucNang;

public class UpdateNN extends Command{

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
