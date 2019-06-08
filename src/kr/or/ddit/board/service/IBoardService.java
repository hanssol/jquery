package kr.or.ddit.board.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.board.vo.BoardVO;
import kr.or.ddit.board.vo.ReplyVO;

public interface IBoardService {
   
	public List<BoardVO> boardListAll();
   
   // 총 데이터 갯수 구하기
	public int getTotalCount();
	
	// 해당 페이지에 따른 리스트 가져오기
	public List<BoardVO> boadList(Map<String, Object> map);
	
	//저장하기
	public int insertBoard(BoardVO vo);
	
	// 댓글저장
	public int insertReply(ReplyVO vo);
   
}