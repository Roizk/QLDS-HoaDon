package Persistence;

import java.util.List;

import Domain.Model.HoaDonTienDien;
import Domain.Model.HoaDonTienDienNN;
import Domain.Model.HoaDonTienDienVN;

public interface HoaDonGateway {
	public void addHoaDonTienDienNN(HoaDonTienDienNN hoadon);
    public void addHoaDonTienDienVN(HoaDonTienDienVN hoadon);
    public void updateHoaDonTienDienNN(HoaDonTienDienNN hoadon);
    public void updateHoaDonTienDienVN(HoaDonTienDienVN hoadon);
    public void delete(int ma);   
    HoaDonTienDienNN getHoaDonNNByMa(int ma);
    HoaDonTienDienVN getHoaDonVNByMa(int ma);
    List<HoaDonTienDienNN> getAllsHoaDonNN();
    List<HoaDonTienDienVN> getAllsHoaDonVN();
}
