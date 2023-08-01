package Domain.Command;



import Domain.HoaDonTienDienChucNang;
import Domain.Model.HoaDonTienDien;
import Domain.Model.HoaDonTienDienNN;
import Domain.Model.HoaDonTienDienVN;

public class DeleteNN extends Command {

    public DeleteNN(HoaDonTienDien hoaDonTienDien, HoaDonTienDienNN hoaDonTienDienNN, HoaDonTienDienVN hoaDonTienDienVN, HoaDonTienDienChucNang hoaDonTienDienChucNang) {
        super(hoaDonTienDien, hoaDonTienDienNN, hoaDonTienDienVN, hoaDonTienDienChucNang);
        this.hoaDonTienDienChucNang = hoaDonTienDienChucNang;
    }

    @Override
    public void execute() {
        delete(hoaDonTienDienChucNang);
    }

    public void delete(HoaDonTienDienChucNang hoaDonTienDiencChucNang) {
        hoaDonTienDiencChucNang.deleteHoaDonNN(hoaDonTienDienNN);
    }
}

    
