package kr.or.ddit.buyer.service;

import java.sql.SQLException;
import java.util.List;

import kr.or.ddit.buyer.dao.BuyerDaoImpl;
import kr.or.ddit.buyer.dao.IBuyerDao;
import kr.or.ddit.buyer.vo.BuyerVO;

public class BuyerServiceImpl implements IBuyerService {
	private static IBuyerService service;
	private IBuyerDao dao;
	
	public static IBuyerService getInstance(){
		if(service ==null) service = new BuyerServiceImpl();
		return service;
	}
	
	public BuyerServiceImpl() {
		dao = BuyerDaoImpl.getInstance();
	}
	//Sq
	@Override
	public List<BuyerVO> getNameList() {
		List<BuyerVO> list = null;
		
		try {
			list = dao.getNameList();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public BuyerVO getDetail(String buyer_id) {
		BuyerVO vo =null;
		
		try {
			vo = dao.getDetail(buyer_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vo;
	}

}
