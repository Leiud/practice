#  新建类时统一继承新式类
class Dog(object):

    def __init__(self, name):
        self.name = name

    def game(self):
        print("%s蹦蹦跳跳的玩耍..." % self.name)


class XiaoTianDog(Dog):

    def game(self):
        print("%s飞到天上去玩耍..." % self.name)


class Person(object):

    def __init__(self,name):
        self.name=name

    # 多态：都是 Dog 类型，看传入的具体参数类型
    def gameWithDog(self,dog):
        print("%s和%s玩耍" % (self.name,dog.name))
        dog.game()

#  wangcai=Dog("旺财")
wangcai = XiaoTianDog("飞天旺财")
xiaoming = Person("小明")
xiaoming.gameWithDog(wangcai)