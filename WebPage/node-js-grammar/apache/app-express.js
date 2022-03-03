//入口文件
//模拟静态资源服务器（Apache服务器）

//加载express模块
var express = require('express');
var path = require('path');

//创建app对象
var app = express();

//处理静态资源的方法
//静态资源在public目录下
/*
var fn = express.static(path.join(__dirname,'public'));
//注册路由
app.use('/',fn);
*/
//   /index.html
app.use('/',express.static(path.join(__dirname,'public')));
//参数1叫做虚拟路径   /xxx/index.html
app.use('/xxx',express.static(path.join(__dirname,'public')));

//启动服务
app.listen(9999,function () {
    console.log('http://localhost:9999');
});