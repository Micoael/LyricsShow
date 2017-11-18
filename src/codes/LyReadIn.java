package codes;
import java.io.*;
public class LyReadIn {
	/**
	 * 用 于检测指针的次数，方便后俩运算
	 * 
	 * @value  出事0 
	 */
	int pointer=0;
	static String[] lastlrcs;
	/**
	 * 
	 *得到源文件，算是一种初始化.如果加载，必须<b>
	 *先调用this method.</b>
	 * @param fileName 文件名
	 * @return 未经分割的数组
	 * @throws IOException IO异常
	 * @author zhangguangwei
	 */
	public String[] getSFile(String fileName) throws IOException{
		//查找可用性
		File file = new File(fileName);
		FileInputStream fis = new FileInputStream(file);
		FileInputStream fis2 = new FileInputStream(file);
		FileInputStream fis3 = new FileInputStream(file);
		BufferedReader br = new BufferedReader(new InputStreamReader(fis,"UTF-8"));
		BufferedReader br2 = new BufferedReader(new InputStreamReader(fis2,"UTF-8"));
		BufferedReader br3 = new BufferedReader(new InputStreamReader(fis3,"UTF-8"));
		
			System.out.println("[getSFile] >>> Successfully Found the File");
		//读取
			int linepointer=0;
			System.out.println("1");
			int lineind=0;
			System.out.println("2");
			while(br.readLine()!=null){
				
				linepointer++;
				
				
			}
			pointer=linepointer;
			String[] lineArr = new String[linepointer];
			
			//二次读取
			while(br2.readLine()!=null){
				
				lineind++;
				lineArr[lineind-1]=br3.readLine();
				
			}
			br.close();
			br2.close();
			br3.close();
			for (int i = 0; i < lineArr.length; i++) {
				System.out.println("[getSFile]"+i+"  --->  "+lineArr[i]);
			}
			System.err.println("[getSFile] >>> IMPORT--DONE");
			return lineArr;
			
			
	}
	/**
	 * 分离歌词数组，得到<b>歌词文件数组
	 * @param lineArr 歌词数组
	 * @return 歌词文件数组
	 * @throws IOException
	 * @author zhangguangwei
	 * @serialData 加油
	 */
	public String[] SpritLrc(String[] lineArr,boolean isSeparate) throws IOException{
		
		//String[] Time = new String[lineArr.length];
		//System.out.println("Times"+Time.length);
		String[] Lrcs = new String[lineArr.length];
		String pre = new String();
		String aft = new String();
		System.out.println("Lrcss"+Lrcs.length);
		for (int j = 0; j < lineArr.length; j++) {
			if(lineArr[j].length()<10){
				lineArr[j]="[00:00.00] Loading";
			}
			Lrcs[j]=lineArr[j].substring(10,lineArr[j].length());
			if(isSeparate&&Lrcs[j].length()>=29){
				pre=Lrcs[j].substring(0, Lrcs[j].length()/2);
				aft=Lrcs[j].substring(Lrcs[j].length()/2, Lrcs[j].length());
				if(aft.startsWith("^[a-z0-9A-Z]")){
					Lrcs[j]="<html>"+pre+"<br>"+"-"+aft+"</html>";
					System.out.println(Lrcs[j]);
				}else{
					Lrcs[j]="<html>"+pre+"<br>"+aft+"</html>";
				}
			}
		}
		for (int i = 0; i < Lrcs.length; i++) {
			System.out.println("LRC ->>> "+Lrcs[i]);
		}
		
		System.err.println("[SpirtiTime] >> SEPARATES---DONE");
		lastlrcs=Lrcs;
		return Lrcs;
	}
	/**
	 * 分离歌词数组，得到<b>歌词时间数组</b>
	 * @param lineArr
	 * @return 歌词文件的时间[秒]
	 */
	public int[] SplitTime(String[] lineArr){
		String[] mins = new String[lineArr.length+1];
		int[] min = new int[lineArr.length+1]; 
		String[] secs = new String[lineArr.length+1];
		int[] sec = new int[lineArr.length+1]; 
		int[] second = new int[lineArr.length+1]; 
		System.out.println("Times"+min.length);
		//String[] Lrcs = new String[lineArr.length];
		//System.out.println("Lrcss"+Lrcs.length);
		for (int j = 0; j < lineArr.length; j++) {
			if(lineArr[j].length()<10){
				lineArr[j]="[00:00.00] Loading...";
			}
			mins[j]=(lineArr[j].substring(1, 3));
			System.out.println("ORIGINAL"+">>>"+mins[j]);
			if(!mins[j].matches("[0-9]+.*")) {
				System.out.println("mins[j]".matches("[0-9]")+"(We are Changing this ...)，because it is "+mins[j]);
				mins[j]="00";
				System.out.println("CHANGED"+">>>"+mins[j]);
				min[j]=Integer.parseInt(mins[j]);
				System.out.println("This branch[change");
			}else {
				min[j]=Integer.parseInt(mins[j]);
				System.out.println("This branch[unchange");
			}
			
			secs[j]=lineArr[j].substring(4, 6);
			if(!secs[j].matches("[0-9]+.*"))
				secs[j]="0";
			sec[j]=Integer.parseInt(secs[j]);
			second[j]=min[j]*60+sec[j];
		}
		
		for (int i = 0; i < min.length; i++) {
			System.out.println("TIM ->>> "+second[i]);
		}
		System.out.println("[SpritTime] >> SEPARATET---DONE");
		return second;
		
	}
	
