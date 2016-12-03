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
