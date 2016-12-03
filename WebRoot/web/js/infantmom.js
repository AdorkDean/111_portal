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
        var eq = $('.all-sort-list > .item').index(this),				//��ȡ��ǰ�����ǵڼ���Ԫ��
            h = $('.all-sort-list').offset().top,						//��ȡ��ǰ�����˵����봰�ڶ�������
            s = $(window).scrollTop(),									//��ȡ�����������˶��ٸ߶�
            i = $(this).offset().top,									//��ǰԪ�ػ������봰�ڶ�������
            item = $(this).children('.item-list').height(),				//�����˵��������������ĸ߶�
            sort = $('.all-sort-list').height();						//��������б������ĸ߶�

        if ( item < sort ){												//�������ĸ߶�С�ڸ���ĸ߶�
            if ( eq == 0 ){
                $(this).children('.item-list').css('top', (i-h));
            } else {
                $(this).children('.item-list').css('top', (i-h)+1);
            }
        } else {
            if ( s > h ) {												//�ж��������ʾλ�ã���������ĸ߶ȴ������з����б������ĸ߶�
                if ( i-s > 0 ){											//�� �����жϵ�ǰ����������λ�� �Ƿ���һ�볬������һ���ڴ�������ʾ��Bug,
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
    //��������Ƴ�
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
