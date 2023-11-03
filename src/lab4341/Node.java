package lab4341;

public class Node {
	
	String value;
	Node left, right, nextleaf;
	int BF;
	
	public Node(String s)
	{
		value = s;
		left = null;
		right = null;
		nextleaf = null;
		BF = 0;
	}

	public Node find(String valueatnode) {
		// TODO Auto-generated method stub
		
		if (value.equals(valueatnode))
		{
		   return this;
		}
		else
		{
			if (left != null)
			{
				Node l = left.find(valueatnode);
				if (l != null)
					return l;
			}
			if (right != null)
			{
				Node r = right.find(valueatnode);
				if (r != null)
					return r;
			}
		}
		return null;
	}

	public void insert(String valueatleft, String valueatright) {
		// TODO Auto-generated method stub
		
		if (valueatleft != null)
		{
			this.left = new Node(valueatleft);
		}
		if (valueatright != null)
		{
			this.right = new Node(valueatright);
		}
		
	}

	public void preorder() {
		// TODO Auto-generated method stub
		
		System.out.println(value + " ");
		
		if (left != null)
		{
			left.preorder();
		}
		if (right != null)
		{
			right.preorder();
		}
		
	}

	public int numleaves() {
		// TODO Auto-generated method stub
		int numinleft = 0; 
		int numinright = 0;
		if (left == null && right == null)
		{
			return 1;
		}
		if (left != null)
		{
			numinleft = left.numleaves();
		}
		if (right != null)
		{
			numinright = right.numleaves();
		}
		return numinleft + numinright;
	}

	public String leavesValues() {
		// TODO Auto-generated method stub
		String line = "";
		 
			if(left == null && right == null) {
				line = value + " ";
				return line;
			}
			if(left != null) {
				line = line + left.leavesValues();
			}
			if(right != null) {
				line = line + right.leavesValues();
			}
		
		return line;
	}

	public String getnamesby(char c) {
		// TODO Auto-generated method stub
		String line = "";
		 
		if(left != null) {
			line = line + left.getnamesby(c);
		}
		if(right != null) {
			line = line + right.getnamesby(c);
		}
		
		if (value.charAt(c) == c)
			line = line + value;
	
	return line;
	}

	public Node setupleaf(Node prevleaf) {
		// TODO Auto-generated method stub
		
		System.out.println(value + " ");
		if (left == null && right == null)
		{
			System.out.println("is leaf - setting up");
			
				System.out.println("**" + prevleaf.value);
				
				prevleaf.nextleaf = this;

				System.out.println("** next " + prevleaf.nextleaf.value);
			
			return this;
		}
		else
		{
			if (left != null)
			{
				prevleaf = left.setupleaf(prevleaf);
			}
			if (right != null)
			{
				prevleaf = right.setupleaf(prevleaf);
			}
			return prevleaf;
		}
			
	}

	public void bstinsert(String s) {
		// TODO Auto-generated method stub
	
			if (s.compareTo(value) < 0)
			{
				if (left == null)
				{
					left = new Node(s);
				}
				else
				{
					left.bstinsert(s);
				}
			}
			else
			{
				if (right == null)
				{
					right = new Node(s);
				}
				else
				{
					right.bstinsert(s);
				}
			}
		
		
	}

	public void inorder() {
		// TODO Auto-generated method stub

		
		if (left != null)
		{
			left.inorder();
		}

		System.out.println(value + " ");
		
		if (right != null)
		{
			right.inorder();
		}
		
	}

	
	public void display(int level) {
		// TODO Auto-generated method stub


		if (left != null)
		{

			left.display(level + 1);
		}

		for (int i = 0; i < level; i++)
			System.out.print("\t");
		System.out.println(value + "/" + BF);
		
		if (right != null)
		{

			right.display(level + 1);
		}
		
	}

	
	
	
	public boolean bstfind(String s) {
		// TODO Auto-generated method stub
		if (s.equals(value) == true)
		{
			return true;
		}
		else if (s.compareTo(value) < 0)
		{
			if (left == null)
				return false;
			else
				return left.bstfind(s);
		}	
		else
		{
			if (right == null)
				return false;
			else
				return right.bstfind(s);
		}
	}
	
