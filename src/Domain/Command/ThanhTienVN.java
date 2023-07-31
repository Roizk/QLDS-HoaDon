package Domain.Command;

import Domain.HoaDonTienDienChucNang;
import Domain.Model.HoaDonTienDien;
import Domain.Model.HoaDonTienDienNN;
import Domain.Model.HoaDonTienDienVN;

public class ThanhTienVN extends Command {

    public ThanhTienVN(HoaDonTienDien hoaDonTienDien, HoaDonTienDienNN hoaDonTienDienNN, HoaDonTienDienVN hoaDonTienDienVN, HoaDonTienDienChucNang hoaDonTienDienChucNang) {
        super(hoaDonTienDien, hoaDonTienDienNN, hoaDonTienDienVN, hoaDonTienDienChucNang);
        this.hoaDonTienDienVN = hoaDonTienDienVN;
    }

    @Override
    public void execute() {
        hoaDonTienDienVN.thanhTien();
    }

}
