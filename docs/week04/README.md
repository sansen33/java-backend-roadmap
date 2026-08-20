# Week 04 — Lambda、Stream 与 Optional

> 主线项目：订单统计报表。每段 Stream 都先写输入类型、输出类型，再编码。

## Day 1 — Lambda 与函数式接口

### 学习
- `Predicate<T>` 判断、`Function<T,R>` 转换、`Consumer<T>` 消费。
- lambda 捕获的局部变量必须 effectively final。

### 练习
把商品可售判断、名称转换、打印动作分别声明为三个函数式接口变量。

### 验收
能将 lambda 改写为方法引用，并解释何时方法引用反而降低可读性。

## Day 2 — `filter`、`map`、`collect`

### 学习
- 中间操作惰性；terminal operation 触发执行。
- `filter` 不改变元素类型，`map` 改变元素类型。

### 练习
从订单列表筛选已支付订单，映射为订单摘要，收集为新 List。

### 验收
不修改源列表；空输入返回空列表；没有副作用 lambda。

## Day 3 — reduce 与数值聚合

### 学习
- `count`、`mapToInt`、`sum`、`reduce` 的适用差异。
- 空流没有最大值；结果必须明确。

### 练习
计算已支付订单总额、最大订单金额和平均订单金额。

### 验收
解释 `reduce` 初始值；不把金额精度问题隐藏在 double 运算中。

## Day 4 — 分组与分区

### 学习
- `Collectors.groupingBy` 产生多组 Map。
- `partitioningBy` 产生 true/false 两组。

### 练习
按用户 ID 分组订单，按支付状态分区；使用下游 `summingInt` 统计总额。

### 验收
空组、未知用户和订单状态均有明确结果。

## Day 5 — Optional

### 学习
- `ofNullable`、`map`、`flatMap`、`filter`、`orElseGet`、`orElseThrow`。
- `orElse` 参数会立即计算；需要延迟计算时用 `orElseGet`。

### 练习
实现 `findProductName(id)`，未找到时返回业务异常；不调用 `get()`。

### 验收
Optional 只用于返回值链路，不作为实体字段或集合元素。

## Day 6 — 可读性与边界

### 学习
- 复杂流拆成命名阶段；不要在 `map` 中写库存扣减等副作用。
- 循环在调试、异常控制和复杂状态中可能更清晰。

### 练习
将一条嵌套流水线拆成三步，并写一个等价循环版本比较。

### 验收
说出选择 Stream 或循环的理由；不为了“函数式”牺牲可读性。

## Day 7 — 闭卷项目

给定订单列表生成用户报表：筛选已支付订单、按用户分组、统计总额、找每组最高订单。

### 必须覆盖
- [ ] 空列表安全。
- [ ] 不修改源数据。
- [ ] 没有 `Optional.get()`。
- [ ] 每个 collector 的返回类型能解释。

提交：`git commit -m "complete week 4 streams"`。
