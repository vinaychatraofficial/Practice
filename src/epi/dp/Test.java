package epi.dp;

public class Test {

	public static void main(String[] args) {
		StringBuffer str=new StringBuffer();
		modifyStr(str);
		System.out.println("str:"+str);
	}
	
	static void modifyStr(StringBuffer str) {
		str.append("hi");
		System.out.println("str1:"+str);
	}

}
