package com.nhom6;

public class DFS {
private LinkedList<Integer> a[];
		private int count=0;
		private int V;
		private int start;
		private int end;
		private LinkedList<Integer> danhDau;
		private LinkedList<Integer> L;
		/**
		 * 
		 */
		
		@SuppressWarnings("unchecked")
		DFS(int v){
			this.V=v;
			for(int i=0;i<v;i++) {
				a[i]=new LinkedList();
			}
		}
		public LinkedList<Integer>[] getA() {
			return a;
		}
		public void setA(LinkedList<Integer>[] a) {
			this.a = a;
		}
		public int getV() {
			return V;
		}
		public void setV(int v) {
			V = v;
		}
		public int getStart() {
			return start;
		}
		public void setStart(int start) {
			this.start = start;
		}
		public int getEnd() {
			return end;
		}
		public void setEnd(int end) {
			this.end = end;
		}
		
		public int getCount() {
			return count;
		}
		public void setCount(int count) {
			this.count = count;
		}
		/**
		 * @param a
		 * @param v
		 * @param start
		 * @param end
		 */
		public DFS(LinkedList<Integer>[] a, int v, int start, int end) {
			super();
			this.a = a;
			V = v;
			this.start = start;
			this.end = end;
		}

		public final static String FILE_URL="C:\\Users\\Lap City\\eclipse-workspace\\Swing\\src\\BTL.txt";
	public void Doc_File() throws IOException {
		Scanner keyboard=new Scanner(System.in);
		File file=new File(FILE_URL);
		InputStream inputStream=new FileInputStream(file);
		InputStreamReader inputStreamReader=new InputStreamReader(inputStream);
		BufferedReader reader=new BufferedReader(inputStreamReader);
		

		int c=inputStreamReader.read();
		this.setStart(c);
		c=inputStreamReader.read();
			this.setEnd(c);
			for(int i=0;i<V;i++) {
				
			while(inputStreamReader.read()!=-1) {
				this.a[i].add(c);
			}
			
			}
			System.out.println("Start : ");
			this.setStart(Integer.parseInt(keyboard.next()));
			System.out.println("End : ");
			this.setEnd(Integer.parseInt(keyboard.next()));
			this.start--;
			this.end--;
	}
	public void inDuongDi(int soCanh) {
		this.setCount(this.getCount()+1);
		System.out.println("/n"+this.start++);
		for(int i=0;i<soCanh;i++) {
			System.out.println("->"+(this.L.get(i)+1));
		}
	}
	public void KhoiTao() {
		for(int i=0;i<V;i++) {
			this.danhDau.set(i, 0);
			this.L.set(i, 0);
		}
		this.danhDau.set(this.start, 1);
		this.L.set(1, this.start);
	}
	public void TRYDFS(int soCanh) {
		
		if(this.L.get(-1+soCanh)==end) {
			inDuongDi(soCanh);
		}else {
			for(int i=0;i<this.a[-1+soCanh].size();i++) {
				if(this.danhDau.get(i)==0) {
					this.L.set(soCanh, this.a[-1+soCanh].get(i));
					this.danhDau.set(this.a[-1+soCanh].get(i),1);
					TRYDFS(soCanh);
					this.L.set(soCanh, 0);
					this.danhDau.set(this.a[-1+soCanh].get(i),1);
					
				}
			}
		}
	}
}



}
