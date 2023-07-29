package Presentation;

import Domain.Command;


public class HoaDonTienDienController {

    private HoaDonTienDienView viewRemote ;
    
    public HoaDonTienDienController(){}
    
    public HoaDonTienDienController(HoaDonTienDienView viewRemote)
    {
        this.viewRemote = viewRemote ; 
    }

    
    
    public void execute(Command command)
    {
        command.execute();
    }

}
