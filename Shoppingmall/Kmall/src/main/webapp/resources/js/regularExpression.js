/*  작성 규칙은 JavaScript function으로 정의하고 결과를 true or false로 return
	
	사용자입력값의 무결성 확인
	id : 5~20자의 영문 소문자, 숫자와 특수기호 (-), (_)만 사용 가능합니다.
	password1 : 8~16자 영문 대/소문자, 숫자, 특수문자만 사용 가능합니다.
	password2 : 8~16자 영문 대/소문자, 숫자, 특수문자만 사용 가능합니다.
	name : 2~20자의 영문 대/소문자, 한글만 사용가능합니다.
	address : 10~50자의 영문, 한글, 숫자, 특수기호(-)만 사용 가능합니다. 
	number : 010-5840-5084와 같은 형식만 입력가능합니다.
	email : 이메일 형식에 맞는것만 입력가능합니다.  */

// 아이디 정규식
function idCheck() {
	var id = $('#id').val();

	if (id.replace(/^[a-z0-9_-]{5,20}$/, '').length > 0) {
		$('#iMessage').html('5~20자의 영문 소문자, 숫자와 특수기호(_),(-)만 사용 가능합니다.');
		$('#id').focus();
		return false;
	} else if (id.length < 1) {
		$('#iMessage').html('필수 정보입니다.');
		return false;
	} else {
		$('#iMessage').html('');
		return true;
	};
}; //idCheck 

// 비밀번호 정규식
function pw1Check() {
	var password1 = $('#password1').val();

	if (password1.replace(/(?=.*[a-zA-ZS])(?=.*?[#?!@$%^&*-]).{8,16}/, '').length > 0) {
		$('#p1Message').html('8~16자 영문 대/소문자, 숫자, 특수문자만 사용 가능합니다.');
		$('#password1').focus();
		return false;
	} else if (password1.length < 1) {
		$('#p1Message').html('필수 정보입니다.');
		return false;
	} else {
		$('#p1Message').html('');
		return true;
	};
}; // pw1Check

// 비밀번호 확인 정규식
function pw2Check() {
	var password2 = $('#password2').val();

	if (password2.replace(/(?=.*[a-zA-ZS])(?=.*?[#?!@$%^&*-]).{8,16}/, '').length > 0) {
		$('#p2Message').html('8~16자 영문 대/소문자, 숫자, 특수문자만 사용 가능합니다.');
		$('#password2').focus();
		return false;
	} else if (password2.length < 1) {
		$('#p2Message').html('필수 정보입니다.');
		return false;
	} else {
		$('#p2Message').html('');
		return true;
	};
}; // pw2Check

// 이름 정규식
function nameCheck() {
	var name = $('#name').val();

	if (name.replace(/^[가-힣a-zA-Z]{2,20}$/, '').length > 0) {
		$('#nMessage').html('2~20자의 영문 대/소문자, 한글만 사용 가능합니다.');
		$('#name').focus();
		return false;
	} else if (name.length < 1) {
		$('#nMessage').html('필수 정보입니다.');
		return false;
	} else {
		$('#nMessage').html('');
		return true;
	}
}; // nameCheck

// 주소 정규식
function addressCheck() {
	var address = $('#address').val();

	if (address.replace(/^[-.가-힣a-zA-Z0-9. ]{10,50}$/, '').length > 0) {
		$('#aMessage').html('10~50자의 영문, 한글, 숫자, 특수기호(-)만 사용 가능합니다.');
		$('#address').focus();
		return false;
	} else if (address.length < 1) {
		$('#aMessage').html('필수 정보입니다.');
		return false;
	} else {
		$('#aMessage').html('');
		return true;
	}
} // addressCheck

// 핸드폰번호 정규식
function numberCheck() {
	var number = $('#number').val();

	if (number.replace(/^01(?:0|1|[6-9])-(?:\d{3}|\d{4})-\d{4}$/, '').length > 0) {
		$('#hMessage').html('010-5840-5084와 같은 형식만 입력가능합니다.');
		$('#number').focus();
		return false;
	} else if (number.length < 1) {
		$('#hMessage').html('필수 정보입니다.');
		return false;
	} else {
		$('#hMessage').html('');
		return true;
	}
} // numberCheck

// 이메일 정규식
function emailCheck() {
	var email = $('#email').val();

	if (email.replace(/^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/, '').length > 0) {
		$('#eMessage').html('이메일 형식에 맞는것만 입력가능합니다.');
		$('#email').focus();
		return false;
	} else if (email.length < 1) {
		$('#eMessage').html('필수 정보입니다.');
		return false;
	} else {
		$('#eMessage').html('');
		return true;
	}
} // numberCheck