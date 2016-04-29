create table ALARM_CONFIG
(
  id          NUMBER not null,
  all_alarm   BLOB,
  insert_time DATE default sysdate,
  description VARCHAR2(64)
);
comment on column ALARM_CONFIG.id
  is 'ID标识';
comment on column ALARM_CONFIG.all_alarm
  is '告警策略';
comment on column ALARM_CONFIG.insert_time
  is '插入时间';
comment on column ALARM_CONFIG.description
  is '描述';
alter table ALARM_CONFIG
  add primary key (ID);


create table APPLICATION
(
  id            NUMBER not null,
  name          VARCHAR2(64),
  public_ip     VARCHAR2(32),
  local_ip      VARCHAR2(32),
  insert_time   DATE default Sysdate,
  public_ip_raw VARCHAR2(256),
  local_ip_raw  VARCHAR2(256)
);
comment on column APPLICATION.id
  is 'ID标识';
comment on column APPLICATION.name
  is '应用名称';
comment on column APPLICATION.public_ip
  is '外网IP';
comment on column APPLICATION.local_ip
  is '内网IP';
comment on column APPLICATION.insert_time
  is '添加时间';
alter table APPLICATION
  add primary key (ID);


create sequence ALARM_CONFIG_SEQ
minvalue 1
maxvalue 99999999
start with 281
increment by 1
cache 20;

create sequence APPLICATION_SEQ
minvalue 1
maxvalue 99999999
start with 141
increment by 1
cache 20;

create or replace trigger ALARM_CONFIG_TRIG
  	before insert on ALARM_CONFIG
  	for each row
begin
    select ALARM_CONFIG_SEQ.nextval into :new.ID from dual;
end;
/

create or replace trigger APPLICATIONN_TRIG
  	before insert on APPLICATION
  	for each row
begin
    select APPLICATION_SEQ.nextval into :new.ID from dual;
end;
/
