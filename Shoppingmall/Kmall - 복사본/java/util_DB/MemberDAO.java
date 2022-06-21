package util_DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import vo.MemberVO;

//** DAO(Data Access Object)
//=> SQL 구문 처리
//=> CRUD 구현 
//   Create(insert), Read(select), Update, Detete

@Repository
public class MemberDAO {
	// ** JDBC 맴버변수 정의
	// => DBConnection, Sql구문처리, 결과를 전달받아 출력
	private Connection cn = DBConnection.getConnection(); 
	private Statement st;
	private PreparedStatement pst;
	private ResultSet rs;
	private String sql;
	
	// ** Read
	// => List, Detail
	// 1. memberList
	// => 처리결과(ResultSet) 를 요청클래스로 전달
	// => List 전달에 적합한 객체 필요 : ArrayList
	// => ArrayList 의 Type :  MemberVO
	public List<MemberVO> memberList() {
		 //sql="select * from member order by id asc";  // 순서대로 정렬 asc(기본값)/desc
		 sql= "select CONCAT(RPAD(substr(id,1,1) , length(id) , '*'), ' ', id) id , password , name ,"
		 		   + "CONCAT(lev, IF(lev='A', ' 관리자', IF(lev='B', ' 나무', IF(lev='C', ' 잎새', ' 새싹')))) lev,"
		 		   + "birthd, point, weight from member" ;
		 
		 List<MemberVO> list = new ArrayList<MemberVO>();
		 try {
			 st = cn.createStatement();
			 rs = st.executeQuery(sql);
			 if (rs.next()) {
				// 데이터가 존재하면 list 에 add  
				 do {
					 MemberVO vo = new MemberVO();
					 vo.setId(rs.getString(1));
					 vo.setPassword(rs.getString(2));
					 vo.setName(rs.getString("name"));
					 vo.setLev(rs.getString(4));
					 vo.setBirthd(rs.getString(5));
					 vo.setPoint(rs.getInt(6));
					 vo.setWeight(rs.getDouble(7));
					 list.add(vo);
				 }while(rs.next());
			 }else {
				 System.out.println("** 출력할 데이터가 1건도 없습니다 **");
				 list = null;
			 }
		} catch (Exception e) {
			System.out.println("** memberList Exception => "+e);
			 list = null;
		} //catch
		 return list;
	} //memberList
	
	// 2.  memberDetail
	// => 처리결과(ResultSet) 를 요청클래스로 전달 
	// => 하나의 Row(레코드,튜플) 제공 (MemberVO return)	
	public MemberVO memberDetail(MemberVO vo) {
		sql = "select id, password, name,"
				+ "CONCAT(lev, IF(lev='A', ' 관리자', IF(lev='B', ' 나무', IF(lev='C', ' 잎새', ' 새싹')))) lev,"
		 		+ "birthd, point, weight "
		 		+ "from member where id=?" ;
		try {
			pst=cn.prepareStatement(sql); 
			pst.setString(1, vo.getId());
			rs=pst.executeQuery(); 
			if (rs.next()) {
				vo.setId(rs.getString(1));
				vo.setPassword(rs.getString(2));
				vo.setName(rs.getString("name"));
				vo.setLev(rs.getString(4));
				vo.setBirthd(rs.getString(5));
				vo.setPoint(rs.getInt(6));
				vo.setWeight(rs.getDouble(7));
			}else {
				vo = null;
			}
		} catch (Exception e) {
			System.out.println("** memberDetail Exception => "+e);
			vo = null;
		} //try
		return vo;
	} //memberDetail
	
	// 3. insert
	// => 처리결과(ResultSet) 를 요청클래스로 전달 
	// => 입력성공: 1, 실패: 0
	public int insert(MemberVO vo) {
		sql="insert into member values(?,?,?,?,?,?,?)";
		try {
			pst=cn.prepareStatement(sql);
			pst.setString(1, vo.getId());
			pst.setString(2, vo.getPassword());
			pst.setString(3, vo.getName());
			pst.setString(4, vo.getLev());
			pst.setString(5, vo.getBirthd());
			pst.setInt(6, vo.getPoint());
			pst.setDouble(7, vo.getWeight());
			return pst.executeUpdate();  // int Type return -> 처리된 Data 갯수
		} catch (Exception e) {
			System.out.println("** insert Exception => "+e);
			return 0;
		} //try
	} //insert
	
	// 4. update
	// => name, point, weight 수정
	public int update(MemberVO vo) {
		sql="update member set password=?, name=?, lev=?, birthd=?, point=?, weight=? where id=?";
		try {
			pst=cn.prepareStatement(sql);
			pst.setString(1, vo.getPassword());
			pst.setString(2, vo.getName());
			pst.setString(3, vo.getLev());
			pst.setString(4, vo.getBirthd());
			pst.setInt(5, vo.getPoint());
			pst.setDouble(6, vo.getWeight());
			pst.setString(7, vo.getId());
			return pst.executeUpdate();
		} catch (Exception e) {
			System.out.println("** update Exception => "+e);
			return 0;
		} //try
	} //update
	
	// 5. delete
	// => 삭제대상 : id 로 선택
	public int delete(MemberVO vo) {
		sql="delete from member where id=?";
		try {
			pst=cn.prepareStatement(sql);
			pst.setString(1, vo.getId());
			return pst.executeUpdate();
		} catch (Exception e) {
			System.out.println("** delete Exception => "+e);
			return 0;
		} //try
	} //delete			
	
	
	

} //class
