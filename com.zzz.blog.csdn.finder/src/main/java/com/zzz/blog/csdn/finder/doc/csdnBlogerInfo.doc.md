## csdn_bloger_info

**说明**

csdn博客主信息表

**表信息**

* 主键 [BLOGER_ID]
* 表注释

| 名称 | 数据类型 | 长度 | 说明 | | :--: | :--- | :------: |  :----: | |*BLOGER_ID | varchar| 40 | 博客主ID | |NICKNAME | varchar| 20
| | |USER_AVATAR | varchar| 2000 | 头像地址 | |BLOG_URL | varchar| 2000 | 博客地址 | |ID | varchar| 200 | 由CSDN分配的ID |
|EXEC_SUBCRIBE_STATUS | integer| 10 | 获取订阅者状态 | |EXE_DATETIME | date| 10 | 执行时间 | |CDATE | date| 10 | 创建时间 | |UDATE |
date| 10 | 更新时间 | |SOURCE_ID | integer| 10 | 数据来源 | |IS_SELF | integer| 10 | 是否自身ID |



