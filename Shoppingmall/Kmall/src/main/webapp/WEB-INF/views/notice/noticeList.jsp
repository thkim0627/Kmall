<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Kmall - 공지사항</title>
<!-- favicon -->
<link rel="shortcut icon" type="image/x-icon" href="resources/favicon/favicon.ico"/>
<!-- css -->
<link rel="stylesheet" type="text/css" href="resources/css/home.css">
<link rel="stylesheet" type="text/css" href="resources/css/noticeList.css">
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
	
	<!-- 공지사항 -->
	<main>
		<table id="noticeTableBox">
			<!-- 제목 -->
			<caption id="noticeTitle">NOTICE</caption>
			<!-- 리스트 - 검색 -->
			<div class="search_wrap">
				<div class="search_area">
					<select name="type" id="type">
		                <option value="" <c:out value="${pageMaker.cri.type == null?'selected':'' }"/>>선택</option>
		                <option value="T" <c:out value="${pageMaker.cri.type eq 'T'?'selected':'' }"/>>제목</option>
		                <option value="C" <c:out value="${pageMaker.cri.type eq 'C'?'selected':'' }"/>>내용</option>
		                <option value="W" <c:out value="${pageMaker.cri.type eq 'W'?'selected':'' }"/>>작성자</option>
            		</select>   
					<input type="text" name="keyword" id="keyword" value="${pageMaker.cri.keyword}">
					<button id="searchBtn">SEARCH</button>
				</div>
			</div>
			<!-- 부제목 -->
			<thead>
				<tr>
					<th class="no">NO</th>
					<th class="title">TITLE</th>
<!-- 					<th class="contents">CONTENT</th> -->
					<th class="writer">WRITER</th>
					<th class="createddate">CERATED DATE</th>
					<th class="views">VIEWS</th>
				</tr>
			</thead>
			<!-- 내용 -->
			<tbody>
				<c:if test="${not empty notice}">
					<c:forEach var="notice" items="${notice}">
						<tr>
							<td class="no">${notice.seq}</td>
							<td class="title"><a href="noticedetail?seq=${notice.seq}">${notice.title}</a></td>
<%-- 							<td class="contents"><a href="noticedetail?seq=${notice.seq}">${notice.content}</a></td> --%>
							<td class="writer">${notice.id}</td>
							<td class="createddate">${notice.regdate}</td>
							<td class="views">${notice.cnt}</td>
						</tr>
					</c:forEach>
				</c:if>
				<!-- NOTICE에서 관리자인 경움만 글쓰기 가능 -->
				<c:if test="${LoginID=='admin'}">
					<td id="none"><a href="noticeinsertf" id="writingBtn">WRITING</a></td>
				</c:if>
			</tbody>
		</table>

		<!-- 리스트 - 페이징 -->
		<div class="pageInfo_wrap" id="pageInfo_wrap">
			<div class="pageInfo_area">
				<ul id="pageInfo" class="pageInfo">
					<!-- 이전페이지 버튼 -->
					<c:if test="${pageMaker.prev}">
						<li class="pageInfo_btn previous"><a href="${pageMaker.startPage-1}">◀</a></li>
					</c:if>
					<!-- 각 번호 페이지 버튼 -->
					<c:forEach var="num" begin="${pageMaker.startPage}" end="${pageMaker.endPage}">
						<li class="pageInfo_btn ${pageMaker.cri.pageNum == num ? "active":"" }"><a href="${num}">${num}</a></li>
					</c:forEach>
					<!-- 다음페이지 버튼 -->
					<c:if test="${pageMaker.next}">
						<li class="pageInfo_btn next"><a href="${pageMaker.endPage + 1}">▶</a></li>
					</c:if>
				</ul>
			</div>
		</div>

		<form id="moveForm" method="get">
			<input type="hidden" name="pageNum" value="${pageMaker.cri.pageNum}">
			<input type="hidden" name="amount" value="${pageMaker.cri.amount}">
			<input type="hidden" name="keyword" value="${pageMaker.cri.keyword}">
			<input type="hidden" name="type" value="${pageMaker.cri.type}">
		</form>
		
		<script>
			let moveForm = $("#moveForm");
			
			// 리스트 - 페이징
			$(".pageInfo a").on("click", function(e){
		        e.preventDefault();
		        moveForm.find("input[name='pageNum']").val($(this).attr("href"));
		        moveForm.attr("action", "noticelist");
		        moveForm.submit();
		        
		    });
			
			
			// 리스트 - 검색
			$(".search_area button").on("click", function(e) {
				e.preventDefault();

				let type = $(".search_area select").val();
				let keyword = $(".search_area input[name='keyword']").val();

				if (!type) {
					alert("검색 종류를 선택해주세요.");
					return false;
				}

				if (!keyword) {
					alert("검색 키워드를 입력해주세요.");
					return false;
				}

				moveForm.find("input[name='type']").val(type);
				moveForm.find("input[name='keyword']").val(keyword);
				moveForm.find("input[name='pageNum']").val(1);
				moveForm.submit();
			});
		</script>
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