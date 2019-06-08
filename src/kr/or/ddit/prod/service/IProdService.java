package kr.or.ddit.prod.service;

import java.sql.SQLException;
import java.util.List;

import kr.or.ddit.prod.vo.ProdVO;

public interface IProdService {
	public List<ProdVO> getProdName(String lprod_gu);
	
	public ProdVO getProdDetail(String prod_id);
}
