class MusicPlayer(object):
    #  记录第一个被创建对象的引用
    instance = None
    #  记录是否进行过初始化操作
    initFlag = False

    def __new__(cls, *args, **kwargs):
        #  判断类属性是否是空对象
        if cls.instance is None:
            #  创建对象时自动调用__new__
            print("创建对象，分配空间")
            #  为对象分配空间
            cls.instance = super().__new__(cls)

        #  返回对象的引用
        return cls.instance

    def __init__(self):
        #  判断是否进行过初始化操作
        if MusicPlayer.initFlag:
            return

        print("播放器初始化")
        MusicPlayer.initFlag = True


# 先运行 __new__，再运行 __init__
player1 = MusicPlayer()
print(player1)
player2 = MusicPlayer()
print(player2)
