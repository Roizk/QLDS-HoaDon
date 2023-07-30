package Domain.Command;

import Domain.HoaDonTienDienChucNang;
import Domain.Model.HoaDonTienDien;
import Domain.Model.HoaDonTienDienNN;
import Domain.Model.HoaDonTienDienVN;

public abstract class Command {

    protected HoaDonTienDien hoaDonTienDien;
    protected HoaDonTienDienNN hoaDonTienDienNN;
    protected HoaDonTienDienVN hoaDonTienDienVN;
    protected HoaDonTienDienChucNang hoaDonTienDienChucNang;
    public abstract void execute();
}
