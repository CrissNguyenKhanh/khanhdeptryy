package view1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;

public class phanquyen extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnNewButton;
	private JButton btnWorkers;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					phanquyen frame = new phanquyen();
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
	public phanquyen() {
		setBackground(Color.GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 556, 736);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("WELCOME TO OMGCOFFE");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.ITALIC, 32));
		lblNewLabel.setBounds(76, 77, 425, 91);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("CHOOSE YOUR ROLE:");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblNewLabel_1.setBounds(10, 264, 244, 23);
		contentPane.add(lblNewLabel_1);
		
		btnNewButton = new JButton("ADMIN");
		btnNewButton.setIcon(new ImageIcon("D:\\dowload\\d804e05746470250a8bfc0237652fb5c.jpg"));
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnNewButton_actionPerformed(e);
			}
		});
		btnNewButton.setBounds(0, 323, 244, 262);
		contentPane.add(btnNewButton);
		
		btnWorkers = new JButton("");
		btnWorkers.setIcon(new ImageIcon("D:\\dowload\\tải xuống (1).png"));
		btnWorkers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnWorkers_actionPerformed(e);
			}
		});
		btnWorkers.setBackground(Color.LIGHT_GRAY);
		btnWorkers.setBounds(296, 323, 244, 262);
		contentPane.add(btnWorkers);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("D:\\dowload\\c081db9234bfbf5a98230478ffa7d9bd.jpg"));
		lblNewLabel_2.setBounds(-17, 0, 910, 724);
		contentPane.add(lblNewLabel_2);
		this.setLocationRelativeTo(null);	}
	protected void do_btnNewButton_actionPerformed(ActionEvent e) {
		formdangnhap1 k = new formdangnhap1();
		k.setVisible(true);
		this.dispose();
	}
	protected void do_btnWorkers_actionPerformed(ActionEvent e) {
		
		formdangnhap2 h = new formdangnhap2();
		h.setVisible(true);
		this.dispose();
	}
}
