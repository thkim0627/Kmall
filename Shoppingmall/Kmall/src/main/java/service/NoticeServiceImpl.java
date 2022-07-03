package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mapperInterface.NoticeMapper;
import vo.NoticeVO;

@Service
public class NoticeServiceImpl implements NoticeService {
	
	@Autowired
	NoticeMapper mapper;
	
	// 공지사항
	// 조회
	@Override
	public List<NoticeVO> noticeList() {
		return mapper.noticeList();
	} 
	
	// 조회 - 페이징
	
	// 상세보기
	@Override
	public NoticeVO noticeOne(NoticeVO vo) {
		return mapper.noticeOne(vo);
	} 
	
	// 상세보기 - 조회수
	@Override
	public int countUp(NoticeVO vo) {
		return mapper.countUp(vo);
	}
	
	// 작성
	@Override
	public int noticeInsert(NoticeVO vo) {
		return mapper.noticeInsert(vo);
	}
	
	// 수정
	@Override
	public int noticeUpdate(NoticeVO vo) {
		return mapper.noticeUpdate(vo);
	}
	
	// 삭제 
	@Override
	public int noticeDelete(NoticeVO vo) {
		return mapper.noticeDelete(vo);
	}
	
} //class