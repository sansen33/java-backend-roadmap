# Week 1 / Day 1 — Java 类型系统 + 类

> 建议用时：60 分钟  
> 今日目标：完成第一次从 JavaScript / TypeScript 到 Java 的思维切换，并能独立定义简单业务类。

## 1. 今天学什么

1. Java 程序基本结构
2. 基本数据类型
3. 包装类型与 `null`
4. `class` 与对象
5. 构造器
6. 实例方法
7. 对象引用与 `==`
8. Java 与 TypeScript 对照

---

## 2. 从 TypeScript 迁移到 Java

TypeScript：

```ts
interface User {
  id: number;
  name: string;
  age: number;
}

const user: User = {
  id: 1,
  name: "Tom",
  age: 30
};
```

Java：

```java
public class User {
    private Long id;
    private String name;
    private Integer age;

    public User(Long id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
}
```

Java 的类型约束比 JavaScript 更严格，而且类型信息贯穿编译和运行时的大量框架能力。

```java
String name = "Tom";
Integer age = 30;

// 编译错误：不能把 String 赋值给 Integer
// age = "30";
```

---

## 3. Java 的 8 个基本类型

```text
byte
short
int
long
float
double
char
boolean
```

业务代码中常见：

```java
int count = 10;
long timestamp = 1720000000L;
double price = 99.9;
boolean enabled = true;
```

### 基本类型 vs 包装类型

```text
int     -> Integer
long    -> Long
double  -> Double
boolean -> Boolean
```

一个非常直观的区别：

```java
Integer age = null; // OK
// int age2 = null; // 编译错误
```

后端业务中经常需要表达“没有值”，所以包装类型非常常见。

---

## 4. Java class

```java
public class User {
    private Long id;
    private String name;
    private Integer age;

    public User(Long id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public boolean isAdult() {
        return age >= 18;
    }
}
```

创建对象：

```java
User user = new User(1L, "Tom", 30);
boolean adult = user.isAdult();
```

TypeScript 中可以类比：

```ts
class User {
  constructor(
    private id: number,
    private name: string,
    private age: number
  ) {}

  isAdult() {
    return this.age >= 18;
  }
}
```

今天需要熟悉的关键词：

```text
类型声明
访问修饰符
构造器
对象创建
实例方法
对象引用
```

---

## 5. 对象引用

```java
User user1 = new User(1L, "Tom", 30);
User user2 = user1;
```

这里没有创建第二个 `User` 对象，而是两个变量引用同一个对象：

```text
user1 ---+
         |
         v
      User Object
         ^
         |
user2 ---+
```

因此：

```java
System.out.println(user1 == user2); // true
```

这会继续引出 Java 中非常重要的：

- `==`
- `equals()`
- `hashCode()`

Day 1 先理解“引用”即可，Week 2 再深入。

---

## 6. 今天的 60 分钟安排

### 0–15 分钟

理解：

- Java 基本类型
- 包装类型
- `String`
- `null`

### 15–30 分钟

自己定义三个类：

- `User`
- `Product`
- `Order`

不要复制答案，自己敲。

### 30–45 分钟

给三个类加入业务方法，例如：

```text
User
- isAdult()

Product
- isAvailable()
- calculateDiscountPrice()

Order
- calculateTotalPrice()
- isPaid()
```

### 45–60 分钟

完成下面的 Day 1 作业。

---

# 7. Day 1 作业

创建 `Product` 类，包含：

```text
id
name
price
stock
```

实现：

```java
boolean isAvailable()
double calculateDiscountPrice(double discount)
```

例如商品价格为 `100`，`discount = 0.8`，结果应为 `80`。

然后创建：

```java
public static void main(String[] args)
```

测试数据：

```text
name     = MacBook Pro
price    = 14999
stock    = 10
discount = 0.9
```

期望输出：

```text
商品：MacBook Pro
是否有库存：true
原价：14999
折扣价：13499.1
```

## 要求

1. 不要直接复制示例代码完成作业。
2. 字段使用合适的 Java 类型。
3. `stock > 0` 时 `isAvailable()` 返回 `true`。
4. 折扣计算逻辑必须封装在 `Product` 内，而不是写在 `main` 中。
5. 完成后尝试解释每一行代码为什么这么写。

---

# 8. 思考题：Integer Cache

先不要搜索答案，预测下面两段代码的结果。

```java
Integer a = 100;
Integer b = 100;

System.out.println(a == b);
```

再看：

```java
Integer a = 1000;
Integer b = 1000;

System.out.println(a == b);
```

思考：为什么结果可能不同？

尝试从今天学习的这些概念解释：

- 基本类型
- 包装类型
- 对象
- 引用
- `==`

提示关键词留到复盘时再看：**自动装箱（Autoboxing）与 Integer Cache**。

---

# 9. 今日验收标准

完成 Day 1 后，应该能够回答：

- `int` 和 `Integer` 有什么区别？
- 为什么 `Integer` 可以是 `null`？
- `new User(...)` 做了什么？
- 构造器是什么？
- `user2 = user1` 会不会创建新对象？
- `==` 比较对象时大致在比较什么？
- 能否不看教程独立写出一个简单的 `Product` 类？

如果最后一项做不到，不进入 Day 2，先再写一个 `Book` 或 `Employee` 类练习一次。

---

# 10. 今日提交建议

完成自己的练习代码后提交：

```bash
git add .
git commit -m "complete week 1 day 1"
git push
```

原则：**每天至少产生一次自己能够解释清楚的代码变化，而不是只记录看了多少课程。**

下一节：**Week 1 / Day 2 — 方法、构造器、封装、static、final 与 Java 参数传递。**
