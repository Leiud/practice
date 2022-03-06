# eval()函数：将 字符串 当成 有效的表达式 来求值 并 返回计算结果
print(eval("1+1"))
print(eval("'*'*10"))
print(type(eval("[1,2,3,4,5]")))
print(type(eval("{'name':'XiaoMing','age':18}")))

input_str = input("请输入算术题：")
print(eval(input_str))

"""
不要通过 eval() 直接转换 通过 input() 输入的内容
如 input 中输入的可是：__import__('os').system('ls')
__import__('os') 相当于 import os
os.system("终端命令")
"""
