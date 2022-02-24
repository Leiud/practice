/****************************根据据您挑选的商品，当当为您推荐部分的显示和隐藏*************************/
function shopping_commend_show(imgObj)
{
	//获取id=shopping_commend_sort的对象
	var content = document.getElementById("shopping_commend_sort");
	//判断内容层是显示/隐藏
	if(content.style.display == "block")
	{
		content.style.display = "none";
		imgObj.src = "images/shopping_arrow_down.gif";
	}else
	{
		content.style.display = "block";
		imgObj.src = "images/shopping_arrow_up.gif";
	}
}
/**************************************购物车模块****************************************/
//表格中行的背景色：鼠标放上变#FFF，鼠标移出变#fefbf2
function productOver(trObj)
{
	trObj.style.backgroundColor = "#FFF";
}
function productOut(trObj)
{
	trObj.style.backgroundColor = "#fefbf2";
}
//删除商品
function deleteProduct(id)
{
	//弹出确认对话框
	if(window.confirm("你确认要删除产品吗？"))
	{
		//获取指定id的对象
		var trObj = document.getElementById(id);
		//删除指定<tr>节点
		trObj.parentNode.removeChild(trObj);
		//调用商品统计的函数
		productCount();
	}
}


//商品计算：商品总金额、商品总积分、共节省的总金额
function productCount()
{
	//变量初始化
	var total = 0;		//商品总金额
	var jiesheng = 0;	//节省总金额
	var jifen = 0;		//商品总积分
	//获取id=shopList的表格对象
	var tableObj = document.getElementById("shopList");
	//获取由<tr>元素构成的数组对象
	var arr_tr_obj = tableObj.rows;
	//循环统计每一行的相关数据
	for(var i=0;i<arr_tr_obj.length;i++)
	{
		//获取每一行单元格构成的数组
		var arr_td_obj = arr_tr_obj[i].cells;
		//取出每一行中的单品积分、市场价、当当价、数量
		var count = arr_td_obj[4].firstChild.value; //数量
		var price1 = arr_td_obj[2].innerHTML.substr(1);//市场价："￥32.00".substr(1)="32.00"
		var price2 = parseFloat(arr_td_obj[3].innerHTML.substr(1)); //当当价
				//原始结果：￥18.90 (59折)
				//提取字符串："￥18.90 (59折)".substr(1) = "18.90(59折)"
				//提取浮点数：parseFloat("18.90(59折)") = 18.9
		//总积分：单品积分*数量
		jifen += arr_td_obj[1].innerHTML * count;
		//总商品金额：当当价*数量
		total += price2 * count;
		//总节省金额：(市场价-当当价)*数量
		jiesheng += (price1-price2)*count;
	}
	//*****************将结果写入到对应的id中去********************
	document.getElementById("total").innerHTML = "&yen; "+total.toFixed(2);
	document.getElementById("jifen").innerHTML = jifen;
	document.getElementById("jiesheng").innerHTML = "&yen; "+jiesheng.toFixed(2);
}
//网页加载完成，调用价格统计函数，该函数不能带括号，因为是传地址，而不是传数值
window.onload = productCount;
