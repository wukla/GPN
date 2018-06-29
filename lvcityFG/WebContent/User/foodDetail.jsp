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
<title>Insert title here</title>
</head>
<body>
	<div class="rightbar">

            	<div class="bread">
            		<span style="float:left;width:80px;height:30px;background-color:lightblue;text-align:center;margin-top:8px;">
            			<a style="cursor:pointer;color:red;display:block;" href="<%=basePath%>/User/Food?action=showList&ftid=${ftid}&pageNow=${pageNow}">返回列表</a>
            		</span>
            	</div>

            	<div class="con_news">

                	<p class="p_tit2">

                    	<span>${article.articlename }</span>

                        发布人:${admin.adminname }　　发布时间：${article.releasetime }

                  </p>

                	<div class="con" style="height:650px;">
						   ${article.content }
                    </div>

              </div>
              
   </div>

       
</body>
</html>