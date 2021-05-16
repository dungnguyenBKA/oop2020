package hust.soict.hedspi.aims.gui;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import hust.soict.hedspi.aims.media.disc.Track;

public class GUIDialog extends JDialog{
	private final JTextField idField = new JTextField();
	private final JTextField costField = new JTextField();
	private final JTextField cateField = new JTextField();
	private final JTextField titleField = new JTextField();
	
	public String getId() {
		return idField.getText();
	}
	public Float getCost() {
		float f;
		try {
			f = Float.parseFloat(costField.getText());
		} catch (Exception e) {
			e.printStackTrace();
			f = -1;
		}
		return f;
	}
	public String getCategory() {
		return cateField.getText();
	}
	public String getTitle() {
		return titleField.getText();
	}
	public JButton okJButton = new JButton("OK");
	
	public GUIDialog(Frame frame) {
		super(frame);
		setSize(600,400);
		setLayout(null);
		setResizable(false);
		
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) ((dimension.getWidth() - 600))/2;
		int y = (int) ((dimension.getHeight() - 400))/2;
		setLocation(x, y);
		
		setVisible(false);
		setModal(true);
	}
	public GUIDialog(Frame frame, String title) {
		super(frame,title);
		setSize(600,400);
		setLayout(null);
		setResizable(false);

		JLabel idJLabel = new JLabel("ID");
		JLabel costJLabel = new JLabel("Cost");
		JLabel categoryJLabel = new JLabel("Category");
		JLabel titleJLabel = new JLabel("Title");
		
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) ((dimension.getWidth() - 600))/2;
		int y = (int) ((dimension.getHeight() - 400))/2;
		setLocation(x, y);
		
		idJLabel.setSize(200,30);
		idJLabel.setLocation(100,20);
		add(idJLabel);
		idField.setSize(200, 30);
		idField.setLocation(300,20);
		add(idField);
		
		costJLabel.setSize(200,40);
		costJLabel.setLocation(100,60);
		add(costJLabel);
		costField.setSize(200, 30);
		costField.setLocation(300,60);
		add(costField);
		
		categoryJLabel.setSize(200,40);
		categoryJLabel.setLocation(100,100);
		add(categoryJLabel);
		cateField.setSize(200, 30);
		cateField.setLocation(300,100);
		add(cateField);
		
		titleJLabel.setSize(200,40);
		titleJLabel.setLocation(100,140);
		add(titleJLabel);
		titleField.setSize(200, 30);
		titleField.setLocation(300,140);
		add(titleField);
		
		
		okJButton.setSize(100,30);
		okJButton.setLocation(250,330);
		okJButton.setFocusPainted(false);
		add(okJButton);
		
		
		setVisible(false);
		setModal(true);
	}
	
	public boolean isEmpty() {
		return titleField.getText().equals("") || idField.getText().equals("") || cateField.getText().equals("") ||costField.getText().equals("");
	}
}


















