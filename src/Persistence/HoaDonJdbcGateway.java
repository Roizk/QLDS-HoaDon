package Persistence;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

import Domain.Model.HoaDonTienDien;
import Domain.Model.HoaDonTienDienNN;
import Domain.Model.HoaDonTienDienVN;
import Persistence.HoaDonGateway;

public class HoaDonJdbcGateway implements HoaDonGateway {
	private Connection connection;

	public HoaDonJdbcGateway() {
		String dbURL = "jdbc:sqlserver://localhost:1433;databaseName=quanlyhoadon;integratedSecurity=true;trustServerCertificate=true";

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			connection = DriverManager.getConnection(dbURL);
			System.out.println("Thanh cong");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void addHoaDonTienDienNN(HoaDonTienDienNN hoaDonTienDienNN) {
		String sqlString = "INSERT INTO HOADON (maKH,hoTen,quocTich,ngayHD,soLuong,donGia,thanhTien) VALUES (?,?,?,?,?,?,?)";
		// 1 2 3 4 5 6 7 1 2 3 4 5 6 7
		try (PreparedStatement statement = connection.prepareStatement(sqlString)) {
			statement.setInt(1, hoaDonTienDienNN.getIdKh());
			statement.setString(2, hoaDonTienDienNN.getHoTen());
			statement.setString(3, hoaDonTienDienNN.getQuocTich());
			java.sql.Date sqlNgayHD = new java.sql.Date(hoaDonTienDienNN.getNgayHD().getTime());
			statement.setDate(4, sqlNgayHD);
			statement.setDouble(5, hoaDonTienDienNN.getSoLuong());
			statement.setDouble(6, hoaDonTienDienNN.getDonGia());
			statement.setDouble(7, hoaDonTienDienNN.thanhTien());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void addHoaDonTienDienVN(HoaDonTienDienVN hoaDonTienDienVN) {
		String sqString = "INSERT INTO HOADON (makH,hoTen,doiTuongKH,ngayHD,soLuong,donGia,dinhMuc,thanhTien) VALUES (?,?,?,?,?,?,?,?)";
		// 1 2 3 4 5 6 7 8 1 2 3 4 5 6 7 8
		try (PreparedStatement statement = connection.prepareStatement(sqString)) {
			statement.setInt(1, hoaDonTienDienVN.getIdKh());
			statement.setString(2, hoaDonTienDienVN.getHoTen());
			statement.setInt(3, hoaDonTienDienVN.getDoiTuong());
			java.sql.Date sqlNgayHD = new java.sql.Date(hoaDonTienDienVN.getNgayHD().getTime());
			statement.setDate(4,sqlNgayHD);
			statement.setDouble(5, hoaDonTienDienVN.getSoLuong());
			statement.setDouble(6, hoaDonTienDienVN.getDonGia());
			statement.setDouble(7, hoaDonTienDienVN.getDinhMuc());
			statement.setDouble(8, hoaDonTienDienVN.thanhTien());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateHoaDonTienDienNN(HoaDonTienDienNN hoaDonTienDienNN) {
		String sqlString = "UPDATE HOADON SET hoTen=?,quocTich=?,ngayHD=?,soLuong=?,donGia=?,thanhTien=? WHERE maKH=?";
		// 1 2 3 4 5 6 7
		try (PreparedStatement statement = connection.prepareStatement(sqlString)) {
			statement.setString(1, hoaDonTienDienNN.getHoTen());
			statement.setString(2, hoaDonTienDienNN.getQuocTich());
			java.sql.Date sqlNgayHD = new java.sql.Date(hoaDonTienDienNN.getNgayHD().getTime());
			statement.setDate(3, sqlNgayHD);
			statement.setDouble(4, hoaDonTienDienNN.getSoLuong());
			statement.setDouble(5, hoaDonTienDienNN.getDonGia());
			statement.setDouble(6, hoaDonTienDienNN.thanhTien());
			statement.setInt(7, hoaDonTienDienNN.getIdKh());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateHoaDonTienDienVN(HoaDonTienDienVN hoaDonTienDienVN) {
		String sqlString = "UPDATE HOADON SET hoTen=?,doiTuongKH=?,ngayHD=?,soLuong=?,donGia=?,dinhMuc=? WHERE maKH=?";
		// 1 2 3 4 5 6 7
		try (PreparedStatement statement = connection.prepareStatement(sqlString)) {
			statement.setString(1, hoaDonTienDienVN.getHoTen());
			statement.setInt(2, hoaDonTienDienVN.getDoiTuong());
			java.sql.Date sqlNgayHD = new java.sql.Date(hoaDonTienDienVN.getNgayHD().getTime());
			statement.setDate(3, sqlNgayHD);
			statement.setDouble(4, hoaDonTienDienVN.getSoLuong());
			statement.setDouble(5, hoaDonTienDienVN.getDonGia());
			statement.setDouble(6, hoaDonTienDienVN.getDinhMuc());
			statement.setInt(7, hoaDonTienDienVN.getIdKh());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int id) {
		String sqlString = "DELETE FROM HOADON WHERE maKH=?";
		try (PreparedStatement statement = connection.prepareStatement(sqlString)) {
			statement.setInt(1, id);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public HoaDonTienDienNN getHoaDonNNById(int id) {
		// TODO Auto-generated method stub
		String sqlString = "SELECT hoTen,quocTich,ngayHD,soLuong,donGia,thanhTien FROM HOADON WHERE maKH=?";
		try (PreparedStatement statement = connection.prepareStatement(sqlString)) {
			statement.setInt(1, id);
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				int maKHInt = resultSet.getInt("maKH");
				String hoTenString = resultSet.getString("hoTen");
				String quocTichString = resultSet.getString("quocTich");
				java.util.Date ngayHDDate = resultSet.getDate("ngayHD");
				double soLuongDouble = resultSet.getDouble("soLuong");
				double donGiaDouble = resultSet.getDouble("donGia");
				double thanhTienDouble = resultSet.getDouble("thanhTien");

				return new HoaDonTienDienNN(maKHInt, hoTenString, ngayHDDate, soLuongDouble, donGiaDouble,
						quocTichString, thanhTienDouble);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public HoaDonTienDienVN getHoaDonVNById(int id) {
		// TODO Auto-generated method stub
		String sqlString = "SELECT * FROM HOADON WHERE maKH=?";
		try (PreparedStatement statement = connection.prepareStatement(sqlString)) {
			statement.setInt(1, id);
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				int maKHInt = resultSet.getInt("maKH");
				String hoTenString = resultSet.getString("hoTen");
				java.util.Date ngayHDDate = resultSet.getDate("ngayHD");
				int doiTuongKHInt = resultSet.getInt("doiTuongKH");
				double soLuongDouble = resultSet.getDouble("soLuong");
				double donGiaDouble = resultSet.getDouble("donGia");
				double dinhMucDouble = resultSet.getDouble("dinhMuc");
				double thanhTienDouble = resultSet.getDouble("thanhTien");

				return new HoaDonTienDienVN(maKHInt, hoTenString, ngayHDDate, doiTuongKHInt, soLuongDouble,
						donGiaDouble, dinhMucDouble, thanhTienDouble);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<HoaDonTienDienNN> getAllsHoaDonNN() {
		List<HoaDonTienDienNN> hoaDonTienDienNNs = new ArrayList<HoaDonTienDienNN>();
		String sqlString = "SELECT * FROM HOADON WHERE quocTich IS NOT NULL";
		try (Statement statement = connection.createStatement()) {
			ResultSet resultSet = statement.executeQuery(sqlString);
			while (resultSet.next()) {
				int maKHInt = resultSet.getInt("maKH");
				String hoTenString = resultSet.getString("hoTen");
				String quocTichString = resultSet.getString("quocTich");
				java.util.Date ngayHDDate = resultSet.getDate("ngayHD");
				double soLuongDouble = resultSet.getDouble("soLuong");
				double donGiaDouble = resultSet.getDouble("donGia");
				double thanhTienDouble = resultSet.getDouble("thanhTien");

				hoaDonTienDienNNs.add(new HoaDonTienDienNN(maKHInt, hoTenString, ngayHDDate, soLuongDouble,
						donGiaDouble, quocTichString, thanhTienDouble));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return hoaDonTienDienNNs;
	}

	@Override
	public List<HoaDonTienDienVN> getAllsHoaDonVN() {
		// TODO Auto-generated method stub
		List<HoaDonTienDienVN> hoaDonTienDienVNs = new ArrayList<HoaDonTienDienVN>();
		String sqlString = "SELECT * FROM HOADON WHERE quocTich IS NULL";
		try (Statement statement = connection.createStatement()) {
			ResultSet resultSet = statement.executeQuery(sqlString);
			while (resultSet.next()) {
				int maKHInt = resultSet.getInt("maKH");
				String hoTenString = resultSet.getString("hoTen");
				int doiTuongKHInt = resultSet.getInt("doiTuongKH");
				java.util.Date ngayHDDate = resultSet.getDate("ngayHD");
				double soLuongDouble = resultSet.getDouble("soLuong");
				double donGiaDouble = resultSet.getDouble("donGia");
				double dinhMucDouble = resultSet.getDouble("dinhMuc");
				double thanhTienDouble = resultSet.getDouble("thanhTien");

				hoaDonTienDienVNs.add(new HoaDonTienDienVN(maKHInt, hoTenString, ngayHDDate, doiTuongKHInt,
						soLuongDouble, donGiaDouble, dinhMucDouble, thanhTienDouble));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return hoaDonTienDienVNs;
	}
}
