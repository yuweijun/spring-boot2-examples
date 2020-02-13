package com.example.cucumber;

import io.cucumber.java.zh_cn.假如;
import io.cucumber.java.zh_cn.当;
import io.cucumber.java.zh_cn.那么;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Weijun Yu
 * @since 2020-02-13
 */
public class BankSteps {

  private static final Logger LOGGER = LoggerFactory.getLogger(BankSteps.class);

  private double balance;

  private double withdraw;

  @假如("我的账户中有余额\"{double}\"元")
  public void 我的账户中有余额(double balance) {
    this.balance = balance;
  }

  @当("我选择固定金额取款方式取出\"{double}\"元")
  public void 我选择固定金额取款方式取出(double withdraw) {
    LOGGER.info("withdraw : {}", withdraw);
    this.withdraw = withdraw;
  }

  @那么("我应该收到现金\"{double}\"元")
  public void 我应该收到现金(double withdraw) {
    LOGGER.info("actual withdraw : {}, withdraw : {}", this.withdraw, withdraw);
    Assert.assertEquals(this.withdraw, withdraw, 0d);
  }

  @那么("我账户的余额应该是\"{double}\"元")
  public void 我账户的余额应该是(double balance) {
    LOGGER.info("balance : {} - {} = {}", this.balance, balance, withdraw);
    Assert.assertEquals(this.balance, balance, withdraw);
  }

}
