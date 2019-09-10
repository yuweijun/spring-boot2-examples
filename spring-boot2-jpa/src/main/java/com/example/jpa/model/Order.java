package com.example.jpa.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.*;

/**
 * com.fasterxml.jackson.databind.exc.InvalidDefinitionException: No serializer found for class
 * org.hibernate.proxy.pojo.bytebuddy.ByteBuddyInterceptor and no properties discovered to create BeanSerializer (to
 * avoid exception, disable SerializationFeature.FAIL_ON_EMPTY_BEANS) (through reference chain:
 * com.example.jpa.model.Order$HibernateProxy$lxcFvXVz["hibernateLazyInitializer"]) at
 * com.fasterxml.jackson.databind.exc.InvalidDefinitionException.from(InvalidDefinitionException.java:77)
 * ~[jackson-databind-2.9.9.jar:2.9.9]
 *
 * <pre>
 * 不加这个会引起上面的异常，@JsonIgnoreProperties({"hibernateLazyInitializer"})
 * 可以看下面 Hibernate 生成的代理类里有个 getHibernateLazyInitializer() 方法
 * </pre>
 *
 * @author Weijun Yu
 * @since 2019-08-23.
 */
@Entity
@Table(name = "t_order")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String description;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToMany
    @JoinTable(name = "t_order_coffee", joinColumns = {@JoinColumn(name = "order_id")})
    @OrderBy("id DESC")
    private Set<Coffee> coffee = new HashSet<>();

    @Column(updatable = false)
    @Temporal(TemporalType.DATE)
    private Date createTime;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return getId() == order.getId() &&
            Objects.equals(getDescription(), order.getDescription()) &&
            getUser().equals(order.getUser()) &&
            getCreateTime().equals(order.getCreateTime()) &&
            getUpdateTime().equals(order.getUpdateTime());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getDescription(), getUser(), getCreateTime(), getUpdateTime());
    }
}

