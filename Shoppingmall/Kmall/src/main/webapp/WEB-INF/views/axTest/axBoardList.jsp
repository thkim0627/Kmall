<%-- <%@ page language="java" contentType="text/html; charset=UTF-8" --%>
<%--     pageEncoding="UTF-8"%> --%>
<%-- <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>     --%>
<!-- <!DOCTYPE html> -->
<!-- <html> -->
<!-- <head> -->
<!-- <meta charset="UTF-8"> -->
<!-- <title>** Spring Mybatis Ajax_BoardList **</title> -->
<!-- <link rel="stylesheet" type="text/css" href="resources/myLib/myStyle.css" > -->
<!-- <script src="resources/myLib/jquery-3.2.1.min.js"></script> -->
<!-- <script src="resources/myLib/axTest01.js"></script> -->
<!-- <script src="resources/myLib/axTest03.js"></script> -->
<!-- </head> -->
<!-- <body> -->
<!-- <!-- ** 반복문에 이벤트 적용  -->
<!-- 	=> 매개변수처리에 varStatus 활용, ajax, json Test   -->
<!-- 	=> Login 여부에 무관하게 처리함. -->
<!-- // Test 1. 타이틀 클릭하면, 하단(resultArea2)에 글 내용 출력하기  -> aTag, JS, jsBDetail1(  )  -->
<!-- // Test 2. 타이틀 클릭하면, 글목록의 아랫쪽(span result)에 글 내용 출력하기 -> aTag, JS, jsBDetail2( , )  -->
<!-- // Test 3. seq 에 마우스 오버시에 별도의 DIV에 글내용 표시 되도록 하기  -->
<!-- //			-> jQuery : id, class, this -->
<!-- // 			-> seq 의 <td> 에 마우스오버 이벤트 -->
<!-- //			-> content 를 표시할 div (table 바깥쪽에) : 표시/사라짐   -->
<!-- //			-> 마우스 포인터의 위치를 이용해서 div의 표시위치 지정 -->
<!-- --> -->

<!-- <h2>** Spring Mybatis Ajax_BoardList **</h2> -->

<%-- <c:if test="${not empty message}"> --%>
<%-- <b>=> ${message}</b>   --%>
<%-- </c:if> --%>
<!-- <hr> -->
<!-- <table width=100% > -->
<!-- 	<tr height="30" bgcolor="YellowGreen"> -->
<!-- 		<th>Seq</th><th>Title</th><th>I D</th><th>RegDate</th><th>조회수</th></tr> -->
<%-- 	<c:if test="${not empty banana}"> --%>
<%-- 	  <c:forEach var="board" items="${banana}" varStatus="vs"> --%>
<!-- 		<tr height="30"> -->
<%-- 			<td align="center" id="${board.seq}" class="sss2 textlink">${board.seq}</td> --%>
<!-- 			<!--  -->
<!-- 			Test 1. 타이틀 클릭하면, 하단(resultArea2)에 글 내용 출력하기  -> aTag, JS, jsBDetail1()   -->
<!-- 			<td><a href="#resultArea2" onclick="jsBDetail1(${board.seq})">${board.title}</a></td>--> -->
<!-- 			<!--  -->
<!-- 			Test 2. 타이틀 클릭하면, 글목록의 아랫쪽에 글 내용 출력하기 -> aTag, JS, jsBDetail2( , ) -->
<!-- 				=> <tr> </tr> 추가후 <span> 내용 표시  -->
<!-- 				=> 이 <span> 의 id 값으로 index 또는 count 이용하기    -->
<!-- 				=> scroll 정지 : "javascript:;" , "javascript:void(0);" 동일효과 -->
<!-- 				=> Toggle 방식으로 없을때 클릭하면 표시되고, 있을때 클릭하면 사라짐 -->
<!-- 				=> 만약 출력할 content의 내용이 없으면 아무것도 나타나지 않는다 (공백의 span 은 표시 되지않음.)	 -->
<!-- 				** function 에 이벤트객체 전달 -->
<!--          		=> 이벤트핸들러의 첫번째 매개변수에 event 라는 이름으로 전달함. -->
<!-- 			--> -->
<%-- 			<td><a href="javascript:;" onclick="jsBDetail2(${board.seq}, ${vs.count})">${board.title}</a></td> --%>
			
<%-- 			<td>${board.id}</td><td>${board.regdate}</td><td>${board.cnt}</td> --%>
<!-- 		</tr> -->
<!-- 		<tr><td></td> -->
<%-- 			<td colspan="4"><span id="${vs.count}" class="content"></span></td> --%>
<!-- 		</tr> -->
		
<%-- 	  </c:forEach> --%>
<%-- 	</c:if> --%>
<%-- 	<c:if test="${empty banana}">	 --%>
<!-- 			<tr height=30><td colspan=5>** 출력할 자료가 1건도 없습니다 **</td></tr> -->
<%-- 	</c:if> --%>
<!-- </table> -->
<!-- <div id="content"></div> -->
<!-- <hr> -->
<!-- </body> -->
<!-- </html> -->