# Week 06 — Maven 与 JUnit

> 主线项目：为订单服务建立可重复的测试基线。每次改代码后先运行最小相关测试。

## Day 1 — Maven 项目结构

### 学习
- `pom.xml`、GAV、标准目录、生命周期。
- main/test 源集和测试类命名。

### 练习
创建最小 Maven 项目，加入 `Product` 和一个 JUnit 测试。

### 验收
`mvn test` 能从命令行执行，不依赖 IDE 配置。

## Day 2 — 依赖与 scope

### 学习
- 直接依赖与传递依赖。
- `test` scope 不应进入生产代码。

### 练习
加入 JUnit Jupiter，查看 `mvn dependency:tree`；记录核心依赖来源。

### 验收
不重复声明已有传递依赖；版本集中管理。

## Day 3 — 生命周期与失败定位

### 学习
- validate、compile、test、package。
- Surefire 如何发现测试；编译失败与断言失败的区别。

### 练习
故意让一个测试失败，阅读报告，再修复并打包。

### 验收
能定位 `target/surefire-reports` 中的失败测试。

## Day 4 — JUnit 断言

### 学习
- `@Test`、`@BeforeEach`、断言消息、异常断言。
- 测试行为和状态，不测试私有实现。

### 练习
测试库存扣减成功、数量为零、超过库存、恰好扣完。

### 验收
每个边界测试能在错误实现下失败。

## Day 5 — 参数化测试

### 学习
- `@ParameterizedTest`、`@CsvSource`、边界等价类。
- 测试数据命名要能说明场景。

### 练习
覆盖折扣、订单数量、商品名称校验；每组数据带预期结果。

### 验收
测试失败时能从参数看出失败案例，不依赖调试器才能理解。

## Day 6 — Mockito

### 学习
- `mock`、`when/thenReturn`、`verify`、异常 stub。
- 只 mock 外部协作者，不 mock 被测对象。

### 练习
mock `PaymentGateway`，验证成功调用一次；支付异常时订单仍未支付。

### 验收
测试不依赖网络、数据库或真实支付服务。

## Day 7 — 闭卷项目

为 `OrderService` 写完整单测并执行 `mvn test`。

### 必须覆盖
- [ ] 成功支付。
- [ ] 渠道失败。
- [ ] 重复支付不重复调用。
- [ ] 库存不足不调用渠道。

提交：`git commit -m "complete week 6 junit"`。
