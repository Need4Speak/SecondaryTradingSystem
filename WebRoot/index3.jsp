<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="utf-8"%>
<%@ page language="java" import="com.entity.*, com.dao.*, java.util.Iterator" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
	    <% 
	    	GoodsDAO goodsDAO = new GoodsDAO();
			ArrayList<Goods> goodsList = goodsDAO.getAllGoods();
			if(goodsDAO.getAllGoods() != null) {
				Iterator<Goods> goodsListIterator = goodsList.iterator();
				Goods each_good;
		        while(goodsListIterator.hasNext()){
		        	each_good = (Goods) goodsListIterator.next();
		            System.out.println(each_good);
		        }
			}
			else {
				System.out.println("goodsList == null");
			}			
	    %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
  
  <body>
  </body>
</html>
