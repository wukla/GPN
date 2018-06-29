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
<title></title>
</head>
<body>
<div class="rightbar">
          	<div class="bread">
          		<a href="<%=basePath%>" style="float:left">首页</a><span style="float:left">>${scenictype}</span>
          		<form method="post" action="<%=basePath %>/tourism/search.do?stid=${stid }&pageNow=1">
	          		<div style="width:200px;height:25px;float:right;">
	          			<input type="text" name="gjc" style="float:left;width:100px;height:25px;margin-top:5px;"/>
	          			<input type="submit" style="width:50px;height:30px;float:left;margin-top:5px;" value="搜索"/>
	          		</div>
          		</form>
            </div>

			<c:if test="${zwjl!=null }">
				<div style="width:100%;height:50px;text-align:center;color:red;float:left;font-size:20px;">暂无记录</div>
			</c:if>

          	 <ul class="ul_zj clearfix">
          	 	<c:if test="${!empty sceniclist }">
				<c:forEach items="${sceniclist}" var="s">
					<li><a href="<%=basePath %>/tourism/watch.do?stid=${s.stid}&aid=${s.aid}&pageNow=${pageNow }"><img src="${s.image }" width="220" height="140"><span>${s.sname }</span></a></li>
				</c:forEach>
				</c:if>
              </ul>

              
           		<div class="line">
                   <div class="fy_left">
                       共条${rowCount }&nbsp;|&nbsp;每页9条&nbsp;|&nbsp;共${pageCount }页
                   </div>
                   <div class="fy_right">
                       <div class="fy"><a href="<%=basePath%>/tourism/search2.do?stid=${stid}&gjc=${gjc }&pageNow=${pageCount }">尾页</a></div>
                       <div class="fy"><a href="<%=basePath%>/tourism/search2.do?stid=${stid}&gjc=${gjc }&pageNow=${pageNow+1 }">下一页</a></div>
                       <div class="fy"><a>${pageNow }</a></div>
                       <div class="fy"><a href="<%=basePath%>/tourism/search2.do?stid=${stid}&gjc=${gjc }&pageNow=${pageNow-1 }">上一页</a></div>
                       <div class="fy"><a href="<%=basePath%>/tourism/search2.do?stid=${stid}&gjc=${gjc }&pageNow=1">首页</a></div>
                   </div>
               </div>

</div>


</body>
</html>