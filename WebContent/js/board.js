/**
 * 
 */
// 호출 : readServer(1)

var currentPage =1;
var readServer = function(cpage) {
   $.ajax({
      url : "listpage.jsp",
      data : {"cpage" : cpage},
      type : "get",
      success : function(datas) {
         $('.container').empty();
         code = '<div class="panel-group" id="accordion">';
         $.each(   datas.data, function(i,v) {
            code += '<div class="panel panel-default">';
            code += '<div class="panel-heading">';
            code += ' <h4 class="panel-title">';
            code += '  <a data-toggle="collapse" data-parent="#accordion" href="#collapse'+v.seq+'">'+v.subject+'</a> ';
            code += ' </h4> ';
            code += '</div>';
            code += '<div id="collapse'+v.seq+'" class="panel-collapse collapse">                                                  ';
            code += '  <div class="panel-body">                                                                               ';
            code += '     <p style="width: 80%; float:left">                                                                    ';
            code += '        작성자 :'+v.writer+' &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;                                                           ';
            code += '        이메일 :'+v.mail+' &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;                                                           ';
            code += '        작성일 :'+v.wdate+' &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;                                                           ';
            code += '        조회수 :'+v.hit+' &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;                                                           ';
            code += '     </p>    ';
            code += '     <p style="text-align: :right;"> ';
            code += '        <button idx="'+v.seq+'" name="modify" class ="action">수정</button> ';
            code += '        <button idx="'+v.seq+'" name="delete" class ="action">삭제</button> ';
            code += '     </p> ';
            code += '     <hr>  ';
            code += '     <p>';
            code +=    v.content;
            code += '     </p>';
            code += '     <p> ';
            code += '        <textarea  class="area" cols="129">댓글쓰기</textarea>  ';
            code += '        <button idx="'+v.seq+'" style="height: 45px; vertical-align: top;" name="reply" class = action> 등록</button>  ';
            code += '     </p> ';
            code += '  </div>';
            code += '</div>';
            code += '</div>';
         })
         code += '</div>';
         $('.container').append(code);
         
         //페이지 번호 출력
         pager="";
         for(i=1; i<=datas.totalpage; i++){
            if(currentPage==i){
               pager += i+"&nbsp;&nbsp;&nbsp;";
               
            }else{
               pager += "<a class='paging'href='#'>"+i+"</a>&nbsp;&nbsp;&nbsp;";
               
            }
            
            
         }
         $('#pagelist').css('text-align','center').css('font-size','1.5em');
         
         $('#pagelist').empty().append(pager);
   
      },
      error : function(xhr) {
         alert("상태 : " + xhr.status);
      },
      dataType : 'json'
   })
}

$('#pagelist').on('click', '.paging', function(obj) {
   num = $(this).text();
   currentPage=num;
   readServer(num);
})


var replyServer = function(){
	$.ajax({
		url : 'replysave.jsp',
		type : 'post',
		data : reply,
		success : function(datas){
			alert(datas.sw);
		},
		error : function(xhr){
			alert("상태 : " + xhr.status);
		},
		dataType : 'json'
	})
}


