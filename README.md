# App-v1-boat-backend
backend for rowing project
# 1.getallfood

## 接口功能

> 获得所有食物列表

## URL

> /api/foods

## 支持格式

> JSON

## HTTP请求方式

> GET

## 请求参数

无

## 返回字段

返回所有食物列表，每个食物所包含字段如下

| 返回字段          | 字段类型    | 说明       |
|:--------------| :------ | :------- |
| id            | Ingeter | 食物id     |
| firstClass    | String  | 食物第一种类   |
| secondClass   | String  | 食物第二种类   |
| foodName      | String  | 食物名      |
| jibenyingyang | String  | 食物所含基本营养 |
| gongxiao      | String  | 食物功效     |
| kuangwuzhi    | String  | 食物所含矿物质  |
| weishengsu    | String  | 食物所含的维生素 |


# 2.get food by id

## 接口功能

> 根据id获得某个食物的信息

## URL

> /api/foods/{id}

## 支持格式

> JSON

## HTTP请求方式

> GET

## 请求参数

| 参数 | 必选   | 类型      | 说明     |
| :- | :--- | :------ | :----- |
| id | true | Integer | 所选食物id |

## 返回字段

| 返回字段          | 字段类型    | 说明       |
| :------------ | :------ | :------- |
| id            | Ingeter | 食物id     |
| firstClass    | String  | 食物第一种类   |
| firstClass    | String  | 食物第二种类   |
| foodName      | String  | 食物名      |
| jibenyingyang | String  | 食物所含基本营养 |
| gongxiao      | String  | 食物功效     |
| kuangwuzhi    | String  | 食物所含矿物质  |
| weishengsu    | String  | 食物所含的维生素 |


# 3.get food by class

## 接口功能

> 根据class获得某些食物的信息

## URL

> /api/foods/{class}

## 支持格式

> JSON

## HTTP请求方式

> GET

## 请求参数

| 参数    | 必选   | 类型     | 说明     |
| :---- | :--- | :----- | :----- |
| class | true | String | 所选食物种类 |

## 返回字段

| 返回字段          | 字段类型    | 说明       |
| :------------ | :------ | :------- |
| id            | Ingeter | 食物id     |
| firstClass    | String  | 食物第一种类   |
| firstClass    | String  | 食物第二种类   |
| foodName      | String  | 食物名      |
| jibenyingyang | String  | 食物所含基本营养 |
| gongxiao      | String  | 食物功效     |
| kuangwuzhi    | String  | 食物所含矿物质  |
| weishengsu    | String  | 食物所含的维生素 |

