# Week 5 / Day 1 — 异常层次与边界

> 建议用时：60 分钟  
> 今日目标：区分参数错误、业务拒绝与基础设施失败。

## 1. 今天学什么

1. `Throwable`、`Exception`、`RuntimeException`
2. checked 与 unchecked exception
3. 异常边界
4. 有意义的异常消息

## 2. 核心示例

```java
if (quantity <= 0) {
    throw new IllegalArgumentException("quantity must be positive");
}
```

正常的“没找到”不应靠异常表达；基础设施错误不能被静默吞掉。

## 3. 今天的 60 分钟安排

阅读异常层次；为商品导入区分非法行和文件读取失败；运行三类失败场景。

# 4. Day 1 作业

定义 `InvalidProductRowException`，包含行号和错误原因。

## 今日验收标准

- 参数错误和业务失败如何区分？
- 异常消息是否能定位数据？
- 能否避免 `catch (Exception) {}`？

下一节：**Week 5 / Day 2 — 捕获、传播与自定义异常。**
