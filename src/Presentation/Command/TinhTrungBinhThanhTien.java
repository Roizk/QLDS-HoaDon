package Presentation.Command;

import Domain.HoaDonTienDienChucNang;
import Domain.Model.HoaDonTienDien;
import Domain.Model.HoaDonTienDienNN;
import Domain.Model.HoaDonTienDienVN;
import Presentation.HoaDonTienDienController;
import Presentation.HoaDonTienDienView;

import java.util.List;

import javax.swing.JOptionPane;

public class TinhTrungBinhThanhTien extends Command {

    public TinhTrungBinhThanhTien(HoaDonTienDien hoaDonTienDien, HoaDonTienDienNN hoaDonTienDienNN,
            HoaDonTienDienVN hoaDonTienDienVN, HoaDonTienDienChucNang hoaDonTienDienChucNang,
            HoaDonTienDienView hoaDonTienDienView, HoaDonTienDienController hoaDonTienDienController) {
        super(hoaDonTienDien, hoaDonTienDienNN, hoaDonTienDienVN, hoaDonTienDienChucNang, hoaDonTienDienView, hoaDonTienDienController);
        this.hoaDonTienDienChucNang = hoaDonTienDienChucNang;
    }

    @Override
    public void execute() {
        List<HoaDonTienDienNN> hoaDonNNList = hoaDonTienDienChucNang.getAllHoaDonTienDienNN();
        if (hoaDonNNList != null ) {
            double trungBinhThanhTien = tinhTrungBinhThanhTien(hoaDonNNList);
            hoaDonTienDienView.getThanhTienTextField().setText(String.valueOf(trungBinhThanhTien));
            JOptionPane.showMessageDialog(hoaDonTienDienView, "Trung bình thành tiền khách nước ngoài: " + trungBinhThanhTien, "Tổng trung bình",
                JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(hoaDonTienDienView, "Thiếu dữ liệu", "Thông báo",
                        JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private double tinhTrungBinhThanhTien(List<HoaDonTienDienNN> hoaDonNNList) {
        double tongThanhTien = 0;
        int soLuongHoaDon = hoaDonNNList.size();
        for (HoaDonTienDienNN hoaDonNN : hoaDonNNList) {
            tongThanhTien += hoaDonNN.thanhTien();
        }
        return soLuongHoaDon == 0 ? 0 : tongThanhTien / soLuongHoaDon;
    }
}
