# Week 09 — Spring IOC、DI 与 AOP

> 主线项目：可测试的分层订单应用。每天启动上下文或运行对应测试验证理解。

## Day 1 — Bean 与 IOC

### 学习
- 容器、组件扫描、Bean 定义与生命周期。
- IOC 是创建和管理依赖的控制权转移。

### 练习
创建 `@Component` 的时钟 Bean，启动上下文并获取实例。

### 验收
解释容器为什么能提供对象；不在业务中到处 `new` 协作者。

## Day 2 — 构造器注入

### 学习
- 构造器注入使依赖必需且可见。
- 接口作为依赖边界，测试时可替换。

### 练习
`OrderService(OrderRepository, PaymentGateway)` 使用单一构造器注入。

### 验收
不用字段注入；可用普通 `new` 在单测中构造 Service。

## Day 3 — 分层 stereotype

### 学习
- Controller、Service、Repository 的职责。
- `@Repository` 的异常转换语义概览。

### 练习
拆分用户查询：Controller 做映射，Service 做规则，Repository 做存取。

### 验收
Controller 不写业务循环；Repository 不知道 HTTP 状态码。

## Day 4 — Configuration 与 Bean

### 学习
- `@Configuration`、`@Bean`、第三方客户端适配。
- Bean 命名与多个实现的选择。

### 练习
注册 `Clock` 或 Payment SDK adapter，Service 依赖自己的接口。

### 验收
第三方类型不泄露到业务核心；配置集中管理。

## Day 5 — AOP 与代理

### 学习
- 切面、切点、通知、JDK/CGLIB 代理直觉。
- 日志、事务等横切关注点。

### 练习
为 Service 记录耗时和请求 ID；异常原样传播。

### 验收
理解 self-invocation 可能绕过代理；不把核心业务藏进切面。

## Day 6 — 配置与环境

### 学习
- profile、配置绑定、环境覆盖、敏感配置。
- 不把密钥写入代码、提交或日志。

### 练习
绑定支付超时配置并为非法值失败启动添加校验。

### 验收
local/test 配置可替换；生产密钥来自外部配置。

## Day 7 — 闭卷项目

构造不含 HTTP 的订单上下文：接口、实现、构造器注入、配置 Bean、日志切面。

### 必须覆盖
- [ ] 依赖方向清晰。
- [ ] Service 可脱离容器单测。
- [ ] 配置不硬编码。
- [ ] 日志不包含支付敏感字段。

提交：`git commit -m "complete week 9 spring core"`。
