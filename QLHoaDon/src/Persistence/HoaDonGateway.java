package QLHoaDon.src.Persistence;
import java.util.List;

import Domain.*;
public interface HoaDonGateway {
    public void add(HoaDon hoadon);
    public void update(HoaDon hoadon);
    public void delete(int ma);   
    HoaDon getHoaDonByMa(int ma);
    List<HoaDon> getAllsHoaDon();
}
