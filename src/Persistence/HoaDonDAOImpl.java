package Persistence;


import java.util.List;
import Domain.Model.HoaDonTienDien;

public class HoaDonDAOImpl implements HoaDonDAO {

    private HoaDonGateway hoaDonGateway;

    public HoaDonDAOImpl(HoaDonGateway hoaDonGateway) {
        this.hoaDonGateway = hoaDonGateway;
    }

    @Override
    public void addHoaDonTienDien(HoaDonTienDien hoadon) {

        hoaDonGateway.addHoaDonTienDien(hoadon);
    }

    @Override
    public List<HoaDonTienDien> getAllsHoaDon(String quocTich) {

        return hoaDonGateway.getAllsHoaDon(quocTich);
    }


    @Override
    public List<HoaDonTienDien> getHoaDonByTen(String hoTen) {

        return hoaDonGateway.getHoaDonByTen(hoTen);
    }

    @Override
    public void updateHoaDonTienDien(HoaDonTienDien hoadon) {

        hoaDonGateway.updateHoaDonTienDien(hoadon);
    }

    @Override
    public void delete(int id) {

        hoaDonGateway.delete(id);
    }

}
