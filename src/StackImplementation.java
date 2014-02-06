import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;


public class StackImplementation {

	class Stack{
		private Integer[] array;
		private Integer index;
		
		Stack(int size){
			array = new Integer[size];
			index=-1;
		}
		
		void push(Integer val){
			if(++index>=array.length){
				Integer[] tmpArray = new Integer[array.length*2];
				for(int i=0;i<array.length;i++)
					tmpArray[i]=array[i];
				array=tmpArray;
			}
			array[index]=val;
		}
		
		Integer pop(){
			if(index==-1)
				return null;
			
			return array[index--];
		}
		
	}
	public static void main(String[] args) {
		try
		{
			BufferedReader buf = new BufferedReader(new FileReader(args[0]));
			String line;
			StackImplementation stckClass = new StackImplementation();
			
			while((line=buf.readLine())!=null){
				StringTokenizer token = new StringTokenizer(line," ");
				Stack stck = stckClass.new Stack(line.length()/2);
				while(token.hasMoreTokens()){
					stck.push(Integer.parseInt(token.nextToken()));
				}
				
				Integer val;
				boolean last=false;
				
				while((val=stck.pop())!=null){
					if(!last){
						System.out.print(val+" ");
						last=true;
					}
					else{
						last=false;
					}
				}
				System.out.println();
			}
			buf.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}

	}

}
