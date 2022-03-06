fileRead = open("readme.txt")
fileWrite = open("readme[复件].txt", "w")

text = fileRead.read()
fileWrite.write(text)

fileRead.close()
fileWrite.close()
