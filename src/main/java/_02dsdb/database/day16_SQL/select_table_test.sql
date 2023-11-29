use homework_55th;

insert student2
values (2018019, 'test', null, null, null, null);

select *
from student2
where name like '王%';

-- is null 如果要判断 是否为null，或者用 <=> ，不能使用null

select *
from student2
where gender <=> null;


select name
from student
where math >= 80
  and math <= 90;


select *
from student
where math < 60
   or chinese < 60
   or english < 60;


select *
from student
         left join student3
                   on student3.id = student.id
limit 2;


select *
from student
limit 5 offset 5;


-- 分页公式 limit eachPageNumber offset eachPageNumber*(page - 1);


-- order 排序
select math
from student
order by math DESC;

-- 可以对多列进行排序
-- 优先对 chinese排序， 如果相同对english排序
select *
from student
order by chinese desc, english, math desc;


select chinese
from student
group by chinese;

select id, dept, dept_id
from student2
group by dept, dept_id;

-- group by的select中，能出现两个东西，1.在 group by 中出现的字段 2. 聚合函数，聚合函数中可包括 其他字段
-- max() min() sum();
select *
from student
where math in (select max(math)
               from student);

show create table student;

SELECT *
FROM (SELECT *, RANK() OVER (ORDER BY math DESC) AS ranking
      FROM student) AS ranked_students
WHERE ranking = 1;


-- GROUP_CONCAT() test
select dept, dept_id, concat(dept)
from student2
group by dept, dept_id;


-- 年龄大于21的，按照 系分组
select dept, count(*), group_concat(age)
from student2
where age > 21
group by dept;


-- having 对分组后的 组结果进行 筛选
select dept, dept_id, group_concat(name)
from student2
group by dept, dept_id
having count(id) < 4;
# 对分组后 展示的数据进行过滤,不能使用where，where只能对 原数据筛选

-- 如果在select中 符合group by的字段，则group by后面字段 可以使用数字代替
select chinese, english, count(*)
from student
group by 1, 2;

-- count(*) 本质也是做分组，全表作为了一个组，所以不能加其他字段
select count(*), id
from student3;

-- count(*) 和 count(columnName区别)
select *
from student3;
-- count(*) 就是统计有多少行，不关心里面的内容
select count(*)
from student2;
# 16
-- count(columnName) 统计 columnName 不为null的行数
select count(dept) # 15
from student2;
select count(dept)
from (select distinct dept
      from student2) as st2;


-- 获取班级的 平均年龄, 这里 聚合函数 都是直接对 组内元素处理
select dept, AVG(age)
from student2
where not dept <=> null
group by dept;

SHOW ENGINES;

SELECT VERSION();

SHOW VARIABLES LIKE '%storage_engine%';


-- 实体完整性
-- 主键约束
-- 1个表中只能有一个主键
-- 主键为唯一的，不能为null
create table test_primary_key
(
    id   int primary key,
    name varchar(255)
);

insert test_primary_key
values (2, 'test'),
       (3, 'test2');

create table test_auto_increment
(
    id   int primary key auto_increment,
    name varchar(255)
);

insert into test_auto_increment(id, name)
values (1, 'ffff');
insert into test_auto_increment(name)
values ('ffff');

select *
from test_auto_increment;

delete
from test_auto_increment
where name = 'ffff';


-- 当使用unique时，如果是 如果有冲突，会直接占当前序号，导致序号的 不连续

create table test_auto_increment_unique
(
    id   int primary key auto_increment,
    name varchar(255) unique
);
insert into test_auto_increment_unique(id, name)
values (1, 'ffff');
insert into test_auto_increment_unique(id, name)
values (2, 'ffff1');
insert into test_auto_increment_unique(name)
values ('ffff');
select * from test_auto_increment_unique;
insert into test_auto_increment_unique(name)
values ('ffff236');








