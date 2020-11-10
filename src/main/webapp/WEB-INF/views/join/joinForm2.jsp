<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** joinForm **</title>
<link rel="stylesheet" type="text/css" href="resources/jqLib/myStyle.css">
<script src="resources/jqLib/jquery-3.2.1.min.js"></script>
<script>

//** 1. 입력 오류 확인 ( inCheck )
// 1.1) 개별적 오류 확인을 위한 switch 변수 정의
var iCheck=false;
var pCheck=false;
var nCheck=false;
var bCheck=false;  // birthd
var oCheck=false;  // point
var wCheck=false;  // weight

//1.2) 개별적 focusout 이벤트리스너 function 작성 : JQuery,
$(function() {
	// 첫 화면 focus
	$('#id').focus();
	
	// ID : 길이, 영문자,숫자 로만 구성
	$('#id').focusout(function() {
		iCheck=idCheck() ;
	}); // id_focusout
	
	// Password : 길이(4 이상), 숫자와 특수문자는 반드시 1개 이상 포함할것
	// => 특수문자 : HTML 특수문자 리스트표 참고 (http://kor.pe.kr/util/4/charmap2.htm)
	$('#password').focusout(function() {
		pCheck=pwCheck() ;
	}); // password
	
	$('#name').focusout(function() {
		nCheck=nmCheck() ;
	}); // name
	
	$('#birthd').focusout(function() {
		bCheck=bdCheck() ;
	}); // birthd
	
	$('#point').focusout(function() {
		oCheck=poCheck() ;
	}); // point
	
	$('#weight').focusout(function() {
		wCheck=weCheck() ;
	}); // weight
}); //ready	

</script>

</head>
<body>
<h2>** Spring Mybatis JoinForm **</h2>
<form action="insert" method="post" id="myForm"  enctype="multipart/form-data"><table>
  <tr height="40"><td bgcolor="pink">I  D</td>
  	  <td><input type="text" name="id" id="id">&nbsp;&nbsp;	
  	  	  <br><span id=iMessage class="eMessage"></span></td>
  </tr>
  <tr height="40"><td bgcolor="pink">Password</td>
  	  <td><input type="password" name="password" id="password" size="10"><br>
		<span  id="pMessage" class="eMessage"></span></td>
  </tr>
  <tr height="40"><td bgcolor="pink">Name</td>
	<td><input type="text" name="name" id="name" value="" size="10"><br>
		<span  id="nMessage" class="eMessage"></span></td>
	</tr>
  </tr>
  <tr height="40"><td bgcolor="pink">Level</td>
  	  <td><select name="lev" id="lev">
				<option value="A">관리자</option>
				<option value="B">나무</option>
				<option value="C">잎새</option>
				<option value="D" selected="selected">새싹</option>
		  </select></td>
  </tr>
  <tr height="40"><td bgcolor="pink">BirthDay</td>
	<td><input type="date" name="birthd" id="birthd" ><br>
		<span id="bMessage" class="eMessage"></span></td>
  </tr>
  <tr height="40"><td bgcolor="pink">Point</td>
  	  <td><input type="text" name="point" id="point" value="" size="10"><br>
		<span id="oMessage" class="eMessage"></span></td>
  </tr>
  <tr height="40"><td bgcolor="pink">Weight</td>
  	  <td><input type="text" name="weight" id="weight" value="" size="10"><br>
		  <span id="wMessage" class="eMessage"></span></td>
  </tr>
  <tr height="40"><td bgcolor="pink">추천인</td>
  	  <td><input type="text" name="rid" id="rid"></td>
  </tr>
  <tr height="40"><td bgcolor="pink">Image</td>
  	<td><img src="" class="select_img" /><br>
  		<input type="file" name="uploadfilef" id="uploadfilef">
  		<script>
		// 해당 파일의 서버상의 경로를 src로 지정하는것으로는 클라이언트 영역에서 이미지는 표시될 수 없기 때문에
		// 이를 해결하기 위해 FileReader이라는 Web API 를 사용
		// => 이 를 통해 url data를 얻을 수 있음.
		//    ( https://developer.mozilla.org/ko/docs/Web/API/FileReader)
		// ** FileReader
		// => 웹 애플리케이션이 비동기적으로 데이터를 읽기 위하여 읽을 파일을 가리키는File
		//    혹은 Blob 객체를 이용해 파일의 내용을(혹은 raw data버퍼로) 읽고 
		//    사용자의 컴퓨터에 저장하는 것을 가능하게 해줌.	
		// => FileReader.onload 이벤트의 핸들러.
		//    읽기 동작이 성공적으로 완료 되었을 때마다 발생.
		// => e.target : 이벤트를 유발시킨 DOM 객체
  		
			$('#uploadfilef').change(function(){
				if(this.files && this.files[0]) {
					var reader = new FileReader;
			 			reader.onload = function(e) {
		 				$(".select_img").attr("src", e.target.result)
		 					.width(70).height(90); 
		 				} // onload_function
		 				reader.readAsDataURL(this.files[0]);
		 		} // if
			}); // change	
  		</script>
  	</td>
  </tr>
  <tr height="40"><td></td>
  	  <td><input type="submit" value="전송" onclick="return inCheck()">&nbsp;&nbsp;
  	      <input type="reset" value="취소">&nbsp;&nbsp;</td>
  </tr>
</table></form>
<hr>
<a href="home">[Home]</a>
</body>
</html>