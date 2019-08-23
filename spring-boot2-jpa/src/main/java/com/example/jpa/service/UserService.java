package com.example.jpa.service;

import com.example.jpa.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * @author yuweijun
 * @since 2019-08-23
 */
@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    /**
     * 当开启事务时，事务提交时 Hibernate 会检查持久化上下文是否处于脏状态，并且自动执行 SQL 更新内存中的状态与数据库的状态同步
     * <pre>
     * org.hibernate.loader.Loader              : Result row: EntityKey[com.example.jpa.model.User#3]
     * o.h.engine.internal.TwoPhaseLoad         : Resolving associations for [com.example.jpa.model.User#3]
     * o.h.engine.internal.TwoPhaseLoad         : Done materializing entity [com.example.jpa.model.User#3]
     * o.h.e.t.internal.TransactionImpl         : committing
     * o.h.e.i.AbstractFlushingEventListener    : Processing flush-time cascades
     * o.h.e.i.AbstractFlushingEventListener    : Dirty checking collections
     * o.h.e.i.AbstractFlushingEventListener    : Flushed: 0 insertions, 1 updates, 0 deletions to 1 objects
     * o.h.e.i.AbstractFlushingEventListener    : Flushed: 0 (re)creations, 0 updates, 0 removals to 0 collections
     * o.hibernate.internal.util.EntityPrinter  : Listing entities:
     * o.hibernate.internal.util.EntityPrinter  : com.example.jpa.model.User{createTime=2019-08-23 23:12:38.385, nickName=Sat Aug 24 23:13:30 CST 2019, mobile=13800000831, name=yu, updateTime=2019-08-23 23:12:57.445, id=3}
     * org.hibernate.SQL                        :
     *     update
     *         t_user
     *     set
     *         mobile=?,
     *         name=?,
     *         nick_name=?,
     *         update_time=?
     *     where
     *         id=?
     * Hibernate:
     *     update
     *         t_user
     *     set
     *         mobile=?,
     *         name=?,
     *         nick_name=?,
     *         update_time=?
     *     where
     *         id=?
     * </pre>
     *
     * 如果不开启事务则不会被更新
     */
    @Transactional
    public void update() {
        Date date = Date.from(LocalDateTime.now().plusDays(1).atZone(ZoneId.systemDefault()).toInstant());
        log.info("update date : {}", date);

        // update user
        userRepository.findByName("yu").get().setNickName(date.toString());
    }
}
