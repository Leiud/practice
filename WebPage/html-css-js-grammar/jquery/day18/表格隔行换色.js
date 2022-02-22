$.fn.setTableColor=function(c1,c2){
	//this代表jQuery对象
	//首行颜色
	this.find('tr:first').css('background-color',c1);
	//奇遇行颜色
	this.find('tr:gt(0):odd').css('background-color',c2);
}

$(function(){
	$('table').setTableColor('yellow','lightblue');
});