public class InstanceofDemo
{
  public static void main(String args[])
  {
    A a = new A();
    B b = new B();
    C c = new C();
 
    System.out.println("b.getClass().isInstance(c): " + b.getClass().isInstance(c).isInstance(c)); //false
  }
}
 