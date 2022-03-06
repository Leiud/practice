"""
r     以只读方式打开文件。文件的指针将会放在文件的开头，默认模式。如果文件不存在，抛出异常。
w     以只写方式打开文件。如果文件存在会被覆盖。如果文件不存在，创建新文件
a     以追加方式打开文件。如果该文件已存在，文件指针将会放在文件的结尾。如果文件不存在，创建新文件进行写入
r+    以读写方式打开文件。文件指针将会放在文件的开头。不存在抛异常。
w+    以读写方式打开文件。存在，覆盖。不存在，新建
a+    以读写方式打开文件。如存在，指针在末尾，如不存在，建立新的，写入数据
"""
#  打开文件(以读写方式)
file = open("readme.txt", "a+")
#  写入
file.write("hello")
#  读取文件，需要指针在文件开头
# file.close()
# file = open("readme.txt")
text = file.read()
print(text)
print(len(text))
print("-" * 50)
#  使用read方法后文件指针会指向内容末尾
text = file.read()
print(text)
print(len(text))
#  关闭文件
file.close()
