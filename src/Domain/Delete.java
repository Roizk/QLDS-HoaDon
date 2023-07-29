package Domain;

import Domain.Model.HoaDonTienDien;

public class Delete extends Command {
    private HoaDonTienDien hoaDonTienDien;
    private HoaDonTienDienChucNang hoaDonTienDienChucNang;

    @Override
    public void execute(HoaDonTienDienChucNang hoaDonTienDiencChucNang)
    {
        delete(hoaDonTienDienChucNang);
    }

    public void delete(HoaDonTienDienChucNang hoaDonTienDiencChucNang) {
        hoaDonTienDiencChucNang.deleteHoaDon(hoaDonTienDien);
    }
}
