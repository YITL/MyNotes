```swift
//1基本函数
func addTwoNum(num1: Int, num2: Int) -> Int {
    return num1 + num2
}
let sum = addTwoNum(num1: 2, num2: 4)
```

```swift
//2相当于Java中的重写toString
class Person{
    var name: String
    var age: Int
    init(name: String, age: Int) {
        self.name = name
        self.age = age
    }
}
extension Person: CustomStringConvertible {
    var description: String {
        get{
            return "\(name) age \(age)"
        }
    }
}
let zhangsan = Person(name: "zhangsan", age: 19)
```

```swift
//3元组
//3.1通过下标访问
let error = (1, "没有权限")
print(error)
print(error.0)
print(error.1)
//3.2通过名字访问
let errorWithName = (errorCode: 1, errorMsg: "没有权限")
print(errorWithName.errorCode)
print(errorWithName.errorMsg)
//3.3元组的修改（元组创建后，不可以增加和删除，不可以修改值的类型）
var error = (1, "没有权限")
error.0 = 2
print(error)
//3.4在定义元组的时候，把类型设置为any类型，则可以随便赋值
var error: (Int, Any) = (1, "没有权限")
error.1 = 123
print(error)
//3.5元组的分解
let error = (1, "没有权限")
let (errorCode, errorMsg) = error
print(errorCode)
print(errorMsg)
//3.6元组作为函数参数和返回值
func test(content: (Int, String)) -> (Int, Int){
    return (content.0, 666)
}
let error = (1, "测试")
let res = test(content: error)
print(res)
```

```swift
//4,optional
//4.1optional强制展开
var str: String? = "abc"
if str != nil {
    let count = str!.count
    print(count)
}
//4.2optional绑定
var str: String? = "abc"
if let tempStr = str {
    let count = tempStr.count
    print(count)
}
//4.3optional隐式展开
var str: String! = "abc"
let count = str.count
print(count)
//4.4optional可选链，optional被传递到了count上
var str: String? = "abc"
let count = str?.count
if count != nil {
    let temp = count!
    print(temp)
}
//4.5optional底层实现是一个范型的枚举类
//var str: String? = "abc" 等价于下一行
var str: Optional<String> = "abc"
if str != nil{
    //let count = str!.count 等价于下一行
    let count = str.unsafelyUnwrapped.count
    print(count)
}
```

```swift
//5,String
//5.1初始化与判空
let str = "abc" //等价于下一行
let str1 = String("abc")
let chars: [Character] = ["a", "b", "c"]
let str2 = String(chars)
if !str.isEmpty {
    print(str)
}
//5.2转义符
let str = "1\n2\n3" //换行符生效
let str1 = #"1\n2\n3"# //换行符未生效
//5.3字符串是值类型，传递的时候会拷贝过去，但是编译器做了优化，只在需要的时候拷贝
var str: String = "abc"
var str1 = str
print(str == str1) //true
str += "def" //等价于str.append("def")
print(str == str1) //false
//5.4遍历
for char in "abc" {
    print(char)
}
//5.5字符串索引
//5.5.1访问
let str = "abcdef"
str[str.startIndex]
str[str.index(before: str.endIndex)]//这个才是最后一位，str[str.endIndex]这种声明会报错
str[str.index(after: str.startIndex)]
str[str.index(str.startIndex, offsetBy: 2)]
//5.5.2插入和删除
var str = "hello"
str.insert("!", at: str.endIndex) //hello！
str.insert(contentsOf: " everyone", at: str.index(before: str.endIndex)) //hello everyone！
str.remove(at: str.index(before: str.endIndex)) //hello everyone
let range = str.index(str.endIndex, offsetBy: -9)..<str.endIndex
str.removeSubrange(range)//hello
//5.6子字符串
let greeting = "hello, world"
let index = greeting.firstIndex(of: ",") ?? greeting.endIndex
let subString = greeting[..<index]//得到的不是String类型，而是子串类型
let resString = String(subString)//这个时候才会进行内存的拷贝
//5.7字符串的比较
var str1 = "abcdef"
var str2 = "abcdef"
print(str1 == str2)
print(str1.hasPrefix("abc"))
print(str2.hasSuffix("def"))
```

```swift
//6运算符
//6.1值溢出
let num1: UInt8 = 250
let num2 = num1 + 10 //报错
print(num2)
let num1: UInt8 = 250
let num2 = num1 &+ 10
print(num2)//4
//6.2合并控制运算符
func addTwoNum(num1: Int?, num2: Int?) -> Int {
    return (num1 ?? 0) + (num2 ?? 0)//a ?? b等价于a != nil ? a! : b
}
print(addTwoNum(num1: nil, num2: 7))//7
//6.3区间运算符
//6.3.1闭区间
for index in 1...5 {
    print(index)
}
//6.3.2左闭右开区间
for index in 1..<5 {
    print(index)
}
//6.3.3单侧区间
let names = ["zhangsan", "lisi", "wangwu"]
for name in names[1...] {
    print(name)
}
for name in names[...1] {
    print(name)
}
//6.3.4倒序遍历
for i in (1...10).reversed() {
    print(i)
}
//6.3.5Comparable区间
let str = "hello."
let interval = "a"..."z"
for c in str {
    if !interval.contains(String(c)) {
        print("\(c)不是小写字母")
    }
}
//6.4重载运算符
struct Vector2D {
    var x = 0.0, y = 0.0
}
extension Vector2D: CustomStringConvertible {
    var description: String {
        get {
            return "Vector:(\(x),\(y))"
        }
    }
}
extension Vector2D {
    static func + (left: Vector2D, right: Vector2D) -> Vector2D {
        return Vector2D(x: left.x + right.x, y: left.y + right.y)
    }
}
let vector1 = Vector2D(x: 2.0, y: 4.0)
let vector2 = Vector2D(x: 1.0, y: 1.0)
let res = vector1 + vector2//Vector:(3.0,5.0)
//6.5自定义运算符
struct Vector2D {
    var x = 0.0, y = 0.0
}
extension Vector2D: CustomStringConvertible {
    var description: String {
        get {
            return "Vector:(\(x),\(y))"
        }
    }
}
extension Vector2D {
    static prefix func +++ (vector: inout Vector2D) -> Vector2D {
        return Vector2D(x: vector.x * 3, y: vector.y * 3)
    }
}
prefix operator +++
var vector1 = Vector2D(x: 2.0, y: 4.0)
var vextor2 = +++vector1//Vector:(6.0,12.0)
```

```swift
//
```


