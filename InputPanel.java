import javax.swing.*;
import java.awt.*;


public class InputPanel extends JPanel{
	private JTextField input;

	public InputPanel(){
		setLayout(new FlowLayout());
		input = new JTextField(20);
		add(input);

	}

	public String getText(){
		return input.getText();
	}



}


