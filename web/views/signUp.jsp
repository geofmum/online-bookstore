<%--
  Created by IntelliJ IDEA.
  User: mabde
  Date: 3/15/2019
  Time: 2:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign Up</title>
</head>
<body>
<label>Enter Your Name: <input type="text" name="uname"></label>
<label>Email: <input type="email" name="email"></label>
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
    </label>
    <label> ZIP CODE : <input type="number" name="zip"></label>
    <label> Phone Number: <input type="number" name="phone"></label>
</fieldset>

<label>Password: <input type="password" name="pass"></label>
<label>Confirm Password: <input type="password" name="pass"></label>


</body>
</html>
