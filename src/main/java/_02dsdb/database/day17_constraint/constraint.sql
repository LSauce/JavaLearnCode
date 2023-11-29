-- null 约束
-- 约束一个字段， 不能为null
create table test_null3
(
    id    int primary key auto_increment,
    name1 varchar(255),
    -- name 这个字段不能为null
    name2 varchar(255) not null
);

-- insert into  两种写法
-- 指定列名
insert into test_null3(id, name1, name2)
values (10000, '张三', null);
-- 填所有列名; 按照 建表字段顺序
insert into test_null3
values (default, '李四1', '不能为null');
-- 当填所有列名，自增id可以使用 default

-- unique 唯一约束，null不算重复
create table test_unique
(
    id      int primary key auto_increment,
    name    varchar(255) unique,
    address varchar(255)

);

insert into test_unique(name)
values ('zs');
insert into test_unique(name)
values ('zs1');
insert into test_unique(name)
values ('zs2');
insert into test_unique(name)
values ('zs3');
insert into test_unique(name)
values (null);
insert into test_unique(name)
values (null);

select *
from test_unique;

create table province
(
    id   int PRIMARY KEY,
    name varchar(20)
);

create table city
(
    id          int,
    name        varchar(20),
    province_id int,
    -- 声明外键
    -- CONSTRAINT 外键名称 foreign key(列) references 表名(列名)
    -- 在 province_id上建立一个外键，指向   province表的id字段
    CONSTRAINT fk_pid foreign key (province_id) REFERENCES province (id)
);

insert into province
values (41, '河南省');
insert into province
values (43, '湖南省');
insert into province
values (42, '湖北省');

-- 插入子行，回去 父表查询
-- 删除父行，会去查子行，
insert into city
values (6, '哈尔滨', 41);

select *
from province;

select *
from city;

-- 默认值， 如果插入没有指定使用 默认值
create table test_default1
(
    id      int primary key auto_increment,
    name    varchar(255) not null,
    country varchar(255) default '中国'
);

insert into test_default1(name)
values ('张三');
insert into test_default1(name)
values ('李四');
insert into test_default1
values (default, 'Mr.zhao', 'US');
select *
from test_default1;

CREATE TABLE user_info
(
    id          int,
    name        varchar(200),
    create_time timestamp DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    update_time timestamp DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间'
);

insert into user_info(id, name)
values (1, '黄杰'),
       (2, '张殿熙');
select * from user_info;
update user_info set name = '殿熙' where id = 2;

-- comment 注释
-- 作用是什么, 使用 show create table table_name 查看
create table test_comment(
    id  int primary key auto_increment,
    name varchar(255) comment '名字',
    status int comment '"0表示未付款，1表示已付款，2'
);

show create table test_comment;





