package util_DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import vo.ClientVO;

//DAO(Data Access Object) : SQL 구문 처리, C(create)R(read)U(update)D(delete) 구현 

@Repository
public class ClientDAO {

	// JDBC 맴버변수 선언
	// Database 연결 및 Sql구문 처리 후 결과를 전달받아 출력
	private Connection cn = DBConnection.getConnection();
	private Statement st;
	private PreparedStatement pst;
	private ResultSet rs;
	private String sql;
	
	// 1.회원조회
	public List<ClientVO> selectClientList() {
		 sql= "select id, password1, password2, name, address, number, email from client";
		 
		 List<ClientVO> list = new ArrayList<ClientVO>();
		 try {
			 st = cn.createStatement();
			 rs = st.executeQuery(sql);
			 if (rs.next()) {
				// 데이터가 존재하면 list에 add  
				 do {
					 ClientVO vo = new ClientVO();
					 vo.setId(rs.getString(1));
					 vo.setPassword1(rs.getString(2));
					 vo.setPassword2(rs.getString(3));
					 vo.setName(rs.getString("name"));
					 vo.setAddress(rs.getString(5));
					 vo.setNumber(rs.getString(6));
					 vo.setEmail(rs.getString(7));
					 list.add(vo);
				 }while(rs.next());
			 }else {
				 list = null;
			 }
		} catch (Exception e) {
			System.out.println("> 회원조회 Exception : " + e);
			 list = null;
		}
		 return list;
	} // selectClientList
	
	// 2.로그인 + 회원페이지
	public ClientVO selectClientOne(ClientVO vo) {
		sql = "select id, password1, password2, name, address, number, email from client where id=?";
		try {
			pst = cn.prepareStatement(sql);
			pst.setString(1, vo.getId());
			rs = pst.executeQuery();
			if (rs.next()) {
				vo.setId(rs.getString(1));
				vo.setPassword1(rs.getString(2));
				vo.setPassword2(rs.getString(3));
				vo.setName(rs.getString("name"));
				vo.setAddress(rs.getString(5));
				vo.setNumber(rs.getString(6));
				vo.setEmail(rs.getString(7));
			} else {
				vo = null;
			}
		} catch (Exception e) {
			System.out.println("> 로그인 + 회원페이지 Exception : " + e);
			vo = null;
		}
		return vo;
	} // selectClientOne
	
	// 3.회원가입
	// 처리결과(ResultSet)를 요청클래스로 전달
	// 입력성공: 1, 실패: 0
	public int insertClient(ClientVO vo) {
		sql = "insert into client values(?, ?, ?, ?, ?, ?, ?)";
		
		try {
			pst = cn.prepareStatement(sql);
			pst.setString(1, vo.getId());
			pst.setString(2, vo.getPassword1());
			pst.setString(3, vo.getPassword2());
			pst.setString(4, vo.getName());
			pst.setString(5, vo.getAddress());
			pst.setString(6, vo.getNumber());
			pst.setString(7, vo.getEmail());
			return pst.executeUpdate();
		} catch (Exception e) {
			System.out.println("> 회원가입 Exception : " + e);
			return 0;
		} 
	} // insertJoin
	
	// 4. 회원정보 수정
	public int updateClient(ClientVO vo) {
		sql = "update client set password1=?, password2=?, address=?, number=?, email=? where id=?";

		try {
			pst = cn.prepareStatement(sql);
			pst.setString(1, vo.getPassword1());
			pst.setString(2, vo.getPassword2());
			pst.setString(3, vo.getAddress());
			pst.setString(4, vo.getNumber());
			pst.setString(5, vo.getEmail());
			return pst.executeUpdate();
		} catch (Exception e) {
			System.out.println("> 회원정보 수정 Exception : " + e);
			return 0;
		}
	} // updateClient
	
	// 5.회원정보 삭제
	// 삭제대상은 id로 선택
	public int deleteClient(ClientVO vo) {
		sql = "delete from client where id=?";
		try {
			pst = cn.prepareStatement(sql);
			pst.setString(1, vo.getId());
			return pst.executeUpdate();
		} catch (Exception e) {
			System.out.println("> 회원정보 삭제 Exception : " + e);
			return 0;
		}
	} // delete
	
} // ClientDAO