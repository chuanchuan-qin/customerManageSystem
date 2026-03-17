<div align="center">
    <img src="pictures/拼电商客户管理系统.png" width="600" alt="拼电商客户管理系统" align="center"/>
</div>

## 介绍

本系统是基于文本界面的《拼电商客户管理系统》，基于[尚硅谷java教学](https://www.bilibili.com/video/BV1PY411e7J6/?p=92&share_source=copy_web&vd_source=677c1741a71bb7c3bc8dfabb8644f7dc)中的例子有所改变，仅供学习

基于 Java 控制台（Console） 实现客户管理系统，主要用于模拟电商平台中的客户信息管理流程。系统采用模块化设计思想，实现了客户信息的`增、删、改、查（CRUD）`操作，并通过菜单交互方式实现用户与系统的交互。

## 系统运行说明
1️⃣ 环境要求

JDK 8 及以上

任意 Java IDE（推荐 IntelliJ IDEA / Eclipse）

2️⃣ 运行步骤

方法一：IDE运行

1. 打开项目

2. 找到 Test.java

3. 右键运行 main() 方法

方法二：命令行运行
```bash
javac *.java
java Test
```

## 系统设计结构

```
├── Customer.java        // 客户实体类（数据层）
├── CustomerList.java    // 客户管理类（业务层）
├── CustomerView.java    // 视图控制类（表现层）
├── Util.java            // 工具类（输入校验）
├── Test.java            // 程序入口
```

该系统由CustomerView、CustomerList、Customer三个模块组成
- CustomerView为主模块，负责菜单的显示和处理用户操作
- CustomerList为Customer对象的管理模块，负责客户的增删改查
- Customer为实体对象，封装客户信息

1️⃣ **Customer类的设计**

Customer类是javabean类，包含姓名(name)、性别(gender)、年龄(age)、电话(phone)、邮箱(email)属性。

**作用：** 封装客户基本信息

**属性：**

- name（姓名）

- age（年龄）

- gender（性别）

- phone（手机号）

- email（邮箱）

**核心方法：**

- getter / setter 方法

- getInfo()：格式化输出客户信息

👉 **设计特点：**

- 符合 JavaBean 规范

- 数据封装清晰

2️⃣ **CustomerList类的设计**

CustomerList类为Customer类的管理模块，内部使用数组管理一组Customer对象，封装了增删改查方法。

**作用：** 管理多个客户对象

**核心数据结构：**

```java
private Customer[] customerArray;
private int numberOfCustomers;
```

**核心功能：**

- addCustomer()：添加客户

- deleteCustomer()：删除客户

- updateCustomer()：修改客户

- getCustomer()：获取单个客户

- getAllCustomers()：获取所有客户

👉 **设计亮点：**

- 使用数组实现简单数据库

- 手动维护“逻辑长度”（numberOfCustomers）

- 避免数组越界

3️⃣ CustomerView类的设计

**作用：** 实现用户交互逻辑

**核心方法：**

主菜单
```java
enterMainMenu()
```

- 循环显示菜单

- 根据用户输入执行不同功能

| 功能模块 | 描述       |
| ---- | -------- |
| 添加客户 | 新增客户信息   |
| 删除客户 | 根据编号删除客户 |
| 修改客户 | 修改已有客户信息 |
| 客户列表 | 查看所有客户   |
| 退出系统 | 安全退出程序   |

👉 **特点：**

- 控制流程清晰

- 符合 MVC 思想中的 View + Controller


4️⃣ **Util类**

**作用：** 统一处理用户输入与校验

**核心方法：**

- readMenuSelection()：菜单选择

- readConfirmSelection()：确认操作

- readCustomerName()：姓名校验

- readCustomerAge()：年龄校验

- readCustomerGender()：性别校验

- readCustomerPhone()：手机号校验

- readCustomerEmail()：邮箱输入

👉 **设计亮点：**

- 防止非法输入（健壮性强）

- 使用正则表达式校验数据

- 所有输入统一入口（高内聚）

5️⃣ **Test（程序入口）**

**作用：** 启动系统

```java
public static void main(String[] args) {
    CustomerView customerView = new CustomerView();
    customerView.enterMainMenu();
}
```
