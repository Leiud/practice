try:
    num = int(input("请输入一个整数"))
    result = 8/num
    print(result)
#  捕获异常类型
except ValueError:
    #  处理错误的代码
    print("请输入正确的整数")
except ZeroDivisionError:
    print("除0错误")
except Exception as result:
    print("未知错误%s" % result)
else:
    print("尝试成功")
finally:
    print("这里无论是否出错都会执行")



