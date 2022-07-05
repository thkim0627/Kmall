<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="UTF-8">
<title>Kmall - 검색</title>
<!-- favicon -->
<link rel="shortcut icon" type="image/x-icon" href="resources/favicon/favicon.ico"/>
<!-- css -->
<link rel="stylesheet" type="text/css" href="resources/css/home.css">
<link rel="stylesheet" type="text/css" href="resources/css/menuSearch.css">
<!-- js -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
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
							<a href="shop">SHOP</a>
							<ul class="shopMenuDepth">
								<li><a href="shop">ALL</a></li>
								<li><a href="outer">OUTER</a></li>
								<li><a href="top">TOP</a></li>
								<li><a href="bottom">BOTTOM</a></li>
								<li><a href="onepiece">ONEPIECE</a></li>
								<li><a href="skirt">SKIRT</a></li>
								<li><a href="shoes">SHOES</a></li>
								<li><a href="bag">BAG</a></li>
								<li><a href="headwear">HEADWEAR</a></li>
								<li><a href="underwear">UNDERWEAR</a></li>
								<li><a href="atc">ATC</a></li>
								<li><a href="etc">ETC</a></li>	
							</ul>
						</li>			
							<li><a href="sale">SALE</a></li>
							<li><a href="#">EVENT</a></li>
							<li><a href="#">MAGAZINE</a></li>
							<li><a href="menucontact">CONTACT</a></li>
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
							<li><a href="menusearch">SEARCH</a></li>
						</c:if>
						<!-- 로그인 후 표시 메뉴-->
						<c:if test="${not empty LoginID}">
							<li><a href="clientlogout">LOGOUT</a></li>
							<li><a href="#">CART</a></li>
							<li><a href="noticelist">NOTICE</a></li>
							<li><a href="menusearch">SEARCH</a></li>
							<li><a href="clientpage">${LoginName}님</a></li>
						</c:if>
					</li>
				</ul>
			</div>
	    </div>
    </nav>
	
	<!-- 검색 폼 -->
	<main>
		<div id="searchTableBox">
			<form action="#" method="get">
				<table>
					<!-- 제목 -->
					<caption id="searchTitle">SEARCH</caption>
					<!-- 검색창 -->
					<tr> 
					 	<td><input type="text" name="#" id="search" placeholder="검색어를 입력하세요."></td><br>
					</tr>
					<tr>	
						<td>
							<input type="submit" id="submit" value="SEARCH">
							<input type="button" id="backBtn" value="CANCEL" onclick="location.href='home'">
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
	<script src="resources/js/home.js"></script>
</body>
</html>