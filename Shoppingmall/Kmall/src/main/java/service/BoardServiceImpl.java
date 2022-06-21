package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mapperInterface.BoardMapper;
import vo.BoardVO;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	BoardMapper mapper;
	// BoardDAO dao; 
	// => Mybatis 로 교체 (interface 방식)
	// => interface BoardMapper 를 통해서 
	//    BoardMapper.xml 의 SQL 구문 접근  
	
	@Override //Ajax_id_BoardList
	public List<BoardVO> aidBList(BoardVO vo) {
		return mapper.aidBList(vo);
	}
	
	@Override
	public List<BoardVO> selectList() {
		return mapper.selectList();
	} //selectList
	
	@Override
	public BoardVO selectOne(BoardVO vo) {
		return mapper.selectOne(vo);
	} //selectOne
	
	@Override
	public int countUp(BoardVO vo) {
		return mapper.countUp(vo);
	}
	
	@Override
	public int insert(BoardVO vo) {
		return mapper.insert(vo);
	}
	@Override
	public int update(BoardVO vo) {
		return mapper.update(vo);
	}
	@Override
	public int delete(BoardVO vo) {
		return mapper.delete(vo);
	}
	
} //class
