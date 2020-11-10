package com.portal.projt;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import service.QnaService;
import vo.PageVO;
import vo.QnaVO;

@Controller
public class QnaController {
	
	@Autowired
	QnaService service;
	
	@RequestMapping(value="/pqblist")
	public ModelAndView pqblist(ModelAndView mv, PageVO pvo) {
		int viewPage = 1;
		if(pvo.getViewPage() > 1)
			viewPage = pvo.getViewPage();
		else
			pvo.setViewPage(viewPage);
		return mv;
	}
	
	@RequestMapping(value="/qblist")
	public ModelAndView qblist(HttpServletResponse response,HttpServletRequest request,ModelAndView mv) {
		if(request.getParameter("message") != null)
			mv.addObject("message",request.getParameter("message"));
		List<QnaVO> list = new ArrayList<QnaVO>();
		list = service.selectList();
		if(list != null)
			mv.addObject("qblist",list);
		else
			mv.addObject("message","출력할 자료 없음");
		mv.setViewName("board/qnaBoardList");
		return mv;
	}
	
	@RequestMapping(value="/qbinsertf") 
	public ModelAndView qbinsertf(ModelAndView mv) {
		mv.setViewName("board/qnaBoardInsert");
		return mv;
	}
	
	@RequestMapping(value="/qbinsert") 
	public ModelAndView qbinsert(ModelAndView mv,QnaVO vo) {
		if(service.qbInsert(vo)>0) {
			mv.addObject("message","문의 등록 성공");
			mv.setViewName("redirect:qblist");
		}else {
			mv.addObject("message","문의 등록 실패");
			mv.setViewName("board/qnaBoardList");
		}
		return mv;
	}
	
	@RequestMapping(value="/qbdetail") 
	public ModelAndView qbdetail(HttpServletRequest request,ModelAndView mv,QnaVO vo) {
		//String logID;
		//HttpSession session = request.getSession(false);
		//if(session != null && session.getAttribute("logID") != null) {
		//	logID = (String)session.getAttribute("logID");
		//	if(!logID.equals(vo.getStudentId())) service.countUp(vo);
		//}else { //logID == null
		//	mv.addObject("message","서비스 이용불가");
		//	mv.setViewName("redirect:qblist");
		//}
		
		vo = service.selectOne(vo);
		if(vo != null) {
			mv.addObject("Detail",vo);
			if ("U".equals(request.getParameter("code"))) 
				mv.setViewName("board/qnaBoardUpdate");
			else
				mv.setViewName("board/qnaBoardDetail");
		}else {
			mv.addObject("message","출력할 자료가 없습니다.");
			mv.setViewName("redirect:qblist");
		}
		return mv;
	}
	
	@RequestMapping(value="/qbupdate") 
	public ModelAndView qbupdate(ModelAndView mv,QnaVO vo) {
		if(service.qbUpdate(vo) > 0) {
			mv.addObject("message","게시글 수정 성공");
			mv.setViewName("redirect:qblist");
		}else {
			mv.addObject("message","게시글 수정 실패");
			mv.addObject("board/qnaBoardList");
		}
		return mv;
	}
	
	@RequestMapping(value="/qbdelete") 
	public ModelAndView qbdelete(ModelAndView mv,QnaVO vo) {
		int count = service.qbDelete(vo);
		System.out.println("qbDelete 갯수"+count);
		if(count>0) {
			mv.addObject("message","게시글 삭제 성공");
			mv.setViewName("redirect:qblist");
		}else {
			mv.addObject("message","게시글 삭제 실패");
			mv.setViewName("board/qnaBoardList");
		}
		return mv;
	}
	
}//QnaController
