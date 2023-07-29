package Presentation;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import Domain.*;
import Domain.Model.HoaDonTienDien;
import Domain.Model.HoaDonTienDienNN;
import Domain.Model.HoaDonTienDienVN;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

public class HoaDonTienDienView extends JFrame implements Subcriber {

    private HoaDonTienDienController hoaDonTienDienController;
    private HoaDonTienDienChucNang hoaDonTienDienChucNang;
    private HoaDonTienDien hoaDonTienDien;
    private HoaDonTienDienVN hoaDonTienDienVN; 

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

        // add item DoituongKH combobox
        doiTuongKHComboBox.addItem("");
        doiTuongKHComboBox.addItem("sinh hoạt");
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
        inputPanel.add(editButton);
        inputPanel.add(deleteButton);
        inputPanel.add(findButton);
        inputPanel.add(saveButton);

        add(inputPanel, BorderLayout.SOUTH);
        quoctichComboBox.addActionListener(this::KiemtraQT);
        // hoaDonTienDien.attach(this);
        setLocationRelativeTo(null);

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

    public void test()
    {
        hoaDonTienDienVN = getHoaDonTienDienVN();
        hoaDonTienDienVN.fromvalue(hoaDonTienDienVN.getDoiTuong());
    }

    @Override
    public void update() {

    }

    public void addHD(ActionEvent e) {
        Add addcommand = new Add(getHoaDonTienDienChucNang());
        hoaDonTienDienController.execute(addcommand);
        clearFields();
    }

    public void updateHD(ActionEvent e) {
        Update updatecommand = new Update(getHoaDonTienDienChucNang());
        hoaDonTienDienController.execute(updatecommand);
    }

    public void deleteHD(ActionEvent e) {
        Delete deletecommand = new Delete(getHoaDonTienDienChucNang());
        hoaDonTienDienController.execute(deletecommand);
        clearFields();
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
    public HoaDonTienDienVN getHoaDonTienDienVN()
    {
        return hoaDonTienDienVN;
    }

}
