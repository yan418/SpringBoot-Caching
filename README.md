# SpringBoot-Caching
SpringBoot自带的Caching缓存+Redis缓存

## 数据
在 resources 路径下 bill.sql 

## Caching缓存 使用
``` bash

  1. 引入包....
  <dependency>
     <groupId>org.springframework.boot</groupId>
     <artifactId>spring-boot-starter-cache</artifactId>
  </dependency>
  2. 启动类 开启 @EnableCaching
  3. 方法上 
     查：@Cacheable(key = "#id")
     改：@CachePut(key="#result.id")
     删：@CacheEvict(key="#id")

```

## Caching缓存接口

``` bash
  /user/{id}     通过ID查询
  /update/{id}   通过ID更新
  /delete/{id}   通过ID删除
```

## Redis缓存 使用
``` bash

  1. 引入包....
   <dependency>
       <groupId>org.springframework.boot</groupId>
       <artifactId>spring-boot-starter-data-redis</artifactId>
   </dependency>
  2. 工具类 RedisClient类
  3. 方法上 
     调用对应的方法

```

## Redis缓存 接口

``` bash
  /provider/{id} 通过ID查询
  /pro/{id}      通过ID更新
  /prodel/{id}   通过ID删除
```
