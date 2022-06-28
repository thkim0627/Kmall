<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Kmall - 회원가입</title>
<!-- favicon -->
<link rel="shortcut icon" type="image/x-icon" href="resources/favicon/favicon.ico"/>
<!-- css -->
<link rel="stylesheet" type="text/css" href="resources/css/home.css">
<link rel="stylesheet" type="text/css" href="resources/css/join.css">
<!-- js -->
<script src="resources/js/jquery-3.2.1.min.js"></script>
<script src="resources/js/join.js"></script>
<script src="resources/js/regularExpression.js"></script>
</head>
<body>
	<header></header>

	<!-- 네비게이션바 -->
	<nav> 
		<div id="navbarBox"> 
	        <!-- 쇼핑메뉴 -->
	        <div id="shopMenuBox">
		        <ul id="shopMenu">
					<c:if test="${empty LoginID || not empty LoginID}">
						<li>
							<a href="#">SHOP</a>
							<ul class="shopMenuDepth">
								<li><a href="#">ALL</a></li>
								<li><a href="#">OUTER</a></li>
								<li><a href="#">TOP</a></li>
								<li><a href="#">BOTTOM</a></li>
								<li><a href="#">ONEPIECE</a></li>
								<li><a href="#">SKIRT</a></li>
								<li><a href="#">SHOES</a></li>
								<li><a href="#">BAG</a></li>
								<li><a href="#">HEADWEAR</a></li>
								<li><a href="#">UNDERWEAR</a></li>
								<li><a href="#">ATC</a></li>
								<li><a href="#">ETC</a></li>	
							</ul>
						</li>			
						<li><a href="#">SALE</a></li>
						<li><a href="#">LOOKBOOK</a></li>
						<li><a href="#">CAMPAIGN</a></li>
						<li><a href="#">CONTACT</a></li>
					</c:if>
				</ul>
			</div>
			<!-- 로고 -->
	        <div id="navbarLogo">
	            <h1><a href="home">Kmall</a></h1>
	        </div>
			<!-- 회원메뉴 -->
	        <div id="memberMenuBox">
		        <ul id="memberMenu">
		        	<li>
						<!-- 로그인 전 표시 메뉴 -->
						<c:if test="${empty LoginID}">
							<li><a href="clientloginf">LOGIN</a></li>
							<li><a href="clientjoinf">JOIN</a></li>
							<li><a href="blist">BOARD</a></li>
							<li><a href="#">SEARCH</a></li>
						</c:if>
						<!-- 로그인 후 표시 메뉴-->
						<c:if test="${not empty LoginID}">
							<li><a href="logout">LOGOUT</a></li>
							<li><a href="mdetail">MYPAGE</a></li>
							<li><a href="blist">BOARD</a></li>
							<li><a href="#">SEARCH</a></li>
							<li><a href="mdetail">${LoginName}님</a></li>
						</c:if>
					</li>
				</ul>
			</div>
	    </div>
    </nav>

	<!-- enctype="multipart/form-data"는 파일 업로드를 가능하게 해줌 
	multipart/form-data는 파일업로드가 있는 입력양식요소에 사용되는 enctype 속성의 값중 하나이고, 
	multipart는 폼데이터가 여러 부분으로 나뉘어 서버로 전송되는 것을 의미한다. 
	폼이 제출될 때 이 형식을 서버에 알려주며, multipart/form-data로 지정이 되어 있어야 서버에서 정상적으로 데이터를 처리할 수 있다. -->
	 
	<!-- 회원가입 -->
	<main>
		<div id="joinTableBox">
			<form action="clientjoin" method="post">
				<table>
					<!-- 제목 -->
					<caption id="joinTitle">JOIN</caption>
					<!-- 아이디 -->
					<tr>
				 		<td>
				 			<input type="text" name="id" id="id" placeholder="ID">
				 			<button type="button" id="idCheckBtn" onclick="idDoubleCheck()">DOUBLE CHECK</button><br>
				 			<span id="iMessage" class="eMessage"></span>
				 		</td>
					</tr>
					<!-- 비밀번호1 -->
					<tr>
						<td>
							<input type="password" name="password1" id="password1" class="password" placeholder="PASSWORD"><br>
							<span id="p1Message" class="eMessage"></span>
						</td>
						
					</tr>
					<!-- 비밀번호2 -->
					<tr>
						<td>
							<input type="password" name="password2" id="password2" class="password" placeholder="RECONFIRM PASSWORD"><br>
							<span id="p2Message" class="eMessage"></span>	
						</td>
					</tr>
					<!-- 이름 -->
					<tr>
				 		<td>
				 			<input type="text" name="name" id="name" placeholder="NAME"><br>
				 			<span id="nMessage" class="eMessage"></span>
				 		</td>
					</tr>
					<!-- 주소 -->
					<tr>
				 		<td>
				 			<input type="text" name="address" id="address" placeholder="ADDRESS"><br>
				 			<span id="aMessage" class="eMessage"></span>	
				 		</td>
					</tr>
					<!-- 핸드폰번호 -->
					<tr>
				 		<td>
				 			<input type="text" name="number" id="number" placeholder="PHONE NUMBER"><br>
				 			<span id="hMessage" class="eMessage"></span>
				 		</td>
					</tr>
					<!-- 이메일 -->
					<tr>
				 		<td>
				 			<input type="text" name="email" id="email" placeholder="EMAIL"><br>
				 			<span id="eMessage" class="eMessage"></span>	
				 		</td>	
					</tr>
					
					<!-- 폼 전송 -->
					<tr>	
						<td style="margin: -1rem;"><br>
							<input type="submit" id="submit" value="SIGNUP" onclick="return inCheck()"><br>
							<input type="reset" id="backBtn" value="CANCEL" onclick="location.href='home'">
						</td>
					</tr>	
				</table>
			</form>
		</div>
	</main>
	
	<!-- 푸터 -->
	<footer>
		<div id="homeFooterHR"></div>
		<div id="homeFooterCont">
			<!-- 고객센터 -->
			<div class="homeFooterBox" style="margin-left: 0.2rem;">
				<div class="footerTitle" style="margin-bottom: 1.1rem;"><h2><span>CS CENTER</span></h2></div>
				<ul class="homeFooterUL">
					<li class="footerContents" style="font-size: 1.7rem; font-weight: bold; margin-bottom: 1.2rem;">010-5840-5084</li>
					<li class="footerContents">thkim_o@daum.net</li>
					<li class="footerContents">AM 09:00 ~ PM 17:00</li>
				</ul>
			</div>
			<!-- 은행 -->
			<div class="homeFooterBox" style="margin-left: 1rem;">
				<div class="footerTitle" style="margin-top: 3rem;"><h2><span>BANK INFO</span></h2></div>
				<ul class="homeFooterUL">
					<li class="footerContents">KB 국민 : 000000-00-000000</li>
					<li class="footerContents">KEB 하나 : 000-000000-00000</li>
					<li class="footerContents">IBK 기업 : 000-000000-00-000</li>
					<li class="footerContents">예금주 : (주)케이몰</li>
				</ul>
			</div>
			<!-- 정책 -->
			<div class="homeFooterBox" style="margin-left: -0.5rem;">
				<div class="footerTitle" style="margin-bottom: 1.3rem;"><h2><span>POLICY</span></h2></div>
				<ul class="homeFooterUL">
					<li class="footerContents"><a class="footerPolicyA" href="#">FAQ</a></li>
					<li class="footerContents"><a class="footerPolicyA" href="#">AGREEMENT</a></li>
					<li class="footerContents"><a class="footerPolicyA" href="#">GUIDE</a></li>
					<li class="footerContents"><a class="footerPolicyA" href="#">PRIVACY</a></li>
				</ul>
			</div>
			<!-- 회사소개 -->
			<div class="homeFooterBox">
				<div class="footerTitle"><h2><span>COMPANY</span></h2></div>
				<ul class="homeFooterUL">
					<li class="footerContents">법인명(상호) : (주)케이몰(Kmall Co., Ltd.)</li>
					<li class="footerContents">대표자(성명) : 김태형 | 사업자 등록번호 안내 : [000-00-00000]</li>
					<li class="footerContents">통신판매업 신고 제 2022-서울길동-00203호 | 전화 : 010-5840-5084 | 팩스 : 02-000-0000</li>
					<li class="footerContents">주소 : 00000 서울특별시 강동구 천호대로185길 67-5 (길동) 한빛주택 203호</li>
				</ul>
			</div>
		</div>
		<p class="footerContents" style="margin: 3rem 0 4rem 3.4rem; line-height: 1.5rem;">
			Contact thkim@kmall.com for more information.<br>
			Copyright © 케이몰. All rights reserved.
		</p>
	</footer>
</body>
</html>