// 2.홈페이지 메인이미지 영역 (메인이미지 자동/수동 슬라이딩 효과)
var div_length = $("#slideBox>div").length; // slideBox에서 div의 length값 가져오기
var srt = 0;
var idx = 0;

// #slide_imgDotCont 메인이미지 수동 슬라이드 버튼 클릭 이벤트
$("section>a").click(function() {
	idx = $(this).index();
	srt = idx;
	$(this).addClass("slideHomeImgON").siblings().removeClass("slideHomeImgON");
	$("#slideBox>div").eq(idx).addClass("slideHomeImgON").siblings().removeClass("slideHomeImgON");
}); // section>a_click

// slideBox 메인이미지 자동 슬라이드
var slide_auto = setInterval(slide_autoRun, 5000);

function slide_autoRun() {
	srt++;

	if (srt == div_length) {
		srt = 0;
	} // if

	$("section>a").eq(srt).addClass("slideHomeImgON").siblings().removeClass("slideHomeImgON");
	$("#slideBox>div").eq(srt).addClass("slideHomeImgON").siblings().removeClass("slideHomeImgON");
} // slide_autoRun