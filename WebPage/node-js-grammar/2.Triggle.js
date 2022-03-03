//输出三角形
//process模块在使用时无需通过require()函数来加载该模块，可直接使用
//循环有多少行
for (var i = 0; i < 10; i++) {
    //每行要输出多少个*
    for (var j = 0; j < i; j++) {
        process.stdout.write('*');
    }
    console.log();
}