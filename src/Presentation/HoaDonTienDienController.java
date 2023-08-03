package Presentation;

import java.awt.event.ActionEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import Domain.HoaDonTienDienChucNang;
import Domain.Command.AddHoaDonNN;
import Domain.Command.AddHoaDonVN;
import Domain.Command.Command;
import Domain.Command.CommandProcessor;
import Domain.Command.DeleteNN;
import Domain.Command.DeleteVN;
import Domain.Command.FindByIDNN;
import Domain.Command.FindByIDVN;
import Domain.Command.ThanhTienNN;
import Domain.Command.ThanhTienVN;
import Domain.Command.UpdateNN;
import Domain.Command.UpdateVN;

import Domain.Model.HoaDonTienDienNN;
import Domain.Model.HoaDonTienDienVN;

public class HoaDonTienDienController extends JOptionPane {

    private HoaDonTienDienView hoaDonTienDienView;
    private HoaDonTienDienVN hoaDonTienDienVN;
    private HoaDonTienDienNN hoaDonTienDienNN;
    private HoaDonTienDienChucNang hoaDonTienDienChucNang;
    private CommandProcessor commandProcessor;

    public HoaDonTienDienController() {
    }

    public HoaDonTienDienController(HoaDonTienDienView viewRemote) {
        this.hoaDonTienDienView = viewRemote;

    }

