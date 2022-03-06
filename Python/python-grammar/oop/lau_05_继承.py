class Animal:

    def __init__(self):
        self.num1=10
        self.__num2=100

    def __test(self):
        print("公共属性num1=%d---私有属性num2=%d" % (self.num1,self.__num2))

    def test(self):
        print("公有方法")
        print("公共属性num1=%d---私有属性num2=%d" % (self.num1,self.__num2))

    def eat(self):
        print("吃")

    def drink(self):
        print("喝")

    def run(self):
        print("跑")

    def sleep(self):
        print("睡")


# 使用继承
class Dog(Animal):

    #  重写父类方法  扩展
    def run(self):
        #  调用父类方法
        super().run()
        #  或者  python2.x中使用  python3仍然支持
        #  最好不要用，否则可能自己调自己，死循环
        #  Animal.run()
        print("~不快")

    def bark(self):
        print("汪")

    def demo(self):
        #  子类对象的方法中不能访问父类的私有属性
        #  print("访问父类私有属性num2：%d" % self.__num2)
        #  子类对象的方法中不能访问父类的私有方法
        #  self.__test()

        #  跳过此方法
        #  pass

        #  访问父类公有属性
        print("父类公有属性num1=%d" % self.num1)
        self.test()


class XiaoTianDog(Dog):
    def fly(self):
        print("飞")

    # 重写父类方法  覆盖
    def bark(self):
        print("汪汪汪")


wangcai = Dog()
wangcai.eat()
wangcai.drink()
wangcai.run()
wangcai.sleep()
wangcai.bark()
wangcai.demo()
print("-"*50)
xiaotian = XiaoTianDog()
# 若子类重写父类方法，子类对象调用自己的方法
xiaotian.bark()
