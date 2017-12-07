package com.techdiggity.gateway;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
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
	
					
					//InputStream resourceAsStream = Main.class.getResourceAsStream("/com/techdiggity/gateway/images/middle.gif");
					File currentDir = new File("");
					System.out.println("Current Dir: " + currentDir.getAbsolutePath());
					InputStream resourceAsStream = Main.class.getResourceAsStream("/Gateway/src/com/techdiggity/gateway/images/middle.gif");
				    //Image image = ImageIO.read(resourceAsStream);
				    //JLabel label1 = new JLabel(new ImageIcon(image));
					if (resourceAsStream == null) {
						System.out.println("Resource is null! :(");
					} else {
						System.out.println("Resource is GOOD!!");
						resourceAsStream.close();
					}
					
					
					
					
					
/*					List<String> resourceFiles = frame.getResourceFiles("/com/techdiggity/gateway");
					//List<String> resourceFiles = frame.getResourceFiles("/images");
							
					for (String resource : resourceFiles) {
						System.out.println(resource);
					}*/
					
					//frame.setLocationRelativeTo(null);
					//frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private List<String> getResourceFiles(String path) throws IOException {
		List<String> filenames = new ArrayList<>();

		try (InputStream in = getResourceAsStream(path);
				BufferedReader br = new BufferedReader(new InputStreamReader(in))) {
			String resource;

			while ((resource = br.readLine()) != null) {
				filenames.add(resource);
			}
		}

		return filenames;
	}

	private InputStream getResourceAsStream(String resource) {
		final InputStream in = getContextClassLoader().getResourceAsStream(resource);

		return in == null ? getClass().getResourceAsStream(resource) : in;
	}

	private ClassLoader getContextClassLoader() {
		return Thread.currentThread().getContextClassLoader();
	}
		  
	/**
	 * Create the frame.
	 */
	public Main() {
		
		if (1==1)
			return;
		
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
		
		//ImagePanel2 ip2 = new ImagePanel2();
		//panel_1.add(ip2);
		
		//ImageIcon icon = createImageIcon("/com/techdiggity/gateway/images/middle.gif", "a pretty but meaningless splat");
		//addImageToPanel(panel_1, "Label Text", JLabel.CENTER, JLabel.CENTER);		
		
		//ImageIcon ii = new ImageIcon("src/com/techdiggity/gateway/images/middle.gif");
		//ImageIcon ii = new ImageIcon("/src/com/techdiggity/gateway/images/middle.gif");
		//ImageIcon ii = new ImageIcon("com/techdiggity/gateway/images/middle.gif");
		//ImageIcon ii = new ImageIcon("/com/techdiggity/gateway/images/middle.gif");
		//ImageIcon ii = new ImageIcon("middle.gif");
		//JLabel labelFoo = new JLabel(ii);
		//panel_1.add(labelFoo);
		
		
		JLabel lblImport = new JLabel("Import Files");
		lblImport.setHorizontalAlignment(SwingConstants.CENTER);
		lblImport.setBounds(0, 69, 168, 32);
		lblImport.setForeground(Color.WHITE);
		lblImport.setFont(new Font("Roboto Light", Font.PLAIN, 24));
		panel_1.add(lblImport);
		
/*		try {
			//URL resource = this.getClass().getResource("/com/techdiggity/gateway/images/middle.gif");
			URL resource = Gateway.class.getResource("/com/techdiggity/gateway/images/middle.gif");
			BufferedImage wPic = ImageIO.read(resource);
			JLabel wIcon = new JLabel(new ImageIcon(wPic));
			panel_1.add(wIcon);	
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}*/
		
		//JLabel label3 = new JLabel(icon);
		//label3.setBounds(4, 57, 151, -68);
		//label3.setToolTipText("A label containing only an image");
		//panel_1.add(label3);
		
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
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Jeffery\\git\\gateway\\middle.gif"));
		lblNewLabel.setBounds(256, 36, 104, 37);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(Main.class.getResource("/com/techdiggity/gateway/images/middle.gif")));
		lblNewLabel_1.setBounds(370, 36, 46, 14);
		contentPane.add(lblNewLabel_1);
		headerPanel.addMouseListener(mml);
		headerPanel.addMouseMotionListener(mml);
	}
	
	private void addImageToPanel(JPanel panel_1, String labelText, int verticalPosition, int horizontalPosition) {
		String path = "/com/techdiggity/gateway/images/gateway-trans-16.png";
		ImageIcon icon = createImageIcon(path, "description");
		JLabel label1 = new JLabel(labelText,icon,JLabel.CENTER);
		label1.setVerticalTextPosition(verticalPosition); // e.g. JLabel.CENTER
		label1.setHorizontalTextPosition(horizontalPosition); // e.g. JLabel.CENTER
		
		//label2 = new JLabel("Text-Only Label");
		//label3 = new JLabel(icon);
	}

	protected ImageIcon createImageIcon(String path, String description) {
		
	    URL imgURL = getClass().getResource(path);

	    if (imgURL != null) {
	        return new ImageIcon(imgURL, description);
	    } else {
	        System.err.println("Couldn't find file:" +path);
	        return null;
	    }
	}
	
	private ImageIcon createImageIcon2(String path) {
		ImageIcon icon = new ImageIcon(Toolkit.getDefaultToolkit().getImage(Gateway.class.getResource(path)));
		return icon;
	}

	public JPanel getHeaderPanel() {
		return headerPanel;
	}
}
