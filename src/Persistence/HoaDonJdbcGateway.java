package Persistence;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Domain.Model.HoaDonTienDien;

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
	public void addHoaDonTienDien(HoaDonTienDien hoaDonTienDien) {
		String sqlString = "INSERT INTO HOADON (hoTen,quocTich,doiTuongKH,dinhMuc,ngayHD,soLuong,donGia,thanhTien) VALUES (?,?,?,?,?,?,?,?)";
		// 1 2 3 4 5 6 7 8
		try (PreparedStatement statement = connection.prepareStatement(sqlString, Statement.RETURN_GENERATED_KEYS)) {
			statement.setString(1, hoaDonTienDien.getHoTen());
			statement.setString(2, hoaDonTienDien.getQuocTich());
			statement.setInt(3, hoaDonTienDien.getDoiTuong());
			statement.setDouble(4, hoaDonTienDien.getDinhMuc());
			java.sql.Date sqlNgayHD = new java.sql.Date(hoaDonTienDien.getNgayHD().getTime());
			statement.setDate(5, sqlNgayHD);
			statement.setDouble(6, hoaDonTienDien.getSoLuong());
			statement.setDouble(7, hoaDonTienDien.getDonGia());
			statement.setDouble(8, hoaDonTienDien.thanhTien());
			statement.executeUpdate();
			ResultSet generatedKeys = statement.getGeneratedKeys();
			if (generatedKeys.next()) {
				int generatedId = generatedKeys.getInt(1);
				hoaDonTienDien.setIdKh(generatedId); // Gán giá trị ID mới cho đối tượng KH
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateHoaDonTienDien(HoaDonTienDien hoaDonTienDien) {

		String sqlString = "UPDATE HOADON SET hoTen=?,quocTich=?,doiTuongKH=?,dinhMuc=?,ngayHD=?,soLuong=?,donGia=?,thanhTien=? WHERE maKH=?";
		// 1 2 3 4 5 6 7 8 9
		try (PreparedStatement statement = connection.prepareStatement(sqlString)) {
			statement.setString(1, hoaDonTienDien.getHoTen());
			statement.setString(2, hoaDonTienDien.getQuocTich());
			statement.setInt(3, hoaDonTienDien.getDoiTuong());
			statement.setDouble(4, hoaDonTienDien.getDinhMuc());
			java.sql.Date sqlNgayHD = new java.sql.Date(hoaDonTienDien.getNgayHD().getTime());
			statement.setDate(5, sqlNgayHD);
			statement.setDouble(6, hoaDonTienDien.getSoLuong());
			statement.setDouble(7, hoaDonTienDien.getDonGia());
			statement.setDouble(8, hoaDonTienDien.thanhTien());
			statement.setInt(9, hoaDonTienDien.getIdKh());
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
	public List<HoaDonTienDien> getHoaDonByTen(String hoTen) {
		List<HoaDonTienDien> resultList = new ArrayList<>();
		// Sử dụng wildcard % trong câu điều kiện LIKE để tìm kiếm theo tên
		String sqlString = "SELECT * FROM HOADON WHERE hoTen LIKE ?";
		try (PreparedStatement statement = connection.prepareStatement(sqlString)) {
			statement.setString(1, "%" + hoTen + "%"); // % đại diện cho bất kỳ ký tự nào
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				int maKHInt = resultSet.getInt("maKH");
				String hoTenString = resultSet.getString("hoTen");
				java.util.Date ngayHDDate = resultSet.getDate("ngayHD");
				double soLuongDouble = resultSet.getDouble("soLuong");
				double donGiaDouble = resultSet.getDouble("donGia");
				double dinhMucDouble = resultSet.getDouble("dinhMuc");
				int doiTuongKHInt = resultSet.getInt("doiTuongKH");
				String quocTichString = resultSet.getString("quocTich");
				double thanhTienDouble = resultSet.getDouble("thanhTien");

				resultList.add(new HoaDonTienDien(maKHInt, hoTenString, ngayHDDate, soLuongDouble,
						donGiaDouble, dinhMucDouble, doiTuongKHInt, quocTichString, thanhTienDouble));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultList;
	}

	@Override
	public List<HoaDonTienDien> getAllsHoaDon(String quocTich) {
		List<HoaDonTienDien> hoaDonTienDien = new ArrayList<>();
		String sqlString;
		if (quocTich == "Việt Nam") {
			sqlString = "SELECT * FROM HOADON WHERE quocTich IS NULL";
		} else {
			sqlString = "SELECT * FROM HOADON WHERE quocTich IS NOT NULL";
		}
		try (PreparedStatement statement = connection.prepareStatement(sqlString)) {

			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				int maKHInt = resultSet.getInt("maKH");
				String hoTenString = resultSet.getString("hoTen");
				java.util.Date ngayHDDate = resultSet.getDate("ngayHD");
				double soLuongDouble = resultSet.getDouble("soLuong");
				double donGiaDouble = resultSet.getDouble("donGia");
				double dinhMucDouble = resultSet.getDouble("dinhMuc");
				int doiTuongKHInt = resultSet.getInt("doiTuongKH");
				String quocTichString = resultSet.getString("quocTich");
				double thanhTienDouble = resultSet.getDouble("thanhTien");

				hoaDonTienDien.add(new HoaDonTienDien(maKHInt, hoTenString, ngayHDDate, soLuongDouble,
						donGiaDouble, dinhMucDouble, doiTuongKHInt, quocTichString, thanhTienDouble));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return hoaDonTienDien;
	}


}
