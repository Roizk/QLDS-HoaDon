package Presentation;

import java.awt.event.ActionEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import Domain.HoaDonTienDienChucNang;
import Domain.Model.HoaDonTienDien;
import Presentation.Command.AddHoaDon;
import Presentation.Command.Command;
import Presentation.Command.CommandProcessor;
import Presentation.Command.Delete;
import Presentation.Command.FindByID;
import Presentation.Command.ThanhTien;
import Presentation.Command.TinhTrungBinhThanhTien;
import Presentation.Command.TotalQuantity;
import Presentation.Command.Update;

public class HoaDonTienDienController extends JOptionPane {

    private HoaDonTienDienView hoaDonTienDienView;
    private HoaDonTienDien hoaDonTienDien;
    private HoaDonTienDienChucNang hoaDonTienDienChucNang;
    private CommandProcessor commandProcessor;

    public HoaDonTienDienController() {
    }

    public HoaDonTienDienController(HoaDonTienDienView viewRemote) {
        this.hoaDonTienDienView = viewRemote;
    }

    DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();

    public boolean isValidInputVN() {
        // Kiểm tra hợp lệ cho các trường dữ liệu dành cho Việt Nam
        try {
            // int id = Integer.parseInt(hoaDonTienDienView.getIdTextField().getText());
            String hoTen = hoaDonTienDienView.getHoTenTextField().getText();
            String ngayRaHoaDon = hoaDonTienDienView.getNgayRaHoaDonTextField().getText();
            double soLuong = Double.parseDouble(hoaDonTienDienView.getSoLuongTextField().getText());

            // Kiểm tra các điều kiện hợp le
            if (hoTen.isEmpty() || ngayRaHoaDon.isEmpty() || soLuong <= 0) {
                return false;
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đúng định dạng cho các trường dữ liệu!", "Lỗi",
                    JOptionPane.ERROR_MESSAGE);
            return false; // Lỗi định dạng dữ liệu không hợp lệ
        }
        return true;
    }

    public boolean isValidInputNN() {
        // Kiểm tra hợp lệ cho các trường dữ liệu dành cho Nước Ngoài
        try {
            // int id = Integer.parseInt(hoaDonTienDienView.getIdTextField().getText());
            String hoTen = hoaDonTienDienView.getHoTenTextField().getText();
            String ngayRaHoaDon = hoaDonTienDienView.getNgayRaHoaDonTextField().getText();
            double soLuong = Double.parseDouble(hoaDonTienDienView.getSoLuongTextField().getText());
            String quocTich = hoaDonTienDienView.getQuocTichTextField().getText();

            // Kiểm tra các điều kiện hợp lệ, ví dụ: không để trống và giá trị dương
            if (hoTen.isEmpty() || ngayRaHoaDon.isEmpty() || soLuong <= 0
                    || quocTich.isEmpty()) {
                return false;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đúng định dạng cho các trường dữ liệu!", "Lỗi",
                    JOptionPane.ERROR_MESSAGE);
            return false; // Lỗi định dạng dữ liệu không hợp lệ
        }

        return true;
    }

