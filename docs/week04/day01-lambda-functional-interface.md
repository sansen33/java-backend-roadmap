# Week 4 / Day 1 — Lambda 与函数式接口

> 建议用时：60 分钟  
> 今日目标：用 lambda 表达可复用的判断、转换和消费行为。

## 1. 今天学什么

1. 函数式接口
2. `Predicate`、`Function`、`Consumer`
3. lambda 参数与返回值
4. 方法引用

## 2. 核心示例

```java
Predicate<Product> available = Product::isAvailable;
Function<Product, String> name = Product::getName;
Consumer<Product> printer = product -> System.out.println(product.getName());
```

lambda 是行为值，不是线程；局部变量被捕获后必须 effectively final。

## 3. 今天的 60 分钟安排

### 0–20 分钟

分别定义商品筛选、名称转换和打印行为。

### 20–40 分钟

比较 lambda 与方法引用的可读性。

### 40–60 分钟

完成作业并测试空值。

# 4. Day 1 作业

实现 `filterAvailable(List<Product>, Predicate<Product>)`，返回新列表，不修改源列表。

## 今日验收标准

- 什么是函数式接口？
- lambda 捕获变量有什么限制？
- 何时方法引用反而不清晰？

下一节：**Week 4 / Day 2 — `filter`、`map`、`collect`。**
