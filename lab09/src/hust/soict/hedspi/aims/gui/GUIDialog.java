package hust.soict.hedspi.aims.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIDialog extends JDialog{
	
	private JLabel idJLabel = new JLabel("ID");
	private JLabel costJLabel = new JLabel("Cost");
	private JLabel categoryJLabel = new JLabel("Category");
	private JLabel titleJLabel = new JLabel("Title");
	
	private JTextField idField = new JTextField();
	private JTextField costField = new JTextField();
	private JTextField cateField = new JTextField();
	private JTextField titleField = new JTextField();
	
//	private JTextField authorsField = new JTextField();
//	private JTextField lengthField = new JTextField();
//	private JTextField directorField = new JTextField();
//	private JTextField artistField = new JTextField();
//	private JTextField tracksField = new JTextField();
	
	
	public String getId() {
		return idField.getText();
	}
	public Float getCost() {
		float f;
		try {
			f = Float.parseFloat(costField.getText());
		} catch (Exception e) {
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
	public void addOK(int width,int height) {
		okJButton.setSize(100,40);
		okJButton.setLocation(width,height);
		okJButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				
			}
		});
		okJButton.setFocusPainted(false);
		add(okJButton);
	}
	
	public boolean isEmpty() {
		return titleField.getText().equals("") || idField.getText().equals("") || cateField.getText().equals("") ||costField.getText().equals("");
	}
}


















