package Domain;

import Domain.Model.HoaDonTienDien;

public class Update extends Command {
    private HoaDonTienDien hoaDonTienDien;
    private HoaDonTienDienChucNang hoaDonTienDienChucNang;

    @Override
    public void execute(HoaDonTienDienChucNang hoaDonTienDiencChucNang)
    {
        update(hoaDonTienDienChucNang);
    }

    public void update(HoaDonTienDienChucNang hoaDonTienDiencChucNang) {
        hoaDonTienDiencChucNang.updateHoaDon(hoaDonTienDien);
    }
}
