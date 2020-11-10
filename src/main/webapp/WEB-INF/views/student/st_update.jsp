<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="kr">
<head>
    <meta charset="UTF-8">
    <title>Document</title>
  <link rel="stylesheet" href="resources/css/reset.css">
  <link rel="stylesheet" href="resources/css/student/st_update.css">
  <script src="resources/css/reset.css/jqLib/jquery-3.2.1.min.js"></script>
    <script>
        $(function() {
            $('.dis').attr('disabled', 'disabled');

            $('#search').click(function() {
                $('.dis').removeAttr('disabled');
            });

        });
    </script>
</head>

<body>

    <div>
        <span>학생메뉴>학적정보>개인정보수정</span>
        <div>
            <form action="#">
                비밀번호 확인 <input type="password">
                <input type="image" src="resources/image/SearchButton.jpg" id="search">

            </form>
        </div>
        <div>

            본인정보

            <form action="#">
                <table>
                    <tr>
                        <td>이름</td>
                        <td>
                            <input type="text" class="dis">
                        </td>
                    </tr>
                    <tr>
                        <td>전화번호</td>
                        <td>
                            <input type="text" class="dis">
                        </td>
                    </tr>
                    <tr>
                        <td>핸드폰</td>
                        <td>
                            <input type="text" class="dis">
                        </td>


                    </tr>
                    <tr>
                        <td>주소</td>
                        <td>
                            <input type="text" class="dis" placeholder="기본주소"><br> <input type="text" class="dis" placeholder="상세주소">
                        </td>
                    </tr>
                    <tr>
                        <td>이메일</td>
                        <td>
                            <input type="text" class="dis">@<input type="text" class="dis">
                        </td>
                    </tr>
                </table>
            </form>
            <div>
                <input type="submit" value="수정" id="update">
            </div>

        </div>
    </div>
</body></html>