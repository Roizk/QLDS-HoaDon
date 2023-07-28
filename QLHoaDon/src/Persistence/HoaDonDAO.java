package QLHoaDon.src.Persistence;

public interface HoaDonDAO {
    public void add(HoaDon hoadon);
    public void update(HoaDon hoadon);
    HoaDon getHoaDonByma(int ma); 
    List<HoaDon> getAllsHoaDon();
}
