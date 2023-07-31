
import javax.swing.SwingUtilities;

import Domain.HoaDonTienDienChucNang;
import Domain.HoaDonTienDienImp;
import Domain.Model.HoaDonTienDienNN;
import Domain.Model.HoaDonTienDienVN;
import Presentation.HoaDonTienDienView;

public class Boostrap {

    public static void main(String[] args) {
        HoaDonTienDienView hoaDonTienDienView = new HoaDonTienDienView();
        HoaDonTienDienChucNang hoaDonTienDienChucNang = new HoaDonTienDienImp();
        HoaDonTienDienVN hoaDonTienDienVN = new HoaDonTienDienVN();
        HoaDonTienDienNN hoaDonTienDienNN = new HoaDonTienDienNN();
        hoaDonTienDienView.setHoaDonTienDienChucNang(hoaDonTienDienChucNang);
        hoaDonTienDienView.setHoaDonTienDienNN(hoaDonTienDienNN);
        hoaDonTienDienView.setHoaDonTienDienVN(hoaDonTienDienVN);
        
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                hoaDonTienDienView.display();
            }
        });

    }

}