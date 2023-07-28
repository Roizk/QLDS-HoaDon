package Persistence;

import java.util.List;

import Domain.Model.HoaDonTienDien;

public interface HoaDonDAO {
    public void add(HoaDonTienDien hoadon);
    public void update(HoaDonTienDien hoadon);
    HoaDonTienDien getHoaDonByma(int ma); 
    List<HoaDonTienDien> getAllsHoaDon();
}
