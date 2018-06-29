
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE HTML>

<html>

<head>
<base href="<%=basePath%>">

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<title>绿城之都-南宁</title>

<meta content="绿城之都-南宁" name="keywords" />

<meta content="绿城之都-南宁" name="description" />

<link href="css/base.css" rel="stylesheet" type="text/css">

<link href="css/pagename.css" rel="stylesheet" type="text/css">

<script type="text/javascript" src="js/jquery-1.6.2.min.js"></script>

<script type="text/javascript" src="js/jquery.SuperSlide.2.1.js"></script>
	

<script  type="text/javascript">
//加入收藏

function AddFavorite(sURL, sTitle) {

    sURL = encodeURI(sURL); 
try{  

    window.external.addFavorite(sURL, sTitle);  

}catch(e) {  

    try{  

        window.sidebar.addPanel(sTitle, sURL, "");  

    }catch (e) {  

        alert("加入收藏失败，请使用Ctrl+D进行添加,或手动在浏览器里进行设置.");

    }  

}

}

//设为首页

function SetHome(url){

if (document.all) {

    document.body.style.behavior='url(#default#homepage)';

      document.body.setHomePage(url);

}else{

    alert("您好,您的浏览器不支持自动设置页面为首页功能,请您手动在浏览器里设置该页面为首页!");

}

}
</script>

</head>

<body>
  <%  HttpSession se = request.getSession();
      List banarList = (List)se.getAttribute("banarList");
      List articleList = (List)se.getAttribute("articleList"); 
      List scenicList = (List)se.getAttribute("scenicList"); 
      List foodList = (List)se.getAttribute("foodList"); 
      %>

<!--header开始--> 

<div class="header"> 

	<div class="w1000">

    	<p>你好，欢迎光临绿城之都南宁！</p>

        <div class="contact">
	        <a onclick="SetHome(window.location)" href="javascript:void(0)">设为首页</a> 
	        <a onclick="AddFavorite(window.location,document.title)" href="javascript:void(0)"  >加入收藏</a>
        </div>

	</div>

</div>





<div class="w1000">

	<div class="header_bottom">

			<a href="<%=basePath%>"><img src="images/logo.jpg" width="294" height="49" alt="" title="绿城之都-南宁"></a>

       		<ul>


            	<li><a href="<%=basePath%>User/Index">网站首页</a></li>       
				<!-- 在页面上使用网站地址调用servlet的方法 -->
            <li><a href="<%=basePath%>historic/show.do">历史</a></li>     

                <li><a href="<%=basePath%>beautiful/yu.do">风景</a></li>        

                <li><a href="<%=basePath%>tourism/showtourism.do">旅游</a></li>      

                <li><a href="<%=basePath%>User/Food?action=show">美食</a></li>      

                <li><a href="<%=basePath%>noticetype/show.do">动态</a></li>      

                <li><a href="<%=basePath%>leave/huang.do">留言</a></li>   
				
				 <li><a href="<%=basePath%>team/show.do">团队介绍</a></li>      

                <li><a href="<%=basePath%>connection/show.do">联系我们</a></li>

     		</ul>  

    </div>       

</div>


<!--header结束--> 


<div class="container"> 		

		<!--banner开始-->

		<div class="banner"> 

            <div class="bd">

                <ul>
					
					<c:if test="${!empty banarList }">
					<c:forEach items="${banarList}" var="banar">
						<li style="background:url(${banar.image}) no-repeat center top;"></li>
					</c:forEach>
					</c:if>
                </ul>

            </div>

            <div class="hd">

                <ul>

                    <li></li>

                    <li></li>

                </ul>

            </div>

            <a class="prev" href="javascript:void(0)"></a>

            <a class="next" href="javascript:void(0)"></a>

        </div>
		 <!--调用JS模块图片滚动--> 
        <script type="text/javascript">jQuery(".banner").slide({ titCell:".hd ul", mainCell:".bd ul", effect:"fold",delayTime:1000,interTime:5000,autoPlay:true, autoPage:true, trigger:"click" });</script>

		<!--banner结束--> 

		

		<!--content开始-->

		<div class="content"> 

			<p class="p_tit1">走进南宁</p>	

			<ul class="ul_jishu clearfix">
				<c:if test="${!empty articleList }">
					<c:forEach items="${articleList}" var="article">
						<li class="fl ml10">
							<a href="<%=basePath%>historic/look.do?aid=${article.aid}&pageNow=1"><img src="${article.image}" width="291" height="126" alt="" title=""></a>
							<p>
                    		<a href="<%=basePath%>historic/look.do?aid=${article.aid}&pageNow=1">${article.articlename}</a>
                    		${article.content}
                    		</p>

                		</li>
					</c:forEach>
				</c:if>
            </ul>	


			<!-- 走进南宁图片 -->
            <div class="feilei">
                <c:if test="${!empty scenicList }">
					<c:forEach items="${scenicList}" var="scenic" varStatus="number">
						<div class="fl${number.count } fldiv">
		                	<a href="<%=basePath%>beautiful/look.do?aid=${scenic.aid}"><img src="${scenic.image }" width="75" height="76" alt="" title=""></a>
		                    <p><a href="<%=basePath%>beautiful/look.do?aid=${scenic.aid}">${scenic.sname }</a></p>
                		</div>
					</c:forEach>
				</c:if>
            </div>

            <div class="zjfc">

            	<p class="p_tit1">美食南宁</p>

                <div class="picScroll-left">

                    <div class="hd">

                        <a class="next"><</a>

                        <a class="prev">></a>

                    </div>
					
					<!-- 美食南宁图片 -->
                    <div class="bd">
                        <ul class="picList">
	                       <c:if test="${!empty foodList }">
								<c:forEach items="${foodList}" var="food">
									<li>
										<a href="<%=basePath%>delicacy/look.do?aid=${food.aid}"><div class="pic"><img src="${food.image }" width="231" height="151" /></div></a>
		                           	</li>
								</c:forEach>
							</c:if>
						</ul>
                    </div>

                </div>

        		<!--为美食南宁模块图片向左滚到--> 

                <script type="text/javascript">

                jQuery(".picScroll-left").slide({titCell:".hd ul",mainCell:".bd ul",autoPage:true,effect:"left",autoPlay:true,vis:4,trigger:"click"});

                </script>
			
            </div>

		</div>

		<!--content 结束--> 

</div>

<!--footer开始-->

<div class="footer"> 

	<p><a href="<%=basePath%>User/Index">首页</a> | <a href="<%=basePath%>historic/show.do">历史</a> | <a href="<%=basePath%>/beautiful/yu.do">风景</a> | <a href="<%=basePath%>tourism/showtourism.do">旅游</a> | <a href="<%=basePath%>/User/Food">美食</a> | <a href="<%=basePath%>noticetype/show.do">动态</a> | <a href="<%=basePath%>leave/huang.do">留言</a>| <a href="<%=basePath%>connection/show.do">联系我们</a></p>

<p>Copyright &copy; 2015－2016 All Rights Reserved 版权所有 XXXXXXXXXXXXXXXXXX</p>
  <p>地址：XXXXXXXXXXXXXXXXXX  来源:<a href="http://www.mycodes.net/" target="_blank">源码之家</a> </p>
  
</div>



<!--footer 结束--> 

</body>

</html>

