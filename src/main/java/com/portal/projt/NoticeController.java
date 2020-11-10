package com.portal.projt;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import service.NoticeService;
import vo.NoticeVO;

@Controller
public class NoticeController {
	
	@Autowired
	NoticeService service;
	
	@RequestMapping(value="/nblist")
	public ModelAndView nblist(HttpServletRequest request,ModelAndView mv) {
		if(request.getParameter("message") != null)
			mv.addObject("message",request.getParameter("message"));
		List<NoticeVO> list = new ArrayList<NoticeVO>();
		list = service.selectList();
		if(list != null)
			mv.addObject("nblist",list);
		else
			mv.addObject("message","출력할 자료 없음");
		mv.setViewName("board/noticeBoardList");
		return mv;
	}
	
	@RequestMapping(value="/nbinsertf") //민혁
	public ModelAndView nbinsertf(ModelAndView mv) {
		mv.setViewName("board/noticeBoardInsert");
		return mv;
	}
	
	@RequestMapping(value="/nbinsert") //민혁
	public ModelAndView nbinsert(ModelAndView mv,NoticeVO vo) {
		if(service.nbInsert(vo)>0) {
			mv.addObject("message","문의 등록 성공");
			mv.setViewName("redirect:nblist");
		}else {
			mv.addObject("message","문의 등록 실패");
			mv.setViewName("board/noticeBoardList");
		}
		return mv;
	}
	
	@RequestMapping(value="/nbdetail") //민혁
	public ModelAndView nbdetail(HttpServletRequest request,ModelAndView mv,NoticeVO vo) {
		//String logID;
		//HttpSession session = request.getSession(false);
		//if(session != null && session.getAttribute("logID") != null) {
		//	logID = (String)session.getAttribute("logID");
		//	if(!logID.equals(vo.getStudentId())) service.countUp(vo);
		//}else { //logID == null
		//	mv.addObject("message","서비스 이용불가");
		//	mv.setViewName("redirect:nblist");
		//}
		vo = service.selectOne(vo);
		if(vo != null) {
			mv.addObject("Detail",vo);
			if(("U").equals(request.getParameter("code")))
				mv.setViewName("board/noticeBoardUpdate");
			else
				mv.setViewName("board/noticeBoardDetail");
		}else {
			mv.addObject("message","출력할 자료가 없습니다.");
			mv.setViewName("redirect:nblist");
		}
		mv.setViewName("board/noticeBoardDetail");
		return mv;
	}
	
	@RequestMapping(value="/nbupdate") //민혁
	public ModelAndView nbupdate(ModelAndView mv,NoticeVO vo) {
		if(service.nbUpdate(vo) > 0) {
			mv.addObject("message","게시글 수정 성공");
			mv.setViewName("redirect:nblist");
		}else {
			mv.addObject("message","게시글 수정 실패");
		}
		
		mv.setViewName("board/noticeBoardList");
		return mv;
	}
	
	@RequestMapping(value="/nbdelete") //민혁
	public ModelAndView nbdelete(ModelAndView mv,NoticeVO vo) {
		int count = service.nbDelete(vo);
		System.out.println("nbDelete 갯수"+count);
		if(count>0) {
			mv.addObject("message","게시글 삭제 성공");
			mv.setViewName("redirect:nblist");
		}else {
			mv.addObject("message","게시글 삭제 실패");
			mv.setViewName("board/noticeBoardList");
		}
		return mv;
	}
	
}//NoticeController
