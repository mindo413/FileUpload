package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import dao.face.FileDao;
import dbutil.DBConn;
import dto.UploadFile;

public class FileDaoImpl implements FileDao {

	private Connection conn = null; // DB연결 객체
	private PreparedStatement ps = null; // SQL 수행 객체
	private ResultSet rs = null; // SQL 수행 결과 객체

	@Override
	public void insert(UploadFile uploadFile) {

		conn = DBConn.getConnection(); // DB연결

		// SQL 쿼리
		String sql = "";
		sql += "INSERT INTO uploadfile(fileno, originname, storedname)";
		sql += " VALUES(uploadfile_seq.nextval, ?, ?)";

		try {
			ps = conn.prepareStatement(sql); // SQL 수행 객체

			// 쿼리 채우기
			ps.setString(1, uploadFile.getOriginname());
			ps.setString(2, uploadFile.getStoredname());

			ps.executeUpdate(); // SQL 실행

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {

				if (ps != null)
					ps.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public List<UploadFile> filelist() {

		conn = DBConn.getConnection(); // DB연결

		// 수행할 SQL 쿼리
		String sql = "";
		sql += "SELECT fileno, originname, storedname FROM uploadfile";
		sql += " ORDER BY fileno";

		// 수행결과를 담을 리스트
		List list = new ArrayList();

		try {
			ps = conn.prepareStatement(sql); // 수행객체 얻기
			rs = ps.executeQuery(); // SQL 수행결과 얻기

			// SQL 수행결과 처리
			while (rs.next()) {
				UploadFile uploadfile = new UploadFile(); // 각 행을 처리할 DTO

				uploadfile.setFileno(rs.getInt("fileno"));
				uploadfile.setOriginname(rs.getString("originname"));
				uploadfile.setStoredname(rs.getString("storedname"));

				list.add(uploadfile);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

}
