class Tool(object):
    #  定义类属性
    count = 0

    #  定义类方法
    @classmethod
    def showToolCount(cls):
        print(cls)
        print("工具对象总数%s" % cls.count)

    def __init__(self, name):
        self.name = name

        #  类属性值加1
        Tool.count += 1


tool1 = Tool("斧头")
tool2 = Tool("榔头")
tool3 = Tool("水桶")

tool3.count = 99

print("tool1工具对象总数=%s" % tool1.count)
tool1.showToolCount()
print("tool2工具对象总数=%s" % tool2.count)
tool2.showToolCount()
print("tool3工具对象总数=%s" % tool3.count)
tool3.showToolCount()

print("Tool工具对象总数=%s" % Tool.count)

# 使用类方法
Tool.showToolCount()
