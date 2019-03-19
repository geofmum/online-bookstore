<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <title>BuyBook</title>

    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet" >
    <link rel="stylesheet" type="text/css" href="/resources/css/style.css"/>

    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css" integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr" crossorigin="anonymous">

    <c:forEach items="${styles}" var="style">
        <link rel="stylesheet" href="${style}"></link>
    </c:forEach>
</head>
<body>
<div class="container">
    <header class="blog-header">
        <div class="row tophdr">
            <div class="col-4">
                <a class="shopname" href="/">BuyBook</a>
            </div>

            <div class="col-8">
                <div class="float-right">
                    <%--<% String userName=session.getAttribute("uname").toString();%>--%>
                    <c:choose>
                    <c:when test="${user!=null}">
                        <a class="cart" href="/"><span class="fas fa-shopping-cart"></span> <span id="shoppingItems1" class="items">0</span></a>
                        <a class="btn btn-warning" href="logout"><i class="fas fa-user"></i> Logout</a>
                        <span class="userpadding"><em class="fas fa-user"></em>${user}</span>
                    </c:when>
                    <c:when test="${user==null}">
                        <a class="cart" href="/"><span class="fas fa-shopping-cart"></span> <span id="shoppingItems" class="items">0</span></a>
                        <a class="btn btn-warning" href="login"><i class="fas fa-user"></i> Login</a>
                        <a class="btn btn-warning" href="signup"><i class="fas fa-user-plus"></i> Sign up</a>
                    </c:when>
                    </c:choose>
                </div>
            </div>
        </div>
        <nav class="navbar navbar-expand-md navbar-dark" style="background:#563D7C">

            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item active">
                        <a class="nav-link" href="/">Home <span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Author</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Publisher</a>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Category
                        </a>
                        <div class="dropdown-menu dropdownlarge" aria-labelledby="navbarDropdown">
                            <div class="row">
                                <div class="col-md-6">
                                    <c:forEach items="${category}" var="cat" varStatus="status">
                                    <a class="dropdown-item" href="category?c=${status.index+1}">${cat}</a>
                                    </c:forEach>
                                </div>
                            </div>


                        </div>
                    </li>

                </ul>
                <c:if test="${pagename != 'signup'}">
                <form class="form-inline my-2 my-lg-0" action="search">
                    <select class="custom-select" name="c" id="inputGroupSelect01">
                        <option selected value="-1">All Categories</option>
                        <c:forEach items="${category}" var="cat" varStatus="status">
                            <a class="dropdown-item" href="#"></a>
                            <option <c:if test="${catindex == (status.index+1)}">selected </c:if>value="${status.index+1}">${cat}</option>
                        </c:forEach>

                    </select> &nbsp;
                    <input class="form-control mr-sm-2" value="${searchVal}" type="search" placeholder="Search" name="s" aria-label="Search">
                    <button class="btn btn-info" type="submit">Search</button>
                </form>
                </c:if>
            </div>
        </nav>
    </header>
</div>