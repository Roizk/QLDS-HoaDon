package Domain.Command;

import Domain.HoaDonTienDienChucNang;
import Domain.Model.HoaDonTienDienNN;

public class AddHoaDonNN extends Command {
    private HoaDonTienDienNN hoaDonTienDienNN;
    private HoaDonTienDienChucNang hoaDonTienDienChucNang;

    public AddHoaDonNN(HoaDonTienDienChucNang hoaDonTienDienChucNang) {
        this.hoaDonTienDienChucNang = hoaDonTienDienChucNang;
    }

    @Override
    public void execute() {
        add(hoaDonTienDienChucNang);
    }

    public void add(HoaDonTienDienChucNang hoaDonTienDiencChucNang) {
        hoaDonTienDiencChucNang.addHoaDonTienDienNN(hoaDonTienDienNN);
    }
}
