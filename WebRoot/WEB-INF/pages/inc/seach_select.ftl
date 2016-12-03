<ul class="search-cdt-detail2" >
						<#if type?default(0)!=2&&type?default(0)!=3>
                        	<li class="search-dtl2-first01" style="display:block" onclick="showSelect(this);" id="showName"><a href="#">艺术品</a></li>
                        <#elseif type?default(0)==2>
                        	<li class="search-dtl2-first01" style="display:block" onclick="showSelect(this);" id="showName"><a href="#">艺术家</a></li>
                        <#elseif type?default(0)==3>
                        	<li class="search-dtl2-first01" style="display:block" onclick="showSelect(this);" id="showName"><a href="#">画廊</a></li>
                        </#if>
                            <ul id="selecttype" style="display:none;position:relative;">
							<li class="search-dtl2-first01" onclick="hideSelect(1);"><a href="#">艺术品</a></li>
                            <li class="search-dtl2-first02"  onclick="hideSelect(2);"><a href="#">艺术家</a></li>
                            <li class="search-dtl2-first02"  onclick="hideSelect(3);"><a href="#">画廊</a></li>
                            </ul>
                         </ul>
                        <div class="search-dtl2-second">
								 <input type="text" autocomplete="off" id="searchKey" maxlength="20" value="搜索" 
					    onfocus="if(this.value=='搜索'){this.value='';this.style.color='#000'}"
					    onblur="if(this.value==''){this.value='搜索'; this.style.color='#ccc'}"  />
								<a href="#" onclick="submitSearch();" id="searchChildren" class="z-btn"></a>
							</div>
