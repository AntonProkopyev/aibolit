class Test
{
    public static void main(String[] args)
    {
        Child cobj = new Child();
        // A simple case
        if (cobj instanceof String)
           System.out.println("cobj is instance of Child");
    }
}