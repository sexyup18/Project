<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <link rel="stylesheet" href="resources/css/reset.css">
    <link rel="stylesheet" href="resources/css/student/st_infoMain.css">
    <meta charset="UTF-8">
    <title>Document</title>
</head>

<body>
    <div>
        <span>학생메뉴>학적정보>학생종합정보</span>
        <div>
          <form action="">
                학번 / 성명 
                <input type="text">
                <input type="text">
                <input type="image" src="resources/image/SearchButton.jpg" id="search">
            </form>
        </div>
        <div id="public">
            <div><img src="" alt=""></div>

            <div>
                <span>
                    <img src="resources/image/hamberger.jpg" >
                    학생정보
                </span>
                <table>
                    <tr>
                        <td>학 번</td>
                        <td><input type="text" class="dis"></td>
                        <td>성 명</td>
                        <td><input type="text" class="dis"></td>
                        <td>국 적</td>
                        <td><input type="text" class="dis"></td>
                        <td>소 속</td>
                        <td><input type="text" class="dis"></td>
                        <td>학 과</td>
                        <td><input type="text" class="dis"></td>
                    </tr>
                    <tr>
                        <td>제2전공</td>
                        <td><input type="text"></td>
                        <td>정원내외</td>
                        <td><input type="text"></td>
                        <td>입학유형</td>
                        <td><input type="text"></td>
                        <td>학 년</td>
                        <td><input type="text"></td>
                        <td>성 별</td>
                        <td><input type="text"></td>
                    </tr>
                    <tr>
                        <td>휴대폰</td>
                        <td><input type="text"></td>
                        <td>학적상태</td>
                        <td><input type="text"></td>
                        <td>최종학적변동</td>
                        <td><input type="text"></td>
                        <td>최종변동일자</td>
                        <td><input type="text"></td>
                        <td>이메일</td>
                        <td><input type="text"></td>
                    </tr>
                </table>
            </div>
            <!--public>학생정보-->
        </div>
        <!--public-->
        <nav>
            <ul>
                <li id="select">기 본</li>
                <li>전 공</li>
                <li>변 동</li>
                <li>장 학</li>
                <li>등 록</li>
            </ul>
        </nav>
        <div><!--여기서부터 바뀌는 공간-->
            <!--이곳이 내용-->
        </div> <!--basic들을 묶고있는 div 바뀌는공간임-->        
    </div>
</body></html>
