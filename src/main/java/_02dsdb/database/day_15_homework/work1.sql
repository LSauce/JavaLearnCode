CREATE DATABASE homework_55th CHARACTER SET utf8mb4 COLLATE utf8mb4_bin;
use homework_55th;
-- 有如下一张表
-- create table student(
-- 	id int,
-- 	name varchar(20),
-- 	chinese float,
-- 	english float,
-- 	math float
-- );
CREATE TABLE student
(
    id      INT,
    name    VARCHAR(20),
    chinese FLOAT,
    english FLOAT,
    math    FLOAT
);
-- 1. 请添加2列信息，出生日期，籍贯。
ALTER TABLE student
    ADD birthday DATE,
    ADD hometown VARCHAR(10);
-- 2. 请修改语文成绩的数据类型为int型
ALTER TABLE student
    MODIFY chinese INT;
-- 删除元素
DELETE
FROM student
WHERE id = 1;
-- 设置主键
ALTER TABLE student
    MODIFY id INT PRIMARY KEY;
-- 显示当前数据
SELECT *
FROM student;

-- 3. 请在里面插入10名学生数据
INSERT INTO student
VALUES (1, 'zs', 61, 70, 99, '2001-08-01', '江西丰城');
INSERT INTO student
VALUES (2, 'zs1', 62, 71, 91, '2001-09-01', '江西丰城1');
INSERT INTO student
VALUES (3, 'zs2', 43, 72, 92, '2001-10-01', '江西丰城2');
INSERT INTO student
VALUES (4, '王八蛋3', 24, 33, 33, '2001-11-01', '江西丰城3');
INSERT INTO student
VALUES (5, 'zs4', 45, 74, 94, '2001-12-01', '江西丰城4');
INSERT INTO student
VALUES (6, '王八蛋5', 66, 75, 55, '2001-10-01', '江西丰城5');
INSERT INTO student
VALUES (7, 'zs6', 67, 76, 96, '2002-08-01', '江西丰城6');
INSERT INTO student
VALUES (8, 'zs7', 68, 77, 17, '2003-08-01', '江西丰城7');
INSERT INTO student
VALUES (9, 'zs8', 69, 78, 98, '2004-08-01', '江西丰城8');
INSERT INTO student
VALUES (10, 'zs9', 70, 99, 99, '2051-08-01', '江西丰城9');
-- 提示：首先修改name这一列的字符集，然后再插入，否则默认的字符集为Latin1，插入中文会报错
--
-- 4. 假设10名同学中有同姓的，如王，请找出姓王同学的信息
SELECT *
FROM student
WHERE name LIKE '王%';
-- 5. 请找出各科不及格学生的信息
SELECT *
FROM student
WHERE chinese < 60
   OR english < 60
   OR math < 60;
-- 6. 请找出有任何一科不及格学生的名称
SELECT name as '如何一科不及格学生的名称'
FROM student
WHERE chinese < 60
   OR english < 60
   OR math < 60;
-- 7. 请找出两科成绩在90分以上的学生名称
SELECT name AS ‘两科成绩在90分以上’
FROM student
WHERE (chinese > 90 AND english > 90)
   OR (chinese > 90 AND math > 90)
   OR (english > 90 AND math > 90);
-- 8. 请找出没有一科挂科的学生名称
SELECT name AS '没有一科挂科的学生'
FROM student
WHERE math >= 60
  AND chinese >= 60
  AND english >= 60;