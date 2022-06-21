package service;

import java.util.List;

import vo.BoardVO;

public interface BoardService {

	List<BoardVO> aidBList(BoardVO vo); //Ajax_id_BoardList
	
	List<BoardVO> selectList(); //selectList
	BoardVO selectOne(BoardVO vo); //selectOne
	int countUp(BoardVO vo);

	int insert(BoardVO vo);
	int update(BoardVO vo);
	int delete(BoardVO vo);

} //class