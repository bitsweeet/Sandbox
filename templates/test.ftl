<#macro ck b>${b?string('checked="checked"', '')}</#macro>
<html>
<head>
  <title>Welcome!</title>
</head>
<body>
  <h1>Welcome ${user}!</h1>
  <p>Our latest product:
  <a href="${latestProduct.url}">${latestProduct.name}</a>!
  <#list shipMethods as sm>
     <br><input type="checkbox" name="${sm.code}" id="${sm.code}" <#list selected as selsm><#if sm.code==selsm><@ck b=(sm.code==selsm)/></#if></#list> value="${sm.description}"/>
         ${sm.description}
  </#list>
</body>
</html>  