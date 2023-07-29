package Domain;

import Domain.Model.HoaDonTienDien;


public class Add extends Command{
    private HoaDonTienDien hoaDonTienDien;
    private HoaDonTienDienChucNang hoaDonTienDienChucNang;
    public Add(HoaDonTienDienChucNang hoaDonTienDienChucNang )
    {
        this.hoaDonTienDienChucNang = hoaDonTienDienChucNang;
    }

    @Override
    public void execute()
    {
        add(hoaDonTienDienChucNang);
    }

    public void add(HoaDonTienDienChucNang hoaDonTienDiencChucNang) {
        hoaDonTienDiencChucNang.addHoaDon(hoaDonTienDien);
    }

}
