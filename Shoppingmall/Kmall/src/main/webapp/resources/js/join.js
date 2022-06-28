// 전역변수 선언
// 개별적 오류 확인을 위한 스위치변수
var iCheck = false; // 아이디 
var p1Check = false; // 비밀번호
var p2Check = false; // 비밀번호 확인
var nCheck = false; // 이름
var aCheck = false; // 주소
var hCheck = false; // 핸드폰번호
var eCheck = false; // 이메일

// 아이디 중복확인
// 중복확인 전 : submit은 disabled 
// 중복확인 후 : enabled하고 동시에 idDup버튼은 disabled  
function idDoubleCheck() {
	// ID 무결성 확인
	if (iCheck == false) {
		iCheck = idCheck();	
	} else {
		// 서버로 확인요청 보내고 결과는 새창으로 처리한다.
		var url = 'idDoubleCheck?id='+$('#id').val();  // idDoubleCheck?id=newid 
		window.open(url, '_blank', 'toolbar=no, menubar=yes, scrollbars=yes, resizable=yes, left=550, top=150, width=400, height=300');
	}
}; // idDoubleCheck



// 개별적 focusout 이벤트 핸들러
$(function(){

	// 비밀번호 일치확인
	$('.password').keyup(function() {
		var password1 = $('#password1').val();
		var password2 = $('#password2').val();
		
		if (password1 != '' || password2 != '') {
			if(password1 == password2) {
				$('#p2Message').html('비밀번호가 일치합니다.');
				$('#p2Message').css('color', 'green');
			} else {
				$('#p2Message').html('비밀번호가 일치하지 않습니다.');
				$('#p2Message').css('color', 'red');
			}
		}
		
	});
	
	
//	$('#id').focus();
	
	//아이디
	$('#id').keydown(function(e){
		if (e.which == 13) {
			// => 회원가입 폼에 submit이 있는경우 enter 누르면 submit 발생되므로 이를 제거함
			e.preventDefault();
			$('#password1').focus();
	}
	}).focusout(function(){
		iCheck = idCheck();
	}); // 아이디
	
	// 비밀번호
	$('#password1').keydown(function(e){
		if (e.which == 13) {
			e.preventDefault();
			$('#password2').focus();
	}
	}).focusout(function(){
		p1Check = pw1Check();
	}); // 비밀번호
	
	// 비밀번호 확인
	$('#password2').keydown(function(e){
		if (e.which == 13) {
			e.preventDefault();
			$('#name').focus();
	}
	}).focusout(function(){
		p2Check = pw2Check();
	}); // 비밀번호 확인 
	
	// 이름
	$('#name').keydown(function(e){
		if (e.which == 13) {
			e.preventDefault();
			$('#address').focus();
		}
	}).focusout(function(){
		nCheck = nameCheck();
	}); // 이름
	
	// 주소
	$('#address').keydown(function(e){
		if (e.which == 13) {
			e.preventDefault();
			$('#number').focus();
		}
	}).focusout(function(){
		aCheck = addressCheck();
	}); // 주소
	
	// 핸드폰번호
	$('#number').keydown(function(e){
		if (e.which == 13) {
			e.preventDefault();
			$('#email').focus();
		}
	}).focusout(function(){
		hCheck = numberCheck();
	}); // 핸드폰번호
	
	// 이메일
	$('#email').keydown(function(e){
		if (e.which == 13) {
			e.preventDefault();
			$('#submit').focus();
		}
	}).focusout(function(){
		eCheck = emailCheck();
	}); // 이메일
	
}); //ready

// SINGUP 버튼을 눌렀을때 잘못 기입된 부분이 있으면 안내메세지 출력
function inCheck() {
	if (iCheck == false) { $('#iMessage').html('필수 정보입니다.'); }
	if (p1Check == false) { $('#p1Message').html('필수 정보입니다.'); }
	if (p2Check == false) { $('#p2Message').html('필수 정보입니다.'); }
	if (nCheck == false) { $('#nMessage').html('필수 정보입니다.'); }
	if (aCheck == false) { $('#aMessage').html('필수 정보입니다.'); }
	if (hCheck == false) { $('#hMessage').html('필수 정보입니다.'); }
	if (eCheck == false) { $('#eMessage').html('필수 정보입니다.'); }
	
	if (iCheck && p1Check && p2Check && nCheck && aCheck && hCheck && eCheck) {
		if (confirm("정말 가입하시겠습니까?") == false) {
			  alert('가입이 취소되었습니다.');
			  return false; 
		} else return true;
	} else return false;
} //inCheck()