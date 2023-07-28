package src.Presentation;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import src.Domain.*;
import src.Domain.Model.HoaDonTienDienNN;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class HoaDonTienDienGUI extends JFrame {

    private DefaultTableModel tableModel;
    private JTable table;
    private JButton addButton;
    private JButton editButton;
    private JButton deleteButton;
    private JButton findButton;
    private JButton saveButton;
    private JRadioButton VNButton;
    private JRadioButton NNButton;

    private JTextField idTextField;
    private JTextField hoTenTextField;
    private JTextField ngayRaHoaDonTextField;
    private JTextField donGiaTextField;
    private JTextField dinhmucTextField;
    private JTextField doiTuongTextField;
    private JTextField soLuongTextField;
    private JTextField thanhTienTextField;
    private JTextField quocTichTextField;
    private JComboBox<String> quoctichComboBox;
    private JComboBox<String> doiTuongKHComboBox;

    public HoaDonTienDienGUI() {
     

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
        JPanel inputPanel = new JPanel(new GridLayout(14, 4));

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
        doiTuongTextField = new JTextField();
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
            doiTuongTextField.setEditable(true);
        } else {
            quocTichTextField.setEditable(true);
            dinhmucTextField.setEditable(false);
            doiTuongTextField.setEditable(false);
            if (soLuongTextField.getText() != null && donGiaTextField.getText() != null) {
                HoaDonTienDienNN hoaDonTienDienNN = new HoaDonTienDienNN();
                thanhTienTextField.setText(hoaDonTienDienNN.toString());
            }

        }

    }

    private void clearFields() {
        idTextField.setText("");
        hoTenTextField.setText("");
        ngayRaHoaDonTextField.setText("");
        soLuongTextField.setText("");
        doiTuongTextField.setText("");
        donGiaTextField.setText("");
        dinhmucTextField.setText("");
        thanhTienTextField.setText("");
    }

}
