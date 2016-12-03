$(document).ready( function() {
    var delay = 0;
    $('.bar').children('span').each( function() {
        var num = Math.floor(Math.random()*8)+2;
        $(this)
            .width(0)
            .delay(delay)
            .animate({
                'width': (num*10)+'%'
            }, 3000);
        delay += 1500;
    });

//            $('.source span').on('click', function() {
//                $(this)
//                        .toggleClass('active')
//                        .next().slideToggle(700);
//            });
//            $('.source pre').slideUp(0);
});


$(function(){
    $("#choose-info span").click(function(){
        $(this).addClass('current').siblings().removeClass('current');
        $("#choose-icon b:eq("+$(this).index()+")").addClass('current').siblings().removeClass('current');
        $("#choose-list .list-con:eq("+$(this).index()+")").addClass('current').siblings().removeClass('current');
    })
})

//弹出层
$(function(){
    $("#popup-btn").click(function(){
        $("#shade").css({
            display:"block"
        });
        $(".popup-add").show();
    });
    $(".close-out").click(function(){
        $("#shade,.popup-add").hide();
    });
});

//退款退货
$(function () {
    function tabs(tabTit, on, tabCon) {
        $(tabCon).each(function () {
            $(this).children().eq(0).show();
        });
        $(tabTit).each(function () {
            $(this).children().eq(0).addClass(on);
        });
        $(tabTit).children().click(function () {//鼠标“click”的效果
            $(this).addClass(on).siblings().removeClass(on);
            var index = $(tabTit).children().index(this);
            $(tabCon).children().eq(index).show().siblings().hide();
        });
    }
    tabs("#tab-hd", "active", "#tab-bd");
    tabs("#tab-hd2", "active2", "#tab-bd2");
    tabs("#tab-hd3", "active2", "#tab-bd3");
    tabs("#tab-hd4", "active2", "#tab-bd4");
});

$(function(){
    $('.see-example').hover(function(){
        $(this).siblings('.example-img').show();
    },function(){
        $(this).siblings('.example-img').hide();
    })
})





