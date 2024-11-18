create table dept(  
  deptno     numeric(2,0),  
  dname      varchar(14),  
  loc        varchar(13),  
  constraint pk_dept primary key (deptno)  
);

insert into dept (DEPTNO, DNAME, LOC)
values(10, 'ACCOUNTING', 'NEW YORK');

insert into dept  
values(20, 'RESEARCH', 'DALLAS');

insert into dept  
values(30, 'SALES', 'CHICAGO');

insert into dept  
values(40, 'OPERATIONS', 'BOSTON');

create table emp(  
  empno    numeric(4,0),  
  ename    varchar(10),  
  job      varchar(9),  
  mgr      numeric(4,0),  
  hiredate date,  
  sal      numeric(7,2),  
  comm     numeric(7,2),  
  deptno   numeric(2,0),  
  constraint pk_emp primary key (empno),  
  constraint fk_deptno foreign key (deptno) references dept (deptno)  
);


insert into emp  
values(  
 7839, 'KING', 'PRESIDENT', null,  
'1990/12/17',
 5000, null, 10  
);

insert into emp  
values(  
 7698, 'BLAKE', 'MANAGER', 7839,  
'1990/12/17',
 2850, null, 30  
);

insert into emp  
values(  
 7782, 'CLARK', 'MANAGER', 7839,  
'1990/12/17',  
 2450, null, 10  
);

insert into emp  
values(  
 7566, 'JONES', 'MANAGER', 7839,  
'1990/12/3',
 2975, null, 20  
);

insert into emp  
values(  
 7788, 'SCOTT', 'ANALYST', 7566,  
'1994/12/17', 
 3000, null, 20  
);

insert into emp  
values(  
 7902, 'FORD', 'ANALYST', 7566,  
'1990/12/3',
 3000, null, 20  
);

insert into emp  
values(  
 7369, 'SMITH', 'CLERK', 7902,  
'1990/12/17',
 800, null, 20  
);

insert into emp  
values(  
 7499, 'ALLEN', 'SALESMAN', 7698,  
'2003/12/17',
 1600, 300, 30  
);

insert into emp  
values(  
 7521, 'WARD', 'SALESMAN', 7698,  
'1999/12/7',
 1250, 500, 30  
);

insert into emp  
values(  
 7654, 'MARTIN', 'SALESMAN', 7698,  
 '1990/12/17',
 1250, 1400, 30  
);
insert into emp  
values(  
 7844, 'TURNER', 'SALESMAN', 7698,  
'2002/12/1',
 1500, 0, 30  
);
insert into emp  
values(  
 7876, 'ADAMS', 'CLERK', 7788,  
 '1990/12/17',
 1100, null, 20  
);

insert into emp  
values(  
 7900, 'JAMES', 'CLERK', 7698,  
'2000/11/1',
 950, null, 30  
);

insert into emp  
values(  
 7934, 'MILLER', 'CLERK', 7782,  
'1990/12/17',
 1300, null, 10  
);
