
import javax.swing.SwingUtilities;

import Domain.HoaDonTienDienChucNang;
import Domain.HoaDonTienDienImp;
import Domain.Model.HoaDonTienDien;
import Persistence.HoaDonDAO;
import Persistence.HoaDonDAOImpl;
import Persistence.HoaDonJdbcGateway;
import Presentation.HoaDonTienDienView;
import Presentation.Command.CommandProcessor;
import Presentation.HoaDonTienDienController;

public class Boostrap {

    public static void main(String[] args) {
        HoaDonTienDienView hoaDonTienDienView = new HoaDonTienDienView();
        HoaDonTienDienController hoaDonTienDienController = new HoaDonTienDienController(hoaDonTienDienView);

        HoaDonDAO hoaDonDAO = new HoaDonDAOImpl(new HoaDonJdbcGateway());
        HoaDonTienDienChucNang hoaDonTienDienChucNang = new HoaDonTienDienImp(hoaDonDAO);
        
        HoaDonTienDien hoaDonTienDien = new HoaDonTienDien();

        CommandProcessor commandProcessor = new CommandProcessor();
        hoaDonTienDienView.setHoaDonTienDienChucNang(hoaDonTienDienChucNang);
        hoaDonTienDienView.setHoaDonTienDien(hoaDonTienDien);
        hoaDonTienDienController.setHoaDonTienDien(hoaDonTienDienView.getHoaDonTienDien());
        hoaDonTienDienController.setCommandProcessor(commandProcessor);
        hoaDonTienDienController.setHoaDonTienDienChucNang(hoaDonTienDienChucNang);
        hoaDonTienDienView.setHoaDonTienDienController(hoaDonTienDienController);

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                hoaDonTienDienView.display();
            }
        });

    }

}