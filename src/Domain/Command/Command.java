package Domain.Command;

import Domain.HoaDonTienDienChucNang;
import Domain.Model.HoaDonTienDien;
import Domain.Model.HoaDonTienDienNN;
import Domain.Model.HoaDonTienDienVN;
import Presentation.HoaDonTienDienController;
import Presentation.HoaDonTienDienView;

public abstract class Command {

    protected HoaDonTienDienView hoaDonTienDienView;
    protected HoaDonTienDien hoaDonTienDien;
    protected HoaDonTienDienNN hoaDonTienDienNN;
    protected HoaDonTienDienVN hoaDonTienDienVN;
    protected HoaDonTienDienChucNang hoaDonTienDienChucNang;
    protected HoaDonTienDienController hoaDonTienDienController; 


    public Command(HoaDonTienDien hoaDonTienDien, HoaDonTienDienNN hoaDonTienDienNN, HoaDonTienDienVN hoaDonTienDienVN, HoaDonTienDienChucNang hoaDonTienDienChucNang,HoaDonTienDienView hoaDonTienDienView,HoaDonTienDienController hoaDonTienDienController) {
        this.hoaDonTienDien = hoaDonTienDien;
        this.hoaDonTienDienNN = hoaDonTienDienNN;
        this.hoaDonTienDienVN = hoaDonTienDienVN;
        this.hoaDonTienDienChucNang = hoaDonTienDienChucNang;
        this.hoaDonTienDienView = hoaDonTienDienView;
        this.hoaDonTienDienController = hoaDonTienDienController;
    }
    
    
    public abstract void execute();
}
