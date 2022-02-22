/****************************根据据您挑选的商品，当当为您推荐部分的显示和隐藏*************************/
function shopping_commend_show(imgObj)
{
	//查找id=shopping_commend_sort的对象
	var divObj = document.getElementById("shopping_commend_sort");
	//判断divObj的display的值
	if(divObj.style.display=="block")
	{
		divObj.style.display = "none";
		imgObj.src = "images/shopping_arrow_down.gif";
	}else
	{
		divObj.style.display = "block";
		imgObj.src = "images/shopping_arrow_up.gif";
	}
}

/**************************************购物车模块****************************************/
//表格中行的背景色：鼠标放上变#FFF，鼠标移出变#fefbf2
function productOver(trObj)
{
	trObj.style.backgroundColor = "red";
}
function productOut(trObj)
{
	trObj.style.backgroundColor = "white";
}
//删除商品：删除行
function deleteProduct(id)
{
	//是否真的要删除吗？
	if(window.confirm("你真的不考滤了吗？确定吗？"))
	{
		//获取tr节点
		var trObj = document.getElementById(id);
		//删除节点
		trObj.parentNode.removeChild(trObj);
		/*分两步写
		var node_tbody = trObj.parentNode;
		node_tbody.removeChild(trObj);
		*/
		//进行商品统计
		productCount();
	}
}



//商品计算：商品总金额、商品总积分、共节省的总金额
function productCount()
{
	//初始化变量
	var total = 0;		//总金额
	var jiesheng = 0;   //总节省
	var jifen = 0;      //总积分
	//获取id=shopList的表格对象
	var tableObj = document.getElementById("shopList");
	//找到表格中所有的行
	var arr_tr =  tableObj.rows;
	//循环每一个行，取出行中不同单元格的值
	for(var i=0;i<arr_tr.length;i++)
	{
		//先取出每一行中的所有单元格
		var arr_td = arr_tr[i].cells;
		//市场价："￥32.00" ——> "32.00"——> 32
		var price1 = parseFloat(arr_td[2].innerHTML.substr(1));
		//当当价："￥18.90 (59折)"——>"18.90(59折)"——>18.9
		var price2 = parseFloat(arr_td[3].innerHTML.substr(1));
		//数量：将数量由"字符串"转成"数值型"
		var count = parseInt(arr_td[4].firstChild.value);
		//积分
		var jifen2 = parseInt(arr_td[1].innerHTML)
		//**********************************************************
		total += price2 * count; //总金额
		jiesheng += (price1-price2) * count;  //总节省
		jifen += jifen2 * count;  //总积分
	}
	//将总金额、总积分、总节省写入对应的id对象中去
	document.getElementById("total").innerHTML = "&yen;"+total.toFixed(2);
	document.getElementById("jiesheng").innerHTML = "&yen;"+jiesheng.toFixed(2);
	document.getElementById("jifen").innerHTML = jifen;
}
//网页加载完成，调用价格统计函数，该函数不能带括号，因为是传地址，而不是传数值
window.onload = productCount;
