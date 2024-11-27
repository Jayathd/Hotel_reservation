package Feedpack;

import java.util.*;
import java.sql.*;

public class FeedDao {

	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tour", "root", "");
		} catch (Exception e) {
			System.out.println(e);
		}
		return con;
	}

	public static int save(Feed e) {
		int status = 0;
		try {
			Connection con = FeedDao.getConnection();
			PreparedStatement ps = con
					.prepareStatement("insert into feedback(name,email,phonenumber,message) values (?,?,?,?)");
			ps.setString(1, e.getName());
			ps.setString(2, e.getEmail());
			ps.setString(3, e.getPhonenumber());
			ps.setString(4, e.getMessage());

			status = ps.executeUpdate();

			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return status;
	}

	public static int update(Feed e) {
		int status = 0;
		try {
			Connection con = FeedDao.getConnection();
			PreparedStatement ps = con
					.prepareStatement("update feedback set name=?,email=?,phonenumber=?,message=? where id=?");
			ps.setString(1, e.getName());
			ps.setString(2, e.getEmail());
			ps.setString(3, e.getPhonenumber());
			ps.setString(4, e.getMessage());
			ps.setInt(5, e.getId());

			status = ps.executeUpdate();

			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return status;
	}

	public static int delete(int id) {
		int status = 0;
		try {
			Connection con = FeedDao.getConnection();
			PreparedStatement ps = con.prepareStatement("delete from feedback where id=?");
			ps.setInt(1, id);
			status = ps.executeUpdate();

			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return status;
	}

	public static Feed getEmployeeById(int id) {
		Feed e = new Feed();

		try {
			Connection con = FeedDao.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from feedback where id=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setEmail(rs.getString(3));
				e.setPhonenumber(rs.getString(4));
				e.setMessage(rs.getString(5));

			}
			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return e;
	}

	public static List<Feed> getAllEmployees() {
		List<Feed> list = new ArrayList<Feed>();

		try {
			Connection con = FeedDao.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from feedback");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Feed e = new Feed();
				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setEmail(rs.getString(3));
				e.setPhonenumber(rs.getString(4));
				e.setMessage(rs.getString(5));

				list.add(e);
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
}
