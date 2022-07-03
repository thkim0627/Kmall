<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Kmall - 마이페이지</title>
<!-- favicon -->
<link rel="shortcut icon" type="image/x-icon" href="resources/favicon/favicon.ico"/>
<!-- css -->
<link rel="stylesheet" type="text/css" href="resources/css/home.css">
<link rel="stylesheet" type="text/css" href="resources/css/clientPage.css">
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
	
	<!-- 마이페이지 -->
	<main>
		<div id="clientPageTableBox">
			<table>
				<!-- 제목 -->
				<caption id="clientPageTitle"></caption>
				<tr>
					<!-- 주문내역 -->
					<td class="clientPageSubtitle">
						<a href="#" class="a1">ORDER</a><br>
						<p><a href="#" class="a2">고객님께서 주문하신 상품의 주문내역을 확인하실 수 있습니다.</a></p>
					</td>
				</tr>
				<tr>	
					<!-- 프로필 -->
					<td class="clientPageSubtitle">
						<a href="clientprofile" class="a1">PROFILE</a><br>
						<p><a href="clientprofile" class="a2">회원이신 고객님의 개인정보를 관리하는 공간입니다.</a></p>
					</td>
				</tr>
				<tr>
					<!-- 쿠폰 -->
					<td class="clientPageSubtitle">
						<a href="#" class="a1">COUPON</a><br>
						<p><a href="#" class="a2">고객님이 보유하고 계신 쿠폰내역을 보여드립니다.</a></p>
					</td>
				</tr>
				<tr>
					<!-- 관심상품 -->
					<td class="clientPageSubtitle">
						<a href="#" class="a1">WISHLIST</a><br>
						<p><a href="#" class="a2">관심상품으로 등록하신 상품의 목록을 보여드립니다.</a></p>
					</td>
				</tr>
				<tr>
					<!-- 배송지등록 -->
					<td class="clientPageSubtitle">
						<a href="#" class="a1">ADDRESS</a><br>
						<p><a href="#" class="a2">자주 사용하는 배송지를 등록하고 관리하실 수 있습니다.</a></p>
					</td>
				</tr>
			</table>
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