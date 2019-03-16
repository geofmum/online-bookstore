<%--
  Created by IntelliJ IDEA.
  User: mabde
  Date: 3/15/2019
  Time: 2:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
    <link rel="stylesheet" type="text/css" href="<c:url value="http://localhost:8080//resources/css/style.css"/>"/>
    <title>Sign Up</title>
</head>
<body>
<div class="container">
<h1>Fill the form to get full access</h1>
    <form  action="index.jsp" method="post">
        <div class="wrapper">
            <label>Enter Your Name: <input type="text" name="uname"></label><br/>
            <label>Email: <input type="email" name="email"></label><br/>


        <fieldset class="address">
            <legend>Address</legend>
            <label>Street: <input type="text" name="street"></label><br/>
            <label>Apartment: <input type="text" name="apartment"></label><br/>
            <label> City: <input type="text" name="city"></label><br/>
            <label> State:
                <select>
                    <option>IA</option>
                    <option>CA</option>
                    <option>NY</option>
                </select>
            </label><br/>
            <label> Zip Code : <input type="number" name="zip"></label><br/>
            <label> Phone Number: <input type="number" name="phone"></label>
        </fieldset><br/>

        <label>Password: <input type="password" name="pass"></label><br/>
        <label>Confirm Password: <input type="password" name="pass"></label><br/>

        <input type="submit">
        </div>

    </form>
</div>
</body>
</html>
