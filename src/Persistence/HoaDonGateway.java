package Persistence;

import java.util.List;

import Domain.Model.HoaDonTienDien;

public interface HoaDonGateway {
    public void add(HoaDonTienDien hoadon);
    public void update(HoaDonTienDien hoadon);
    public void delete(HoaDonTienDien hoadon);   
    HoaDonTienDien getHoaDonByMa(int ma);
    List<HoaDonTienDien> getAllsHoaDon();
}
