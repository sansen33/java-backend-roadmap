# Week 05 — 异常、IO、注解与反射

> 主线项目：健壮的 CSV 商品导入器。重点是失败语义、资源生命周期和可观察错误。

## Day 1 — 异常层次与边界

### 学习
- Error、Exception、RuntimeException 的职责差异。
- 参数非法、业务拒绝、基础设施失败分别如何表达。
- 异常消息应包含操作和关键标识。

### 练习
为商品导入定义 `InvalidProductRowException`，包含行号和原因。

### 验收
不使用 `return false` 隐藏所有失败；也不使用异常表示正常的“没找到”。

## Day 2 — 捕获、传播与自定义异常

### 学习
- `try/catch/finally` 的执行顺序。
- `throw` 与 `throws`；异常在合适的边界转换。
- 不捕获后只打印并继续。

### 练习
库存不足抛 `InsufficientStockException`，Service 边界将其转换为用户可理解的结果。

### 验收
状态修改发生在所有校验之后；异常不会导致半完成订单。

## Day 3 — try-with-resources

### 学习
- `AutoCloseable`、资源关闭顺序、关闭异常。
- `BufferedReader` 与字符编码。

### 练习
读取 UTF-8 CSV，使用 try-with-resources；每行解析为 `ProductRow`。

### 验收
正常结束、解析失败和读取失败都能关闭资源；不手写重复 close。

## Day 4 — `Path` 与 `Files`

### 学习
- `Path.of`、`Files.exists`、`Files.newBufferedReader`、临时文件。
- 不依赖 IDE 当前工作目录；路径由参数传入。

### 练习
读取文件、过滤表头、统计有效行/错误行，输出导入报告。

### 验收
空文件、缺失文件、空列、坏数字均有确定错误。

## Day 5 — 注解

### 学习
- `@Target`、`@Retention`、`@Documented`。
- 注解描述元数据，业务逻辑由读取者执行。

### 练习
定义运行时注解 `@Required`，标注 record/class 字段。

### 验收
只能在预期目标使用；运行时可以通过反射读取。

## Day 6 — 反射

### 学习
- `Class`、字段读取、访问控制、反射异常。
- 反射适合框架基础设施，不应替代核心业务调用。

### 练习
实现通用校验器：扫描 `@Required` 字段，返回字段名和错误信息。

### 验收
`null`、空字符串、私有字段均测试；异常信息包含类型与字段。

## Day 7 — 闭卷项目

从空文件实现 CSV 导入器：读取、校验、转换、错误报告；运行至少四类坏输入。

### 必须覆盖
- [ ] 错误包含行号。
- [ ] 资源自动关闭。
- [ ] IO 异常不被吞掉。
- [ ] 导入结果不包含无效实体。

提交：`git commit -m "complete week 5 exception io"`。
