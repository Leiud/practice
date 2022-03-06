# 定义枪
class Gun:
    def __init__(self, model):
        # 枪的型号
        self.model = model
        # 子弹数量
        self.bulletCount = 0

    # 装弹
    def addBullet(self, count):
        self.bulletCount += count

    # 发射子弹
    def shoot(self):
        # 判断子弹数量
        if self.bulletCount <= 0:
            print("%s没有子弹了" % self.model)
            return
        # 发射子弹
        self.bulletCount -= 1
        # 提示发射信息
        print("[%s]突突突...\n剩余[%d]颗子弹" % (self.model, self.bulletCount))


# 定义士兵
class Soldier:
    def __init__(self, name):
        # 姓名
        self.name = name
        # 枪 新兵没有枪 定义没有初始值的属性时用None
        self.gun = None

    # 开火
    def fire(self):
        # 判断士兵是否有枪
        # is:身份运算符 比较内存地址是否一致
        if self.gun is None:
            print("[%s]还没有枪..." % self.name)
            return
        # 喊口号
        print("[%s]: 冲啊..." % self.name)
        # 装弹
        self.gun.addBullet(50)
        # 发射子弹
        self.gun.shoot()


# 创建枪对象
ak47 = Gun("Ak47")
ak47.addBullet(50)
# 创建士兵对象
soldier = Soldier("许三多")
soldier.gun = ak47
soldier.fire()
