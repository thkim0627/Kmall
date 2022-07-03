<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Kmall - 프로필</title>
<!-- favicon -->
<link rel="shortcut icon" type="image/x-icon" href="resources/favicon/favicon.ico"/>
<!-- css -->
<link rel="stylesheet" type="text/css" href="resources/css/home.css">
<link rel="stylesheet" type="text/css" href="resources/css/clientProfile.css">
<!-- js -->
<script src="resources/js/jquery-3.2.1.min.js"></script>
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
							<li><a href="noticelist">NOTICE</a></li>
							<li><a href="#">SEARCH</a></li>
						</c:if>
						<!-- 로그인 후 표시 메뉴-->
						<c:if test="${not empty LoginID}">
							<li><a href="clientlogout">LOGOUT</a></li>
							<li><a href="#">CART</a></li>
							<li><a href="noticelist">NOTICE</a></li>
							<li><a href="#">SEARCH</a></li>
							<li><a href="clientpage">${LoginName}님</a></li>
						</c:if>
					</li>
				</ul>
			</div>
	    </div>
    </nav>
	
	<!-- 프로필 -->
	<main>
		<div id="profileTableBox">
			<form action="clientupdate" method="post">
				<table id="profileTable">
					<!-- 제목 -->
					<caption id="ProfileTitle">✶ 회원 정보 수정</caption>
					<!-- 부제목 -->
					<caption id="ProfileSubTitle">기본정보<span style="float: right; font-size: 0.8rem;">필수입력사항</span><span style="color: red; float: right; font-size: 0.8rem;">✔</span></caption>
					<!-- 아이디 -->
					<tr> <!-- input Tag 입력 막기 : disabled는 서버로 전송 안됨, readonly는 서버로 전송 됨 -->
						<td><label for="id">아이디</label><span style="color: red; font-size: 0.8rem;">✔</span></td>
						<td><input type="text" name="id" id="id" value="${client.id}" readonly></td>
					</tr>
					<!-- 비밀번호1 -->
					<tr>
						<td><label for="password1">비밀번호</label><span style="color: red; font-size: 0.8rem;">✔</span></td>
						<td><input type="text" name="password1" id="password1" value="${client.password1}" readonly></td>
					</tr>
					<!-- 비밀번호2 -->
					<tr>
						<td><label for="password2">비밀번호 확인</label><span style="color: red; font-size: 0.8rem;">✔</span></td>
						<td><input type="text" name="password2" id="password2" value="${client.password1}" readonly></td>
					</tr>
					<!-- 이름 -->
					<tr>
						<td><label for="name">이름</label><span style="color: red; font-size: 0.8rem;">✔</span></td>
						<td><input type="text" name="name" id="name" value="${client.name}" readonly></td>
					</tr>
					<!-- 주소 -->
					<tr>
						<td><label for="address">주소</label><span style="color: red">✔</span></td>
						<td><input type="text" name="address" id="address" value="${client.address}"></td>
					</tr>
					<!-- 핸드폰번호 -->
					<tr>
						<td><label for="number">휴대전화</label><span style="color: red; font-size: 0.8rem;">✔</span></td>
						<td><input type="text" name="number" id="number" value="${client.number}"></td>
					</tr>
					<!-- 이메일 -->
					<tr>
						<td><label for="email">이메일</label><span style="color: red; font-size: 0.8rem;">✔</span></td>
						<td><input type="text" name="email" id="email" value="${client.email}"></td>
					</tr>
					<tr>
						<td class="submitBox"></td>
						<td class="submitBox">
							<input type="submit" id="submitUpdate" value="회원정보 수정">
							<input type="reset" id="backBtn" value="취소" onclick="location.href='home'">
							<input type="button" id="submitDelete" value="회원탈퇴" onclick="location.href='clientdelete'">
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
			<!-- 은행정보 -->
			<div class="homeFooterBox" style="margin-left: 1rem;">
				<div class="footerTitle" style="margin-top: 3rem;"><h2><span>BANK INFO</span></h2></div>
				<ul class="homeFooterUL">
					<li class="footerContents">KB 국민 : 000000-00-000000</li>
					<li class="footerContents">KEB 하나 : 000-000000-00000</li>
					<li class="footerContents">IBK 기업 : 000-000000-00-000</li>
					<li class="footerContents">예금주 : (주)케이몰</li>
				</ul>
			</div>
			<!-- 정책정보 -->
			<div class="homeFooterBox" style="margin-left: -0.5rem;">
				<div class="footerTitle" style="margin-bottom: 1.3rem;"><h2><span>POLICY</span></h2></div>
				<ul class="homeFooterUL">
					<li class="footerContents"><a class="footerPolicyA" href="#">FAQ</a></li>
					<li class="footerContents"><a class="footerPolicyA" href="#">AGREEMENT</a></li>
					<li class="footerContents"><a class="footerPolicyA" href="#">GUIDE</a></li>
					<li class="footerContents"><a class="footerPolicyA" href="#">PRIVACY</a></li>
				</ul>
			</div>
			<!-- 회사정보 -->
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