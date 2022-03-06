#  若导入模块中存在相同函数，后导入的会覆盖先前的
import lau_15_测试模块1
import lau_16_测试模块2

#  为导入模块指定别名
import lau_15_测试模块1 as Dog
import lau_16_测试模块2 as Cat

#  从模块中导入工具
#  from lau_15_测试模块1 import sayHello
#  从模块中导入工具  起别名(当不同模块中函数名相同时)
#  from lau_15_测试模块1 import sayHello as say
#  从模块中导入所有工具
#  from lau_15_测试模块1 import *

"""
lau_15_测试模块1.sayHello()
lau_16_测试模块2.sayHello()

dog=lau_15_测试模块1.Dog()
print(dog)
cat=lau_16_测试模块2.Cat()
print(cat)
"""

Dog.sayHello()
Cat.sayHello()

dog = Dog.Dog()
print(dog)
cat = Cat.Cat()
print(cat)

#  查看模块完整路径
print(Dog.__file__)
