# 单行注释，距#一个空格
"""
多行注释
python不需要写：;
基本变量：
int：整数  python2.x还有long型
float：浮点型
bool：布尔型
str:字符串
python在定义变量时不需要定义变量类型，python解释器会自行判断
"""
name = "小明"  # 单行注释，距代码至少两个空格
isMan = True
age = 18
height = 179.5
"""
input():输入函数 输入类型默认为字符串
int():将字符串转化为整数
float():将字符串转化为小数
print():输出函数
"""
input=input("请输入一个数：")
# 格式化输出
# %s:字符串
# %d:整数
# %f:浮点数 .2:小数点后保留两位
# %%：输出%
print("%s今年%d岁身高%.2fcm" % (name,age,height))
print("您输入的数为：%.2f" % float(input))



