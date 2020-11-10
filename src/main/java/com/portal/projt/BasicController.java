package com.portal.projt;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import service.BasicService;
import vo.BasicVO;

@Controller
public class BasicController {
	
	@Autowired
	BasicService service;
	
	@RequestMapping(value="/joinf") 
	public ModelAndView joinf(ModelAndView mv) {
		mv.setViewName("join/joinForm");
		return mv;
	}

	
	@RequestMapping(value = "/login")
	public ModelAndView login(HttpServletRequest request, ModelAndView mv, BasicVO vo) {

		int studentId = (Integer.parseInt(request.getParameter("studentId")));
		String password = request.getParameter("password");
		String message = null;
		String url = "home";
		if (studentId > 0 && password.length() > 0) {
			vo.setStudentId(studentId);
			vo = service.selectOne(vo);

			if (vo == null) {
				message = " ID 오류 ";
			} else {
				if (vo.getPassword().equals(password)) {
					HttpSession session = request.getSession();
					session.setAttribute("logID", studentId);
					session.setAttribute("logName", vo.getName());
				} else {
					message = " Password 오류 ";
				}
			}
		} else {
			message = "정확한 값을 입력하세요.";
		}
		if (message != null)
			mv.addObject("message", message);
		mv.setViewName(url);
		return mv;
	} // login
	
	
	@RequestMapping(value = "/insert")
	public ModelAndView insert(HttpServletRequest request, ModelAndView mv, BasicVO vo) throws IOException {

		String realPath = request.getRealPath("/");
		System.out.println("realPath => " + realPath);

		if (realPath.contains(".eclipse."))
			realPath = "D:\\0MTest\\IDEset\\MyWork\\Portal_Projt-master\\src\\main\\webapp\\resources\\image/";
		else
			realPath += "resources\\image\\";
		File f1 = new File(realPath); // 지정된 경로의 정보에 대한 File 객체 생성됨
		System.out.println("** before mkDir f1 => " + f1);
		if (!f1.exists())
			f1.mkdir();
		System.out.println("** iamgef 전송 확인 => " + vo.getImagef());
		MultipartFile imagef = null;
		String file1, file2 = "resources/image/hoseologo2.png";
		if (vo.getImagef() != null) {
			imagef = vo.getImagef();
			if (!imagef.isEmpty()) {
				file1 = realPath + imagef.getOriginalFilename(); // 드라이브에 저장되는 실제 경로
				imagef.transferTo(new File(file1));
				file2 = "resources/image/" + imagef.getOriginalFilename();
			}
		}
		vo.setImage(file2);
		String message = null;
		if (service.insert(vo) > 0) {
			message = " 회원 가입 성공";
		} else {
			message = " 회원 가입 실패";
		}
		// 3. Service 결과 처리
		if (message != null)
			mv.addObject("message", message);
		mv.setViewName("home");
		return mv;
	} // insert
	
}//BasicController
