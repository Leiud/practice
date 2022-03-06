# 定义一个元组
info = ("张三", 18, 1.79)

# 取值、取索引
print(info[0])
print(info.index("张三"))
# 统计计数
print(len(info))
print(info.count("张三"))
# 循环遍历
for i in info:
    # 使用格式化字符串拼接变量i不方便 因为元组内元素数据类型不同
    print(i)

"""
print("" % ()) ()本质是元组
list()和tuple()可以使元组和列表相互转换
"""