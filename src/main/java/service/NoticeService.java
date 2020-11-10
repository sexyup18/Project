package service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import proDAO.NoticeDAO;
import vo.NoticeVO;

@Service
public class NoticeService {
	@Autowired
	NoticeDAO ndao;

	public ArrayList<NoticeVO> selectList() {
	      return ndao.selectList();
	   }

	   public NoticeVO selectOne(NoticeVO vo) {
	      return ndao.selectOne(vo);
	   }
	   
	   public int nbInsert(NoticeVO vo) {
		   return ndao.nbInsert(vo);
	   }
	   
	   public int nbUpdate(NoticeVO vo) {
		   return ndao.nbUpdate(vo);
	   }

	   public int nbDelete(NoticeVO vo) {
	      return ndao.nbDelete(vo);
	   }
	   
	   public int countUp(NoticeVO vo) {
		   return ndao.countUp(vo);
	   }
	   
}//NoticeService
