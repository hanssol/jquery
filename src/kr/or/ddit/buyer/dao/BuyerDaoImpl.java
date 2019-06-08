package kr.or.ddit.buyer.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.buyer.vo.BuyerVO;
import kr.or.ddit.ibatis.config.SqlMapClientFactory;
import kr.or.ddit.member.dao.MemberDaoImpl;

public class BuyerDaoImpl implements IBuyerDao {

	// 인스턴스 변수 선언
	private static IBuyerDao dao;
	private SqlMapClient smc;
	
	//자신의 객체를 생성하고 리턴하는 메서드 - getInstance()
	public static IBuyerDao getInstance(){
		if(dao ==null) dao = new BuyerDaoImpl();
		return dao;
	}
	//SqlMapClient 객체 생성(얻어오기 - 생성자에서 한다.)
	private BuyerDaoImpl() {
		smc = SqlMapClientFactory.getSqlMapClient();
	}
	
	
	
	@Override
	public List<BuyerVO> getNameList() throws SQLException {
		List<BuyerVO> list = smc.queryForList("buyer.getNameList");
		return list; 
	}

	@Override
	public BuyerVO getDetail(String buyer_id) throws SQLException {
		return (BuyerVO) smc.queryForObject("buyer.getDetail",buyer_id);
	}

}
