<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<meta http-equiv="Content-Style" content="text/css">
<meta http-equiv="Content-Script-Type" content="text/javascript">
<meta http-equiv="imagetollbar" content="no">
<meta name="description" content="">
<meta name="keywords" content="" lang="ja">

<link rel="stylesheet" type="text/css" href="./css/style.css">
<title>Home</title>

</head>

<style type="text/css">

	#text-center{
		display:inline-block;
	 	text-align: center;

	 	/* display:flex;
	 	justify-content:center;
	 	align-items:center; */
	}

</style>

<body>

	<div id="header"></div>


	<div id="main">

		<div id="top"><p>Home</p></div>

		<div id="text-center">

			<s:form action="HomeAction">
				<s:submit value="商品購入"/>
			</s:form>

			<s:if test="#session.id != null">
				<br/>
				<p>マイページは<a href="<s:url action="MyPageAction"/>">こちら</a></p>
				<p>ログアウトする場合は<a href="<s:url action="LogoutAction"/>">こちら</a></p>
			</s:if>

		</div>

	</div>


	<div id="footer"></div>

</body>
</html>