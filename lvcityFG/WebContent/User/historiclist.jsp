<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath %>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/base.css" rel="stylesheet" type="text/css">

<link href="css/pagename.css" rel="stylesheet" type="text/css">

</head>
<body>
	<body>
<div class="rightbar">
          	<div class="bread"><a href="index.html">首页</a> >${noticetype }</div>

			<ul class="ul_news">
                 <c:if test="${!empty HistoricleList }">
					<c:forEach items="${HistoricleList}" var="historic">
	        			
	       				 <li><span>${historic.releasetime}</span><a href="<%=basePath %>historic/watch.do?aid=${historic.aid}&pageNow=${pageNow }">${historic.articlename }</a></li>
	       			
	       			</c:forEach>
				 </c:if>
        
              </ul>

           		<div class="line">
                   <div class="fy_left">
                       共${rowCount }条&nbsp;|&nbsp;每页${pageSize }条&nbsp;|&nbsp;共${pageCount }页
                   </div>
                   <div class="fy_right">
                       <div class="fy"><a href="<%=basePath %>historic/watch.do?aid=${historic.aid}&pageNow=${pageCount }">尾页</a></div>
                       <div class="fy"><a href="<%=basePath %>historic/watch.do?aid=${historic.aid}&pageNow=${pageNow+1 }">下一页</a></div>
                       <div class="fy"><a>${pageNow }</a></div>
                       <div class="fy"><a href="<%=basePath %>historic/watch.do?aid=${historic.aid}&pageNow=${pageNow-1 }">上一页</a></div>
                       <div class="fy"><a href="<%=basePath %>historic/watch.do?aid=${historic.aid}&pageNow=1">首页</a></div>
                   </div>
               </div>

</div>
</body>
</html>