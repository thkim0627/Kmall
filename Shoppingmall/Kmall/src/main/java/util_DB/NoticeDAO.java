package util_DB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import vo.NoticeVO;

@Repository
public class NoticeDAO {
	private Connection cn = DBConnection.getConnection(); 
	private Statement st;
	private PreparedStatement pst;
	private ResultSet rs;
	private String sql ;
	
	// 공지사항
	// 조회
	public List<NoticeVO> noticeList() {
		sql="select * from notice order by seq desc" ;
		List<NoticeVO> list = new ArrayList<NoticeVO>();
		try {
			st = cn.createStatement();
			rs = st.executeQuery(sql);
			// 출력할 자료가 있는지 확인
			if (rs.next()) {
				// ResultSet의 Data를 list에 담기
				do {
					NoticeVO vo = new NoticeVO();
					vo.setSeq(rs.getInt(1));
					vo.setTitle(rs.getString(2));
					vo.setId(rs.getString(3));
					vo.setContent(rs.getString(4));
					vo.setRegdate(rs.getString(5));
					vo.setCnt(rs.getInt(6));
					list.add(vo);
				}while(rs.next());
			}else {
				System.out.println("> 출력할 자료가 없습니다. <");
				list = null;
			}
		} catch (Exception e) {
			System.out.println("> noticeList Exception : " + e.toString());
			list = null;
		}
		return list;
	} // noticeList
	
	// 상세보기
	public NoticeVO noticeOne(NoticeVO vo) {
		sql = "select * from notice where seq=?";
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
				System.out.println("> 글번호에 해당하는 자료가 없습니다. <");
				vo = null;
			}
		} catch (Exception e) {
			System.out.println("> noticeOne Exception : " + e.toString());
			vo = null;
		}
		return vo;
	} // noticeOne

	// 상세보기 - 조회수
	public int countUp(NoticeVO vo) {
		sql="update notice set cnt=cnt+1 where seq=?" ;
		try {
			pst=cn.prepareStatement(sql);
			pst.setInt(1, vo.getSeq());
			return pst.executeUpdate();
		} catch (Exception e) {
			System.out.println("> countUp Exception : " + e.toString());
			return 0;
		}
	} // countUp
	
	// 작성
	public int noticeInsert(NoticeVO vo) {
		sql = "insert into notice(title,id,content) values(?,?,?)" ;
		try {
			pst=cn.prepareStatement(sql);
			pst.setString(1, vo.getTitle());
			pst.setString(2, vo.getId());
			pst.setString(3, vo.getContent());
			return pst.executeUpdate();
		} catch (Exception e) {
			System.out.println("> noticeInsert Exception : " + e.toString());
			return 0;
		}
	} // noticeInsert
	
	// 수정
	public int noticeUpdate(NoticeVO vo) {
		sql = "update notice set title=?, content=? where seq=?" ;
		try {
			pst=cn.prepareStatement(sql);
			pst.setString(1, vo.getTitle());
			pst.setString(2, vo.getContent());
			pst.setInt(3, vo.getSeq());
			return pst.executeUpdate();
		} catch (Exception e) {
			System.out.println("> noticeUpdate Exception : " + e.toString());
			return 0;
		}
	} // noticeUpdate
	
	// 삭제
	public int noticeDelete(NoticeVO vo) {
		sql = "delete from notice where seq=?" ;
		try {
			pst=cn.prepareStatement(sql);
			pst.setInt(1, vo.getSeq());
			return pst.executeUpdate();
		} catch (Exception e) {
			System.out.println("> noticeDelete Exception : " + e.toString());
			return 0;
		}
	} // noticeDelete
	
} // class