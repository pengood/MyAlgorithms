package pzhao.com;

class Violent{
	public static int search(String s,String p){
		int N=s.length();
		int M=p.length();
		int i,j;
		for(i=0,j=0;i<N&&j<M;){
			if(s.charAt(i)==p.charAt(j)){i++;j++;}
			else{i=i-j+1;j=0;}
		}
		if(j==M) return i-j;
		return -1;
	}
}



public class KMP {
	
	public static int[] getNext(String p){
		int n=p.length();
		int[] next=new int[n];
		next[0]=-1;
		int k=-1;
		int j=0;
		while(j<n-1){
			if(k==-1||p.charAt(j)==p.charAt(k)){
				k++;j++;
				next[j]=k;
			}
			else {
				k=next[k];
			}
		}
		return next;
			
	}
	
	public static int KmpSearch(String s,String p){
		int[] next=getNext(p);
		int i=0,j=0;
		int N=s.length();
		int M=p.length();
		while(i<N&&j<M){
			if(j==-1||s.charAt(i)==p.charAt(j))
			{
				i++;j++;
			}
			else {
				j=next[j];
			}
		}
		if(j==M)return i-j;
		return -1;
	}

	public static void main(String[] args){
		String string="AAAAAAAAAAAAAAB";
		String pString="AAAAB";
		int i=Violent.search(string, pString);
		System.out.println(i);
		int c=KMP.KmpSearch(string, pString);
		System.out.println(c);
		int[] next=getNext(pString);
		for(int x:next)
			System.out.print(x+" ");
	}
}
