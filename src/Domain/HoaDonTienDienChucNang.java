package Domain;

import java.util.List;

import Domain.Model.HoaDonTienDien;


public interface HoaDonTienDienChucNang {

    void addHoaDonTienDien(HoaDonTienDien hoaDonTienDien);

    void updateHoaDonTienDien(HoaDonTienDien hoaDonTienDien);

    void deleteHoaDon(HoaDonTienDien hoaDonTienDien);

    List<HoaDonTienDien> getHoaDonTienDienByTen(String ten);

    List<HoaDonTienDien> getAllHoaDonTienDien(String quocTich);

}
