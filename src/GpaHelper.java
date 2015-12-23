

/**	This utility class facilitates conversion from metric units to
 *	imperial units.
 */
public class GpaHelper
{
	/** Represents the number of centimetres in an inch. */
	public static final int GradePoint_A1 = 9;
	public static final int GradePoint_A = 8;
	public static final int GradePoint_B1 = 7;
	public static final int GradePoint_B = 6;
	public static final int GradePoint_C1 = 5;
	public static final int GradePoint_C = 4;
	public static final int GradePoint_D1 = 3;
	public static final int GradePoint_D = 2;
	public static final int GradePoint_E = 1;
	public static final int GradePoint_F = 0;
	public static final int CreditChoice_1 = 3;
	public static final int CreditChoice_2 = 6;
	public static final int CreditChoice_3 = 9;
	public static final int CreditChoice_4 = 4;
	public static final int a = 0;
	public static final int b = 1;
	
	// Include additional constants here as needed.
	// Use the one above as a guide.
	;
	
	
	// This line prevents clients from instantiating the class.
	public GpaHelper() {}
	
	protected static int getGPA(String s)
	{
		if(s.equalsIgnoreCase("A+"))
			return 9;
		else if(s.equalsIgnoreCase("A"))
			return 8;
		else if(s.equalsIgnoreCase("B+"))
			return 7;
		else if(s.equalsIgnoreCase("B"))
			return 6;
		else if(s.equalsIgnoreCase("C+"))
			return 5;
		else if(s.equalsIgnoreCase("C"))
			return 4;
		else if(s.equalsIgnoreCase("D+"))
			return 3;
		else if(s.equalsIgnoreCase("D"))
			return 2;
		else if(s.equalsIgnoreCase("E"))
			return 1;
		else
			return 0;
		
		
	}
	
}