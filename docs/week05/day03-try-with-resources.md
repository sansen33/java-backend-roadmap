# Week 5 / Day 3 — try-with-resources

> 建议用时：60 分钟  
> 今日目标：可靠读取字符流并自动关闭资源。

## 1. 今天学什么

1. `AutoCloseable`
2. `BufferedReader`
3. UTF-8 编码
4. 资源关闭顺序

## 2. 核心示例

```java
try (BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
    return reader.lines().toList();
}
```

资源由语言结构管理；不要依赖人工 `close()`。

## 3. 今天的 60 分钟安排

读取 CSV，测试正常结束、解析失败和文件读取失败。

# 4. Day 3 作业

实现 `readProductRows(Path path)`，按 UTF-8 读取并跳过表头。

## 今日验收标准

- 为什么 try-with-resources 更可靠？
- 多资源按什么顺序关闭？
- 编码不明确会导致什么问题？

下一节：**Week 5 / Day 4 — Path 与 Files。**
