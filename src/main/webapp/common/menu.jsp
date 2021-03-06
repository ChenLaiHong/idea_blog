<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
    <%
 pageContext.setAttribute("APP_PATH",request.getContextPath());
 %>
     <header>
      <div id="logo">
        <div id="logo_text">
          <!-- class="logo_colour", allows you to change the colour of the text -->
          <h1><a href="">个人<span class="logo_colour">_博客_中心</span></a></h1>
          <h2>${currentUser.sign}</h2>
        </div>
      </div>
      <div><c:if test="${currentUser.imageName ==null}"> 
				<img src="${APP_PATH}/static/images/moren.png"  class="img-circle" width="60" height="60" style="display: inline-block;" > 
			</c:if>
			<c:if test="${currentUser.imageName !=null}"> 
				<img src="${APP_PATH}/static/userImages/${currentUser.imageName }"  class="img-circle" width="60" height="60" style="display: inline-block;" > 
			</c:if></div>
    <nav>
        <ul class="sf-menu" id="nav">
          <li><a href="${APP_PATH}/toMain.do">个人博客</a></li>
          <li><a href="${APP_PATH}/toWriter.do">写博客</a></li>
          <li><a href="${APP_PATH}/toLink.do">链接</a></li>
          <li><a href="#">设置</a>
         	<ul>
          		<li><a href="${APP_PATH}/toUpdateUser.do">修改个人信息</a></li>
          		<li><a href="${APP_PATH}/toUpdatePass.do">修改密码</a> </li>
          	</ul>
          </li>
          <li><a href="${APP_PATH}/types.do">返回列表页</a></li>
          <li><a href="${APP_PATH}/loginout.do">安全退出</a> </li>
        </ul>
      </nav>
      </header>