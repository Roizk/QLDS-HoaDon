
import javax.swing.SwingUtilities;

import Domain.HoaDonTienDienChucNang;
import Domain.HoaDonTienDienImp;
import Domain.Command.CommandProcessor;
import Domain.Model.HoaDonTienDienNN;
import Domain.Model.HoaDonTienDienVN;
import Presentation.HoaDonTienDienView;
import Presentation.HoaDonTienDienController;

public class Boostrap {

    public static void main(String[] args) {
        HoaDonTienDienView hoaDonTienDienView = new HoaDonTienDienView();
        HoaDonTienDienController hoaDonTienDienController = new HoaDonTienDienController(hoaDonTienDienView);
        HoaDonTienDienChucNang hoaDonTienDienChucNang = new HoaDonTienDienImp();
        HoaDonTienDienVN hoaDonTienDienVN = new HoaDonTienDienVN();
        HoaDonTienDienNN hoaDonTienDienNN = new HoaDonTienDienNN();
        CommandProcessor commandProcessor = new CommandProcessor();
        hoaDonTienDienView.setHoaDonTienDienChucNang(hoaDonTienDienChucNang);
        hoaDonTienDienController.setHoaDonTienDienNN(hoaDonTienDienNN);
        hoaDonTienDienController.setHoaDonTienDienVN(hoaDonTienDienVN);
        hoaDonTienDienController.setCommandProcessor(commandProcessor);
        hoaDonTienDienController.setHoaDonTienDienChucNang(hoaDonTienDienChucNang);
        hoaDonTienDienView.setHoaDonTienDienNN(hoaDonTienDienNN);
        hoaDonTienDienView.setHoaDonTienDienVN(hoaDonTienDienVN);
        hoaDonTienDienView.setHoaDonTienDienController(hoaDonTienDienController);
        
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                hoaDonTienDienView.display();
            }
        });

    }

}