// JavaScript Document
$(function () {
	g_c_index2 = 0; //当前状态
	
	//$(".video_content").css("height",$(".video_content").height()+"px");
	
	$("#video_goleft").click(function () {
		g_c_index2 -= 1;
		if (g_c_index2 < 0) g_c_index2 = 0;
		dotit2();
		return false;
	});
	$("#video_goright").click(function () {
		g_c_index2 += 1;
		if (g_c_index2 > $(".video_catalog ul li").length-1) g_c_index2 = 0;
		dotit2();
		return false;
	});
	$(".video_catalog ul li").hover(function () {
		g_c_index2 = $(this).index();
		dotit2();
		return false;
	},function(){});

	function dotit2() {
		$(".video_catalog ul li a").removeClass("selected");
		$(".video_catalog ul li a").eq(g_c_index2).addClass("selected");
		var id = $(".video_catalog ul li a").eq(g_c_index2).attr("contentid");
		$(".video_content_category").stop(true,true).hide();
		$("#"+id).fadeIn(500);
	}

	var timer2 = 0;
	function autoPlay2() {
		timer2 = setInterval("$('#video_goright').click();", 5000);
	}
	function stopPlay2() {
		clearInterval(timer2);
	}
			
	/*
	autoPlay2();

	$("#video_goleft,#video_goright,.video_catalog ul li").click(function () {
		stopPlay2();
		autoPlay2();
		return false;
	});
	*/

});


$(function(){
	$(".shitilist_module").each(function(){
		if($(this).index()>1)
			$(this).css("margin-bottom","2px");
	});
});

$(function(){
	$(".list_module_tit ul li a").hover(
		function(){
			var obj1 = $(this).parents(".list_module");
			obj1.find(".list_module_tit ul li a").removeClass("selected");
			$(this).addClass("selected");
			
			obj1.find(".moduleullist").stop(true,true).hide();
			var id = $(this).attr("conid");
			obj1.find("#"+id).fadeIn(400);
		},function(){}
	);
});

$(function(){
	$(".list_module_tit ul li a").hover(
		function(){
			var obj1 = $(this).parents(".list_module");
			obj1.find(".list_module_tit ul li a").removeClass("selected");
			$(this).addClass("selected");
			
			obj1.find(".moduleullist").stop(true,true).hide();
			var id = $(this).attr("conid");
			obj1.find("#"+id).fadeIn(400);
		},function(){}
	);
});
