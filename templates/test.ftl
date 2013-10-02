<#macro ck b>${b?string('checked="checked"', '')}</#macro>
<#macro formselect options selected="" value="" name="" id="">
		<#assign notExist = true>
		<#list options as o>
			<#if value != ''>
				<#if selected == o[value]>
					<#assign notExist = false>
					<#break>
				</#if>
			<#else>
				<#if o == selected>
					<#assign notExist = false>
					<#break>
				</#if>
			</#if>
		</#list>
</#macro>
<html>
<head>
  <title>Welcome!</title>
</head>
<body>
  <h1>Welcome ${user}!</h1>
  <p>Our latest product:
  <a href="${latestProduct.url}">${latestProduct.name}</a>!
  <#list shipMethods as sm>
     <br><input type="checkbox" name="${sm.code}" id="${sm.code}" <#list selected as selsm><@ck (sm.code==selsm.code)/></#list> value="${sm.description}"/>
         ${sm.description}
  </#list>
  
  <#if shipMethods??>shipMethods<#else>[""]</#if>
  <@formselect options=[""]  selected="preferredShipMethodId" id="preferredShipMethodId" name="preferredShipMethodId" value=""/>
  <p>
  <#assign lst = ["whale", "eel"]>
  
  <#if lst?? && (lst?size > 1)>
  	<#assign title="title=\"multiple\"">
  <#else>
    <#assign title="">
    list is less than 2.
  </#if>
  
  <br><span ${title}>hello</span><br>
  
  <#if lst?? && (lst?size > 1)>
  	<span title="<#list lst as i>- ${i} <#if i_has_next>&#13;</#if></#list>">multiple here</span>
  <#else>
    <span>List is less than 2</span>
  </#if>
  
</body>
</html>  