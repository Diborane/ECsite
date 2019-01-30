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
<title>UserCreate</title>

</head>

<body>

	<div id="header"></div>

	<div id="main">
		<div id="top"><p>UserCreate</p></div>

		<h3>登録するユーザー情報を入力してください。</h3>

		<s:form action="UserCreateConfirmAction">
			<s:textfield name="loginUserId" label="ログインID" value=""/>
			<s:textfield name="loginPassword" label="パスワード" value=""/>
			<s:textfield name="userName" label="ユーザー名" value=""/>
			<s:submit value="登録確認画面へ"/>
		</s:form>

		<s:if test="errorMessage != null">
			<div id="errorMessage"><s:property value="errorMessage"/></div>
			<br/>
		</s:if>

		<div>ログイン画面に戻るには<a href='<s:url action="HomeAction"/>'>こちら</a></div>

	</div>

	<div id="footer"></div>

</body>
</html>