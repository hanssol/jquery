package kr.or.ddit.member.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.ibatis.config.SqlMapClientFactory;
import kr.or.ddit.member.vo.MemberVO;
import kr.or.ddit.member.vo.ZipVO;

public class MemberDaoImpl implements IMemberDao{
	
	// Mapper에 접근하는 객체 - SqlMapClient
	private SqlMapClient smc;
	
	private MemberDaoImpl(){
		smc = SqlMapClientFactory.getSqlMapClient();
	}
	// MemberDaoImpl객체 생성 - get메소드 정의
	
	private static IMemberDao dao;
	
	public static IMemberDao getInstance(){
		if(dao ==null) dao = new MemberDaoImpl();
		return dao;
	}
	@Override
	public List<MemberVO> getAllMember() throws SQLException {
		List<MemberVO> list = smc.queryForList("mymember.getAllMember");
		
		return list;
	}
	@Override
	public String getMember(String mem_id) throws SQLException {
		String vo = (String) smc.queryForObject("mymember.getMember",mem_id);
		return vo;
	}
	@Override
	public List<ZipVO> getZipcode(String dong) throws SQLException {
		List<ZipVO> list = smc.queryForList("mymember.getZipcode",dong);
		return list;
	}
	@Override
	public String insertMember(MemberVO vo2) throws SQLException {
		String id = (String) smc.insert("mymember.insertMember",vo2);
		return id;
	}

}
