package Presentation;

import java.util.List;

import Domain.Command.Command;
import Domain.Model.HoaDonTienDienNN;
import Domain.Model.HoaDonTienDienVN;
import Persistence.HoaDonJdbcGateway;

public class HoaDonTienDienController {
    //private HoaDonJdbcGateway hoaDonJdbcGateway = new HoaDonJdbcGateway();
    private HoaDonTienDienView hoaDonTienDienView;

    public HoaDonTienDienController() {
    }

    public HoaDonTienDienController(HoaDonTienDienView viewRemote) {
        this.hoaDonTienDienView = viewRemote;
    }

    public void execute(Command command) {
        command.execute();
    }
    // public List<HoaDonTienDienVN> getAllsHoaDonVN() {
    //     return hoaDonJdbcGateway.getAllsHoaDonVN();
    // }

    // public List<HoaDonTienDienNN> getAllsHoaDonNN() {
    //     return hoaDonJdbcGateway.getAllsHoaDonNN();
    // }

}
