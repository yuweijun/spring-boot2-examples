package com.example.jpa.service;

import com.example.jpa.model.Coffee;
import com.example.jpa.model.Order;
import com.example.jpa.repository.CoffeeRepository;
import com.example.jpa.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
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
     * 2019-08-24 12:03:37.167 DEBUG 57545 --- [nio-8080-exec-1] o.h.p.c.AbstractCollectionPersister      : Deleting collection: [com.example.jpa.model.Order.coffee#5]
     * 2019-08-24 12:03:37.167 DEBUG 57545 --- [nio-8080-exec-1] org.hibernate.SQL                        :
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
     * 2019-08-24 12:03:37.170 DEBUG 57545 --- [nio-8080-exec-1] org.hibernate.SQL                        :
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
            List<Coffee> coffee = order.getCoffee();
            coffee.add(america);
            return order;
        }

        return null;
    }

}

// PersistentBag (org.hibernate.collection.internal)
//     instantiate:29, BagType (org.hibernate.type)
//     getCollection:790, CollectionType (org.hibernate.type)
//     resolveKey:469, CollectionType (org.hibernate.type)
//     resolve:462, CollectionType (org.hibernate.type)
//     doInitializeEntity:172, TwoPhaseLoad (org.hibernate.engine.internal)
//     initializeEntity:129, TwoPhaseLoad (org.hibernate.engine.internal)
//     performTwoPhaseLoad:238, AbstractRowReader (org.hibernate.loader.plan.exec.process.internal)
//     finishUp:209, AbstractRowReader (org.hibernate.loader.plan.exec.process.internal)
//     extractResults:133, ResultSetProcessorImpl (org.hibernate.loader.plan.exec.process.internal)
//     executeLoad:122, AbstractLoadPlanBasedLoader (org.hibernate.loader.plan.exec.internal)
//     executeLoad:86, AbstractLoadPlanBasedLoader (org.hibernate.loader.plan.exec.internal)
//     load:188, AbstractLoadPlanBasedEntityLoader (org.hibernate.loader.entity.plan)
//     load:4273, AbstractEntityPersister (org.hibernate.persister.entity)
//     loadFromDatasource:511, DefaultLoadEventListener (org.hibernate.event.internal)
//     doLoad:481, DefaultLoadEventListener (org.hibernate.event.internal)
//     load:222, DefaultLoadEventListener (org.hibernate.event.internal)
//     proxyOrLoad:281, DefaultLoadEventListener (org.hibernate.event.internal)
//     doOnLoad:124, DefaultLoadEventListener (org.hibernate.event.internal)
//     onLoad:92, DefaultLoadEventListener (org.hibernate.event.internal)
//     fireLoad:1257, SessionImpl (org.hibernate.internal)
//     access$2000:208, SessionImpl (org.hibernate.internal)
//     doLoad:2881, SessionImpl$IdentifierLoadAccessImpl (org.hibernate.internal)
//     load:2855, SessionImpl$IdentifierLoadAccessImpl (org.hibernate.internal)
//     find:3490, SessionImpl (org.hibernate.internal)
//     find:3459, SessionImpl (org.hibernate.internal)
//     invoke0:-1, NativeMethodAccessorImpl (sun.reflect)
//     invoke:62, NativeMethodAccessorImpl (sun.reflect)
//     invoke:43, DelegatingMethodAccessorImpl (sun.reflect)
//     invoke:498, Method (java.lang.reflect)
//     invoke:350, ExtendedEntityManagerCreator$ExtendedEntityManagerInvocationHandler (org.springframework.orm.jpa)
//     find:-1, $Proxy107 (com.sun.proxy)
//     invoke0:-1, NativeMethodAccessorImpl (sun.reflect)
//     invoke:62, NativeMethodAccessorImpl (sun.reflect)
//     invoke:43, DelegatingMethodAccessorImpl (sun.reflect)
//     invoke:498, Method (java.lang.reflect)
//     invoke:309, SharedEntityManagerCreator$SharedEntityManagerInvocationHandler (org.springframework.orm.jpa)
//     find:-1, $Proxy107 (com.sun.proxy)
//     findById:274, SimpleJpaRepository (org.springframework.data.jpa.repository.support)
//     invoke0:-1, NativeMethodAccessorImpl (sun.reflect)
//     invoke:62, NativeMethodAccessorImpl (sun.reflect)
//     invoke:43, DelegatingMethodAccessorImpl (sun.reflect)
//     invoke:498, Method (java.lang.reflect)
//     invoke:359, RepositoryComposition$RepositoryFragments (org.springframework.data.repository.core.support)
//     invoke:200, RepositoryComposition (org.springframework.data.repository.core.support)
//     invoke:644, RepositoryFactorySupport$ImplementationMethodExecutionInterceptor (org.springframework.data.repository.core.support)
//     proceed:186, ReflectiveMethodInvocation (org.springframework.aop.framework)
//     doInvoke:608, RepositoryFactorySupport$QueryExecutorMethodInterceptor (org.springframework.data.repository.core.support)
//     lambda$invoke$3:595, RepositoryFactorySupport$QueryExecutorMethodInterceptor (org.springframework.data.repository.core.support)
//     get:-1, 940454178 (org.springframework.data.repository.core.support.RepositoryFactorySupport$QueryExecutorMethodInterceptor$$Lambda$885)
//     apply:-1, 1233454027 (org.springframework.data.repository.util.QueryExecutionConverters$$Lambda$884)
//     invoke:595, RepositoryFactorySupport$QueryExecutorMethodInterceptor (org.springframework.data.repository.core.support)
//     proceed:186, ReflectiveMethodInvocation (org.springframework.aop.framework)
//     invoke:59, DefaultMethodInvokingMethodInterceptor (org.springframework.data.projection)
//     proceed:186, ReflectiveMethodInvocation (org.springframework.aop.framework)
//     proceedWithInvocation:-1, 712726821 (org.springframework.transaction.interceptor.TransactionInterceptor$$Lambda$882)
//     invokeWithinTransaction:295, TransactionAspectSupport (org.springframework.transaction.interceptor)
//     invoke:98, TransactionInterceptor (org.springframework.transaction.interceptor)
//     proceed:186, ReflectiveMethodInvocation (org.springframework.aop.framework)
//     invoke:139, PersistenceExceptionTranslationInterceptor (org.springframework.dao.support)
//     proceed:186, ReflectiveMethodInvocation (org.springframework.aop.framework)
//     invoke:144, CrudMethodMetadataPostProcessor$CrudMethodMetadataPopulatingMethodInterceptor (org.springframework.data.jpa.repository.support)
//     proceed:186, ReflectiveMethodInvocation (org.springframework.aop.framework)
//     invoke:364, CrudMethodMetadataPostProcessor$ExposeRepositoryInvocationInterceptor (org.springframework.data.jpa.repository.support)
//     proceed:186, ReflectiveMethodInvocation (org.springframework.aop.framework)
//     invoke:93, ExposeInvocationInterceptor (org.springframework.aop.interceptor)
//     proceed:186, ReflectiveMethodInvocation (org.springframework.aop.framework)
//     invoke:61, SurroundingTransactionDetectorMethodInterceptor (org.springframework.data.repository.core.support)
//     proceed:186, ReflectiveMethodInvocation (org.springframework.aop.framework)
//     invoke:212, JdkDynamicAopProxy (org.springframework.aop.framework)
//     findById:-1, $Proxy112 (com.sun.proxy)
//     findById2:272, OrderService (com.example.jpa.service)
//     invoke:-1, OrderService$$FastClassBySpringCGLIB$$7ae73d44 (com.example.jpa.service)
//     invoke:218, MethodProxy (org.springframework.cglib.proxy)
//     intercept:684, CglibAopProxy$DynamicAdvisedInterceptor (org.springframework.aop.framework)
//     findById2:-1, OrderService$$EnhancerBySpringCGLIB$$481c043a (com.example.jpa.service)
//     add2:58, OrderController (com.example.jpa.controller)
//     invoke0:-1, NativeMethodAccessorImpl (sun.reflect)
//     invoke:62, NativeMethodAccessorImpl (sun.reflect)
//     invoke:43, DelegatingMethodAccessorImpl (sun.reflect)
//     invoke:498, Method (java.lang.reflect)
//     doInvoke:190, InvocableHandlerMethod (org.springframework.web.method.support)
//     invokeForRequest:138, InvocableHandlerMethod (org.springframework.web.method.support)
//     invokeAndHandle:104, ServletInvocableHandlerMethod (org.springframework.web.servlet.mvc.method.annotation)
//     invokeHandlerMethod:892, RequestMappingHandlerAdapter (org.springframework.web.servlet.mvc.method.annotation)
//     handleInternal:797, RequestMappingHandlerAdapter (org.springframework.web.servlet.mvc.method.annotation)
//     handle:87, AbstractHandlerMethodAdapter (org.springframework.web.servlet.mvc.method)
//     doDispatch:1039, DispatcherServlet (org.springframework.web.servlet)
//     doService:942, DispatcherServlet (org.springframework.web.servlet)
//     processRequest:1005, FrameworkServlet (org.springframework.web.servlet)
//     doGet:897, FrameworkServlet (org.springframework.web.servlet)
//     service:634, HttpServlet (javax.servlet.http)
//     service:882, FrameworkServlet (org.springframework.web.servlet)
//     service:741, HttpServlet (javax.servlet.http)
//     internalDoFilter:231, ApplicationFilterChain (org.apache.catalina.core)
//     doFilter:166, ApplicationFilterChain (org.apache.catalina.core)
//     doFilter:53, WsFilter (org.apache.tomcat.websocket.server)
//     internalDoFilter:193, ApplicationFilterChain (org.apache.catalina.core)
//     doFilter:166, ApplicationFilterChain (org.apache.catalina.core)
//     doFilterInternal:88, HttpTraceFilter (org.springframework.boot.actuate.web.trace.servlet)
//     doFilter:118, OncePerRequestFilter (org.springframework.web.filter)
//     internalDoFilter:193, ApplicationFilterChain (org.apache.catalina.core)
//     doFilter:166, ApplicationFilterChain (org.apache.catalina.core)
//     doFilterInternal:99, RequestContextFilter (org.springframework.web.filter)
//     doFilter:118, OncePerRequestFilter (org.springframework.web.filter)
//     internalDoFilter:193, ApplicationFilterChain (org.apache.catalina.core)
//     doFilter:166, ApplicationFilterChain (org.apache.catalina.core)
//     doFilterInternal:92, FormContentFilter (org.springframework.web.filter)
//     doFilter:118, OncePerRequestFilter (org.springframework.web.filter)
//     internalDoFilter:193, ApplicationFilterChain (org.apache.catalina.core)
//     doFilter:166, ApplicationFilterChain (org.apache.catalina.core)
//     doFilterInternal:93, HiddenHttpMethodFilter (org.springframework.web.filter)
//     doFilter:118, OncePerRequestFilter (org.springframework.web.filter)
//     internalDoFilter:193, ApplicationFilterChain (org.apache.catalina.core)
//     doFilter:166, ApplicationFilterChain (org.apache.catalina.core)
//     filterAndRecordMetrics:114, WebMvcMetricsFilter (org.springframework.boot.actuate.metrics.web.servlet)
//     doFilterInternal:104, WebMvcMetricsFilter (org.springframework.boot.actuate.metrics.web.servlet)
//     doFilter:118, OncePerRequestFilter (org.springframework.web.filter)
//     internalDoFilter:193, ApplicationFilterChain (org.apache.catalina.core)
//     doFilter:166, ApplicationFilterChain (org.apache.catalina.core)
//     doFilterInternal:200, CharacterEncodingFilter (org.springframework.web.filter)
//     doFilter:118, OncePerRequestFilter (org.springframework.web.filter)
//     internalDoFilter:193, ApplicationFilterChain (org.apache.catalina.core)
//     doFilter:166, ApplicationFilterChain (org.apache.catalina.core)
//     invoke:202, StandardWrapperValve (org.apache.catalina.core)
//     invoke:96, StandardContextValve (org.apache.catalina.core)
//     invoke:490, AuthenticatorBase (org.apache.catalina.authenticator)
//     invoke:139, StandardHostValve (org.apache.catalina.core)
//     invoke:92, ErrorReportValve (org.apache.catalina.valves)
//     invoke:74, StandardEngineValve (org.apache.catalina.core)
//     service:343, CoyoteAdapter (org.apache.catalina.connector)
//     service:408, Http11Processor (org.apache.coyote.http11)
//     process:66, AbstractProcessorLight (org.apache.coyote)
//     process:853, AbstractProtocol$ConnectionHandler (org.apache.coyote)
//     doRun:1587, NioEndpoint$SocketProcessor (org.apache.tomcat.util.net)
//     run:49, SocketProcessorBase (org.apache.tomcat.util.net)
//     runWorker:1149, ThreadPoolExecutor (java.util.concurrent)
//     run:624, ThreadPoolExecutor$Worker (java.util.concurrent)
//     run:61, TaskThread$WrappingRunnable (org.apache.tomcat.util.threads)
//     run:748, Thread (java.lang)