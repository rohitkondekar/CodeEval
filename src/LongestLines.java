import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.RandomAccess;

/**
 * https://www.codeeval.com/open_challenges/2/
 * @author rohitkondekar
 *
 */

public class LongestLines {

	class obj {
		int length;
		String str;
		
		obj(String str,int length){
			this.length = length;
			this.str = str;
		}
	}
	
	public class ObjComparator implements Comparator<obj>{

		@Override
		public int compare(obj o1, obj o2) {
			return (o1.length>o2.length)?1:-1;
		}
		
	}
	public class MaxObjComparator implements Comparator<obj>{

		@Override
		public int compare(obj o1, obj o2) {
			return (o1.length<o2.length)?1:-1;
		}
		
	}
	
	public static void main(String[] args) {
		try {
			
			BufferedReader buf = new BufferedReader(new FileReader(args[0]));
			int n;
			String line;
			
			if((line=buf.readLine())==null)
				return;
			
			n = Integer.parseInt(line);
			LongestLines longLines = new LongestLines();
			Comparator<obj> comparator1 = longLines.new ObjComparator();
			Comparator<obj> comparator2 = longLines.new MaxObjComparator();
			PriorityQueue<obj> queueMin = new PriorityQueue<obj>(n,comparator1);
			PriorityQueue<obj> queueMax = new PriorityQueue<obj>(n,comparator2);
			
			
			while((line=buf.readLine())!=null){
				if(queueMin.size()<n){
					queueMin.add(longLines.new obj(line,line.length()));
					queueMax.add(longLines.new obj(line,line.length()));
				}
				else{
					if(queueMin.peek().length<line.length()){
						queueMin.add(longLines.new obj(line,line.length()));
						queueMax.add(longLines.new obj(line,line.length()));
					}
				}
			}
			
			int i=0;
			while(!queueMax.isEmpty() && ++i<=n){
				System.out.println(queueMax.poll().str);
			}
			buf.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
