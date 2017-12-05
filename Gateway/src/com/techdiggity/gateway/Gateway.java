package com.techdiggity.gateway;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;

public class Gateway {

	JFrame frame = null;
	private JFrame frmGateway;
	private JPanel contentPane;
	private JMenu mnFile;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					try {
						UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					} catch (Exception e) {}
					
					Gateway gateway = new Gateway();
					gateway.launchFrame();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	protected void launchFrame() {
		frmGateway.setLocationRelativeTo(null);
		frmGateway.setVisible(true);
		resetFocus();
	}

	private void resetFocus() {
		getMnFile().requestFocus();
	}
	
	/**
	 * Create the frame.
	 */
	public Gateway() {
		frmGateway = new JFrame();
		frmGateway.setTitle("Gateway");
		frmGateway.setIconImage(Toolkit.getDefaultToolkit().getImage(Gateway.class.getResource("/com/techdiggity/gateway/images/gateway-trans-16.png")));
		frmGateway.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGateway.setBounds(100, 100, 562, 307);
		
		JMenuBar menuBar = new JMenuBar();
		frmGateway.setJMenuBar(menuBar);
		
		mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmImportFile = new JMenuItem("Import File");
		mntmImportFile.setIcon(new ImageIcon(Gateway.class.getResource("/com/techdiggity/gateway/images/file-import-16.png")));
		mnFile.add(mntmImportFile);
		
		JMenuItem mntmImportFolder = new JMenuItem("Import Files");
		mntmImportFolder.setIcon(new ImageIcon(Gateway.class.getResource("/com/techdiggity/gateway/images/folder-import-16.png")));
		mnFile.add(mntmImportFolder);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.setIcon(new ImageIcon(Gateway.class.getResource("/com/techdiggity/gateway/images/blue-logout-16.png")));
		mnFile.add(mntmExit);
		
		JMenu mnEdit = new JMenu("Edit");
		menuBar.add(mnEdit);
		
		JMenuItem mntmSettings = new JMenuItem("Settings");
		mntmSettings.setIcon(new ImageIcon(Gateway.class.getResource("/com/techdiggity/gateway/images/settings-16.png")));
		mnEdit.add(mntmSettings);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		JMenuItem mntmAboutGateway = new JMenuItem("About Gateway");
		mntmAboutGateway.setIcon(new ImageIcon(Gateway.class.getResource("/com/techdiggity/gateway/images/about-16.png")));
		mntmAboutGateway.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displayAboutBox();
			}
		});
		mnHelp.add(mntmAboutGateway);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		frmGateway.setContentPane(contentPane);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setRollover(true);
		toolBar.setFloatable(false);
		toolBar.setToolTipText("Import DICOM File");
		contentPane.add(toolBar, BorderLayout.NORTH);
		
		JButton btnImportFile = new JButton("");
		btnImportFile.setToolTipText("Import File");
		btnImportFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// ??
				resetFocus();
			}
		});
		btnImportFile.setIcon(new ImageIcon(Gateway.class.getResource("/com/techdiggity/gateway/images/file-import.png")));
		btnImportFile.setFocusPainted(false);
		toolBar.add(btnImportFile);
		
		JButton btnImportFiles = new JButton("");
		btnImportFiles.setToolTipText("Import Files");
		btnImportFiles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// ??
				resetFocus();
			}
		});
		btnImportFiles.setIcon(new ImageIcon(Gateway.class.getResource("/com/techdiggity/gateway/images/folder-import.png")));
		btnImportFiles.setFocusPainted(false);
		toolBar.add(btnImportFiles);
		
		JButton btnSettings = new JButton("");
		btnSettings.setToolTipText("Settings");
		btnSettings.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// ??
				resetFocus();
			}
		});
		btnSettings.setIcon(new ImageIcon(Gateway.class.getResource("/com/techdiggity/gateway/images/settings-25.png")));
		btnSettings.setFocusPainted(false);
		toolBar.add(btnSettings);
		
		JButton btnAbout = new JButton("");
		btnAbout.setToolTipText("About");
		btnAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// ??
				resetFocus();
			}
		});
		btnAbout.setIcon(new ImageIcon(Gateway.class.getResource("/com/techdiggity/gateway/images/about-24.png")));
		btnAbout.setFocusPainted(false);
		toolBar.add(btnAbout);
		
		JButton btnExit = new JButton("");
		btnExit.setToolTipText("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// ??
				resetFocus();
			}
		});
		btnExit.setIcon(new ImageIcon(Gateway.class.getResource("/com/techdiggity/gateway/images/blue-logout-24.png")));
		btnExit.setFocusPainted(false);
		toolBar.add(btnExit);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
	}

	protected void displayAboutBox() {
		About about = new About(frame);
		about.setVisible(true);		
	}

	public JMenu getMnFile() {
		return mnFile;
	}
}
