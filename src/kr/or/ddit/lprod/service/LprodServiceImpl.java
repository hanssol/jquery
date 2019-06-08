package kr.or.ddit.lprod.service;

import java.sql.SQLException;
import java.util.List;

import kr.or.ddit.lprod.dao.ILprodDao;
import kr.or.ddit.lprod.dao.LprodDaoImpl;
import kr.or.ddit.lprod.vo.LprodVO;



public class LprodServiceImpl implements ILprodService {

	// service 객체 리턴

	// dao객체를 얻어오기

	private ILprodDao dao;

	// 생성자

	private LprodServiceImpl() {
		// dao = new MemberDaoImpl();
		dao = LprodDaoImpl.getInstance();
	}

	private static ILprodService service;

	public static ILprodService getInstance() {
		if (service == null)
			service = new LprodServiceImpl();

		return service;
	}

	@Override
	public List<LprodVO> getAllLprod() {

		List<LprodVO> list = null;
		try {
			list = dao.getAllLprod();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

}
