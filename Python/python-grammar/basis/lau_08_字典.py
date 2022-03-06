# 定义字典
dict={"name":"小明"
        }

# 取值
# 如果指定的key不存在会报错
print(dict["name"])
# 增加/修改
# 不存在则增加，存在则修改
dict["age"]=18
dict["name"]="小明明"
print(dict)
# 删除
# 如果指定的key不存在会报错
dict.pop("name")
print(dict)

# 统计字典中键值对数量
print(len(dict))
# 合并字典
# 如果被合并字典包含已存在键值对会覆盖原有键值对
height={"height": 1.79,
        "age" : 20}
dict.update(height)
print(dict)
# 清空字典
dict.clear()
print(dict)
 
# 循环遍历
for k in dict :
    print("%s---%s" % (k,dict[k]))