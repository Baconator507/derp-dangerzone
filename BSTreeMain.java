import javax.swing.JFrame;

public class BSTreeMain {
	private BSTree tree;

	public static void main(String args[]) // Runs JFrame with panels
	{
		final BSTree tree = new BSTree();
		tree.insertNode(new Word("bacon"));
		tree.insertNode(new Word("potato"));
		tree.insertNode(new Word("banana"));
		tree.insertNode(new Word("cow"));
		tree.insertNode(new Word("moo"));
		tree.postOrder();
		tree.preOrder();
	}
}



