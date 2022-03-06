name_list=["王五","李四","赵六"]

# 从列表中取值、取索引
# 索引超出范围会报错
print(name_list[0])
# 传递数据不在列表中会报错
print(name_list.index("李四"))

# 修改数据
# 索引超出范围会报错
name_list[1]="张三"
print(name_list)

# 增加数据
# 在列表末尾追加数据
name_list.append("修")
print(name_list)
# 在列表中插入数据
name_list.insert(1,"元'")
print(name_list)
# 在末尾合并另一个列表
list=["徐凤年","李淳罡","剑九黄"]
name_list.extend(list)
print(name_list)

# 删除数据
# 删除指定数据 第一次出现的
name_list.remove("张三")
print(name_list)
# 删除最后一个数据
name_list.pop()
print(name_list)
# 删除指定索引数据
name_list.pop(3)
print(name_list)
# 清空列表
name_list.clear()
print(name_list)

name="李"
del name
# del是从内存中删除，后续无法使用此变量

# 计算列表内元素数量
list_lens = len(name_list)
print(list_lens)
# 统计列表中某一元素出现次数
print("张三出现了%d次" % name_list.count("张三"))

num_list=[2,4,1,5,3]
# 升序排列
num_list.sort()
print(num_list)
# 降序排列
num_list.sort(reverse=True)
print(num_list)
# 逆序排列
num_list.reverse()
print(num_list)

# 迭代遍历
for num in num_list :
    print(num)