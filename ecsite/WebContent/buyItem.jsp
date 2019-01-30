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
<title>BuyItem</title>

</head>
<style type="text/css">
	table{
		display:inline-block;
		text-align:right;
		margin: 0px 10px;
	}

	#payment{
		margin: 10px;
	}
</style>

<script type="text/javascript">

	function stockSelectMenu(itemStock){

		var j = itemStock;

		document.write("<select name=\"stock\">");
		document.write("<option value=\"0\" selected=\"selected\">0</option>");

		for(var i=1; i<=j; i++){
			document.write("<option value=\""+i+"\">"+i+"</option>");
		}

		document.write("</select>");
	}

</script>

<body>

	<div id="header"></div>

	<div id="main">

		<div id="top"><p>BuyItem</p></div>


		<s:form action="BuyItemAction">
			<s:iterator value="#session.buyItemDTOList">

				<input type="hidden" class="itemStock" value='<s:property value="itemStock"/>'/>

				<table>
					<tr>
						<td>商品名:</td><td><s:property value="itemName"/></td>
					</tr>
					<tr>
						<td>価格:</td><td><s:property value="itemPrice"/>円</td>
					</tr>


					<s:if test="itemStock != 0">
						<tr>
							<td>在庫:</td><td><s:property value="itemStock"/>個</td>
						</tr>

						<tr>
							<td>購入個数:</td>
							<td>
								<%-- <select name="stock">
									<option value="0" selected="selected">0</option>
									<option value="1">1</option>
									<option value="2">2</option>
									<option value="3">3</option>
									<option value="4">4</option>
									<option value="5">5</option>
								</select> --%>

								<script type="text/javascript">

									var itemStock_pre = document.getElementsByClassName("itemStock");
									var length = document.getElementsByClassName("itemStock").length;
									var itemStock = itemStock_pre[length-1].value;

									stockSelectMenu(itemStock);

								</script>


							</td>
						</tr>
					</s:if>


					<s:if test="itemStock == 0">
						<tr>
							<td>在庫:</td><td>在庫切れ</td>
						</tr>

						<tr>
							<td><input type="hidden" name="stock" value="0"></td>
						</tr>
					</s:if>


				</table>

			</s:iterator>

					<div id="payment">
						決算方法:
						<input  type="radio" name="pay" value="1" checked="checked"/>現金払い
						<input type="radio" name="pay" value="2"/>クレジットカード
					</div>

				<div><input type="submit" value="購入" id="submit"></div>

		</s:form>


		<s:if test="errorMessage != null">
				<div id="errorMessage"><s:property value="errorMessage"/></div>
		</s:if>

		<div>ホーム画面は<a href='<s:url action="GoHomeAction"/>'>こちら</a></div>
		<div>マイページは<a href='<s:url action="MyPageAction"/>'>こちら</a></div>



	</div>

	<div id="footer"></div>

</body>
</html>