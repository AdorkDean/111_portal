
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="description" content="111医药馆网上药店是国家药监局认证指定网上药房|打造为老百姓服务药品价格低品种全|网上购药买药就选壹壹壹医药馆药品特卖网站">
    <meta name="keywords" content="壹壹壹医药馆|壹药馆|11医药馆|1药馆|医卡通|111医药馆|医药网|药品特卖网站">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <title>身份认证</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp"/>
    <link rel="icon" type="image/png" href="images/common/favicon.png">
    <meta name="mobile-web-app-capable" content="yes">
    <link rel="icon" sizes="192x192" href="images/common/favicon.png">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <link rel="apple-touch-icon-precomposed" href="images/common/favicon.png">
    <meta name="msapplication-TileImage" content="images/common/favicon.png">
    <meta name="msapplication-TileColor" content="#0e90d2">
</head>
<body class="health-bc">
<#include "/static/inc/version2.2.0/new_leader_header.ftl" />
<script>$("#leader_navicator li").eq(3).addClass("cur");</script>
<script type="text/javascript" src="/web/version2.2.0/editor/js/imagePreview.js"></script>
<script type="text/javascript" src="/web/version2.2.0/js/leaderIdentity.js"></script>
<script type="text/javascript" src="/web/version2.2.0/editor/js/ajaxfileupload.js"></script> 

