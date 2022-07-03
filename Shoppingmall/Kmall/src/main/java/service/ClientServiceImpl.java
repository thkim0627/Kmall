package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mapperInterface.ClientMapper;
import vo.ClientVO;

// Service
// 요청클래스와 DAO클래스 사이의 연결(완충지대) 역할
// 요청클래스와 DAO클래스 사이에서 변경사항이 생기더라도 서로 영향 받지않도록해주는 역할
// 결합도는 낮추고, 응집도는 높인다.

// interface 자동완성 
// Alt + Shift + T  
// 또는 마우스우클릭 PopUp Menu 의  Refactor - Extract Interface...

@Service
public class ClientServiceImpl implements ClientService {
	
	@Autowired
	ClientMapper mapper;
	
	// 1.회원 조회
	@Override
	public List<ClientVO> selectClientList() {
		return mapper.selectClientList();
	}
	// 2.로그인 + 회원페이지
	@Override
	public ClientVO selectClientOne(ClientVO vo) {
		return mapper.selectClientOne(vo);
	}
	// 3.회원가입
	@Override
	public int insertClient(ClientVO vo) {
		return mapper.insertClient(vo);
	}
	// 4.회원정보 수정
	@Override
	public int updateClient(ClientVO vo) {
		return mapper.updateClient(vo);
	}
	// 5.회원정보 삭제
	@Override
	public int deleteClient(ClientVO vo) {
		return mapper.deleteClient(vo);
	}	
	
} // ClientServiceImpl