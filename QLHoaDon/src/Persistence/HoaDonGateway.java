package QLHoaDon.src.Persistence;

public interface HoaDonGateway {
    public void add();
    public void update();
    public void delete();   
    public void getHoaDonByMa(int ma);
    List<HoaDon> getAllsHoaDon();
}
