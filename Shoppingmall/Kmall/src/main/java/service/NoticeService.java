package service;

import java.util.List;

import criteria.Criteria;
import vo.NoticeVO;

public interface NoticeService {

	// 공지사항
	// 조회
	List<NoticeVO> noticeList();
	
	// 조회 - 페이징
	List<NoticeVO> noticeListPaging(Criteria cri);
	
	// 게시물 총 페이지수
	public int noticeTotal();
	
	// 상세보기
	NoticeVO noticeOne(NoticeVO vo);

	// 상세보기 - 조회수
	int countUp(NoticeVO vo);

	// 작성
	int noticeInsert(NoticeVO vo);

	// 수정
	int noticeUpdate(NoticeVO vo);

	// 삭제
	int noticeDelete(NoticeVO vo);

} // class