    public void setHoaDon() {
        if ("Việt Nam".equals(hoaDonTienDienView.getQuoctichComboBox().getSelectedItem().toString())) {
            String ngayHoatDongStr = hoaDonTienDienView.getNgayRaHoaDonTextField().getText();
            dateFormat(ngayHoatDongStr);
            hoaDonTienDien.setNgayHD(dateFormat(ngayHoatDongStr));
            hoaDonTienDien.setQuocTich(null);
            hoaDonTienDien.setHoTen(hoaDonTienDienView.getHoTenTextField().getText());
            hoaDonTienDien.setSoLuong(Double.parseDouble(hoaDonTienDienView.getSoLuongTextField().getText()));
            hoaDonTienDien.setDinhMuc(Double.parseDouble(hoaDonTienDienView.getDinhmucTextField().getText()));
            // Lấy giá trị ngày hoạt động từ trường nhập liệu và chuyển đổi sang định dạng
            // Date
            hoaDonTienDien.setDonGia(Double.parseDouble(hoaDonTienDienView.getDonGiaTextField().getText()));
            if (0 == hoaDonTienDienView.getDoiTuongKHComboBox().getSelectedIndex()) {
                hoaDonTienDien.setDoiTuongkh(hoaDonTienDien.fromvalue(0));
            } else if (1 == hoaDonTienDienView.getDoiTuongKHComboBox().getSelectedIndex()) {
                hoaDonTienDien.setDoiTuongkh(hoaDonTienDien.fromvalue(1));
            } else if (2 == hoaDonTienDienView.getDoiTuongKHComboBox().getSelectedIndex()) {
                hoaDonTienDien.setDoiTuongkh(hoaDonTienDien.fromvalue(2));
            }
            hoaDonTienDien.setDoiTuong(hoaDonTienDienView.getDoiTuongKHComboBox().getSelectedIndex());
        } else {
            String ngayHoatDongStr = hoaDonTienDienView.getNgayRaHoaDonTextField().getText();
            dateFormat(ngayHoatDongStr);
            hoaDonTienDien.setNgayHD(dateFormat(ngayHoatDongStr));
            hoaDonTienDien.setHoTen(hoaDonTienDienView.getHoTenTextField().getText());
            hoaDonTienDien.setSoLuong(Double.parseDouble(hoaDonTienDienView.getSoLuongTextField().getText()));
            hoaDonTienDien.setQuocTich(hoaDonTienDienView.getQuocTichTextField().getText());
        }

    }

    public Date dateFormat(String date) {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date ngayHoatDong = dateFormat.parse(date);
            return ngayHoatDong;
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void addHD(ActionEvent e) {
        if (isValidInputVN()) {
            setHoaDon();
            Command addHoaDoncommand = new AddHoaDon(hoaDonTienDien, hoaDonTienDienChucNang,
                    this);
            commandProcessor.execute(addHoaDoncommand);
            JOptionPane.showMessageDialog(hoaDonTienDienView, "Lưu thành công");
            clearFields();
        }
        hoaDonTienDien.notifySubcriber();

    }

    public void updateHD(ActionEvent e) {

        if (isValidInputVN()) {
            setHoaDon();
            hoaDonTienDien.setIdKh(Integer.parseInt(hoaDonTienDienView.getIdTextField().getText()));
            Command updateHoaDoncommand = new Update(hoaDonTienDien, hoaDonTienDienChucNang,
                    this);
            commandProcessor.execute(updateHoaDoncommand);
            JOptionPane.showMessageDialog(hoaDonTienDienView, "Sửa thành công");
            clearFields();
        }
        hoaDonTienDien.notifySubcriber();
    }

    public void deleteHD(ActionEvent e) {
        int option = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa?", "Xác nhận xóa",
                JOptionPane.YES_NO_OPTION);
        if (option == JOptionPane.YES_OPTION) {
            hoaDonTienDien.setIdKh(Integer.parseInt(hoaDonTienDienView.getIdTextField().getText()));
            Command deletecommand = new Delete(hoaDonTienDien, hoaDonTienDienChucNang,
                    this);
            try {
                commandProcessor.execute(deletecommand);
                JOptionPane.showMessageDialog(hoaDonTienDienView, "Xóa thành công");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Vui lòng chọn hóa đơn muốn xóa");
            }
            clearFields();
        }
        hoaDonTienDien.notifySubcriber();
    }

