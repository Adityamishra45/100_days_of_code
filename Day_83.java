class Solution
{
	public static int countPairs(Node root1, Node root2, int x)
	{
		// Code here
		Set<Integer> hs = new HashSet<>();
		preOrder(root1,hs);
		
		return count(root2,hs,x);
		
	}
	
	static void preOrder(Node root, Set<Integer> hs){
	    if( root == null){
	        return;
	    }
	    
	    hs.add(root.data);
	    preOrder(root.left,hs);
	    preOrder(root.right,hs);
	}
	
		static int count(Node root, Set<Integer> hs, int x){
		    int count =0;
	    if( root == null){
	        return count;
	    }
	    //simply checking if the set contains the number(resulted number) that we have subtracted from target
	    
	    if(hs.contains(x-root.data)){
	        count++;
	    }
	    
	    return count +  count(root.left,hs,x) + count(root.right,hs,x);
	
	}
}
