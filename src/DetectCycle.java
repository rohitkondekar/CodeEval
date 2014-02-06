import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;


public class DetectCycle {
	
	public static void main(String[] args) {
		
		try {
			BufferedReader buf = new BufferedReader(new FileReader(args[0]));
			String line;
			
			while((line=buf.readLine())!=null){
				StringTokenizer token = new StringTokenizer(line," ");
				ArrayList<Integer> array = new ArrayList<Integer>(line.length()/2);
				
				while(token.hasMoreTokens()){
					array.add(Integer.parseInt(token.nextToken()));
				}
				
				HashMap<Integer, Boolean> hashMap = new HashMap<Integer, Boolean>();
				ArrayList<Integer> cycle = new ArrayList<Integer>();
				
				for(int i=0;i<array.size();i++){
					if(hashMap.containsKey(array.get(i))){
						if(hashMap.get(array.get(i))){
							int j;
							for(j=0;j<cycle.size()-1;j++){
								System.out.print(cycle.get(j)+" ");
							}
							System.out.println(cycle.get(j));
							break;
						}
						else{
							hashMap.put(array.get(i), true);
							cycle.add(array.get(i));
							
						}
					}
					else{
						hashMap.put(array.get(i), false);
					}
				}
			}
			buf.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}

}
