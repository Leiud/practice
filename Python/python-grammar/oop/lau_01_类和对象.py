# 定义一个类
class Cat:

    #  定义方法
    #  哪一个对象调用的方法，self就是它的引用
    def eat(self):
        print("%s爱吃鱼" % self.name)

    def drink(self):
        print("%s要喝水" % self.name)

    # 初始化方法--设置属性  自动调用
    def __init__(self, name):
        self.name = name

    # 销毁方法  自动调用
    def __del__(self):
        print("%s已从内存中删除" % self.name)

    # str方法--类似于Java中的toString()
    def __str__(self):
        # 该方法必须要返回一个字符串
        return "我是小猫%s" % self.name

Tom = Cat("Tom")

# 增加属性  在外部直接增加  不推荐
# Tom.name = "Tom"
Tom.eat()
Tom.drink()
addr = id(Tom)
# 打印对象信息  调用str方法
print(Tom)
print("地址：\t10进制：%d--16进制：%x" % (addr, addr))


# 提前删除对象
# del Tom
print("-" * 50)
