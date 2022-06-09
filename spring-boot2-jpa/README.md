# FIX Caused by: org.h2.jdbc.JdbcSQLIntegrityConstraintViolationException: NULL not allowed for column "ID"; SQL statement: 

    https://github.com/h2database/h2database/issues/3325

> You can try to append ;MODE=LEGACY to JDBC URL as a temporary workaround, it this mode H2 accepts incorrect attempts to insert NULL into identity column.

## persistence.xml

    <property name="javax.persistence.jdbc.url" value="jdbc:h2:mem:JPA;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE;MODE=LEGACY"/>

## hibernate.cfg.example.xml and hibernate.cfg.hikari.xml

    <property name="connection.url">jdbc:h2:mem:JPA;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE;MODE=LEGACY</property>


