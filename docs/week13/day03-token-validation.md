# Week 13 / Day 3 — Token 校验

> 建议用时：60 分钟  
> 今日目标：在受保护路由验证 Bearer token。

## 1. 今天学什么
- Authorization header、filter、签名/过期校验。

## 2. 实践
解析 `Bearer <token>`，将认证主体放入 SecurityContext。

# 3. Day 3 作业
保护 `/users/me`。

## 4. 今日验收标准
- 缺失、篡改、过期 token 返回 401。
- 不信任客户端传来的 userId。

下一节：**Week 13 / Day 4 — Spring Security。**
