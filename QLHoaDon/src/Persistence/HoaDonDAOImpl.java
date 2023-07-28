package QLHoaDon.src.Persistence;
import java.util.List;


public class HoaDonDAOImpl implements HoaDonDAO{

    private HoaDonGateway hoaDonGateway;

    public HoaDonDAOImpl(HoaDonGateway hoaDonGateway) {
        this.hoaDonGateway= hoaDonGateway;
    }

    @Override
    public void add(HoaDon hoadon) {

        hoaDonGateway.add(hoadon); 
    }

    @Override
    public List<HoaDon> getAllsHoaDon(HoaDon hoadon) {
        
        return hoaDonGateway.getAllsHoaDon(hoadon);
    }

    @Override
    public HoaDon getHoaDonByma(int ma) {

        return hoaDonGateway.getHoaDonByma(ma);
    }

    @Override
    public void update(HoaDon hoadon) {

        hoaDonGateway.update(hoadon);       
    }
    
    @Override
    public void delete(int ma){

        hoaDonGateway.delete(ma);
    }

}
