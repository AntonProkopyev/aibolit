class Temp extends Base
{ 

    private int i;

    Temp(int x)
    {
		this.i = null ;
    }
 
    // constructor with one arguemnt. 
    Temp(int x, int y) 
    { 
        super(x);
		this(y);
    } 
    Temp(double x)
    {
        super(x);
		this.i = x;
    }
    public static void main(String[] args) 
    { 
        // Object creation by calling no-argument  
        // constructor. 
        new Temp(5,6);
    } 
} 