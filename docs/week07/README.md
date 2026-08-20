# Week 07 — MySQL 与 SQL

> 主线项目：电商五表和订单查询。每天保存 SQL、样例数据和查询结果。

## Day 1 — 关系模型与 DDL

### 学习
- 主键、外键、NOT NULL、UNIQUE、默认值。
- `DECIMAL` 保存金额；订单项保存下单时单价快照。

### 练习
创建 `user`、`product`、`category`、`orders`、`order_item` 五表。

### 验收
能画出外键关系；删除策略和字段可空性有理由。

## Day 2 — DML 与约束

### 学习
- INSERT、UPDATE、DELETE、受影响行数。
- 条件更新避免误改全表。

### 练习
插入三类商品和订单；使用条件 SQL 扣库存。

### 验收
重复邮箱被 UNIQUE 拒绝；库存不会更新成负数。

## Day 3 — 条件查询

### 学习
- WHERE、IN、LIKE、BETWEEN、IS NULL、ORDER BY、LIMIT。
- 分页排序必须有稳定的次排序键。

### 练习
查询可售商品、某用户最近订单、价格区间商品。

### 验收
解释 null 行为；不使用 `= NULL`。

## Day 4 — JOIN

### 学习
- INNER JOIN、LEFT JOIN、ON 与 WHERE 的位置影响。
- 一对多 JOIN 会造成主表重复行。

### 练习
查询订单用户、订单明细商品；分别写详情查询和汇总查询。

### 验收
结果行数和业务粒度明确；不靠 `DISTINCT` 掩盖错误连接。

## Day 5 — 聚合

### 学习
- COUNT、SUM、AVG、GROUP BY、HAVING。
- `COUNT(*)` 与 `COUNT(column)` 的 NULL 差异。

### 练习
按用户统计订单数/金额，按商品统计销量，找销售额超过阈值用户。

### 验收
能说清 WHERE 与 HAVING 的执行意图。

## Day 6 — 子查询与 SQL 复盘

### 学习
- EXISTS、IN、相关子查询；避免不必要嵌套。
- 查询先写业务问题，再选择 SQL 结构。

### 练习
查询从未下单用户、无明细订单、销量最高商品。

### 验收
每条 SQL 有样例数据验证，避免 `SELECT *`。

## Day 7 — 闭卷项目

独立完成五表 DDL、样例数据和 10 条业务 SQL：用户订单页、商品销量、销售额排行、异常数据检查。

### 必须覆盖
- [ ] 订单项保存价格快照。
- [ ] 金额使用 DECIMAL。
- [ ] JOIN 粒度正确。
- [ ] 无无条件 UPDATE/DELETE。

提交：`git commit -m "complete week 7 sql"`。
