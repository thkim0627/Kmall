/**
 *  Ajax Board Test
 => jsonView 활용
 */
// Test 1. 타이틀 클릭하면, 하단(resultArea2)에 글 내용 출력하기
function jsBDetail1(seq) {
	$.ajax({
		type:'Get',
		url: 'jsbdetail?seq='+seq,
		/*data: { seq:seq },*/
		success:function(resultData){
			$('#resultArea2').html(resultData.content);
		},
		error:function(){
			alert('~~ 서버오류 !! 잠시후 다시 하세요 ~~');
		}
	}); //ajax
	
} //jsBDetail1

// Test 2. 타이틀 클릭하면, 글목록의 아랫쪽(span)에 글 내용 출력하기
// => Toggle 방식으로 없을때 클릭하면 표시되고, 있을때 클릭하면 사라지도록 
// => 이벤트 객체 전달 Test (이벤트 리스너 함수의 첫 번째 매개변수에 전달) 
function jsBDetail2(e, seq, count) {
	
	console.log('** e.type => '+e.type);
	console.log('** e.target => '+e.target);
	
	if ( $('#'+count).html()=='' ) {
	// 글이 없을때만 Ajax 로 가져오면됨	
		$.ajax({
			type:'Get',
			url: 'jsbdetail?seq='+seq,
			success:function(resultData){
				$('#resultArea2').html('');
				$('.content').html('');
				$('#'+count).html(resultData.content);
			},
			error:function(){
				alert('~~ 서버오류 !! 잠시후 다시 하세요 ~~');
			}
		}); //ajax
	}else $('#'+count).html(''); // 글이 있을때는 clear
	
} //jsBDetail2

// Test 3. seq 에 마우스 오버시에 별도의 DIV에 글내용 표시 되도록 하기 
// => jQuery : id, class, this
// => hover(f1, f2)

$(function(){
	// 3.1) css, display 속성 활용 
	$('.sss1').hover(function(e){
			// ** seq확인, ajax content 읽어오기, div에 출력(마우스 위치필요)
			// => 마우스 위치필요 : event객체 (이벤트핸들러 첫번째 매개변수) 가 제공 
			// 1) 마우스포인터 위치인식
			// => e.pageX, e.pageY : 전체 Page 기준
        	// => e.clientX, e.clientY : 보여지는 화면 기준-> page Scroll 시에 불편함
			var mleft=e.pageX;
			var mtop=e.pageY;
			
			// 2) seq 확인
			var seq=$(this).attr('id');
			
			// 3) Ajax
			$.ajax({
				type:'Get',
				url: 'jsbdetail?seq='+seq,
				success:function(resultData){
					$('.content').html('');
					$('#content').html(resultData.content)
					.css({
						/*div 를 위치 지정해서 표시*/ 
						display:'block',
						left:mleft,
						top:mtop
					});
				},
				error:function(){
					alert('~~ 서버오류 !! 잠시후 다시 하세요 ~~');
				}
			}); //ajax
			return false; // 이벤트 Propagation(전달) 방지
		}, function(){
			$('.content').html('');
			$('#content').css('display','none');
			return false; // 이벤트 Propagation(전달) 방지
		}); //sss1_hover
		
	// 3.2) JQ 메서드 show() , hide() 활용 
	$('.sss2').hover(function(e){
		
		var mleft=e.pageX;
		var mtop=e.pageY;
		var seq=$(this).attr('id');
		
		console.log('** e.pageX, e.pageY => '+e.pageX+' , '+ e.pageY);
		console.log('** e.clientX, e.clientY => '+e.clientX+' , '+ e.clientY);
		// ** 이벤트 Propagation(전달) Test
		// => console.log 여러번 찍히는것을 확인
		// => return false; 추가 전후 비교해봄.
		//    axTestForm.jsp 에도 axTest03.js 추가후 Test
		
		// ** 아래 2 출력 비교해보세요 ~~
		//console.log('** e.target => '+e.target);
		//console.log(e.target); 
		
		$.ajax({
			type:'Get',
			url: 'jsbdetail?seq='+seq,
			success:function(resultData){
				$('.content').html('');
				$('#content').html(resultData.content)
				.css({
					/* 
					display:'block',
					=> show() , hide() 메서드로 처리  */ 
					left:mleft,
					top:mtop
				}).show();
			},
			error:function(){
				alert('~~ 서버오류 !! 잠시후 다시 하세요 ~~');
			}
		}); //ajax
		return false; // 이벤트 Propagation(전달) 방지
	}, function(){
		$('.content').html('');
		$('#content').hide();
		return false; // 이벤트 Propagation(전달) 방지
	}); //sss2_hover
	
}); //ready

/*
 * * JQ 로 이벤트 핸들러 작성시 주의 사항 
=> jQuery 로 이벤트를 처리하기 위해 지금처럼 ready 이벤트를 사용하는 경우
   본구문이 포함된 axTest03.js 를 부모창에도 추가하고, 
   결과로 불리워지는 axBoardList.jsp 에도 포함 하게되면
   마치 callBack 함수처럼 실행 할 때마다 이중으로 불리워지면서
   2의 자승으로 늘어나게 됨. 
=> 해결방법
  1) ~.js 를 각각 분리한다. 
  -> $('#jlogin').click( .....) 부분 axTest04.js 로 독립 
  2) JS의 함수 방식 으로 이벤트 처리
  
** ** 이벤트 전달
=> Tag 들이 겹겹이 포함관계에 있을때 이벤트가 전달되어 여러번 발생가능함. 
=> 이것을 이벤트 Propagation(전파) 이라함.
=> 해결 : return false
  		-> e.preventDefault() + e.stopPropagation()

** ** JS & JQ 에서 익명함수의 매개변수역할 
=> 이벤트 핸들러 의 첫 매개변수 : 이벤트 객체를 전달 
=> ajax 메서드의 success 속성 : 서버의 response 결과 
=> css 속성값 : 0부터 순차적으로 대입됨 (jq03_attr.html 참고)

 */







