package Persistence;

import java.sql.SQLException;
import java.util.List;

import Domain.Model.HoaDonTienDien;
import Domain.Model.HoaDonTienDienNN;
import Domain.Model.HoaDonTienDienVN;

public class HoaDonDAOImpl implements HoaDonDAO{

    private HoaDonGateway hoaDonGateway;

    

    public HoaDonDAOImpl(HoaDonGateway hoaDonGateway) {
        this.hoaDonGateway= hoaDonGateway;
    }

    @Override
    public void addHoaDonTienDienNN(HoaDonTienDienNN hoadon) {

        hoaDonGateway.addHoaDonTienDienNN(hoadon); 
    }
    @Override
    public void addHoaDonTienDienVN(HoaDonTienDienVN hoadon) {

        hoaDonGateway.addHoaDonTienDienVN(hoadon); 
    }

    @Override
    public List<HoaDonTienDienNN> getAllsHoaDonNN() {
        
        return hoaDonGateway.getAllsHoaDonNN();
    }
    @Override
    public List<HoaDonTienDienVN> getAllsHoaDonVN() {
        
        return hoaDonGateway.getAllsHoaDonVN();
    }

    @Override
    public HoaDonTienDienNN getHoaDonNNById(int id) throws SQLException{

        return hoaDonGateway.getHoaDonNNById(id);
    }
    @Override
    public HoaDonTienDienVN getHoaDonVNById(int id) throws SQLException{

        return hoaDonGateway.getHoaDonVNById(id);
    }

    @Override
    public void updateHoaDonTienDienNN(HoaDonTienDienNN hoadon) {

        hoaDonGateway.updateHoaDonTienDienNN(hoadon);       
    }
    @Override
    public void updateHoaDonTienDienVN(HoaDonTienDienVN hoadon) {

        hoaDonGateway.updateHoaDonTienDienVN(hoadon);       
    }
    
    @Override
    public void delete(int id){

        hoaDonGateway.delete(id);
    }

}
    


