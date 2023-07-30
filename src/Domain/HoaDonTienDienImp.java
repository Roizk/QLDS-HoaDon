package Domain;

import java.sql.SQLException;
import java.util.List;

import Domain.Model.HoaDonTienDien;
import Domain.Model.HoaDonTienDienNN;
import Domain.Model.HoaDonTienDienVN;
import Persistence.HoaDonDAO;
import Persistence.HoaDonDAOImpl;
import Persistence.HoaDonJdbcGateway;

public class HoaDonTienDienImp implements HoaDonTienDienChucNang {

    private HoaDonDAO hoaDonDAO;

    public HoaDonTienDienImp() {
        hoaDonDAO = new HoaDonDAOImpl(new HoaDonJdbcGateway());
    }

    @Override
    public void addHoaDonTienDienVN(HoaDonTienDienVN hoaDonTienDienVN) {
        hoaDonDAO.addHoaDonTienDienVN(hoaDonTienDienVN);
    }

    @Override
    public void addHoaDonTienDienNN(HoaDonTienDienNN hoaDonTienDienNN) {
        hoaDonDAO.addHoaDonTienDienNN(hoaDonTienDienNN);
    }

    @Override
    public void deleteHoaDon(HoaDonTienDien hoaDonTienDien) {

    }

    @Override
    public void updateHoaDonTienDienVN(HoaDonTienDienVN hoaDonTienDienVN) {
        hoaDonDAO.updateHoaDonTienDienVN(hoaDonTienDienVN);
    }

    @Override
    public void updateHoaDonTienDienNN(HoaDonTienDienNN hoaDonTienDienNN) {
        hoaDonDAO.updateHoaDonTienDienNN(hoaDonTienDienNN);
    }

    @Override
    public HoaDonTienDienVN getHoaDonTienDienVNById(int idKh) throws SQLException {

        return hoaDonDAO.getHoaDonVNByMa(idKh);
    }

    @Override
    public HoaDonTienDienNN getHoaDonTienDienNNById(int idKh) throws SQLException {

        return hoaDonDAO.getHoaDonNNByMa(idKh);
    }

    @Override
    public List<HoaDonTienDienVN> getAllHoaDonTienDienVN() {
        return hoaDonDAO.getAllsHoaDonVN();

    }

    @Override
    public List<HoaDonTienDienNN> getAllHoaDonTienDienNN() {
        return hoaDonDAO.getAllsHoaDonNN();

    }

}
