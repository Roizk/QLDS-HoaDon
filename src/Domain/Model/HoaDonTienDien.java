package Domain.Model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Domain.Publisher;
import Presentation.Subcriber;

public class HoaDonTienDien implements Publisher  {

    private int idKH;
    private String hoTen;
    private Date ngayHD;
    private double soLuong;
    private double donGia;
    private List<Subcriber> hoaDonTienDiensubcriber;
    private double dinhMuc;
    private String quocTich;
    private enum doiTuongKH {
        SINH_HOAT,
        KINH_DOANH,
        SAN_XUAT
    };
    private doiTuongKH doiTuongkh;

    private int doiTuong;

    public HoaDonTienDien() {
        hoaDonTienDiensubcriber = new ArrayList<>();
    }

    public HoaDonTienDien(int idKh, String hoTen, Date ngayHD, double soLuong, double donGia,double dinhMuc,int doiTuong,String quocTich, double thanhTien) {
        this.idKH = idKh;
        this.hoTen = hoTen;
        this.ngayHD = ngayHD;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.dinhMuc=dinhMuc;
        this.doiTuong=doiTuong;
        this.quocTich = quocTich;
    }

    public double thanhTien() {
        if( "Việt Nam".equals(quocTich))
        {
            if (soLuong <= dinhMuc) {
                return soLuong * donGia;
            } else
                return soLuong * donGia * dinhMuc + (soLuong - dinhMuc) * donGia * 2.5;
        }
        else
        {
            return soLuong * donGia;
        }
    }
    public doiTuongKH fromvalue(int value) {
        switch (value) {
            case 0: {
                doiTuongKH doiTuongkh = doiTuongKH.SINH_HOAT;
                setDoiTuongkh(doiTuongkh);
                return doiTuongkh;
            }
            case 1: {
                doiTuongKH doiTuongkh = doiTuongKH.KINH_DOANH;
                setDoiTuongkh(doiTuongkh);
                return doiTuongkh;
            }
            case 2: {
                doiTuongKH doiTuongkh = doiTuongKH.SAN_XUAT;
                setDoiTuongkh(doiTuongkh);
                return doiTuongkh;
            }
            default:
            {
                doiTuongKH doiTuongkh = null;
                setDoiTuongkh(doiTuongkh);
                return doiTuongkh;
            }
        }
    }
    public double tinhTrungBinhThanhTienKhachNuocNgoai(List<HoaDonTienDien> hoaDonList) {
        double tongThanhTien = 0;
        int soLuongHoaDon = hoaDonList.size();
        for (HoaDonTienDien hoaDon : hoaDonList) {
            tongThanhTien += hoaDon.thanhTien();
        }
        return soLuongHoaDon == 0 ? 0 : tongThanhTien / soLuongHoaDon;
    }
    public double tinhTrungBinhThanhTienKhachNuocNgoai() {
        return 0;
    }

    @Override
    public void attach(Subcriber subscriber) {
        hoaDonTienDiensubcriber.add(subscriber);
    }

    @Override
    public void detach(Subcriber subscriber) {
        hoaDonTienDiensubcriber.remove(subscriber);
    }

    @Override
    public void notifySubcriber() {
        for (Subcriber subcriber : hoaDonTienDiensubcriber) {
            subcriber.update();
        }
    }
    public double getDinhMuc() {
        return this.dinhMuc;
    }

    public void setDinhMuc(double dinhMuc) {
        this.dinhMuc = dinhMuc;
    }
    
    public String getQuocTich() {
        return this.quocTich;
    }

    public void setQuocTich(String qt) {
        this.quocTich = qt;

    }
    public int getIdKh() {
        return this.idKH;
    }

    public void setIdKh(int idKh) {
        this.idKH = idKh;
    }

    public String getHoTen() {
        return this.hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public Date getNgayHD() {
        return this.ngayHD;
    }

    public void setNgayHD(Date ngayHD) {
        this.ngayHD = ngayHD;
    }

    public double getSoLuong() {
        return this.soLuong;
    }

    public void setSoLuong(double soLuong) {
        this.soLuong = soLuong;
    }

    public double getDonGia() {
        return this.donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }
    public doiTuongKH getDoiTuongKH() {
        return doiTuongkh;
    }

    public void setDoiTuongkh(doiTuongKH doiTuongkh) {
        this.doiTuongkh = doiTuongkh;
    }

    public int getDoiTuongKHValue() {
        return doiTuongkh.ordinal();
    }

    public int getDoiTuong() {
        return doiTuong;
    }

    public void setDoiTuong(int doituong)
    {
        this.doiTuong = doituong ; 
    }

}
