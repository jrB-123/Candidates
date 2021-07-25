package com.proj.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class UserList extends JPanel implements ActionListener{
	// - - > DECLARATIONS
	private static final long serialVersionUID = 1L;
	private JPanel upperPanel, middlePanel;
	private JComboBox filterPartyBox, filterPositionBox;
	private JTextField searchField;
	private JButton searchButton;
	// - - > DECLARING COMBO BOX CHOICES
	private String[] positionsArray = {"(Filter Position)", "President", "Vice President", "Executive Secretary",
									  "Secretary of Agrarian Reform", "Secretary of Agriculture",
									  "Secretary of Education", "Secretary of Finance", "Secretary of Energy",
									  "Secretary of Health", "Secretary of Justice"};
	private String[] partiesArray = {"(Filter Party)", "PDP-LABAN", "Liberal Party", "ANAKBAYAN"};
	
	public UserList() { // USER LIST CONSTRUCTOR
		this.setLayout(new BorderLayout());
		
		upperPanel = new JPanel();
		upperPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 25));
		upperPanel.setPreferredSize(new Dimension(0, 80));
		
		// - - > ADDING STARTING LABEL
		JLabel startingMast = new JLabel("USERS CANDIDATES LIST");
		startingMast.setFont(new Font("Arial", Font.BOLD, 25));
		upperPanel.add(startingMast);
		
		this.add(upperPanel, BorderLayout.PAGE_START);
		
		// - - > MIDDLE PANEL
		middlePanel();
	}
	
	private void middlePanel() { // METHOD RESPONSIBLE FOR RENDERING THE MIDDLE PANEL
		middlePanel = new JPanel();
		middlePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 0));
		middlePanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		JPanel filtersPanel = new JPanel();
		filtersPanel.setLayout(new GridLayout(3, 1));
		filtersPanel.setPreferredSize(new Dimension(230, 150));
		
		JPanel filtersLabelWrapper = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 25)); // TEXT PANEL
		
		JLabel filtersLabel = new JLabel("TABLE FILTERS:");
		filtersLabelWrapper.add(filtersLabel);
		filtersPanel.add(filtersLabelWrapper);
		
		// - - > ADDING FILTER PARTY COMBO BOX		
		JPanel filterPartyWrapper = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 2)); // FILTER PARTY PANEL
		
		filterPartyBox = new JComboBox(); // FILTER PARTY COMBO BOX PROPER
		filterPartyBox.setPreferredSize(new Dimension(200, 30));
		
		for(String item : partiesArray) { // POPULATING FILTER PARTY BOX
			filterPartyBox.addItem(item);
		}
		
		filterPartyWrapper.add(filterPartyBox);
		
		filtersPanel.add(filterPartyWrapper);
		
		// - - > ADDING FILTER POSITION COMBO BOX
		JPanel filterPositionWrapper = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0)); // FILTER POSITION PANEL
		
		filterPositionBox = new JComboBox(); // FILTER POSITION COMBO BOX
		filterPositionBox.setPreferredSize(new Dimension(200, 30));
		
		for(String item : positionsArray) { // POPULATING FILTER POSITION BOX
			filterPositionBox.addItem(item);
		}
		
		filterPositionWrapper.add(filterPositionBox);
		
		filtersPanel.add(filterPositionWrapper);
		
		middlePanel.add(filtersPanel);
		
		// - - > SEARCH BOX
		JPanel searchWrapper = new JPanel(new FlowLayout(FlowLayout.CENTER, 9, 14));
		searchWrapper.setPreferredSize(new Dimension(550, 120));
		searchWrapper.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Search Candidate:"));
		
		JLabel searchLabel = new JLabel("Input Candidate's Name in Search Bar");
		searchLabel.setFont(new Font("Arial", Font.BOLD, 18));
		searchWrapper.add(searchLabel);
		
		searchField = new JTextField();
		searchField.setPreferredSize(new Dimension(400,30));
		searchWrapper.add(searchField);
		
		searchButton = new JButton("Search");
		searchButton.setPreferredSize(new Dimension(80, 30));
		searchButton.addActionListener(this);
		
		searchWrapper.add(searchButton);
		
		middlePanel.add(searchWrapper);
		
		this.add(middlePanel, BorderLayout.CENTER);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(searchButton)) {
			try {
				String searchInput = searchField.getText();
				if(searchInput.contentEquals("")) { // IF SEARCH BOX IS EMPTY
					JOptionPane.showMessageDialog(null, "USER MUST INPUT A CANDIDATE'S NAME!");
				}else {
					System.out.println("INPUT: " + searchInput);
				}
			}catch(NullPointerException ne) {
				ne.printStackTrace();
			}
			
			searchField.setText(null);
		}
	}

}
