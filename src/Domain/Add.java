package Domain;

import Domain.Model.HoaDonTienDien;


public class Add extends Command{
    private HoaDonTienDien hoaDonTienDien;
    private HoaDonTienDienChucNang hoaDonTienDienChucNang;

    @Override
    public void execute(HoaDonTienDienChucNang hoaDonTienDiencChucNang)
    {
        add(hoaDonTienDienChucNang);
    }

    public void add(HoaDonTienDienChucNang hoaDonTienDiencChucNang) {
        hoaDonTienDiencChucNang.addHoaDon(hoaDonTienDien);
    }

}
