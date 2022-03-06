# 定义九九乘法表的函数
def multiple_table():
    row = 1
    while row <= 9:
        col = 1
        while col <= row:
            print("%d * %d = %d" % (col, row, col * row), end="\t")
            col += 1
        print("")
        row += 1


# 使用此函数 先定义再使用
multiple_table()
