package com.techdiggity.gateway;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class About extends JDialog {

	private static final long serialVersionUID = -79666805421455396L;
	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			About dialog = new About(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public About(Component parent) {
		setTitle("About");
		setIconImage(Toolkit.getDefaultToolkit().getImage(About.class.getResource("/com/techdiggity/gateway/images/gateway-trans-16.png")));
		setModal(true);
		setBounds(100, 100, 388, 176);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblImage = new JLabel("");
		lblImage.setBounds(10, 11, 151, 64);
		lblImage.setHorizontalAlignment(SwingConstants.CENTER);
		lblImage.setIcon(new ImageIcon(About.class.getResource("/com/techdiggity/gateway/images/gateway-64.png")));
		contentPanel.add(lblImage);
		
		JLabel lblGateway = new JLabel("GATEWAY");
		lblGateway.setBounds(10, 71, 134, 23);
		lblGateway.setForeground(new Color(0, 102, 204));
		lblGateway.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblGateway.setHorizontalAlignment(SwingConstants.CENTER);
		contentPanel.add(lblGateway);
		
		JLabel lblTheGatewayTo = new JLabel("The Gateway To Your PACS Server");
		lblTheGatewayTo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTheGatewayTo.setBounds(147, 52, 215, 14);
		contentPanel.add(lblTheGatewayTo);
		
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		JLabel lblJefferyBrannon = new JLabel("CopyRight \u00a9 "+year+" - Jeffery Brannon");
		lblJefferyBrannon.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblJefferyBrannon.setBounds(147, 69, 215, 14);
		contentPanel.add(lblJefferyBrannon);
		
		JLabel lblGateway_1 = new JLabel("Gateway");
		lblGateway_1.setBounds(147, 11, 191, 40);
		lblGateway_1.setFont(new Font("Tahoma", Font.BOLD, 24));
		contentPanel.add(lblGateway_1);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
					}
				});
				cancelButton.setActionCommand("Cancel");
				//buttonPane.add(cancelButton);
			}
		}
		
		setLocationRelativeTo(parent);
	}
}
