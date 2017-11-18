package codes;

public class LyricShow {
	LyReadIn l = new LyReadIn();
	currentMills c = new currentMills();
	String a[];
	int[] b;
	/**
	 * Load loads the base thing of the program.
	 * <br>
	 * YOu need to use these codes first.<br><br><br>
	 * <code>
	 * .load(FILENAME)
	 * </code>
	 * @param fileName
	 * @throws Exception
	 */
	public void Load(String fileName,boolean isMove) throws Exception{
		
		//String a[]=new String[l.getLength(fileName)];
		//String b[]=new String[l.getLength(fileName)];
		a=l.lrc(fileName, a,isMove);
		b=l.time(fileName, b);
		
		
	}
	public String getReturns(String fileName,int moveNum,boolean isMove) throws Exception{
				String str ;
				str=c.compare(c.timeContinue(),b,a,moveNum);
				System.out.println("playing");
				return str;
			
		
	
	}
	
	}
	 

