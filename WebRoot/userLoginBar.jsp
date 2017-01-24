<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="com.entity.*, com.dao.*, java.util.Iterator" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
  	<%!
  		User userLogin = new User();
  	 %>
  	<% 
  		String userNameInSession;
  		if(session.getAttribute("userName")!=null){
  			userNameInSession = (String)request.getSession().getAttribute("userName");
  			// Get log in user's obejct.
  			userLogin = UserDAO.getUserByName(userNameInSession);
  		}
  		else {
  			userNameInSession = null;
  		}
  	%>
  	<!-- Set jstl var userNameInSession -->
  	<c:set var="userNameInSession" value="<%=userNameInSession %>"/>
    <c:choose>
	    <c:when test="${userNameInSession == null}">
	    	<a href="login.jsp">登录</a>
	    </c:when>
	    <c:otherwise>
	    	<%=userLogin.getUserName() %>已登录，注销
	    </c:otherwise>
	</c:choose>  		
