package tungloaithucan;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import view1.GDnhanvien;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
 
public class hamboger extends JFrame{
  static GDnhanvien i;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnhamburger;
	private JButton btnspaghetti;
	private JButton btnsuachua;
	private JButton btnbanplan;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					hamboger frame = new hamboger(i);
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
	public hamboger(GDnhanvien i) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 555, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnhamburger = new JButton("");
		btnhamburger.setForeground(Color.WHITE);
		btnhamburger.setBackground(Color.WHITE);
		btnhamburger.setIcon(new ImageIcon("D:\\dowload\\hamburger.png"));
		btnhamburger.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnhamburger_actionPerformed(e);
			}
		});
		btnhamburger.setBounds(10, 31, 158, 140);
		contentPane.add(btnhamburger);
		
		btnspaghetti = new JButton("");
		btnspaghetti.setForeground(Color.WHITE);
		btnspaghetti.setBackground(Color.WHITE);
		btnspaghetti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnspaghetti_actionPerformed(e);
			}
		});
		btnspaghetti.setIcon(new ImageIcon("D:\\dowload\\spaghetti.png"));
		btnspaghetti.setBounds(283, 31, 158, 140);
		contentPane.add(btnspaghetti);
		
		btnsuachua = new JButton("");
		btnsuachua.setBackground(Color.WHITE);
		btnsuachua.setIcon(new ImageIcon("D:\\dowload\\yogurt.png"));
		btnsuachua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnsuachua_actionPerformed(e);
			}
		});
		btnsuachua.setBounds(10, 213, 158, 159);
		contentPane.add(btnsuachua);
		
		btnbanplan = new JButton("");
		btnbanplan.setBackground(Color.WHITE);
		btnbanplan.setIcon(new ImageIcon("D:\\dowload\\flan.png"));
		btnbanplan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnbanplan_actionPerformed(e);
			}
		});
		btnbanplan.setBounds(283, 220, 152, 152);
		contentPane.add(btnbanplan);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setIcon(new ImageIcon("D:\\dowload\\previous.png"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnNewButton_actionPerformed(e);
			}
		});
		btnNewButton.setBounds(445, 165, 100, 100);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("D:\\dowload\\4049.jpg_wh860.jpg"));
		lblNewLabel.setBounds(-39, 10, 585, 393);
		contentPane.add(lblNewLabel);
		this.i = i;
	}
	protected void do_btnhamburger_actionPerformed(ActionEvent e) {
	    hambuger k = new hambuger(i);
	    k.setVisible(true);
	    
	}
	protected void do_btnNewButton_actionPerformed(ActionEvent e) {
		this.dispose();
	}
	protected void do_btnspaghetti_actionPerformed(ActionEvent e) {
		miy k = new miy(i);
		k.setVisible(true);
	}
	protected void do_btnsuachua_actionPerformed(ActionEvent e) {
		suachua k = new suachua(i);
		k.setVisible(true);
	}
	protected void do_btnbanplan_actionPerformed(ActionEvent e) {
		banhplan k = new banhplan(i);
		k.setVisible(true);
	}
}
