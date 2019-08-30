package com.example.jpa;

import com.example.jpa.model.User;
import net.bytebuddy.ByteBuddy;
import net.bytebuddy.agent.ByteBuddyAgent;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.dynamic.ClassFileLocator;
import net.bytebuddy.dynamic.DynamicType;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.util.Map;

/**
 * @author Weijun Yu
 * @since 2019-08-30.
 */
public class GeneratedMethodAccessorTest {

  public static void main(String[] args) throws Exception {
    User user = new User();
    user.setId(1);

    Method method = User.class.getDeclaredMethod("getId");
    method.setAccessible(true);

    for (int i = 0; i < 20; i++) {
      method.invoke(user);
    }

    Field field = Method.class.getDeclaredField("methodAccessor");
    field.setAccessible(true);
    Object methodAccessor = field.get(method);
    Field delegate = methodAccessor.getClass().getDeclaredField("delegate");
    delegate.setAccessible(true);
    Object gma = delegate.get(methodAccessor);

    ByteBuddyAgent.install();
    try {
      ClassFileLocator classFileLocator = ClassFileLocator.AgentBased
          .fromInstalledAgent(gma.getClass().getClassLoader());
      DynamicType.Unloaded<? extends Object> unloaded = new ByteBuddy().redefine(
          gma.getClass(), classFileLocator).make();
      Map<TypeDescription, File> saved = unloaded.saveIn(Files.createTempDirectory("proxy").toFile());
      saved.forEach((t, u) -> System.out.println(u.getAbsolutePath()));
    } catch (IOException e) {
      throw new RuntimeException("Failed to save class to file");
    }
  }

}
