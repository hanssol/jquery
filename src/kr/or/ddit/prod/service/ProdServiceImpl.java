package kr.or.ddit.prod.service;

import java.sql.SQLException;
import java.util.List;

import kr.or.ddit.prod.dao.IProdDao;
import kr.or.ddit.prod.dao.ProdDaoImpl;
import kr.or.ddit.prod.vo.ProdVO;

public class ProdServiceImpl implements IProdService {
	
	//인스턴스변수 선언
	private IProdDao dao;
	private static IProdService service;
	//dao 객체얻어오기 - 생성자
	private ProdServiceImpl() {
		dao = ProdDaoImpl.getInstance();
	}
	
	//자신의 객체 생성해서 리턴 - getInstance()
	public static IProdService getInstance(){
		if(service==null) service = new ProdServiceImpl();
		return service;
	}
	
	
	@Override
	public List<ProdVO> getProdName(String lprod_gu) {
		List<ProdVO> list = null;
		
		try {
			list = dao.getProdName(lprod_gu);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public ProdVO getProdDetail(String prod_id) {
		ProdVO vo = null;
		try {
			vo = dao.getProdDetail(prod_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vo;
	}

}
