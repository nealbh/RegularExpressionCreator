import java.util.Scanner;
import java.util.HashMap;
import java.io.*;
class Regex{
	public static void howOftenMenu(){
		// matching taken from http://www.eclipse.org/tptp/home/downloads/installguide/gla_42/ref/rregexp.html
		// http://www.rexegg.com/regex-quickstart.html
		System.out.println("Often Menu");
		System.out.println("1) at least n but not more than m times -- defining m and n later");
		System.out.println("2) at least n but no more than m time -- n and m defined later");
		System.out.println("3) at least n times -- defining n later");
		System.out.println("4) exactly n times -- defining n later");
		System.out.println("5) 0 or more times");
		System.out.println("6) 1 or more times");
		System.out.println("7) 0 or 1 times");
	}

	public static void populateHowOften(HashMap often){
		often.put(1, "{n.m}");
		often.put(2, "{n,m}?");
		often.put(3, "{n,}");
		often.put(4,"{n}");
		often.put(5, "*");
		often.put(6, "+");
		often.put(7,"?");
	}

	public static void whatTypeMenu(){
		System.out.println("Type Menu");
		System.out.println("1) everything except \\n in a regular expression within parentheses");
		System.out.println("2) a null token matching the beginning of a string or line");
		System.out.println("3) a null token matching the end of a string or line");
		System.out.println("4) backspace inside a character class");	
		System.out.println("5) null token matching a word boundary (\\w on one side and \\W on the other)");
		System.out.println("6) null token matching a boundary that isn't a word boundary");
		System.out.println("7) only at beginning of string");
		System.out.println("8) only at end of string (or before newline at the end) ");
		System.out.println("9) newline");
		System.out.println("10) carriage return");
		System.out.println("11) tab");
		System.out.println("12) form feed");
		System.out.println("13) digit[0-9]");
		System.out.println("14) non-digit[^0-9]");
		System.out.println("15) word character [0-9a-z_A-Z]");
		System.out.println("16) non-word character [^0-9a-z_A-Z]");
		System.out.println("17) a whitespace character [\\t\\n\\r\\f]");
		System.out.println("18) a non-whitespace character [^\\t\\n\\r\\f]");
		System.out.println("19) the corresponding control character");
		System.out.println("20) the null character. Any other backslashed character matches itself");
		System.out.println("21) standard letters or numbers that you can type in later");
	}

	public static void populateWhatType(HashMap type){
		type.put(1,".");
		type.put(2,"^");
		type.put(3, "$");
		type.put(4, "\\b");
		type.put(5, "\\b");
		type.put(6, "\\B");
		type.put(7,"\\A");
		type.put(8, "\\Z");
		type.put(9, "\\");
		type.put(10, "\\r");
		type.put(11, "\\t");
		type.put(12, "\\f");
		type.put(13,"\\d");
		type.put(14, "\\D");
		type.put(15, "\\w");
		type.put(16, "\\W");
		type.put(17, "\\s");
		type.put(18, "\\S");
		type.put(19, "\\cD");
		type.put(20, "\\0");
	}
	
	public static int askFor(String var, int lowerBound, int upperBound, Scanner sc){
		int input;
		do{
			System.out.println( var + " : ");
			input = sc.nextInt();
		} while (input <= lowerBound || input >= upperBound);	
		return input;	
	}

	public static void main(String [] args){
		// create and initialize input varaible, as well as input and output 
		Scanner sc = new Scanner(System.in);
		String output = "/";
		String piece = "";
		int input,n,m;
		HashMap<Integer, String> often = new HashMap<Integer,String>();
		HashMap<Integer, String> type = new HashMap<Integer,String>();
		populateHowOften(often);
		populateWhatType(type);
		
		// looping through, the number of times this loop is executed coorelates to the length of the regular expressions
		while(true){
			whatTypeMenu();
			input = askFor("Please enter a positive number less than 22 or enter zero to quit and end the regular expression ", -1, 22, sc);
			// RegEx is complete
			if(input == 0) break;
			if(input != 21) piece = type.get(input);
			else {
				String verify = "a";
				while (!verify.equals("Y")){
					System.out.println("Please type the string sequence you would like to see next : ");
					// necessary to take string input from the command line
					InputStreamReader in = new InputStreamReader(System.in);
					BufferedReader reader = new BufferedReader(in);
					try{
						piece = reader.readLine();
					} 
					catch(Exception e){}
					System.out.println("You typed: " + piece);
					System.out.println("Is this what you wanted? Answer Y (must be capital) for yes and anything else for no");
					try{
						verify = reader.readLine();
					} catch (Exception e){}
				}
			}
			output += piece;
			
			howOftenMenu();
			input = askFor("Please enter a non-negative number for how often you want to see " + piece, -1, Integer.MAX_VALUE, sc);
			if(input <= 4 && input != 0){
				String app = often.get(input);
				// ask for n
				n = askFor("Please enter a non-negative number for the lower bound n : ", -1, Integer.MAX_VALUE, sc);
				app = app.replaceAll("n", Integer.toString(n));
				if (input <= 2 && input != 0){
					// ask for m
					m = askFor("Please enter a number large than n as the upper bound m : ", n, Integer.MAX_VALUE, sc);
					app = app.replaceAll("m", Integer.toString(m));
				}
				// concatenate the piece 
				output += app;
			} else if (input != 0) {
				output += often.get(input);
			} 
			System.out.println("The current Regex is : " + output);
		}
		// print the output at the end	
		System.out.println("The final Regex is : " + output + "/");
		
	}
}