package view1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import doanhthu.doanhthu;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.SwingConstants;

public class GDadmin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnNewButton_3;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GDadmin frame = new GDadmin();
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
	public GDadmin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1261, 859);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setIcon(new ImageIcon("D:\\dowload\\415518629_895900108655147_182281702052380754_n (1).png"));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(-13, 31, 1271, 266);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("LOẠICF");
		
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnNewButton_actionPerformed(e);
			}
		});
		btnNewButton.setIcon(new ImageIcon("D:\\dowload\\coffee (1).png"));
		btnNewButton.setBounds(31, 82, 110, 101);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("vip");
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnNewButton_1_actionPerformed(e);
			}
		});
		btnNewButton_1.setIcon(new ImageIcon("D:\\dowload\\teamwork.png"));
		btnNewButton_1.setBounds(258, 90, 110, 93);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setBackground(Color.WHITE);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnNewButton_2_actionPerformed(e);
			}
		});
		btnNewButton_2.setIcon(new ImageIcon("D:\\dowload\\woman.png"));
		btnNewButton_2.setBounds(826, 82, 100, 101);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel_1 = new JLabel("ADMIN QUẢN LÍ:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 29));
		lblNewLabel_1.setBounds(0, -74, 1227, 212);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("D:\\dowload\\f881ad2778cc7d7c88791e14c9419b52 (1).jpg"));
		lblNewLabel_2.setBounds(0, -11, 1247, 786);
		contentPane.add(lblNewLabel_2);
		
		btnNewButton_3 = new JButton("");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnNewButton_3_actionPerformed(e);
			}
		});
		btnNewButton_3.setIcon(new ImageIcon("D:\\dowload\\home.png"));
		btnNewButton_3.setBackground(Color.WHITE);
		btnNewButton_3.setForeground(Color.BLACK);
		btnNewButton_3.setBounds(556, 82, 110, 76);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnNewButton_4_actionPerformed(e);
			}
		});
		btnNewButton_4.setIcon(new ImageIcon("D:\\dowload\\bar-chart.png"));
		btnNewButton_4.setBackground(Color.WHITE);
		btnNewButton_4.setBounds(1072, 82, 127, 101);
		contentPane.add(btnNewButton_4);
	}
	protected void do_btnNewButton_actionPerformed(ActionEvent e) {
		quanlithucuong k = new quanlithucuong();
		k.setVisible(true);
		this.dispose();
	}
	protected void do_btnNewButton_1_actionPerformed(ActionEvent e) {
		quanlinhanvien k = new quanlinhanvien();
		k.setVisible(true);
		this.dispose();
	}
	protected void do_btnNewButton_2_actionPerformed(ActionEvent e) {
		quanlikhachhang k  = new quanlikhachhang();
		k.setVisible(true);
		this.dispose();
	}
	protected void do_btnNewButton_3_actionPerformed(ActionEvent e) {
		 
		formdangnhap1 k = new formdangnhap1();
		k.setVisible(true);
		this.dispose();
}
	protected void do_btnNewButton_4_actionPerformed(ActionEvent e) {
		doanhthu k = new doanhthu();
		k.setVisible(true);
	}
}
