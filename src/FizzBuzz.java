import java.awt.datatransfer.StringSelection;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileReader;


public class FizzBuzz {

	public static void main(String[] args) {
		
		try{
			BufferedReader buf = new BufferedReader(new FileReader(args[0]));
			String line;
			BufferedOutputStream out = new BufferedOutputStream(System.out);
			
			
			while((line=buf.readLine())!=null){
				String[] tmpArr = line.split(" ");
				int A = Integer.parseInt(tmpArr[0]);
				int B = Integer.parseInt(tmpArr[1]);
				int N = Integer.parseInt(tmpArr[2]);
				
				int i,a,b;
				for(i=1,a=1,b=1;i<N;i++,a++,b++){
					
					if(A==a && b==B){
						out.write("FB ".getBytes());
						a=0;b=0;
					}
					else if(A==a){
						out.write("F ".getBytes());
						a=0;
					}
					else if(b==B){
						out.write("B ".getBytes());
						b=0;
					}
					else{
						out.write((String.valueOf(i)+" ").getBytes());
					}
				}
				
				//for no trailing space
				if(A==a && b==B){
					out.write("FB".getBytes());
					a=0;b=0;
				}
				else if(A==a){
					out.write("F".getBytes());
					a=0;
				}
				else if(b==B){
					out.write("B".getBytes());
					b=0;
				}
				else{
					out.write((String.valueOf(i)).getBytes());
				}
				
				out.write("\n".getBytes());
			}
			out.close();
			buf.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		
	}

}
