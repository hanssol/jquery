package kr.or.ddit.member.dao;

import java.sql.SQLException;
import java.util.List;

import kr.or.ddit.member.vo.MemberVO;
import kr.or.ddit.member.vo.ZipVO;

public interface IMemberDao {
	
	public List<MemberVO> getAllMember() throws SQLException;
	
	// 중복검사
	public String getMember(String mem_id) throws SQLException;
	
	// 우편번호 검색
	public List<ZipVO> getZipcode(String dong) throws SQLException;
	// 저장하기
	public String insertMember(MemberVO vo) throws SQLException;
		
	
}
