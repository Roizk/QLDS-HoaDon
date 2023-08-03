package Domain.Command;

import java.util.List;
import java.util.Objects;

import javax.swing.JOptionPane;

import Domain.HoaDonTienDienChucNang;
import Domain.Model.HoaDonTienDien;
import Domain.Model.HoaDonTienDienNN;
import Domain.Model.HoaDonTienDienVN;
import Presentation.HoaDonTienDienController;
import Presentation.HoaDonTienDienView;

public class FindByIDNN extends Command {

    public FindByIDNN(HoaDonTienDien hoaDonTienDien, HoaDonTienDienNN hoaDonTienDienNN,
            HoaDonTienDienVN hoaDonTienDienVN, HoaDonTienDienChucNang hoaDonTienDienChucNang,
            HoaDonTienDienView hoaDonTienDienView, HoaDonTienDienController hoaDonTienDienController) {
        super(hoaDonTienDien, hoaDonTienDienNN, hoaDonTienDienVN, hoaDonTienDienChucNang, hoaDonTienDienView,
                hoaDonTienDienController);
    }

    @Override
    public void execute() {
        findByID();
    }

    public void findByID() {
        String ID = JOptionPane.showInputDialog(hoaDonTienDienView, "Nhập ID", "ID", JOptionPane.PLAIN_MESSAGE);

        if (ID != null && !ID.isEmpty()) {
            boolean found = false; //
            List<HoaDonTienDienNN> hoaDonNNList = hoaDonTienDienChucNang.getAllHoaDonTienDienNN();
            hoaDonTienDienView.getTableModelNN().setRowCount(0); // Xóa toàn bộ dữ liệu trong bảng HoaDonTienDienVN

            // Tìm kiếm và thêm chỉ hàng ID cần tìm vào bảng HoaDonTienDienVN
            for (HoaDonTienDienNN hoaDonNN : hoaDonNNList) {
                if (hoaDonNN != null && Objects.equals(hoaDonNN.getIdKh(), Integer.parseInt(ID))) {
                    Object[] rowData = {
                            hoaDonNN.getIdKh(),
                            hoaDonNN.getHoTen(),
                            hoaDonNN.getQuocTich(),
                            hoaDonNN.getNgayHD() != null ? hoaDonNN.getNgayHD().toString() : "",
                            hoaDonNN.getSoLuong(),
                            hoaDonNN.getDonGia(),
                            hoaDonNN.thanhTien()
                    };
                    hoaDonTienDienView.getTableModelNN().addRow(rowData); // Thêm hàng cần tìm vào bảng
                    found = true; // Đã tìm thấy ID
                    break; // Dừng vòng lặp khi đã tìm thấy ID
                }

            }
            if (!found) {
                JOptionPane.showMessageDialog(hoaDonTienDienView, "Không tìm thấy hóa đơn với ID cần tìm!", "Thông báo",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        }

    }
}
