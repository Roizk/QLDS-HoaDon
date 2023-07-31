
import Domain.HoaDonTienDienChucNang;
import Domain.HoaDonTienDienImp;
import Domain.Model.HoaDonTienDien;
import Domain.Model.HoaDonTienDienNN;
import Domain.Model.HoaDonTienDienVN;
import Presentation.HoaDonTienDienView;

public class Boostrap {

    public static void main(String[] args) {
        HoaDonTienDienView hoaDonTienDienView = new HoaDonTienDienView();
        HoaDonTienDienChucNang hoaDonTienDienChucNangImp = new HoaDonTienDienImp();
        HoaDonTienDien hoaDonTienDienVN = new HoaDonTienDienVN();
        HoaDonTienDien hoaDonTienDienNN = new HoaDonTienDienNN();
        hoaDonTienDienView.setHoaDonTienDienChucNang(hoaDonTienDienChucNangImp);
        hoaDonTienDienView.setHoaDonTienDien(hoaDonTienDienVN);
        hoaDonTienDienView.setHoaDonTienDien(hoaDonTienDienNN);
        hoaDonTienDienView.display();
    }

}