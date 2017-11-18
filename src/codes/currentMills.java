package codes;

public class currentMills  {
	boolean isPau=false;
	int lastak=0;
	static int m=0,s=0,ms=0;
	static int lrcnum=0;
	/**
	 * reset方法：重置<head><body>当前时间（归0）</body>
	 * @return 无返回值
	 * 
	 */
	public void reset(){
		
		m=0;
		s=0;
		ms=0;
	}
	/**
	 * 暂停、播放
	 */
	public void pause(){
		if(isPau){
			isPau=false;
		}else{
			isPau=true;
		}
	}
	/**
	 * forward快进
	 * @param fwdOn 
	 * 快进值（s数）
	 */
	public void forward(int fwdOn){
		s=s+fwdOn;
	}
	/**
	 * 设置时间
	 * @param m
	 * @param s
	 * @param ms
	 */
	public void setTime(int min,int sec,int msec){
		m=min;
		s=sec;
		ms=msec;
	}
	/**
	 * 快退
	 * @param bwdOn 
	 * 快退值（s数）
	 */
	
	public void backward(int bwdOn){
		s=s-bwdOn;
	}
	/**
	 * timeContinue方法：判断是否暂停，如果是，不继续
	 * 否则，毫秒数+1
	 * @return 返回 String，为下文compare打基础
	 * 
	 */
	public int timeContinue() throws Exception{
		if(!isPau){
		s++;
		Thread.sleep(1000);
		System.out.println(ms+"ms"+s+"s"+m+"m");
		}
		if(s>=60){
			s=0;
			m++;
			
		}
		/*String finm=m;
		String fins=s;
		if(s<10){
			fins="0"+s;
		}
		if(m<10){
			finm="0"+m;
		}*/
		//System.out.println("["+finm+":"+fins);
		return m*60+s;
		
		
	}
	/**
	 * 比较歌词时间于currT是否相同.
	 * @param i 当前时间.
	 * @param Lrctime 歌词时间.
	 * @param lineArr 歌词的String数组.
	 * @return 歌词的string.
	 */
	public String compare(int i,int[] Lrctime,String[] lineArr,int moveNum){
		int x=0;
		int times=0;
		for (int ak = 0; ak < Lrctime.length; ak++) {
			if(ak-1<0){
				ak=1;
			}
			if(Lrctime[ak-1]<i&&Lrctime[ak]>=i){
				x=ak;
			}
		}
			/*if(i==Lrctime[ak]){
				x=ak+moveNum;
				lastak=x+moveNum;
				/*if(ak+moveNum<0){
					x=0;
					lastak=0;
				}else if(ak+moveNum>Lrctime.length){
					x=Lrctime.length;
					lastak=Lrctime.length;
				}
			}else{
				//x=(Integer) null;
				x=lastak+moveNum;
			}
			
		}
		if(x<0){
			x=0;
		}else if(x>Lrctime.length){
			x=Lrctime.length;
		}*/
		lrcnum=x-1;
		return lineArr[x-1];
	}
	public int getMins(){
		System.out.println(m+""+s);
		return m;
	}
	public int getsecs(){
		return s;
	}
	
	public int getlrcNum(){
		return lrcnum;
	}
}
