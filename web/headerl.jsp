

<%-- 
    Document   : header
    Created on : Sep 22, 2015, 5:00:57 PM
    Author     : swapnika
--%>

<%@page contentType="text/html" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Home</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="shortcut icon" href="favicon.ico" type="image/x-icon">
        <link rel="stylesheet" href="styles/main.css">
    </head>
    <body>
        
            <div class="site_header">
            <p id="title"><a href="home.jsp" target="_self">Researchers Exchange Participations</a></p>

<div class="about">
    <ul>
        <li id="about"><a href="aboutl.jsp" target="_self">About us</a></li>
        <li id="how"><a href="howl.jsp" target="_self">How it works</a></li>
        
        
        <li id="login"><c:out value="${theUser.getName()}" default="" /></li>
        
        
      

    </ul>
</div>

</div>