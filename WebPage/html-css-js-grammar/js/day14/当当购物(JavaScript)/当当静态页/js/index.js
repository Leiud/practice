/*****************************************书讯快递***********************************************/
//（1）取得三个对象的id
//（2）三个DIV的高度一致
//（3）dome2中的内容与dome1的内容一样
//（4）dome的scrollTop属性来实现滚动
//（5）鼠标放上dome停止滚动、鼠标移开dome继续滚动

//（1）获取三个<div>的对象
var dome = document.getElementById("dome");
var dome1 = document.getElementById("dome1");
var dome2 = document.getElementById("dome2");
//（2）将三个<div>的高度设为一致
dome1.style.height = dome.offsetHeight + "px";
dome2.style.height = dome.offsetHeight + "px";
//dome1.style.backgroundColor = "#ff0000";
//dome2.style.backgroundColor = "#ffff00";
//（3）将dome1的内容复制到dome2中
dome2.innerHTML = dome1.innerHTML;
//（4）定时器：对dome对象的scrollTop属性进行修改，实现动画
var timer1 = window.setInterval("startScroll()",40);
function startScroll()
{
	dome.scrollTop++;
	//如果滚动上去的距离等于dome元素的高度，则从头开始滚动
	if(dome.scrollTop==dome.offsetHeight)
	{
		dome.scrollTop = 0;
	}
}
//（5）事件动画
dome.onmouseover = function(){
						window.clearInterval(timer1);
					}
dome.onmouseout = function(){
						timer1 = window.setInterval("startScroll()",40);
					}


/*************************************焦点图*****************************************/
/*
分析结果：
	（1）先让图片轮换起来
	（2）事件：鼠标放到图片上停止轮换、鼠标移开继续
	（3）序号也要跟着变背景：当前背景色为orange，其它背景色为空
	（4）事件：鼠标放到序号上停止轮换，图片也切换到对应那张图，移出继续轮换
*/

//（一）先让图片轮换起来
//获取id=dd_scroll图片对象
var imgObj = document.getElementById("dd_scroll");
var num = 1;//当前图片、全局变量
var timer2 = window.setInterval("imgSwap()",1000);
function imgSwap()
{
	//修改imgObj的src属性的值
	imgObj.src = "images/dd_scroll_"+num+".jpg";
	//更改序号背景色
	changeBgColor();
	//如果num=7，则num=1
	num++;
	if(num==7)
	{
		num = 1;
	}
}
//给图片增加onMouseOver事件、onMouseOut事件
imgObj.onmouseover = function(){
							window.clearInterval(timer2);
						}
imgObj.onmouseout = function(){
							timer2 = window.setInterval("imgSwap()",1000);
						}

//（二）让序号的背景色，跟着当前图片走。
function changeBgColor()
{
	//获取id=scroll_number的div对象
	var divObj = document.getElementById("scroll_number");
	//获取所有的<li>标签构成的对象数组
	var arr_lis = divObj.getElementsByTagName("li");
	//循环将所有的<li>标签的背景色清空
	for(var i=0;i<arr_lis.length;i++)
	{
		arr_lis[i].style.backgroundColor = "";
	}
	//将当前图片序号，更改背景色为orange
	arr_lis[num-1].style.backgroundColor = "orange";
}
//（三）鼠标放到序号上时，动画停止，图片要切换到相对应的图片上，
//鼠标移开，动画继续
function scrollStop(index)
{
	//清除定时器
	window.clearInterval(timer2);
	//将当前图片序号换成index
	num = index;
	//重新更改图片的src属性的值
	imgObj.src = "images/dd_scroll_"+num+".jpg";
	//更改当前li序号的背景色
	changeBgColor();
}
//鼠标移开，动画继续
function scrollStart()
{
	timer2 = window.setInterval("imgSwap()",1000);
}

/***********************************************首页选项卡切换效果*********************************************/
function showMe(index)
{
	//book_type_out是标签的当前样式
	//book_type 不是标签的当前样式
	//book_show 是内容的当前样式
	//book_none 不是当前内容的样式
	
	//定义一个数组
	var arr = ["history","family","culture","novel"];
	//循环数组
	for(var i=0;i<arr.length;i++)
	{
		document.getElementById(arr[i]).className = "book_type";
		document.getElementById("book_"+arr[i]).className = "book_none";
	}
	//当前的标签样式
	document.getElementById(arr[index]).className = "book_type_out";
	//当前的内容样式
	document.getElementById("book_"+arr[index]).className = "book_show";
}
