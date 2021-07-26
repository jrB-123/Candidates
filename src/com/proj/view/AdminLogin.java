package com.proj.view;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.proj.controller.Controller;

public class AdminLogin extends JPanel implements ActionListener {
	// - - > DECLARATIONS
	private static final long serialVersionUID = 1L;
	private JTextField usernameField;
	private JPasswordField pw;
	private JButton reset, submit;

	public AdminLogin() {
		this.setLayout(new GridLayout(5, 1)); // 5 rows x 1 col
		
		JPanel adminIconWrapper = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 12));
		
		ImageIcon img = new ImageIcon("src\\com\\proj\\resources\\admin22.png");
		JLabel adminIcon = new JLabel(img);
		adminIcon.setPreferredSize(new Dimension(60,60));
		
		adminIconWrapper.add(adminIcon);
		this.add(adminIconWrapper); // row 1
		
		JPanel adminLabelWrapper = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 30));
		
		JLabel adminLabel = new JLabel("ADMINISTRATION LOGIN", SwingConstants.CENTER);
		adminLabel.setPreferredSize(new Dimension(500,25));
		adminLabel.setFont(new Font("Arial", Font.BOLD, 25));
		
		adminLabelWrapper.add(adminLabel);
		this.add(adminLabelWrapper);
		
		// CALL METHODS FOR THE FIELDS
		usernameFieldArea();
		passwordFieldArea();
		
		// CALL METHOD FOR THE BUTTON
		buttonsWrapperArea();
	}	
	
	private void usernameFieldArea() { // contains components within the usernameField
		JPanel usernameWrapper = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 20));
		
		JLabel username = new JLabel("Username: ");
		username.setPreferredSize(new Dimension(100, 25));
		username.setFont(new Font("Arial", Font.PLAIN, 18));
		usernameWrapper.add(username);
		
		usernameField = new JTextField();
		usernameField.setPreferredSize(new Dimension(200, 30));
		usernameWrapper.add(usernameField);
		
		this.add(usernameWrapper);
	}
	
	private void passwordFieldArea() { // contains components within the passwordField
		JPanel passwordWrapper = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 20));
		
		JLabel password = new JLabel("Password: ");
		password.setPreferredSize(new Dimension(100, 25));
		password.setFont(new Font("Arials", Font.PLAIN, 18));
		passwordWrapper.add(password); 
		
		pw = new JPasswordField();
		pw.setPreferredSize(new Dimension(200,30));
		passwordWrapper.add(pw);
		
		this.add(passwordWrapper);
	}
	
	private void buttonsWrapperArea() { // contains components within the reset and submit buttons
		JPanel buttonsWrapper = new JPanel(new FlowLayout(FlowLayout.CENTER, 30, 10));
		
		reset = new JButton("RESET");
		reset.setPreferredSize(new Dimension(100, 30));
		reset.addActionListener(this);
		buttonsWrapper.add(reset);
		
		submit = new JButton("SUBMIT");
		submit.setPreferredSize(new Dimension(100,30));
		submit.addActionListener(this);
		buttonsWrapper.add(submit);
		
		this.add(buttonsWrapper);
	}

	@Override
	public void actionPerformed(ActionEvent e) { // EVENT LISTENER FOR RESET AND SUBMIT
		// TODO Auto-generated method stub
		if(e.getSource().equals(reset)) { // RESET BUTTON CLICKED!
			System.out.println("RESET BUTTON CLICKED!");
			pw.setText("");
			usernameField.setText("");
			JOptionPane.showMessageDialog(null, "Credentials were reset!"); // Pop-Up info
			
		}else if(e.getSource().equals(submit)) { // SUBMIT BUTTON CLICKED!
			System.out.println("SUBMIT BUTTON CLICKED!");
			
			char[] arr = pw.getPassword();
			String password = String.valueOf(arr);
			String username = usernameField.getText();
						
			Controller control = new Controller();
			boolean flag = control.passwordCheck(username, password);
			
			if(flag) { // if correct
				JOptionPane.showMessageDialog(null, "Credentials are Correct!"); // Pop-Up info
				MainFrame.mainFrame.setSize(850, 500);
				CardLayout cl = (CardLayout) MainFrame.deck.getLayout();
				cl.show(MainFrame.deck, MainFrame.adminListCard);
				
			}else { // if incorrect
				JOptionPane.showMessageDialog(null, "Credentials are Incorrect!"); // Pop-Up info
				
			}
			pw.setText("");
			usernameField.setText("");
		}
	}
}
