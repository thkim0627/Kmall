<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ID DUBLE CHECK</title>
<!-- favicon -->
<link rel="shortcut icon" type="image/x-icon" href="resources/favicon/favicon.ico"/>
<!-- css -->
<link rel="stylesheet" type="text/css" href="resources/css/join.css">
<link rel="stylesheet" type="text/css" href="resources/css/idDoubleCheck.css">
<!-- js -->
<script src="resources/js/jquery-3.2.1.min.js"></script>
<script src="resources/js/regularExpression.js"></script>
<script>
// 사용자가 입력한 ID를 중복확인 후 중복되지 않은 ID를 선택하면 현재창이 닫히면서 DOUBLE CHECK 버튼은 disbled, submit 버튼은 enabled로 변경
function idSelect(){
	opener.$('#id').val('${newID}');
	
	// 속성 설정
	// opener.$('#submit').prop('disabled', false);
	// opener.$('#idCheckBtn').prop('disabled', true);
		
	// 아이디가 확정되었으므로 readonly로 변경해서 수정불가하게 한다.
	// opener.$('#id').prop('readonly', true);
	opener.$('#password1').focus();
	
	window.close();
} // idSelect
</script>
</head>
<body>
	<div id="wrap">
		<h4>ID DUBLE CHECK</h4>
		
		<form action="idDoubleCheck" method="get">
			<input type="text" id="id" name="id" placeholder="ID">
			<input type="submit" id="idCheckBtn2" value="DOUBLE CHECK" onclick="return idCheck()">
			<!-- inCheck.js의  idCheck()의 결과에 따라 submit결정-->
			<span id="iMessage" class="eMessage"></span>
		</form>
		
		<!-- 서버의 확인 결과에 따른 처리 영역 
			 idUse가 'T'이면 선택가능, 'F'이면 선택불가능  -->
		<div id="msgBlock">
			<c:if test="${idUse=='T'}">
				<!-- 사용자가 입력한 아이디가 중복되지 않으면 사용가능 하도록 해주고 현재창은 닫는다. -->
				<div class="idCheckMsgBox">
					${newID}(은)는 사용 가능합니다.
					<input type="button" id="idSelectBtn" value="SELECTABLE" onclick="idSelect()">
				</div>
			</c:if>	
			<c:if test="${idUse=='F'}">
				<div class="idCheckMsgBox">${newID}(은)는 사용 불가능합니다.</div>
				
				<!-- 회원가입 페이지에서 사용자가 입력한 아이디는 지워주고 현재창에서는 아이디에 focus를 주고 재입력 유도한다. -->
				<script>
					$('#id').focus();
					opener.document.getElementById('id').value='';
				</script>
			</c:if>
		</div> 
	</div>
</body>
</html>