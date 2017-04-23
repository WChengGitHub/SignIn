create database SignInSystem;


use SignInSystem; /*打开数据库*/
create table tb_companyRepresentative /*公司负责人表*/
(
	CompanyRepresentativeId char(32) primary key,#公司负责人id
	Name varchar(20) not null,#公司负责人名称
	Password varchar(20) not null,#密码
	Telephone char(12) not null,#手机号码
	Email varchar(32) not null
	#邮箱

);
describe tb_companyRepresentative;

use SignInSystem; /*打开数据库*/
create table tb_company /*公司表*/
(
	CompanyId char(32) primary key,#公司id
	Name varchar(100) not null,#公司名称
	Address varchar(255) not null,#公司地址
	Del bit default 0 not null,#删除状态 1-已删除 0-未删除
	CompanyRepresentativeId char(32) not null, #公司负责人id
	foreign key(CompanyRepresentativeId)references tb_companyRepresentative(CompanyRepresentativeId) #外键

);
describe tb_company;

use SignInSystem; /*打开数据库*/
create table tb_department /*部门表*/
(
	DepartmentId char(32) primary key,#部门id
	Name varchar(30) not null,#部门名称
	CompanyId char(32) not null,#公司id
	Address varchar(100) not null, #部门地址
	Mac char(18) not null,#Wifi-mac
	Del bit default 0 not null,#删除状态 1-已删除 0-未删除
	foreign key(CompanyId) references tb_company(CompanyId)#外键
);
describe tb_department;

use SignInSystem; /*打开数据库*/
create table tb_employee /*员工表*/
(
	EmployeeId char(32) primary key,#员工id（创建时间+工号+随机数）
	Name varchar(20) not null,#员工姓名
	Account varchar(30) not null,#账号（公司id+工号）
	Password varchar(20) not null,#员工密码
	Del bit default 0  not null,#删除状态 1-已删除 0-未删除
	Telephone char(12) not null,#手机号码
	Sex bit  not null,#性别 1-男 0-女
	Email varchar(32) not null,#邮箱
	DepartmentId char(32) not null,#部门id
	foreign key(DepartmentId) references tb_department(DepartmentId),#外键
	Duties varchar(20) not null,#员工职务
	Privilege char(1) not null
	#权限 0-普通员工 1-部门管理员（待补充）

);
describe tb_employee;

use SignInSystem; /*打开数据库*/
create table tb_detail /*请假/出差/缺勤的详情表*/
(
	DetailId char(32) primary key,#详情记录id
	Status char(1) not null,#1-出差2-缺勤3-请假
	StartTime timestamp not null,#起始时间
	EndTime timestamp not null,#截止时间
	AcceptTime timestamp not null,#批准时间
	Reason varchar(200) not null,#原因说明
	EmployeeId char(32) not null,#审核人id
	foreign key(EmployeeId) references tb_employee(EmployeeId),#外键
	Date timestamp not null,#审核时间
	Address varchar(100), #出差地址
	Style bit default 0 not null
	#0-日常1-活动

);
describe tb_detail;
use SignInSystem;/*打开数据库*/
create table tb_dailyAttendance /*日常出勤表*/
(
	DailyAttendanceId char(32) primary key,#日常出勤记录id
	EnterTime timestamp not null,#签到时间
	OutTime timestamp not null,#签出时间
	FrontTime timestamp not null,#签到前限 或者char?
	AccumulatedTime timestamp not null,#累积时间 或者char?
	#Status char(1) default 0 not null,
	Status char(1)  not null,#状态 1-出勤 2-迟到 3-早退 4-迟到&早退
	EmployeeId char(32)not null,#员工id
	foreign key(EmployeeId) references tb_employee(EmployeeId)#外键

);
describe tb_dailyAttendance;

use SignInSystem; /*打开数据库*/
create table tb_departmentSchedule /*部门上班表*/
(
	ScheduleId char(32) primary key,#部门上班表id
	DepartmentId char(32) not null,#部门id
	foreign key(DepartmentId) references tb_department(DepartmentId),#外键
	EnterTime varchar(12) not null,#上班时间
	OutTime varchar(12) not null,#下班时间
	Del bit default 0 not null #删除状态 1-已删除 0-未删除

);
describe tb_departmentSchedule;

use SignInSystem; /*打开数据库*/
create table tb_employeeSchedule /*员工上班时间表*/
(
	ScheduleId char(32) not null,#上班时间表记录id
	EmployeeId char(32) not null,#员工id
	foreign key(EmployeeId) references tb_employee(EmployeeId),#外键
	foreign key(ScheduleId) references tb_departmentSchedule(ScheduleId),#外键
	primary key(ScheduleId,EmployeeId)

);
describe tb_employeeSchedule;

