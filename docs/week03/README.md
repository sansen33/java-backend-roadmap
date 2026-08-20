# Week 03 — Collections

> 主线项目：内存购物车。每天完成代码后记录集合选择、时间复杂度直觉与边界行为。

## Day 1 — `ArrayList` 与 `LinkedList`

### 学习
- `List` 接口、`ArrayList` 动态数组、`size/get/add/remove`。
- `ArrayList` 适合遍历和按下标读取；不要凭印象选择 `LinkedList`。

### 练习
实现 `ProductCatalog`：添加商品、按 ID 查找、删除商品、返回商品副本列表。

### 验收
空列表、重复 ID、越界下标行为明确；说明为何接口类型写 `List`。

## Day 2 — `HashSet` 与去重

### 学习
- Set 保证元素唯一；唯一性依赖 `equals/hashCode`。
- 业务请求幂等 ID 与对象去重是两个不同问题。

### 练习
用 `Set<Long> processedRequestIds` 拒绝重复请求；为 `ProductTag` 实现值相等。

### 验收
两个内容相同的 tag 只能留下一个；重复请求不重复修改购物车。

## Day 3 — `HashMap`

### 学习
- `put`、`putIfAbsent`、`computeIfAbsent`、`merge`。
- `containsKey` 与 `get == null` 的差异。

### 练习
实现 `Map<Long, CartItem>`，同商品加入时用 `merge` 累加数量。

```java
cart.merge(productId, new CartItem(productId, quantity), CartItem::add);
```

### 验收
不存在商品、数量小于等于零、重复商品均有确定结果。

## Day 4 — Queue、Deque 与栈

### 学习
- Queue 的 FIFO；Deque 可作队列或栈。
- `offer/poll/peek` 在空队列时返回安全结果。

### 练习
用 `ArrayDeque<Long>` 处理待结算购物车；另写括号匹配器。

### 验收
空队列不抛出预期外异常；能解释队列和栈的选择。

## Day 5 — 排序与比较器

### 学习
- `Comparable` 表示自然顺序；`Comparator` 表示外部排序规则。
- 链式比较、稳定排序、空值策略。

### 练习
按价格升序、库存降序、名称升序排序商品，并保留源列表不变。

### 验收
同价商品按名称稳定排序；排序规则是命名变量而非复杂 lambda 嵌套。

## Day 6 — 并发集合

### 学习
- 普通 HashMap 并发写不安全；ConcurrentHashMap 提供并发访问基础。
- 线程安全容器不等于业务操作原子。

### 练习
比较 `map.get()` 后 `map.put()` 与 `compute()`；记录库存扣减仍需要原子业务操作。

### 验收
解释“查库存再扣库存”竞态；不把 synchronized 随意加在所有方法上。

## Day 7 — 闭卷项目

实现内存购物车：商品索引 Map、购物车数量聚合、Set 幂等请求、队列结算。

### 必须覆盖
- [ ] 同商品数量累计。
- [ ] 重复请求不重复累计。
- [ ] 删除后数量为零的条目不残留。
- [ ] 源商品列表不被排序修改。

提交：`git commit -m "complete week 3 collections"`。
