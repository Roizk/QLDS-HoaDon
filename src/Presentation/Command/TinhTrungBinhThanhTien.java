package Presentation.Command;

import Domain.HoaDonTienDienChucNang;
import Domain.Model.HoaDonTienDienNN;
import Domain.Model.HoaDonTienDienVN;
import Presentation.HoaDonTienDienController;
import Presentation.HoaDonTienDienView;

import javax.swing.JOptionPane;

public class TinhTrungBinhThanhTien extends Command {

    public TinhTrungBinhThanhTien(HoaDonTienDienNN hoaDonTienDienNN, HoaDonTienDienVN hoaDonTienDienVN,
            HoaDonTienDienChucNang hoaDonTienDienChucNang, HoaDonTienDienView hoaDonTienDienView,
            HoaDonTienDienController hoaDonTienDienController) {
        super(hoaDonTienDienNN, hoaDonTienDienVN, hoaDonTienDienChucNang, hoaDonTienDienView, hoaDonTienDienController);
        this.hoaDonTienDienChucNang = hoaDonTienDienChucNang;
    }

    @Override
    public void execute() {

        if (tinhTrungBinhThanhTien() != 0) {
            JOptionPane.showMessageDialog(hoaDonTienDienView,
                    "Trung bình thành tiền khách nước ngoài: " + tinhTrungBinhThanhTien(), "Tổng trung bình",
                    JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(hoaDonTienDienView, "Thiếu dữ liệu", "Thông báo",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private double tinhTrungBinhThanhTien() {
        return hoaDonTienDienChucNang.tbThanhTien();
    }
}
