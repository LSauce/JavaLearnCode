-- 新建一个学生表S，有包含如下信息
-- # 学号 id，
-- # 学生姓名 name，
-- # 性别 gender，
-- # 年龄 age，
-- # 专业 dept，
-- # 所在系编号 …等
-- # 并插入10条数据。
-- #
-- 学号格式为 201801 201802 201803...
-- # 性别只有 'male' & 'female'
-- # 院系包含（信息系、数学系，计算机科学系 等）
USE homework_55th;
CREATE TABLE student2
(
    id      INT PRIMARY KEY,
    name    VARCHAR(50) NOT NULL,
    gender  VARCHAR(20),
    age     INT,
    dept    VARCHAR(200),
    dept_id VARCHAR(200)
);
INSERT INTO student2 (id, name, gender, age, dept, dept_id)
VALUES (201801, '张三', '男', 20, '信息系', 1),
       (201802, '李四', '男', 21, '数学系', 2),
       (201803, '王五', '男', 22, '计算机科学系', 3),
       (201804, '赵六', '女', 20, '信息系', 1),
       (201805, '钱七', '女', 21, '数学系', 2),
       (201806, '孙八', '男', 22, '计算机科学系', 3),
       (201807, '周九', '女', 20, '信息系', 1),
       (201808, '吴十', '男', 21, '数学系', 2),
       (201809, '郑十一', '男', 22, '计算机科学系', 3),
       (201810, '王十二', '女', 20, '信息系', 1);
-- 然后做如下查询：

-- 1.查询全体学生的学号与姓名。
SELECT id, name
FROM student2;
-- 3.查询全体学生的详细记录。
SELECT *
FROM student2;
-- 4.查询全体学生的姓名、出生年份和所属部门 使用列别名改变查询结果的列标题
SELECT name                     AS '姓名',
       YEAR(CURRENT_DATE) - age AS '出生年份',
       dept                     AS '所属部门'
FROM student2;
-- 7.查询所有年龄在20岁以下的学生姓名及其年龄。
SELECT name, age
FROM student2
WHERE age < 20;
-- 8.查询年龄在20~23岁（包括20岁和23岁）之间的学生的姓名、系别和年龄。
SELECT name, dept, age
FROM student2
WHERE age >= 20
  AND age <= 23;

-- 9.查询年龄不在20~23岁之间的学生姓名、系别和年龄。
INSERT INTO student2
VALUES (201811, '张十三', '男', 25, '信息系', 1);

SELECT name, dept, age
FROM student2
WHERE age < 20
   OR age > 23;
-- 10.查询信息系、数学系和计算机系学生的姓名和性别。
SELECT name, gender
FROM student2
WHERE dept_id = 1
   OR dept_id = 2
   OR dept_id = 3;

-- 11.查询既不是信息系、数学系，也不是计算机科学系的学生的姓名和性别。
SELECT name, gender
FROM student2
WHERE dept_id != 1
  AND dept_id != 2
  AND dept_id != 3;

-- 12.查询学号为200518的学生的详细情况。
INSERT INTO student2
VALUES (200518, '张18', '男', 15, '信息系', 1);

SELECT *
FROM student2
WHERE id = '200518';


-- 13.查询所有姓刘学生的姓名、学号和性别。
INSERT student2
VALUES (201812, '刘十四', '女', 12, '信息系', 1);


SELECT name, age, gender
FROM student2
WHERE name LIKE '刘%';

-- 14.查询姓“李”且全名为两个汉字的学生的姓名。
SELECT name
FROM student2
WHERE name LIKE '李_';

-- 15.查询名字中第2个字为“立"字的学生的姓名和学号。
INSERT student2
VALUES (201813, '张立', '男', 88, '信息系', 1);

SELECT name, id
FROM student2
WHERE name LIKE '_立';

-- 16.查询所有不姓刘的学生姓名。
SELECT name
FROM student2
WHERE name NOT LIKE '刘%';

-- 17.查询学号在201801~201809之间的学生姓名。
SELECT *
FROM student2
WHERE id > 201801
  AND id < 201809;

-- 18.查询不同院系学生的人数。
SELECT dept_id, COUNT(*) AS '系人数'
FROM student2
GROUP BY dept_id;

-- 19.查询不同院系学生的平均年龄，并以降序排序。
SELECT dept_id, AVG(age) AS '系平均年龄'
FROM student2
GROUP BY dept_id
ORDER BY AVG(age) DESC ;

-- 20.查询计算机系年龄在20岁以下的学生姓名。
SELECT name
FROM student2
WHERE dept_id = 3
  AND age < 20;

-- 22.查询全体学生情况，查询结果按所在系的系号升序排列，同一系中的学生按年龄降序排列。
SELECT *
FROM student2
ORDER BY dept_id ASC , age DESC;