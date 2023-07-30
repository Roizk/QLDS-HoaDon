package Domain.Command;

import Domain.HoaDonTienDienChucNang;

public class Delete extends Command {

    public Delete(HoaDonTienDienChucNang hoaDonTienDienChucNang) {
        this.hoaDonTienDienChucNang = hoaDonTienDienChucNang;
    }

    @Override
    public void execute() {
        delete(hoaDonTienDienChucNang);
    }

    public void delete(HoaDonTienDienChucNang hoaDonTienDiencChucNang) {
        hoaDonTienDiencChucNang.deleteHoaDon(hoaDonTienDien);
    }
}
