package Domain.Command;

import Domain.Model.HoaDonTienDienNN;

public class ThanhTienNN extends Command {

    public ThanhTienNN(HoaDonTienDienNN hoaDonTienDienNN) {
        this.hoaDonTienDienNN = hoaDonTienDienNN;
    }

    @Override
    public void execute() {
        hoaDonTienDienNN.thanhTien();
    }
}