// package com.example.jpa.model;
//
// import java.lang.reflect.Method;
// import java.util.Date;
// import java.util.List;
// import org.hibernate.proxy.HibernateProxy;
// import org.hibernate.proxy.LazyInitializer;
// import org.hibernate.proxy.ProxyConfiguration;
// import org.hibernate.proxy.ProxyConfiguration.Interceptor;
// import org.hibernate.proxy.ProxyConfiguration.InterceptorDispatcher;
//
// public class Order$HibernateProxy$EQBeoEdX extends Order implements HibernateProxy, ProxyConfiguration {
//    private Interceptor $$_hibernate_interceptor;
//    // $FF: synthetic field
//    private static final Method cachedValue$BRdXHODs$co366m1 = Order.class.getMethod("getDescription");
//    // $FF: synthetic field
//    private static final Method cachedValue$BRdXHODs$sf8alh0 = Order.class.getMethod("getCreateTime");
//    // $FF: synthetic field
//    private static final Method cachedValue$BRdXHODs$o23rrk2 = HibernateProxy.class.getMethod("getHibernateLazyInitializer");
//    // $FF: synthetic field
//    private static final Method cachedValue$BRdXHODs$d2ig4k3 = Order.class.getMethod("getId");
//    // $FF: synthetic field
//    private static final Method cachedValue$BRdXHODs$90rvr72 = Order.class.getMethod("getUpdateTime");
//    // $FF: synthetic field
//    private static final Method cachedValue$BRdXHODs$klt3am2 = Order.class.getMethod("setDescription", String.class);
//    // $FF: synthetic field
//    private static final Method cachedValue$BRdXHODs$7m9oaq0 = Object.class.getDeclaredMethod("clone");
//    // $FF: synthetic field
//    private static final Method cachedValue$BRdXHODs$1j8cpk1;
//    // $FF: synthetic field
//    private static final Method cachedValue$BRdXHODs$fp45to2;
//    // $FF: synthetic field
//    private static final Method cachedValue$BRdXHODs$i9hker3;
//    // $FF: synthetic field
//    private static final Method cachedValue$BRdXHODs$r9jjnb1;
//    // $FF: synthetic field
//    private static final Method cachedValue$BRdXHODs$1ifmou0;
//    // $FF: synthetic field
//    private static final Method cachedValue$BRdXHODs$ep0ugl3;
//    // $FF: synthetic field
//    private static final Method cachedValue$BRdXHODs$nmflds3;
//    // $FF: synthetic field
//    private static final Method cachedValue$BRdXHODs$oj2bn41;
//    // $FF: synthetic field
//    private static final Method cachedValue$BRdXHODs$gpia792;
//    // $FF: synthetic field
//    private static final Method cachedValue$BRdXHODs$m175621;
//    // $FF: synthetic field
//    private static final Method cachedValue$BRdXHODs$jgpi333;
//    // $FF: synthetic field
//    private static final Method cachedValue$BRdXHODs$oisf2r3;
//
//    protected Object clone() throws CloneNotSupportedException {
//       return InterceptorDispatcher.intercept(this, cachedValue$BRdXHODs$7m9oaq0, new Object[0], (Object)null, this.$$_hibernate_interceptor);
//    }
//
//    public boolean equals(Object var1) {
//       return (Boolean)InterceptorDispatcher.intercept(this, cachedValue$BRdXHODs$jgpi333, new Object[]{var1}, false, this.$$_hibernate_interceptor);
//    }
//
//    public String toString() {
//       return (String)InterceptorDispatcher.intercept(this, cachedValue$BRdXHODs$i9hker3, new Object[0], (Object)null, this.$$_hibernate_interceptor);
//    }
//
//    public int hashCode() {
//       return (Integer)InterceptorDispatcher.intercept(this, cachedValue$BRdXHODs$nmflds3, new Object[0], 0, this.$$_hibernate_interceptor);
//    }
//
//    public int getId() {
//       return (Integer)InterceptorDispatcher.intercept(this, cachedValue$BRdXHODs$d2ig4k3, new Object[0], 0, this.$$_hibernate_interceptor);
//    }
//
//    public void setId(int var1) {
//       InterceptorDispatcher.intercept(this, cachedValue$BRdXHODs$1j8cpk1, new Object[]{var1}, (Object)null, this.$$_hibernate_interceptor);
//    }
//
//    public String getDescription() {
//       return (String)InterceptorDispatcher.intercept(this, cachedValue$BRdXHODs$co366m1, new Object[0], (Object)null, this.$$_hibernate_interceptor);
//    }
//
//    public void setDescription(String var1) {
//       InterceptorDispatcher.intercept(this, cachedValue$BRdXHODs$klt3am2, new Object[]{var1}, (Object)null, this.$$_hibernate_interceptor);
//    }
//
//    protected boolean canEqual(Object var1) {
//       return (Boolean)InterceptorDispatcher.intercept(this, cachedValue$BRdXHODs$oisf2r3, new Object[]{var1}, false, this.$$_hibernate_interceptor);
//    }
//
//    public Date getCreateTime() {
//       return (Date)InterceptorDispatcher.intercept(this, cachedValue$BRdXHODs$sf8alh0, new Object[0], (Object)null, this.$$_hibernate_interceptor);
//    }
//
//    public Date getUpdateTime() {
//       return (Date)InterceptorDispatcher.intercept(this, cachedValue$BRdXHODs$90rvr72, new Object[0], (Object)null, this.$$_hibernate_interceptor);
//    }
//
//    public void setCreateTime(Date var1) {
//       InterceptorDispatcher.intercept(this, cachedValue$BRdXHODs$ep0ugl3, new Object[]{var1}, (Object)null, this.$$_hibernate_interceptor);
//    }
//
//    public void setUpdateTime(Date var1) {
//       InterceptorDispatcher.intercept(this, cachedValue$BRdXHODs$r9jjnb1, new Object[]{var1}, (Object)null, this.$$_hibernate_interceptor);
//    }
//
//    public User getUser() {
//       return (User)InterceptorDispatcher.intercept(this, cachedValue$BRdXHODs$oj2bn41, new Object[0], (Object)null, this.$$_hibernate_interceptor);
//    }
//
//    public List getCoffee() {
//       return (List)InterceptorDispatcher.intercept(this, cachedValue$BRdXHODs$fp45to2, new Object[0], (Object)null, this.$$_hibernate_interceptor);
//    }
//
//    public void setUser(User var1) {
//       InterceptorDispatcher.intercept(this, cachedValue$BRdXHODs$m175621, new Object[]{var1}, (Object)null, this.$$_hibernate_interceptor);
//    }
//
//    public void setCoffee(List var1) {
//       InterceptorDispatcher.intercept(this, cachedValue$BRdXHODs$1ifmou0, new Object[]{var1}, (Object)null, this.$$_hibernate_interceptor);
//    }
//
//    public Object writeReplace() {
//       return InterceptorDispatcher.intercept(this, cachedValue$BRdXHODs$gpia792, new Object[0], (Object)null, this.$$_hibernate_interceptor);
//    }
//
//    public LazyInitializer getHibernateLazyInitializer() {
//       return (LazyInitializer)InterceptorDispatcher.intercept(this, cachedValue$BRdXHODs$o23rrk2, new Object[0], (Object)null, this.$$_hibernate_interceptor);
//    }
//
//    public void $$_hibernate_set_interceptor(Interceptor var1) {
//       this.$$_hibernate_interceptor = var1;
//    }
//
//    public Order$HibernateProxy$EQBeoEdX(int var1, String var2, User var3, List var4, Date var5, Date var6) {
//       super(var1, var2, var3, var4, var5, var6);
//    }
//
//    public Order$HibernateProxy$EQBeoEdX() {
//    }
//
//    static {
//       cachedValue$BRdXHODs$1j8cpk1 = Order.class.getMethod("setId", Integer.TYPE);
//       cachedValue$BRdXHODs$fp45to2 = Order.class.getMethod("getCoffee");
//       cachedValue$BRdXHODs$i9hker3 = Order.class.getMethod("toString");
//       cachedValue$BRdXHODs$r9jjnb1 = Order.class.getMethod("setUpdateTime", Date.class);
//       cachedValue$BRdXHODs$1ifmou0 = Order.class.getMethod("setCoffee", List.class);
//       cachedValue$BRdXHODs$ep0ugl3 = Order.class.getMethod("setCreateTime", Date.class);
//       cachedValue$BRdXHODs$nmflds3 = Order.class.getMethod("hashCode");
//       cachedValue$BRdXHODs$oj2bn41 = Order.class.getMethod("getUser");
//       cachedValue$BRdXHODs$gpia792 = HibernateProxy.class.getMethod("writeReplace");
//       cachedValue$BRdXHODs$m175621 = Order.class.getMethod("setUser", User.class);
//       cachedValue$BRdXHODs$jgpi333 = Order.class.getMethod("equals", Object.class);
//       cachedValue$BRdXHODs$oisf2r3 = Order.class.getDeclaredMethod("canEqual", Object.class);
//    }
// }
