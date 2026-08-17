# 24 周详细学习计划

适用背景：5 年+前端经验，每天约 1 小时。每周默认学习 6 天，第 7 天复盘或休息。

## Week 01 — Java 语言切换
基本类型、流程控制、方法、class、record、enum、String、日期、List。完成 `exercises/week01/JavaBasicsPractice.java`。验收：独立写 User/Product/Order 模型。

## Week 02 — OOP、接口、泛型
封装、继承、多态、interface、abstract class、泛型、equals/hashCode/toString。实战：PaymentStrategy。

## Week 03 — Collections
ArrayList、LinkedList、HashSet、HashMap、Queue、Deque、ConcurrentHashMap。实战：内存购物车。

## Week 04 — Lambda / Stream / Optional
filter/map/flatMap/reduce/collect/groupingBy、Optional。对订单数据做筛选、分组、汇总和 Top N。

## Week 05 — Exception / IO / Annotation / Reflection
异常、try-with-resources、Files、注解、反射。理解 Spring 注解与反射机制。

## Week 06 — Maven / JUnit
pom、dependency、scope、生命周期、JUnit、Mockito 基础；为 Service 写单测。

## Week 07 — MySQL / SQL
DDL/DML、JOIN、GROUP BY、子查询。设计 user/product/category/orders/order_item 五张表并写业务 SQL。

## Week 08 — Index / Transaction / Lock
B+Tree、聚簇/二级/联合索引、EXPLAIN、ACID、隔离级别、MVCC、行锁、死锁。

## Week 09 — Spring IOC / DI / AOP
Bean、IOC、DI、Component/Service/Repository/Configuration、AOP。

## Week 10 — Spring Boot / MVC / REST
Controller、REST Mapping、RequestBody、PathVariable、RequestParam；补全 User CRUD。

## Week 11 — MyBatis
Mapper、XML、动态 SQL、分页、MyBatis-Plus；将内存 Map 替换为 MySQL。

## Week 12 — 企业 API 规范
DTO/VO/Entity、Validation、统一响应、全局异常、日志、分页、OpenAPI。

## Week 13 — JWT / Security / RBAC
注册、登录、Token 校验、管理员/普通用户权限。

## Week 14 — Redis
String/Hash/List/Set/ZSet、TTL、缓存；理解穿透、击穿、雪崩。

## Week 15 — Redis 进阶
SET NX、Redisson、分布式锁、幂等；研究高并发库存扣减。

## Week 16 — JVM
Heap/Stack/Metaspace、对象创建、GC Roots、G1、类加载、双亲委派。

## Week 17 — Concurrency
Thread、synchronized、volatile、CAS、Atomic、Lock、线程池、CompletableFuture。

## Week 18 — MQ
RabbitMQ 或 RocketMQ；Producer/Consumer、ACK、重复消费、消息丢失、堆积、延迟消息、幂等。

## Week 19 — Linux / Docker
Linux 命令、进程/端口/日志、Dockerfile、Compose、Nginx；容器化 Java + MySQL + Redis。

## Week 20 — Microservice 思维
单体 vs 微服务、服务边界、同步/异步、注册发现；规划 user/product/order 服务。

## Week 21 — Spring Cloud
Nacos、OpenFeign、Gateway、Sentinel；实现服务调用和统一入口。

## Week 22 — 项目强化
实现 Redis 防击穿、下单防重复/库存一致性、MQ 消费幂等，并为每个场景写设计说明。

## Week 23 — 面试体系
Java、MySQL/Redis、算法、项目复盘；准备 HashMap、线程池、JVM、Spring、MVCC、Redis、MQ 口述答案。

## Week 24 — 简历 / 模拟面试 / 投递
定位“资深前端 -> 全栈 -> 后端深化”；准备 3 个 STAR 故事、3 个系统设计场景和至少 2 次模拟面试。

## 算法安排
Week 01-08 每周 2-3 题；Week 09-16 每周 3-5 题；Week 17-24 每周 5-7 题。重点：数组、HashMap、字符串、链表、栈/队列、树、二分、双指针、滑动窗口、DFS/BFS。
