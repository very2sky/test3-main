<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	alert("로그아웃 되었습니다!");
	location.href = "${pageContext.request.contextPath }/board/list.do";
</script>
</head>
<body>

</body>
</html>