	public String findlargest()
	{
		if (right != null)
		{
			return right.findlargest();
		}
		else
			return value;
	}

	public void bstreplaceandremove(String s) {
		// TODO Auto-generated method stub
		
		// need to find the right value to be replaced here
		
		// let us find the largest in the left
		
		if (left != null)
		{
			String largestonleft = left.findlargest();
			this.value = largestonleft;
			
			if (left.value.equals(largestonleft))
				left.bstreplaceandremove(largestonleft);
			else
				this.bstremove(largestonleft);
		}
		if (right != null)
		{
			String smallestonright = right.findsmallest();
			this.value = smallestonright;
			
			if (right.value.equals(smallestonright))
				right.bstreplaceandremove(smallestonright);
			else
				this.bstremove(smallestonright);
		}
		
		
		// replace it here
		// then remove it from the tree
		
		
		
	}

	private String findsmallest() {
		// TODO Auto-generated method stub
		if (left != null)
		{
			return left.findsmallest();
		}
		else
			return value;
	}

	public void bstremove(String s) {
		// TODO Auto-generated method stub
		// I am at a node that has the reponsibility to remove s from one of its children
		if (s.equals(value) == true)

		if (s.compareTo(value) < 0)  // s is smaller than value at node
		{
			if (left.value.equals(s))
			{
				if (left.left == null && left.right == null)
				{
					left = null;
				}
				else
					left.bstreplaceandremove(s);
			}
			else
			{
				left.bstremove(s);
			}
		}
		if (s.compareTo(value) > 0)  // s is smaller than value at node
		{
			if (right.value.equals(s))
			{
				if (right.left == null && right.right == null)
				{
					right = null;
				}
				else
					right.bstreplaceandremove(s);
			}
			else
			{
				right.bstremove(s);
			}
		}
		
	}


	public boolean avlinsert(String s) {
		// TODO Auto-generated method stub
	
			if (s.compareTo(value) < 0)
			{
				if (left == null)
				{
					left = new Node(s);
					BF = BF - 1;
					if (BF == -1)
						return true;
					else
						return false;
				}
				else
				{
					boolean change = left.avlinsert(s);
					if (change == false)
					{
						return false;
					}
					else
					{
						BF = BF - 1;
						if (BF == -1)
						{
							return true;
						}
						else if (BF == 0)
						{
							return false;
						}
						else if (BF == -2)
						{
							// Need to do rotation
							if (left.BF == -1)
							{
								// do single rotation from left
								System.out.println("Need to do single rotation");
								singlerotationfromleft();
								
							}
							else if (left.BF == 1)
							{
								// do double rotation from left
							}
							
							BF = 0;
							return false;
						}
						
					}
					
				}
			}
			else
			{
				if (right == null)
				{
					right = new Node(s);
					BF = BF + 1;
					if (BF == 1)
						return true;
					else
						return false;
				}
				else
				{
					boolean change = right.avlinsert(s);
					if (change == false)
					{
						return false;
					}
					else
					{
						BF = BF + 1;
						if (BF == 1)
						{
							return true;
						}
						else if (BF == 0)
						{
							return false;
						}
						else if (BF == 2)
						{
							// Need to do rotation
							if (right.BF == 1)
							{
								// do single rotation from right
							}
							else if (left.BF == -1)
							{
								// do double rotation from right
							}
							
							BF = 0;
							return false;
						}
						
					}
					
				}
				
				
			}
		
			return false; // dummy return
	}

	private void singlerotationfromleft() {
		// TODO Auto-generated method stub
		
		Node nodeA = this;
		Node NodeB = this.left;
		Node T1 = this.left.left;
		Node T2 = this.left.right;
		Node T3 = this.right;
		String A = this.value;
		String B = this.left.value;
		
		this.value = B;
		this.left = T1;
		this.right = NodeB;
		this.right.value = A;
		this.right.left = T2;
		this.right.right = T3;
		this.right.BF = 0;
		
		
	}




}
