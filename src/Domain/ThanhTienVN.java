package Domain;

import Domain.Model.HoaDonTienDienVN;

public class ThanhTienVN extends Command {

    private HoaDonTienDienVN hoaDonTienDienVN;

    public ThanhTienVN(HoaDonTienDienVN hoaDonTienDienVN) {
        this.hoaDonTienDienVN = hoaDonTienDienVN;
    }

    @Override
    public void execute() {
        thanhTien(hoaDonTienDienVN);
    }

    public void thanhTien(HoaDonTienDienVN hoaDonTienDienVN) {
        hoaDonTienDienVN.thanhTien();
    }

}
