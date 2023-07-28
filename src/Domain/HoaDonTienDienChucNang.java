package Domain;

import java.util.List;

import Domain.Model.HoaDonTienDien;

public interface HoaDonTienDienChucNang {

    void addHoaDon(HoaDonTienDien hoaDonTienDien);

    void deleteHoaDon(HoaDonTienDien hoaDonTienDien);

    void updateHoaDon(HoaDonTienDien hoaDonTienDien);

    HoaDonTienDien getHoaDonTienDienById(int idKh);

    List<HoaDonTienDien> getAllHoaDonTienDien();

}
