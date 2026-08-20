# Week 6 / Day 4 — JUnit 断言

> 建议用时：60 分钟  
> 今日目标：测试可观察行为，而不是实现细节。

## 1. 今天学什么

1. `@Test`
2. `@BeforeEach`
3. 基本断言
4. 异常断言

## 2. 核心示例

```java
@Test
void shouldDecreaseStock() {
    Product product = new Product(10);
    assertTrue(product.decreaseStock(3));
    assertEquals(7, product.getStock());
}
```

## 3. 今天的 60 分钟安排

测试扣库存成功、零数量、超过库存、恰好扣完。

# 4. Day 4 作业

为 Product 写边界测试，确保错误实现能被测试发现。

## 今日验收标准

- 测试验证了什么契约？
- 断言状态还是私有字段？
- 异常测试如何写？

下一节：**Week 6 / Day 5 — 参数化测试。**
