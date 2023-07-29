package Persistence;

import java.sql.SQLException;
import java.util.List;

import Domain.Model.*;


public interface HoaDonDAO {
    public void addHoaDonTienDienNN(HoaDonTienDienNN hoadon);
    public void addHoaDonTienDienVN(HoaDonTienDienVN hoadon);
    public void updateHoaDonTienDienNN(HoaDonTienDienNN hoadon);
    public void updateHoaDonTienDienVN(HoaDonTienDienVN hoadon);
    public void delete(int ma);
    HoaDonTienDienNN getHoaDonNNByMa(int ma) throws SQLException;
    HoaDonTienDienVN getHoaDonVNByMa(int ma) throws SQLException;
    List<HoaDonTienDienNN> getAllsHoaDonNN();
    List<HoaDonTienDienVN> getAllsHoaDonVN();
}
