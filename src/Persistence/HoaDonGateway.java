package Persistence;


import java.util.List;

import Domain.Model.HoaDonTienDien;

public interface HoaDonGateway {

    public void addHoaDonTienDien(HoaDonTienDien hoadon);

    public void updateHoaDonTienDien(HoaDonTienDien hoadon);

    public void delete(int id);

    List<HoaDonTienDien> getHoaDonByTen(String hoTen);

    List<HoaDonTienDien> getAllsHoaDon(String quocTich);

   
}
