package kr.or.connect.diexam01;

public class UserBean {
  /*
   * 1) 기본 생성자 가지고 있다. 
   * 2) 필드는 private하게 선언 
   * 3) getter, setter 메소드를 가진다. getName() setName() 메소드를 name 프로퍼티(property)라고 한다. 
   */

  // 규칙 있는 이유 : 내가 직접 만드는게 아니라 맏길거니깐

  private String name;
  private int age;
  private boolean male;

  public UserBean() {}
  public UserBean(String name, int age, boolean male) {
    this.name = name;
    this.age = age;
    this.male = male; 
  }

  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public int getAge() {
    return age;
  }
  public void setAge(int age) {
    this.age = age;
  }
  public boolean isMale() {
    return male;
  }
  public void setMale(boolean male) {
    this.male = male;
  }


}
