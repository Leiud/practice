class Woman:
    def __init__(self, name):
        self.name = name
        # 定义私有属性，在外部无法访问
        self.__age = 18

    # 私有方法 同样不允许在外界访问
    def __secret(self):
        print("%s的年龄是%d" % (self.name, self.__age))


xiaoxiao = Woman("小小")

# python中不存在真正的私有，还是可以在外部访问
print(xiaoxiao._Woman__age)
xiaoxiao._Woman__secret()

# 无法访问
xiaoxiao.__secret()
print(xiaoxiao.__age)
