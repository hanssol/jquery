package kr.or.ddit.board.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import kr.or.ddit.board.vo.BoardVO;
import kr.or.ddit.board.vo.ReplyVO;

public interface IBoardDao {
	
	
   public List<BoardVO> boardListAll() throws SQLException;
   
   
   // 총 데이터 갯수 구하기
 	public int getTotalCount() throws SQLException;
 	
 	// 해당 페이지에 따른 리스트 가져오기
 	public List<BoardVO> boadList(Map<String, Object> map) throws SQLException;
 	
 	public int insertBoard(BoardVO vo) throws SQLException;
 	
 	public int insertReply(ReplyVO vo) throws SQLException;
    
}