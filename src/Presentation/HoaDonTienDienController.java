package Presentation;

import Domain.Command;

public class HoaDonTienDienController {
    
    public void execute(Command command)
    {
        command.execute();
    }

}
