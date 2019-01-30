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
<title>UserCreateConfirm</title>

</head>

<body>

	<div id="header"></div>

	<div id="main">
		<div id="top"><p>UserCreateConfirm</p></div>

		<h3>以下の内容で登録します。よろしければ登録ボタンを押してください。</h3>

		<div>ログインID:<s:property value="#session.loginUserId"/></div>
		<div>パスワード:<s:property value="#session.loginPassword"/></div>
		<div>ユーザー名:<s:property value="#session.userName"/></div>
		<br/>

		<s:form action="UserCreateCompleteAction">
			<div><s:submit value="登録"/></div>
		</s:form>


	</div>

	<div id="footer"></div>

</body>
</html>