package Presentation.Command;

import java.util.List;

import javax.swing.JOptionPane;

import Domain.HoaDonTienDienChucNang;
import Domain.Model.HoaDonTienDienNN;
import Domain.Model.HoaDonTienDienVN;
import Presentation.HoaDonTienDienController;
import Presentation.HoaDonTienDienView;

public class TotalQuantity extends Command {

    public TotalQuantity(HoaDonTienDienNN hoaDonTienDienNN, HoaDonTienDienVN hoaDonTienDienVN,
            HoaDonTienDienChucNang hoaDonTienDienChucNang,
            HoaDonTienDienView hoaDonTienDienView, HoaDonTienDienController hoaDonTienDienController) {
        super(hoaDonTienDienNN, hoaDonTienDienVN, hoaDonTienDienChucNang, hoaDonTienDienView,
                hoaDonTienDienController);
    }

    @Override
    public void execute()
    {
        calTotal();
    }


    public void calTotal()
    {
         double totalQuantityVN = 0.0;
        double totalQuantityNN = 0.0;

        // Calculate total quantity for HoaDonTienDienVN
        List<HoaDonTienDienVN> hoaDonVNList = hoaDonTienDienChucNang.getAllHoaDonTienDienVN();
        for (HoaDonTienDienVN hoaDonVN : hoaDonVNList) {
            totalQuantityVN += hoaDonVN.getSoLuong();
        }

        // Calculate total quantity for HoaDonTienDienNN
        List<HoaDonTienDienNN> hoaDonNNList = hoaDonTienDienChucNang.getAllHoaDonTienDienNN();
        for (HoaDonTienDienNN hoaDonNN : hoaDonNNList) {
            totalQuantityNN += hoaDonNN.getSoLuong();
        }

        JOptionPane.showMessageDialog(hoaDonTienDienView,
                "Tổng số lượng KW khách hàng Việt Nam đã dùng: " + totalQuantityVN + "\n"
                        + "Tổng số lượng khách hàng Nước Ngoài đã dùng: " + totalQuantityNN,
                "Tổng số lượng KW",
                JOptionPane.INFORMATION_MESSAGE);
    }
    }


