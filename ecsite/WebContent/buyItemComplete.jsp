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
<title>BuyItemComplete</title>

</head>
<body>

	<div id="header"></div>

	<div id="main">

		<div id="top"><p>BuyItemComplete</p></div>

		<h3>購入手続きが完了しました。</h3>

		<div>ホーム画面に戻るには<a href='<s:url action="GoHomeAction"/>'>こちら</a></div>
		<div>マイページは<a href='<s:url action="MyPageAction"/>'>こちら</a></div>

	</div>

	<div id="footer"></div>

</body>
</html>