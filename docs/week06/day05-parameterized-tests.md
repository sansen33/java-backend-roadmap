# Week 6 / Day 5 — 参数化测试

> 建议用时：60 分钟  
> 今日目标：用多组边界数据覆盖等价类。

## 1. 今天学什么

1. `@ParameterizedTest`
2. `@CsvSource`
3. 边界值
4. 测试命名

## 2. 核心示例

```java
@ParameterizedTest
@CsvSource({"-1, false", "0, false", "1, true"})
void shouldValidateQuantity(int quantity, boolean expected) {}
```

## 3. 今天的 60 分钟安排

覆盖折扣、订单数量和名称校验的有效/无效边界。

# 4. Day 5 作业

为 `isValidProductName` 编写参数化测试，覆盖 null、空白、50 和 51 个字符。

## 今日验收标准

- 参数化测试减少了什么重复？
- 为什么边界值最容易暴露错误？
- 失败输出是否能定位案例？

下一节：**Week 6 / Day 6 — Mockito。**

---

<!-- daily-navigation -->
[下一天](../week06/day06-mockito.md)
