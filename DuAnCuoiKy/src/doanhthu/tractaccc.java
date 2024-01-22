package doanhthu;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class tractaccc extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					cfsd frame = new cfsd();
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
	public  tractaccc () {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 331, 352);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTnSnPhm = new JLabel("Tên Sản Phẩm:");
		lblTnSnPhm.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTnSnPhm.setBounds(25, 24, 136, 37);
		contentPane.add(lblTnSnPhm);
		
		JLabel lblGa = new JLabel("Gía:");
		lblGa.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblGa.setBounds(25, 93, 94, 37);
		contentPane.add(lblGa);
		
		JLabel lblSLy = new JLabel("Số Ly đã bán:");
		lblSLy.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSLy.setBounds(25, 160, 114, 37);
		contentPane.add(lblSLy);
		
		JLabel lblChim = new JLabel("chiếm:");
		lblChim.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblChim.setBounds(25, 224, 94, 37);
		contentPane.add(lblChim);
		
		JLabel lblNewLabel = new JLabel("Trà Tắc");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(202, 31, 209, 27);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("30000");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(202, 98, 209, 27);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("19 Ly");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(202, 170, 209, 27);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("4%");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_2.setBounds(202, 224, 209, 27);
		contentPane.add(lblNewLabel_1_2);
		
		btnNewButton = new JButton("HỦY");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnNewButton_actionPerformed(e);
			}
		});
		btnNewButton.setBounds(138, 261, 108, 44);
		contentPane.add(btnNewButton);
		btnNewButton.setBackground(Color.WHITE);
	}

	protected void do_btnNewButton_actionPerformed(ActionEvent e) {
		this.dispose();
	}
}
