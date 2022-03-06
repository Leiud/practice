# 定义家具类
class HouseItem:
    def __init__(self, name, area):
        self.name = name
        self.area = area

    def __str__(self):
        return "%s占地%.2f" % (self.name, self.area)


# 定义房子类
class House:
    def __init__(self, houseType, area):
        self.houseType = houseType
        self.area = area
        # 剩余面积
        self.freeArea = area
        # 家具列表
        self.itemList = []

    def __str__(self):
        # python能够自动将一对括号里的代码连接
        return ("户型：%s\n总面积：%.2f\n剩余面积：%.2f\n家具：%s"
                % (self.houseType, self.area,
                   self.freeArea, self.itemList))

    def addItem(self, item):
        """
        :type item: Object
        """
        print("要添加%s" % item)
        # 判断剩余面积是否够用
        if self.freeArea < item.area:
            print("%s太大了，无法添加" % item.name)
            return
        # 将家具添加到列表
        self.itemList.append(item.name)
        # 计算剩余面积
        self.freeArea -= item.area


# 创建家具对象
bed = HouseItem("席梦思", 4)
chest = HouseItem("衣柜", 2)
table = HouseItem("餐桌", 1.5)

# 创建房子对象
myHouse = House("两室一厅", 60)
myHouse.addItem(bed)
myHouse.addItem(chest)
myHouse.addItem(table)
