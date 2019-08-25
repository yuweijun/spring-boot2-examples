package com.example.jpa.repository;

import com.example.jpa.model.Coffee;
import org.springframework.data.repository.CrudRepository;

public interface CoffeeRepository extends CrudRepository<Coffee, Integer> {
}

// package com.sun.proxy;
//
// import com.example.jpa.repository.CoffeeRepository;
// import java.lang.reflect.InvocationHandler;
// import java.lang.reflect.Method;
// import java.lang.reflect.Proxy;
// import java.lang.reflect.UndeclaredThrowableException;
// import java.util.Optional;
// import org.aopalliance.aop.Advice;
// import org.springframework.aop.Advisor;
// import org.springframework.aop.TargetSource;
// import org.springframework.aop.framework.Advised;
// import org.springframework.aop.framework.AopConfigException;
// import org.springframework.core.DecoratingProxy;
// import org.springframework.data.repository.Repository;
// import org.springframework.transaction.interceptor.TransactionalProxy;
//
// public final class $Proxy109 extends Proxy implements CoffeeRepository, Repository, TransactionalProxy, Advised, DecoratingProxy {
//    private static Method m1;
//    private static Method m4;
//    private static Method m13;
//    private static Method m24;
//    private static Method m27;
//    private static Method m23;
//    private static Method m29;
//    private static Method m20;
//    private static Method m3;
//    private static Method m14;
//    private static Method m19;
//    private static Method m32;
//    private static Method m33;
//    private static Method m0;
//    private static Method m5;
//    private static Method m21;
//    private static Method m8;
//    private static Method m34;
//    private static Method m12;
//    private static Method m11;
//    private static Method m18;
//    private static Method m17;
//    private static Method m10;
//    private static Method m7;
//    private static Method m2;
//    private static Method m6;
//    private static Method m36;
//    private static Method m28;
//    private static Method m37;
//    private static Method m30;
//    private static Method m9;
//    private static Method m15;
//    private static Method m16;
//    private static Method m31;
//    private static Method m25;
//    private static Method m35;
//    private static Method m22;
//    private static Method m26;
//
//    public $Proxy109(InvocationHandler var1) throws  {
//       super(var1);
//    }
//
//    public final boolean equals(Object var1) throws  {
//       try {
//          return (Boolean)super.h.invoke(this, m1, new Object[]{var1});
//       } catch (RuntimeException | Error var3) {
//          throw var3;
//       } catch (Throwable var4) {
//          throw new UndeclaredThrowableException(var4);
//       }
//    }
//
//    public final void delete(Object var1) throws  {
//       try {
//          super.h.invoke(this, m4, new Object[]{var1});
//       } catch (RuntimeException | Error var3) {
//          throw var3;
//       } catch (Throwable var4) {
//          throw new UndeclaredThrowableException(var4);
//       }
//    }
//
//    public final void deleteAll() throws  {
//       try {
//          super.h.invoke(this, m13, (Object[])null);
//       } catch (RuntimeException | Error var2) {
//          throw var2;
//       } catch (Throwable var3) {
//          throw new UndeclaredThrowableException(var3);
//       }
//    }
//
//    public final boolean isExposeProxy() throws  {
//       try {
//          return (Boolean)super.h.invoke(this, m24, (Object[])null);
//       } catch (RuntimeException | Error var2) {
//          throw var2;
//       } catch (Throwable var3) {
//          throw new UndeclaredThrowableException(var3);
//       }
//    }
//
//    public final void addAdvisor(Advisor var1) throws AopConfigException {
//       try {
//          super.h.invoke(this, m27, new Object[]{var1});
//       } catch (RuntimeException | Error var3) {
//          throw var3;
//       } catch (Throwable var4) {
//          throw new UndeclaredThrowableException(var4);
//       }
//    }
//
//    public final boolean isProxyTargetClass() throws  {
//       try {
//          return (Boolean)super.h.invoke(this, m23, (Object[])null);
//       } catch (RuntimeException | Error var2) {
//          throw var2;
//       } catch (Throwable var3) {
//          throw new UndeclaredThrowableException(var3);
//       }
//    }
//
//    public final void removeAdvisor(int var1) throws AopConfigException {
//       try {
//          super.h.invoke(this, m29, new Object[]{var1});
//       } catch (RuntimeException | Error var3) {
//          throw var3;
//       } catch (Throwable var4) {
//          throw new UndeclaredThrowableException(var4);
//       }
//    }
//
//    public final Class[] getProxiedInterfaces() throws  {
//       try {
//          return (Class[])super.h.invoke(this, m20, (Object[])null);
//       } catch (RuntimeException | Error var2) {
//          throw var2;
//       } catch (Throwable var3) {
//          throw new UndeclaredThrowableException(var3);
//       }
//    }
//
//    public final long count() throws  {
//       try {
//          return (Long)super.h.invoke(this, m3, (Object[])null);
//       } catch (RuntimeException | Error var2) {
//          throw var2;
//       } catch (Throwable var3) {
//          throw new UndeclaredThrowableException(var3);
//       }
//    }
//
//    public final int indexOf(Advisor var1) throws  {
//       try {
//          return (Integer)super.h.invoke(this, m14, new Object[]{var1});
//       } catch (RuntimeException | Error var3) {
//          throw var3;
//       } catch (Throwable var4) {
//          throw new UndeclaredThrowableException(var4);
//       }
//    }
//
//    public final TargetSource getTargetSource() throws  {
//       try {
//          return (TargetSource)super.h.invoke(this, m19, (Object[])null);
//       } catch (RuntimeException | Error var2) {
//          throw var2;
//       } catch (Throwable var3) {
//          throw new UndeclaredThrowableException(var3);
//       }
//    }
//
//    public final void addAdvice(int var1, Advice var2) throws AopConfigException {
//       try {
//          super.h.invoke(this, m32, new Object[]{var1, var2});
//       } catch (RuntimeException | Error var4) {
//          throw var4;
//       } catch (Throwable var5) {
//          throw new UndeclaredThrowableException(var5);
//       }
//    }
//
//    public final void addAdvice(Advice var1) throws AopConfigException {
//       try {
//          super.h.invoke(this, m33, new Object[]{var1});
//       } catch (RuntimeException | Error var3) {
//          throw var3;
//       } catch (Throwable var4) {
//          throw new UndeclaredThrowableException(var4);
//       }
//    }
//
//    public final int hashCode() throws  {
//       try {
//          return (Integer)super.h.invoke(this, m0, (Object[])null);
//       } catch (RuntimeException | Error var2) {
//          throw var2;
//       } catch (Throwable var3) {
//          throw new UndeclaredThrowableException(var3);
//       }
//    }
//
//    public final Object save(Object var1) throws  {
//       try {
//          return (Object)super.h.invoke(this, m5, new Object[]{var1});
//       } catch (RuntimeException | Error var3) {
//          throw var3;
//       } catch (Throwable var4) {
//          throw new UndeclaredThrowableException(var4);
//       }
//    }
//
//    public final boolean isInterfaceProxied(Class var1) throws  {
//       try {
//          return (Boolean)super.h.invoke(this, m21, new Object[]{var1});
//       } catch (RuntimeException | Error var3) {
//          throw var3;
//       } catch (Throwable var4) {
//          throw new UndeclaredThrowableException(var4);
//       }
//    }
//
//    public final Iterable findAll() throws  {
//       try {
//          return (Iterable)super.h.invoke(this, m8, (Object[])null);
//       } catch (RuntimeException | Error var2) {
//          throw var2;
//       } catch (Throwable var3) {
//          throw new UndeclaredThrowableException(var3);
//       }
//    }
//
//    public final boolean removeAdvice(Advice var1) throws  {
//       try {
//          return (Boolean)super.h.invoke(this, m34, new Object[]{var1});
//       } catch (RuntimeException | Error var3) {
//          throw var3;
//       } catch (Throwable var4) {
//          throw new UndeclaredThrowableException(var4);
//       }
//    }
//
//    public final void deleteAll(Iterable var1) throws  {
//       try {
//          super.h.invoke(this, m12, new Object[]{var1});
//       } catch (RuntimeException | Error var3) {
//          throw var3;
//       } catch (Throwable var4) {
//          throw new UndeclaredThrowableException(var4);
//       }
//    }
//
//    public final void deleteById(Object var1) throws  {
//       try {
//          super.h.invoke(this, m11, new Object[]{var1});
//       } catch (RuntimeException | Error var3) {
//          throw var3;
//       } catch (Throwable var4) {
//          throw new UndeclaredThrowableException(var4);
//       }
//    }
//
//    public final void setExposeProxy(boolean var1) throws  {
//       try {
//          super.h.invoke(this, m18, new Object[]{var1});
//       } catch (RuntimeException | Error var3) {
//          throw var3;
//       } catch (Throwable var4) {
//          throw new UndeclaredThrowableException(var4);
//       }
//    }
//
//    public final void setTargetSource(TargetSource var1) throws  {
//       try {
//          super.h.invoke(this, m17, new Object[]{var1});
//       } catch (RuntimeException | Error var3) {
//          throw var3;
//       } catch (Throwable var4) {
//          throw new UndeclaredThrowableException(var4);
//       }
//    }
//
//    public final boolean existsById(Object var1) throws  {
//       try {
//          return (Boolean)super.h.invoke(this, m10, new Object[]{var1});
//       } catch (RuntimeException | Error var3) {
//          throw var3;
//       } catch (Throwable var4) {
//          throw new UndeclaredThrowableException(var4);
//       }
//    }
//
//    public final Optional findById(Object var1) throws  {
//       try {
//          return (Optional)super.h.invoke(this, m7, new Object[]{var1});
//       } catch (RuntimeException | Error var3) {
//          throw var3;
//       } catch (Throwable var4) {
//          throw new UndeclaredThrowableException(var4);
//       }
//    }
//
//    public final String toString() throws  {
//       try {
//          return (String)super.h.invoke(this, m2, (Object[])null);
//       } catch (RuntimeException | Error var2) {
//          throw var2;
//       } catch (Throwable var3) {
//          throw new UndeclaredThrowableException(var3);
//       }
//    }
//
//    public final Iterable saveAll(Iterable var1) throws  {
//       try {
//          return (Iterable)super.h.invoke(this, m6, new Object[]{var1});
//       } catch (RuntimeException | Error var3) {
//          throw var3;
//       } catch (Throwable var4) {
//          throw new UndeclaredThrowableException(var4);
//       }
//    }
//
//    public final Class getTargetClass() throws  {
//       try {
//          return (Class)super.h.invoke(this, m36, (Object[])null);
//       } catch (RuntimeException | Error var2) {
//          throw var2;
//       } catch (Throwable var3) {
//          throw new UndeclaredThrowableException(var3);
//       }
//    }
//
//    public final void addAdvisor(int var1, Advisor var2) throws AopConfigException {
//       try {
//          super.h.invoke(this, m28, new Object[]{var1, var2});
//       } catch (RuntimeException | Error var4) {
//          throw var4;
//       } catch (Throwable var5) {
//          throw new UndeclaredThrowableException(var5);
//       }
//    }
//
//    public final Class getDecoratedClass() throws  {
//       try {
//          return (Class)super.h.invoke(this, m37, (Object[])null);
//       } catch (RuntimeException | Error var2) {
//          throw var2;
//       } catch (Throwable var3) {
//          throw new UndeclaredThrowableException(var3);
//       }
//    }
//
//    public final boolean removeAdvisor(Advisor var1) throws  {
//       try {
//          return (Boolean)super.h.invoke(this, m30, new Object[]{var1});
//       } catch (RuntimeException | Error var3) {
//          throw var3;
//       } catch (Throwable var4) {
//          throw new UndeclaredThrowableException(var4);
//       }
//    }
//
//    public final Iterable findAllById(Iterable var1) throws  {
//       try {
//          return (Iterable)super.h.invoke(this, m9, new Object[]{var1});
//       } catch (RuntimeException | Error var3) {
//          throw var3;
//       } catch (Throwable var4) {
//          throw new UndeclaredThrowableException(var4);
//       }
//    }
//
//    public final int indexOf(Advice var1) throws  {
//       try {
//          return (Integer)super.h.invoke(this, m15, new Object[]{var1});
//       } catch (RuntimeException | Error var3) {
//          throw var3;
//       } catch (Throwable var4) {
//          throw new UndeclaredThrowableException(var4);
//       }
//    }
//
//    public final boolean isFrozen() throws  {
//       try {
//          return (Boolean)super.h.invoke(this, m16, (Object[])null);
//       } catch (RuntimeException | Error var2) {
//          throw var2;
//       } catch (Throwable var3) {
//          throw new UndeclaredThrowableException(var3);
//       }
//    }
//
//    public final boolean replaceAdvisor(Advisor var1, Advisor var2) throws AopConfigException {
//       try {
//          return (Boolean)super.h.invoke(this, m31, new Object[]{var1, var2});
//       } catch (RuntimeException | Error var4) {
//          throw var4;
//       } catch (Throwable var5) {
//          throw new UndeclaredThrowableException(var5);
//       }
//    }
//
//    public final void setPreFiltered(boolean var1) throws  {
//       try {
//          super.h.invoke(this, m25, new Object[]{var1});
//       } catch (RuntimeException | Error var3) {
//          throw var3;
//       } catch (Throwable var4) {
//          throw new UndeclaredThrowableException(var4);
//       }
//    }
//
//    public final String toProxyConfigString() throws  {
//       try {
//          return (String)super.h.invoke(this, m35, (Object[])null);
//       } catch (RuntimeException | Error var2) {
//          throw var2;
//       } catch (Throwable var3) {
//          throw new UndeclaredThrowableException(var3);
//       }
//    }
//
//    public final Advisor[] getAdvisors() throws  {
//       try {
//          return (Advisor[])super.h.invoke(this, m22, (Object[])null);
//       } catch (RuntimeException | Error var2) {
//          throw var2;
//       } catch (Throwable var3) {
//          throw new UndeclaredThrowableException(var3);
//       }
//    }
//
//    public final boolean isPreFiltered() throws  {
//       try {
//          return (Boolean)super.h.invoke(this, m26, (Object[])null);
//       } catch (RuntimeException | Error var2) {
//          throw var2;
//       } catch (Throwable var3) {
//          throw new UndeclaredThrowableException(var3);
//       }
//    }
//
//    static {
//       try {
//          m1 = Class.forName("java.lang.Object").getMethod("equals", Class.forName("java.lang.Object"));
//          m4 = Class.forName("com.example.jpa.repository.CoffeeRepository").getMethod("delete", Class.forName("java.lang.Object"));
//          m13 = Class.forName("com.example.jpa.repository.CoffeeRepository").getMethod("deleteAll");
//          m24 = Class.forName("org.springframework.aop.framework.Advised").getMethod("isExposeProxy");
//          m27 = Class.forName("org.springframework.aop.framework.Advised").getMethod("addAdvisor", Class.forName("org.springframework.aop.Advisor"));
//          m23 = Class.forName("org.springframework.aop.framework.Advised").getMethod("isProxyTargetClass");
//          m29 = Class.forName("org.springframework.aop.framework.Advised").getMethod("removeAdvisor", Integer.TYPE);
//          m20 = Class.forName("org.springframework.aop.framework.Advised").getMethod("getProxiedInterfaces");
//          m3 = Class.forName("com.example.jpa.repository.CoffeeRepository").getMethod("count");
//          m14 = Class.forName("org.springframework.aop.framework.Advised").getMethod("indexOf", Class.forName("org.springframework.aop.Advisor"));
//          m19 = Class.forName("org.springframework.aop.framework.Advised").getMethod("getTargetSource");
//          m32 = Class.forName("org.springframework.aop.framework.Advised").getMethod("addAdvice", Integer.TYPE, Class.forName("org.aopalliance.aop.Advice"));
//          m33 = Class.forName("org.springframework.aop.framework.Advised").getMethod("addAdvice", Class.forName("org.aopalliance.aop.Advice"));
//          m0 = Class.forName("java.lang.Object").getMethod("hashCode");
//          m5 = Class.forName("com.example.jpa.repository.CoffeeRepository").getMethod("save", Class.forName("java.lang.Object"));
//          m21 = Class.forName("org.springframework.aop.framework.Advised").getMethod("isInterfaceProxied", Class.forName("java.lang.Class"));
//          m8 = Class.forName("com.example.jpa.repository.CoffeeRepository").getMethod("findAll");
//          m34 = Class.forName("org.springframework.aop.framework.Advised").getMethod("removeAdvice", Class.forName("org.aopalliance.aop.Advice"));
//          m12 = Class.forName("com.example.jpa.repository.CoffeeRepository").getMethod("deleteAll", Class.forName("java.lang.Iterable"));
//          m11 = Class.forName("com.example.jpa.repository.CoffeeRepository").getMethod("deleteById", Class.forName("java.lang.Object"));
//          m18 = Class.forName("org.springframework.aop.framework.Advised").getMethod("setExposeProxy", Boolean.TYPE);
//          m17 = Class.forName("org.springframework.aop.framework.Advised").getMethod("setTargetSource", Class.forName("org.springframework.aop.TargetSource"));
//          m10 = Class.forName("com.example.jpa.repository.CoffeeRepository").getMethod("existsById", Class.forName("java.lang.Object"));
//          m7 = Class.forName("com.example.jpa.repository.CoffeeRepository").getMethod("findById", Class.forName("java.lang.Object"));
//          m2 = Class.forName("java.lang.Object").getMethod("toString");
//          m6 = Class.forName("com.example.jpa.repository.CoffeeRepository").getMethod("saveAll", Class.forName("java.lang.Iterable"));
//          m36 = Class.forName("org.springframework.aop.framework.Advised").getMethod("getTargetClass");
//          m28 = Class.forName("org.springframework.aop.framework.Advised").getMethod("addAdvisor", Integer.TYPE, Class.forName("org.springframework.aop.Advisor"));
//          m37 = Class.forName("org.springframework.core.DecoratingProxy").getMethod("getDecoratedClass");
//          m30 = Class.forName("org.springframework.aop.framework.Advised").getMethod("removeAdvisor", Class.forName("org.springframework.aop.Advisor"));
//          m9 = Class.forName("com.example.jpa.repository.CoffeeRepository").getMethod("findAllById", Class.forName("java.lang.Iterable"));
//          m15 = Class.forName("org.springframework.aop.framework.Advised").getMethod("indexOf", Class.forName("org.aopalliance.aop.Advice"));
//          m16 = Class.forName("org.springframework.aop.framework.Advised").getMethod("isFrozen");
//          m31 = Class.forName("org.springframework.aop.framework.Advised").getMethod("replaceAdvisor", Class.forName("org.springframework.aop.Advisor"), Class.forName("org.springframework.aop.Advisor"));
//          m25 = Class.forName("org.springframework.aop.framework.Advised").getMethod("setPreFiltered", Boolean.TYPE);
//          m35 = Class.forName("org.springframework.aop.framework.Advised").getMethod("toProxyConfigString");
//          m22 = Class.forName("org.springframework.aop.framework.Advised").getMethod("getAdvisors");
//          m26 = Class.forName("org.springframework.aop.framework.Advised").getMethod("isPreFiltered");
//       } catch (NoSuchMethodException var2) {
//          throw new NoSuchMethodError(var2.getMessage());
//       } catch (ClassNotFoundException var3) {
//          throw new NoClassDefFoundError(var3.getMessage());
//       }
//    }
// }
