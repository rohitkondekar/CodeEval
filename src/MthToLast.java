import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;


public class MthToLast {
	
	class Node{
		String val;
		Node next;
		
		Node(String val){
			this.val=val;
		}
	}

	public static void main(String[] args) {
		
		try{
			BufferedReader buf = new BufferedReader(new FileReader(args[0]));
			String line;
			MthToLast mLast = new MthToLast();
			
			while((line=buf.readLine())!=null){
				StringTokenizer token = new StringTokenizer(line," ");
				
				int M=0;
				String val;
				Node head=null,current=null;
				int size=0;
				
				while(token.hasMoreTokens()){
					val = token.nextToken();

					if(!token.hasMoreTokens())
						M = Integer.parseInt(val);
					else{
						Node n = mLast.new Node(val);
						if(head==null){
							head=n;
							current=n;
						}
						else{
							current.next=n;
							current = n;
						}
						size++;
					}
				}
				
				if(M>size){
					System.out.println();
					continue;
				}
				
				Node p1=head,p2=head;
				
				for(int i=1;i<M;i++)
					p2=p2.next;
				
				while(p2.next!=null){
					p1=p1.next;
					p2=p2.next;
				}
				
				System.out.println(p1.val);
				buf.close();
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}

	}

}
