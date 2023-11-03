package lab4341;

import lab4341.Tree;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class driver {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub

		// open the file - using scanner
		
/*		Scanner scn = new Scanner(new File("btree.txt"));
		
		// declare and create a tree object
		
		Tree tr = new Tree();
		
		// read the first line and insert it into the tree object
		
		String line;
		
		while (scn.hasNext())
		{  
			line = scn.nextLine();
		
			tr.insert(line);
		}
		
		tr.preorder();
		
		System.out.println("The number of leaves in the tree is " + tr.numleaves());
		
		System.out.println(tr.leavesValues());
		
//		System.out.println(tr.getnamesby('m'));
		
		tr.setupleafIter();
		
		Node leafiter = tr.firstleaf;
		
		while (leafiter != null)
		{
		
			System.out.println(leafiter.value);
		
			leafiter = tr.getNextLeaf(leafiter);		
		}
		// iterate through this - 
		// output the string at leafiter
		// then do leafiter = tr.getnextleaf(leafiter);
		 * 
		 * 
		 */
		Scanner scn = new Scanner(new File("bsttree.txt"));
		
		// insert the items from this file into a tree - using bstinsert
		// test if the items are all inserted properly!
		
		Tree tr = new Tree();
		String value;
		
		while (scn.hasNext())
		{
			value = scn.next();
			
			tr.avlinsert(value);
		
		}
		
		tr.inorder();
		System.out.println();
		
		tr.display();
		
	/*	tr.bstremove("calvin");
		
		tr.inorder();
		
		tr.bstremove("obrien");
		
		tr.inorder();
		
	*/
		
		
		
		
	}

}
