package kr.or.ddit.prod.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.ibatis.config.SqlMapClientFactory;
import kr.or.ddit.prod.vo.ProdVO;

public class ProdDaoImpl implements IProdDao {
	
	//인스턴스변수 선언
	private SqlMapClient smc;
	private static IProdDao dao;
	
	//SqlMapClient객체 얻어오기 - 생성자
	private ProdDaoImpl() {
		smc = SqlMapClientFactory.getSqlMapClient();
	}
	//자신의 객체를 생성하고 리턴 - getInstance()
	public static IProdDao getInstance(){
		if(dao==null) dao=new ProdDaoImpl();
		return dao;
	}
	
	@Override
	public List<ProdVO> getProdName(String lprod_gu) throws SQLException {
		List<ProdVO> list = smc.queryForList("prod.getProdName", lprod_gu);
		return list;
	}

	@Override
	public ProdVO getProdDetail(String prod_id) throws SQLException {
		ProdVO vo = (ProdVO) smc.queryForObject("prod.getProdDetail",prod_id);
		return vo;
	}

}
