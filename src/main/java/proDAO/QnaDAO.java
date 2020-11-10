package proDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import DB.DBConnection;
import vo.PageVO;
import vo.QnaVO;

@Repository
public class QnaDAO {
	static Connection cn = DBConnection.getConnection();
	static Statement st;
	static PreparedStatement pst;
	static ResultSet rs;
	String sql;
	
	
	public int totalRowCount() {
		sql = "select count(*) from boardQna";
		try {
			st = cn.createStatement();
			rs = st.executeQuery(sql);
			if(rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			System.out.println("boardQna totalRowCount - "+e.toString());
		}
		return 0;
	} // totalRowCount
	
	public PageVO pageList(PageVO pvo) {
		pvo.setTotalCount(totalRowCount());
		ArrayList<QnaVO> list = new ArrayList<QnaVO>();
		sql = "select * from " 
				+ "(select b.* ,ROW_NUMBER() OVER(order by root desc, step asc)"
				+ "rnum from board b) where rnum between ? and ?";
		try {
			pst = cn.prepareStatement(sql);
			pst.setInt(1, pvo.getSno());
			pst.setInt(2, pvo.getEno());
			rs = pst.executeQuery();
			if(rs.next()) {		
			do {
						QnaVO vo = new QnaVO();
						vo.setSeq(rs.getInt(1));
						vo.setTitle(rs.getString(2));
						vo.setContents(rs.getString(3));
						vo.setRegDate(rs.getString(4));
						vo.setCount(rs.getInt(5));
						vo.setStudentId(rs.getInt(6));
						vo.setAttfile(rs.getString(7));
						list.add(vo);
					} while (rs.next());
			}else{
				list = null;
				System.out.println("boardQna PageList - 출력할 자료가없습니다.");
			}
		} catch (SQLException e) {
			System.out.println("boardQna PageList" + e.toString());
		}
		pvo.setQblist(list);
		return pvo;
	} // pageList
	
	public ArrayList<QnaVO> selectList() {
		sql = "select * from boardQna order by seq desc";
		ArrayList<QnaVO> list = new ArrayList<QnaVO>();
		try {
			st = cn.createStatement();
			rs = st.executeQuery(sql);
			if (rs.next()) {
				do {
					QnaVO vo = new QnaVO();
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
				System.out.println("QnaBoard selectList - 검색 자료 없음");
				list = null;
			}
		} catch (Exception e) {
			System.out.println("selectList Exception - " + e.toString());
			list = null;
		}
		return list;
	} // selectList

	public QnaVO selectOne(QnaVO vo) {
		sql = "select * from boardQna where seq=?";
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
		
	public int qbInsert(QnaVO vo) {
		sql = "insert into boardQna values"
				+"((select nvl(max(seq),0)+1 from boardqna),?,?,sysdate,0,0,?)";
		try {
			pst = cn.prepareStatement(sql);
			pst.setString(1, vo.getTitle());
			pst.setString(2, vo.getContents());
			pst.setString(3, vo.getAttfile());
			return pst.executeUpdate();
		} catch (SQLException e) {
			System.out.println("qbinsert Exception - "+e.toString());
			return 0;
		}
	}//qbinsert
	
	public int qbUpdate(QnaVO vo) {
		sql = "update boardQna set title=?, contents=? where seq=?";
		try {
			pst = cn.prepareStatement(sql);
			pst.setString(1, vo.getTitle());
			pst.setString(2, vo.getContents());
			pst.setInt(3, vo.getSeq());
			return pst.executeUpdate();
		} catch (SQLException e) {
			System.out.println("qbupdate Exception - "+e.toString());
			return 0;
		}
	}//qbupdate
	
	public int qbDelete(QnaVO vo) {
		sql = "delete from boardQna where seq=?";
			try {
				pst = cn.prepareStatement(sql);
				pst.setInt(1, vo.getSeq());
				return pst.executeUpdate();
			} catch (SQLException e) {
				System.out.println("qbdelete Exception - "+e.toString());
				return 0;
			}
	}//qbdelete
	
	public int countUp(QnaVO vo) {
		sql = "update boardQna set cnt=cnt+1 where seq=?";
		try {
			pst = cn.prepareStatement(sql);
			pst.setInt(1, vo.getSeq());
			return pst.executeUpdate();
		} catch (Exception e) {
			System.out.println("boardQna countUp - "+e.toString());
			return 0;
		}
	}//countUp

}//QnaDAO
