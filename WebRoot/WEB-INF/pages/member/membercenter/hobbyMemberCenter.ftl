<!doctype html>
<html>

<body>
<!--内容开始-->
<form id="hobbyMemberCenterForm">        
        <!-- 个人资料开始-->
        <div class="data-part hobby-member-center"  style="padding-bottom: 20px;display:none">
            <!-- 兴趣爱好开始-->
            <div class="data-message border-no">
                <dl class="input-message">
                    <dt><span>*</span>购物喜好:</dt>
                    <dd>
                        <div class="radio-box" style="float:left;">
                            <input type="checkbox" class="shoppingLike" name="tMemberHobby.shoppingLike" <#if tMemberHobby?exists && tMemberHobby.shoppingLike?exists && tMemberHobby.shoppingLike?index_of(',0,') gte 0>checked</#if> value="0" />食品/饮料　　　　　<input type="checkbox" class="shoppingLike" name="tMemberHobby.shoppingLike" <#if tMemberHobby?exists && tMemberHobby.shoppingLike?exists && tMemberHobby.shoppingLike?index_of(',5,') gte 0>checked</#if> value="5" />家电/数码　　　　　<input type="checkbox" class="shoppingLike" name="tMemberHobby.shoppingLike" <#if tMemberHobby?exists && tMemberHobby.shoppingLike?exists && tMemberHobby.shoppingLike?index_of(',10,') gte 0>checked</#if> value="10" />汽车/护养<br/>
                            <input type="checkbox" class="shoppingLike" name="tMemberHobby.shoppingLike" <#if tMemberHobby?exists && tMemberHobby.shoppingLike?exists && tMemberHobby.shoppingLike?index_of(',1,') gte 0>checked</#if> value="1" />美容/护理　　　　　<input type="checkbox" class="shoppingLike" name="tMemberHobby.shoppingLike" <#if tMemberHobby?exists && tMemberHobby.shoppingLike?exists && tMemberHobby.shoppingLike?index_of(',6,') gte 0>checked</#if> value="6" />服装/箱包　　　　　<input type="checkbox" class="shoppingLike" name="tMemberHobby.shoppingLike" <#if tMemberHobby?exists && tMemberHobby.shoppingLike?exists && tMemberHobby.shoppingLike?index_of(',11,') gte 0>checked</#if> value="11" />进口/食品<br/>
                            <input type="checkbox" class="shoppingLike" name="tMemberHobby.shoppingLike" <#if tMemberHobby?exists && tMemberHobby.shoppingLike?exists && tMemberHobby.shoppingLike?index_of(',2,') gte 0>checked</#if> value="2" />厨卫/清洁　　　　　<input type="checkbox" class="shoppingLike" name="tMemberHobby.shoppingLike" <#if tMemberHobby?exists && tMemberHobby.shoppingLike?exists && tMemberHobby.shoppingLike?index_of(',7,') gte 0>checked</#if> value="7" />运动/户外　　　　　<input type="checkbox" class="shoppingLike" name="tMemberHobby.shoppingLike" <#if tMemberHobby?exists && tMemberHobby.shoppingLike?exists && tMemberHobby.shoppingLike?index_of(',4,') gte 0>checked</#if> value="4" />家居/家具<br/>
                            <input type="checkbox" class="shoppingLike" name="tMemberHobby.shoppingLike" <#if tMemberHobby?exists && tMemberHobby.shoppingLike?exists && tMemberHobby.shoppingLike?index_of(',3,') gte 0>checked</#if> value="3" />母婴/玩具　　　　　<input type="checkbox" class="shoppingLike" name="tMemberHobby.shoppingLike" <#if tMemberHobby?exists && tMemberHobby.shoppingLike?exists && tMemberHobby.shoppingLike?index_of(',8,') gte 0>checked</#if> value="8" />文具/影音　　　　　<input type="checkbox" class="shoppingLike" name="tMemberHobby.shoppingLike" <#if tMemberHobby?exists && tMemberHobby.shoppingLike?exists && tMemberHobby.shoppingLike?index_of(',9,') gte 0>checked</#if> value="9" />建材/装修<br/>
                            <input type="checkbox" class="shoppingLike" name="tMemberHobby.shoppingLike" <#if tMemberHobby?exists && tMemberHobby.shoppingLike?exists && tMemberHobby.shoppingLike?index_of(',12,') gte 0>checked</#if> value="12" />营养保健/健身器材　<input type="checkbox" class="shoppingLike" name="tMemberHobby.shoppingLike" <#if tMemberHobby?exists && tMemberHobby.shoppingLike?exists && tMemberHobby.shoppingLike?index_of(',13,') gte 0>checked</#if> value="13" />机票/手机充值/健康服务
                        </div>
                        <p id="tip-validate-shoppingLike" class="data-ts-me" style="float:left;margin-left:10px;display:none;">请选择购物喜好</p>
                    </dd>
                </dl>
                <dl class="input-message">
                    <dt><span>*</span>购物类型:</dt>
                    <dd>
                        <div class="radio-box" style="float:left;">
                            <input type="checkbox" class="shoppingPreference" name="tMemberHobby.shoppingPreference" <#if tMemberHobby?exists && tMemberHobby.shoppingPreference?exists && tMemberHobby.shoppingPreference?index_of(',0,') gte 0>checked</#if> value="0" />够新奇　　
                            <input type="checkbox" class="shoppingPreference" name="tMemberHobby.shoppingPreference" <#if tMemberHobby?exists && tMemberHobby.shoppingPreference?exists && tMemberHobby.shoppingPreference?index_of(',1,') gte 0>checked</#if> value="1" />够快捷　　
                            <input type="checkbox" class="shoppingPreference" name="tMemberHobby.shoppingPreference" <#if tMemberHobby?exists && tMemberHobby.shoppingPreference?exists && tMemberHobby.shoppingPreference?index_of(',2,') gte 0>checked</#if> value="2" />够安全　　
                            <input type="checkbox" class="shoppingPreference" name="tMemberHobby.shoppingPreference" <#if tMemberHobby?exists && tMemberHobby.shoppingPreference?exists && tMemberHobby.shoppingPreference?index_of(',3,') gte 0>checked</#if> value="3" />够低价
                        </div>
                        <p id="tip-validate-shoppingPreference" class="data-ts-me" style="float:left;margin-left:10px;display:none;">请选择购物喜好</p>
                    </dd>
                </dl>
                <dl class="input-message">
                    <dt>最喜爱的品牌:</dt>
                    <dd>
                        <div class="text-box">
                            <textarea name="tMemberHobby.likeBrand" maxlength="490"><#if tMemberHobby?exists && tMemberHobby.likeBrand?exists>${tMemberHobby.likeBrand?default('')}</#if></textarea>
                        </div>
                    </dd>
                </dl>
                <dl class="input-message">
                    <dt>最喜爱的明星:</dt>
                    <dd>
                        <div class="text-box">
                            <textarea name="tMemberHobby.likeStar" maxlength="490"><#if tMemberHobby?exists && tMemberHobby.likeStar?exists>${tMemberHobby.likeStar?default('')}</#if></textarea>
                        </div>
                    </dd>
                </dl>
                <dl class="input-message">
                    <dt>最喜爱的电影:</dt>
                    <dd>
                        <div class="text-box">
                            <textarea name="tMemberHobby.likeFilm" maxlength="490"><#if tMemberHobby?exists && tMemberHobby.likeFilm?exists>${tMemberHobby.likeFilm?default('')}</#if></textarea>
                        </div>
                    </dd>
                </dl>
                <dl class="input-message">
                    <dt>最喜爱的人物:</dt>
                    <dd>
                        <div class="text-box">
                            <textarea name="tMemberHobby.likeCharacter" maxlength="490"><#if tMemberHobby?exists && tMemberHobby.likeCharacter?exists>${tMemberHobby.likeCharacter?default('')}</#if></textarea>
                        </div>
                    </dd>
                </dl>
            </div>
            <!-- 兴趣爱好结束-->
            <div class="member-btn"><input type="button" class="btn_div" value="保存" onclick="saveMemberCenter('hobbyMemberCenterForm')"/></div>
	        <div class="member-btn"><input type="button" class="btn_div_temp" value="保存" style="display:none;background:#dddddd"/></div>
        </div>
        <!-- 个人资料结束-->

<!--内容结束-->
</form>

</body>
</html>