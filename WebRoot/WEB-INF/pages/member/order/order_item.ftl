 <#include "/WEB-INF/pages/inc/taglibs.ftl">
 <#if orderItems?has_content>
 <#list orderItems as item>
 <div class="commodity-list">
 	<a href="${base}/p/${item.goods_id?default('')}.html">
    <dl>
        <dt><img src="${ui1}${item.abbreviation_picture?default('')}" width="50px" height="50px"/></dt>
        <dd>
            <span title="${item.goods_name}" >
			<#assign siz=item.goods_name.length()>
            <#if siz gt 4 >${item.goods_name[0..5]?default('')}...
   			<#else> ${item.goods_name?default('')}</#if>
   
            </span>
            <span>数量：${item.quantity?default(0)}台</span>
            <span>价格：<i>${currency(item.pc_price?default(0),"true")}</i></span>
        </dd>
    </dl>
    </a>
</div>
</#list>
</#if>
