// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
	    // Tests some of the operations
	    System.out.println(plus(2,3));   // 2 + 3
	    System.out.println(minus(7,2));  // 7 - 2
   		System.out.println(minus(2,7));  // 2 - 7
 		System.out.println(times(3,4));  // 3 * 4
   		System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
   		System.out.println(pow(5,3));      // 5^3
   		System.out.println(pow(3,5));      // 3^5
   		System.out.println(div(12,3));   // 12 / 3    
   		System.out.println(div(5,5));    // 5 / 5  
		   System.out.println(div(-20,-5));
   		System.out.println(div(25,7));   // 25 / 7
   		System.out.println(mod(25,7));   // 25 % 7
   		System.out.println(mod(120,6));  // 120 % 6    
   		System.out.println(sqrt(36));
		System.out.println(sqrt(263169));
   		System.out.println(sqrt(76123));
	}  

	// Returns x1 + x2
	public static int plus(int x1, int x2) {
		int num = x1;
		if (x2 > 0){
			for (int i = 0; i < x2; i++)
		{
			num++;
		}
		}
		if (x2 < 0) { 
			for (int i = 0; i > x2; i--)
		{
			num--;
		}
		}
		return (num);
	}

	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		int num = x1;
		if (x2 > 0){
			for (int i = 0; i < x2; i++)
			{
				num--;
			}
			}
		if (x2 < 0) {
			for (int i = 0; i > x2; i--)
			{
				num++;
			}
		    }
		return (num);
	}

	// Returns x1 * x2
	public static int times(int x1, int x2) {
		int sum = 0;
		if (x1 == 0 || x2 == 0){
			return 0;
		}
		if (x1 > 0 ){
			if (x2 > 0){
				for (int i = 0; i < x2; i++)
				{
				sum = plus(sum, x1);
				}
			}
			if (x2 < 0){
				for (int i = x2; i < 0; i++)
				{
					sum = minus(sum, x1);
				}
			}
		}
		if (x1 < 0){
			if (x2 < 0){
				for (int i = x2; i < 0; i++)
				{
					sum = minus(sum, x1);
				}
			}
			if (x2 > 0){
				for (int i = 0; i < x2; i++)
				{
					sum = plus(sum, x1);
				}
			}
		}	
		return sum;
	}

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		int num = 1;
		for (int i = 0; i < n; i++)
		{
			num = times(num, x);
		}
		return num;
	}

	// Returns the integer part of x1 / x2 
	public static int div(int x1, int x2) {
		int num = x1;
		int count = 0;
		if (x1 > 0){
			if (x2 > 0){
				while (minus(num, x2) >= 0)
				{
					num = minus(num, x2);
					count++;
				}
			}
			if (x2 < 0){
				while (plus(num, x2) >= 0)
				{
					num = plus(num, x2);
					count--;
				}
			}
		}
		if (x1 < 0){
			if (x2 > 0){
				while (plus(num, x2) <= 0)
				{
					num = plus(num, x2);
					count--;
				}
			}
			if (x2 < 0){
				while (minus(num, x2) <= 0)
				{
					num = minus(num, x2);
					count++;
				}
			}
		}
		return count;
	}

	// Returns x1 % x2
	public static int mod(int x1, int x2) {
		int a = div(x1, x2);
		int b = times(a, x2);

		return (minus(x1, b));
	}	

	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x) {
		int i = 1;
		while (minus(x, pow(i, 2)) > i){
			i++;
		}
		if (pow(i, 2) == x){
		return i;
		}
		else {
			return (i - 1);
		}
}  	  
}