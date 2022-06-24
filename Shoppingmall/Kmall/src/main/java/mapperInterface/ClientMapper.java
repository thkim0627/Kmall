package mapperInterface;

import java.util.List;

import vo.ClientVO;

public interface ClientMapper {
	
	// 1.회원 조회
	List<ClientVO> selectClientList();
	
	// 2.로그인 + 회원페이지
	ClientVO selectClientOne(ClientVO vo);
	
	// 3.회원가입
	int insertClient(ClientVO vo);
	
	// 4.회원정보 수정
	int updateClient(ClientVO vo);
	
	// 5.회원정보 삭제
	int deleteClient(ClientVO vo);
	
} // ClientMapper