<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">

function validateForm(form){

	let id=form.id.value;
	let name=form.name.value;
	let price=form.price.value;
	let description=form.description.value;

	if(id=="" || id.length===0){
		document.getElementById("idErrorMsg").innerHTML="Id is Required";
			return false;
		}else{
			document.getElementById("idErrorMsg").innerHTML="";
				}

	return true;
}

</script>
</head>
<body>

<h1>Product Form</h1>

<jsp:include page="./menu.jsp"/>
<hr/>
<form action="saveProductV1"  onsubmit="return validateForm(this)" method="post">
<input name="id" placeholder="Product Id">
<span id="idErrorMsg"></span>
 <br/>
<input name="name" placeholder="Product Name"> <br/>
<input name="price" placeholder="Price"> <br/>
<textarea name="description" placeholder="Product Description"></textarea><br/>
<input type="submit" value="Save">
</form>

</body>
</html>