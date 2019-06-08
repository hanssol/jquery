package kr.or.ddit.board.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import kr.or.ddit.board.dao.IBoardDao;
import kr.or.ddit.board.dao.IBoardDaoServiceImpl;
import kr.or.ddit.board.vo.BoardVO;
import kr.or.ddit.board.vo.ReplyVO;

public class IBoardServiceImpl implements IBoardService{
	private static IBoardService service;
	private IBoardDao dao;
	
	public static IBoardService getInstance(){
		if(service == null) service = new IBoardServiceImpl();
		return service;
	}
	
	public IBoardServiceImpl() {
		dao = IBoardDaoServiceImpl.getInstance();
	}
	
	
	@Override
	public List<BoardVO> boardListAll() {
		List<BoardVO> list = null;
		try {
			list = dao.boardListAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int getTotalCount() {
		int count = 0;
		
		try {
			count = dao.getTotalCount();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return count;
	}

	@Override
	public List<BoardVO> boadList(Map<String, Object> map) {
		List<BoardVO> list = null;
		try {
			list = dao.boadList(map);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int insertBoard(BoardVO vo) {
		int seq = 0;
		
		try {
			seq = dao.insertBoard(vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return seq;
	}

	@Override
	public int insertReply(ReplyVO vo) {
		int renum = 0;
		try {
			renum = dao.insertReply(vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return renum;
	}

}
