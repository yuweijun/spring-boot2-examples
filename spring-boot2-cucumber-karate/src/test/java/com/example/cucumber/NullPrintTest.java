package com.example.cucumber;

import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * @author Weijun Yu
 * @since 2020-02-13
 */
@RunWith(Cucumber.class)
@io.cucumber.junit.CucumberOptions(strict = true, tags = {"@nullprint"})
public class NullPrintTest {
}