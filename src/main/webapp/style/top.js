// JavaScript Document
$(function () {
    g_c_index = 0; //当前状态

    $(".imgview").width($("#banner_shower").width() * $(".imgico ul li").length);


    $("#goleft").click(function () {
        g_c_index -= 1;
        if (g_c_index < 0) g_c_index = 0;
        moveit();
        dotit();
        return false;
    });
    $("#goright").click(function () {
        g_c_index += 1;
        if (g_c_index > $(".imgico ul li").length-1) g_c_index = 0;
        moveit();
        dotit();
        return false;
    });
    $(".imgico ul li").click(function () {
        g_c_index = $(this).index();
        moveit();
        dotit();
        return false;
    });

    function dotit() {
        $(".imgico ul li a").removeClass("selected");
        $(".imgico ul li a").eq(g_c_index).addClass("selected");
    }

    function moveit() {
        var left = g_c_index * $("#banner_shower").width();
        $(".imgview").stop(true, true).animate({ marginLeft: -left }, 1000);
    }

    var timer = 0;
    function autoPlay() {
        timer = setInterval("$('#goright').click();", 5000);
    }
    function stopPlay() {
        clearInterval(timer);
    }
    autoPlay();

    $("#goleft,#goright,.imgico ul li").click(function () {
        stopPlay();
        autoPlay();
        return false;
    });


    //导航状态
    var url = document.URL.toLowerCase();
    var toobjid = "";
    if (url.indexOf("index.aspx") > -1) {
        toobjid = "index";
    } else if (url.indexOf("videolist.asp") > -1) {
        toobjid = "video";
    } else if (url.indexOf("arclist.asp") > -1) {
        toobjid = "arc";
    } else if (url.indexOf("testpaperlist.asp") > -1) {
        toobjid = "testpaper";
    } else if (url.indexOf("info.aspx?id=1") > -1) {
        toobjid = "about";
    } else if (url.indexOf("info.aspx?id=2") > -1) {
        toobjid = "contact";
    } else if (url.indexOf("softlist.asp") > -1) {
        toobjid = "soft";
    } else if (url.indexOf("games.asp") > -1) {
        toobjid = "game";
    } else if (url.indexOf("userask.asp") > -1) {
        toobjid = "ask";
    }
    toobjid = toobjid == "" ? "index" : toobjid;
    toobjid = "nav_" + toobjid;
    $("#" + toobjid).addClass("selected");
});
