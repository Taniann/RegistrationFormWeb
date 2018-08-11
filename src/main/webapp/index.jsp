<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<html>
<head>
    <title>Registration Form</title>
</head>
<body>
<form name="form" action="register" method="post" >
<table align="center">
 <tr>
 <td>Email</td>
 <td><input type="text" name="email" /></td>
 </tr>
 <tr>
 <td>Phone number</td>
 <td><input type="text" name="phoneNumber" /></td>
 </tr>
 <tr>
 <td>Login</td>
 <td><input type="text" name="login" /></td>
 </tr>
 <tr>
 <td>Password</td>
 <td><input type="text" name="password" /></td>
 </tr>
 <tr>
  <td>Confirm Password</td>
  <td><input type="text" name="conpassword" /></td>
  </tr>
 <tr>
 <td></td>
 <td><input type="submit" value="Register"></input><input
 type="reset" value="Reset"></input></td>
 </tr>
</table>
</form>
</body>
</html>