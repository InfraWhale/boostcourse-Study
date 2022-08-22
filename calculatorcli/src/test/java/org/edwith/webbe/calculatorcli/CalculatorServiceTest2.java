package org.edwith.webbe.calculatorcli;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ApplicationConfig.class})
public class CalculatorServiceTest2 {
  @Autowired
  CalculatorService2 calculatorService2;

  @Test
  public void plus() throws Exception{
    // given
    int value1 = 10;
    int value2 = 5;

    // when
    int result = calculatorService2.plus(value1, value2);

    // then
    Assert.assertEquals(15, result); // 결과와 15가 같을 경우에만 성공
  }

  @Test
  public void divide() throws Exception{
    // given
    int value1 = 10;
    int value2 = 5;

    // when
    int result = calculatorService2.divide(value1, value2);

    // then
    Assert.assertEquals(2,result); // 결과와 2가 같을 경우에만 성공
    //Assert.assertEquals(3,result); // 결과와 3이 같을 경우에만 성공
  }

  @Test
  public void divideExceptionTest() throws Exception{
    // given
    int value1 = 10;
    int value2 = 0;

    try {
      calculatorService2.divide(value1, value2);
    }catch (ArithmeticException ae){
      Assert.assertTrue(true); // 이부분이 실행되었다면 성공
      return; // 메소드를 더이상 실행하지 않는다.
    }
    Assert.fail(); // 이부분이 실행되면 무조건 실패다.

  }
}
