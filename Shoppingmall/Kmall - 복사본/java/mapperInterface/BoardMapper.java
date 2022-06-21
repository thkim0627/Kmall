package mapperInterface;

import java.util.List;

import vo.BoardVO;

public interface BoardMapper {
	
	List<BoardVO> aidBList(BoardVO vo); //Ajax_id_BoardList
	
	List<BoardVO> selectList();
	BoardVO selectOne(BoardVO vo);
	int countUp(BoardVO vo);
	int insert(BoardVO vo);
	int update(BoardVO vo);
	int delete(BoardVO vo);

} //interface
