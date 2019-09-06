package com.example.jpa.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

/**
 * @author Weijun Yu
 * @since 2019-08-23.
 */
@Entity
@Table(name = "t_user")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  private String name;

  private String nickName;

  private String mobile;

  @Column(updatable = false)
  @Temporal(TemporalType.DATE)
  private Date createTime;

  @Temporal(TemporalType.TIMESTAMP)
  private Date updateTime;
}

// package com.example.jpa.model;
//
// import java.lang.reflect.Method;
// import java.util.Date;
// import org.hibernate.proxy.HibernateProxy;
// import org.hibernate.proxy.LazyInitializer;
// import org.hibernate.proxy.ProxyConfiguration;
// import org.hibernate.proxy.ProxyConfiguration.Interceptor;
// import org.hibernate.proxy.ProxyConfiguration.InterceptorDispatcher;
//
// public class User$HibernateProxy$tmnA3MNP extends User implements HibernateProxy, ProxyConfiguration {
//    private Interceptor $$_hibernate_interceptor;
//    // $FF: synthetic field
//    private static final Method cachedValue$BHZ59bCV$o23rrk2 = HibernateProxy.class.getMethod("getHibernateLazyInitializer");
//    // $FF: synthetic field
//    private static final Method cachedValue$BHZ59bCV$d511hm1 = User.class.getMethod("getCreateTime");
//    // $FF: synthetic field
//    private static final Method cachedValue$BHZ59bCV$una70p0 = User.class.getMethod("getId");
//    // $FF: synthetic field
//    private static final Method cachedValue$BHZ59bCV$qljmnc3 = User.class.getMethod("getUpdateTime");
//    // $FF: synthetic field
//    private static final Method cachedValue$BHZ59bCV$3v9ba01 = User.class.getMethod("toString");
//    // $FF: synthetic field
//    private static final Method cachedValue$BHZ59bCV$7m9oaq0 = Object.class.getDeclaredMethod("clone");
//    // $FF: synthetic field
//    private static final Method cachedValue$BHZ59bCV$i813lp2;
//    // $FF: synthetic field
//    private static final Method cachedValue$BHZ59bCV$f2ksb93;
//    // $FF: synthetic field
//    private static final Method cachedValue$BHZ59bCV$r5uljt0;
//    // $FF: synthetic field
//    private static final Method cachedValue$BHZ59bCV$cvbajg2;
//    // $FF: synthetic field
//    private static final Method cachedValue$BHZ59bCV$8c8c911;
//    // $FF: synthetic field
//    private static final Method cachedValue$BHZ59bCV$opp0ju3;
//    // $FF: synthetic field
//    private static final Method cachedValue$BHZ59bCV$rbasqf1;
//    // $FF: synthetic field
//    private static final Method cachedValue$BHZ59bCV$gpia792;
//    // $FF: synthetic field
//    private static final Method cachedValue$BHZ59bCV$vepkcq0;
//    // $FF: synthetic field
//    private static final Method cachedValue$BHZ59bCV$fgrq9l0;
//    // $FF: synthetic field
//    private static final Method cachedValue$BHZ59bCV$46i9v70;
//    // $FF: synthetic field
//    private static final Method cachedValue$BHZ59bCV$o37sse2;
//    // $FF: synthetic field
//    private static final Method cachedValue$BHZ59bCV$98l6uv0;
//
//    protected Object clone() throws CloneNotSupportedException {
//       return InterceptorDispatcher.intercept(this, cachedValue$BHZ59bCV$7m9oaq0, new Object[0], (Object)null, this.$$_hibernate_interceptor);
//    }
//
//    public int getId() {
//       return (Integer)InterceptorDispatcher.intercept(this, cachedValue$BHZ59bCV$una70p0, new Object[0], 0, this.$$_hibernate_interceptor);
//    }
//
//    public String getName() {
//       return (String)InterceptorDispatcher.intercept(this, cachedValue$BHZ59bCV$opp0ju3, new Object[0], (Object)null, this.$$_hibernate_interceptor);
//    }
//
//    public String getNickName() {
//       return (String)InterceptorDispatcher.intercept(this, cachedValue$BHZ59bCV$rbasqf1, new Object[0], (Object)null, this.$$_hibernate_interceptor);
//    }
//
//    public String getMobile() {
//       return (String)InterceptorDispatcher.intercept(this, cachedValue$BHZ59bCV$fgrq9l0, new Object[0], (Object)null, this.$$_hibernate_interceptor);
//    }
//
//    public Date getCreateTime() {
//       return (Date)InterceptorDispatcher.intercept(this, cachedValue$BHZ59bCV$d511hm1, new Object[0], (Object)null, this.$$_hibernate_interceptor);
//    }
//
//    public Date getUpdateTime() {
//       return (Date)InterceptorDispatcher.intercept(this, cachedValue$BHZ59bCV$qljmnc3, new Object[0], (Object)null, this.$$_hibernate_interceptor);
//    }
//
//    public void setId(int var1) {
//       InterceptorDispatcher.intercept(this, cachedValue$BHZ59bCV$i813lp2, new Object[]{var1}, (Object)null, this.$$_hibernate_interceptor);
//    }
//
//    public void setName(String var1) {
//       InterceptorDispatcher.intercept(this, cachedValue$BHZ59bCV$o37sse2, new Object[]{var1}, (Object)null, this.$$_hibernate_interceptor);
//    }
//
//    public void setNickName(String var1) {
//       InterceptorDispatcher.intercept(this, cachedValue$BHZ59bCV$r5uljt0, new Object[]{var1}, (Object)null, this.$$_hibernate_interceptor);
//    }
//
//    public void setMobile(String var1) {
//       InterceptorDispatcher.intercept(this, cachedValue$BHZ59bCV$f2ksb93, new Object[]{var1}, (Object)null, this.$$_hibernate_interceptor);
//    }
//
//    public void setCreateTime(Date var1) {
//       InterceptorDispatcher.intercept(this, cachedValue$BHZ59bCV$vepkcq0, new Object[]{var1}, (Object)null, this.$$_hibernate_interceptor);
//    }
//
//    public void setUpdateTime(Date var1) {
//       InterceptorDispatcher.intercept(this, cachedValue$BHZ59bCV$cvbajg2, new Object[]{var1}, (Object)null, this.$$_hibernate_interceptor);
//    }
//
//    public boolean equals(Object var1) {
//       return (Boolean)InterceptorDispatcher.intercept(this, cachedValue$BHZ59bCV$46i9v70, new Object[]{var1}, false, this.$$_hibernate_interceptor);
//    }
//
//    protected boolean canEqual(Object var1) {
//       return (Boolean)InterceptorDispatcher.intercept(this, cachedValue$BHZ59bCV$98l6uv0, new Object[]{var1}, false, this.$$_hibernate_interceptor);
//    }
//
//    public int hashCode() {
//       return (Integer)InterceptorDispatcher.intercept(this, cachedValue$BHZ59bCV$8c8c911, new Object[0], 0, this.$$_hibernate_interceptor);
//    }
//
//    public String toString() {
//       return (String)InterceptorDispatcher.intercept(this, cachedValue$BHZ59bCV$3v9ba01, new Object[0], (Object)null, this.$$_hibernate_interceptor);
//    }
//
//    public Object writeReplace() {
//       return InterceptorDispatcher.intercept(this, cachedValue$BHZ59bCV$gpia792, new Object[0], (Object)null, this.$$_hibernate_interceptor);
//    }
//
//    public LazyInitializer getHibernateLazyInitializer() {
//       return (LazyInitializer)InterceptorDispatcher.intercept(this, cachedValue$BHZ59bCV$o23rrk2, new Object[0], (Object)null, this.$$_hibernate_interceptor);
//    }
//
//    public void $$_hibernate_set_interceptor(Interceptor var1) {
//       this.$$_hibernate_interceptor = var1;
//    }
//
//    public User$HibernateProxy$tmnA3MNP() {
//    }
//
//    public User$HibernateProxy$tmnA3MNP(int var1, String var2, String var3, String var4, Date var5, Date var6) {
//       super(var1, var2, var3, var4, var5, var6);
//    }
//
//    static {
//       cachedValue$BHZ59bCV$i813lp2 = User.class.getMethod("setId", Integer.TYPE);
//       cachedValue$BHZ59bCV$f2ksb93 = User.class.getMethod("setMobile", String.class);
//       cachedValue$BHZ59bCV$r5uljt0 = User.class.getMethod("setNickName", String.class);
//       cachedValue$BHZ59bCV$cvbajg2 = User.class.getMethod("setUpdateTime", Date.class);
//       cachedValue$BHZ59bCV$8c8c911 = User.class.getMethod("hashCode");
//       cachedValue$BHZ59bCV$opp0ju3 = User.class.getMethod("getName");
//       cachedValue$BHZ59bCV$rbasqf1 = User.class.getMethod("getNickName");
//       cachedValue$BHZ59bCV$gpia792 = HibernateProxy.class.getMethod("writeReplace");
//       cachedValue$BHZ59bCV$vepkcq0 = User.class.getMethod("setCreateTime", Date.class);
//       cachedValue$BHZ59bCV$fgrq9l0 = User.class.getMethod("getMobile");
//       cachedValue$BHZ59bCV$46i9v70 = User.class.getMethod("equals", Object.class);
//       cachedValue$BHZ59bCV$o37sse2 = User.class.getMethod("setName", String.class);
//       cachedValue$BHZ59bCV$98l6uv0 = User.class.getDeclaredMethod("canEqual", Object.class);
//    }
// }