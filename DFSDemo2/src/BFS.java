import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.text.html.ListView;

public class BFS {
	static  final int number=100;
	private LinkedList<Integer> a[];
public void BFS(int i) {
	
	ArrayList queue=new ArrayList();
	ArrayList listVisit=new ArrayList<>();
	
	boolean[] visit;
	int n;
	visit=new boolean[number];
	visit[i]=true;
	queue.add(0,i);
	while(queue.size()>0) {
		i=(int) queue.get(-1+queue.size());
		queue.remove(-1+queue.size());
		listVisit.add(i);
		for(int j=0;j<this.a[i].size();j++) {
			if(!visit[j]) {
				visit[j]=true;
				queue.add(0,j);
			}
		}
	}
	for(int g=0;i<-1+listVisit.size();i++) {
		System.out.println(listVisit.get(g)+"->");
	}
	System.out.println(listVisit.get(-1+listVisit.size()));
}

}