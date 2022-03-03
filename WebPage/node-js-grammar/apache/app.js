//模拟Apache服务器，静态资源都放在public文件夹下

//加载模块
var http = require('http');
var path = require('path');
var fs = require('fs');
var mime = require('mime');

//创建服务
http.createServer(function (req, res) {
    //1.获取用户请求路径
    //2.获取public目录的完整路径
    var publicDir = path.join(__dirname, 'public');
    //3.根据public的路径和用户请求的路径，最终计算出用户请求的静态资源的完整路径
    var filename = path.join(publicDir, req.url);
    //4.根据文件的完整路径去读取该文件，如果读取到了，就把文件返回给用户，否则返回404
    fs.readFile(filename, function (err, data) {
        if (err) {
            res.end('文件不存在！');
        } else {
            //通过第三方模块mime来判断不同的资源对应的Content-Type裂隙
            //在app.js所在的文件夹下使用---npm install mime 命令
            res.setHeader('Content-Type', mime.getType(filename));
            //如果找到了用户要读取的文件，就把该文件返回给用户
            res.end(data);
        }
    });
}).listen(9090, function () {
    console.log('http://localhost:9090');
});
