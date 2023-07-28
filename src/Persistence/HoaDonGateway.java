package src.Persistence;

import java.util.List;

import src.Domain.Model.HoaDonTienDien;

public interface HoaDonGateway {
    public void add(HoaDonTienDien hoadon);
    public void update(HoaDonTienDien hoadon);
    public void delete(int ma);   
    HoaDonTienDien getHoaDonByMa(int ma);
    List<HoaDonTienDien> getAllsHoaDon();
}
