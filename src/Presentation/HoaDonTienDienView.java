package Presentation;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import Domain.HoaDonTienDienChucNang;
import Domain.Command.AddHoaDonNN;
import Domain.Command.AddHoaDonVN;
import Domain.Command.Delete;
import Domain.Command.ThanhTienVN;
import Domain.Command.UpdateNN;
import Domain.Command.UpdateVN;
import Domain.Model.HoaDonTienDien;
import Domain.Model.HoaDonTienDienNN;
import Domain.Model.HoaDonTienDienVN;

public class HoaDonTienDienView extends JFrame implements Subcriber {

    private HoaDonTienDienController hoaDonTienDienController;
    private HoaDonTienDienChucNang hoaDonTienDienChucNang;
    private HoaDonTienDien hoaDonTienDien;
    private HoaDonTienDienVN hoaDonTienDienVN;
    private HoaDonTienDienNN hoaDonTienDienNN;

    private DefaultTableModel tableModelVN;
    private DefaultTableModel tableModelNN;
    private JTable table;
    private JButton addButton;
    private JButton editButton;
    private JButton deleteButton;
    private JButton findButton;
    private JButton saveButton;

    private JTextField idTextField;
    private JTextField hoTenTextField;
    private JTextField ngayRaHoaDonTextField;
    private JTextField donGiaTextField;
    private JTextField dinhmucTextField;
    private JTextField soLuongTextField;
    private JTextField thanhTienTextField;
    private JTextField quocTichTextField;
    private JComboBox<String> quoctichComboBox;
    private JComboBox<String> doiTuongKHComboBox;

    public HoaDonTienDienView() {

        hoaDonTienDienController = new HoaDonTienDienController(this);

    }

