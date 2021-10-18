create table if not exists area
(
    id bigint auto_increment comment '地区id',
    areaname varchar(64) not null comment '地区名称，64位以内',
    description text null comment '描述，文本',
    constraint id_UNIQUE
        unique (id)
);

alter table area
    add primary key (id);

create table if not exists building_group
(
    id int(1) auto_increment comment '建筑群id'
        primary key,
    name varchar(10) not null comment '建筑群名，10个字符内'
);

create table if not exists building
(
    id bigint auto_increment comment '建筑id',
    name varchar(64) not null comment '建筑名称，不超过64',
    description text null comment '建筑描述',
    area_id bigint null comment '所在区域id',
    bg_id int(1) null comment '所属建筑群id',
    constraint id_UNIQUE
        unique (id),
    constraint fk_building_area
        foreign key (area_id) references area (id)
            on update cascade on delete cascade,
    constraint fk_building_building_group
        foreign key (bg_id) references building_group (id)
            on update cascade on delete cascade
);

create index fk_building_area_idx
    on building (area_id);

create index fk_building_building_group_idx
    on building (bg_id);

alter table building
    add primary key (id);

create table if not exists building_key
(
    building_id bigint not null,
    b_key varchar(45) not null,
    id bigint auto_increment
        primary key,
    constraint fk_building_id
        foreign key (building_id) references building (id)
            on update cascade on delete cascade
);

create table if not exists carbon_building
(
    id bigint auto_increment comment '记录id'
        primary key,
    building_id bigint not null comment '记录所属建筑id',
    create_time datetime default CURRENT_TIMESTAMP not null comment '创建时间',
    el_light decimal(20,4) null comment '照明插座用电量',
    el_air_condition decimal(20,4) null comment '空调用电',
    el_motion decimal(20,4) null comment '动力用电',
    el_special decimal(20,4) null comment '特殊用电',
    wa_supply decimal(20,4) null comment '总供水量',
    wa_drain decimal(20,4) null comment '总排水量',
    me_kitchen decimal(20,4) null comment '厨房用气量',
    me_heating decimal(20,4) null comment '供暖用气量',
    constraint fk_carbon_building_building
        foreign key (building_id) references building (id)
            on update cascade on delete cascade
);

create index carbon_building_create_time__index
    on carbon_building (create_time);

create index create_time
    on carbon_building (building_id, create_time);

create index fk_carbon_building_building_idx
    on carbon_building (building_id);

create table if not exists carbon_building_computed
(
    id bigint auto_increment
        primary key,
    create_time datetime default CURRENT_TIMESTAMP null,
    building_id bigint null,
    el_light_computed decimal(20,4) null,
    el_air_condition_computed decimal(20,4) null,
    el_motion_computed decimal(20,4) null,
    el_special_computed decimal(20,4) null,
    wa_supply_computed decimal(20,4) null,
    wa_drain_computed decimal(20,4) null,
    me_kitchen_computed decimal(20,4) null,
    me_heating_computed decimal(20,4) null,
    el_total_computed decimal(20,4) null,
    wa_total_computed decimal(20,4) null,
    me_total_computed decimal(20,4) null,
    total_computed decimal(20,4) null,
    constraint fk_carbon_builiding_info_period_building_id_building_id
        foreign key (building_id) references building (id)
            on update cascade on delete cascade
);

create index carbon_building_computed_create_time__index
    on carbon_building_computed (create_time);

create index fk_carbon_building_computed_create_time__idx
    on carbon_building_computed (building_id, create_time);

create index fk_carbon_builiding_info_period_building_id_building_id_idx
    on carbon_building_computed (building_id);

create table if not exists environment_building
(
    id bigint auto_increment
        primary key,
    temperature decimal(20,4) null,
    humidity decimal(20,4) null,
    wind_speed decimal(20,4) null,
    building_id bigint not null,
    create_time datetime not null,
    co2 decimal(20,4) null,
    constraint fk_building_id_environment_building_id
        foreign key (building_id) references building (id)
            on update cascade on delete cascade
);

create index environment_building_create_time_index
    on environment_building (create_time);

create index fk_building_id_environment_building_id_idx
    on environment_building (building_id);

create table if not exists user
(
    id bigint auto_increment comment '用户id',
    username varchar(32) not null comment '用户名，32位以内',
    password varchar(64) not null comment '密码，64位以内',
    email varchar(255) null comment '邮箱，255位以内',
    create_time datetime default CURRENT_TIMESTAMP null comment '创建的时间，默认为服务器时间',
    is_admin tinyint default 0 not null comment '0 -> 用户, 1 -> 管理员',
    is_enable tinyint default 1 not null comment '该用户是否开启',
    constraint email_UNIQUE
        unique (email),
    constraint id_UNIQUE
        unique (id),
    constraint username_UNIQUE
        unique (username)
);

alter table user
    add primary key (id);

