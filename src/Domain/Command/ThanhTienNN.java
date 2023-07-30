package Domain.Command;

import Domain.Model.HoaDonTienDienNN;

public class ThanhTienNN extends Command {
    private HoaDonTienDienNN hoaDonTienDienNN;

    public ThanhTienNN(HoaDonTienDienNN hoaDonTienDienNN) {
        this.hoaDonTienDienNN = hoaDonTienDienNN;
    }

    @Override
    public void execute() {
        hoaDonTienDienNN.thanhTien();
    }
}