# 对象通用方法
## 覆盖 equals 时的注意事项
1. 自反性：对于任何非 null 的引用值 x，x.equals(x) 必须返回 true
2. 对称性：对于任何非 null 的引用值 x 和 y，当且仅当 y.equals(x) 返回 true 时，x.equals(y) 必须返回 true
3. 传递性：对于任何非 null 的引用值 x、y、z，如果 x.equals(y) 返回 true，并且 y.equals(z) 也返回 true，那么 x.equals(z) 也必须返回 true
4. 一致性：对于任何非 null 的引用值 x 和 y，只要 equals 的比较操作在对象中所用的信息没有被修改，多次调用 x.equals(y) 就会一致地返回 true，或者一致的返回 false
5. 对于任何非 null 的引用值 x，x.equals(null) 必须返回 false
## 覆盖 equals 时总要覆盖 hashCode
## 始终要覆盖 toString
## 谨慎覆盖 clone
## 考虑实现 Comparable 接口
> 类实现了 Comparable 接口，就表明它的实例具有内在的排序关系，实现了 Comparable 接口的对象数组进行排序只需要：`Arrays.sort(a);'`
# 接口和类
- 组合优于继承
- 接口优于抽象类
- 接口只用于定义类型，不应该用来导出常量
> 导出常量可用枚举或者不可实例化的工具类
- 类层次优于标签类
> 当你想要编写一个包含显示的标签域的类时，应该考虑一下，这个标签是否可以被取消，这个类是否可以用类层次来代替，当你遇到一个包含标签域的现有类时，就要考虑将它重构到一个层次结构中去
