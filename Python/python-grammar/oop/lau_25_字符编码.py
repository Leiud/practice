# *_* coding:utf8 *_*

"""
python2使用 ASCII 编码格式
python3使用 UTF-8 编码格式
    在计算机中使用 1-6 个字节表示一个 utf-8 字符，涵盖了地球几乎所有地区的文字
    大多数汉字使用 3 个字节表示

在python2中使用中文，需要在第一行加上：# *_* coding:utf8 *_*
"""

hello = "hello"
print(hello)

# python2中遍历字符
# 引号前面的 u 告诉解释器这是一个utf8编码格式的字符串
hello_str = u"hello,世界"
print(hello_str)
for c in hello_str:
    print(c)
