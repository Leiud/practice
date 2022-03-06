class Dog(object):
    #  定义静态方法  即不需要实例/类属性的方法
    @staticmethod
    def run():
        print("跑")


#  通过类名调用方法  不需要创建对象
Dog.run()
