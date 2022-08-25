package org.edwith.webbe.calculatorcli; // 테스트에 스프링 사용

import org.springframework.stereotype.Component;

@Component
public class CalculatorService2 {
  public int plus(int value1, int value2) {
    return value1 + value2;
  }

  public int minus(int value1, int value2) {
    return value1 - value2;
  }

  public int multiple(int value1, int value2) {
    return value1 * value2;
  }

  public int divide(int value1, int value2) throws ArithmeticException {
    return value1 / value2;
  }
}
