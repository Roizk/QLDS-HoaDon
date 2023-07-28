package Presentation;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import Domain.*;
import Domain.Model.HoaDonTienDienNN;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

public class HoaDonTienDienView extends JFrame {

    private HoaDonTienDienController hoaDonTienDienController;

    private DefaultTableModel tableModel;
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

        hoaDonTienDienController = new HoaDonTienDienController();
        // Set up JFrame
        setTitle("Hóa đơn tiền điện");
        setSize(1200, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create JTable to display student list
        tableModel = new DefaultTableModel();
        tableModel.addColumn("Id khách hàng ");
        tableModel.addColumn("Họ tên ");
        tableModel.addColumn("quốc tịch nước ngoài");
        tableModel.addColumn("Ngày ra hóa đơn ");
        tableModel.addColumn("Số lượng ");
        tableModel.addColumn("Đối tượng ");
        tableModel.addColumn("Đơn giá");
        tableModel.addColumn("Định mức ");
        tableModel.addColumn("Thành tiền ");
        table = new JTable(tableModel);

        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        // Create JPanel for student details input and buttons
        JPanel inputPanel = new JPanel(new GridLayout(14, 2));

        quoctichComboBox = new JComboBox<>();
        doiTuongKHComboBox = new JComboBox<>();

        quoctichComboBox.addItem("");
        quoctichComboBox.addItem("Việt Nam");
        quoctichComboBox.addItem("Nước Ngoài");
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

        // new GridLayout(7, 2)
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
        quoctichComboBox.addActionListener(e -> check(e));
        setLocationRelativeTo(null);

    }

    public void check(ActionEvent e) {
        if (quoctichComboBox.getSelectedItem() == "Việt Nam") {
            quocTichTextField.setEditable(false);
            dinhmucTextField.setEditable(true);
            doiTuongKHComboBox.setEditable(true);
        } else {
            quocTichTextField.setEditable(true);
            dinhmucTextField.setEditable(false);
            doiTuongKHComboBox.setEditable(false);

            if (soLuongTextField.getText() != null && donGiaTextField.getText() != null) {
                HoaDonTienDienNN hoaDonTienDienNN = new HoaDonTienDienNN();
                thanhTienTextField.setText(hoaDonTienDienNN.toString());
            }

        }

    }

    public void addHD(ActionEvent e) {
        Add addcommand = new Add();
        hoaDonTienDienController.execute(addcommand);
    }

    public void updateHD(ActionEvent e) {
        Update updatecommand = new Update();
        hoaDonTienDienController.execute(updatecommand);
    }

    public void deleteHD(ActionEvent e) {
        Delete deletecommand = new Delete();
        hoaDonTienDienController.execute(deletecommand);
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

}
