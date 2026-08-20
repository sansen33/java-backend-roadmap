# Week 12 / Day 2 — Bean Validation

> 建议用时：60 分钟  
> 今日目标：用声明式约束拒绝无效请求。

## 1. 今天学什么
- `@Valid`、`@NotBlank`、`@Email`、`@Size`。

## 2. 实践
在创建用户 DTO 上标注约束，Controller 参数加 `@Valid`。

# 3. Day 2 作业
验证姓名、邮箱和长度边界。

## 4. 今日验收标准
- 校验错误返回 400。
- 业务唯一性不误用 Bean Validation。

下一节：**Week 12 / Day 3 — 统一响应。**
