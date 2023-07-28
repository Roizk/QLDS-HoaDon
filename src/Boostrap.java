

import javax.swing.SwingUtilities;

import Presentation.HoaDonTienDienGUI;

public class Boostrap {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new HoaDonTienDienGUI().setVisible(true);
            }
        });
    }

    
}