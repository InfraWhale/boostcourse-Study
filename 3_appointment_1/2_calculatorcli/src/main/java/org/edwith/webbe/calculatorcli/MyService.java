package org.edwith.webbe.calculatorcli;

import org.springframework.stereotype.Service;

@Service
public class MyService {
  private final CalculatorService2 calculatorService2;

  public MyService(CalculatorService2 calculatorService2) {
    this.calculatorService2 = calculatorService2;
  }

  public int execute(int value1, int value2){
    return calculatorService2.plus(value1, value2) * 2;
  }
}
