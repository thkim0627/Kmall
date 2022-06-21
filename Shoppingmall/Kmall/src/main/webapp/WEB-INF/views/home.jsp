<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="UTF-8">
<!-- 0-0. viewport -->
<meta name="viewport" content="width=device-width, initail-scale=1">
<title>Kmall 공식 온라인 스토어</title>
<!-- 0-1.favicon -->
<link rel="shortcut icon" type="image/x-icon" href="resources/favicon/favicon.ico"/>
<!-- 0-2.css -->
<link rel="stylesheet" type="text/css" href="resources/css/home.css">
<!-- 0-3.jqeury -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
	<header></header>
	
	<!-- 1.홈페이지 네비게이션바 영역 -->
	<nav> 
		<div id="navbarBox"> 
	        <!-- 1-1.네비게이션 쇼핑메뉴영역 -->
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
			<!-- 1-2.네비게이션 로고영역 -->
	        <div id="navbarLogo">
	            <h1><a href="home">Kmall</a></h1>
	        </div>
			<!-- 1-3.네비게이션 회원메뉴 영역 -->
	        <div id="memberMenuBox">
		        <ul id="memberMenu">
		        	<li>
						<!-- 로그인 전 표시 메뉴 -->
						<c:if test="${empty LoginID}">
							<li><a href="loginf">LOGIN</a></li>
							<li><a href="joinf">JOIN</a></li>
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
    
	
	<main> 
		<!-- 2.홈페이지 메인이미지 영역 -->
		<section> 
			<div id="slideBox">
				<!-- 메인이미지1 -->
				<div class="slideHomeImgON">
					<a href="#"><img class="slideHomeImg" src="https://i.pinimg.com/originals/07/5f/3e/075f3ee72f718f5fe63e0982d2bd221f.jpg"></a>
				</div>
				<!-- 메인이미지2 -->
				<div>
					<a href="#"><img class="slideHomeImg" src="https://www.charleskeith.com/on/demandware.static/-/Library-Sites-CharlesKeith/default/dw8d6941cd/images/ambassadorPage/charles-keith-duel-bottom-banner-1000x666.jpg"></a>
				</div>
				<!-- 메인이미지3 -->
				<div>
					<a href="#"><img class="slideHomeImg" src="https://www.charleskeith.co.uk/on/demandware.static/-/Library-Sites-CharlesKeithEU/default/dw1b60733c/images/megamenu/2022/charles-keith-third-mega-menu-week-11-boots-1000x667.jpg"></a>
				</div>
				<!-- 메인이미지 수동 슬라이드 버튼 -->
				<section id="slideImgDotCont">
					<a class="slideHomeImgON" href="#"></a> 
					<a href="#"></a> 
					<a href="#"></a>
				</section>
			</div>
		</section>
		
		<!-- 3.홈페이지 신상품 노출 영역 -->
		<section>
			<div id="goodsCont">
				<!-- 신상품 제목 -->
				<div class="goodsTitle">
					<h2><span>NEW PRODUCT</span></h2>
				</div>
				<!-- 신상품 목록1 -->	
				<ul id="goodsList">
					<li class="homeGoods">
						<!-- 이미지1 영역 -->
						<div>
							<a href="#"><img src="https://www.succoluxury.com/wp-content/uploads/2022/01/SUCCOFW212215436-650x1200.jpg"></a>
						</div>
						<!-- 텍스트 영역 -->
						<div class="homeGoodsTextBox">
							<span>THE CROPPED CARDIGAN</span><br>
							<span style="color: red;">91,700원</span>
						</div>
					</li>
					<li class="homeGoods">
						<!-- 이미지2 영역 -->
						<div>
							<a href="#"><img src="https://www.succoluxury.com/wp-content/uploads/2021/12/SUCCOFW212215462-650x1200.jpg"></a>
						</div>
						<!-- 텍스트 영역 -->
						<div class="homeGoodsTextBox">
							<span>THE CROPPED CARDIGAN</span><br>
							<span style="color: red;">83,800원</span>
						</div>
					</li>
					<li class="homeGoods">
						<!-- 이미지3 영역 -->
						<div>
							<a href="#"><img src="https://www.succoluxury.com/wp-content/uploads/2021/12/SUCCOFW212215207-650x1200.jpg"></a>
						</div>
						<!-- 텍스트 영역 -->
						<div class="homeGoodsTextBox">
							<span>THE KNITTED HOODIE</span><br>
							<span style="color: red;">83,600원</span>
						</div>
					</li>
					<li class="homeGoods">
						<!-- 이미지4 영역 -->
						<div>
							<a href="#"><img src="https://www.succoluxury.com/wp-content/uploads/2021/12/SUCCOFW212215105-650x1200.jpg"></a>
						</div>
						<!-- 텍스트 영역 -->
						<div class="homeGoodsTextBox">
							<span>THE KNITTED HOODIE</span><br>
							<span style="color: red;">80,700원</span>
						</div>
					</li>
				</ul>
				<!-- 신상품 목록2 -->	
				<ul id="goodsList">
					<li class="homeGoods">
						<!-- 이미지1 영역 -->
						<div>
							<a href="#"><img src="https://www.succoluxury.com/wp-content/uploads/2021/11/SUCCOFW212215747-1-650x1200.jpg"></a>
						</div>
						<!-- 텍스트 영역 -->
						<div class="homeGoodsTextBox">
							<span>THE BOTANICAL SWEATPANTS</span><br>
							<span style="color: red;">70,100원</span>
						</div>
					</li>
					<li class="homeGoods">
						<!-- 이미지2 영역 -->
						<div>
							<a href="#"><img src="https://www.succoluxury.com/wp-content/uploads/2021/11/SUCCOFW212215654-copy-650x1200.jpg"></a>
						</div>
						<!-- 텍스트 영역 -->
						<div class="homeGoodsTextBox">
							<span>THE BOTANICAL HOODIE</span><br>
							<span style="color: red;">76,900원</span>
						</div>
					</li>
					<li class="homeGoods">
						<!-- 이미지3 영역 -->
						<div>
							<a href="#"><img src="https://www.succoluxury.com/wp-content/uploads/2021/11/SUCCOFW212215754-650x1200.jpg"></a>
						</div>
						<!-- 텍스트 영역 -->
						<div class="homeGoodsTextBox">
							<span>THE BOTANICAL HOODIE</span><br>
							<span style="color: red;">76,800원</span>
						</div>
					</li>
					<li class="homeGoods">
						<!-- 이미지4 영역 -->
						<div>
							<a href="#"><img src="https://www.succoluxury.com/wp-content/uploads/2021/11/SUCCOFW212215760-650x1200.jpg"></a>
						</div>
						<!-- 텍스트 영역 -->
						<div class="homeGoodsTextBox">
							<span>THE BOTANICAL SWEATPANTS</span><br>
							<span style="color: red;">72,500원</span>
						</div>
					</li>
				</ul>
			</div>
		</section>
		
		<!-- 4.홈페이지 추천상품 노출 영역 -->
		<section>
			<div id="goodsCont2">
				<!-- 추천상품 목록1 -->
				<ul id="goodsList2">
					<!-- 이미지영역1 -->
					<li class="homeGoods2">
						<div>
							<a href="#"><img src="https://www.succoluxury.com/wp-content/uploads/2021/03/succo_1821_white_f2-1.jpg"></a>
						</div>
					</li>
					<!-- 이미지영역2 -->
					<li class="homeGoods2">
						<div>
							<a href="#"><img src="https://www.succoluxury.com/wp-content/uploads/2021/03/succo_1821_white_m2-2.jpg"></a>
						</div>
					</li>
				</ul>
			</div>
		</section>
	</main>
	
	<!-- 5.홈페이지 푸터 콘텐츠 영역 -->
	<footer>
		<div id="homeFooterHR"></div>
		<div id="homeFooterCont">
			<!-- 고객센터 정보영역 -->
			<div class="homeFooterBox" style="margin-left: 0.2rem;">
				<div class="footerTitle" style="margin-bottom: 1.1rem;"><h2><span>CS CENTER</span></h2></div>
				<ul class="homeFooterUL">
					<li class="footerContents" style="font-size: 1.7rem; font-weight: bold; margin-bottom: 1.2rem;">010-5840-5084</li>
					<li class="footerContents">thkim_o@daum.net</li>
					<li class="footerContents">AM 09:00 ~ PM 17:00</li>
				</ul>
			</div>
			<!-- 은행 정보영역 -->
			<div class="homeFooterBox" style="margin-left: 1rem;">
				<div class="footerTitle" style="margin-top: 3rem;"><h2><span>BANK INFO</span></h2></div>
				<ul class="homeFooterUL">
					<li class="footerContents">KB 국민 : 000000-00-000000</li>
					<li class="footerContents">KEB 하나 : 000-000000-00000</li>
					<li class="footerContents">IBK 기업 : 000-000000-00-000</li>
					<li class="footerContents">예금주 : (주)케이몰</li>
				</ul>
			</div>
			<!-- 정책 정보영역 -->
			<div class="homeFooterBox" style="margin-left: -0.5rem;">
				<div class="footerTitle" style="margin-bottom: 1.3rem;"><h2><span>POLICY</span></h2></div>
				<ul class="homeFooterUL">
					<li class="footerContents"><a class="footerPolicyA" href="#">FAQ</a></li>
					<li class="footerContents"><a class="footerPolicyA" href="#">AGREEMENT</a></li>
					<li class="footerContents"><a class="footerPolicyA" href="#">GUIDE</a></li>
					<li class="footerContents"><a class="footerPolicyA" href="#">PRIVACY</a></li>
				</ul>
			</div>
			<!-- 회사 정보영역 -->
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