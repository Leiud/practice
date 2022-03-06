str="hello hello"

# 统计字符串长度
print(len(str))
# 统计某一子串出现次数
print(str.count("llo"))
print(str.count("abc"))
# 统计某一子串出现位置
# 若传递的子字符串不存在会报错
print(str.index("llo"))

# 判断空白字符
space_str="     \t\n\r"
print(space_str.isspace())
# 判断字符串中是否只含数字
"""
都不能判断小数
1不能判断uncide
1，2不能判断汉字数字
"""
num_str="1"
print(num_str.isdecimal())
print(num_str.isdigit())
print(num_str.isnumeric())

hello_str="hello world"
# 判断是否以指定字符串开始，区分大小写
print(hello_str.startswith("hello"))
# 判断是否以指定字符串结束，区分大小写
print(hello_str.endswith("world"))
# 查找指定字符串索引,不存在则为-1
print(hello_str.find("llo"))
print(hello_str.find("abc"))
# 替换字符串内容，不会修改字符串，会返回新的字符串
new_str=hello_str.replace("world","python")
print(new_str)

# 切片
num_str="0123456789"
print(num_str[2:6])
print(num_str[2:])
print(num_str[0:6])
print(num_str[:6])
print(num_str[:])
print(num_str[::2])
print(num_str[1::2])
print(num_str[-1])
print(num_str[2:-1])
print(num_str[-2:])
print(num_str[-1::-1])
print(num_str[::-1])