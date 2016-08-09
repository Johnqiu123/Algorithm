package com.neu.String.subStringSearch;

/**
 * 
 * KMP的基本思路：
 * 当出现不匹配时，就能知晓一部分文本的内容，我们可以利用这些信息
 * 避免将指针回退到所有这些已知的字符之前
 * 
 * 算法分成两个部分：
 * 1. 生成dfa[][]数组，记录匹配失败时模式指针j应该回退到多远
 *      生成流程：
 *      1)  将dfa[][X]复制到dfa[][j](对应匹配失败的情况)；
 *      2) 将dfa[pat.charAt(j)][j]设为j+1(对应匹配成功的情况);
 *      3) 更新X
 *      
 * 2. 搜索，根据dfa数组，进行状态转换搜索
 * @author Johnqiu
 *
 */
public class KMP {

    private String pat;  //模式
    private int[][] dfa;  // 有限状态转换机数组
    
    public KMP(String pat){
	     // 由模式字符串构造DFA
	     this.pat = pat;
	     int M = pat.length();  // 获取长度
	     int R = 256;  // EXTENDED_ASCII 字母表的长度
	     dfa = new int[R][M];
	     System.out.println((int)pat.charAt(0));
	     dfa[pat.charAt(0)][0] = 1;  // 模式初始位置设为1, 获取字母表对应的值
	     
	     // 计算dfa数组
	     for(int X= 0, j=1; j < M; j++ ){
	    	    for (int c=0; c < R; c++){
	    	    	dfa[c][j] = dfa[c][X];    // 复制匹配失败情况下的值
	    	    }
	    	    dfa[pat.charAt(j)][j] = j + 1;  // 设置匹配成功情况下的值
	    	    X = dfa[pat.charAt(j)][X];  // 更新重启状态
	     }     
    }
    
    /**
     *  搜索匹配的子字符串
     * @param txt
     * @return
     */
    public int search(String txt){
	      // 在txt上模拟DFA的运行
	   int i,j,N = txt.length();
	   int M = pat.length();
	   
	   // 文本指针不回退，模式指针回退
	   for (i = 0, j =0; i < N && j<M; i++){
		   j = dfa[txt.charAt(i)][j];    // 获取跳转状态值
	   }
	   if(j == M){
		   return i-M;  // 找到匹配（到这模式字符串的结尾）
	   }else
		   return N;    // 未找到匹配 （到这文本字符串的结尾）
    }
    
    public static void main(String[] args) {
    	String pat = args[0];
	    String txt = args[1];
	    KMP kmp = new KMP(pat);
	    System.out.println("text:          " + txt);
	    int offset = kmp.search(txt);
	    System.out.println("pattern:      "+ pat);
	    for(int i=0; i < offset; i++){
		  System.out.print(".");
	    }
	    System.out.println(pat);
	}
	            
}
