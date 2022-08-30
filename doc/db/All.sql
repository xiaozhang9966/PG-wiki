drop table if exists `test`;
create table `test`(
    `id` bigint not null comment 'id',
    `name` varchar(50) comment '名称',
    `password` varchar(50) comment '密码',
    primary key (`id`)
) engine = innodb default charset = utf8mb4 comment ='测试';#记得用innodb引擎ENGINE=InnoDB使用InnoDB引擎,InnoDB,是NySQL的数据库引擎之一
select * from test;