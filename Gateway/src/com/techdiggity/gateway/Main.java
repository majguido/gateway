package com.techdiggity.gateway;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Main extends JFrame {

	private JPanel contentPane;
	private JPanel headerPanel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Main() {
		setUndecorated(true);
		setTitle("Gateway");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 763, 317);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(30, 144, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 139));
		panel.setBounds(0, 85, 763, 179);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(100, 149, 237));
		panel_1.setBounds(10, 34, 168, 112);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblImport = new JLabel("Import Files");
		lblImport.setHorizontalAlignment(SwingConstants.CENTER);
		lblImport.setBounds(0, 69, 168, 32);
		lblImport.setForeground(Color.WHITE);
		lblImport.setFont(new Font("Roboto Light", Font.PLAIN, 24));
		panel_1.add(lblImport);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(100, 149, 237));
		panel_2.setBounds(202, 34, 168, 112);
		panel.add(panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(100, 149, 237));
		panel_3.setBounds(585, 34, 168, 112);
		panel.add(panel_3);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(394, 34, 168, 112);
		panel.add(panel_4);
		panel_4.setBackground(new Color(100, 149, 237));
		
		headerPanel = new JPanel();
		headerPanel.setBackground(new Color(30, 144, 255));
		headerPanel.setBounds(0, 0, 763, 37);
		contentPane.add(headerPanel);
		headerPanel.setLayout(null);
		
		JLabel label = new JLabel("_");
		label.setBounds(725, 7, 7, 25);
		headerPanel.add(label);
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				setState(JFrame.ICONIFIED);
			}
		});
		label.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		
		JLabel lblX = new JLabel("X");
		lblX.setBounds(742, 7, 11, 25);
		headerPanel.add(lblX);
		lblX.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
				System.exit(0);
			}
		});
		lblX.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		
		MoveMouseListener mml = new MoveMouseListener(headerPanel);
		
		JLabel lblGateway = new JLabel("Gateway");
		lblGateway.setBounds(31, 18, 181, 74);
		contentPane.add(lblGateway);
		lblGateway.setForeground(new Color(255, 255, 255));
		lblGateway.setFont(new Font("Roboto Light", Font.PLAIN, 36));
		
		JLabel label_1 = new JLabel("<");
		label_1.setFont(new Font("Roboto Light", Font.PLAIN, 24));
		label_1.setForeground(Color.WHITE);
		label_1.setBounds(10, 48, 23, 14);
		contentPane.add(label_1);
		headerPanel.addMouseListener(mml);
		headerPanel.addMouseMotionListener(mml);
	}
	public JPanel getHeaderPanel() {
		return headerPanel;
	}
}