<!--提现开始-->
<div class="my-pharmacy-page w1000" style="margin-top:25px;">
    <div class="personal-data">
        <ul class="data-nav">
            <li><a href="/leaderarticle/leaderarticle!myLeaderFans.action"><span>我的秀粉</span></a></li>
            <li><a href="/member/bindingAmount!presentRecordList.action"><span>提现记录</span></a></li>
            <li><a href="/member/bindingAmount!proceedsDetailList.action"><span>收益明细</span></a></li>
            <li class="current"><a href="/leaderarticle/leaderarticle!leaderIdentity.action"><span>身份认证</span></a></li>
            <li><a href="/leaderarticle/leaderarticle!leaderFunctionIntroduce.action"><span>特色功能</span></a></li>
        </ul>
        <div class="data-line"></div>
    </div>
    <div class="apply-list">
        <div class="identity-num">
            <span> <b>*</b>身份证号：</span>
            <input type="text" id="identityIdCard" value="${tleader.cardCode?default('')}"/>
        </div>
        <p><b>*</b>上传您的照片：  图片不大于2M</p>
        <dl>
            <dt>
                <span class="see-example">查看范例</span>
            <div class="example-img"><img src="http://img.zdfei.com/static/image/temp/20160609/20ca45f1d745fa637c3fa532ed3763ef.jpg" alt="" width="320" height="209"/></div>
            </dt>
            <dd>
                <div class="click-w">
 					<input unselectable="on" type="file" name="imgfile" id="imgfile0">
        			<span id="headImageTip"><img style="width:108px;height:78px;" src="${tleader.headUrl?default('')}"/></span><div class="health-close"></div>
        			<input type="hidden" class="image_url_hidden_v" value="${tleader.headUrl?default('')}" id="your_self_photo"/>
                </div>
            </dd>
        </dl>
        <p><b>*</b>上传您的资质：  最少上传一张最多五张，资质比如执业医师，执业药师，健康管理师，育婴师，药士，初中级药师，主管药师，护士资格证，中药调剂员等资质，图片不大于2M</p>
        <dl>
            <dt>
                <span class="see-example">查看范例</span>
            <div class="example-img"><img src="http://img.zdfei.com/static/image/temp/20160609/4117f8b117d6630a4b9bb5ca8790c899.jpg" alt="" width="320" height="209"/></div>
            </dt>
            <dd>
            	<#list datas?if_exists as resc>
                <div class="click-w">
 					<input unselectable="on" type="file" name="imgfile" id="imgfile${resc_index+1}">
        			<span id="headImageTip"><img style="width:108px;height:78px;" src="${resc.image_url?default('')}"/></span><div class="health-close"></div>
        			<input type="hidden" class="image_url_hidden_v" value="${resc.image_url?default('')}" id="your_belong_photo_${resc_index+1}"/>
	            	<input type="hidden" class="image_id_hidden_v" value="${resc.id?default('')}" id="leader_image_id_${resc_index+1}"/>
                </div>
                </#list>
                <#if size?exists>
                	<#if size == 0>
                	<div class="click-w">
	 					<input unselectable="on" type="file" name="imgfile" id="imgfile1">
	        			<span id="headImageTip">上传图片</span><div class="health-close"></div>
	        			<input type="hidden" class="image_url_hidden_v" value="" id="your_belong_photo_1"/>
                	</div>
                	<div class="click-w">
	 					<input unselectable="on" type="file" name="imgfile" id="imgfile2">
	        			<span id="headImageTip">上传图片</span><div class="health-close"></div>
	        			<input type="hidden" class="image_url_hidden_v" value="" id="your_belong_photo_2"/>
                	</div>
                	<div class="click-w">
	 					<input unselectable="on" type="file" name="imgfile" id="imgfile3">
	        			<span id="headImageTip">上传图片</span><div class="health-close"></div>
	        			<input type="hidden" class="image_url_hidden_v" value="" id="your_belong_photo_3"/>
                	</div>
                	<div class="click-w">
	 					<input unselectable="on" type="file" name="imgfile" id="imgfile4">
	        			<span id="headImageTip">上传图片</span><div class="health-close"></div>
	        			<input type="hidden" class="image_url_hidden_v" value="" id="your_belong_photo_4"/>
                	</div>
                	<div class="click-w">
	 					<input unselectable="on" type="file" name="imgfile" id="imgfile5">
	        			<span id="headImageTip">上传图片</span><div class="health-close"></div>
	        			<input type="hidden" class="image_url_hidden_v" value="" id="your_belong_photo_5"/>
                	</div>
                	</#if>
                	<#if size == 1>
                	<div class="click-w">
	 					<input unselectable="on" type="file" name="imgfile" id="imgfile2">
	        			<span id="headImageTip">上传图片</span><div class="health-close"></div>
	        			<input type="hidden" class="image_url_hidden_v" value="" id="your_belong_photo_2"/>
                	</div>
                	<div class="click-w">
	 					<input unselectable="on" type="file" name="imgfile" id="imgfile3">
	        			<span id="headImageTip">上传图片</span><div class="health-close"></div>
	        			<input type="hidden" class="image_url_hidden_v" value="" id="your_belong_photo_3"/>
                	</div>
                	<div class="click-w">
	 					<input unselectable="on" type="file" name="imgfile" id="imgfile4">
	        			<span id="headImageTip">上传图片</span><div class="health-close"></div>
	        			<input type="hidden" class="image_url_hidden_v" value="" id="your_belong_photo_4"/>
                	</div>
                	<div class="click-w">
	 					<input unselectable="on" type="file" name="imgfile" id="imgfile5">
	        			<span id="headImageTip">上传图片</span><div class="health-close"></div>
	        			<input type="hidden" class="image_url_hidden_v" value="" id="your_belong_photo_5"/>
                	</div>
                	</#if>
                	<#if size == 2>
                	<div class="click-w">
	 					<input unselectable="on" type="file" name="imgfile" id="imgfile3">
	        			<span id="headImageTip">上传图片</span><div class="health-close"></div>
	        			<input type="hidden" class="image_url_hidden_v" value="" id="your_belong_photo_3"/>
                	</div>
                	<div class="click-w">
	 					<input unselectable="on" type="file" name="imgfile" id="imgfile4">
	        			<span id="headImageTip">上传图片</span><div class="health-close"></div>
	        			<input type="hidden" class="image_url_hidden_v" value="" id="your_belong_photo_4"/>
                	</div>
                	<div class="click-w">
	 					<input unselectable="on" type="file" name="imgfile" id="imgfile5">
	        			<span id="headImageTip">上传图片</span><div class="health-close"></div>
	        			<input type="hidden" class="image_url_hidden_v" value="" id="your_belong_photo_5"/>
                	</div>
                	</#if>
                	<#if size == 3>
                	<div class="click-w">
	 					<input unselectable="on" type="file" name="imgfile" id="imgfile4">
	        			<span id="headImageTip">上传图片</span><div class="health-close"></div>
	        			<input type="hidden" class="image_url_hidden_v" value="" id="your_belong_photo_4"/>
                	</div>
                	<div class="click-w">
	 					<input unselectable="on" type="file" name="imgfile" id="imgfile5">
	        			<span id="headImageTip">上传图片</span><div class="health-close"></div>
	        			<input type="hidden" class="image_url_hidden_v" value="" id="your_belong_photo_5"/>
                	</div>
                	</#if>
                	<#if size == 4>
                	<div class="click-w">
	 					<input unselectable="on" type="file" name="imgfile" id="imgfile5">
	        			<span id="headImageTip">上传图片</span><div class="health-close"></div>
	        			<input type="hidden" class="image_url_hidden_v" value="" id="your_belong_photo_5"/>
                	</div>
                	</#if>
                </#if>
                
            </dd>
        </dl>
        <p><b>*</b>上传您的身份证正面：  图片不大于2M</p>
        <dl>
            <dt>
                <span class="see-example">查看范例</span>
            <div class="example-img"><img src="http://img.zdfei.com/static/image/temp/20160609/a99ebddfa502b4473a74f6bac738ead3.jpg" alt="" width="320" height="209"/></div>
            </dt>
            <dd>
                <div class="click-w">
 					<input unselectable="on" type="file" name="imgfile" id="imgfile6">
        			<span id="headImageTip"><img style="width:108px;height:78px;" src="${tleader.cardFirstUrl?default('')}"/></span><div class="health-close"></div>
        			<input type="hidden" class="image_url_hidden_v" value="${tleader.cardFirstUrl?default('')}" id="your_sfz_photo_1"/>
                </div>
            </dd>
        </dl>
        <p><b>*</b>上传您的身份证反面：  图片不大于2M</p>
        <dl>
            <dt>
                <span class="see-example">查看范例</span>
            <div class="example-img"><img src="http://img.zdfei.com/static/image/temp/20160609/8e2360f8676502259614f8655ad4fa38.jpg" alt="" width="320" height="209"/></div>
            </dt>
            <dd>
               <div class="click-w">
 					<input unselectable="on" type="file" name="imgfile" id="imgfile7">
        			<span id="headImageTip"><img style="width:108px;height:78px;" src="${tleader.cardTwoUrl?default('')}"/></span><div class="health-close"></div>
        			<input type="hidden" class="image_url_hidden_v" value="${tleader.cardTwoUrl?default('')}" id="your_sfz_photo_2"/>
                </div>
            </dd>
        </dl>
        <div class="health-submit">
            <!--p><input type="checkbox" class="checkbox" id="aggreen_check"/>同意 <a href="javascript:;">健康领秀活动相关说明</a></p-->
            <input type="button" value="提 交" class="health-submit-btn" id="health_submit_btn_new"/>
        </div>
    </div>
