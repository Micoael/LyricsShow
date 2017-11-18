package codes;

public class Test01 {
	
	
	static LyricShow ilk = new LyricShow();
	
	public static void main(String[] args) throws Exception{
		ilk.Load("D:/gameLog.txt", false);
	
		System.out.println(ilk.getReturns("D:/gamelog.txt", 0, false));
		
	}
}
