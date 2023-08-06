package Presentation.Command;

import java.util.List;

import javax.swing.table.DefaultTableModel;

import Domain.HoaDonTienDienChucNang;
import Domain.Model.HoaDonTienDien;

import Presentation.HoaDonTienDienController;

public class FindByID extends Command {

    private DefaultTableModel table;

    public FindByID(HoaDonTienDien hoaDonTienDien,
            HoaDonTienDienChucNang hoaDonTienDienChucNang,
            HoaDonTienDienController hoaDonTienDienController) {
        super(hoaDonTienDien, hoaDonTienDienChucNang, hoaDonTienDienController);

        this.hoaDonTienDienChucNang = hoaDonTienDienChucNang;
        table = new DefaultTableModel();
        table.addColumn("Id khách hàng ");
        table.addColumn("Họ tên ");
        table.addColumn("quốc tịch nước ngoài");
        table.addColumn("Ngày ra hóa đơn ");
        table.addColumn("Số lượng ");
        table.addColumn("Đối tượng ");
        table.addColumn("Định mức ");
        table.addColumn("Đơn giá");
        table.addColumn("Thành tiền ");
    }

    @Override
    public void execute() {

        List<HoaDonTienDien> danhSachHoaDon = hoaDonTienDienChucNang.getHoaDonTienDienByTen(hoaDonTienDien.getHoTen());
        // Thêm dữ liệu từ danhSachHoaDon vào bảng
        for (HoaDonTienDien hoaDon : danhSachHoaDon) {
            if (hoaDonTienDien.getQuocTich() == "Việt Nam") {
                if (hoaDon.getQuocTich() == null) {
                    Object[] rowData = {
                            hoaDon.getIdKh(),
                            hoaDon.getHoTen(),
                            hoaDon.getQuocTich(),
                            hoaDon.getNgayHD() != null ? hoaDon.getNgayHD().toString() : "",
                            hoaDon.getSoLuong(),
                            hoaDon.fromvalue(hoaDon.getDoiTuong()),
                            hoaDon.getDonGia(),
                            hoaDon.getDinhMuc(),
                            hoaDon.thanhTien()
                    };
                    table.addRow(rowData);
                }
            } else if (hoaDonTienDien.getQuocTich() == "Nước Ngoài") {
                if (hoaDon.getQuocTich() != null) {
                    Object[] rowData = {
                            hoaDon.getIdKh(),
                            hoaDon.getHoTen(),
                            hoaDon.getQuocTich(),
                            hoaDon.getNgayHD() != null ? hoaDon.getNgayHD().toString() : "",
                            hoaDon.getSoLuong(),
                            hoaDon.fromvalue(hoaDon.getDoiTuong()),
                            hoaDon.getDonGia(),
                            hoaDon.getDinhMuc(),
                            hoaDon.thanhTien()
                    };
                    table.addRow(rowData);
                }
            }
        }
        setTable(table);
    }

    public DefaultTableModel getTable() {
        return this.table;
    }

    public void setTable(DefaultTableModel table) {
        this.table = table;
    }

}
