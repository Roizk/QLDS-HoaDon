package Domain.Command;

import Domain.HoaDonTienDienChucNang;
import Domain.Model.HoaDonTienDienVN;

public class AddHoaDonVN extends Command {
    private HoaDonTienDienVN hoaDonTienDienVN;
    private HoaDonTienDienChucNang hoaDonTienDienChucNang;

    public AddHoaDonVN(HoaDonTienDienChucNang hoaDonTienDienChucNang) {
        this.hoaDonTienDienChucNang = hoaDonTienDienChucNang;
    }

    @Override
    public void execute() {
        add(hoaDonTienDienChucNang);
    }

    public void add(HoaDonTienDienChucNang hoaDonTienDiencChucNang) {
        hoaDonTienDiencChucNang.addHoaDonTienDienVN(hoaDonTienDienVN);
    }

}