use SignInSystem; /*打开数据库*/
create table tb_memo /*备忘录表*/
(
	MemoId char(32) primary key,#备忘记录id
	EmployeeId char(32) not null,#员工id
	foreign key(EmployeeId) references tb_employee(EmployeeId),#外键
	Content varchar(200) not null,#备忘录内容
	StartTime timestamp not null,#起始时间
	EndTime timestamp not null
	#截止时间

);
describe tb_memo;

use SignInSystem; /*打开数据库*/
create table tb_application /*修改申请表*/
(
	ApplicationId char(32) primary key,#修改申请记录id
	EmployeeId char(32) not null,#员工id
	foreign key(EmployeeId) references tb_employee(EmployeeId),#外键
	DailyAttendanceId char(32) not null,#日常出勤记录id
	foreign key(DailyAttendanceId) references tb_dailyAttendance(DailyAttendanceId),#外键
	Title varchar(50) not null,#申请标题
	Remark varchar(100) not null,#备注
	ApplicationTime timestamp not null,#申请时间
	CorrectTime timestamp not null, #正确时间
	Style bit not null,#0-修改上班时间 1-修改下班时间
	Status bit default 0  not null
	#审核状态 0-未审核 1-已审核

);
describe tb_application;

use SignInSystem; /*打开数据库*/
create table tb_arriveAndLeave /*员工进出表*/
(
	ArriveAndLeaveId char(32) primary key,#员工进出记录id
	EmployeeId char(32) not null,#员工id
	DailyAttendanceId char(32) not null,#进出记录对应的出勤记录
	foreign key(DailyAttendanceId) references tb_dailyAttendance(DailyAttendanceId),#外键
	foreign key(EmployeeId) references tb_employee(EmployeeId),#外键

	ArriveTime timestamp not null,#进入时间
	LeaveTime timestamp not null
	#离开时间

);
describe tb_arriveAndLeave;

use SignInSystem; /*打开数据库*/
create table tb_activity /*活动表*/
(
	ActivityId char(32) primary key,#活动id
	ActivityName char(24) not null,#活动名称
	Content varchar(100),#活动内容
	StartTime timestamp not null,#起始时间
	EndTime timestamp not null,#截止时间
	EmployeeId char(32) not null,#发起人id
	foreign key(EmployeeId) references tb_employee(EmployeeId),#外键
	Address varchar(30) not null,#活动地点
	Style bit default 0 not null,#0-活动 1-会议
	CompanyRepresentativeId char(32) not null, #公司负责人id
	foreign key(CompanyRepresentativeId)references tb_companyRepresentative(CompanyRepresentativeId) #外键

);
describe tb_activity;

use SignInSystem; /*打开数据库*/
create table tb_activityAttendance /*活动出席表*/
(
	ActivityAttendanceId char(32) primary key,#活动出席记录id
	EmployeeId char(32) not null,#员工id
	foreign key(EmployeeId) references tb_employee(EmployeeId),#外键
	ActivityId char(32) not null,#活动id
	foreign key(ActivityId) references tb_activity(ActivityId),#外键
	EnterTime timestamp not null,#签到时间
	OutTime timestamp not null,#签出时间
	Status char(1) not null
	#状态 1-出勤 2-迟到 3-缺勤 4-请假 5-早退 6-迟到&早退

);
describe tb_activityAttendance;

use SignInSystem; /*打开数据库*/
create table tb_advice /*意见表*/
(
	AdviceId char(32) primary key,#意见记录id
	EmployeeId char(32) not null,#员工id
	foreign key(EmployeeId) references tb_employee(EmployeeId),#外键
	Content varchar(100) not null,#意见内容
	Status bit default 0  not null,#审阅状态 1-已读 0-未读
	Date timestamp not null,#发布时间
	Style bit not null
	#意见类型 0-软件意见 1-公司意见

);
describe tb_advice;

use SignInSystem; /*打开数据库*/
create table tb_notify /*通知表*/
(
	NotifyId char(32) primary key,#通知记录id
	Title varchar(50) not null,#通知标题
	Content varchar(100) not null,#通知内容
	NotifyTime timestamp not null,#发布通知时间
	Adscription varchar(60) not null,#所属部门/公司
	EmployeeId char(32) not null,#员工id
	foreign key(EmployeeId) references tb_employee(EmployeeId),#外键
	CompanyRepresentativeId char(32) not null, #公司负责人id
	foreign key(CompanyRepresentativeId)references tb_companyRepresentative(CompanyRepresentativeId) #外键

);
describe tb_notify;

