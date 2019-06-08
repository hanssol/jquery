<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="kr.or.ddit.board.vo.BoardVO"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.board.service.IBoardServiceImpl"%>
<%@page import="kr.or.ddit.board.service.IBoardService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
{

<%
	int cpage = Integer.parseInt(request.getParameter("cpage"));

	IBoardService service = IBoardServiceImpl.getInstance();

	/* 전체 데이터 갯수 구하기 */
	int totalcount = service.getTotalCount();
	
	/* 한페이지당 출력할 갯수*/
	int perlist = 5;
	
	/* 전체 페이지 수 */
// 	int totalpage = totalcount / perlist;
// 	if(totalcount % perlist >0) totalpage++;
	
	int totalpage = (int)Math.ceil((double)totalcount/ perlist); 
	
	// cpage : 1-> 1,5  cpage : 2->6,10
	int start = (cpage - 1) * perlist + 1;
	int end = start + perlist -1;
	if(end > totalcount) end = totalcount;
	
	Map<String,Object> map = new HashMap<String, Object>();
	map.put("start", start);
	map.put("end",end);
	%>
	"totalpage" : "<%= totalpage%>",
	"data" : [
	
	<%
	List<BoardVO> list =service.boadList(map);
	for(int i=0;i<list.size();i++){
		BoardVO vo =list.get(i);
		if(i>0) out.print(",");

%>
{
		"seq" : "<%= vo.getSeq() %>",
		"subject" : "<%= vo.getSubject() %>",
		"writer" : "<%= vo.getWriter() %>",
		"mail" : "<%= vo.getMail() %>",
		"content" : "<%= vo.getContent().replaceAll("\r\n", "<br>") %>",
		"wdate" : "<%= vo.getWdate() %>",
		"hit" :"<%=vo.getHit() %>"
	
	}

<%
	}
%>
	]	
}

