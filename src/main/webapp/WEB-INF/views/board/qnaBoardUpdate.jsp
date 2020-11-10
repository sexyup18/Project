<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Q&ABoard Detail</title>
<script src="resources/jqLib/jquery-3.2.1.min.js"></script>
<link rel="stylesheet" href="resources/css/board/qnaBoardUpdate.css">
</head>
<body>
<header>
	<h1>Q&A UPDATE</h1>
</header>
	<form action="qbupdate" method="post">
		<div id="div1">
			<table>
				<tr height="30">
					<td bgcolor="#566881"
						style="border-radius: 5px; text-align: center; color: white; 
						border: 1px solid #000033; width: 70px;">번 호</td>
					<td>
					<input type="text" name="seq" id="seq" value="${Detail.seq}" readonly="readonly"></td>
				</tr>
				<tr height="30">
					<td bgcolor="#566881"
						style="border-radius: 5px; text-align: center; color: white; 
						border: 1px solid #000033; width: 70px;">제 목</td>
					<td>
					<input type="text" name="title" id="title"value="${Detail.title}"></td>
				</tr>
				<tr height="30">
					<td bgcolor="#566881"
						style="border-radius: 5px; text-align: center; color: white; 
						border: 1px solid #000033; width: 70px;">내 용</td>
					<td><textarea name="contents" id="contents" rows="25" cols="60">${Detail.contents}</textarea></td>
				</tr>
				<tr height="30">
					<td bgcolor="#566881"
						style="border-radius: 5px; text-align: center; color: white; 
						border: 1px solid #000033; width: 70px;">날 짜</td>
					<td style="border: 1px solid #000033; border-radius: 5px; background-color: white;">${Detail.regDate}</td>
				</tr>
				<tr height="30">
					<td bgcolor="#566881"
						style="border-radius: 5px; text-align: center; color: white; 
						border: 1px solid #000033; width: 70px;">조회수</td>
					<td style="border: 1px solid #000033; border-radius: 5px;">${Detail.count}</td>
				</tr>
				<tr height="30">
					<td bgcolor="#566881"
						style="border-radius: 5px; text-align: center; color: white; 
						border: 1px solid #000033; width: 70px;">작성자</td>
					<td style="border: 1px solid #000033; border-radius: 5px;">${Detail.studentId}</td>
				</tr>
				<tr height="50">
					<td bgcolor="#566881" style="border-radius: 5px; text-align: center; 
					color: white; border: 1px solid #000033; width: 70px;">첨부파일</td>
					<td style="border-radius: 5px; border: 1px solid #000033;">
					<img src="${Detail.attfile}" width="50%" height="50"></td>
				</tr>
				<tr height="50"><td></td>
  	  				<td style="float: right;">
  	  					<input type="submit" value="완료" id="btn">&nbsp;
  	      				<input type="reset"  value="취소" id="btn"></td>
  				</tr>
			</table>
		</div>
	</form>
</body>
	<footer>
		<div>
			<ul>
				<li><a href="#" class="a1">개인정보처리방침</a></li>
				<li><a href="#">이메일무단수집거부</a></li>
				<li><a href="#">오시는길</a></li>
				<li><a href="#">교내전화번호</a></li>
				<li><a href="#">학내백신다운로드</a></li>
				<ul>
					<ul>
						<li>은혜캠퍼스 충청남도 아산시 배방읍 호서로79번길20 (우)31499 TEL:041-540-5114</li>
						<li>승빈캠퍼스 충청남도 천안시 동남구 호서대길12 (우)31066 TEL:041-560-8114</li>
						<li>민혁캠퍼스 충청남도 천안시 배방읍 호서대길12 (우)31499 TEL:041-560-8115</li>
						<li>COPYRIGHT(C) 2011 HOSEO UNIVERSITY. ALL RIGHT RESERVED</li>
					</ul>
					<img src="resources/image/hoseologo1.png" width="140" height="50">
				</ul>
			</ul>
		</div>
	</footer>
</html>