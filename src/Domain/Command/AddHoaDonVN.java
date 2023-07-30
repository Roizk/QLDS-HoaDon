package Domain.Command;

import Domain.HoaDonTienDienChucNang;

public class AddHoaDonVN extends Command {
    

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
