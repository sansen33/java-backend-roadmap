# Week 13 / Day 2 — 登录与 JWT

> 建议用时：60 分钟  
> 今日目标：签发短期访问令牌。

## 1. 今天学什么
- JWT header/payload/signature、过期时间、签名密钥。

## 2. 实践
校验密码后签发含 subject 和角色的 token；不把密码放入 payload。

# 3. Day 2 作业
实现 `POST /auth/login`。

## 4. 今日验收标准
- 错误凭证不区分用户不存在/密码错误。
- token 有过期时间。

下一节：**Week 13 / Day 3 — Token 校验。**

---

<!-- daily-navigation -->
[下一天](../week13/day03-token-validation.md)
