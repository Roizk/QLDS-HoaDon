package Domain;

import java.sql.SQLException;
import java.util.List;

import Domain.Model.HoaDonTienDien;
import Domain.Model.HoaDonTienDienNN;
import Domain.Model.HoaDonTienDienVN;

public interface HoaDonTienDienChucNang {

    void addHoaDonTienDienNN(HoaDonTienDienNN hoaDonTienDienNN);

    void addHoaDonTienDienVN(HoaDonTienDienVN hoaDonTienDienVN);

    void updateHoaDonTienDienNN(HoaDonTienDienNN hoaDonTienDienNN);

    void updateHoaDonTienDienVN(HoaDonTienDienVN hoaDonTienDienVN);

    void deleteHoaDon(HoaDonTienDien hoaDonTienDien);

    HoaDonTienDien getHoaDonTienDienVNById(int idKh) throws SQLException;

    HoaDonTienDien getHoaDonTienDienNNById(int idKh) throws SQLException;

    List<HoaDonTienDienVN> getAllHoaDonTienDienVN();

    List<HoaDonTienDienNN> getAllHoaDonTienDienNN();

}
