<form id="ttForm" action="../member/return!saveGoodsReturn.action" method="post" enctype="multipart/form-data">
    <div class="out-box out popup-add">
        <h4 class="out-title">
            <a href="#" class="close-out"></a>
            <ul class="refund-choice clearfix clear" id="lll"><!--  id="tab-hd2" -->
                <li class="active2" >我要退/换货</li>
            </ul>
            <input type="hidden" name="orderId" id="orderId"/>
            <input type="hidden" name="goodsId" id="goodsId"/>
        </h4>
        <div class="out-info clearfix clear">
            <ul class="refund-info" id="tab-bd2">
                <li class="choice-box">
                    <dl class="refund-details clearfix clear">
                        <dt><b>*</b>服务类型：</dt>
                        <dd style="width: 400px;">
                            <div class="refund-list">
                                <select onchange="changeTuihuanHuo()" class="selete-box" name="serviceType" id="serviceType">
                                    <option value="">请选择服务类型</option>
                                    <option value="0">退货</option>
                                    <option value="1">换货</option>
                                    <option value="2">退款(无需退货)</option>
                                </select>
                            </div>
                        </dd>
                    </dl>
                    <dl class="refund-details clearfix clear" id="goodsNumDiv">
                        <dt><b>*</b>商品个数：</dt>
                        <dd style="width: 400px;">
                            <div class="refund-box">
                                <input type="text" class="refund-price" maxlength="6" onkeyup="validateMaxNum(this)" name="goodsNum" id="goodsNum">
                            </div>
                            <span class="refund-tips">最多<span id="numTip" style="color:red;"></span>个<input type="hidden" id="_numTip"/></span>
                        </dd>
                    </dl>
                    <dl class="refund-details clearfix clear">
                        <dt><b>*</b>退换货说明：</dt>
                        <dd style="width: 400px;">
                            <div class="refund-box">
                                <textarea maxlength="150" style="border: 1px solid #d7d7d7;" class="refund-reason" onkeyup="checkLen(this)" name="refundDescribe" id="refundDescribe"></textarea>
                            </div>
                            <span class="refund-tips">还可以输入<span id="leaveCount" style="color:red;"></span>字<br/>（最多150字）</span>
                        </dd>
                    </dl>
                    <dl class="refund-details clearfix clear">
                        <dt>上传凭证：</dt>
                        <dd style="width: 400px;">
                            <ul class="refund-img clearfix clear">
                                <li><a href="javascript:void(0)"><input unselectable="on" type="file" name="image1" id="file1" class="file1" value="file1"/><span id="fileSpan1" class="fileSpan1">上传</span></a></li>
                                <li><a href="javascript:void(0)"><input unselectable="on" type="file" name="image2" id="file2" class="file1" value="file1"/><span id="fileSpan2" class="fileSpan1">上传</span></a></li>
                                <li><a href="javascript:void(0)"><input unselectable="on" type="file" name="image3" id="file3" class="file1" value="file1"/><span id="fileSpan3" class="fileSpan1">上传</span></a></li>
                                <li><a href="javascript:void(0)"><input unselectable="on" type="file" name="image4" id="file4" class="file1" value="file1"/><span id="fileSpan4" class="fileSpan1">上传</span></a></li>
                                <li><a href="javascript:void(0)"><input unselectable="on" type="file" name="image5" id="file5" class="file1" value="file1"/><span id="fileSpan5" class="fileSpan1">上传</span></a></li>
                            </ul>
                            <p class="upload-for mt10">
                                <!--<a class="upload-img-btn" href="#">上传图片</a>-->
                                <span>（最多五张图片，每张图片大小不超过5M，支持JPG格式）</span>
                            </p>
                        </dd>
                    </dl>
                    <div class="for-btn-box">
                        <a href="#" class="submit-refund" onclick="subApply()">提交</a><a href="#" class="cancle-refund">取消</a>
                    </div>
                    
                </li>
            </ul>
        </div>
    </div>
</form>
<div id="shade"></div>
<script type="text/javascript" src="${base}/web/js/jquery.min.js"></script>
<script type="text/javascript" src="${base}/web/js/return_apply.js"></script>
<link rel="stylesheet" type="text/css" href="${base}/web/css/return_apply.css"/>