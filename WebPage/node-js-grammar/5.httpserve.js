//根据用户不同请求，服务器做出不同响应（响应现有的html文件）

//加载http模块
var http = require('http');
//加载文件模块
var fs = require('fs');
//加载path模块
var path = require('path');
//加载mime模块
var mime = require('mime');
//创建http服务
http.createServer(function (req, res) {
    //将render函数挂载到res下
    res.render = function (filename, res) {
        fs.readFile(filename, function (err, data) {
            if (err) {
                throw err;
            }
            res.setHeader('Content-Type', mime.getType(filename));
            res.end(data);
        });
    }
    //获取用户请求的url
    console.log(req.url);
    //通过req.url获取用户请求的路径，根据不同的请求路径服务器做出不同的响应
    if (req.url === '/' || req.url === '/index') {
        //读取index.html文件
        //读取文件不必设置编码将二进制数据转换为字符串，直接将二进制数据发给浏览器，让浏览器转换
        res.render(path.join(__dirname, 'htmls', 'index.html'), res);
    } else if (req.url === '/login') {
        res.render(path.join(__dirname, 'htmls', 'login.html'), res);
    } else if (req.url === '/list') {
        res.render(path.join(__dirname, 'htmls', 'list.html'), res);
    } else if (req.url === '/register') {
        res.render(path.join(__dirname, 'htmls', 'register.html'), res);
    } else if (req.url === '/images/index.jpg') {
        //用户请求访问图片
        res.render(path.join(__dirname, 'htmls', 'images', 'index.jpg'), res);
    } else if (req.url === '/css/index.css') {
        //用户请求css文件
        res.render(path.join(__dirname, 'htmls', 'css', 'index.css'), res);
    } else if (req.url.startsWith('resource') && req.method === 'get') {
        //静态资源（.gif、.css、.jpg等）都在resource文件夹下
        //如果用户请求的是以/resource开头，并且是get请求，就认为用户是在请求静态资源
        res.render(path.join(__dirname, req.url), res);
    } else {
        res.render(path.join(__dirname, 'htmls', '404.html'), res);
    }
    //结束响应
}).listen(8080, function () {
    console.log('http://localhost:8080');
});

/*
//将转发逻辑封装到render()函数
function render(filename, res) {
    fs.readFile(filename, function (err, data) {
        if (err) {
            throw err;
        }
        res.setHeader('Content-Type', mime.getType(filename));
        res.end(data);
    });
}
*/
