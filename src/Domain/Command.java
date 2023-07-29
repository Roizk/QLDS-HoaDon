package Domain;

import Domain.Model.HoaDonTienDienNN;
import Domain.Model.HoaDonTienDienVN;

public abstract class Command {

    public abstract void execute(HoaDonTienDienChucNang hoaDonTienDienChucNang);

    // public abstract void thanhTienVNExecute(HoaDonTienDienVN hoaDonTienDienVN);

    // public abstract void thanhTienNNExecute(HoaDonTienDienNN hoaDonTienDienNN);
}
