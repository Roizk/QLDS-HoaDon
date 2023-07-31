package Domain.Command;

import Domain.HoaDonTienDienChucNang;
import Domain.Model.HoaDonTienDien;
import Domain.Model.HoaDonTienDienNN;
import Domain.Model.HoaDonTienDienVN;

public class ThanhTienNN extends Command {

    public ThanhTienNN(HoaDonTienDien hoaDonTienDien, HoaDonTienDienNN hoaDonTienDienNN, HoaDonTienDienVN hoaDonTienDienVN, HoaDonTienDienChucNang hoaDonTienDienChucNang) {
        super(hoaDonTienDien, hoaDonTienDienNN, hoaDonTienDienVN, hoaDonTienDienChucNang);
        this.hoaDonTienDienNN = hoaDonTienDienNN;
    }

    @Override
    public void execute() {
        hoaDonTienDienNN.thanhTien();
    }
}