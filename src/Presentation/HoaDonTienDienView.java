package Presentation;

import java.awt.BorderLayout;

import java.awt.GridLayout;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import javax.swing.event.DocumentEvent;

import Domain.HoaDonTienDienChucNang;
import Domain.Model.HoaDonTienDien;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class HoaDonTienDienView extends JFrame implements Subcriber {

    private HoaDonTienDienController hoaDonTienDienController;
    private HoaDonTienDienChucNang hoaDonTienDienChucNang;
    private HoaDonTienDien hoaDonTienDien;

    private DefaultTableModel tableModelVN;
    private DefaultTableModel tableModelNN;
    JTable table;
    private JButton addButton;
    private JButton editButton;
    private JButton deleteButton;
    private JButton findButton;
    private JButton updateButton;
    private JButton calculateTotalButton;
    private JButton tinhTrungBinhButton;

    private JTextField idTextField;
    private JTextField hoTenTextField;
    private JTextField ngayRaHoaDonTextField;
    private JTextField donGiaTextField;
    private JTextField dinhmucTextField;
    private JTextField soLuongTextField;
    private JTextField thanhTienTextField;
    private JTextField quocTichTextField;
    private JTextField timKiemTextField;
    private JComboBox<String> quoctichComboBox;
    private JComboBox<String> doiTuongKHComboBox;

    public HoaDonTienDienView() {

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
        JPanel inputPanel = new JPanel(new GridLayout(16, 2));

        quoctichComboBox = new JComboBox<>();
        doiTuongKHComboBox = new JComboBox<>();

        // add item Quoctich combobox
        quoctichComboBox.addItem("");
        quoctichComboBox.addItem("Việt Nam");
        quoctichComboBox.addItem("Nước Ngoài");
        quoctichComboBox.addActionListener(hoaDonTienDienController::KiemtraQT);

        // add item DoituongKH combobox
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
        timKiemTextField = new JTextField();
        addButton = new JButton("Thêm");
        editButton = new JButton("Sửa");
        deleteButton = new JButton("Xóa");
        findButton = new JButton("Tìm kiếm");
        updateButton = new JButton("Làm mới");
        calculateTotalButton = new JButton("Tính tổng số lượng");
        tinhTrungBinhButton = new JButton("Tính trung bình thành tiền");

        inputPanel.add(new JLabel("Tìm kiếm"));
        inputPanel.add(timKiemTextField);
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
        inputPanel.add(tinhTrungBinhButton);
        ;
        thanhTienTextField.setEditable(false);
        inputPanel.add(addButton);
        addButton.addActionListener(hoaDonTienDienController::addHD);
        inputPanel.add(editButton);
        editButton.addActionListener(hoaDonTienDienController::updateHD);
        inputPanel.add(deleteButton);
        deleteButton.addActionListener(hoaDonTienDienController::deleteHD);
        inputPanel.add(findButton);
        findButton.addActionListener(hoaDonTienDienController::findByID);
        inputPanel.add(updateButton);
        updateButton.addActionListener(hoaDonTienDienController::updateButton);
        inputPanel.add(calculateTotalButton);
        doiTuongKHComboBox.addActionListener(hoaDonTienDienController::doiTuongKHCheck);
        calculateTotalButton.addActionListener(hoaDonTienDienController::calculateTotal);
        tinhTrungBinhButton.addActionListener(hoaDonTienDienController::tinhTrungBinhThanhTienKhachNuocNgoai);
        dinhmucTextField.setEditable(false);
        donGiaTextField.setEditable(false);
        idTextField.setEditable(false);

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
                hoaDonTienDienController.thanhTien();
                ;
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                // thanhTien();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                hoaDonTienDienController.thanhTien();
            }
        };

        quoctichComboBox.addActionListener(e -> {
            String selectedQuocTich = (String) quoctichComboBox.getSelectedItem();
            if ("Việt Nam".equals(selectedQuocTich)) {
                // Nếu là khách hàng Việt Nam, thêm DocumentListener vào dinhmucTextField
                soLuongTextField.getDocument().addDocumentListener(documentListener);
            } else {
                // Nếu là khách hàng Nước Ngoài, thêm DocumentListener vào donGiaTextField
                soLuongTextField.getDocument().addDocumentListener(documentListener);
            }
        });

        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int row = table.getSelectedRow();
                if (row >= 0) {
                    String ngayHoatDongStrVN = table.getValueAt(row, 2).toString(); // Assuming the date is in the 3rd
                                                                                    // column (index 2) of the JTable
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    String ngayHoatDongStrNN = table.getValueAt(row, 3).toString(); // Assuming the date is in the 3rd
                                                                                    // column (index 2) of the JTable

                    // Thay đổi định dạng ở đây
                    try {
                        if ("Việt Nam".equals(quoctichComboBox.getSelectedItem())) {
                            Date ngayHoatDongVN = null;
                            if (ngayHoatDongStrVN.matches("\\d{4}-\\d{2}-\\d{2}")) {
                                ngayHoatDongVN = dateFormat.parse(ngayHoatDongStrVN);
                            }
                            hoaDonTienDien.setNgayHD(ngayHoatDongVN);
                            idTextField.setText(table.getValueAt(row, 0).toString());
                            hoTenTextField.setText(table.getValueAt(row, 1).toString());
                            ngayRaHoaDonTextField.setText(table.getValueAt(row, 2).toString());
                            soLuongTextField.setText(table.getValueAt(row, 3).toString());
                            String doiTuongKHStr = table.getValueAt(row, 4).toString();
                                switch (doiTuongKHStr) {
                                    case "SINH_HOAT": {
                                        doiTuongKHComboBox.setSelectedIndex(0);
                                        break;
                                    }
                                    case "KINH_DOANH": {
                                        doiTuongKHComboBox.setSelectedIndex(1);
                                        break;
                                    }
                                    case "SAN_XUAT": {
                                        doiTuongKHComboBox.setSelectedIndex(2);
                                        break;
                                    }
                                    default: {
                                        doiTuongKHComboBox.setSelectedIndex(-1); // Không chọn mục nào
                                        break;
                                    }
                                }
                            donGiaTextField.setText(table.getValueAt(row, 5).toString());
                            dinhmucTextField.setText(table.getValueAt(row, 6).toString());
                            // Để gán thông tin thanh toán:
                            thanhTienTextField.setText(table.getValueAt(row, 7).toString());
                        } else if ("Nước Ngoài".equals(quoctichComboBox.getSelectedItem())) {
                            Date ngayHoatDongNN = null;
                            if (ngayHoatDongStrNN.matches("\\d{4}-\\d{2}-\\d{2}")) {
                                ngayHoatDongNN = dateFormat.parse(ngayHoatDongStrNN);
                            }
                            hoaDonTienDien.setNgayHD(ngayHoatDongNN);
                            idTextField.setText(table.getValueAt(row, 0).toString());
                            hoTenTextField.setText(table.getValueAt(row, 1).toString());
                            quocTichTextField.setText(table.getValueAt(row, 2).toString());
                            ngayRaHoaDonTextField.setText(ngayHoatDongStrNN);

                            soLuongTextField.setText(table.getValueAt(row, 4).toString());

                            donGiaTextField.setText(table.getValueAt(row, 5).toString());
                            // Để gán thông tin thanh toán:
                            thanhTienTextField.setText(table.getValueAt(row, 6).toString());
                        }
                    } catch (ParseException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });

        hoaDonTienDien.attach(this);

    }
    @Override
    public void update() {
        // Lấy dữ liệu từ cơ sở dữ liệu (sử dụng phương thức thích hợp từ
        // HoaDonJdbcGateway)
        List<HoaDonTienDien> hoaDonList = hoaDonTienDienChucNang.getAllHoaDonTienDien(quoctichComboBox.getSelectedItem().toString());
        if("Nước Ngoài".equals(quoctichComboBox.getSelectedItem()))
        {
            tableModelNN.setRowCount(0);
            // Thêm dữ liệu vào bảng
            for (HoaDonTienDien hoaDon : hoaDonList) {
                Object[] rowData = {
                    hoaDon.getIdKh(),
                    hoaDon.getHoTen(),
                    hoaDon.getQuocTich(),
                    hoaDon.getNgayHD(),
                    hoaDon.getSoLuong(),
                    hoaDon.getDonGia(),
                    hoaDon.thanhTien()
                };
                tableModelNN.addRow(rowData);
            }
        }
        else
        {
            tableModelVN.setRowCount(0);
            for (HoaDonTienDien hoaDon : hoaDonList) {
                Object[] rowData = {
                        hoaDon.getIdKh(),
                        hoaDon.getHoTen(),
                        hoaDon.getNgayHD(),
                        hoaDon.getSoLuong(),
                        hoaDon.fromvalue(hoaDon.getDoiTuong()),
                        hoaDon.getDonGia(),
                        hoaDon.getDinhMuc(),
                        hoaDon.thanhTien()
                };
                tableModelVN.addRow(rowData);
            }
        }
    }

    public HoaDonTienDienChucNang getHoaDonTienDienChucNang() {
        return hoaDonTienDienChucNang;
    }

    public HoaDonTienDien getHoaDonTienDien() {
        return hoaDonTienDien;
    }


    public void setHoaDonTienDien(HoaDonTienDien hoaDonTienDien) {
        this.hoaDonTienDien = hoaDonTienDien;
    }

    public void setHoaDonTienDienChucNang(HoaDonTienDienChucNang hoaDonTienDienChucNangImp) {
        this.hoaDonTienDienChucNang = hoaDonTienDienChucNangImp;
    }

    public HoaDonTienDienController getHoaDonTienDienController() {
        return this.hoaDonTienDienController;
    }

    public void setHoaDonTienDienController(HoaDonTienDienController hoaDonTienDienController) {
        this.hoaDonTienDienController = hoaDonTienDienController;
    }

    public DefaultTableModel getTableModelVN() {
        return this.tableModelVN;
    }

    public DefaultTableModel getTableModelNN() {
        return this.tableModelNN;
    }

    public JTable getTable() {
        return this.table;
    }

    public JButton getAddButton() {
        return this.addButton;
    }

    public JButton getEditButton() {
        return this.editButton;
    }

    public JButton getDeleteButton() {
        return this.deleteButton;
    }

    public JButton getFindButton() {
        return this.findButton;
    }

    public JButton getUpdateButton() {
        return this.updateButton;
    }

    public void setUpdateButton(JButton updateButton) {
        this.updateButton = updateButton;
    }

    public JButton getCalculateTotalButton() {
        return this.calculateTotalButton;
    }

    public JTextField getIdTextField() {
        return this.idTextField;
    }

    public void setIdTextField(JTextField idTextField) {
        this.idTextField = idTextField;
    }

    public JTextField getHoTenTextField() {
        return this.hoTenTextField;
    }

    public void setHoTenTextField(JTextField hoTenTextField) {
        this.hoTenTextField = hoTenTextField;
    }

    public JTextField getNgayRaHoaDonTextField() {
        return this.ngayRaHoaDonTextField;
    }

    public void setNgayRaHoaDonTextField(JTextField ngayRaHoaDonTextField) {
        this.ngayRaHoaDonTextField = ngayRaHoaDonTextField;
    }

    public JTextField getDonGiaTextField() {
        return this.donGiaTextField;
    }

    public void setDonGiaTextField(JTextField donGiaTextField) {
        this.donGiaTextField = donGiaTextField;
    }

    public JTextField getDinhmucTextField() {
        return this.dinhmucTextField;
    }

    public void setDinhmucTextField(JTextField dinhmucTextField) {
        this.dinhmucTextField = dinhmucTextField;
    }

    public JTextField getSoLuongTextField() {
        return this.soLuongTextField;
    }

    public void setSoLuongTextField(JTextField soLuongTextField) {
        this.soLuongTextField = soLuongTextField;
    }

    public JTextField getThanhTienTextField() {
        return this.thanhTienTextField;
    }

    public void setThanhTienTextField(JTextField thanhTienTextField) {
        this.thanhTienTextField = thanhTienTextField;
    }

    public JTextField getQuocTichTextField() {
        return this.quocTichTextField;
    }

    public void setQuocTichTextField(JTextField quocTichTextField) {
        this.quocTichTextField = quocTichTextField;
    }

    public void setTimKiemTextField(JTextField timKiemTextField) {
        this.timKiemTextField = timKiemTextField;
    }

    public JTextField getTimKiemTextField() {
        return timKiemTextField;
    }

    public JComboBox<String> getQuoctichComboBox() {
        return this.quoctichComboBox;
    }

    public void setQuoctichComboBox(JComboBox<String> quoctichComboBox) {
        this.quoctichComboBox = quoctichComboBox;
    }

    public JComboBox<String> getDoiTuongKHComboBox() {
        return this.doiTuongKHComboBox;
    }

    public void setDoiTuongKHComboBox(JComboBox<String> doiTuongKHComboBox) {
        this.doiTuongKHComboBox = doiTuongKHComboBox;
    }

}
