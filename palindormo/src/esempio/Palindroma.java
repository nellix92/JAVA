package esempio;

public class Palindroma {

	public static void main(String[] args) {

		String input = "radar";
		boolean isPalindromo = checkPalindromo (input);
		System.out.println(input + "è palindromo" + isPalindromo);
		
		
	}
	
	
	public static boolean checkPalindromo (String s) {
		
		String rev = new StringBuilder (s).reverse().toString();
		return s.equals(rev);
	}

}
