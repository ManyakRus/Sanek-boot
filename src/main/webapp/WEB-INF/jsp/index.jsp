<!DOCTYPE HTML>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<html>
   <head>
      <meta charset="UTF-8" />
      <title>Sanek-boot</title>
      <link rel="stylesheet" type="text/css"
                href="${pageContext.request.contextPath}/css/style.css"/>
   </head>
   <body>
      <h1>Привет</h1>
      <h2>${message}</h2>
       
        <table border="1" cellpadding="5">
            <caption><h2>List of countries</h2></caption>
            <tr>
                <th>Code</th>
                <th>Name</th>
            </tr>
            <c:forEach var="c" items="${list}">
                <tr>
                    <td><c:out value="${c.code}" /></td>
                    <td><c:out value="${c.name}" /></td>
                </tr>
            </c:forEach>
        </table>
      
      <BR/>
      <a href="${pageContext.request.contextPath}/sendEmail">отправить емайл</a> <BR/> 
      <a href="${pageContext.request.contextPath}/personList">Person List</a>  
       
   </body>
   
</html>