</div>

<div style="margin-top:20px;"><#include "/static/inc/version2.2.0/new_leader_footer.ftl"/></div>

<script type="text/javascript">
    $(function()
    {
    //图片预览监听事件
	imageUploadOnListener();
		
		
		//删除图片
		$(".health-close").click(function()
		{
	    	$(this).siblings("input[type='file']").val("");
	    	$(this).siblings("span").children("img").remove();
	    	$(this).siblings("span").html("上传图片");
	    	$(this).parent().find("input.image_url_hidden_v").val('');
	    	//图片预览监听事件
			imageUploadOnListener();
	    	//真正删除图片
	    	var del_id = $(this).parent().find("input.image_id_hidden_v").val();
	    	if(del_id != undefined)
	    	{
	    		var url = "/leaderarticle/leaderarticle!delLeaderImage.action";
				$.ajax
				({
					type: "POST",
					url: url,
					async: false,
					data:{"leader_image_id":del_id},
					dataType: "json",
					success: function(data){},error: function(e) {}  
				 });
	    	}
	    	
	    });
    	//查看范例
        $('.see-example').hover(function()
        {
            $(this).siblings('.example-img').show();
        },function()
        {
            $(this).siblings('.example-img').hide();
        });
        //提交
        $("#health_submit_btn_new").click(function()
        {
        	//身份证
			var identityIdCard = $.trim($("#identityIdCard").val());
			if(identityIdCard == '1101298948290192' || identityIdCard == '' || identityIdCard == undefined)
			{
				$alertCanDisplay("warn","请填写您的身份证号码！","111医药馆提示您",null);
				$("#identityIdCard").focus();
				return false;
			}  
			else
			{
				if(!isChinaIDCard(identityIdCard))
			    {
					$alertCanDisplay("warn","请填写正确的身份证号码！","111医药馆提示您",null);
					$("#identityIdCard").focus();
					return false;
			    }
			}  
			//您的照片
			var your_self_photo = $.trim($("#your_self_photo").val());  
			if(your_self_photo == null || your_self_photo == '' || your_self_photo == undefined)
			{
				$alertCanDisplay("warn","请上传您的照片,图片不大于2M！","111医药馆提示您",null);
				return false;
			}
			//您的资质
			var your_belong_photo_1 = $.trim($("#your_belong_photo_1").val());  
			var your_belong_photo_2 = $.trim($("#your_belong_photo_2").val());  
			var your_belong_photo_3 = $.trim($("#your_belong_photo_3").val());  
			var your_belong_photo_4 = $.trim($("#your_belong_photo_4").val());  
			var your_belong_photo_5 = $.trim($("#your_belong_photo_5").val());  
			//资质ID
			var leader_image_id_1 = $.trim($("#leader_image_id_1").val());
			var leader_image_id_2 = $.trim($("#leader_image_id_2").val());
			var leader_image_id_3 = $.trim($("#leader_image_id_3").val());
			var leader_image_id_4 = $.trim($("#leader_image_id_4").val());
			var leader_image_id_5 = $.trim($("#leader_image_id_5").val());
			if(your_belong_photo_1 == null || your_belong_photo_1 == '' || your_belong_photo_1 == undefined)
			{
				$alertCanDisplay("warn","请至少上传一张您的资质图片,且不大于2M！","111医药馆提示您",null);
				return false;
			}
			//您的身份证正面
			var your_sfz_photo_1 = $.trim($("#your_sfz_photo_1").val());  
			if(your_sfz_photo_1 == null || your_sfz_photo_1 == '' || your_sfz_photo_1 == undefined)
			{
				$alertCanDisplay("warn","请上传您的身份证正面,图片不大于2M！","111医药馆提示您",null);
				return false;
			}
			//您的身份证反面
			var your_sfz_photo_2 = $.trim($("#your_sfz_photo_2").val());  
			if(your_sfz_photo_2 == null || your_sfz_photo_2 == '' || your_sfz_photo_2 == undefined)
			{
				$alertCanDisplay("warn","请上传您的身份证反面,图片不大于2M！","111医药馆提示您",null);
				return false;
			}
			/*复选框
			var f = $("#aggreen_check").prop("checked");
			if(!f)
			{
				$alertCanDisplay("warn","请同意健康领秀活动相关说明！","111医药馆提示您",null);
				return false;
			}*/
			$(this).attr("disabled",true);
			$(this).val("正在提交中...");
			var url = "/leaderarticle/leaderarticle!saveIdentity.action";
			$.ajax
			({
				type: "POST",
				url: url,
				async: false,
				data:{"identityIdCard":identityIdCard,"your_self_photo":your_self_photo,"your_belong_photo_1":your_belong_photo_1,"your_belong_photo_2":your_belong_photo_2,"your_belong_photo_3":your_belong_photo_3,"your_belong_photo_4":your_belong_photo_4,"your_belong_photo_5":your_belong_photo_5,"your_sfz_photo_1":your_sfz_photo_1,"your_sfz_photo_2":your_sfz_photo_2,"leader_image_id_1":leader_image_id_1,"leader_image_id_2":leader_image_id_2,"leader_image_id_3":leader_image_id_3,"leader_image_id_4":leader_image_id_4,"5":leader_image_id_5},
				dataType: "json",
				success: function(data) 
				{  
					$alertCanDisplay("success","恭喜，资料提交成功！","111医药馆提示您",null);
					window.location.reload();
			    },  
			    error: function(e) {console.log(e)}  
			 });
			
        });
    });
    //单张图片上传
	function saveSigleImage(elementId)
	{
		  $.ajaxFileUpload(
		  {
			  url: "/leaderarticle/leaderarticle!saveImage.action",
			  secureuri: false,
			  fileElementId: elementId,
			  dataType: "json",
			  success: function(data, status)
		      {
		      	  $("#"+elementId).parent().find("input.image_url_hidden_v").val(data);
		      },
		      error: function(e) 
		      {  
		          console.log(e); 
		      }  
		  });
	 }
	 
	 //图片预览监听事件
function imageUploadOnListener()
{
	$("input[type=file]").on('click',null,function()
	{
		if(typeof FileReader==='undefined')
		{ 
			$(this).change(function()
			{
				loadImgForIE(this);
			})
		}
		else
		{ 
			$(this).change(function()
			{
				readFile(this);
				var obj = $(this);
				window.setTimeout(function()
				{
					var elementId = obj.attr("id");
					saveSigleImage(elementId)
				},500);
			})
		} 
	});
}
	 
	 
</script>
</body>
</html>