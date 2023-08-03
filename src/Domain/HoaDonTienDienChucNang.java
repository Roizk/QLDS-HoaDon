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

    void deleteHoaDonVN(HoaDonTienDienVN hoaDonTienDienVN);
    void deleteHoaDonNN(HoaDonTienDienNN hoaDonTienDienNN);

    HoaDonTienDien getHoaDonTienDienVNById(int idKh) throws SQLException;

    HoaDonTienDien getHoaDonTienDienNNById(int idKh) throws SQLException;

    List<HoaDonTienDienVN> getAllHoaDonTienDienVN();

    List<HoaDonTienDienNN> getAllHoaDonTienDienNN();

    double tinhTrungBinhThanhTienKhachNuocNgoai(HoaDonTienDienNN hoaDonTienDienNN);

}