    public void display() {
        // Set up JFrame

        setTitle("Hóa đơn tiền điện");
        setSize(1200, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);

        // Create JTable to display BillVN list
        tableModelVN = new DefaultTableModel();
        tableModelVN.addColumn("Id khách hàng ");
        tableModelVN.addColumn("Họ tên ");
        tableModelVN.addColumn("Ngày ra hóa đơn ");
        tableModelVN.addColumn("Số lượng ");
        tableModelVN.addColumn("Đối tượng ");
        tableModelVN.addColumn("Đơn giá");
        tableModelVN.addColumn("Định mức ");
        tableModelVN.addColumn("Thành tiền ");
        table = new JTable(tableModelVN);

        // Create JTable to display BillNN list
        tableModelNN = new DefaultTableModel();
        tableModelNN.addColumn("Id khách hàng ");
        tableModelNN.addColumn("Họ tên ");
        tableModelNN.addColumn("quốc tịch nước ngoài");
        tableModelNN.addColumn("Ngày ra hóa đơn ");
        tableModelNN.addColumn("Số lượng ");
        tableModelNN.addColumn("Đơn giá");
        tableModelNN.addColumn("Thành tiền ");
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        // Create JPanel for student details input and buttons
        JPanel inputPanel = new JPanel(new GridLayout(14, 2));

        quoctichComboBox = new JComboBox<>();
        doiTuongKHComboBox = new JComboBox<>();

        // add item Quoctich combobox
        quoctichComboBox.addItem("");
        quoctichComboBox.addItem("Việt Nam");
        quoctichComboBox.addItem("Nước Ngoài");
        quoctichComboBox.addActionListener(this::KiemtraQT);

        // add item DoituongKH combobox
        doiTuongKHComboBox.addItem("");
        doiTuongKHComboBox.addItem("Sinh hoạt");
        doiTuongKHComboBox.addItem("Kinh doanh");
        doiTuongKHComboBox.addItem("Sản xuất");

        idTextField = new JTextField();
        hoTenTextField = new JTextField();
        ngayRaHoaDonTextField = new JTextField();
        soLuongTextField = new JTextField();
        donGiaTextField = new JTextField();
        dinhmucTextField = new JTextField();
        thanhTienTextField = new JTextField();
        quocTichTextField = new JTextField();
        addButton = new JButton("Thêm");
        editButton = new JButton("Sửa");
        deleteButton = new JButton("Xóa");
        findButton = new JButton("Tìm kiếm");
        saveButton = new JButton("Lưu");

        inputPanel.add(new JLabel("Quốc tịch"));
        inputPanel.add(quoctichComboBox);
        inputPanel.add(new JLabel("Tên quốc tịch"));
        inputPanel.add(quocTichTextField);
        inputPanel.add(new JLabel("ID:"));
        inputPanel.add(idTextField);
        inputPanel.add(new JLabel("Họ tên:"));
        inputPanel.add(hoTenTextField);
        inputPanel.add(new JLabel("Ngày ra hóa đơn:"));
        inputPanel.add(ngayRaHoaDonTextField);
        inputPanel.add(new JLabel("Số lượng:"));
        inputPanel.add(soLuongTextField);
        inputPanel.add(new JLabel("Đối tượng:"));
        inputPanel.add(doiTuongKHComboBox);
        inputPanel.add(new JLabel("Đơn giá:"));
        inputPanel.add(donGiaTextField);
        inputPanel.add(new JLabel("Định mức:"));
        inputPanel.add(dinhmucTextField);
        inputPanel.add(new JLabel("Thành tiền:"));
        inputPanel.add(thanhTienTextField);
        thanhTienTextField.setEditable(false);
        inputPanel.add(addButton);
        addButton.addActionListener(this::addHD);
        inputPanel.add(editButton);
        editButton.addActionListener(this::updateHD);
        inputPanel.add(deleteButton);
        deleteButton.addActionListener(this::deleteHD);
        inputPanel.add(findButton);
        findButton.addActionListener(this::findByID);
        inputPanel.add(saveButton);

        add(inputPanel, BorderLayout.SOUTH);
        this.setVisible(true);
        setLocationRelativeTo(null);

        for (int i = 0; i < tableModelVN.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

        for (int i = 0; i < tableModelNN.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

        hoaDonTienDienVN.attach(this);
        hoaDonTienDienNN.attach(this);
        hoaDonTienDienVN.notifySubcriber();
        hoaDonTienDienNN.notifySubcriber();

    }

    public void KiemtraQT(ActionEvent e) {

        if (quoctichComboBox.getSelectedItem() == "Việt Nam") {
            chooseVn();
        } else {
            chooseNN();
            if (!soLuongTextField.getText().isEmpty() && !donGiaTextField.getText().isEmpty()) {
                HoaDonTienDienNN hoaDonTienDienNN = new HoaDonTienDienNN();
                thanhTienTextField.setText(hoaDonTienDienNN.toString());
            }
        }
    }

    public void findByID(ActionEvent e) {
        JOptionPane.showInputDialog(this, "Nhập ID", "ID");
    }

    public void test() {
        hoaDonTienDienVN = getHoaDonTienDienVN();
        hoaDonTienDienVN.fromvalue(hoaDonTienDienVN.getDoiTuong());
    }

    public void thanhTien() {
        ThanhTienVN thanhTienVNcommand = new ThanhTienVN(getHoaDonTienDien(), getHoaDonTienDienNN(),
                getHoaDonTienDienVN(), getHoaDonTienDienChucNang());
        hoaDonTienDienController.execute(thanhTienVNcommand);
    }

    public void addHD(ActionEvent e) {
        if ("Việt Nam".equals(quoctichComboBox.getSelectedItem())) {
            if (isValidInputVN()) {
                setHoaDonVN();
                AddHoaDonVN addHoaDonVNcommand = new AddHoaDonVN(getHoaDonTienDien(), getHoaDonTienDienNN(),
                        getHoaDonTienDienVN(), getHoaDonTienDienChucNang());
                hoaDonTienDienController.execute(addHoaDonVNcommand);
                clearFields();
            }
        } else {
            if (isValidInputNN()) {
                setHoaDonNN();
                AddHoaDonNN addHoaDonNNcommand = new AddHoaDonNN(getHoaDonTienDien(), getHoaDonTienDienNN(),
                        getHoaDonTienDienVN(), getHoaDonTienDienChucNang());
                hoaDonTienDienController.execute(addHoaDonNNcommand);
                clearFields();
            }
            JOptionPane.showMessageDialog(this, "Lưu thành công");
        }
        hoaDonTienDienVN.notifySubcriber();
        hoaDonTienDienNN.notifySubcriber();
    }

    public void updateHD(ActionEvent e) {
        if ("Việt Nam".equals(quoctichComboBox.getSelectedItem())) {
            if (isValidInputVN()) {
                setHoaDonVN();
                UpdateVN updateHoaDonVNcommand = new UpdateVN(getHoaDonTienDien(), getHoaDonTienDienNN(),
                        getHoaDonTienDienVN(), getHoaDonTienDienChucNang());
                hoaDonTienDienController.execute(updateHoaDonVNcommand);
                clearFields();
            }
        } else {
            if (isValidInputNN()) {
                setHoaDonNN();
                UpdateNN updateHoaDonNNcommand = new UpdateNN(getHoaDonTienDien(), getHoaDonTienDienNN(),
                        getHoaDonTienDienVN(), getHoaDonTienDienChucNang());
                hoaDonTienDienController.execute(updateHoaDonNNcommand);
                clearFields();
            }
            JOptionPane.showMessageDialog(this, "Lưu thành công");
        }
        hoaDonTienDienVN.notifySubcriber();
        hoaDonTienDienNN.notifySubcriber();
    }

    public void deleteHD(ActionEvent e) {
        Delete deletecommand = new Delete(getHoaDonTienDien(), getHoaDonTienDienNN(), getHoaDonTienDienVN(),
                getHoaDonTienDienChucNang());
        hoaDonTienDienController.execute(deletecommand);
        clearFields();
        JOptionPane.showMessageDialog(this, "Sửa thành công");
        hoaDonTienDienVN.notifySubcriber();
        hoaDonTienDienNN.notifySubcriber();
    }

    private void chooseVn() {
        table.setModel(tableModelVN);
        quocTichTextField.setEditable(false);
        dinhmucTextField.setEditable(true);
        doiTuongKHComboBox.setEnabled(true);
        quocTichTextField.setText("");
    }

    private void chooseNN() {
        table.setModel(tableModelNN);
        quocTichTextField.setEditable(true);
        dinhmucTextField.setEditable(false);
        doiTuongKHComboBox.setEnabled(false);
        doiTuongKHComboBox.setSelectedItem("");
    }

    private void setHoaDonVN() {
        hoaDonTienDienVN.setIdKh(Integer.parseInt(idTextField.getText()));
        hoaDonTienDienVN.setHoTen(hoTenTextField.getText());
        hoaDonTienDienVN.setSoLuong(Double.parseDouble(soLuongTextField.getText()));
        hoaDonTienDienVN.setDinhMuc(Double.parseDouble(dinhmucTextField.getText()));

        if (0 == doiTuongKHComboBox.getSelectedIndex()) {
            hoaDonTienDienVN.setDoiTuongkh(hoaDonTienDienVN.fromvalue(0));
        } else if (1 == doiTuongKHComboBox.getSelectedIndex()) {
            hoaDonTienDienVN.setDoiTuongkh(hoaDonTienDienVN.fromvalue(1));
        } else {
            hoaDonTienDienVN.setDoiTuongkh(hoaDonTienDienVN.fromvalue(2));
        }

        hoaDonTienDienVN.setDonGia(Double.parseDouble(donGiaTextField.getText()));
    }

    private void setHoaDonNN() {
        hoaDonTienDienNN.setIdKh(Integer.parseInt(idTextField.getText()));
        hoaDonTienDienNN.setHoTen(hoTenTextField.getText());
        hoaDonTienDienNN.setSoLuong(Double.parseDouble(soLuongTextField.getText()));
        hoaDonTienDienNN.setQuocTich(quocTichTextField.getText());
        hoaDonTienDienVN.setDonGia(Double.parseDouble(donGiaTextField.getText()));
    }

    private boolean isValidInputVN() {
        // Kiểm tra hợp lệ cho các trường dữ liệu dành cho Việt Nam
        try {
            int id = Integer.parseInt(idTextField.getText());
            String hoTen = hoTenTextField.getText();
            String ngayRaHoaDon = ngayRaHoaDonTextField.getText();
            double soLuong = Double.parseDouble(soLuongTextField.getText());
            double donGia = Double.parseDouble(donGiaTextField.getText());
            double dinhMuc = Double.parseDouble(dinhmucTextField.getText());

            // Kiểm tra các điều kiện hợp lệ, ví dụ: không để trống và giá trị dương
            if (id <= 0 || hoTen.isEmpty() || ngayRaHoaDon.isEmpty() || soLuong <= 0 || donGia <= 0 || dinhMuc < 0) {
                return false;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đúng định dạng cho các trường dữ liệu!", "Lỗi",
                    JOptionPane.ERROR_MESSAGE);
            return false; // Lỗi định dạng dữ liệu không hợp lệ
        }

        return true;
    }

    private boolean isValidInputNN() {
        // Kiểm tra hợp lệ cho các trường dữ liệu dành cho Nước Ngoài
        try {
            int id = Integer.parseInt(idTextField.getText());
            String hoTen = hoTenTextField.getText();
            String ngayRaHoaDon = ngayRaHoaDonTextField.getText();
            double soLuong = Double.parseDouble(soLuongTextField.getText());
            double donGia = Double.parseDouble(donGiaTextField.getText());
            String quocTich = quocTichTextField.getText();

            // Kiểm tra các điều kiện hợp lệ, ví dụ: không để trống và giá trị dương
            if (id <= 0 || hoTen.isEmpty() || ngayRaHoaDon.isEmpty() || soLuong <= 0 || donGia <= 0
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

    @Override
    public void update() {
        // Lấy dữ liệu từ cơ sở dữ liệu (sử dụng phương thức thích hợp từ
        // HoaDonJdbcGateway)
        List<HoaDonTienDienNN> hoaDonNNList = hoaDonTienDienChucNang.getAllHoaDonTienDienNN();

        tableModelNN.setRowCount(0);

        // Thêm dữ liệu vào bảng
        for (HoaDonTienDienNN hoaDonNN : hoaDonNNList) {
            Object[] rowData = {
                    hoaDonNN.getIdKh(),
                    hoaDonNN.getHoTen(),
                    hoaDonNN.getQuocTich(),
                    hoaDonNN.getNgayHD(),
                    hoaDonNN.getSoLuong(),
                    hoaDonNN.getDonGia(),
                    hoaDonNN.thanhTien()
            };
            tableModelNN.addRow(rowData);
        }
        List<HoaDonTienDienVN> hoaDonVNList = hoaDonTienDienChucNang.getAllHoaDonTienDienVN();

        tableModelVN.setRowCount(0);

        for (HoaDonTienDienVN hoaDonVN : hoaDonVNList) {
            Object[] rowData = {
                    hoaDonVN.getIdKh(),
                    hoaDonVN.getHoTen(),
                    hoaDonVN.getNgayHD(),
                    hoaDonVN.getSoLuong(),
                    hoaDonVN.fromvalue(hoaDonVN.getDoiTuong()),
                    hoaDonVN.getDonGia(),
                    hoaDonVN.getDinhMuc(),
                    hoaDonVN.thanhTien()
            };
            tableModelVN.addRow(rowData);
        }
    }

    private void clearFields() {
        idTextField.setText("");
        hoTenTextField.setText("");
        ngayRaHoaDonTextField.setText("");
        soLuongTextField.setText("");
        donGiaTextField.setText("");
        dinhmucTextField.setText("");
        thanhTienTextField.setText("");
    }

    public HoaDonTienDienChucNang getHoaDonTienDienChucNang() {
        return hoaDonTienDienChucNang;
    }

    public HoaDonTienDien getHoaDonTienDien() {
        return hoaDonTienDien;
    }

    public HoaDonTienDienVN getHoaDonTienDienVN() {
        return hoaDonTienDienVN;
    }

    public HoaDonTienDienNN getHoaDonTienDienNN() {
        return hoaDonTienDienNN;
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

}
