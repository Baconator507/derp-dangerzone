import javax.swing.JFrame;
import java.util.*;
import java.io.*;


public class BSTreeMain {
	private BSTree tree;

	public static void main(String args[]) // Runs JFrame with panels
	{
		final BSTree tree = new BSTree();
		loadTree(tree,"words.txt");
//		tree.postOrder();
	//	tree.preOrder();

		tree.inOrder();
		System.out.println(tree.findNode(new Word("Apple")));
		tree.clearOrder();
		tree.inOrder();


	}

	public static void loadTree(BSTree tree, String file){
		Scanner s = null;
		try {
			s = new Scanner(new BufferedReader(new FileReader(file)));
			while (s.hasNext()) {
				tree.insertNode(new Word(s.next()));
			}
		} 
		catch(FileNotFoundException e)
		{
			System.out.println("File Not Found: ") ; 
		}
		catch(IOException e)
		{
			System.out.println("IOException " + e.getMessage() ); // !!READ_ONLY!!
		}
		finally {
			if (s != null) { 
				s.close();
			}
		}
	} 
}



