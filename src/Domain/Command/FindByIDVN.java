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

public class FindByIDVN extends Command {

    public FindByIDVN(HoaDonTienDien hoaDonTienDien, HoaDonTienDienNN hoaDonTienDienNN,
            HoaDonTienDienVN hoaDonTienDienVN, HoaDonTienDienChucNang hoaDonTienDienChucNang,
            HoaDonTienDienView hoaDonTienDienView, HoaDonTienDienController hoaDonTienDienController) {
        super(hoaDonTienDien, hoaDonTienDienNN, hoaDonTienDienVN, hoaDonTienDienChucNang, hoaDonTienDienView,
                hoaDonTienDienController);
        this.hoaDonTienDienChucNang = hoaDonTienDienChucNang;
    }

    @Override
    public void execute() {
        findByID();
    }

    public void findByID() {
        String ID = JOptionPane.showInputDialog(hoaDonTienDienView, "Nhập ID", "ID", JOptionPane.PLAIN_MESSAGE);

        if (ID != null && !ID.isEmpty()) {
            boolean found = false; //
            List<HoaDonTienDienVN> hoaDonVNList = hoaDonTienDienChucNang.getAllHoaDonTienDienVN();
            hoaDonTienDienView.getTableModelVN().setRowCount(0); // Xóa toàn bộ dữ liệu trong bảng HoaDonTienDienVN

            // Tìm kiếm và thêm chỉ hàng ID cần tìm vào bảng HoaDonTienDienVN
            for (HoaDonTienDienVN hoaDonVN : hoaDonVNList) {
                if (hoaDonVN != null && Objects.equals(hoaDonVN.getIdKh(), Integer.parseInt(ID))) {
                    Object[] rowData = {
                            hoaDonVN.getIdKh(),
                            hoaDonVN.getHoTen(),
                            hoaDonVN.getNgayHD() != null ? hoaDonVN.getNgayHD().toString() : "",
                            hoaDonVN.getSoLuong(),
                            hoaDonVN.fromvalue(hoaDonVN.getDoiTuong()),
                            hoaDonVN.getDonGia(),
                            hoaDonVN.getDinhMuc(),
                            hoaDonVN.thanhTien()
                    };
                    hoaDonTienDienView.getTableModelVN().addRow(rowData); // Thêm hàng cần tìm vào bảng
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
