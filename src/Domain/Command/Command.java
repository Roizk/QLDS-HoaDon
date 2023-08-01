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


    public Command(HoaDonTienDien hoaDonTienDien, HoaDonTienDienNN hoaDonTienDienNN, HoaDonTienDienVN hoaDonTienDienVN, HoaDonTienDienChucNang hoaDonTienDienChucNang) {
        this.hoaDonTienDien = hoaDonTienDien;
        this.hoaDonTienDienNN = hoaDonTienDienNN;
        this.hoaDonTienDienVN = hoaDonTienDienVN;
        this.hoaDonTienDienChucNang = hoaDonTienDienChucNang;
    }
    
    
    public abstract void execute();
}
