import java.util.Scanner;
import java.util.HashMap;
class Regex{
	public static void menu(){
		// matching taken from http://www.eclipse.org/tptp/home/downloads/installguide/gla_42/ref/rregexp.html
		System.out.println("Enter a number for what you are looking for:");
		System.out.println("1) at least n but not more than m times -- defining m and n later");
     	System.out.println("2) at least n but no more than m time -- n and m defined later");
		System.out.println("3) at least n times -- defining n later");
		System.out.println("4) exactly n times -- defining n later");
		System.out.println("5) exactly n times -- n defined later");
		System.out.println("6) at least n times -- n defined later");
		System.out.println("7) 0 or more times");
		System.out.println("8) 1 or more times");
		System.out.println("9) 0 or 1 times");
		System.out.println("10) everything except \\n in a regular expression within parentheses");
		System.out.println("11) a null token matching the beginning of a string or line (i.e., the position right after a newline or right before the beginning of a string) in a regular expression within parentheses");
		System.out.println("12) a null token matching the end of a string or line (that is, the position right before a newline or right after the end of a string) in a regular expression within parentheses");
		System.out.println("13) backspace inside a character class ([abcd])");	
		System.out.println("14) null token matching a word boundary (\\w on one side and \\W on the other)");
		System.out.println("15) null token matching a boundary that isn't a word boundary");
		System.out.println("16) only at beginning of string");
		System.out.println("17) only at end of string (or before newline at the end) ");
		System.out.println("18) newline");
		System.out.println("19) carriage return");
		System.out.println("20) tab");
		System.out.println("21) form feed");
		System.out.println("22) digit[0-9]");
		System.out.println("23) non-digit[^0-9]");
		System.out.println("24) word character [0-9a-z_A-Z]");
		System.out.println("25) non-word character [^0-9a-z_A-Z]");
		System.out.println("26) a whitespace character [\\t\\n\\r\\f]");
		System.out.println("27) a non-whitespace character [^\\t\\n\\r\\f]");
		System.out.println("28) the hexadecimal representation of character nn -- nn defined later");
		System.out.println("29) the corresponding control character");
		System.out.println("30) the octal representation of character nn unless a backreference");//expr.put(27, "");
		System.out.println("31) the null character. Any other backslashed character matches itself");
		System.out.println("32) 0 or more times");
		System.out.println("33) 1 or more times");
		System.out.println("34) 0 or 1 times");

	}

	public static void populateHash(HashMap expr){
		expr.put(1, "{n.m}");
		expr.put(2, "{n,m}?");
		expr.put(3, "{n,}");
		expr.put(4,"{n}");
		expr.put(5, "{n}?");
		expr.put(6, "{n,}?");
		expr.put(7, "*");
		expr.put(8, "+");
		expr.put(9,"?");
		expr.put(10,".");
		expr.put(11,"^");
		expr.put(12, "$");
		expr.put(13, "\\b");
		expr.put(14, "\\b");
		expr.put(15, "\\B");
		expr.put(16,"\\A");
		expr.put(17, "\\Z");
		expr.put(18, "\\");
		expr.put(19, "\\r");
		expr.put(20, "\\t");
		expr.put(21, "\\f");
		expr.put(22,"\\d");
		expr.put(23, "\\D");
		expr.put(24, "\\w");
		expr.put(25, "\\W");
		expr.put(26, "\\s");
		expr.put(27, "\\S");
		expr.put(29, "\\cD");
		expr.put(31, "\\0");
		expr.put(32, "*?");
		expr.put(33, "+?");
		expr.put(34, "??");
	}
	
	public static void main(String [] args){
		// create and initialize input varaible, as well as input and output 
		Scanner sc = new Scanner(System.in);
		String output = "";
		int input,n,m;
		HashMap<Integer, String> expr = new HashMap<Integer,String>();
		populateHash(expr);
		
		// looping through, the number of times this loop is executed coorelates to the length of the regular expressions
		while(true){
			menu();
			do{
				System.out.println("Please enter a positive number or enter zero to quit : ");
				input = sc.nextInt();
			} while(input < 0);
			if(input == 0) break;
			if(input <= 6){
				String app = expr.get(input);
				// ask for n
				do{
					System.out.println("Please enter a non-negative number for n : ");
					n = sc.nextInt();
				} while (n < 0);
				app = app.replaceAll("n", Integer.toString(n));
				System.out.println(app);
				System.out.println(n);
				if (input <= 2){
					// ask for m
					do {
						m = sc.nextInt();
					} while(m <= n);
					app = app.replaceAll("m", Integer.toString(m));
				}
				// concatenate the piece 
				output += app;
			} else {
				output += expr.get(input);
			}
			System.out.println("The current Regex is : " + output);
		}
		// print the output at the end	
		System.out.println(output);
		
	}
}