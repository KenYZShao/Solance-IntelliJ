Download the zip file, extract it and open on IntelliJ.
Open src/main/java/com/solance/WorkflowApplication and run it.
Then open your browser and type http://localhost:8080/h2-console to test it

Below is the console log
  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::                (v3.2.0)

2025-08-06T21:28:45.752+01:00  INFO 18168 --- [           main] com.solance.WorkflowApplication          : Starting WorkflowApplication using Java 17.0.15 with PID 18168 (C:\Users\Ken Shao\IdeaProjects\solance-workflow-service\target\classes started by Ken Shao in C:\Users\Ken Shao\IdeaProjects\solance-workflow-service)
2025-08-06T21:28:45.755+01:00  INFO 18168 --- [           main] com.solance.WorkflowApplication          : No active profile set, falling back to 1 default profile: "default"
2025-08-06T21:28:47.067+01:00  INFO 18168 --- [           main] .s.d.r.c.RepositoryConfigurationDelegate : Multiple Spring Data modules found, entering strict repository configuration mode
2025-08-06T21:28:47.069+01:00  INFO 18168 --- [           main] .s.d.r.c.RepositoryConfigurationDelegate : Bootstrapping Spring Data JPA repositories in DEFAULT mode.
2025-08-06T21:28:47.244+01:00  INFO 18168 --- [           main] .s.d.r.c.RepositoryConfigurationDelegate : Finished Spring Data repository scanning in 166 ms. Found 2 JPA repository interfaces.
2025-08-06T21:28:47.262+01:00  INFO 18168 --- [           main] .s.d.r.c.RepositoryConfigurationDelegate : Multiple Spring Data modules found, entering strict repository configuration mode
2025-08-06T21:28:47.263+01:00  INFO 18168 --- [           main] .s.d.r.c.RepositoryConfigurationDelegate : Bootstrapping Spring Data Redis repositories in DEFAULT mode.
2025-08-06T21:28:47.281+01:00  INFO 18168 --- [           main] .RepositoryConfigurationExtensionSupport : Spring Data Redis - Could not safely identify store assignment for repository candidate interface com.solance.repository.AccountRepository; If you want this repository to be a Redis repository, consider annotating your entities with one of these annotations: org.springframework.data.redis.core.RedisHash (preferred), or consider extending one of the following types with your repository: org.springframework.data.keyvalue.repository.KeyValueRepository
2025-08-06T21:28:47.283+01:00  INFO 18168 --- [           main] .RepositoryConfigurationExtensionSupport : Spring Data Redis - Could not safely identify store assignment for repository candidate interface com.solance.repository.TransactionRepository; If you want this repository to be a Redis repository, consider annotating your entities with one of these annotations: org.springframework.data.redis.core.RedisHash (preferred), or consider extending one of the following types with your repository: org.springframework.data.keyvalue.repository.KeyValueRepository
2025-08-06T21:28:47.284+01:00  INFO 18168 --- [           main] .s.d.r.c.RepositoryConfigurationDelegate : Finished Spring Data repository scanning in 12 ms. Found 0 Redis repository interfaces.
2025-08-06T21:28:48.273+01:00  INFO 18168 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port 8080 (http)
2025-08-06T21:28:48.287+01:00  INFO 18168 --- [           main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
2025-08-06T21:28:48.288+01:00  INFO 18168 --- [           main] o.apache.catalina.core.StandardEngine    : Starting Servlet engine: [Apache Tomcat/10.1.16]
2025-08-06T21:28:48.378+01:00  INFO 18168 --- [           main] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
2025-08-06T21:28:48.380+01:00  INFO 18168 --- [           main] w.s.c.ServletWebServerApplicationContext : Root WebApplicationContext: initialization completed in 2570 ms
2025-08-06T21:28:48.544+01:00  INFO 18168 --- [           main] com.zaxxer.hikari.HikariDataSource       : SolanceHikariPool - Starting...
2025-08-06T21:28:48.750+01:00  INFO 18168 --- [           main] com.zaxxer.hikari.pool.HikariPool        : SolanceHikariPool - Added connection conn0: url=jdbc:h2:mem:testdb user=SA
2025-08-06T21:28:48.752+01:00  INFO 18168 --- [           main] com.zaxxer.hikari.HikariDataSource       : SolanceHikariPool - Start completed.
2025-08-06T21:28:48.765+01:00  INFO 18168 --- [           main] o.s.b.a.h2.H2ConsoleAutoConfiguration    : H2 console available at '/h2-console'. Database available at 'jdbc:h2:mem:testdb'
2025-08-06T21:28:49.000+01:00  INFO 18168 --- [           main] o.hibernate.jpa.internal.util.LogHelper  : HHH000204: Processing PersistenceUnitInfo [name: default]
2025-08-06T21:28:49.065+01:00  INFO 18168 --- [           main] org.hibernate.Version                    : HHH000412: Hibernate ORM core version 6.3.1.Final
2025-08-06T21:28:49.115+01:00  INFO 18168 --- [           main] o.h.c.internal.RegionFactoryInitiator    : HHH000026: Second-level cache disabled
2025-08-06T21:28:49.431+01:00  INFO 18168 --- [           main] o.s.o.j.p.SpringPersistenceUnitInfo      : No LoadTimeWeaver setup: ignoring JPA class transformer
2025-08-06T21:28:49.478+01:00  WARN 18168 --- [           main] org.hibernate.orm.deprecation            : HHH90000025: H2Dialect does not need to be specified explicitly using 'hibernate.dialect' (remove the property setting and it will be selected by default)
2025-08-06T21:28:50.403+01:00  INFO 18168 --- [           main] o.h.e.t.j.p.i.JtaPlatformInitiator       : HHH000489: No JTA platform available (set 'hibernate.transaction.jta.platform' to enable JTA platform integration)
2025-08-06T21:28:50.420+01:00  INFO 18168 --- [           main] org.hibernate.orm.connections.access     : HHH10001501: Connection obtained from JdbcConnectionAccess [org.hibernate.engine.jdbc.env.internal.JdbcEnvironmentInitiator$ConnectionProviderJdbcConnectionAccess@28705150] for (non-JTA) DDL execution was not in auto-commit mode; the Connection 'local transaction' will be committed and the Connection will be set into auto-commit mode.
Hibernate: 
    create table account (
        id bigint generated by default as identity,
        account_holder varchar(255),
        balance numeric(38,2),
        currency varchar(255),
        iban varchar(255),
        status varchar(255) check (status in ('ACTIVE','PENDING','SUSPENDED','CLOSED','DORMANT','FROZEN')),
        customer_id bigint,
        primary key (id)
    )
Hibernate: 
    create table customer (
        id bigint generated by default as identity,
        address varchar(255),
        country_code varchar(255),
        email varchar(255),
        name varchar(255),
        registration_date timestamp(6),
        primary key (id)
    )
Hibernate: 
    create table transactions (
        txn_type varchar(31) not null,
        id bigint generated by default as identity,
        amount numeric(19,4),
        currency varchar(3),
        status varchar(20) check (status in ('PENDING','PROCESSED','FAILED','REVERSED','CANCELLED')),
        timestamp timestamp(6),
        reference varchar(255),
        beneficiary_iban varchar(255),
        exchange_rate numeric(38,2),
        originating_country varchar(255),
        payment_reference varchar(255),
        purpose_reference varchar(255),
        target_currency varchar(255),
        primary key (id)
    )
Hibernate: 
    alter table if exists customer 
       drop constraint if exists UK_dwk6cx0afu8bs9o4t536v1j5v
Hibernate: 
    alter table if exists customer 
       add constraint UK_dwk6cx0afu8bs9o4t536v1j5v unique (email)
Hibernate: 
    alter table if exists account 
       add constraint FKnnwpo0lfq4xai1rs6887sx02k 
       foreign key (customer_id) 
       references customer
2025-08-06T21:28:50.457+01:00  INFO 18168 --- [           main] j.LocalContainerEntityManagerFactoryBean : Initialized JPA EntityManagerFactory for persistence unit 'default'
2025-08-06T21:28:50.937+01:00  INFO 18168 --- [           main] o.s.d.j.r.query.QueryEnhancerFactory     : Hibernate is in classpath; If applicable, HQL parser will be used.
2025-08-06T21:28:51.590+01:00  WARN 18168 --- [           main] JpaBaseConfiguration$JpaWebConfiguration : spring.jpa.open-in-view is enabled by default. Therefore, database queries may be performed during view rendering. Explicitly configure spring.jpa.open-in-view to disable this warning
2025-08-06T21:28:52.088+01:00  INFO 18168 --- [           main] o.s.b.a.e.web.EndpointLinksResolver      : Exposing 2 endpoint(s) beneath base path '/actuator'
2025-08-06T21:28:52.158+01:00  INFO 18168 --- [           main] o.s.s.web.DefaultSecurityFilterChain     : Will secure any request with [org.springframework.security.web.session.DisableEncodeUrlFilter@7f336491, org.springframework.security.web.context.request.async.WebAsyncManagerIntegrationFilter@5dd2e62a, org.springframework.security.web.context.SecurityContextHolderFilter@22aaa811, org.springframework.security.web.header.HeaderWriterFilter@71737478, org.springframework.web.filter.CorsFilter@2339ad10, org.springframework.security.web.authentication.logout.LogoutFilter@3e6b8b27, org.springframework.security.web.savedrequest.RequestCacheAwareFilter@3d45ea17, org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestFilter@756476a3, org.springframework.security.web.authentication.AnonymousAuthenticationFilter@1030ce34, org.springframework.security.web.session.SessionManagementFilter@6f8af186, org.springframework.security.web.access.ExceptionTranslationFilter@141cee26, org.springframework.security.web.access.intercept.AuthorizationFilter@6c1e2161]
2025-08-06T21:28:52.827+01:00  INFO 18168 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port 8080 (http) with context path ''
2025-08-06T21:28:52.840+01:00  INFO 18168 --- [           main] com.solance.WorkflowApplication          : Started WorkflowApplication in 7.49 seconds (process running for 11.32)
=== Database connection pool configuration verification ===
Connection pool name: SolanceHikariPool
Maximum number of connections:20
Minimum idle connection:10
Active connections:1
Connection test successful! Database:H2
2025-08-06T21:29:00.643+01:00  WARN 18168 --- [nio-8080-exec-1] o.s.w.s.h.HandlerMappingIntrospector     : Cache miss for REQUEST dispatch to '/h2-console/login.do' (previous null). Performing CorsConfiguration lookup. This is logged once only at WARN level, and every time at TRACE.
2025-08-06T21:29:00.947+01:00  INFO 18168 --- [nio-8080-exec-5] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring DispatcherServlet 'dispatcherServlet'
2025-08-06T21:29:00.948+01:00  INFO 18168 --- [nio-8080-exec-5] o.s.web.servlet.DispatcherServlet        : Initializing Servlet 'dispatcherServlet'
2025-08-06T21:29:00.951+01:00  INFO 18168 --- [nio-8080-exec-5] o.s.web.servlet.DispatcherServlet        : Completed initialization in 3 ms
2025-08-06T21:29:00.954+01:00  WARN 18168 --- [nio-8080-exec-5] o.s.w.s.h.HandlerMappingIntrospector     : Cache miss for REQUEST dispatch to '/favicon.ico' (previous null). Performing MatchableHandlerMapping lookup. This is logged once only at WARN level, and every time at TRACE.
