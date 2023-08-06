package Persistence;


import java.util.List;

import Domain.Model.*;

public interface HoaDonDAO {

    public void addHoaDonTienDien(HoaDonTienDien hoadon);

    public void updateHoaDonTienDien(HoaDonTienDien hoadon);
    
    public void delete(int id);

    List<HoaDonTienDien> getHoaDonByTen(String hoTen) ;

    List<HoaDonTienDien> getAllsHoaDon(String quocTich);

   
}
