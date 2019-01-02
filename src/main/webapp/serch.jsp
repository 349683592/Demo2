<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script type="text/javascript">

		function seacher(){
			$.post("${pageContext.request.contextPath}/mobile/findMobile",{"mobilenumber":$("#number").val()},function(data){
				alert(data);
			},"text")
		}
	

</script>
<title>Insert title here</title>
</head>
<body>
		<input type="text" id="number"/>
		<input type="button" value="查询" onclick="seacher()">
</body>
</html>