<!doctype html>
<html>

<body>
<form id="moreMemberCenterForm">
        <!-- 个人资料开始-->
        <div class="data-part more-member-center"  style="padding-bottom: 20px;display:none">
            <!-- 工作情况开始-->
            <div class="data-message">
                <h3 class="data-tit">个人信息</h3>
                <dl class="input-message">
                    <dt>单位名称:</dt>
                    <dd>
                        <div class="input-box w330-input border-cur"><input type="text" maxlength="180" name="tMemberBaseMessageExt.companyName" value="<#if tMemberBaseMessageExt?exists && tMemberBaseMessageExt.companyName?exists>${tMemberBaseMessageExt.companyName?default('')}</#if>" /></div>
                    </dd>
                </dl>
                <dl class="input-message">
                    <dt><span>*</span>行业:</dt>
                    <dd>
                        <div class="radio-box" style="float:left;">
                            <input type="radio" class="industry" name="tMemberBaseMessageExt.industry" value="0" <#if tMemberBaseMessageExt?exists && tMemberBaseMessageExt.industry?exists && tMemberBaseMessageExt.industry==0>checked</#if> />计算机/互联网/通讯/电子 <br/>
                        </div>
                        <p id="tip-validate-industry" class="data-ts-me" style="float:left;margin-left:10px;display:none;">请选择行业</p>
                        <div class="radio-box">
                            <input type="radio" class="industry" name="tMemberBaseMessageExt.industry" value="1" <#if tMemberBaseMessageExt?exists && tMemberBaseMessageExt.industry?exists && tMemberBaseMessageExt.industry==1>checked</#if> />会计/金融/银行/保险<br/>
                        </div>
                        <div class="radio-box">
                            <input type="radio" class="industry" name="tMemberBaseMessageExt.industry" value="2" <#if tMemberBaseMessageExt?exists && tMemberBaseMessageExt.industry?exists && tMemberBaseMessageExt.industry==2>checked</#if> />贸易/消费/制造/运营<br/>
                        </div>
                        <div class="radio-box">
                            <input type="radio" class="industry" name="tMemberBaseMessageExt.industry" value="3" <#if tMemberBaseMessageExt?exists && tMemberBaseMessageExt.industry?exists && tMemberBaseMessageExt.industry==3>checked</#if> />制药/医疗<br/>
                        </div>
                        <div class="radio-box">
                            <input type="radio" class="industry" name="tMemberBaseMessageExt.industry" value="4" <#if tMemberBaseMessageExt?exists && tMemberBaseMessageExt.industry?exists && tMemberBaseMessageExt.industry==4>checked</#if> />广告/媒体<br/>
                        </div>
                        <div class="radio-box">
                            <input type="radio" class="industry" name="tMemberBaseMessageExt.industry" value="5" <#if tMemberBaseMessageExt?exists && tMemberBaseMessageExt.industry?exists && tMemberBaseMessageExt.industry==5>checked</#if> />房地产/建筑 <br/>
                        </div>
                        <div class="radio-box">
                            <input type="radio" class="industry" name="tMemberBaseMessageExt.industry" value="6" <#if tMemberBaseMessageExt?exists && tMemberBaseMessageExt.industry?exists && tMemberBaseMessageExt.industry==6>checked</#if> />专业服务/教育/培训<br/>
                        </div>
                        <div class="radio-box">
                            <input type="radio" class="industry" name="tMemberBaseMessageExt.industry" value="7" <#if tMemberBaseMessageExt?exists && tMemberBaseMessageExt.industry?exists && tMemberBaseMessageExt.industry==7>checked</#if> />服务业<br/>
                        </div>
                        <div class="radio-box">
                            <input type="radio" class="industry" name="tMemberBaseMessageExt.industry" value="8" <#if tMemberBaseMessageExt?exists && tMemberBaseMessageExt.industry?exists && tMemberBaseMessageExt.industry==8>checked</#if> />物流/运输<br/>
                        </div>
                        <div class="radio-box">
                            <input type="radio" class="industry" name="tMemberBaseMessageExt.industry" value="9" <#if tMemberBaseMessageExt?exists && tMemberBaseMessageExt.industry?exists && tMemberBaseMessageExt.industry==9>checked</#if> />能源/原材料<br/>
                        </div>
                        <div class="radio-box">
                            <input type="radio" class="industry" name="tMemberBaseMessageExt.industry" value="10" <#if tMemberBaseMessageExt?exists && tMemberBaseMessageExt.industry?exists && tMemberBaseMessageExt.industry==10>checked</#if> />政府/非盈利机构/其他<br/>
                        </div>
                        <div class="radio-box">
                            <input type="radio" class="industry" name="tMemberBaseMessageExt.industry" value="11" <#if tMemberBaseMessageExt?exists && tMemberBaseMessageExt.industry?exists && tMemberBaseMessageExt.industry==11>checked</#if> />退休
                        </div>
                    </dd>
                </dl>
                <dl class="input-message">
                    <dt>职位:</dt>
                    <dd>
                        <div class="input-box w130-input" style="float:left;"><input type="text" maxlength="50" name="tMemberBaseMessageExt.position" value="<#if tMemberBaseMessageExt?exists && tMemberBaseMessageExt.position?exists>${tMemberBaseMessageExt.position?default('')}</#if>" /></div>
                        <p class="data-ts no-background">例如：一般员工；经理；总监；CEO</p>
                    </dd>
                </dl>
                <dl class="input-message">
                    <dt><span>*</span>工作年限:</dt>
                    <dd>
                        <select id="workYear" name="tMemberBaseMessageExt.workYear" class="selete-box-member" >
                        	<option value="0" selected="selected">
								--请选择--
							</option>
							<option label="1年" <#if tMemberBaseMessageExt?exists && tMemberBaseMessageExt.workYear?exists && tMemberBaseMessageExt.workYear==1>selected</#if> value="1">
								1年
							</option>
							<option label="2年" <#if tMemberBaseMessageExt?exists && tMemberBaseMessageExt.workYear?exists && tMemberBaseMessageExt.workYear==2>selected</#if> value="2">
								2年
							</option>
							<option label="3年" <#if tMemberBaseMessageExt?exists && tMemberBaseMessageExt.workYear?exists && tMemberBaseMessageExt.workYear==3>selected</#if> value="3">
								3年
							</option>
							<option label="4年以上" <#if tMemberBaseMessageExt?exists && tMemberBaseMessageExt.workYear?exists && tMemberBaseMessageExt.workYear==4>selected</#if> value="4">
								4年以上
							</option>
                        </select>
                        <p id="tip-validate-workYear" class="data-ts-me" style="float:left;margin-left:10px;display:none;">请选择工作年限</p>
                    </dd>
                </dl>
            </div>
            <!-- 工作情况结束-->
            <!-- 教育情况开始-->
            <div class="data-message border-no">
                <h3 class="data-tit">教育情况</h3>
                <dl class="input-message">
                    <dt><span>*</span>教育程度:</dt>
                    <dd> <div class="radio-box" style="float:left;">

                            <input class="diploma" name="tMemberBaseMessageExt.diploma" value="0" <#if tMemberBaseMessageExt?exists && tMemberBaseMessageExt.diploma?exists && tMemberBaseMessageExt.diploma==0>checked</#if> type="radio"/>高中以下
                            <input class="diploma" name="tMemberBaseMessageExt.diploma" value="1" <#if tMemberBaseMessageExt?exists && tMemberBaseMessageExt.diploma?exists && tMemberBaseMessageExt.diploma==1>checked</#if> type="radio"/>中专
                            <input class="diploma" name="tMemberBaseMessageExt.diploma" value="2" <#if tMemberBaseMessageExt?exists && tMemberBaseMessageExt.diploma?exists && tMemberBaseMessageExt.diploma==2>checked</#if> type="radio"/>大专
                            <input class="diploma" name="tMemberBaseMessageExt.diploma" value="3" <#if tMemberBaseMessageExt?exists && tMemberBaseMessageExt.diploma?exists && tMemberBaseMessageExt.diploma==3>checked</#if> type="radio"/>本科
                            <input class="diploma" name="tMemberBaseMessageExt.diploma" value="4" <#if tMemberBaseMessageExt?exists && tMemberBaseMessageExt.diploma?exists && tMemberBaseMessageExt.diploma==4>checked</#if> type="radio"/>硕士
                            <input class="diploma" name="tMemberBaseMessageExt.diploma" value="5" <#if tMemberBaseMessageExt?exists && tMemberBaseMessageExt.diploma?exists && tMemberBaseMessageExt.diploma==5>checked</#if> type="radio"/>博士
                        </div>
                        <p id="tip-validate-diploma" class="data-ts-me" style="float:left;margin-left:10px;display:none;">请选择教育程度</p>
                    </dd>
                </dl>
                <dl class="input-message">
                    <dt>毕业学校:</dt>
                    <dd>
                        <div class="input-box w130-input"><input maxlength="50" name="tMemberBaseMessageExt.graduationSchool" value="<#if tMemberBaseMessageExt?exists && tMemberBaseMessageExt.graduationSchool?exists>${tMemberBaseMessageExt.graduationSchool?default('')}</#if>" type="text"/></div>
                    </dd>
                </dl>
                <dl class="input-message">
                    <dt>毕业时间:</dt>
                    <dd>
                        <div class="input-box w130-input">
                        	<input type="text" class="w130-input" name="tMemberBaseMessageExt.graduationDt" id="graduationDt" onclick="WdatePicker()" value="<#if tMemberBaseMessageExt?exists && tMemberBaseMessageExt.graduationDt?exists>${tMemberBaseMessageExt.graduationDt?default('')}</#if>"/>
                        </div>
                    </dd>
                </dl>
            </div>
            <!-- 教育情况结束-->
            <div class="member-btn"><input type="button" class="btn_div" value="保存" onclick="saveMemberCenter('moreMemberCenterForm')"/></div>
	        <div class="member-btn"><input type="button" class="btn_div_temp" value="保存" style="display:none;background:#dddddd"/></div>
        </div>
        <!-- 个人资料结束-->
</form>


</body>
</html>