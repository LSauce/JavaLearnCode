-- 现在有一个学生表，需要存储的信息包括，学生id，姓名，年龄，身高，体重，籍贯，身份证号，联系电话
-- 现在有一个图书信息表，需要存储的信息包括，序号，书名，作者，出版社，出版日期，定价，备注
create table student
(
    id      int,
    name    varchar(255), # varchar 可以尽量 写大点，不建议大于255
    age     int,
    height  float(10, 2),
    weight  float(10, 2),
    address varchar(1023),
    id_card varchar(50),
    phone   varchar(50)
);
-- 现在有一个图书信息表，需要存储的信息包括，
-- 序号，书名，作者，出版社，出版日期，定价，备注
create table book_info
(
    id               int,
    name             varchar(255),
    author           varchar(255),
    press            varchar(255),
    publication_date date,
    price            decimal,
    remark           text
);


show tables;

desc book_info;
describe book_info;

show create table student;


show variables like 'character_set_server';

show collation;

show variables like 'collation_server';


create table student2
(
    id      int,
    name    varchar(255),
    age     int,
    address varchar(255),
    remark  varchar(1023)
);

insert into student2(id, name, age, address, remark)
values (1, '黄杰1', 10, '湖北', 'test');
insert into student2(id, name, age, remark)
values (1, '黄杰1', 10, 'test');
insert into student2
values (1, '黄杰', 10, '湖北', 'test');

select *
from student2;

# 测试链接  笛卡尔积
select *
from student2,
     student2 as s2;


describe student2;

insert into student2
values (2, '艾旭', 19, '山西', '戴帽子的小伙');

-- 编号是1，姓名是 "阿妈粽" ，年龄25， 地址上海，自我评价：是一个up主
-- 编号是2，姓名是 "阿斗归来了" ， 地址湖北，自我评价：是一个视频区up主
-- 编号是3，姓名是 "盗月社" ， 地址上海，自我评价：做饭up主
-- 编号是4，姓名是 "李云龙" ， 地址湖北，自我评价：团长
insert into student2(id, name, address, remark)
values (1, '阿妈粽', '上海', '是个up主');

insert into student2
values (2, '阿斗归来', null, '湖北', '一个视频up主');

select *
from student2;

delete
from student2
where name = '阿斗归来';

-- 查询语句
select *
from student2;

select *
from student2
where name = '黄杰';

-- 可以指定返回的列
select id
from student2;

select id
from student2
where address = '湖北';

select *
from student2
where age > 18;

-- 修改数据
update student2
set remark = 'test2';

update student2
set name = '10'
where id = 1;

-- update 一定要加where
