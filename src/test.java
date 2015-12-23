import java.util.Scanner;

public class test 
{
	public static void main(String[] args)
	{
		String regex = "^[A-Z|a-z]+[ ][\\d]+[ ][A-Z][+]*$";
		
		String s = new Scanner(System.in).nextLine();
		System.out.println(s.matches(regex));
		//System.out.println((int) (char) (byte) -1);
	}
}