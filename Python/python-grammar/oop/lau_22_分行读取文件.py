flie = open("readme.txt")
while True:
    text = flie.readline()
    if not text:
        break
    print(text)
flie.close()
