package QLHoaDon.src.Persistence;

public interface HoaDonGateway {
    public void add(HoaDon hoadon);
    public void update(HoaDon hoadon);
    public void delete(HoaDon hoadon);   
    Hoadon getHoaDonByMa(int ma);
    List<HoaDon> getAllsHoaDon();
}
