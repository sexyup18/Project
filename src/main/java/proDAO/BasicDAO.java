package proDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import org.springframework.stereotype.Repository;

import DB.DBConnection;
import vo.BasicVO;

@Repository
public class BasicDAO {
	static Connection cn = DBConnection.getConnection();
	static Statement st;
	static PreparedStatement pst;
	static ResultSet rs;
	String sql;
	
	public BasicVO selectOne(BasicVO vo) {
		sql = "select * from member where studentId=?";
		// Statement 비교
		// => "select * from member where id='"+vo.getId()+"'"
		try {
			pst = cn.prepareStatement(sql);
			pst.setInt(1, vo.getStudentId());
			// select * from member where id='banana' ;
			rs = pst.executeQuery();
			if (rs.next()) {
				vo.setStudentId(rs.getInt(1));
				vo.setName(rs.getString(2));
				vo.setPassword(rs.getString(3));
				vo.setAcaYear(rs.getString(4));
				vo.setBirth(rs.getInt(5));
				vo.setRegNum(rs.getInt(6));
				vo.setGender(rs.getString(7));
				vo.setEmail(rs.getString(8));
				vo.setNation(rs.getString(9));
				vo.setAddress(rs.getString(10));
				vo.setPhone(rs.getInt(11));
				vo.setImage(rs.getString(12));
				vo.setMainMajor( rs.getString(13));
				vo.setDoubleMajor(rs.getString(14));
			} else {
				vo = null;
			}
		} catch (Exception e) {
			System.out.println("** selectOne Exception=>" + e.toString());
			vo = null;
		}
		return vo;
	} // selectOne
	
	
	public int insert(BasicVO vo) {
		sql = "insert into member values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			pst = cn.prepareStatement(sql);
			pst.setInt(1, vo.getStudentId());
			pst.setString(2, vo.getName());
			pst.setString(3, vo.getPassword());
			pst.setString(4, vo.getAcaYear());
			pst.setInt(5, vo.getBirth());
			pst.setInt(6, vo.getRegNum());
			pst.setString(7, vo.getGender());
			pst.setString(8, vo.getEmail());
			pst.setString(9, vo.getNation());
			pst.setString(10, vo.getAddress());
			pst.setInt(11, vo.getPhone());
			pst.setString(12, vo.getImage());
			pst.setString(13, vo.getMainMajor());
			pst.setString(14, vo.getDoubleMajor());
			return pst.executeUpdate();
		} catch (Exception e) {
			System.out.println("basicInsert Exception - "+e.toString());
		}
		return 0;
	}//insert
	
}//BasicDAO
