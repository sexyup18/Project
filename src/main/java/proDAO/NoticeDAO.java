package proDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import DB.DBConnection;
import vo.NoticeVO;

@Repository
public class NoticeDAO {
	static Connection cn = DBConnection.getConnection();
	static Statement st;
	static PreparedStatement pst;
	static ResultSet rs;
	String sql;
	
	public ArrayList<NoticeVO> selectList() {
		sql = "select * from boardNotice order by seq desc";
		ArrayList<NoticeVO> list = new ArrayList<NoticeVO>();
		try {
			st = cn.createStatement();
			rs = st.executeQuery(sql);
			if (rs.next()) {
				do {
					NoticeVO vo = new NoticeVO();
					vo.setSeq(rs.getInt(1));
					vo.setTitle(rs.getString(2));
					vo.setContents(rs.getString(3));
					vo.setRegDate(rs.getString(4));
					vo.setCount(rs.getInt(5));
					vo.setStudentId(rs.getInt(6));
					vo.setAttfile(rs.getString(7));
					list.add(vo);
				} while (rs.next());
			} else {
				System.out.println("NoticeBoard selectList - 검색 자료 없음");
				list = null;
			}
		} catch (Exception e) {
			System.out.println("selectList Exception - " + e.toString());
			list = null;
		}
		return list;
	} // selectList

	public NoticeVO selectOne(NoticeVO vo) {
		sql = "select * from boardNotice where seq=?";
		try {
			pst = cn.prepareStatement(sql);
			pst.setInt(1, vo.getSeq());
			rs = pst.executeQuery();
			if (rs.next()) {
				vo.setTitle(rs.getString(2));
				vo.setContents(rs.getString(3));
				vo.setRegDate(rs.getString(4));
				vo.setCount(rs.getInt(5));
				vo.setStudentId(rs.getInt(6));
				vo.setAttfile(rs.getString(7));
			} else {
				vo = null;
			}
		} catch (Exception e) {
			System.out.println("selectOne Exception - " + e.toString());
			vo = null;
		}
		return vo;
	} // selectOne
		
	public int nbInsert(NoticeVO vo) {
		sql = "insert into boardNotice values"
				+"((select nvl(max(seq),0)+1 from boardNotice),?,?,sysdate,0,0,?)";
		try {
			pst = cn.prepareStatement(sql);
			pst.setString(1, vo.getTitle());
			pst.setString(2, vo.getContents());
			pst.setString(3, vo.getAttfile());
			return pst.executeUpdate();
		} catch (SQLException e) {
			System.out.println("nbinsert Exception - "+e.toString());
			return 0;
		}
	}//nbinsert
	
	public int nbUpdate(NoticeVO vo) {
		sql = "update boardNotice set title=?, content=? where seq=?";
		try {
			pst = cn.prepareStatement(sql);
			pst.setString(1, vo.getTitle());
			pst.setString(2, vo.getContents());
			pst.setInt(3, vo.getSeq());
			return pst.executeUpdate();
		} catch (SQLException e) {
			System.out.println("nbupdate Exception - "+e.toString());
			return 0;
		}
	}//nbupdate
	
	public int nbDelete(NoticeVO vo) {
		sql = "delete from boardNotice where seq=?";
			try {
				pst = cn.prepareStatement(sql);
				pst.setInt(1, vo.getSeq());
				return pst.executeUpdate();
			} catch (SQLException e) {
				System.out.println("nbdelete Exception - "+e.toString());
				return 0;
			}
	}//nbdelete
	
	public int countUp(NoticeVO vo) {
		sql = "update boardNotice set cnt=cnt+1 where seq=?";
		try {
			pst = cn.prepareStatement(sql);
			pst.setInt(1, vo.getSeq());
			return pst.executeUpdate();
		} catch (Exception e) {
			System.out.println("boardNotice countUp - "+e.toString());
			return 0;
		}
	}//countUp
	
}//NoticeDAO
