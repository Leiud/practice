# 调用函数
# 导包
import lau_04_九九乘法表

lau_04_九九乘法表.multiple_table()


# 定义加法计算器
# 函数定义要求函数上方空两行


def sum(a, b):
    """
    函数解释文档：加法计算器
    :param a: 加数
    :param b: 加数
    :return: 和
    """
    # return之后的代码不会执行
    return a + b
    print("%d + %d = %d" % (a, b, a + b))


c = sum(1, 2)
print(c)
