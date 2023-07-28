

import javax.swing.SwingUtilities;

import Presentation.HoaDonTienDienView;

public class Boostrap {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new HoaDonTienDienView().setVisible(true);
            }
        });
    }

    
}