    public void thanhTien() {
        String soLuongStr = hoaDonTienDienView.getSoLuongTextField().getText();
        String donGiaStr = hoaDonTienDienView.getDonGiaTextField().getText();
        String dinhMucStr = hoaDonTienDienView.getDinhmucTextField().getText();

        if ("Việt Nam".equals(hoaDonTienDienView.getQuoctichComboBox().getSelectedItem())) {
            if (!soLuongStr.isEmpty() && !donGiaStr.isEmpty() && !dinhMucStr.isEmpty()) {
                double soLuong = Double.parseDouble(soLuongStr);
                double donGia = Double.parseDouble(donGiaStr);
                double dinhMuc = Double.parseDouble(dinhMucStr);
                hoaDonTienDienView.getHoaDonTienDien().setSoLuong(soLuong);
                hoaDonTienDienView.getHoaDonTienDien().setDonGia(donGia);
                hoaDonTienDienView.getHoaDonTienDien().setDinhMuc(dinhMuc);

                Command thanhTiencommand = new ThanhTien(hoaDonTienDien, hoaDonTienDienChucNang,
                        this);
                CommandProcessor commandProcessor = new CommandProcessor();
                commandProcessor.execute(thanhTiencommand);

                double thanhTien = hoaDonTienDienView.getHoaDonTienDien().thanhTien();
                hoaDonTienDienView.getThanhTienTextField().setText(String.valueOf(thanhTien));
            }
        } else {
            if (!soLuongStr.isEmpty() && !donGiaStr.isEmpty()) {
                double soLuong = Double.parseDouble(soLuongStr);
                double donGia = Double.parseDouble(donGiaStr);

                hoaDonTienDienView.getHoaDonTienDien().setSoLuong(soLuong);
                hoaDonTienDienView.getHoaDonTienDien().setDonGia(donGia);

                Command thanhTiencommand = new ThanhTien(hoaDonTienDien, hoaDonTienDienChucNang,
                        this);
                CommandProcessor commandProcessor = new CommandProcessor();
                commandProcessor.execute(thanhTiencommand);

                double thanhTien = hoaDonTienDienView.getHoaDonTienDien().thanhTien();
                hoaDonTienDienView.getThanhTienTextField().setText(String.valueOf(thanhTien));
            }
        }
    }

    private void clearFields() {
        hoaDonTienDienView.getIdTextField().setText("");
        hoaDonTienDienView.getHoTenTextField().setText("");
        hoaDonTienDienView.getNgayRaHoaDonTextField().setText("");
        hoaDonTienDienView.getSoLuongTextField().setText("");
        hoaDonTienDienView.getDonGiaTextField().setText("");
        hoaDonTienDienView.getDinhmucTextField().setText("");
        hoaDonTienDienView.getThanhTienTextField().setText("");
        hoaDonTienDienView.getQuocTichTextField().setText("");
        hoaDonTienDienView.getDoiTuongKHComboBox().setSelectedIndex(0);
    }

    public void KiemtraQT(ActionEvent e) {

        if ("Việt Nam".equals(hoaDonTienDienView.getQuoctichComboBox().getSelectedItem())) {
            clearFields();
            chooseVn();
        } else {
            clearFields();
            chooseNN();
        }

        hoaDonTienDien.notifySubcriber();
    }

    private void chooseVn() {
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        hoaDonTienDienView.table.setModel(hoaDonTienDienView.getTableModelVN());
        hoaDonTienDienView.getQuocTichTextField().setEditable(false);
        hoaDonTienDienView.getDoiTuongKHComboBox().setEnabled(true);
        hoaDonTienDienView.getQuocTichTextField().setText("");
        formatCenterCell(hoaDonTienDienView.getTableModelVN());
    }

