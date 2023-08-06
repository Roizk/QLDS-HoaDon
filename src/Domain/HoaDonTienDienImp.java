package Domain;


import java.util.List;

import Domain.Model.HoaDonTienDien;

import Persistence.HoaDonDAO;

public class HoaDonTienDienImp implements HoaDonTienDienChucNang {

    private HoaDonDAO hoaDonDAO;

    public HoaDonTienDienImp(HoaDonDAO hoaDonDAO) {
        this.hoaDonDAO = hoaDonDAO;
    }

    @Override
    public void addHoaDonTienDien(HoaDonTienDien hoaDonTienDien) {
        hoaDonDAO.addHoaDonTienDien(hoaDonTienDien);
    }


    @Override
    public void deleteHoaDon(HoaDonTienDien hoaDonTienDien) {
        hoaDonDAO.delete(hoaDonTienDien.getIdKh());
    }



    @Override
    public void updateHoaDonTienDien(HoaDonTienDien hoaDonTienDien) {
        hoaDonDAO.updateHoaDonTienDien(hoaDonTienDien);
    }

    @Override
    public List<HoaDonTienDien> getHoaDonTienDienByTen(String ten){

        return hoaDonDAO.getHoaDonByTen(ten);
    }
    @Override
    public List<HoaDonTienDien> getAllHoaDonTienDien(String quocTich) {
        return hoaDonDAO.getAllsHoaDon(quocTich);

    }

    

   
}
