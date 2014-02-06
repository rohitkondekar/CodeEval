import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileReader;


public class LowestCommonAncestor {

	class Node{
		int val;
		Node right;
		Node left;
		
		Node(int val){
			this.val = val;
		}
	}
	
	public static void main(String[] args) {
		
		LowestCommonAncestor lca = new LowestCommonAncestor();
		Node root = lca.new Node(30);
		root.left = lca.new Node(8);
		root.left.left = lca.new Node(3);
		root.left.right = lca.new Node(20);
		root.right = lca.new Node(52);
		root.left.right.left =  lca.new Node(10);
		root.left.right.right = lca.new Node(29);
		
		
		try{
			BufferedReader buf = new BufferedReader(new FileReader(args[0]));
			String line;
			BufferedOutputStream out = new BufferedOutputStream(System.out);
			
			while((line=buf.readLine())!=null){
				String[] arr = line.split(" ");
				out.write(String.valueOf(lca.LCA(Integer.parseInt(arr[0]),Integer.parseInt(arr[1]),root).val).getBytes());
				out.write("\n".getBytes());
			}
			out.close();
			buf.close();
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		
	}
	
	Node LCA(int val1,int val2, Node root){
		
		if(val1==root.val || val2==root.val)
			return root;
		
		Node tmpR=null,tmpL=null;
		if(root.left!=null){
			tmpR = LCA(val1,val2,root.left);
		}
		
		if(root.right!=null){
			tmpL = LCA(val1,val2,root.right);
		}
		
		if(val1==root.val || val2==root.val){
			if(tmpL!=null || tmpR!=null)
				return root;
		}
		
		if(tmpL!=null && tmpR!=null)
			return root;
		else if(tmpL!=null)
			return tmpL;
		else if(tmpR!=null)
			return tmpR;
		
		return null;
		
	}

}
