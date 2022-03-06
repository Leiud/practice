class Game(object):
    #  历史最高分
    topScore = 0

    def __init__(self, playerName):
        self.playerName = playerName

    @staticmethod
    def showHelp():
        print("帮助信息：让僵尸进入大门")

    @classmethod
    def showTopScore(cls):
        print("历史纪录%s" % cls.topScore)

    def startGame(self):
        print("%s开始游戏了" % self.playerName)


#  查看帮助信息
Game.showHelp()
#  查看历史最高分
#  开始游戏
gamer = Game("小明")
gamer.startGame()
Game.topScore = 100
Game.showTopScore()
