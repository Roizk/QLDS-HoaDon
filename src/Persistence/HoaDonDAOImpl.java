package Persistence;

import java.util.List;

import Domain.Model.HoaDonTienDien;

public class HoaDonDAOImpl implements HoaDonDAO{

    private HoaDonGateway hoaDonGateway;

    public HoaDonDAOImpl(HoaDonGateway hoaDonGateway) {
        this.hoaDonGateway= hoaDonGateway;
    }

    @Override
    public void add(HoaDonTienDien hoadon) {

        hoaDonGateway.add(hoadon); 
    }

    @Override
    public List<HoaDonTienDien> getAllsHoaDon() {
        
        return hoaDonGateway.getAllsHoaDon();
    }

    @Override
    public HoaDonTienDien getHoaDonByma(int ma) {

        return hoaDonGateway.getHoaDonByMa(ma);
    }

    @Override
    public void update(HoaDonTienDien hoadon) {

        hoaDonGateway.update(hoadon);       
    }
    
    @Override
    public void delete(int ma){

        hoaDonGateway.delete(ma);
    }

}
    


