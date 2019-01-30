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

<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="./css/style.css">
<title>BuyItemConfirm</title>

</head>

<script type="text/javascript">
	function SubOrRet(url){
		$('form').attr('action',url);
		$('form').submit();
	}
</script>

<style type="text/css">

	table{
		display:inline-block;
		text-align:right;
		margin: 0px 10px;
	}

</style>

<body>

	<div id="header"></div>

	<div id="main">
		<div id="top"><p>BuyItemConfirm</p></div>

		<h3>購入内容を確認後、購入ボタンを押してください。</h3>


		<s:iterator value="#session.buyItemDTOList" status="status">
			<s:if test="stock[#status.index] != 0">
				<table>
					<tr>
						<td>商品名:</td><td><s:property value="itemName"/></td>
					</tr>
					<tr>
						<td>価格:</td><td><s:property value="itemPrice"/>円</td>
					</tr>
					<tr>
						<td>購入個数:</td><td><s:property value="stock[#status.index]"/>個</td>
					</tr>
				</table>
			</s:if>
		</s:iterator>


				<div><p>合計金額:<s:property value="#session.totalPrice"/>円</p></div>
				<div><p>お支払い方法:<s:property value="#session.payment"/></p></div>


		<form>
			<input type="button" value="購入" onclick="SubOrRet('BuyItemCompleteAction')"/>
			<input type="button" value="戻る" onclick="SubOrRet('HomeAction')"/>
		</form>



	</div>

	<div id="footer"></div>

</body>
</html>