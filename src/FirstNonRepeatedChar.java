import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;


public class FirstNonRepeatedChar {

	public static void main(String[] args) {
		try{
			BufferedReader buf = new BufferedReader(new FileReader(args[0]));
			String line;
			BufferedOutputStream out = new BufferedOutputStream(System.out);
			
			while((line=buf.readLine())!=null){
				HashMap<Character, Integer> map = new HashMap<Character, Integer>();
				for(int i=0;i<line.length();i++){
					if(map.containsKey(line.charAt(i)))
						map.put(line.charAt(i), map.get(line.charAt(i))+1);
					else
						map.put(line.charAt(i),1);
				}
				
				for(int i=0;i<line.length();i++){
					if(map.get(line.charAt(i))==1)
					{
						out.write((line.charAt(i)+"\n").getBytes());
						break;
					}
				}
				
			}
			out.close();
			buf.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}

	}

}
