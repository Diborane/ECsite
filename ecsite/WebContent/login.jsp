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
<title>Login</title>


</head>
<body>

	<div id="header"></div>


	<div id="main">

		<div id="top"><p>Login</p></div>

			<h3>商品を購入する場合はログインをお願いします。</h3>


			<s:form action="LoginAction">
					<s:textfield name="loginUserId" label="ログインID"/>
					<s:textfield name="loginPassword" label="パスワード"/>
					<s:submit value="ログイン"/>
			</s:form>

			<s:if test="errorMessage != null">
				<br>
				<div id="errorMessage"><s:property value="errorMessage"/></div>
			</s:if>

			<br>
			<div>ホーム画面に戻る場合は<a href='<s:url action="GoHomeAction"/>'>こちら</a></div>
			<div>アカウントをお持ちでない方は<a href='<s:url action="UserCreateAction"/>'>こちら</a></div>

	</div>


	<div id="footer"></div>

</body>
</html>