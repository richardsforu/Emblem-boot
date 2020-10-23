<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>My First Spring Server Side Application</h1> <hr/>

<h2>Welcome dear ${pname}</h2>
<hr/>

<h1>${myCities}</h1>

<hr/>

<table border="1">
<thead>
	<tr>
		<th>Sno</th>
		<th>City Name</th>
	</tr>
</thead>

<tbody>
<c:forEach var="cityName" items="${myCities}" varStatus="sno">
<tr>
	<td>${sno.count}</td>
	<td>${cityName} </td>
</tr>
	
</c:forEach>

</tbody>

</table>















</body>
</html>