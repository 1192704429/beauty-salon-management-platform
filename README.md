# 基于 Spring Boot + Vue 的美容服务预约电商管理系统设计与实现

> 本文围绕美容行业服务管理场景，设计并实现了一款支持管理员、美容师、用户三种角色的美容服务预约电商管理系统。

## 一、项目背景

该系统主要应用于美容院、皮肤管理中心等线下美容服务门店。传统美容门店在服务预约、订单管理、员工排班、库存消耗等方面多依赖人工记录或通用软件，存在信息不透明、管理效率低、用户体验差等问题。本项目旨在通过数字化手段，实现美容项目管理、用户在线预约、美容师接单与服务记录、管理员数据分析与运营管理的一体化流程，提升门店运营效率与用户满意度。

## 二、功能模块介绍

系统分为三个终端：管理后台端、美容师端、用户端。

| 终端 | 角色 |
| :--- | :--- |
| 管理后台端 | 管理员 |
| 美容师端 | 美容师 |
| 用户端 | 用户 |


![功能模块图](https://code-graden-server-dev.oss-cn-beijing.aliyuncs.com/azhou_promotion/img/module_structure/func_module_69160cd5f1d24c1bbc79576b24e72f30.png)


## 三、技术栈说明

前端：Vue

后端：Spring Boot

数据库与中间件：MySQL

## 四、核心模块介绍

###### 管理后台端

###### 管理员

| 功能模块 | 功能点 |
| :--- | :--- |
| 登录 | 管理员身份验证与登录 |
| 数据分析 | 查看平台运营数据统计与分析 |
| 用户管理 | 美容师管理、系统用户管理 |
| 服务管理 | 美容项目创建与管理、项目消耗物品管理、美容物品管理 |
| 美容百科 | 发布与管理美容知识文章 |
| 轮播管理 | 首页轮播图内容管理 |
| 服务订单 | 订单管理、订单评价管理 |

##### 界面展示

登录页：管理员输入账号密码登录美容院后台

![登录页：管理员输入账号密码登录美容院后台](https://code-graden-server-dev.oss-cn-beijing.aliyuncs.com/2026-04-29/5bed4366-1d3b-4f74-8245-77fb2badd324.png)

数据分析页：展示顾客与产品销售的相关统计数据

![数据分析页：展示顾客与产品销售的相关统计数据](https://code-graden-server-dev.oss-cn-beijing.aliyuncs.com/2026-04-29/767ec293-ac5c-4314-8489-7c962a992627.png)

轮播图管理页：对系统轮播图进行增删改管理

![轮播图管理页：对系统轮播图进行增删改管理](https://code-graden-server-dev.oss-cn-beijing.aliyuncs.com/2026-04-29/48eaaba6-ba97-4253-8505-9b54da5af001.png)

美容师管理：管理员查看并管理系统中的美容师信息

![美容师管理：管理员查看并管理系统中的美容师信息](https://code-graden-server-dev.oss-cn-beijing.aliyuncs.com/2026-04-29/e0857395-dfa7-4913-8a6e-ac2b24cd75d1.png)

顾客管理页：管理顾客信息，支持增删改查询操作

![顾客管理页：管理顾客信息，支持增删改查询操作](https://code-graden-server-dev.oss-cn-beijing.aliyuncs.com/2026-04-29/da05872a-09d9-4bec-81f1-9bfba4bda686.png)

美容项目管理页：管理员管理平台的所有美容项目信息

![美容项目管理页：管理员管理平台的所有美容项目信息](https://code-graden-server-dev.oss-cn-beijing.aliyuncs.com/2026-04-29/b479ff44-3eb5-4d05-8a02-7f29269fc61f.png)

美容项目管理：修改光子嫩肤美容项目的相关信息

![美容项目管理：修改光子嫩肤美容项目的相关信息](https://code-graden-server-dev.oss-cn-beijing.aliyuncs.com/2026-04-29/4850183c-e5ca-4573-854a-5eabb9fb47f6.png)

美容物品管理：管理美容物品，支持搜索增删改查操作

![美容物品管理：管理美容物品，支持搜索增删改查操作](https://code-graden-server-dev.oss-cn-beijing.aliyuncs.com/2026-04-29/1ed64ce7-7d2f-4894-8528-9d8dfc1ba637.png)

美容物品管理：展示美容物品列表，支持增删改查操作

![美容物品管理：展示美容物品列表，支持增删改查操作](https://code-graden-server-dev.oss-cn-beijing.aliyuncs.com/2026-04-29/38aac776-7d1d-4057-8c6b-a6da22aecba2.png)

项目消耗管理页：管理美容项目对应的物品消耗信息

![项目消耗管理页：管理美容项目对应的物品消耗信息](https://code-graden-server-dev.oss-cn-beijing.aliyuncs.com/2026-04-29/0ef784db-ca0c-4a2a-8e99-632e88dc357c.png)

美容百科管理：对美容百科资讯进行增删改查管理

![美容百科管理：对美容百科资讯进行增删改查管理](https://code-graden-server-dev.oss-cn-beijing.aliyuncs.com/2026-04-29/7fb15957-bab5-4796-8d37-cd98e0cbb2b6.png)

预约管理页：管理员查看并管理用户的美容预约信息

![预约管理页：管理员查看并管理用户的美容预约信息](https://code-graden-server-dev.oss-cn-beijing.aliyuncs.com/2026-04-29/5948d53f-69fd-4741-8c2e-354a3be803bc.png)

订单管理页：管理员查看并管理美容服务订单

![订单管理页：管理员查看并管理美容服务订单](https://code-graden-server-dev.oss-cn-beijing.aliyuncs.com/2026-04-29/1087940e-c541-4f48-8d4e-dcb9cbddea6c.png)

订单管理页：管理员查看并管理平台的美容服务订单

![订单管理页：管理员查看并管理平台的美容服务订单](https://code-graden-server-dev.oss-cn-beijing.aliyuncs.com/2026-04-29/d209f7c6-d87d-459f-8c07-2e958de7fba3.png)


###### 美容师端

###### 美容师

| 功能模块 | 功能点 |
| :--- | :--- |
| 登录 | 美容师身份验证与登录 |
| 个人信息 | 查看与修改个人资料 |
| 服务订单 | 订单管理、订单评价查看 |
| 我的预约 | 查看用户预约服务安排 |

##### 界面展示

订单管理：展示美容师的服务订单，支持搜索筛选

![订单管理：展示美容师的服务订单，支持搜索筛选](https://code-graden-server-dev.oss-cn-beijing.aliyuncs.com/2026-04-29/c936e4a2-321d-435e-8d22-5b7439c35dea.png)

订单评价页：查看用户提交的服务订单评价内容

![订单评价页：查看用户提交的服务订单评价内容](https://code-graden-server-dev.oss-cn-beijing.aliyuncs.com/2026-04-29/323d9c61-cbf1-4560-84c8-8b8cab1e1d5d.png)

预约管理页：查看并管理用户的美容预约信息

![预约管理页：查看并管理用户的美容预约信息](https://code-graden-server-dev.oss-cn-beijing.aliyuncs.com/2026-04-29/8af16684-0292-419d-864f-51d193601be8.png)


###### 用户端

###### 用户

| 功能模块 | 功能点 |
| :--- | :--- |
| 登录&注册 | 用户账号注册与登录 |
| 首页 | 美容项目推荐展示、轮播图浏览、美容师推荐展示 |
| 美容项目 | 查看美容项目详情并进行美容师预约 |
| 美容百科 | 浏览美容相关知识文章 |
| 美容师列表 | 查看所有美容师信息 |
| 个人中心 | 个人信息修改、密码修改、预约记录查询、订单管理 |

##### 界面展示

注册页：填写注册信息，完成莱美美容账号注册

![注册页：填写注册信息，完成莱美美容账号注册](https://code-graden-server-dev.oss-cn-beijing.aliyuncs.com/2026-04-29/c53f9646-6558-4841-8792-450d88003fee.png)

登录页：输入账号密码，登录莱美美容系统

![登录页：输入账号密码，登录莱美美容系统](https://code-graden-server-dev.oss-cn-beijing.aliyuncs.com/2026-04-29/15412d46-2efc-45f8-8675-2bf1686691e5.png)

首页：展示美容项目推荐与平台主推医美项目

![首页：展示美容项目推荐与平台主推医美项目](https://code-graden-server-dev.oss-cn-beijing.aliyuncs.com/2026-04-29/e21f193a-6ad3-4926-8852-9e53e2274e6e.png)

列表页：展示各类美容项目及价格，供用户浏览选择

![列表页：展示各类美容项目及价格，供用户浏览选择](https://code-graden-server-dev.oss-cn-beijing.aliyuncs.com/2026-04-29/1498872f-07c5-4169-827d-884643287411.png)

详情页：展示光子嫩肤美容项目详情及用户评论

![详情页：展示光子嫩肤美容项目详情及用户评论](https://code-graden-server-dev.oss-cn-beijing.aliyuncs.com/2026-04-29/392e34fa-c2d7-41e6-8f30-83c1b190a8d4.png)

美容百科列表页：展示美容百科内容，支持搜索查询相关资讯

![美容百科列表页：展示美容百科内容，支持搜索查询相关资讯](https://code-graden-server-dev.oss-cn-beijing.aliyuncs.com/2026-04-29/b491b18f-5f5d-4850-82c7-3d21643028ee.png)

详情页：展示深圳眼部松弛矫正医院排名的百科内容

![详情页：展示深圳眼部松弛矫正医院排名的百科内容](https://code-graden-server-dev.oss-cn-beijing.aliyuncs.com/2026-04-29/0a364b3e-7a6a-4772-8d24-3d9b01cd2e9d.png)

美容师列表页：展示美容师信息，介绍美莱美容机构

![美容师列表页：展示美容师信息，介绍美莱美容机构](https://code-graden-server-dev.oss-cn-beijing.aliyuncs.com/2026-04-29/e37f2a43-ce57-429a-8873-7fe9d87837b1.png)

订单管理页：查看个人美容服务订单，可对完成订单评价

![订单管理页：查看个人美容服务订单，可对完成订单评价](https://code-graden-server-dev.oss-cn-beijing.aliyuncs.com/2026-04-29/7eb7f18c-685c-407c-89c8-10bb67ecf5be.png)

预约记录页：展示用户个人的美容项目预约记录

![预约记录页：展示用户个人的美容项目预约记录](https://code-graden-server-dev.oss-cn-beijing.aliyuncs.com/2026-04-29/754308b4-8fad-4619-842b-d93c15fe665b.png)

个人信息修改页：修改个人账号的基本信息内容

![个人信息修改页：修改个人账号的基本信息内容](https://code-graden-server-dev.oss-cn-beijing.aliyuncs.com/2026-04-29/11466bef-cc8b-4336-831b-f672a089e2fe.png)


## 五、主要业务流程

1. 用户浏览首页或美容项目列表。
2. 用户选择心仪的美容项目并查看详情。
3. 用户选择可预约的美容师并预约服务时间。
4. 系统生成预约订单并通知美容师。
5. 美容师在“我的预约”中查看预约安排并完成服务。
6. 美容师完成服务后在“服务订单”中更新订单状态。
7. 用户对已完成的订单进行评价。
8. 管理员通过管理后台查看订单、评价及数据分析报表。

## 六、项目拓展性

未来可向多门店连锁管理、会员积分与等级体系、智能排班与自动派单、线上商城与美妆产品销售、消息推送与营销活动管理、财务对账与报表导出等方向进行功能扩展。

## 代码说明 
本仓库为项目的 **后端核心代码部分** 主要用于展示系统的业务设计思路与后端实现方式 出于学习展示与版权保护考虑 前端实现、完整数据库脚本及部署配置未在本仓库中公开 

##  项目交流 
本项目用于学习展示 如需项目完整功能演示、答辩说明或技术交流 请前往作者 GitHub 主页查看联系方式