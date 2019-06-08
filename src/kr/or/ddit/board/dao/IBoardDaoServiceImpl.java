package kr.or.ddit.board.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.board.vo.BoardVO;
import kr.or.ddit.board.vo.ReplyVO;
import kr.or.ddit.ibatis.config.SqlMapClientFactory;

public class IBoardDaoServiceImpl implements IBoardDao {
	
	private static IBoardDao dao;
	private SqlMapClient smc;
	
	public static IBoardDao getInstance(){
		if(dao==null) dao = new IBoardDaoServiceImpl();
		return dao;
	}
	//SqlMapClient 객체 생성(얻어오기 - 생성자에서 한다.)
		private IBoardDaoServiceImpl() {
			smc = SqlMapClientFactory.getSqlMapClient();
		}
	
	@Override
	public List<BoardVO> boardListAll() throws SQLException {
		List<BoardVO> list = smc.queryForList("board.boardListAll");
		return list;
	}
	@Override
	public int getTotalCount() throws SQLException {
		
		return (int) smc.queryForObject("board.getTotalCount");
	}
	@Override
	public List<BoardVO> boadList(Map<String, Object> map) throws SQLException {
		
		return smc.queryForList("board.boardList",map);
	}
	@Override
	public int insertBoard(BoardVO vo) throws SQLException {
		
		return (int) smc.insert("board.insertBoard", vo);
	}
	@Override
	public int insertReply(ReplyVO vo) throws SQLException {
		
		return (int) smc.insert("board.insertReply",vo);
	}

}
