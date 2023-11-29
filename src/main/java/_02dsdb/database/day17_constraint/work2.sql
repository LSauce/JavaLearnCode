-- 在数据库中创建如下两张表
create table dept
(
    id    int(10) primary key,
    dname varchar(10)
);
insert into dept
values (1, '事业部');
insert into dept
values (2, '销售部');
insert into dept
values (3, '技术部');

create table emp
(
    id     int(10) primary key,
    ename  varchar(10),
    job    varchar(10),
    mgr    varchar(10),
    sal    float,
    deptno int(10)
);
insert into emp
values (1, 'jacky', 'clerk', 'tom', '1000', 1);
insert into emp
values (2, 'tom', 'clerk', '', '2000', 1);
insert into emp
values (7, 'biddy', 'clerk', '', '2000', 1);
insert into emp
values (3, 'jenny', 'sales', 'pretty', '600', 2);
insert into emp
values (4, 'pretty', 'sales', '', '800', 2);
insert into emp
values (5, 'buddy', 'jishu', 'canndy', '1000', 3);
insert into emp
values (6, 'canndy', 'jishu', '', '1500', 3);
select *
from dept;
select *
from emp;


-- 1 列出emp表中各部门的部门号，最高工资，最低工资
SELECT deptno, MAX(sal), MIN(sal)
FROM emp
GROUP BY deptno;
-- 2 列出emp表中各部门job为'CLERK'的员工的最低工资，最高工资
SELECT dept.dname, MAX(sal), MIN(sal)
FROM dept
         LEFT JOIN emp
                   ON emp.job = 'clerk' AND deptno = dept.id
GROUP BY dept.dname;
-- 3 对于emp中最低工资小于2000的部门，列出job为'CLERK'的员工的部门号，最低工资，最高工资
SELECT emp.deptno, MIN(sal), MAX(sal)
FROM emp
         LEFT JOIN (SELECT e2.deptno FROM emp as e2 GROUP BY e2.deptno HAVING MIN(e2.sal) < 2000) AS d
                   ON d.deptno = emp.deptno
WHERE emp.job = 'clerk'
GROUP BY deptno;
-- 4 根据部门号由高而低，工资有低而高列出每个员工的姓名，部门号，工资
SELECT ename, deptno, sal
FROM emp
ORDER BY deptno DESC, sal;

-- 5 列出'buddy'所在部门中每个员工的姓名与部门号
SELECT emp.ename, deptno
FROM emp
WHERE deptno in (SELECT deptno FROM emp WHERE ename = 'buddy');
# 使用连接
SELECT e1.ename, e1.deptno
FROM emp AS e1
         JOIN emp AS e2
              ON e2.ename = 'buddy' AND e1.deptno = e2.deptno;
-- 6 列出每个员工的姓名，工作，部门号，部门名
SELECT ename, job, deptno, dname
FROM emp
         JOIN dept
              ON dept.id = emp.deptno;
-- 7 列出emp中工作为'CLERK'的员工的姓名，工作，部门号，部门名
SELECT ename, job, deptno, dname
FROM emp
         JOIN dept
              ON dept.id = emp.deptno AND job = 'clerk';
-- 8 对于emp中有管理者的员工，列出姓名，管理者姓名（管理者外键为mgr）
SELECT ename, mgr
FROM emp
WHERE mgr IS NOT NULL
  AND mgr <> '';

-- 9 对于dept表中，列出所有部门名，部门号，同时列出各部门工作为'CLERK'的员工名与工作
SELECT dname, deptno, ename, job
FROM emp
      RIGHT  JOIN dept ON emp.deptno = dept.id AND job = 'clerk';
-- 10 对于工资高于本部门平均水平的员工，列出部门号，姓名，工资，按部门号排序
SELECT emp.deptno, ename, sal
FROM emp
         JOIN (SELECT deptno, AVG(sal) AS avg FROM emp GROUP BY deptno) AS avg_sal
              ON avg_sal.deptno = emp.deptno AND emp.sal > avg_sal.avg
ORDER BY emp.deptno;
-- 11 对于emp，列出各个部门中工资高于本部门平均工资的员工数和部门号，按部门号排序
SELECT COUNT(emp.id), emp.deptno
FROM emp
         JOIN (SELECT deptno, AVG(sal) AS avg FROM emp GROUP BY deptno) AS avg_sal
              ON avg_sal.deptno = emp.deptno AND emp.sal > avg_sal.avg
GROUP BY deptno
ORDER BY deptno;