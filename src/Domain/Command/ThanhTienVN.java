package Domain.Command;

import Domain.Model.HoaDonTienDienVN;

public class ThanhTienVN extends Command {

    public ThanhTienVN(HoaDonTienDienVN hoaDonTienDienVN) {
        this.hoaDonTienDienVN = hoaDonTienDienVN;
    }

    @Override
    public void execute() {
        hoaDonTienDienVN.thanhTien();
    }

}
