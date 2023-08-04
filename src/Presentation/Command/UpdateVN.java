package Presentation.Command;

import javax.swing.JOptionPane;

import Domain.HoaDonTienDienChucNang;
import Domain.Model.HoaDonTienDienNN;
import Domain.Model.HoaDonTienDienVN;
import Presentation.HoaDonTienDienController;
import Presentation.HoaDonTienDienView;

public class UpdateVN extends Command {

    public UpdateVN(HoaDonTienDienNN hoaDonTienDienNN,
            HoaDonTienDienVN hoaDonTienDienVN, HoaDonTienDienChucNang hoaDonTienDienChucNang,
            HoaDonTienDienView hoaDonTienDienView, HoaDonTienDienController hoaDonTienDienController) {
        super(hoaDonTienDienNN, hoaDonTienDienVN, hoaDonTienDienChucNang, hoaDonTienDienView,
                hoaDonTienDienController);
        this.hoaDonTienDienChucNang = hoaDonTienDienChucNang;
    }

    @Override
    public void execute() {
        if (hoaDonTienDienController.isValidInputVN()) {
            hoaDonTienDienController.setHoaDonVN();
            hoaDonTienDienVN.setIdKh(Integer.parseInt(hoaDonTienDienView.getIdTextField().getText()));
            update(hoaDonTienDienChucNang);
            JOptionPane.showMessageDialog(hoaDonTienDienView, "Sửa thành công");
        }
    }

    public void update(HoaDonTienDienChucNang hoaDonTienDiencChucNang) {
        hoaDonTienDiencChucNang.updateHoaDonTienDienVN(hoaDonTienDienVN);
    }
}
