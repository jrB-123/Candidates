package com.proj.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

public class AdminList extends JPanel{
	// - - > DECLARATIONS
	private DefaultTableModel dtm;
	
	public AdminList() {
		this.setLayout(new BorderLayout());
		
		// - - > UPPER PANEL
		JPanel upperPanel = new JPanel();
		upperPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		upperPanel.setPreferredSize(new Dimension(0, 80));
		upperPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 25));
		
		JLabel mastText = new JLabel("ADMIN CANDIDATES LIST");
		mastText.setFont(new Font("Arial", Font.BOLD, 25));
		
		upperPanel.add(mastText);
		this.add(upperPanel, BorderLayout.PAGE_START);
		
		// - - > MIDDLE PANEL
		JPanel middlePanel = new JPanel();
		middlePanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		middlePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		this.add(middlePanel, BorderLayout.CENTER);
		System.out.println("Hello");
		
	}
	
	private void renderTablePanel() {
		
	}
}
