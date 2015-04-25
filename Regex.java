import java.util.Scanner;
class Regex{
	public static void menu(){
		// matching taken from http://www.eclipse.org/tptp/home/downloads/installguide/gla_42/ref/rregexp.html
		System.out.println("Enter a number for what you are looking for:");
		System.out.println("1)  at least n but not more than m times -- defining m and n later");
		System.out.println("2)  at least n times -- defining n later");
		System.out.println("3)  exactly n times -- defining n later");
		System.out.println("4)  0 or more times");
		System.out.println("5)  1 or more times");
		System.out.println("6)  0 or 1 times");
		System.out.println("7)  everything except \\n in a regular expression within parentheses");
		System.out.println("8)  a null token matching the beginning of a string or line (i.e., the position right after a newline or right before the beginning of a string) in a regular expression within parentheses");
		System.out.println("9)  a null token matching the end of a string or line (that is, the position right before a newline or right after the end of a string) in a regular expression within parentheses");
		System.out.println("10) backspace inside a character class ([abcd])");
		System.out.println("11) null token matching a word boundary (\\w on one side and \\W on the other)");
		System.out.println("12) null token matching a boundary that isn't a word boundary");
		System.out.println("13) only at beginning of string");
		System.out.println("14) only at end of string (or before newline at the end) ");
		System.out.println("15) newline");
		System.out.println("16) carriage return");
		System.out.println("17) tab");
		System.out.println("18) form feed");
		System.out.println("19) digit[0-9]");
		System.out.println("20) non-digit[^0-9]");
		System.out.println("21) word character [0-9a-z_A-Z]");
		System.out.println("22) non-word character [^0-9a-z_A-Z]");
		System.out.println("23) a whitespace character [\\t\\n\\r\\f]");
		System.out.println("24) a non-whitespace character [^\\t\\n\\r\\f]");
		System.out.println("25) the hexadecimal representation of character nn -- nn defined later");
		System.out.println("26) the corresponding control character");
		System.out.println("27) the octal representation of character nn unless a backreference");
		System.out.println("28) the null character. Any other backslashed character matches itself");
		System.out.println("29) 0 or more times");
		System.out.println("30) 1 or more times");
		System.out.println("31) 0 or 1 times");
		System.out.println("32) exactly n times -- n defined later");
		System.out.println("33) at least n times -- n defined later");
	}

	public static void main(String [] args){
		// create and initialize input varaible, as well as input and output 
		Scanner sc = new Scanner(System.in);
		String output = "";
		int input;
		
		// looping through, the number of times this loop is executed coorelates to the length of the regular expressions
		while(true){
			menu();
			do{
				System.out.println("Please enter a positive number : ");
				input = sc.nextInt();
			} while(input < 0);
			if(input == 0) break;
			output += Integer.toString(input);
		}	
		System.out.println(output);
		
	}
}