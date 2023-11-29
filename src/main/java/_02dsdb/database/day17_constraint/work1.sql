# -- 某大学研究生院有若干研究生导师，包括职工编号、姓名、职称、研究方向，
# 其中每个导师的职工编号是唯一的。
# 若干研究生，包括学号、姓名、性别、入学日期，
# 其中每个研究生的学号是唯一的。每个导师可以带若干研究生，
# 但每个研究生只能有一个导师。
# 请设计一个数据库，要求可以正确体现导师和研究生之间的关系。
# 设计完毕之后，请插入一定量的数据，并验证你设计的数据库是否满足要求。
use homework_55th;


create table t_staff
(
    id        int primary key,
    name      varchar(20)  not null,
    title     varchar(20)  not null,
    direction varchar(255) not null
);

create table t_stu
(
    id       int primary key,
    name     varchar(20) not null,
    gender   varchar(20) not null,
    date     char(10),
    tutor_id int         not null
);

INSERT INTO t_staff (id, name, title, direction)
VALUES (1, '张三', '教授', '计算机科学'),
       (2, '李四', '副教授', '人工智能'),
       (3, '王五', '讲师', '数据科学');

-- 向 t_stu 插入测试数据
INSERT INTO t_stu (id, name, gender, date, tutor_id)
VALUES (1, '小明', '男', '2021-09-01', 1),
       (2, '小红', '女', '2021-09-01', 1),
       (3, '小李', '男', '2021-09-01', 2),
       (4, '小张', '女', '2021-09-01', 2),
       (5, '小王', '男', '2021-09-01', 3),
       (6, '小赵', '女', '2021-09-01', 3);

# ------------------
# -- 1.请查出每个导师所带研究生的姓名。
SELECT staff.name, GROUP_CONCAT(stu.name)
FROM t_staff AS staff
         LEFT JOIN t_stu AS stu
                   ON stu.tutor_id = staff.id
GROUP by staff.name;
# ------------------
# -- 2.清查出特定姓名的导师所带研究生的姓名。
SELECT stu.name
FROM t_stu AS stu
         INNER JOIN t_staff
                    ON t_staff.id = tutor_id
WHERE t_staff.name = '张三';
# ------------------
# -- 3.请查出每个导师所带研究生的数量。
SELECT staff.name, COUNT(stu.name)
FROM t_staff AS staff
         LEFT JOIN t_stu AS stu
                   ON staff.id = stu.tutor_id
GROUP BY staff.id;
# ------------------
# -- 4.请查出每个导师所带的男研究生的数量。
SELECT staff.name, COUNT(stu.name)
FROM t_staff AS staff
         LEFT JOIN t_stu AS stu
                   ON staff.id = stu.tutor_id AND stu.gender = '男'
GROUP BY staff.id;
# ------------------
# -- 5.请找出选择哪个研究方向的导师最多。
# 获取最大的序列
SELECT direction, COUNT(id)
FROM t_staff
GROUP BY direction
ORDER BY COUNT(id);
# ------------------
# 找到研究导师最多的
SELECT t.direction, COUNT(*) AS tutor_count
FROM t_staff AS t
         JOIN (SELECT direction, COUNT(*) AS count
               FROM t_staff
               GROUP BY direction) AS counts ON t.direction = counts.direction
GROUP BY t.direction
HAVING COUNT(*) = MAX(counts.count);
# ------------------
# -- 6.请找统计不同职称的导师的个数。
SELECT COUNT(id)
FROM t_staff
GROUP BY title;
#
# -- 在你设计的表中插入若干数据。: 示例如下
# insert t_staff values(123,'邹华','教授','机器识别');
# insert t_stu values(16071021,'唐三','male','2016.07.07',123);