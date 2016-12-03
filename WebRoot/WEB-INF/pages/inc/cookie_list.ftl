<div class="u_remb">
                           <div class="u_mail">
                                <div class="u_tit">您浏览的艺术品</div>
                           </div>
                           <div class="u_com" >
                                <div class="ulist"  id="botton-scroll" >
                                    <ul id="CarouselNT" class="featureul" >
                                    <#list  mapList?if_exists as resc>
                                       <li>
                                          <a target="_blank" href="${base}/works/works!selectWorksDetail.action?worksId=${getMapValue(resc,'id')?default(0)}"><img src="${base}${resc.imgurl?default('')}" width="220" height="220"></a>
                                          <p><span>${resc.worksname?default('')}</span>${resc.artname?default('')}</p>
                                       </li>
                                       </#list>
                                    </ul>
                                </div>
                                <div class="arr_l" id="nextBtn" class="left" ></div>
                                <div class="arr_r" id="topBtn" class="right" ></div>
                           </div>
                      </div>