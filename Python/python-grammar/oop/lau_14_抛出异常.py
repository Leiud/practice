def inputPassWord():
    #  提示用户输入密码
    pwd = input("请输入密码")
    #  判断密码长度>=8
    if len(pwd) >= 8:
        return pwd

    #  否则抛异常
    print("主动抛出异常")
    #  创建异常对象
    ex = Exception("密码长度不够")
    #  抛出异常
    raise ex


try:
    print(inputPassWord())
except Exception as result:
    print(result)
