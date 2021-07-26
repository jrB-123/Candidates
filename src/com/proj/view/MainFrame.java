package com.proj.view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

/***
 * 
 * @Author: GROUP 6??
 * @Members: Gutierrez, Pamoso, Briz, Aquino, Degrano
 * @Description: An Election Candidate Management Application 
 *
 */

public class MainFrame {
	// - - > DECLARATIONS
	public static JFrame mainFrame;
	public static JPanel deck;
	private Home home;
	// - - > ADMIN SIDE
	private AdminLogin adminLogin;
	private AdminList adminList;
	// - - > USER SIDE
	private UserList userList;
	// - - > CARD LABELS
	public static String homeCard = "HOME";
	public static String adminLoginCard = "ADMINLOGIN"; 
	public static String adminListCard = "ADMINLIST";
	public static String userListCard = "USERLIST";
	
	public MainFrame() {
		mainFrame = new JFrame();
		mainFrame.setSize(750, 400);
		mainFrame.setTitle("Election Candidates Management Application");
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setResizable(false);
		mainFrame.getContentPane().setLayout(new BorderLayout());
		
		// INITIALIZE CUSTOM PANELS
		home = new Home();
		adminLogin = new AdminLogin();
		adminList = new AdminList();
		userList = new UserList();
		
		// STACK AND ADD PAGES HERE
		deck = new JPanel(new CardLayout()); // CARDLAYOUT AS NAVIGATION TOOL
		deck.add(home, homeCard); // HOME PAGE
		deck.add(adminLogin, adminLoginCard); // ADMIN LOGIN
		deck.add(adminList, adminListCard); // ADMIN CANDIDATES LIST PAGE
		deck.add(userList, userListCard); // USER LIST
		
		mainFrame.getContentPane().add(deck, BorderLayout.CENTER);
		mainFrame.setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MainFrame();
	}

}
