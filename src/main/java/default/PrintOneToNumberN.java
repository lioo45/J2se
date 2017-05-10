
public class PrintOneToNumberN {
	public static void main(String[] args) {
		int n=19;
		printMaxN(n);
	}
	
	private static void printMaxN(int n){
		if(n<=0)
			throw new RuntimeException("n�������0");
		else if(n<=18)
			printfWhenNLess19(n);
		else{
//			printfWhenNLess19(18);
			printMaxNWithString(n);
		}
	}

	private static void printMaxNWithString(int n) {
		char str[]=new char[n];
		//��ʼ���ַ���Ϊ10000000000000000000,18��0
		for(int i=0;i<18;++i)
			str[i]='0';
		str[18]='1';
		for(int i=19;i<n;++i)
			str[i]='0';
		int currentByte=19;
		while(currentByte<=n){
			//��ӡ�ַ���
			for(int i=currentByte-1;i>=0;--i)
				System.out.print(str[i]);
			System.out.println();
			//��������
			int i=0;
			while(str[i]=='9'&&i<n){
				str[i]='0';
				++i;
			}
			str[i]=(char) (str[i]+1);
			
			//��str��xλ������x+1λʱ
			if(i>=currentByte)
				currentByte++;
		}
	}
	
	private static void printfWhenNLess19(int n) {
		long max=1;
		for(int i=1;i<=n;++i)
			max*=10;
		for(int i=1;i<max;++i)
			System.out.println(i);
	}
}