use SignInSystem; /*打开数据库*/
create table tb_employeeNotify /*员工的通知表*/
(
	NotifyId char(32) not null,#通知记录id
	EmployeeId char(32) not null,#员工id
	Status bit default 0  not null,#审阅状态 1-已读 0-未读
	foreign key(EmployeeId) references tb_employee(EmployeeId),#外键
	foreign key(NotifyId) references tb_notify(NotifyId),#外键
	primary key(NotifyId,EmployeeId)
);
describe tb_employeeNotify;

use SignInSystem; /*打开数据库*/
create table tb_interim /*请假临时表*/
(
	EmployeeId char(32) not null,#员工id
	DepartmentId char(32) not null,#部门id
	foreign key(DepartmentId) references tb_department(DepartmentId),#外键
	foreign key(EmployeeId) references tb_employee(EmployeeId),#外键
	primary key(DepartmentId,EmployeeId)
);
describe tb_interim;


insert into tb_companyrepresentative 
(CompanyRepresentativeId,Name,Password,Telephone,Email)
values
('123','张三','123','0','0'),
('456','李四','456','0','0');

insert into tb_company
(CompanyId,Name,Address,Del,CompanyRepresentativeId)
values
('12','旭日真维斯','广东惠州惠城环城西路店',0,'123'),
('34','旭日菲尔','广东惠州惠城江北菊花一路',0,'123'),
('56','和诚创新中心','惠州学院五号楼',0,'456'),
('78','和诚TRR研发基地','仲恺高新区仲恺大道',0,'456');

insert into tb_department
(DepartmentId,Name,CompanyId,Address,Mac,Del)
values
('1','财务处','12','一楼101','00:27:1D:06:7E:3E',0),
('2','人力资源部','12','二楼202','00:27:1D:07:7E:3E',0),
('3','售后部','34','一楼102','00:27:1D:08:7E:3E',0),
('4','批发部','34','二楼202','00:27:1D:09:7E:3E',0),
('5','后勤部','56','一楼103','00:27:1D:05:7E:3E',0),
('6','研发部','56','二楼203','00:27:1D:04:7E:3E',0),
('7','保安处','78','一楼104','00:27:1D:03:7E:3E',0),
('8','推广部','78','二楼204','00:27:1D:02:7E:3E',0);

insert into tb_employee
(EmployeeId,Name,Account,Password,Del,Telephone,Sex,Email,DepartmentId,Duties,Privilege)
values
('1','张曙光','12123','123',0,'0',0,'0','1','部门管理员','1'),
('2','张珊珊','12234','123',0,'0',0,'0','1','普通员工','0'),
('3','吴三桂','12345','123',0,'0',0,'0','2','部门管理员','1'),
('4','黄山松','12456','123',0,'0',0,'0','2','普通员工','0'),
('5','蔡时光','12567','123',0,'0',0,'0','2','普通员工','0'),
('6','丁三石','34123','123',0,'0',0,'0','3','部门管理员','1'),
('7','陈思凯','34234','123',0,'0',0,'0','3','普通员工','0'),
('8','卢森堡','34345','123',0,'0',0,'0','3','普通员工','0'),
('9','李师师','34456','123',0,'0',0,'0','4','部门管理员','1'),
('10','赵姗姗','34567','123',0,'0',0,'0','4','普通员工','0'),
('11','白石江','56123','123',0,'0',0,'0','5','部门管理员','1'),
('12','洪江市','56234','123',0,'0',0,'0','5','普通员工','0'),
('13','蔡司','56345','123',0,'0',0,'0','6','部门管理员','1'),
('14','陆顺','56456','123',0,'0',0,'0','6','普通员工','0'),
('15','李绅','56567','123',0,'0',0,'0','6','普通员工','0'),
('16','黄石港','56678','123',0,'0',0,'0','6','普通员工','0'),
('17','林生','78123','123',0,'0',0,'0','7','部门管理员','1'),
('18','张淑梅','78234','123',0,'0',0,'0','7','普通员工','0'),
('19','王淑芬','78345','123',0,'0',0,'0','7','普通员工','0'),
('20','陈世美','78456','123',0,'0',0,'0','7','普通员工','0'),
('21','徐淑敏','78567','123',0,'0',0,'0','8','部门管理员','1'),
('22','徐水丽','78678','123',0,'0',0,'0','8','普通员工','0'),
('23','刘胜男','78789','123',0,'0',0,'0','8','普通员工','0'),
('24','刘世明','78890','123',0,'0',0,'0','8','普通员工','0');

