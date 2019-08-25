package com.example.jpa.service;

import com.example.jpa.model.Coffee;
import com.example.jpa.model.Order;
import com.example.jpa.repository.CoffeeRepository;
import com.example.jpa.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


/**
 * @author yuweijun
 * @since 2019-08-24
 */
@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CoffeeRepository coffeeRepository;

    /**
     * <pre>
     * 2019-08-24 12:03:37.067  INFO 57545 --- [nio-8080-exec-1] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring DispatcherServlet 'dispatcherServlet'
     * 2019-08-24 12:03:37.067  INFO 57545 --- [nio-8080-exec-1] o.s.web.servlet.DispatcherServlet        : Initializing Servlet 'dispatcherServlet'
     * 2019-08-24 12:03:37.075  INFO 57545 --- [nio-8080-exec-1] o.s.web.servlet.DispatcherServlet        : Completed initialization in 8 ms
     * 2019-08-24 12:03:37.127 DEBUG 57545 --- [nio-8080-exec-1] o.h.e.t.internal.TransactionImpl         : On TransactionImpl creation, JpaCompliance#isJpaTransactionComplianceEnabled == false
     * 2019-08-24 12:03:37.127 DEBUG 57545 --- [nio-8080-exec-1] o.h.e.t.internal.TransactionImpl         : begin
     * 2019-08-24 12:03:37.133 DEBUG 57545 --- [nio-8080-exec-1] org.hibernate.SQL                        :
     *     call next value for hibernate_sequence
     * Hibernate:
     *     call next value for hibernate_sequence
     * 2019-08-24 12:03:37.134 DEBUG 57545 --- [nio-8080-exec-1] o.h.id.enhanced.SequenceStructure        : Sequence value obtained: 6
     * 2019-08-24 12:03:37.134 DEBUG 57545 --- [nio-8080-exec-1] o.h.r.j.i.ResourceRegistryStandardImpl   : HHH000387: ResultSet's statement was not registered
     * 2019-08-24 12:03:37.134 DEBUG 57545 --- [nio-8080-exec-1] o.h.e.i.AbstractSaveEventListener        : Generated identifier: 6, using strategy: org.hibernate.id.enhanced.SequenceStyleGenerator
     * 2019-08-24 12:03:37.143 DEBUG 57545 --- [nio-8080-exec-1] org.hibernate.SQL                        :
     *     select
     *         order0_.id as id1_1_0_,
     *         order0_.create_time as create_t2_1_0_,
     *         order0_.description as descript3_1_0_,
     *         order0_.update_time as update_t4_1_0_,
     *         order0_.user_id as user_id5_1_0_,
     *         user1_.id as id1_3_1_,
     *         user1_.create_time as create_t2_3_1_,
     *         user1_.mobile as mobile3_3_1_,
     *         user1_.name as name4_3_1_,
     *         user1_.nick_name as nick_nam5_3_1_,
     *         user1_.update_time as update_t6_3_1_
     *     from
     *         t_order order0_
     *     left outer join
     *         t_user user1_
     *             on order0_.user_id=user1_.id
     *     where
     *         order0_.id=?
     * Hibernate:
     *     select
     *         order0_.id as id1_1_0_,
     *         order0_.create_time as create_t2_1_0_,
     *         order0_.description as descript3_1_0_,
     *         order0_.update_time as update_t4_1_0_,
     *         order0_.user_id as user_id5_1_0_,
     *         user1_.id as id1_3_1_,
     *         user1_.create_time as create_t2_3_1_,
     *         user1_.mobile as mobile3_3_1_,
     *         user1_.name as name4_3_1_,
     *         user1_.nick_name as nick_nam5_3_1_,
     *         user1_.update_time as update_t6_3_1_
     *     from
     *         t_order order0_
     *     left outer join
     *         t_user user1_
     *             on order0_.user_id=user1_.id
     *     where
     *         order0_.id=?
     * 2019-08-24 12:03:37.147 DEBUG 57545 --- [nio-8080-exec-1] o.h.l.p.e.p.i.ResultSetProcessorImpl     : Starting ResultSet row #0
     * 2019-08-24 12:03:37.149 DEBUG 57545 --- [nio-8080-exec-1] l.p.e.p.i.EntityReferenceInitializerImpl : On call to EntityIdentifierReaderImpl#resolve, EntityKey was already known; should only happen on root returns with an optional identifier specified
     * 2019-08-24 12:03:37.154 DEBUG 57545 --- [nio-8080-exec-1] o.h.engine.internal.TwoPhaseLoad         : Resolving associations for [com.example.jpa.model.Order#5]
     * 2019-08-24 12:03:37.156 DEBUG 57545 --- [nio-8080-exec-1] o.h.engine.internal.TwoPhaseLoad         : Done materializing entity [com.example.jpa.model.Order#5]
     * 2019-08-24 12:03:37.156 DEBUG 57545 --- [nio-8080-exec-1] o.h.engine.internal.TwoPhaseLoad         : Resolving associations for [com.example.jpa.model.User#3]
     * 2019-08-24 12:03:37.156 DEBUG 57545 --- [nio-8080-exec-1] o.h.engine.internal.TwoPhaseLoad         : Done materializing entity [com.example.jpa.model.User#3]
     * 2019-08-24 12:03:37.156 DEBUG 57545 --- [nio-8080-exec-1] o.h.r.j.i.ResourceRegistryStandardImpl   : HHH000387: ResultSet's statement was not registered
     * 2019-08-24 12:03:37.156 DEBUG 57545 --- [nio-8080-exec-1] .l.e.p.AbstractLoadPlanBasedEntityLoader : Done entity load : com.example.jpa.model.Order#5
     * 2019-08-24 12:03:37.158 DEBUG 57545 --- [nio-8080-exec-1] stractLoadPlanBasedCollectionInitializer : Loading collection: [com.example.jpa.model.Order.coffee#5]
     * 2019-08-24 12:03:37.158 DEBUG 57545 --- [nio-8080-exec-1] org.hibernate.SQL                        :
     *     select
     *         coffee0_.order_id as order_id1_2_0_,
     *         coffee0_.coffee_id as coffee_i2_2_0_,
     *         coffee1_.id as id1_0_1_,
     *         coffee1_.create_time as create_t2_0_1_,
     *         coffee1_.name as name3_0_1_,
     *         coffee1_.price as price4_0_1_,
     *         coffee1_.update_time as update_t5_0_1_
     *     from
     *         t_order_coffee coffee0_
     *     inner join
     *         t_menu coffee1_
     *             on coffee0_.coffee_id=coffee1_.id
     *     where
     *         coffee0_.order_id=?
     * Hibernate:
     *     select
     *         coffee0_.order_id as order_id1_2_0_,
     *         coffee0_.coffee_id as coffee_i2_2_0_,
     *         coffee1_.id as id1_0_1_,
     *         coffee1_.create_time as create_t2_0_1_,
     *         coffee1_.name as name3_0_1_,
     *         coffee1_.price as price4_0_1_,
     *         coffee1_.update_time as update_t5_0_1_
     *     from
     *         t_order_coffee coffee0_
     *     inner join
     *         t_menu coffee1_
     *             on coffee0_.coffee_id=coffee1_.id
     *     where
     *         coffee0_.order_id=?
     * 2019-08-24 12:03:37.160 DEBUG 57545 --- [nio-8080-exec-1] o.h.l.p.e.p.i.ResultSetProcessorImpl     : Preparing collection intializer : [com.example.jpa.model.Order.coffee#5]
     * 2019-08-24 12:03:37.162 DEBUG 57545 --- [nio-8080-exec-1] o.h.l.p.e.p.i.ResultSetProcessorImpl     : Starting ResultSet row #0
     * 2019-08-24 12:03:37.163 DEBUG 57545 --- [nio-8080-exec-1] e.p.i.CollectionReferenceInitializerImpl : Found row of collection: [com.example.jpa.model.Order.coffee#5]
     * 2019-08-24 12:03:37.163 DEBUG 57545 --- [nio-8080-exec-1] o.h.l.p.e.p.i.ResultSetProcessorImpl     : Starting ResultSet row #1
     * 2019-08-24 12:03:37.164 DEBUG 57545 --- [nio-8080-exec-1] e.p.i.CollectionReferenceInitializerImpl : Found row of collection: [com.example.jpa.model.Order.coffee#5]
     * 2019-08-24 12:03:37.164 DEBUG 57545 --- [nio-8080-exec-1] o.h.engine.internal.TwoPhaseLoad         : Resolving associations for [com.example.jpa.model.Coffee#1]
     * 2019-08-24 12:03:37.164 DEBUG 57545 --- [nio-8080-exec-1] o.h.engine.internal.TwoPhaseLoad         : Done materializing entity [com.example.jpa.model.Coffee#1]
     * 2019-08-24 12:03:37.164 DEBUG 57545 --- [nio-8080-exec-1] o.h.engine.internal.TwoPhaseLoad         : Resolving associations for [com.example.jpa.model.Coffee#2]
     * 2019-08-24 12:03:37.164 DEBUG 57545 --- [nio-8080-exec-1] o.h.engine.internal.TwoPhaseLoad         : Done materializing entity [com.example.jpa.model.Coffee#2]
     * 2019-08-24 12:03:37.164 DEBUG 57545 --- [nio-8080-exec-1] o.h.e.l.internal.CollectionLoadContext   : 1 collections were found in result set for role: com.example.jpa.model.Order.coffee
     * 2019-08-24 12:03:37.164 DEBUG 57545 --- [nio-8080-exec-1] o.h.e.l.internal.CollectionLoadContext   : Collection fully initialized: [com.example.jpa.model.Order.coffee#5]
     * 2019-08-24 12:03:37.164 DEBUG 57545 --- [nio-8080-exec-1] o.h.e.l.internal.CollectionLoadContext   : 1 collections initialized for role: com.example.jpa.model.Order.coffee
     * 2019-08-24 12:03:37.164 DEBUG 57545 --- [nio-8080-exec-1] o.h.r.j.i.ResourceRegistryStandardImpl   : HHH000387: ResultSet's statement was not registered
     * 2019-08-24 12:03:37.165 DEBUG 57545 --- [nio-8080-exec-1] stractLoadPlanBasedCollectionInitializer : Done loading collection
     * 2019-08-24 12:03:37.165 DEBUG 57545 --- [nio-8080-exec-1] o.h.e.t.internal.TransactionImpl         : committing
     * 2019-08-24 12:03:37.165 DEBUG 57545 --- [nio-8080-exec-1] o.h.e.i.AbstractFlushingEventListener    : Processing flush-time cascades
     * 2019-08-24 12:03:37.165 DEBUG 57545 --- [nio-8080-exec-1] o.h.e.i.AbstractFlushingEventListener    : Dirty checking collections
     * 2019-08-24 12:03:37.165 DEBUG 57545 --- [nio-8080-exec-1] o.hibernate.engine.spi.CollectionEntry   : Collection dirty: [com.example.jpa.model.Order.coffee#5]
     * 2019-08-24 12:03:37.165 DEBUG 57545 --- [nio-8080-exec-1] o.hibernate.engine.internal.Collections  : Collection found: [com.example.jpa.model.Order.coffee#5], was: [com.example.jpa.model.Order.coffee#5] (initialized)
     * 2019-08-24 12:03:37.165 DEBUG 57545 --- [nio-8080-exec-1] o.h.e.i.AbstractFlushingEventListener    : Flushed: 1 insertions, 0 updates, 0 deletions to 5 objects
     * 2019-08-24 12:03:37.166 DEBUG 57545 --- [nio-8080-exec-1] o.h.e.i.AbstractFlushingEventListener    : Flushed: 0 (re)creations, 1 updates, 0 removals to 1 collections
     * 2019-08-24 12:03:37.166 DEBUG 57545 --- [nio-8080-exec-1] o.hibernate.internal.util.EntityPrinter  : Listing entities:
     * 2019-08-24 12:03:37.166 DEBUG 57545 --- [nio-8080-exec-1] o.hibernate.internal.util.EntityPrinter  : com.example.jpa.model.Coffee{createTime=2019-08-24 12:02:54.866, price=20, name=espresso, updateTime=2019-08-24 12:02:54.866, id=1}
     * 2019-08-24 12:03:37.166 DEBUG 57545 --- [nio-8080-exec-1] o.hibernate.internal.util.EntityPrinter  : com.example.jpa.model.Order{createTime=2019-08-24 12:02:54.905, coffee=[com.example.jpa.model.Coffee#1, com.example.jpa.model.Coffee#2, com.example.jpa.model.Coffee#6], description=null, updateTime=2019-08-24 12:02:54.905, id=5, user=com.example.jpa.model.User#3}
     * 2019-08-24 12:03:37.166 DEBUG 57545 --- [nio-8080-exec-1] o.hibernate.internal.util.EntityPrinter  : com.example.jpa.model.User{createTime=2019-08-24 12:02:54.88, nickName=test, mobile=13800000831, name=yu, updateTime=2019-08-24 12:02:54.88, id=3}
     * 2019-08-24 12:03:37.166 DEBUG 57545 --- [nio-8080-exec-1] o.hibernate.internal.util.EntityPrinter  : com.example.jpa.model.Coffee{createTime=null, price=20, name=America, updateTime=null, id=6}
     * 2019-08-24 12:03:37.166 DEBUG 57545 --- [nio-8080-exec-1] o.hibernate.internal.util.EntityPrinter  : com.example.jpa.model.Coffee{createTime=2019-08-24 12:02:54.876, price=30, name=latte, updateTime=2019-08-24 12:02:54.876, id=2}
     * 2019-08-24 12:03:37.166 DEBUG 57545 --- [nio-8080-exec-1] org.hibernate.SQL                        :
     *     insert
     *     into
     *         t_menu
     *         (create_time, name, price, update_time, id)
     *     values
     *         (?, ?, ?, ?, ?)
     * Hibernate:
     *     insert
     *     into
     *         t_menu
     *         (create_time, name, price, update_time, id)
     *     values
     *         (?, ?, ?, ?, ?)
     * 2019-08-24 12:03:37.167 DEBUG 57545 --- [nio-8080-exec-1] o.h.p.c.AbstractCollectionPersister      : Deleting collection: [com.example.jpa.model.Order.coffee#5]
     * 2019-08-24 12:03:37.167 DEBUG 57545 --- [nio-8080-exec-1] org.hibernate.SQL                        :
     *     delete
     *     from
     *         t_order_coffee
     *     where
     *         order_id=?
     * Hibernate:
     *     delete
     *     from
     *         t_order_coffee
     *     where
     *         order_id=?
     * 2019-08-24 12:03:37.169 DEBUG 57545 --- [nio-8080-exec-1] o.h.p.c.AbstractCollectionPersister      : Done deleting collection
     * 2019-08-24 12:03:37.169 DEBUG 57545 --- [nio-8080-exec-1] o.h.p.c.AbstractCollectionPersister      : Inserting collection: [com.example.jpa.model.Order.coffee#5]
     * 2019-08-24 12:03:37.169 DEBUG 57545 --- [nio-8080-exec-1] org.hibernate.SQL                        :
     *     insert
     *     into
     *         t_order_coffee
     *         (order_id, coffee_id)
     *     values
     *         (?, ?)
     * Hibernate:
     *     insert
     *     into
     *         t_order_coffee
     *         (order_id, coffee_id)
     *     values
     *         (?, ?)
     * 2019-08-24 12:03:37.170 DEBUG 57545 --- [nio-8080-exec-1] org.hibernate.SQL                        :
     *     insert
     *     into
     *         t_order_coffee
     *         (order_id, coffee_id)
     *     values
     *         (?, ?)
     * Hibernate:
     *     insert
     *     into
     *         t_order_coffee
     *         (order_id, coffee_id)
     *     values
     *         (?, ?)
     * 2019-08-24 12:03:37.170 DEBUG 57545 --- [nio-8080-exec-1] org.hibernate.SQL                        :
     *     insert
     *     into
     *         t_order_coffee
     *         (order_id, coffee_id)
     *     values
     *         (?, ?)
     * Hibernate:
     *     insert
     *     into
     *         t_order_coffee
     *         (order_id, coffee_id)
     *     values
     *         (?, ?)
     * 2019-08-24 12:03:37.171 DEBUG 57545 --- [nio-8080-exec-1] o.h.p.c.AbstractCollectionPersister      : Done inserting collection: 3 rows inserted
     * 2019-08-24 12:03:37.298 DEBUG 57545 --- [nio-8080-exec-1] o.h.e.jdbc.internal.JdbcCoordinatorImpl  : HHH000420: Closing un-released batch
     * </pre>
     *
     * @param id orderId
     * @return order retrieved from db
     */
    @Transactional
    public Order findById(int id) {
        Coffee america = Coffee.builder().name("America")
                               .price(20L)
                               .build();
        coffeeRepository.save(america);

        Optional<Order> optionalOrder = orderRepository.findById(id);
        if (optionalOrder.isPresent()) {
            Order order = optionalOrder.get();
            // 会删除原来的元素 delete from
            // 然后再关系表 t_order_coffee 增加一条数据
            order.getCoffee().add(america);
            return order;
        }

        return null;
    }

    /**
     * <pre>
     * 2019-08-24 19:24:48.125 DEBUG 60640 --- [nio-8080-exec-4] o.h.e.t.internal.TransactionImpl         : On TransactionImpl creation, JpaCompliance#isJpaTransactionComplianceEnabled == false
     * 2019-08-24 19:24:48.132 DEBUG 60640 --- [nio-8080-exec-4] o.h.e.t.internal.TransactionImpl         : begin
     * 2019-08-24 19:24:48.134 DEBUG 60640 --- [nio-8080-exec-4] org.hibernate.SQL                        :
     *     call next value for hibernate_sequence
     * Hibernate:
     *     call next value for hibernate_sequence
     * 2019-08-24 19:24:48.134 DEBUG 60640 --- [nio-8080-exec-4] o.h.id.enhanced.SequenceStructure        : Sequence value obtained: 7
     * 2019-08-24 19:24:48.134 DEBUG 60640 --- [nio-8080-exec-4] o.h.r.j.i.ResourceRegistryStandardImpl   : HHH000387: ResultSet's statement was not registered
     * 2019-08-24 19:24:48.134 DEBUG 60640 --- [nio-8080-exec-4] o.h.e.i.AbstractSaveEventListener        : Generated identifier: 7, using strategy: org.hibernate.id.enhanced.SequenceStyleGenerator
     * 2019-08-24 19:24:48.134 DEBUG 60640 --- [nio-8080-exec-4] o.h.e.t.internal.TransactionImpl         : committing
     * 2019-08-24 19:24:48.134 DEBUG 60640 --- [nio-8080-exec-4] o.h.e.i.AbstractFlushingEventListener    : Processing flush-time cascades
     * 2019-08-24 19:24:48.134 DEBUG 60640 --- [nio-8080-exec-4] o.h.e.i.AbstractFlushingEventListener    : Dirty checking collections
     * 2019-08-24 19:24:48.134 DEBUG 60640 --- [nio-8080-exec-4] o.h.e.i.AbstractFlushingEventListener    : Flushed: 1 insertions, 0 updates, 0 deletions to 1 objects
     * 2019-08-24 19:24:48.134 DEBUG 60640 --- [nio-8080-exec-4] o.h.e.i.AbstractFlushingEventListener    : Flushed: 0 (re)creations, 0 updates, 0 removals to 0 collections
     * 2019-08-24 19:24:48.134 DEBUG 60640 --- [nio-8080-exec-4] o.hibernate.internal.util.EntityPrinter  : Listing entities:
     * 2019-08-24 19:24:48.134 DEBUG 60640 --- [nio-8080-exec-4] o.hibernate.internal.util.EntityPrinter  : com.example.jpa.model.Coffee{createTime=null, price=20, name=America, updateTime=null, id=7}
     * 2019-08-24 19:24:48.135 DEBUG 60640 --- [nio-8080-exec-4] org.hibernate.SQL                        :
     *     insert
     *     into
     *         t_menu
     *         (create_time, name, price, update_time, id)
     *     values
     *         (?, ?, ?, ?, ?)
     * Hibernate:
     *     insert
     *     into
     *         t_menu
     *         (create_time, name, price, update_time, id)
     *     values
     *         (?, ?, ?, ?, ?)
     * 2019-08-24 19:24:48.135 DEBUG 60640 --- [nio-8080-exec-4] o.h.e.t.internal.TransactionImpl         : begin
     * 2019-08-24 19:24:48.136 DEBUG 60640 --- [nio-8080-exec-4] org.hibernate.SQL                        :
     *     select
     *         order0_.id as id1_1_0_,
     *         order0_.create_time as create_t2_1_0_,
     *         order0_.description as descript3_1_0_,
     *         order0_.update_time as update_t4_1_0_,
     *         order0_.user_id as user_id5_1_0_,
     *         user1_.id as id1_3_1_,
     *         user1_.create_time as create_t2_3_1_,
     *         user1_.mobile as mobile3_3_1_,
     *         user1_.name as name4_3_1_,
     *         user1_.nick_name as nick_nam5_3_1_,
     *         user1_.update_time as update_t6_3_1_
     *     from
     *         t_order order0_
     *     left outer join
     *         t_user user1_
     *             on order0_.user_id=user1_.id
     *     where
     *         order0_.id=?
     * Hibernate:
     *     select
     *         order0_.id as id1_1_0_,
     *         order0_.create_time as create_t2_1_0_,
     *         order0_.description as descript3_1_0_,
     *         order0_.update_time as update_t4_1_0_,
     *         order0_.user_id as user_id5_1_0_,
     *         user1_.id as id1_3_1_,
     *         user1_.create_time as create_t2_3_1_,
     *         user1_.mobile as mobile3_3_1_,
     *         user1_.name as name4_3_1_,
     *         user1_.nick_name as nick_nam5_3_1_,
     *         user1_.update_time as update_t6_3_1_
     *     from
     *         t_order order0_
     *     left outer join
     *         t_user user1_
     *             on order0_.user_id=user1_.id
     *     where
     *         order0_.id=?
     * 2019-08-24 19:24:48.136 DEBUG 60640 --- [nio-8080-exec-4] o.h.l.p.e.p.i.ResultSetProcessorImpl     : Starting ResultSet row #0
     * 2019-08-24 19:24:48.136 DEBUG 60640 --- [nio-8080-exec-4] l.p.e.p.i.EntityReferenceInitializerImpl : On call to EntityIdentifierReaderImpl#resolve, EntityKey was already known; should only happen on root returns with an optional identifier specified
     * 2019-08-24 19:24:48.137 DEBUG 60640 --- [nio-8080-exec-4] o.h.engine.internal.TwoPhaseLoad         : Resolving associations for [com.example.jpa.model.Order#5]
     * 2019-08-24 19:24:48.137 DEBUG 60640 --- [nio-8080-exec-4] o.h.engine.internal.TwoPhaseLoad         : Done materializing entity [com.example.jpa.model.Order#5]
     * 2019-08-24 19:24:48.137 DEBUG 60640 --- [nio-8080-exec-4] o.h.engine.internal.TwoPhaseLoad         : Resolving associations for [com.example.jpa.model.User#3]
     * 2019-08-24 19:24:48.137 DEBUG 60640 --- [nio-8080-exec-4] o.h.engine.internal.TwoPhaseLoad         : Done materializing entity [com.example.jpa.model.User#3]
     * 2019-08-24 19:24:48.137 DEBUG 60640 --- [nio-8080-exec-4] o.h.r.j.i.ResourceRegistryStandardImpl   : HHH000387: ResultSet's statement was not registered
     * 2019-08-24 19:24:48.137 DEBUG 60640 --- [nio-8080-exec-4] .l.e.p.AbstractLoadPlanBasedEntityLoader : Done entity load : com.example.jpa.model.Order#5
     * 2019-08-24 19:24:48.137 DEBUG 60640 --- [nio-8080-exec-4] o.h.e.t.internal.TransactionImpl         : committing
     * 2019-08-24 19:24:48.138 DEBUG 60640 --- [nio-8080-exec-4] stractLoadPlanBasedCollectionInitializer : Loading collection: [com.example.jpa.model.Order.coffee#5]
     * 2019-08-24 19:24:48.138 DEBUG 60640 --- [nio-8080-exec-4] org.hibernate.SQL                        :
     *     select
     *         coffee0_.order_id as order_id1_2_0_,
     *         coffee0_.coffee_id as coffee_i2_2_0_,
     *         coffee1_.id as id1_0_1_,
     *         coffee1_.create_time as create_t2_0_1_,
     *         coffee1_.name as name3_0_1_,
     *         coffee1_.price as price4_0_1_,
     *         coffee1_.update_time as update_t5_0_1_
     *     from
     *         t_order_coffee coffee0_
     *     inner join
     *         t_menu coffee1_
     *             on coffee0_.coffee_id=coffee1_.id
     *     where
     *         coffee0_.order_id=?
     * Hibernate:
     *     select
     *         coffee0_.order_id as order_id1_2_0_,
     *         coffee0_.coffee_id as coffee_i2_2_0_,
     *         coffee1_.id as id1_0_1_,
     *         coffee1_.create_time as create_t2_0_1_,
     *         coffee1_.name as name3_0_1_,
     *         coffee1_.price as price4_0_1_,
     *         coffee1_.update_time as update_t5_0_1_
     *     from
     *         t_order_coffee coffee0_
     *     inner join
     *         t_menu coffee1_
     *             on coffee0_.coffee_id=coffee1_.id
     *     where
     *         coffee0_.order_id=?
     * 2019-08-24 19:24:48.138 DEBUG 60640 --- [nio-8080-exec-4] o.h.l.p.e.p.i.ResultSetProcessorImpl     : Preparing collection intializer : [com.example.jpa.model.Order.coffee#5]
     * 2019-08-24 19:24:48.138 DEBUG 60640 --- [nio-8080-exec-4] o.h.l.p.e.p.i.ResultSetProcessorImpl     : Starting ResultSet row #0
     * 2019-08-24 19:24:48.138 DEBUG 60640 --- [nio-8080-exec-4] e.p.i.CollectionReferenceInitializerImpl : Found row of collection: [com.example.jpa.model.Order.coffee#5]
     * 2019-08-24 19:24:48.138 DEBUG 60640 --- [nio-8080-exec-4] o.h.l.p.e.p.i.ResultSetProcessorImpl     : Starting ResultSet row #1
     * 2019-08-24 19:24:48.139 DEBUG 60640 --- [nio-8080-exec-4] e.p.i.CollectionReferenceInitializerImpl : Found row of collection: [com.example.jpa.model.Order.coffee#5]
     * 2019-08-24 19:24:48.139 DEBUG 60640 --- [nio-8080-exec-4] o.h.engine.internal.TwoPhaseLoad         : Resolving associations for [com.example.jpa.model.Coffee#1]
     * 2019-08-24 19:24:48.139 DEBUG 60640 --- [nio-8080-exec-4] o.h.engine.internal.TwoPhaseLoad         : Done materializing entity [com.example.jpa.model.Coffee#1]
     * 2019-08-24 19:24:48.139 DEBUG 60640 --- [nio-8080-exec-4] o.h.engine.internal.TwoPhaseLoad         : Resolving associations for [com.example.jpa.model.Coffee#2]
     * 2019-08-24 19:24:48.139 DEBUG 60640 --- [nio-8080-exec-4] o.h.engine.internal.TwoPhaseLoad         : Done materializing entity [com.example.jpa.model.Coffee#2]
     * 2019-08-24 19:24:48.139 DEBUG 60640 --- [nio-8080-exec-4] o.h.e.l.internal.CollectionLoadContext   : 1 collections were found in result set for role: com.example.jpa.model.Order.coffee
     * 2019-08-24 19:24:48.139 DEBUG 60640 --- [nio-8080-exec-4] o.h.e.l.internal.CollectionLoadContext   : Collection fully initialized: [com.example.jpa.model.Order.coffee#5]
     * 2019-08-24 19:24:48.139 DEBUG 60640 --- [nio-8080-exec-4] o.h.e.l.internal.CollectionLoadContext   : 1 collections initialized for role: com.example.jpa.model.Order.coffee
     * 2019-08-24 19:24:48.139 DEBUG 60640 --- [nio-8080-exec-4] o.h.r.j.i.ResourceRegistryStandardImpl   : HHH000387: ResultSet's statement was not registered
     * 2019-08-24 19:24:48.139 DEBUG 60640 --- [nio-8080-exec-4] stractLoadPlanBasedCollectionInitializer : Done loading collection
     * </pre>
     *
     * 没有事务管理时不会自动保存变更对象
     *
     * @param id orderId
     * @return order
     */
    public Order findById2(int id) {
        Coffee america = Coffee.builder().name("America")
                               .price(20L)
                               .build();
        coffeeRepository.save(america);

        Optional<Order> optionalOrder = orderRepository.findById(id);
        if (optionalOrder.isPresent()) {
            Order order = optionalOrder.get();
            // 不会删除原来的元素 delete from
            // 不会增加关系表数据
            order.getCoffee().add(america);
            return order;
        }

        return null;
    }

}