    public boolean isValidInputVN() {
        // Kiểm tra hợp lệ cho các trường dữ liệu dành cho Việt Nam
        try {
            // int id = Integer.parseInt(hoaDonTienDienView.getIdTextField().getText());
            String hoTen = hoaDonTienDienView.getHoTenTextField().getText();
            String ngayRaHoaDon = hoaDonTienDienView.getNgayRaHoaDonTextField().getText();
            double soLuong = Double.parseDouble(hoaDonTienDienView.getSoLuongTextField().getText());
            double donGia = Double.parseDouble(hoaDonTienDienView.getDonGiaTextField().getText());
            double dinhMuc = Double.parseDouble(hoaDonTienDienView.getDinhmucTextField().getText());

            // Kiểm tra các điều kiện hợp le
            if (hoTen.isEmpty() || ngayRaHoaDon.isEmpty() || soLuong <= 0 || donGia <= 0 || dinhMuc < 0) {
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
            double donGia = Double.parseDouble(hoaDonTienDienView.getDonGiaTextField().getText());
            String quocTich = hoaDonTienDienView.getQuocTichTextField().getText();

            // Kiểm tra các điều kiện hợp lệ, ví dụ: không để trống và giá trị dương
            if (hoTen.isEmpty() || ngayRaHoaDon.isEmpty() || soLuong <= 0 || donGia <= 0
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

    public void setHoaDonVN() {
        String ngayHoatDongStr = hoaDonTienDienView.getNgayRaHoaDonTextField().getText();
        dateFormat(ngayHoatDongStr);
        hoaDonTienDienVN.setNgayHD(dateFormat(ngayHoatDongStr));
        hoaDonTienDienVN.setHoTen(hoaDonTienDienView.getHoTenTextField().getText());
        hoaDonTienDienVN.setSoLuong(Double.parseDouble(hoaDonTienDienView.getSoLuongTextField().getText()));
        hoaDonTienDienVN.setDinhMuc(Double.parseDouble(hoaDonTienDienView.getDinhmucTextField().getText()));
        // Lấy giá trị ngày hoạt động từ trường nhập liệu và chuyển đổi sang định dạng
        // Date
        hoaDonTienDienVN.setDonGia(Double.parseDouble(hoaDonTienDienView.getDonGiaTextField().getText()));

        if (0 == hoaDonTienDienView.getDoiTuongKHComboBox().getSelectedIndex()) {
            hoaDonTienDienVN.setDoiTuongkh(hoaDonTienDienVN.fromvalue(0));
        } else if (1 == hoaDonTienDienView.getDoiTuongKHComboBox().getSelectedIndex()) {
            hoaDonTienDienVN.setDoiTuongkh(hoaDonTienDienVN.fromvalue(1));
        } else {
            hoaDonTienDienVN.setDoiTuongkh(hoaDonTienDienVN.fromvalue(2));
        }
        hoaDonTienDienVN.setDoiTuong(hoaDonTienDienView.getDoiTuongKHComboBox().getSelectedIndex());

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

    public void setHoaDonNN() {
        String ngayHoatDongStr = hoaDonTienDienView.getNgayRaHoaDonTextField().getText();
        dateFormat(ngayHoatDongStr);
        hoaDonTienDienNN.setNgayHD(dateFormat(ngayHoatDongStr));
        hoaDonTienDienNN.setHoTen(hoaDonTienDienView.getHoTenTextField().getText());
        hoaDonTienDienNN.setSoLuong(Double.parseDouble(hoaDonTienDienView.getSoLuongTextField().getText()));
        hoaDonTienDienNN.setQuocTich(hoaDonTienDienView.getQuocTichTextField().getText());
        hoaDonTienDienNN.setDonGia(Double.parseDouble(hoaDonTienDienView.getDonGiaTextField().getText()));
    }

    public void addHD(ActionEvent e) {

        if ("Việt Nam".equals(hoaDonTienDienView.getQuoctichComboBox().getSelectedItem())) {
            Command addHoaDonVNcommand = new AddHoaDonVN(hoaDonTienDienView.getHoaDonTienDien(),
                    hoaDonTienDienNN,
                    hoaDonTienDienVN, hoaDonTienDienChucNang,
                    hoaDonTienDienView, this);

            commandProcessor.execute(addHoaDonVNcommand);
            clearFields();

        } else {

            Command addHoaDonNNcommand = new AddHoaDonNN(hoaDonTienDienView.getHoaDonTienDien(),
                    hoaDonTienDienNN,
                    hoaDonTienDienVN, hoaDonTienDienChucNang,
                    hoaDonTienDienView, this);
            commandProcessor.execute(addHoaDonNNcommand);
            clearFields();
        }
        hoaDonTienDienNN.notifySubcriber();
        hoaDonTienDienVN.notifySubcriber();

    }

    public void updateHD(ActionEvent e) {
        if ("Việt Nam".equals(hoaDonTienDienView.getQuoctichComboBox().getSelectedItem())) {

            Command updateHoaDonVNcommand = new UpdateVN(hoaDonTienDienView.getHoaDonTienDien(),
                    hoaDonTienDienNN,
                    hoaDonTienDienVN, hoaDonTienDienChucNang,
                    hoaDonTienDienView, this);
            commandProcessor.execute(updateHoaDonVNcommand);
            clearFields();

        } else {

            Command updateHoaDonNNcommand = new UpdateNN(hoaDonTienDienView.getHoaDonTienDien(),
                    hoaDonTienDienNN,
                    hoaDonTienDienVN, hoaDonTienDienChucNang,
                    hoaDonTienDienView, this);
            commandProcessor.execute(updateHoaDonNNcommand);
            clearFields();
        }
        hoaDonTienDienNN.notifySubcriber();
        hoaDonTienDienVN.notifySubcriber();
    }

    public void deleteHD(ActionEvent e) {
        if ("Việt Nam".equals(hoaDonTienDienView.getQuoctichComboBox().getSelectedItem().toString())) {
            int option = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa?", "Xác nhận xóa",
                    JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.YES_OPTION) {
                Command deletecommand = new DeleteVN(hoaDonTienDienView.getHoaDonTienDien(),
                        hoaDonTienDienNN,
                        hoaDonTienDienVN, hoaDonTienDienChucNang,
                        hoaDonTienDienView, this);
                try {

                    commandProcessor.execute(deletecommand);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "Vui lòng chọn hóa đơn muốn xóa");
                }
                
                clearFields();
            }
        } else {
            int option = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa?", "Xác nhận xóa",
                    JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.YES_OPTION) {
                Command deletecommand = new DeleteNN(hoaDonTienDienView.getHoaDonTienDien(),
                        hoaDonTienDienNN,
                        hoaDonTienDienVN, hoaDonTienDienChucNang,
                        hoaDonTienDienView, this);
               try {

                    commandProcessor.execute(deletecommand);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "Vui lòng chọn hóa đơn muốn xóa");
                }
                
                clearFields();
            }
        }
        hoaDonTienDienNN.notifySubcriber();
        hoaDonTienDienVN.notifySubcriber();

    }

    public void thanhTien() {
        String soLuongStr = hoaDonTienDienView.getSoLuongTextField().getText();
        String donGiaStr = hoaDonTienDienView.getDonGiaTextField().getText();
        String dinhMucStr = hoaDonTienDienView.getDinhmucTextField().getText();

        if (!soLuongStr.isEmpty() && !donGiaStr.isEmpty() && !dinhMucStr.isEmpty()) {
            double soLuong = Double.parseDouble(soLuongStr);
            double donGia = Double.parseDouble(donGiaStr);
            double dinhMuc = Double.parseDouble(dinhMucStr);

            if ("Việt Nam".equals(hoaDonTienDienView.getQuoctichComboBox().getSelectedItem())) {
                hoaDonTienDienView.getHoaDonTienDienVN().setSoLuong(soLuong);
                hoaDonTienDienView.getHoaDonTienDienVN().setDonGia(donGia);
                hoaDonTienDienView.getHoaDonTienDienVN().setDinhMuc(dinhMuc);

                Command thanhTienVNcommand = new ThanhTienVN(hoaDonTienDienView.getHoaDonTienDien(),
                        hoaDonTienDienNN,
                        hoaDonTienDienVN, hoaDonTienDienChucNang,
                        hoaDonTienDienView, this);
                CommandProcessor commandProcessor = new CommandProcessor();
                commandProcessor.execute(thanhTienVNcommand);

                double thanhTien = hoaDonTienDienView.getHoaDonTienDienVN().thanhTien();
                hoaDonTienDienView.getThanhTienTextField().setText(String.valueOf(thanhTien));
            } else {
                hoaDonTienDienNN.setSoLuong(soLuong);
                hoaDonTienDienNN.setDonGia(donGia);

                Command thanhTienNNcommand = new ThanhTienNN(hoaDonTienDienView.getHoaDonTienDien(),
                        hoaDonTienDienNN,
                        hoaDonTienDienVN, hoaDonTienDienChucNang,
                        hoaDonTienDienView, this);
                CommandProcessor commandProcessor = new CommandProcessor();
                commandProcessor.execute(thanhTienNNcommand);

                double thanhTien = hoaDonTienDienView.getHoaDonTienDienNN().thanhTien();
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

        hoaDonTienDienVN.notifySubcriber();
        hoaDonTienDienNN.notifySubcriber();

    }

    private void chooseVn() {
        hoaDonTienDienView.table.setModel(hoaDonTienDienView.getTableModelVN());
        hoaDonTienDienView.getQuocTichTextField().setEditable(false);
        hoaDonTienDienView.getDoiTuongKHComboBox().setEnabled(true);
        hoaDonTienDienView.getQuocTichTextField().setText("");
    }

    private void chooseNN() {
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        hoaDonTienDienView.table.setModel(hoaDonTienDienView.getTableModelNN());
        hoaDonTienDienView.getQuocTichTextField().setEditable(true);
        hoaDonTienDienView.getDinhmucTextField().setText("");
        hoaDonTienDienView.getDoiTuongKHComboBox().setEnabled(false);
        hoaDonTienDienView.getDonGiaTextField().setText("4.000");
        hoaDonTienDienView.getDoiTuongKHComboBox().setSelectedItem("");
        for (int i = 0; i < hoaDonTienDienView.getTableModelNN().getColumnCount(); i++) {
            hoaDonTienDienView.table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
    }

    public void doiTuongKHCheck(ActionEvent e) {
        hoaDonTienDienVN = new HoaDonTienDienVN();
        if (hoaDonTienDienView.getDoiTuongKHComboBox().getSelectedIndex() == 0) {
            hoaDonTienDienView.getDonGiaTextField().setText("3.000");
            hoaDonTienDienView.getDinhmucTextField().setText("350");
            hoaDonTienDienVN.setDonGia(3.000);
            hoaDonTienDienVN.setDinhMuc(350);

        } else if (hoaDonTienDienView.getDoiTuongKHComboBox().getSelectedIndex() == 1) {
            hoaDonTienDienView.getDonGiaTextField().setText("4.000");
            hoaDonTienDienView.getDinhmucTextField().setText("450");
            hoaDonTienDienVN.setDonGia(4.000);
            hoaDonTienDienVN.setDinhMuc(450);
        } else {
            hoaDonTienDienView.getDonGiaTextField().setText("5.000");
            hoaDonTienDienView.getDinhmucTextField().setText("550");
            hoaDonTienDienVN.setDonGia(5.000);
            hoaDonTienDienVN.setDinhMuc(550);
        }
    }

    public void calculateTotal(ActionEvent e) {
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

        JOptionPane.showMessageDialog(this,
                "Tổng số lượng KW khách hàng Việt Nam đã dùng: " + totalQuantityVN + "\n"
                        + "Tổng số lượng khách hàng Nước Ngoài đã dùng: " + totalQuantityNN,
                "Tổng số lượng KW",
                JOptionPane.INFORMATION_MESSAGE);
    }

    public void tinhTrungBinhThanhTienKhachNuocNgoai(ActionEvent e) {
        if ("Nước Ngoài".equals(hoaDonTienDienView.getQuoctichComboBox().getSelectedItem().toString())){
            double trungBinhThanhTien = hoaDonTienDienChucNang.tinhTrungBinhThanhTienKhachNuocNgoai(hoaDonTienDienNN);
            JOptionPane.showMessageDialog(this, "Trung bình thành tiền khách nước ngoài: " + trungBinhThanhTien, "Tổng trung bình",
                JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            JOptionPane.showMessageDialog(this, "Đây là chức năng chỉ dùng cho khách nước ngoài"+"\n"+"Xin vui lòng chọn lại quốc tịch",
            "Thông báo",JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void findByID(ActionEvent e) {
        try {
            if ("Việt Nam".equals(hoaDonTienDienView.getQuoctichComboBox().getSelectedItem())) {
                Command findVNCommand = new FindByIDVN(hoaDonTienDienView.getHoaDonTienDien(),
                        hoaDonTienDienView.getHoaDonTienDienNN(),
                        hoaDonTienDienView.getHoaDonTienDienVN(), hoaDonTienDienView.getHoaDonTienDienChucNang(),
                        hoaDonTienDienView, this);
                commandProcessor.execute(findVNCommand);
            } else {
                Command findNNCommand = new FindByIDNN(hoaDonTienDienView.getHoaDonTienDien(),
                        hoaDonTienDienView.getHoaDonTienDienNN(),
                        hoaDonTienDienView.getHoaDonTienDienVN(), hoaDonTienDienView.getHoaDonTienDienChucNang(),
                        hoaDonTienDienView, this);
                commandProcessor.execute(findNNCommand);

            }

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập ID dưới dạng số nguyên!", "Lỗi",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public void updateButton(ActionEvent e) {
        hoaDonTienDienVN.notifySubcriber();
        hoaDonTienDienVN.notifySubcriber();
    }

    public void setHoaDonTienDienVN(HoaDonTienDienVN hoaDonTienDienVN) {
        this.hoaDonTienDienVN = hoaDonTienDienVN;
    }

    public void setHoaDonTienDienNN(HoaDonTienDienNN hoaDonTienDienNN) {
        this.hoaDonTienDienNN = hoaDonTienDienNN;
    }

    public void setHoaDonTienDienChucNang(HoaDonTienDienChucNang hoaDonTienDienChucNangImp) {
        this.hoaDonTienDienChucNang = hoaDonTienDienChucNangImp;
    }

    public void setCommandProcessor(CommandProcessor commandProcessor) {
        this.commandProcessor = commandProcessor;
    }

}
