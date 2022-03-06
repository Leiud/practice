class A :
    def test(self):
        print("Atest方法")

class B :
    def demo(self):
        print("Bdemo方法")

    def test(self):
        print("Btest方法")

class C(B,A):
    #  多继承让子类对象拥有多个父类的属性和方法
    pass


c = C()
#  当父类方法重名时，继承的方法是第一个
c.test()
c.demo()

#  查询方法搜索顺序
print(C.__mro__)


