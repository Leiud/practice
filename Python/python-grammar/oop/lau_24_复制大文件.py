fileRead = open("readme.txt")
fileWrite = open("readme[复件].txt", "w")

while True:
    text = fileRead.readline()
    # 当读取完毕时，指针在文档末尾
    if not text:
        break
    fileWrite.write(text)

fileRead.close()
fileWrite.close()