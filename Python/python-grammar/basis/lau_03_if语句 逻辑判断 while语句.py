# 定义变量时，=左右各一个空格
# 变量均用小写字母，变量之间用下划线分隔
# 或者用驼峰法 小驼峰：firstName  大驼峰：FirstName
import random  # 导入随机数包

# if条件判断
x = int(input("请输入一个数："))
if x > 10:
    print("%d>10" % x)
else:
    print("%d<10" % x)

# 逻辑判断
# 当判断条件过长时：
if ((x > 0 and x < 10)
        or (x > 10 and x < 20)
        or (x > 20 and x < 30)
        or (x > 30 and x < 40)):
    print("%d<40" % x)
elif x > 40:
    print("%d>40" % x)
else:
    # 1-100内的随机数，包括1和100
    y = random.randint(1, 100)
    if (x < y):
        print("%d<%d" % (x, y))

# while循环语句
i = 1
while i < 10:
    # print默认输出换行，end可使其不换行
    if i == 9:
        print(i)
    else:
        print(i, end="\t-\t")
    i += 1
i = 1
while i < 10:
    if i % 2 == 0:
        # 跳过此次后续步骤，进入下一次循环
        i += 1
        continue
    elif i == 9:
        # 跳出循环
        break
    else:
        print(i, end=" ")
        i += 1
