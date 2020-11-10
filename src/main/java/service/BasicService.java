package service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import proDAO.BasicDAO;
import vo.BasicVO;

@Service
public class BasicService {
	
	@Autowired
	BasicDAO bdao;
	
	public BasicVO selectOne(BasicVO vo) {
		return bdao.selectOne(vo);
	}
	
	public int insert(BasicVO vo) {  
		return bdao.insert(vo); 
	}
}//BasicService
