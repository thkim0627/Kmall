package util_DB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import vo.BoardVO;

// ** JDBC 처리
// => C R U D 

@Repository
public class BoardDAO {
	private Connection cn = DBConnection.getConnection(); 
	private Statement st;
	private PreparedStatement pst;
	private ResultSet rs;
	private String sql ;
	
	// ** selectList
	public List<BoardVO> selectList() {
		sql="select * from board order by seq desc" ;
		List<BoardVO> list = new ArrayList<BoardVO>();
		try {
			st = cn.createStatement();
			rs = st.executeQuery(sql);
			// 출력 record 가 있는지 확인
			if (rs.next()) {
				// ResultSet 의 Data -> list 에 담기
				do {
					BoardVO vo = new BoardVO();
					vo.setSeq(rs.getInt(1));
					vo.setTitle(rs.getString(2));
					vo.setId(rs.getString(3));
					vo.setContent(rs.getString(4));
					vo.setRegdate(rs.getString(5));
					vo.setCnt(rs.getInt(6));
					list.add(vo);
				}while(rs.next());
			}else {
				System.out.println("** 출력할 자료가 1개도 없습니다. **");
				list = null;
			}
		} catch (Exception e) {
			System.out.println("** selectList Exception => "+e.toString());
			list = null;
		}
		return list;
	} //selectList
	
	public BoardVO selectOne(BoardVO vo) {
		sql = "select * from board where seq=?";
		try {
			pst = cn.prepareStatement(sql);
			pst.setInt(1, vo.getSeq());
			rs = pst.executeQuery();
			if (rs.next()) {
				vo.setSeq(rs.getInt(1));
				vo.setTitle(rs.getString(2));
				vo.setId(rs.getString(3));
				vo.setContent(rs.getString(4));
				vo.setRegdate(rs.getString(5));
				vo.setCnt(rs.getInt(6));
			}else {
				System.out.println("** 글번호에 해당하는 글이 없습니다 **");
				vo=null;
			}
		} catch (Exception e) {
			System.out.println("** selectOne Exception => "+e.toString());
			vo=null;
		}
		return vo;
	} //selectOne

	// 조회수 증가 메서드 작성
	public int countUp(BoardVO vo) {
		// 조회수 증가 Sql 처리
		sql="update board set cnt=cnt+1 where seq=?" ;
		try {
			pst=cn.prepareStatement(sql);
			pst.setInt(1, vo.getSeq());
			return pst.executeUpdate();
		} catch (Exception e) {
			System.out.println("** countUp Exception => "+e.toString());
			return 0;
		}
	} //countUp
	
	public int insert(BoardVO vo) {
		sql = "insert into board(title,id,content) values(?,?,?)" ;
		try {
			pst=cn.prepareStatement(sql);
			pst.setString(1, vo.getTitle());
			pst.setString(2, vo.getId());
			pst.setString(3, vo.getContent());
			return pst.executeUpdate();
		} catch (Exception e) {
			System.out.println("** Board insert Exception => "+e.toString());
			return 0;
		}
	} //insert
	
	public int update(BoardVO vo) {
		sql = "update board set title=?, content=? where seq=?" ;
		try {
			pst=cn.prepareStatement(sql);
			pst.setString(1, vo.getTitle());
			pst.setString(2, vo.getContent());
			pst.setInt(3, vo.getSeq());
			return pst.executeUpdate();
		} catch (Exception e) {
			System.out.println("** Board update Exception => "+e.toString());
			return 0;
		}
	} //update
	
	public int delete(BoardVO vo) {
		sql = "delete from board where seq=?" ;
		try {
			pst=cn.prepareStatement(sql);
			pst.setInt(1, vo.getSeq());
			return pst.executeUpdate();
		} catch (Exception e) {
			System.out.println("** Board delete Exception => "+e.toString());
			return 0;
		}
	} //delete
	
} //class
