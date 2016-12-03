$(function(){
    function tabs(tabTit,on,tabCon){
        $(tabCon).each(function(){
            $(this).children().eq(0).show();
        });
        $(tabTit).each(function(){
            $(this).children().eq(0).addClass(on);
        });
        $(tabTit).children().hover(function(){
            $(this).addClass(on).siblings().removeClass(on);
            var index = $(tabTit).children().index(this);
            $(tabCon).children().eq(index).show().siblings().hide();
        });
    }
    tabs(".tab-hd","active",".tab-bd");
});

//header-list
$(function(){
    $('.all-sort-list > .item').hover(function(){
        var eq = $('.all-sort-list > .item').index(this),				//获取当前滑过是第几个元素
            h = $('.all-sort-list').offset().top,						//获取当前下拉菜单距离窗口多少像素
            s = $(window).scrollTop(),									//获取游览器滚动了多少高度
            i = $(this).offset().top,									//当前元素滑过距离窗口多少像素
            item = $(this).children('.item-list').height(),				//下拉菜单子类内容容器的高度
            sort = $('.all-sort-list').height();						//父类分类列表容器的高度

        if ( item < sort ){												//如果子类的高度小于父类的高度
            if ( eq == 0 ){
                $(this).children('.item-list').css('top', (i-h));
            } else {
                $(this).children('.item-list').css('top', (i-h)+1);
            }
        } else {
            if ( s > h ) {												//判断子类的显示位置，如果滚动的高度大于所有分类列表容器的高度
                if ( i-s > 0 ){											//则 继续判断当前滑过容器的位置 是否有一半超出窗口一半在窗口内显示的Bug,
                    $(this).children('.item-list').css('top', (s-h)+2 );
                } else {
                    $(this).children('.item-list').css('top', (s-h)-(-(i-s))+2 );
                }
            } else {
                $(this).children('.item-list').css('top', 0 );
            }
        }

        $(this).addClass('hover');
        $(this).children('.item-list').css('display','block');
    },function(){
        $(this).removeClass('hover');
        $(this).children('.item-list').css('display','none');
    });

    $('.item > .item-list > .close').click(function(){
        $(this).parent().parent().removeClass('hover');
        $(this).parent().hide();
    });
})

//banner
var time = "";
var index = 1;
$(function () {
    showimg(index);
    //鼠标移入移出
    $(".imgnum span").hover(function () {
        clearTimeout(time);
        var icon=parseInt($(this).index())+1;
        $(".imgnum span").removeClass("onselect").eq(icon-1).addClass("onselect");
        $("#banner-img li").hide().stop(true,true).eq(icon-1).fadeIn("slow");
    }, function () {
        index=parseInt($(this).index())+1> 1 ? 1 :parseInt($(this).index())+1;
        time = setTimeout("showimg(" + index + ")", 3000);
    });
});

function showimg(num) {
    index = num;
    $(".imgnum span").removeClass("onselect").eq(index-1).addClass("onselect");
    $("#banner-img li").hide().stop(true,true).eq(index-1).fadeIn("slow");
    index = index + 1 > 2 ? 1 : index + 1;
    time = setTimeout("showimg(" + index + ")", 3000);
}
















































//function $(id){
//    return typeof  id==='string'?document.getElementById(id):id;
//}
//window.onload = function () {
//    var timer = null;
//    var divs = $('notice-con').getElementsByTagName('div');
//    var lis = $('notice-tit').getElementsByTagName('li');
//    if (divs.length != lis.length) return;
//    for (var i = 0; i < divs.length; i++) {
//        divs[i].tit = i;
//        divs[i].onmouseover = function () {
//            var that=this;
//            if(timer){
//                clearTimeout(timer);
//                timer=null;
//            }
//            timer=window.setTimeout(function(){
//                for(var j=0;j<divs.length;j++){
//                    divs[j].className='con-sub-list';
//                    lis[j].className='';
//                    lis[j].style.opacity='0.7';
//                }
//                that.className='con-sub-list selected-con';
//                lis[that.tit].style.opacity='1';
//                lis[that.tit].className = 'img-show';
//            },100)
//        }
//    }
//}
//
////function changeTab(){
////    var n=DOM.getIndex(this);;
////    DOM.addClass(this,"selected-tab");
////    var siblings=DOM.siblings(this);
////    for(var i=0;i<siblings.length;i++){
////        DOM.removeClass(siblings[i],"selected-tab");
////    }
////    var contentGroup=DOM.nextSilbings(this.parentNode)[0];
////    var contents=DOM.children(contentGroup);
////    for(var i=0;i<contents.length;i++){
////        DOM.removeClass(contents[i],"selected-con");
////    }
////    DOM.addClass(contents[n],"selected-con");
////}
////var oTabs=DOM.getEleByClass("tab");
////for(var i=0;i<oTabs.length;i++){
////    oTabs[i].onmouseover=changeTab;
////}
