package kr.or.ddit.lprod.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.lprod.vo.LprodVO;
import kr.or.ddit.ibatis.config.SqlMapClientFactory;

public class LprodDaoImpl  implements ILprodDao{
	
	
	//Mapper에 접근하는 객체 
	private SqlMapClient smc;

	private LprodDaoImpl(){
		smc=SqlMapClientFactory.getSqlMapClient();
	}
	
	//MemberDaoImple 객체 생성 get메소드를 정의한다 
	

	
	public static ILprodDao dao;
	
	public static ILprodDao getInstance(){
		if(dao==null) dao=new LprodDaoImpl();
		return dao;
	}
	
	
	@Override
	public List<LprodVO> getAllLprod() throws SQLException {
	
		List<LprodVO> list =smc.queryForList("myLprod.getAllLprod");
				
		
		return list;
	}



}
