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
<title>MyPage</title>
</head>
<style type="text/css">
	table{
		text-align:center;
		margin:0px auto;
		border: 1px solid black;
	}

	td{
		border: 0.5px solid black;
		padding: 3px;
	}

	th{
		border: 1px solid black;
	}

</style>

<body>

	<div id="header"></div>

	<div id="main">
		<div id="top"><p>MyPage</p></div>

		<s:if test="message != null">
			<h3><s:property value="message"/></h3>
		</s:if>


		<s:if test="myPageDTOList == null || myPageDTOList.isEmpty() == true">
			<h3>ご購入情報はありません</h3>
		</s:if>

		<s:elseif test="myPageDTOList != null && myPageDTOList.isEmpty() == false">
			<h3>ご購入情報は以下になります</h3>

			<table>
				<tr>
					<th>商品名</th><th>合計額</th><th>合計個数</th><th>支払い方法</th><th>購入日</th>
				</tr>

				<s:iterator value="myPageDTOList">
					<tr>
						<td><s:property value="buyItemName"/></td>
						<td><s:property value="buyTotalPrice"/>円</td>
						<td><s:property value="buyTotalCount"/>個</td>
						<td><s:property value="payment"/></td>
						<td><s:property value="insertDate"/></td>
					</tr>
				</s:iterator>

			</table>

			<s:form action="MyPageAction" theme="simple">
				<input type="hidden" name="deleteFlg" value="1">
				<div id="submit"><s:submit value="履歴全削除"/></div>
			</s:form>

		</s:elseif>

		<div>ホーム画面に戻る場合は<a href='<s:url action="GoHomeAction"/>'>こちら</a></div>
		<div>ログアウトする場合は<a href='<s:url action="LogoutAction"/>'>こちら</a></div>
		<div><p>商品購入は<a href='<s:url action="HomeAction"/>'>こちら</a></p></div>

	</div>

	<div id="footer"></div>

</body>
</html>