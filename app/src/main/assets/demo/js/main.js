$(document).ready(function(){
	var app={
       question:function(text){
       	   alert(text);
           this.text=text;
           $dom="<div class='question'>"
     		+"<a class='questionIcon headerImg'>"
     		+"<img src='img/question.png' alt=''>"
     		+"</a>"
     		+"<div class='questionContent'>"
     		+"<p>"+text.content+"</p>"
     		+"</div>"
     	    +"</div>";
           $(".wrap").append($dom);
       },
       reason:function(text){

           this.text=text;
           text.src=text.url?"<img src='"+text.url+"'>":'';
           $dom="<div class='reason'>"
     		+"<a class='reasonIcon headerImg'>"
     		+"<img src='img/reason.png' alt=''>"
     		+"</a>"
            +"<div class='reasonContent'>"
            +"<p>"+text.content+text.src+"</p>"
            +"</div>"
     	    +"</div>";
           $(".wrap").append($dom);
       }
	};
//	var q_json={
//		"content":"哈哈哈哈哈哈"
//	}
//	var r_json={
//		"content":"哈哈哈哈哈哈",
//		"url":"http://avatar.csdn.net/2/6/D/1_hongweigg.jpg"
//	}
//	//提问
//    var question=new app.question(q_json);
//    //答案
//    var reason=new app.reason(r_json);

});