package Presentation.Command;

import java.util.List;

import Domain.HoaDonTienDienChucNang;
import Domain.Model.HoaDonTienDien;

import Presentation.HoaDonTienDienController;

public class TotalQuantity extends Command {
    private HoaDonTienDien hoaDonTienDien;
    double totalQuantity = 0.0;

    public TotalQuantity(HoaDonTienDien hoaDonTienDien, 
            HoaDonTienDienChucNang hoaDonTienDienChucNang,
            HoaDonTienDienController hoaDonTienDienController) {
        super(hoaDonTienDien, hoaDonTienDienChucNang, hoaDonTienDienController);
        this.hoaDonTienDienChucNang = hoaDonTienDienChucNang;
        this.hoaDonTienDien = hoaDonTienDien;
    }

    @Override
    public void execute() {
        calTotal();
    }

    public void calTotal() {

        // Calculate total quantity for HoaDonTienDien
        List<HoaDonTienDien> hoaDonList = hoaDonTienDienChucNang.getAllHoaDonTienDien(hoaDonTienDien.getQuocTich());
        for (HoaDonTienDien hoaDon : hoaDonList) {
            totalQuantity += hoaDon.getSoLuong();
        }

        setTotalQuantity(totalQuantity);

    }

    public double getTotalQuantity() {
        return this.totalQuantity;
    }

    public void setTotalQuantity(double totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

}
