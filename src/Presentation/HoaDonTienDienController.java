package Presentation;


import Domain.Command.Command;

public class HoaDonTienDienController {
    
    private HoaDonTienDienView hoaDonTienDienView;

    public HoaDonTienDienController() {
    }

    public HoaDonTienDienController(HoaDonTienDienView viewRemote) {
        this.hoaDonTienDienView = viewRemote;
    }

    public void execute(Command command) {
        command.execute();
    }

}
