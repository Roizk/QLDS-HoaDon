package Domain;

import java.util.List;

import Domain.Model.HoaDonTienDien;
import Domain.Model.HoaDonTienDienNN;
import Persistence.HoaDonDAO;

public class HoaDonTienDienImp implements HoaDonTienDienChucNang{

    private HoaDonDAO hoaDonDAO;
    
    // public HoaDonTienDienImp()
    // {
    //     hoaDonDAO = new HoaDonDAO() ;
    // }

    @Override
    public void addHoaDon(HoaDonTienDien hoaDonTienDien) {

    }

    @Override
    public void deleteHoaDon(HoaDonTienDien hoaDonTienDien) {

    }

    @Override
    public void updateHoaDon(HoaDonTienDien hoaDonTienDien) {

    }

    @Override
    public HoaDonTienDien getHoaDonTienDienById(int idKh) {
        throw new UnsupportedOperationException("Unimplemented method 'getHoaDonTienDienById'");
    }

    @Override
    public List<HoaDonTienDien> getAllHoaDonTienDien() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllHoaDonTienDien'");
    }

    

}