	public String[] lrcsOut(String file) throws IOException{
		return lastlrcs;
		//return SpritLrc(getSFile(file),false);
	}
	
	
	
	
	/**
	 * 分离歌词数组，得到歌词的时间数组
	 * @param lineArr
	 * @return
	 * @throws IOException
	 */
	public String[] SpritTime(String[] lineArr) throws IOException{
		
		String[] Time = new String[lineArr.length];
		System.out.println("Times"+Time.length);
		//String[] Lrcs = new String[lineArr.length];
		//System.out.println("Lrcss"+Lrcs.length);
		for (int j = 0; j < lineArr.length; j++) {
			
			
			Time[j]=lineArr[j].substring(0, 6);
		}
		
		for (int i = 0; i < Time.length; i++) {
			System.out.println("TIM ->>> "+Time[i]);
		}
		System.out.println("[SpritTime] >> SEPARATET---DONE");
		return Time;
	}
	/**
	 * 废了，没啥用，扔了算了<br>
	 * <b>仅供开发人员使用</b><br>
	 * 哈哈哈哈哈哈哈哈哈哈<br><br><br><br><br><br><br>
	 * @param FileName
	 */
	public void Together(String FileName) {
		
		try {
			String a[]=SpritLrc(getSFile(FileName), false);
			String b[]=SpritTime(getSFile(FileName));
			for (int i = 0; i < a.length; i++) {
				System.out.println("[LyReading Together] >> Time  =>  "+a[i]);
				System.out.println("[LyReading Together] >> Lyrics  =>  "+b[i]);
			}
			
		} catch (IOException e) {
			System.err.println("超出！");
		}
	}
	/**
	 * 调用SPLITLRC
	 * @see SpritLrc
	 * @param FileName
	 * @param LrcArray
	 * @return
	 */
	public String[] lrc(String FileName,String[] LrcArray,boolean isMove){
		try {
			LrcArray=SpritLrc(getSFile(FileName),isMove);
			//TimeArray=SpritTime(getSFile(FileName));
		} catch (IOException e) {
			System.err.println("at LYreadin likexxx occoured error!!!");
			e.printStackTrace();
		}
		return LrcArray;
		
		
	}
	/**
	 * 调用ST
	 * @see SpritTime
	 * @param FileName
	 * @param TimeArray
	 * @return
	 */
	public int[] time(String FileName,int[] TimeArray){
		try {
			//LrcArray=SpritLrc(getSFile(FileName));
			TimeArray=SplitTime(getSFile(FileName));
		} catch (IOException e) {
			System.err.println("at LYreadin likexxx occoured error!!!");
		}
		return TimeArray;
		
		
	}
	/**
	 * 得到要创建的数组长度
	 * 
	 * @param fileName
	 * @return 数组长度int
	 * @throws IOException
	 */
	public int getLength(String fileName) throws IOException{
		getSFile(fileName);
		return pointer;
	}
	
	
}
