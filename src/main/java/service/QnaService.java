package service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import proDAO.QnaDAO;
import vo.PageVO;
import vo.QnaVO;

@Service
public class QnaService {
	
	   @Autowired
	   QnaDAO qdao;
	   
	   public int totalRowCount() {
		   return qdao.totalRowCount();
	   }
	
	   public PageVO pageList(PageVO pvo) {
		   return qdao.pageList(pvo);
	   }
	   
	   public ArrayList<QnaVO> selectList() {
	      return qdao.selectList();
	   }
	   
	   public QnaVO selectOne(QnaVO vo) {
	      return qdao.selectOne(vo);
	   }
	   
	   public int qbInsert(QnaVO vo) {
		   return qdao.qbInsert(vo);
	   }
	   
	   public int qbUpdate(QnaVO vo) {
		   return qdao.qbUpdate(vo);
	   }

	   public int qbDelete(QnaVO vo) {
	      return qdao.qbDelete(vo);
	   }
	   
	   public int countUp(QnaVO vo) {
		   return qdao.countUp(vo);
	   }
	   
}//QnaService