    public void formatCenterCell(DefaultTableModel tableModel) {
        for (int i = 0; i < tableModel.getColumnCount() - 1; i++) {
            hoaDonTienDienView.table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
    }

    private void chooseNN() {
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        hoaDonTienDienView.table.setModel(hoaDonTienDienView.getTableModelNN());
        hoaDonTienDienView.getQuocTichTextField().setEditable(true);
        hoaDonTienDienView.getDinhmucTextField().setText("");
        hoaDonTienDienView.getDoiTuongKHComboBox().setEnabled(false);
        hoaDonTienDienView.getDonGiaTextField().setText("4000");
        hoaDonTienDienView.getDoiTuongKHComboBox().setSelectedItem("");
        formatCenterCell(hoaDonTienDienView.getTableModelNN());
    }

    public void doiTuongKHCheck(ActionEvent e) {
        // hoaDonTienDien = new HoaDonTienDien();
        if (hoaDonTienDienView.getDoiTuongKHComboBox().getSelectedIndex() == 0) {
            hoaDonTienDienView.getDonGiaTextField().setText("3000");
            hoaDonTienDienView.getDinhmucTextField().setText("350");
            hoaDonTienDien.setDonGia(3.000);
            hoaDonTienDien.setDinhMuc(350);

        } else if (hoaDonTienDienView.getDoiTuongKHComboBox().getSelectedIndex() == 1) {
            hoaDonTienDienView.getDonGiaTextField().setText("4000");
            hoaDonTienDienView.getDinhmucTextField().setText("450");
            hoaDonTienDien.setDonGia(4.000);
            hoaDonTienDien.setDinhMuc(450);
        } else {
            hoaDonTienDienView.getDonGiaTextField().setText("5000");
            hoaDonTienDienView.getDinhmucTextField().setText("550");
            hoaDonTienDien.setDonGia(5.000);
            hoaDonTienDien.setDinhMuc(550);
        }
    }

    public void calculateTotal(ActionEvent e) {
        if ("Việt Nam".equals(hoaDonTienDienView.getQuoctichComboBox().getSelectedItem())){
            TotalQuantity TotalQuantity = new TotalQuantity(hoaDonTienDien, hoaDonTienDienChucNang,this);
            hoaDonTienDien.setQuocTich(hoaDonTienDienView.getQuoctichComboBox().getSelectedItem().toString());
            commandProcessor.execute(TotalQuantity);
            JOptionPane.showMessageDialog(this,"Tổng số lượng KW khách hàng Việt Nam đã dùng: " + TotalQuantity.getTotalQuantity(),
            "Tổng số lượng KW", JOptionPane.INFORMATION_MESSAGE);
        }else if ("Nước Ngoài".equals(hoaDonTienDienView.getQuoctichComboBox().getSelectedItem())){
            TotalQuantity TotalQuantity = new TotalQuantity(hoaDonTienDien, hoaDonTienDienChucNang,this);
            hoaDonTienDien.setQuocTich(hoaDonTienDienView.getQuoctichComboBox().getSelectedItem().toString());
            commandProcessor.execute(TotalQuantity);
            JOptionPane.showMessageDialog(this,"Tổng số lượng KW khách hàng nước ngoài đã dùng: " + TotalQuantity.getTotalQuantity(),
            "Tổng số lượng KW", JOptionPane.INFORMATION_MESSAGE);
        }else {
            JOptionPane.showMessageDialog(this,"Xin chọn quốc tịch ", "Thông Báo", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void tinhTrungBinhThanhTienKhachNuocNgoai(ActionEvent e) {
        if ("Nước Ngoài".equals(hoaDonTienDienView.getQuoctichComboBox().getSelectedItem())) {
            TinhTrungBinhThanhTien tinhTrungBinhCommand = new TinhTrungBinhThanhTien(
                    hoaDonTienDienView.getHoaDonTienDien(),
                    hoaDonTienDienView.getHoaDonTienDienChucNang(), this);
            tinhTrungBinhCommand.execute();
            if (tinhTrungBinhCommand.getTBThanhTien() != 0) {
                JOptionPane.showMessageDialog(hoaDonTienDienView,
                        "Trung bình thành tiền khách nước ngoài: " + tinhTrungBinhCommand.getTBThanhTien(),
                        "Tổng trung bình",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(hoaDonTienDienView, "Thiếu dữ liệu", "Thông báo",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this,
                    "Đây là chức năng chỉ dùng cho khách nước ngoài" + "\n" + "Xin vui lòng chọn lại quốc tịch",
                    "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void findByID(ActionEvent e) {
        try {

            hoaDonTienDien.setQuocTich(hoaDonTienDienView.getQuoctichComboBox().getSelectedItem().toString());
            hoaDonTienDien.setHoTen(hoaDonTienDienView.getTimKiemTextField().getText());
            FindByID findCommand = new FindByID(hoaDonTienDien,
                    hoaDonTienDienView.getHoaDonTienDienChucNang(),
                    this);
            commandProcessor.execute(findCommand);
            hoaDonTienDienView.getTableModelVN().setRowCount(0);
            hoaDonTienDienView.table.setModel(findCommand.getTable());
            formatCenterCell(findCommand.getTable());

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập ID dưới dạng số nguyên!", "Lỗi",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public void setHoaDonTienDien(HoaDonTienDien hoaDonTienDien) {
        this.hoaDonTienDien = hoaDonTienDien;
    }

    public void setHoaDonTienDienChucNang(HoaDonTienDienChucNang hoaDonTienDienChucNangImp) {
        this.hoaDonTienDienChucNang = hoaDonTienDienChucNangImp;
    }

    public void setCommandProcessor(CommandProcessor commandProcessor) {
        this.commandProcessor = commandProcessor;
    }

}
