<!--遮罩层开始-->
<div id="shade">
	<!--新增收货人信息开始-->
	    <div class="out out-box" id="out2" style="display:none">
	     <form id="receiverAdd" name="receiverAdd" action="">
	      <input type="hidden" name="tmemberreceiver.id" id="tmemberreceiver_id"  value=""/>
	            <input type="hidden" name="memberReceiver_adcode" id="memberReceiver_adcode"  value=""/>
	            <input type="hidden" name="tmemberreceiver.longitude" id="tmemberreceiver_longitude"  value=""/>
	            <input type="hidden" name="city_name_set" id="city_name_set"  value=""/>
	            <input type="hidden" name="tmemberreceiver.latitude" id="tmemberreceiver_latitude"  value=""/>
	            <input type="hidden" name="tmemberreceiver.locationAddress" id="tmemberreceiver_locationAddress"  value=""/>
	            <input type="hidden" name="tmemberreceiver_areaId" id="tmemberreceiver_areaId"  value=""/>
	            <input type="hidden" name="tmemberreceiver_is_default" id="tmemberreceiver_is_default"  value=""/>
	        <div class="double-out">
	            <div class="firse-out">
	                <h4 class="out-title">
	                    <a href="javascript:closeDiv('out2')" class="close-out"></a>
	                    新增收货人信息
	                </h4>
	                <div class="out-info clearfix clear">
	                    <dl class="refund-details clearfix clear">
	                        <dt><b>*</b>位置：</dt>
	                        <dd>
	                            <div id="distpicker">
	                                <div class="form-group" style="margin-bottom:0;">
	                                    <div style="position: relative;">
	                                        <input id="city-picker3" class="form-control" readonly type="text" value="" data-toggle="city-picker">
	                                    </div>
	                                </div>
	                            </div>
	                            <div class="location-box" id="city-picker3_tishi">
	                            请补充完省市区地址
	                            </div>
	                        </dd>
	                    </dl>
	                    <dl class="refund-details clearfix clear">
	                        <dt><b>*</b>详细地址：</dt>
	                        <dd style="width:500px; position: relative;">
	                            <div class="refund-box receive-d">
	                                <input type="text" name="tmemberreceiver.address" maxlength="40" id="tmemberreceiver_address" class="refund-price" value="请输入你的收货地址（写字楼,小区,街道或者学校）" onfocus="javascript:if(this.value=='请输入你的收货地址（写字楼,小区,街道或者学校）'){ this.value='';this.style.color='#222';this.style.border='1px solid #222'}" onblur="javascript:if(this.value==''){ this.value='请输入你的收货地址（写字楼,小区,街道或者学校）';this.style.color='#222';this.style.border='1px solid #d7d7d7'}">
	                            </div>
	                             <div id="addressSpanFont" style="position: absolute; top:3px; left:359px; width:116px; height:38px; padding-left: 20px;"><font color="red" ><i style="position: absolute; top:0; left:0; background: url(${base}/web/version2.2.0/images/member/member_data_icon_red.png) no-repeat left center;display:inline-block; width:15px; height:15px;"></i>请填写收货人详细地址，不超过40个字</font></div>
	                        </dd>
	                    </dl>
	                    <dl class="refund-details tel-details clearfix clear">
	                        <dt><b>*</b>收货人姓名：</dt>
	                        <dd style="width:500px;">
	                            <div class="refund-box">
	                                <input type="text"  name="tmemberreceiver.receiver" maxlength="10" id="tmemberreceiver_receiver" class="refund-price" value="请输入收货人姓名" onfocus="javascript:if(this.value=='请输入收货人姓名'){ this.value='';this.style.color='#222';this.style.border='1px solid #222'}" onblur="javascript:if(this.value==''){ this.value='请输入收货人姓名';this.style.color='#222';this.style.border='1px solid #d7d7d7'}">
	                            </div>
	                             <div id="receiverSpanFont"><font color="red"  class="location-box" style="line-height:38px;">请填写收货人姓名，不超过10个字</font></div>
	                        </dd>
	                    </dl>
	                    <dl class="refund-details tel-details clearfix clear">
	                        <dt><b>*</b>收货人手机号：</dt>
	                        <dd style="width:500px;">
	                            <div class="refund-box">
	                                <input type="text" name="tmemberreceiver.mobile" maxlength="11" id="tmemberreceiver_mobile" class="refund-price" value="请输入收货人手机号" onfocus="javascript:if(this.value=='请输入收货人手机号'){ this.value='';this.style.color='#222';this.style.border='1px solid #222'}" onblur="javascript:if(this.value==''){ this.value='请输入收货人手机号';this.style.color='#222';this.style.border='1px solid #d7d7d7'}">
	                            </div>
	                            <div ><font color="red" id="mobileSpanFont"  class="location-box"  style="line-height:38px;">请输入11位正确手机号码</font></div>
	                        </dd>
	                    </dl>
	                    <div class="check-box-address">
	                        <input type="checkbox" value="1" id="tmemberreceiver_is_default_checkbox"/>设置为默认收货地址
	                    </div>
	                    <div class="for-btn-box add-receive-box clearfix clear">
	                        <a href="javascript:saveOrupdateReceiver('receiverAdd','out2')" class="submit-refund">提 交</a>
	                        <a href="javascript:closeDiv('out2')" class="cancel-btn">取消</a>
	                    </div>
	                </div>
	            </div>
	        </div>
	        </form>
	    </div>
	    <!--新增收货人信息结束-->
     <!--新增收货人信息开始-->
     <!--
     <div class="com-out out out-box" id="out22" style="display:none">
    	<div class="double-out">
    	<form id="receiverAdd" name="receiverAdd" action="">
            <input type="hidden" name="tmemberreceiver.id" id="tmemberreceiver_id"  value=""/>
            <input type="hidden" name="memberReceiver_adcode" id="memberReceiver_adcode"  value=""/>
            <input type="hidden" name="tmemberreceiver.longitude" id="tmemberreceiver_longitude"  value=""/>
            <input type="hidden" name="city_name_set" id="city_name_set"  value=""/>
            <input type="hidden" name="tmemberreceiver.latitude" id="tmemberreceiver_latitude"  value=""/>
            <input type="hidden" name="tmemberreceiver.locationAddress" id="tmemberreceiver_locationAddress"  value=""/>
            <input type="hidden" name="tmemberreceiver_areaId" id="tmemberreceiver_areaId"  value=""/>
            <div class="firse-out">
                <h4 class="out-title">
                    <a href="javascript:closeDiv('out2')" class="close-out"></a>
                                                      完善收货人信息
                </h4>
                <div class="out-info clearfix clear">
                        <dl class="refund-details clearfix clear">
                            <dt><b>*</b>收货人：</dt>
                            <dd>
                                <div class="refund-box receive-p">
                                    <input type="text" name="tmemberreceiver.receiver" maxlength="10" class="refund-price" id="tmemberreceiver_receiver" value=""/>
                                </div>
                                <span><font color="red" id="receiverSpanFont"></font></span>
                            </dd>
                        </dl>
                        <dl class="refund-details clearfix clear">
                            <dt><b>*</b>位置：</dt>
                            <dd>
                                <div class="refund-list add-address choice-city" onclick="showCity()" id="city_div_id">
                                    <i></i>请选择
                                </div>
                                <div class="location-box">
                                    <input class="city-ipt" type="text" readonly="readonly" onclick="mapShow()" id="map_search" class="refund-price" value="请输入您的地址" onfocus="javascript:if(this.value=='请输入您的地址'){ this.value='';this.style.color='#333'}" onblur="javascript:if(this.value==''){ this.value='请输入您的地址';this.style.color='#afafaf'}">
                                </div>
                                <style>
                                .amap-logo,.amap-copyright{display:none}
                                </style>
                                <span><font color="red" id="weizhixinxi_span"></font></span>
                            </dd>
                        </dl>
                        <dl class="refund-details clearfix clear">
                            <dt><b>*</b>详细地址：</dt>
                            <dd>
                                <div class="refund-box receive-d">
                                    <input type="text" name="tmemberreceiver.address" maxlength="40" class="refund-price" id="tmemberreceiver_address" value=""/>
                                </div>
                                 <span><font color="red" id="addressSpanFont"></font></span>
                            </dd>
                        </dl>
                        <dl class="refund-details tel-details clearfix clear">
                            <dt><b>*</b>手机号码：</dt>
                            <dd>
                                <div class="refund-box">
                                     <input type="text" name="tmemberreceiver.mobile" class="refund-price" id="tmemberreceiver_mobile" value=""/>
                                </div>
                                <span><font color="red" id="mobileSpanFont"></font></span>
                            </dd>
                        </dl>
                        <dl class="refund-details tel-details clearfix clear">
                            <dt></dt>
                            <dd>
                            </dd>
                        </dl>
                    <div class="for-btn-box add-receive-box clearfix clear">
                        <a href="javascript:saveOrupdateReceiver('receiverAdd','out2')" class="submit-refund">保存收货人信息</a>
                    </div>
                </div>
            </div>
            </form>
            <div class="second-out">
            	<h4 class="out-title city-title">
                    <a href="javascript:closeCity()" class="close-city"></a>
                    请选择你所在的城市
                </h4>
                <div class="city-main">
                    <div class="city-location clearfix clear">
                        <div class="input-city">
                            <input class="city-ipt" type="text" id="search_input_id" value="请输入城市" onfocus="javascript:if(this.value=='请输入城市'){ this.value='';this.style.color='#333'}" onblur="javascript:if(this.value==''){ this.value='请输入城市';this.style.color='#afafaf'}"  onkeyup="searchCity()" />
                            <ul class="input-city-list" id="search_input_ul_id">
                            
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
            <div class="third-out">
            	<a href="javascript:closeMap()" class="close-add"></a>
            	<div class="show-map2">
                	<div class="map" id="container">
                    	<div class="ab-location">
                        	<div class="fill-lication">
                            	<input class="ipt-lication" type="text" id="search_keyword" class="refund-price" onkeyup="key_search()" value="请输入您的收货地址(写字楼,小区,街道或者学校)" onfocus="javascript:if(this.value=='请输入您的收货地址(写字楼,小区,街道或者学校)'){ this.value='';this.style.color='#333'}" onblur="javascript:if(this.value==''){ this.value='请输入您的收货地址(写字楼,小区,街道或者学校)';this.style.color='#999'}">
                            </div>
                            <a href="javascript:key_search()" class="search-location"></a>
                            <ul class="map-location-list" id="map_search_ul_id">
                            </ul>
                        </div>
                        <div class="manual-locate">
                            <a href="#" class="manual-locate-btn">手动选择地址</a>
                            <div class="out-info clearfix clear manual-locate-form" style="display:none">
                                <dl class="refund-details clearfix clear">
                                    <dt><b>*</b>位置：</dt>
                                    <dd>
                                        <span class="address-tip" id="cityName_span"></span>
                                        <div class="refund-list add-address">
                                            <select class="selete-box" id="area_select_one">
                                                <option value="">请选择</option>
                                            </select>
                                        </div>
                                        <span id="area_sq_span_id">
                                           
                                        </span>
                                        <span><font color="red" id="area_select_one_span"></font></span>
                                    </dd>
                                </dl>
                                <dl class="refund-details clearfix clear">
                                    <dt><b>*</b>详细地址：</dt>
                                    <dd>
                                        <div class="refund-box receive-d">
                                            <input type="text" maxlength="40" class="refund-price" id="tmemberreceiver_address_sd">
                                        </div>
                                        <span><font color="red" id="addressSpanFont_sd"></font></span>
                                    </dd>
                                </dl>
                                <dl class="refund-details tel-details clearfix clear">
                                    <dt><b>*</b>手机号码：</dt>
                                    <dd>
                                        <div class="refund-box">
                                            <input type="text" class="refund-price" id="tmemberreceiver_mobile_sd">
                                        </div>
                                        <span><font color="red" id="mobileSpanFont_sd"></font></span>
                                    </dd>
                                    
                                </dl>
                                <div class="for-btn-box">
                                    <a href="#" class="submit-refund" id="receiver_sd_save">保存</a><a href="#" class="cancle-refund">取消</a>
                                </div>
                            </div>
                        </div>
                        <style>
                        .manual-locate-btn{width: 154px; height: 40px; line-height: 40px; background: #3682d8; color: #fff; font-size: 14px; text-align: center; display: inline-block; position: relative; right: 40px; top: 10px; z-index: 999; float: right;}
                        .manual-locate .out-info{position: relative; padding:20px 0; top: 20px; left: 10px; right: 10px; width: 670px; overflow: hidden; z-index: 1099;}
                        .manual-locate .out-info .refund-details dt{width:140px;}
                        .manual-locate .out-info .refund-details dd{width:450px;}
                        </style>
                    </div>
                </div>
            </div>
            
        </div>
    </div>
    -->
    <!--新增收货人信息结束-->


    <!--编辑收货人信息开始-->
    <div class="out out-box" id="out3" style="display:none;">
        <h4 class="out-title">
            <a href="#" class="close-out"></a>
            编辑收货人信息
        </h4>
        <div class="out-info clearfix clear">
            <dl class="refund-details clearfix clear">
                <dt><b>*</b>收货人：</dt>
                <dd>
                    <div class="refund-box receive-p">
                        <input type="text" class="refund-price">
                    </div>
                </dd>
            </dl>
            <dl class="refund-details clearfix clear">
                <dt><b>*</b>1退货原因：</dt>
                <dd>
                    <div class="refund-list add-address">
                        <select class="selete-box">
                            <option>请选择</option>
                            <option>111</option>
                            <option>222</option>
                            <option>333</option>
                            <option>444</option>
                        </select>
                    </div>
                    <span class="address-tip">省</span>
                    <div class="refund-list add-address">
                        <select class="selete-box">
                            <option>请选择</option>
                            <option>111</option>
                            <option>222</option>
                            <option>333</option>
                            <option>444</option>
                        </select>
                    </div>
                    <span class="address-tip">市</span>
                    <div class="refund-list add-address">
                        <select class="selete-box">
                            <option>请选择</option>
                            <option>111</option>
                            <option>222</option>
                            <option>333</option>
                            <option>444</option>
                        </select>
                    </div>
                    <span class="address-tip">区</span>
                </dd>
            </dl>
            <dl class="refund-details clearfix clear">
                <dt><b>*</b>详细地址：</dt>
                <dd>
                    <div class="refund-box receive-d">
                        <input type="text" class="refund-price">
                    </div>
                </dd>
            </dl>
            <dl class="refund-details tel-details clearfix clear">
                <dt><b>*</b>手机号码：</dt>
                <dd>
                    <div class="refund-box">
                        <input type="text" class="refund-price">
                    </div>
                </dd>
                <dd class="tel-sec">固定电话：</dd>
                <dd>
                    <div class="refund-box">
                        <input type="text" class="refund-price">
                    </div>
                </dd>
            </dl>
            <dl class="refund-details tel-details clearfix clear">
                <dt>邮箱：</dt>
                <dd>
                    <div class="refund-box">
                        <input type="text" class="refund-price">
                    </div>
                </dd>
            </dl>
            <div class="for-btn-box add-receive-box clearfix clear">
                <a href="#" class="submit-refund">保存收货人信息</a>
            </div>
        </div>
    </div>
    <!--编辑收货人信息结束-->

    <!--删除收货人信息开始-->
    <div class="out out-box" id="out4" style="display:none">
        <h4 class="out-title">
            <a href="javascript:closeDiv('out4')" class="close-out"></a>
            删除收货人信息
        </h4>
        <div class="out-info clearfix clear">
            <h4 class="delete-teceive-tips">您确定要删除该收货地址吗？</h4>
            <div class="for-btn-box delete-receive-info clearfix clear">
                <input type="hidden" id="delete_receiverid" name="delete_receiverid">
                <a href="javascript:delReceiver()" class="submit-refund">确定</a><a href="javascript:closeDiv('out4')" class="submit-refund">取消</a>
            </div>
        </div>
    </div>
    <!--删除收货人信息结束-->
    
    <!--设置默认收货人信息开始-->
    <div class="out out-box" id="out5" style="display:none">
        <h4 class="out-title">
            <a href="javascript:closeDiv('out5')" class="close-out"></a>
            设置默认收货地址信息
        </h4>
        <div class="out-info clearfix clear">
            <h4 class="delete-teceive-tips">您确定要设置为默认收货地址吗？</h4>
            <div class="for-btn-box delete-receive-info clearfix clear">
                <input type="hidden" id="moren_receiverid" name="delete_receiverid">
                <a href="javascript:setDefaultReceiver()" class="submit-refund">确定</a><a href="javascript:closeDiv('out5')" class="submit-refund">取消</a>
            </div>
        </div>
    </div>
    <!--设置默认收货人信息开始-->

</div>
<!--遮罩层结束-->