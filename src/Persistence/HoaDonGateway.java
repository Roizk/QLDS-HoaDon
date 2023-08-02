package Persistence;

import java.sql.SQLException;
import java.util.List;

import Domain.Model.HoaDonTienDienNN;
import Domain.Model.HoaDonTienDienVN;

public interface HoaDonGateway {
    public void addHoaDonTienDienNN(HoaDonTienDienNN hoadon);

    public void addHoaDonTienDienVN(HoaDonTienDienVN hoadon);

    public void updateHoaDonTienDienNN(HoaDonTienDienNN hoadon);

    public void updateHoaDonTienDienVN(HoaDonTienDienVN hoadon);

    public void delete(int id);

    HoaDonTienDienNN getHoaDonNNById(int id) throws SQLException;

    HoaDonTienDienVN getHoaDonVNById(int id) throws SQLException;

    List<HoaDonTienDienNN> getAllsHoaDonNN();

    List<HoaDonTienDienVN> getAllsHoaDonVN();
}
