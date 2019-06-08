package kr.or.ddit.member.service;

import java.sql.SQLException;
import java.util.List;

import kr.or.ddit.member.dao.IMemberDao;
import kr.or.ddit.member.dao.MemberDaoImpl;
import kr.or.ddit.member.vo.MemberVO;
import kr.or.ddit.member.vo.ZipVO;

public class MemberServiceImpl implements IMemberService {
	
	// dao객체를 얻어오기
	private IMemberDao dao;
	
	private MemberServiceImpl() {
		dao = MemberDaoImpl.getInstance();
	}
	
	// service객체생성 - 리턴하는 get메소드
	private static IMemberService service;
	
	public static IMemberService getInstance(){
		if(service == null) service = new MemberServiceImpl();
		
		return service;
	}
	
	@Override
	public List<MemberVO> getAllMember() throws SQLException {
		
		List<MemberVO> list = null;
		
		list = dao.getAllMember();
		
		return list;
	}
	

	@Override
	public String getMember(String mem_id)  {
		String res =null;
		 
		try {
			
			res=dao.getMember(mem_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return res;
	}

	@Override
	public List<ZipVO> getZipcode(String dong) {
		List<ZipVO> list =null;
		 
		try {
			
			list = dao.getZipcode(dong);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public String insertMember(MemberVO vo)  {
		String id =null;
		 
		try {
			
			id=dao.insertMember(vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return id;
	}
	
}
