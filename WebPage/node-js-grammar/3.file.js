//文件操作
/*
    fs模块，在使用时必须通过require()函数来加载方可使用：var fs=require('fs');
    原因：
        process模块是全局模块，而fs模块不是全局模块
        全局模块可直接使用，而非全局模块需先通过require（''）加载
*/


//文件写入操作
//1.加载文件操作模块
var fs = require('fs');
//2.写入文件的信息
var msg = 'Hello World!';
//3.调用fs.writeFile()进行文件写入
fs.writeFile('./hello.txt',msg,'utf8',function (err){
    //如果err==null，表示写入文件成功
    if(err){
        console.log('写入文件出错！具体错误：'+err);
    }else{
        console.log('OK');
    }
});



//文件读取操作
//1.加载fs模块
var fs = require('fs');
//2.调用fs.readFile()方法读取文件
//此处的./是相对路径，相对的是执行node命令的路径，而不是相对于正在执行的这个js文件来查找文件
fs.readFile('./hello.txt',function (err,data) {
    if (err) {
        throw err;
    }
    //data的数据类型是一个Buffer对象，里面保存的是一个一个的字节（可理解为字节数组）
    //把Buffer对象转换为字符串需调用toString（），默认编码为utf-8
    console.log(data.toString('utf8'));
});

//读取文件时若传递了编码，则回调函数中的data默认会转换为字符串
fs.readFile('./hello.txt','utf8',function (err,data) {
    if (err) {
        throw err;
    }
    console.log(data);
});

console.log(__dirname);
console.log(__filename);

var path = require('path');
var filename = path.join(__dirname,'hello.txt');
console.log(filename);
fs.readFile(filename,'utf8',function (err,data) {
    if (err) {
        throw err;
    }
    console.log(data);
});



//创建文件夹
//1.加载文件操作模块
var fs = require('fs');
//2.创建目录
fs.mkdir('./test-mkdir',function (err) {
    if (err) {
        console.log('创建目录出错！详细信息如下：'+err);
    } else {
        console.log('创建目录成功！'); 
    }
});