package doanhthu;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import tungloainuoc.tradao;
import tungloainuoc.tratac;
import view1.GDadmin;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class doanhthu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnNewButton;
	private JButton btnXem;
	private JButton btnXem_1;
	private JButton btnXem_2;
	private JButton btnXem_3;
	private JButton btnXem_4;
	private JButton btnXem_5;
	private JButton btnXem_6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					doanhthu frame = new doanhthu();
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
	public doanhthu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1140, 872);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CAFE SỮA ĐÁ:\r\n");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(35, 90, 189, 52);
		contentPane.add(lblNewLabel);
		
		JLabel lblTrChanh = new JLabel("TRÀ CHANH:");
		lblTrChanh.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTrChanh.setBounds(35, 176, 189, 52);
		contentPane.add(lblTrChanh);
		
		JLabel lblTro = new JLabel("TRÀ ĐÀO:");
		lblTro.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTro.setBounds(35, 262, 189, 52);
		contentPane.add(lblTro);
		
		JLabel lblTrTc = new JLabel("TRÀ TẮC:");
		lblTrTc.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTrTc.setBounds(35, 355, 189, 52);
		contentPane.add(lblTrTc);
		
		JLabel lblSmDa = new JLabel("SÂM DỨA:");
		lblSmDa.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSmDa.setBounds(35, 456, 189, 52);
		contentPane.add(lblSmDa);
		
		JLabel lblCacaoHot = new JLabel("CACAO HOT:");
		lblCacaoHot.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblCacaoHot.setBounds(35, 561, 189, 52);
		contentPane.add(lblCacaoHot);
		
		JLabel lblCacao = new JLabel("CACAO ĐÁ:");
		lblCacao.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblCacao.setBounds(35, 656, 189, 52);
		contentPane.add(lblCacao);
		
		JLabel lblKhng = new JLabel("KHÔNG ĐỘ:");
		lblKhng.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblKhng.setBounds(35, 747, 189, 52);
		contentPane.add(lblKhng);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("D:\\dowload\\419880359_360267510065881_5342323776175431937_n (1).png"));
		lblNewLabel_1.setBounds(234, 47, 725, 227);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("New label");
		lblNewLabel_1_1.setIcon(new ImageIcon("D:\\dowload\\419880359_360267510065881_5342323776175431937_n (1).png"));
		lblNewLabel_1_1.setBounds(234, 139, 336, 227);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("New label");
		lblNewLabel_1_2.setIcon(new ImageIcon("D:\\dowload\\419880359_360267510065881_5342323776175431937_n (1).png"));
		lblNewLabel_1_2.setBounds(234, 223, 253, 227);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("New label");
		lblNewLabel_1_3.setIcon(new ImageIcon("D:\\dowload\\419880359_360267510065881_5342323776175431937_n (1).png"));
		lblNewLabel_1_3.setBounds(234, 308, 423, 227);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("New label");
		lblNewLabel_1_4.setIcon(new ImageIcon("D:\\dowload\\419880359_360267510065881_5342323776175431937_n (1).png"));
		lblNewLabel_1_4.setBounds(234, 401, 129, 227);
		contentPane.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("New label");
		lblNewLabel_1_5.setIcon(new ImageIcon("D:\\dowload\\419880359_360267510065881_5342323776175431937_n (1).png"));
		lblNewLabel_1_5.setBounds(234, 508, 460, 227);
		contentPane.add(lblNewLabel_1_5);
		
		JLabel lblNewLabel_1_6 = new JLabel("New label");
		lblNewLabel_1_6.setIcon(new ImageIcon("D:\\dowload\\419880359_360267510065881_5342323776175431937_n (1).png"));
		lblNewLabel_1_6.setBounds(234, 598, 725, 227);
		contentPane.add(lblNewLabel_1_6);
		
		JLabel lblNewLabel_1_7 = new JLabel("New label");
		lblNewLabel_1_7.setIcon(new ImageIcon("D:\\dowload\\419880359_360267510065881_5342323776175431937_n (1).png"));
		lblNewLabel_1_7.setBounds(234, 705, 725, 227);
		contentPane.add(lblNewLabel_1_7);
		
		JLabel lblNewLabel_2 = new JLabel("DOANH THU ĐỒ UỐNG NĂM 2023");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 33));
		lblNewLabel_2.setBounds(272, 10, 637, 61);
		contentPane.add(lblNewLabel_2);
		
		btnNewButton = new JButton("xem");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnNewButton_actionPerformed(e);
			}
		});
		btnNewButton.setBounds(1015, 82, 90, 73);
		contentPane.add(btnNewButton);
		
		btnXem = new JButton("xem");
		btnXem.setBackground(Color.WHITE);
		btnXem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnXem_actionPerformed(e);
			}
		});
		btnXem.setBounds(1015, 165, 90, 73);
		contentPane.add(btnXem);
		
		btnXem_1 = new JButton("xem");
		btnXem_1.setBackground(Color.WHITE);
		btnXem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnXem_1_actionPerformed(e);
			}
		});
		btnXem_1.setBounds(1015, 242, 90, 73);
		contentPane.add(btnXem_1);
		
		btnXem_2 = new JButton("xem");
		btnXem_2.setBackground(Color.WHITE);
		btnXem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnXem_2_actionPerformed(e);
			}
		});
		btnXem_2.setBounds(1015, 334, 90, 73);
		contentPane.add(btnXem_2);
		
		btnXem_3 = new JButton("xem");
		btnXem_3.setBackground(Color.WHITE);
		btnXem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnXem_3_actionPerformed(e);
			}
		});
		btnXem_3.setBounds(1015, 435, 90, 73);
		contentPane.add(btnXem_3);
		
		btnXem_4 = new JButton("xem");
		btnXem_4.setBackground(Color.WHITE);
		btnXem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnXem_4_actionPerformed(e);
			}
		});
		btnXem_4.setBounds(1015, 528, 90, 73);
		contentPane.add(btnXem_4);
		
		btnXem_5 = new JButton("xem");
		btnXem_5.setBackground(Color.WHITE);
		btnXem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnXem_5_actionPerformed(e);
			}
		});
		btnXem_5.setBounds(1015, 633, 90, 73);
		contentPane.add(btnXem_5);
		
		btnXem_6 = new JButton("xem");
		btnXem_6.setBackground(Color.WHITE);
		btnXem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnXem_6_actionPerformed(e);
			}
		});
		btnXem_6.setBounds(1015, 735, 90, 73);
		contentPane.add(btnXem_6);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnNewButton_1_actionPerformed(e);
			}
		});
		btnNewButton_1.setIcon(new ImageIcon("D:\\dowload\\home.png"));
		btnNewButton_1.setBounds(969, 10, 90, 61);
		contentPane.add(btnNewButton_1);
		this.setLocationRelativeTo(null);
	}
	protected void do_btnNewButton_actionPerformed(ActionEvent e) {
		cfsd k = new cfsd();
		k.setVisible(true);
	}
	protected void do_btnXem_actionPerformed(ActionEvent e) {
		trachanh k = new trachanh();
		k.setVisible(true);
	}
	
	protected void do_btnXem_1_actionPerformed(ActionEvent e) {
		tradaoo k  = new tradaoo();
		
		k.setVisible(true);
		
	}
	protected void do_btnXem_2_actionPerformed(ActionEvent e) {
		tractaccc k = new tractaccc();
		k.setVisible(true);
		
	}
	protected void do_btnXem_3_actionPerformed(ActionEvent e) {
		samdua k = new samdua();
		k.setVisible(true);
		
	}
	protected void do_btnXem_4_actionPerformed(ActionEvent e) {
		cacaonongg k = new cacaonongg();
		k.setVisible(true);
	}
	protected void do_btnXem_5_actionPerformed(ActionEvent e) {
		cacaoda k = new cacaoda();
		k.setVisible(true);
	}
	protected void do_btnXem_6_actionPerformed(ActionEvent e) {
		khongdo k = new khongdo();
		k.setVisible(true);
	}
	protected void do_btnNewButton_1_actionPerformed(ActionEvent e) {
		this.dispose();
		GDadmin k = new GDadmin();
		k.setVisible(true);
	}
}
