<%--
  Created by IntelliJ IDEA.
  User: mabde
  Date: 3/15/2019
  Time: 2:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link href="/resources/css/style.css" rel="stylesheet" type="text/css"></script>
<html>
<head>
    <title>Sign Up</title>
</head>
<body>
<div class="container">
<h1>Fill the form to get full access</h1>
<div class="emailName">
    <label>Enter Your Name: <input type="text" name="uname"></label><br/>
    <label>Email: <input type="email" name="email"></label><br/>
</div>

<fieldset>
   <legend>Address</legend>
    <label>Street: <input type="text" name="street"></label>
    <label>Apartment: <input type="text" name="apartment"></label>
    <label> City: <input type="text" name="city"></label>
    <label> State:
    <select>
        <option>IA</option>
        <option>CA</option>
        <option>NY</option>
    </select>
    </label><br/>
    <label> ZIP CODE : <input type="number" name="zip"></label><br/>
    <label> Phone Number: <input type="number" name="phone"></label>
</fieldset><br/>

<label>Password: <input type="password" name="pass"></label><br/>
<label>Confirm Password: <input type="password" name="pass"></label>

</div>
</body>
</html>
