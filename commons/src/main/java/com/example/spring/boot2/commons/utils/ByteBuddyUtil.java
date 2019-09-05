package com.example.spring.boot2.commons.utils;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.agent.ByteBuddyAgent;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.dynamic.ClassFileLocator;
import net.bytebuddy.dynamic.DynamicType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Map;

/**
 * @author Weijun Yu
 * @since 2019-09-05.
 */
public class ByteBuddyUtil {

  private static final Logger LOGGER = LoggerFactory.getLogger(ByteBuddyUtil.class);

  public static void saveGeneratedClass(Class<?> clazz) {
    try {
      ByteBuddyAgent.install();
      ClassFileLocator classFileLocator = ClassFileLocator.AgentBased.fromInstalledAgent(clazz.getClassLoader());
      DynamicType.Unloaded<?> unloaded = new ByteBuddy().redefine(clazz, classFileLocator).make();
      Map<TypeDescription, File> saved = unloaded.saveIn(Files.createTempDirectory("bytebuddy").toFile());
      saved.forEach((t, u) -> LOGGER.info(u.getAbsolutePath()));
    } catch (IOException e) {
      LOGGER.error("save clazz failure : {}", clazz.getCanonicalName(), e);
    }
  }

}
