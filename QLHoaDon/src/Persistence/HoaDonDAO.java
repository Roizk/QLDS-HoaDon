package QLHoaDon.src.Persistence;
import java.util.List;

import Domain.*;
public interface HoaDonDAO {
    public void add(HoaDon hoadon);
    public void update(HoaDon hoadon);
    public void delete(int ma);
    HoaDon getHoaDonByma(int ma); 
    List<HoaDon> getAllsHoaDon();
}
