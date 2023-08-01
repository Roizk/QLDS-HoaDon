package Presentation;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import javax.swing.event.DocumentEvent;

import Domain.HoaDonTienDienChucNang;
import Domain.Command.AddHoaDonNN;
import Domain.Command.AddHoaDonVN;
import Domain.Command.Command;
import Domain.Command.DeleteNN;
import Domain.Command.DeleteVN;
import Domain.Command.ThanhTienNN;
import Domain.Command.ThanhTienVN;
import Domain.Command.UpdateNN;
import Domain.Command.UpdateVN;
import Domain.Model.HoaDonTienDien;
import Domain.Model.HoaDonTienDienNN;
import Domain.Model.HoaDonTienDienVN;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
    private JButton updateButton;
    private JButton calculateTotalButton;

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
        updateButton = new JButton("Cập nhật");
        calculateTotalButton = new JButton("Tính tổng số lượng");

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
        inputPanel.add(updateButton);
        updateButton.addActionListener(this::updateButton);
        inputPanel.add(calculateTotalButton);
        calculateTotalButton.addActionListener(this::calculateTotal);

        add(inputPanel, BorderLayout.SOUTH);
        this.setVisible(true);
        setLocationRelativeTo(null);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        for (int i = 0; i < tableModelVN.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
        // đối tượng lắng nghe thanhtien
        DocumentListener documentListener = new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                thanhTien();
                ;
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                // thanhTien();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                // thanhTien();
            }
        };

        quoctichComboBox.addActionListener(e -> {
            String selectedQuocTich = (String) quoctichComboBox.getSelectedItem();
            if ("Việt Nam".equals(selectedQuocTich)) {
                // Nếu là khách hàng Việt Nam, thêm DocumentListener vào dinhmucTextField
                dinhmucTextField.getDocument().addDocumentListener(documentListener);
            } else {
                // Nếu là khách hàng Nước Ngoài, thêm DocumentListener vào donGiaTextField
                donGiaTextField.getDocument().addDocumentListener(documentListener);
            }
        });

        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int row = table.getSelectedRow();
                if (row >= 0) {
                    if ("Việt Nam".equals(quoctichComboBox.getSelectedItem())) {
                        // Lấy thông tin từ hóa đơn Việt Nam và gán vào các textfield tương ứng
                        idTextField.setText(table.getValueAt(row, 0).toString());
                        hoTenTextField.setText(table.getValueAt(row, 1).toString());
                        ngayRaHoaDonTextField.setText(table.getValueAt(row, 2).toString());
                        soLuongTextField.setText(table.getValueAt(row, 3).toString());
                        switch (table.getValueAt(row, 4).toString()) {
                            case "SINH_HOAT": {
                                doiTuongKHComboBox.setSelectedIndex(1);
                            }
                                break;
                            case "KINH_DOANH": {
                                doiTuongKHComboBox.setSelectedIndex(2);
                            }
                                break;
                            case "SAN_XUAT": {
                                doiTuongKHComboBox.setSelectedIndex(3);
                            }
                        }
                        donGiaTextField.setText(table.getValueAt(row, 5).toString());
                        dinhmucTextField.setText(table.getValueAt(row, 6).toString());
                        // Để gán thông tin thanh toán:
                        thanhTienTextField.setText(table.getValueAt(row, 7).toString());
                    } else if ("Nước Ngoài".equals(quoctichComboBox.getSelectedItem())) {
                        // Lấy thông tin từ hóa đơn Nước Ngoài và gán vào các textfield tương ứng
                        idTextField.setText(table.getValueAt(row, 0).toString());
                        hoTenTextField.setText(table.getValueAt(row, 1).toString());
                        ngayRaHoaDonTextField.setText(table.getValueAt(row, 3).toString());
                        soLuongTextField.setText(table.getValueAt(row, 4).toString());
                        quocTichTextField.setText(table.getValueAt(row, 2).toString());
                        donGiaTextField.setText(table.getValueAt(row, 5).toString());

                        // Để gán thông tin thanh toán:
                        thanhTienTextField.setText(table.getValueAt(row, 6).toString());
                    }
                }
            }
        });

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

    public void findByID(ActionEvent e) {
        JOptionPane.showInputDialog(this, "Nhập ID", "ID");
    }

    public void test() {
        hoaDonTienDienVN = getHoaDonTienDienVN();
        hoaDonTienDienVN.fromvalue(hoaDonTienDienVN.getDoiTuong());
    }

    public void thanhTien() {
        if ("Việt Nam".equals(quoctichComboBox.getSelectedItem())) {
            // Nếu là khách hàng Việt Nam, tính tổng số tiền cho Việt Nam
            hoaDonTienDienVN.setSoLuong(Double.parseDouble(soLuongTextField.getText()));
            hoaDonTienDienVN.setDonGia(Double.parseDouble(donGiaTextField.getText()));
            hoaDonTienDienVN.setDinhMuc(Double.parseDouble(dinhmucTextField.getText()));
            Command thanhTienVNcommand = new ThanhTienVN(getHoaDonTienDien(), getHoaDonTienDienNN(),
                    getHoaDonTienDienVN(), getHoaDonTienDienChucNang());
            hoaDonTienDienController.execute(thanhTienVNcommand);
            String thanhTienStr = String.valueOf(getHoaDonTienDienVN().thanhTien());
            if (!thanhTienStr.isEmpty()) {
                thanhTienTextField.setText(thanhTienStr);
            }
        }

        else {
            // Nếu là khách hàng Nước Ngoài, tính tổng số tiền cho Nước Ngoài

            hoaDonTienDienNN.setSoLuong(Double.parseDouble(soLuongTextField.getText()));
            hoaDonTienDienNN.setDonGia(Double.parseDouble(donGiaTextField.getText()));
            Command thanhTienNNcommand = new ThanhTienNN(getHoaDonTienDien(), getHoaDonTienDienNN(),
                    getHoaDonTienDienVN(), getHoaDonTienDienChucNang());
            hoaDonTienDienController.execute(thanhTienNNcommand);
            String thanhTienStr = String.valueOf(getHoaDonTienDienNN().thanhTien());
            if (!thanhTienStr.isEmpty()) {
                thanhTienTextField.setText(thanhTienStr);
            }
        }

    }

    public void addHD(ActionEvent e) {
        if ("Việt Nam".equals(quoctichComboBox.getSelectedItem())) {
            if (isValidInputVN()) {
                setHoaDonVN();
                Command addHoaDonVNcommand = new AddHoaDonVN(getHoaDonTienDien(), getHoaDonTienDienNN(),
                        getHoaDonTienDienVN(), getHoaDonTienDienChucNang());
                hoaDonTienDienController.execute(addHoaDonVNcommand);
                clearFields();
            }
        } else {
            if (isValidInputNN()) {
                setHoaDonNN();
                Command addHoaDonNNcommand = new AddHoaDonNN(getHoaDonTienDien(), getHoaDonTienDienNN(),
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
                Command updateHoaDonVNcommand = new UpdateVN(getHoaDonTienDien(), getHoaDonTienDienNN(),
                        getHoaDonTienDienVN(), getHoaDonTienDienChucNang());
                hoaDonTienDienController.execute(updateHoaDonVNcommand);
                clearFields();
            }
        } else {
            if (isValidInputNN()) {
                setHoaDonNN();
                Command updateHoaDonNNcommand = new UpdateNN(getHoaDonTienDien(), getHoaDonTienDienNN(),
                        getHoaDonTienDienVN(), getHoaDonTienDienChucNang());
                hoaDonTienDienController.execute(updateHoaDonNNcommand);
                clearFields();
            }
            JOptionPane.showMessageDialog(this, "Lưu thành công");
        }
        hoaDonTienDienVN.notifySubcriber();
        hoaDonTienDienNN.notifySubcriber();
    }

    public void updateButton(ActionEvent e) {
        hoaDonTienDienVN.notifySubcriber();
        hoaDonTienDienNN.notifySubcriber();
    }

    public void deleteHD(ActionEvent e) {
        if ("Việt Nam".equals(quoctichComboBox.getSelectedItem().toString())) {
            hoaDonTienDienVN.setIdKh(Integer.parseInt(idTextField.getText()));
            Command deletecommand = new DeleteVN(getHoaDonTienDien(), getHoaDonTienDienNN(), getHoaDonTienDienVN(),
                    getHoaDonTienDienChucNang());
            hoaDonTienDienController.execute(deletecommand);
            clearFields();
            JOptionPane.showMessageDialog(this, "Xóa thành công");
            hoaDonTienDienVN.notifySubcriber();
            hoaDonTienDienNN.notifySubcriber();
        } else {
             hoaDonTienDienNN.setIdKh(Integer.parseInt(idTextField.getText()));
            Command deletecommand = new DeleteNN(getHoaDonTienDien(), getHoaDonTienDienNN(), getHoaDonTienDienVN(),
                    getHoaDonTienDienChucNang());
            hoaDonTienDienController.execute(deletecommand);
            clearFields();
            JOptionPane.showMessageDialog(this, "Xóa thành công");
            hoaDonTienDienVN.notifySubcriber();
            hoaDonTienDienNN.notifySubcriber();
        }
    }

    private void chooseVn() {
        table.setModel(tableModelVN);
        quocTichTextField.setEditable(false);
        dinhmucTextField.setEditable(true);
        doiTuongKHComboBox.setEnabled(true);
        quocTichTextField.setText("");
    }

    private void chooseNN() {
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        table.setModel(tableModelNN);
        quocTichTextField.setEditable(true);
        dinhmucTextField.setEditable(false);
        doiTuongKHComboBox.setEnabled(false);
        doiTuongKHComboBox.setSelectedItem("");
        for (int i = 0; i < tableModelNN.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
    }

    private void setHoaDonVN() {
        hoaDonTienDienVN.setIdKh(Integer.parseInt(idTextField.getText()));
        hoaDonTienDienVN.setHoTen(hoTenTextField.getText());
        hoaDonTienDienVN.setSoLuong(Double.parseDouble(soLuongTextField.getText()));
        hoaDonTienDienVN.setDinhMuc(Double.parseDouble(dinhmucTextField.getText()));
        // Lấy giá trị ngày hoạt động từ trường nhập liệu và chuyển đổi sang định dạng
        // Date
        String ngayHoatDongStr = ngayRaHoaDonTextField.getText();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date ngayHoatDong = dateFormat.parse(ngayHoatDongStr);
            hoaDonTienDienVN.setNgayHD(ngayHoatDong);
        } catch (ParseException e) {
            e.printStackTrace();
            // Xử lý nếu có lỗi định dạng ngày
        }

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
        // Lấy giá trị ngày hoạt động từ trường nhập liệu và chuyển đổi sang định dạng
        // Date
        String ngayHoatDongStr = ngayRaHoaDonTextField.getText();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date ngayHoatDong = dateFormat.parse(ngayHoatDongStr);
            hoaDonTienDienNN.setNgayHD(ngayHoatDong);
        } catch (ParseException e) {
            e.printStackTrace();
            // Xử lý nếu có lỗi định dạng ngày
        }
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

            // Kiểm tra các điều kiện hợp le
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
        quocTichTextField.setText("");
        doiTuongKHComboBox.setSelectedIndex(0);
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
