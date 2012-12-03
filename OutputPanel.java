import java.util.*;
import java.io.*;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JList;
import javax.swing.JFrame;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


public class OutputPanel extends JFrame {
	private JList olist, dlist;
	private LogPanel output;
	private ControlPanel control;
	private BSTree tree;

	public OutputPanel() {
		BSTree tree = new BSTree(this);
		loadTree(tree,"words.txt");
		output = new LogPanel();
		control = new ControlPanel(tree);
		setLayout(new BorderLayout());

		add(output, BorderLayout.CENTER);
		add(control, BorderLayout.PAGE_END);
	}
	public void setOutput (String data){
		output.setOutPut2(data);
	}
	public void clear(){
		output.clear();
	}
	public Word getWord(){
		return new Word(output.getText());
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
