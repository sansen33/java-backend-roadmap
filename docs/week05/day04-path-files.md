# Week 5 / Day 4 — `Path` 与 `Files`

> 建议用时：60 分钟  
> 今日目标：编写不依赖 IDE 工作目录的文件处理代码。

## 1. 今天学什么

1. `Path.of`
2. `Files.exists`
3. 文本读写
4. 临时文件测试

## 2. 核心示例

```java
Path path = Path.of(inputPath);
if (!Files.exists(path)) {
    throw new FileNotFoundException(path.toString());
}
```

路径应来自参数或配置，不要假设当前目录。

## 3. 今天的 60 分钟安排

读取文件、校验列数、统计有效行与错误行。

# 4. Day 4 作业

实现 CSV 导入报告：有效数量、错误数量、每个错误的行号。

## 今日验收标准

- 空文件如何处理？
- 缺失文件如何报告？
- 为什么要用临时文件测试？

下一节：**Week 5 / Day 5 — 注解。**
