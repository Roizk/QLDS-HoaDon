package Domain;

import Domain.Model.HoaDonTienDien;

public class Update extends Command {
    private HoaDonTienDien hoaDonTienDien;
    private HoaDonTienDienChucNang hoaDonTienDienChucNang;

    public Update(HoaDonTienDienChucNang hoaDonTienDienChucNang )
    {
        this.hoaDonTienDienChucNang = hoaDonTienDienChucNang;
    }

    @Override
    public void execute()
    {
        update(hoaDonTienDienChucNang);
    }

    public void update(HoaDonTienDienChucNang hoaDonTienDiencChucNang) {
        hoaDonTienDiencChucNang.updateHoaDon(hoaDonTienDien);
    }
}
