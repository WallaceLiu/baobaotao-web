# baobaotao-web
练习项目
## Spring测试
1. 测试 @Value注解
2. 测试 @AutoWired注解
3. 测试 Junit
## MyBatis测试
1. 多数据源
```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans
	xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xmlns:context="http://www.springframework.org/schema/context"
	xsi:schemaLocation="http://www.springframework.org/schema/beans 
    		http://www.springframework.org/schema/beans/spring-beans.xsd
       		http://www.springframework.org/schema/context 
     		http://www.springframework.org/schema/context/spring-context.xsd"
	default-autowire="byName">

	<!-- BoneCP configuration -->
	<bean
		id="abstractDataSource"
		abstract="true"
		class="com.jolbox.bonecp.BoneCPDataSource"
		destroy-method="close">
		<property
			name="driverClass"
			value="${jdbc.driverClass}" />
		<property
			name="idleConnectionTestPeriodInMinutes"
			value="${jdbc.idleConnectionTestPeriod}" />
		<property
			name="idleMaxAgeInMinutes"
			value="${jdbc.idleMaxAge}" />
		<property
			name="maxConnectionsPerPartition"
			value="${jdbc.maxConnectionsPerPartition}" />
		<property
			name="minConnectionsPerPartition"
			value="${jdbc.minConnectionsPerPartition}" />
		<property
			name="partitionCount"
			value="${jdbc.partitionCount}" />
		<property
			name="acquireIncrement"
			value="${jdbc.acquireIncrement}" />
		<property
			name="statementsCacheSize"
			value="${jdbc.statementsCacheSize}" />
		<property
			name="releaseHelperThreads"
			value="${jdbc.releaseHelperThreads}" />
	</bean>
	<bean
		id="testDataSource"
		parent="abstractDataSource">
		<property
			name="jdbcUrl"
			value="${test.jdbc.jdbcUrl}" />
		<property
			name="username"
			value="${test.jdbc.username}" />
		<property
			name="password"
			value="${test.jdbc.password}" />
	</bean>

	<bean
		id="test2DataSource"
		parent="abstractDataSource">
		<property
			name="jdbcUrl"
			value="${test2.jdbc.jdbcUrl}" />
		<property
			name="username"
			value="${test2.jdbc.username}" />
		<property
			name="password"
			value="${test2.jdbc.password}" />
	</bean>

	<bean
		id="transactionManager"
		class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
		<property
			name="dataSource"
			ref="testDataSource" />
	</bean>

	<bean
		id="transactionManager2"
		class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
		<property
			name="dataSource"
			ref="test2DataSource" />
	</bean>

	<bean
		id="testSessionFactory"
		class="org.mybatis.spring.SqlSessionFactoryBean">
		<property
			name="dataSource"
			ref="testDataSource" />
		<property
			name="configLocation"
			value="classpath:sqlmap-config.xml" />
		<property
			name="mapperLocations"
			value="classpath:sqlmap/test/*.xml" />
	</bean>

	<bean
		id="test2SessionFactory"
		class="org.mybatis.spring.SqlSessionFactoryBean">
		<property
			name="dataSource"
			ref="test2DataSource" />
		<property
			name="configLocation"
			value="classpath:sqlmap-config.xml" />
		<property
			name="mapperLocations"
			value="classpath:sqlmap/test2/*.xml" />
	</bean>


	<bean class="org.mybatis.spring.mapper.MapperScannerConfigurer">
		<property
			name="basePackage"
			value="com.baobaotao.web.dao.test" />
		<property
			name="sqlSessionFactoryBeanName"
			value="testSessionFactory" />
	</bean>

	<bean class="org.mybatis.spring.mapper.MapperScannerConfigurer">
		<property
			name="basePackage"
			value="com.baobaotao.web.dao.test2" />
		<property
			name="sqlSessionFactoryBeanName"
			value="test2SessionFactory" />
	</bean>
</beans>
```
## Guava
1. 测试 Lamdba