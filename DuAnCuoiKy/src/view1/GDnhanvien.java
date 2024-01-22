package view1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.beans.Statement;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import khachhangvip.khachhangvip;
import mangve.manghangvenha;
import quanlidouong.douong;
import tungloainuoc.CAFESUADA;
import tungloainuoc.cacaoda;
import tungloainuoc.cacaonong;
import tungloainuoc.khongdo;
import tungloainuoc.samdua;
import tungloainuoc.trachanh;
import tungloainuoc.tradao;
import tungloainuoc.tratac;
import tungloaithucan.hamboger;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.JCheckBox;
import javax.swing.ButtonGroup;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.ImageIcon;

public class GDnhanvien extends JFrame {
	private ArrayList<douong> list;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton BTNAO11;
	private JButton BTNAO13;
	private JButton BTNAO12;
	private JButton BTNAO16;
	private JButton BTNAO1;
	private JButton BTNAO2;
	private JButton BTNAO3;
	private JButton BTNAO4;
	private JButton BTNAO5;
	private JButton BTNAO6;
	private JButton BTNAO7;
	private JButton BTNAO8;
	private JButton BTNAO9;
	private JButton BTNAO10;
	private JButton BTNAO14;
	private JButton BTNAO15;
	private JButton btnBan2;
	private JButton BTN1;
	private JButton btnBaN4;
	private JPanel panel_5;
	private JButton cfsuada;
	private JComboBox comboBox;
	public JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GDnhanvien frame = new GDnhanvien();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	String url = "jdbc:sqlserver://localhost:1433;databaseName=duan";
	String user = "sa";
	String password = "123456789";
	Statement st;
	ResultSet rs;
	public Object getable;
	private DefaultTableModel model;
	private JLabel tongtien;
	private JLabel tienthua;
	private String formattedTotalAmount;
	private DecimalFormat decimalFormat;
	public double thanhtien;
	private JButton tong;
	private JTextField tienkhachtra;
	private JButton btnBan3;
	private int douong;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JButton in;
	private JButton btnBan5;
	private JButton btnBan6;
	private JButton btnBan7;
	private JButton btnBan8;
	private JButton btnBan9;
	private JButton btnBan10;
	private JButton btnBan11;
	private JButton btnBan12;
	private JButton btnBan13;
	private JButton btnBan14;
	private JButton btnBan15;
	private JButton btnBan16;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JButton btnNewButton;
	private JButton btnNewButton_8;
	private JLabel lblNewLabel_8;

	public GDnhanvien() {
		list = new ArrayList<douong>();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1261, 857);
		contentPane = new JPanel();
		contentPane.setBackground(Color.MAGENTA);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("BÀN CHƯA CÓ KHÁCH");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setBackground(Color.BLACK);
		lblNewLabel.setBounds(0, 250, 300, 52);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 26));
		contentPane.add(lblNewLabel);

		JPanel panel = new JPanel();
		panel.setBackground(Color.CYAN);
		panel.setBounds(0, 292, 345, 210);
		contentPane.add(panel);
		panel.setLayout(null);

		BTN1 = new JButton("BAN1");
		BTN1.setBackground(Color.LIGHT_GRAY);
		BTN1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_BTN1_actionPerformed(e);
			}
		});
		BTN1.setBounds(0, 10, 67, 43);
		panel.add(BTN1);

		btnBan2 = new JButton("BAN2");
		btnBan2.setBackground(Color.LIGHT_GRAY);
		btnBan2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnBan2_actionPerformed(e);
			}
		});
		btnBan2.setBounds(77, 10, 83, 43);
		panel.add(btnBan2);

		btnBan3 = new JButton("BAN3");
		btnBan3.setBackground(Color.LIGHT_GRAY);
		btnBan3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				do_btnBan3_actionPerformed(e);
			}
		});
		btnBan3.setBounds(170, 10, 67, 43);
		panel.add(btnBan3);

		btnBaN4 = new JButton("BAN4");
		btnBaN4.setBackground(Color.LIGHT_GRAY);
		btnBaN4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnBaN4_actionPerformed(e);
			}
		});
		btnBaN4.setBounds(253, 10, 82, 43);
		panel.add(btnBaN4);

		btnBan5 = new JButton("BAN5");
		btnBan5.setBackground(Color.LIGHT_GRAY);
		btnBan5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnBan5_actionPerformed(e);
			}
		});
		btnBan5.setBounds(0, 63, 67, 43);
		panel.add(btnBan5);

		btnBan6 = new JButton("BAN6");
		btnBan6.setBackground(Color.LIGHT_GRAY);
		btnBan6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnBan6_actionPerformed(e);
			}
		});
		btnBan6.setBounds(77, 63, 83, 43);
		panel.add(btnBan6);

		btnBan7 = new JButton("BAN7");
		btnBan7.setBackground(Color.LIGHT_GRAY);
		btnBan7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnBan7_actionPerformed(e);
			}
		});
		btnBan7.setBounds(170, 63, 67, 43);
		panel.add(btnBan7);

		btnBan8 = new JButton("BAN8");
		btnBan8.setBackground(Color.LIGHT_GRAY);
		btnBan8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnBan8_actionPerformed(e);
			}
		});
		btnBan8.setBounds(253, 63, 82, 43);
		panel.add(btnBan8);

		btnBan9 = new JButton("BAN9");
		btnBan9.setBackground(Color.LIGHT_GRAY);
		btnBan9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnBan9_actionPerformed(e);
			}
		});
		btnBan9.setBounds(0, 116, 67, 43);
		panel.add(btnBan9);

		btnBan10 = new JButton("BAN10");
		btnBan10.setBackground(Color.LIGHT_GRAY);
		btnBan10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnBan10_actionPerformed(e);
			}
		});
		btnBan10.setBounds(77, 116, 83, 43);
		panel.add(btnBan10);

		btnBan11 = new JButton("BAN11");
		btnBan11.setBackground(Color.LIGHT_GRAY);
		btnBan11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnBan11_actionPerformed(e);
			}
		});
		btnBan11.setBounds(170, 116, 73, 43);
		panel.add(btnBan11);

		btnBan12 = new JButton("BAN12");
		btnBan12.setBackground(Color.LIGHT_GRAY);
		btnBan12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnBan12_actionPerformed(e);
			}
		});
		btnBan12.setBounds(253, 116, 82, 43);
		panel.add(btnBan12);

		btnBan13 = new JButton("BAN13");
		btnBan13.setBackground(Color.LIGHT_GRAY);
		btnBan13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnBan13_actionPerformed(e);
			}
		});
		btnBan13.setBounds(0, 169, 73, 43);
		panel.add(btnBan13);

		btnBan14 = new JButton("BAN14");
		btnBan14.setBackground(Color.LIGHT_GRAY);
		btnBan14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnBan14_actionPerformed(e);
			}
		});
		btnBan14.setBounds(77, 169, 83, 43);
		panel.add(btnBan14);

		btnBan15 = new JButton("BAN15");
		btnBan15.setBackground(Color.LIGHT_GRAY);
		btnBan15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnBan15_actionPerformed(e);
			}
		});

		btnBan15.setBounds(170, 169, 73, 43);
		panel.add(btnBan15);

		btnBan16 = new JButton("BAN16");
		btnBan16.setBackground(Color.LIGHT_GRAY);
		btnBan16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnBan16_actionPerformed(e);
			}
		});
		btnBan16.setBounds(253, 169, 82, 43);
		panel.add(btnBan16);

		JLabel lblBnangC = new JLabel("BÀN ĐANG CÓ KHÁCH");
		lblBnangC.setForeground(Color.RED);
		lblBnangC.setBounds(0, 501, 300, 52);
		lblBnangC.setFont(new Font("Tahoma", Font.BOLD, 23));
		contentPane.add(lblBnangC);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 543, 345, 210);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		panel_5 = new JPanel();
		panel_5.setBackground(Color.CYAN);
		panel_5.setBounds(0, 0, 345, 210);
		panel_1.add(panel_5);
		panel_5.setLayout(null);
		panel_5.setVisible(false);

		BTNAO1 = new JButton("BAN1");
		BTNAO1.setBackground(Color.WHITE);
		BTNAO1.setBounds(0, 10, 67, 43);
		panel_5.add(BTNAO1);
		BTNAO1.setVisible(false);

		BTNAO2 = new JButton("BAN2");
		BTNAO2.setBackground(Color.WHITE);
		BTNAO2.setBounds(77, 10, 83, 43);
		panel_5.add(BTNAO2);
		BTNAO2.setVisible(false);
		BTNAO3 = new JButton("BAN3");
		BTNAO3.setBackground(Color.WHITE);
		BTNAO3.setBounds(170, 10, 77, 43);
		panel_5.add(BTNAO3);
		BTNAO3.setVisible(false);
		BTNAO4 = new JButton("BAN4");
		BTNAO4.setBackground(Color.WHITE);
		BTNAO4.setBounds(257, 10, 78, 43);
		panel_5.add(BTNAO4);
		BTNAO4.setVisible(false);
		BTNAO5 = new JButton("BAN5");
		BTNAO5.setBackground(Color.WHITE);
		BTNAO5.setBounds(0, 63, 67, 43);
		panel_5.add(BTNAO5);
		BTNAO5.setVisible(false);
		BTNAO6 = new JButton("BAN6");
		BTNAO6.setBackground(Color.WHITE);
		BTNAO6.setBounds(77, 63, 83, 43);
		panel_5.add(BTNAO6);
		BTNAO6.setVisible(false);
		BTNAO7 = new JButton("BAN7");
		BTNAO7.setBackground(Color.WHITE);
		BTNAO7.setBounds(170, 63, 77, 43);
		panel_5.add(BTNAO7);
		BTNAO7.setVisible(false);
		BTNAO8 = new JButton("BAN8");
		BTNAO8.setBackground(Color.WHITE);
		BTNAO8.setBounds(257, 63, 78, 43);
		panel_5.add(BTNAO8);
		BTNAO8.setVisible(false);
		BTNAO9 = new JButton("BAN9");
		BTNAO9.setBackground(Color.WHITE);
		BTNAO9.setBounds(0, 116, 67, 43);
		panel_5.add(BTNAO9);
		BTNAO9.setVisible(false);
		BTNAO10 = new JButton("BAN10");
		BTNAO10.setBackground(Color.WHITE);
		BTNAO10.setBounds(77, 116, 83, 43);
		panel_5.add(BTNAO10);
		BTNAO10.setVisible(false);
		BTNAO11 = new JButton("BAN11");
		BTNAO11.setBackground(Color.WHITE);
		BTNAO11.setBounds(170, 116, 77, 43);
		panel_5.add(BTNAO11);
		BTNAO11.setVisible(false);
		BTNAO12 = new JButton("BAN12");
		BTNAO12.setBackground(Color.WHITE);
		BTNAO12.setBounds(257, 116, 78, 43);
		panel_5.add(BTNAO12);
		BTNAO12.setVisible(false);
		BTNAO13 = new JButton("BAN13");
		BTNAO13.setBackground(Color.WHITE);
		BTNAO13.setBounds(0, 169, 67, 43);
		panel_5.add(BTNAO13);
		BTNAO13.setVisible(false);
		BTNAO14 = new JButton("BAN14");
		BTNAO14.setBackground(Color.WHITE);
		BTNAO14.setBounds(77, 169, 83, 43);
		panel_5.add(BTNAO14);
		BTNAO14.setVisible(false);
		BTNAO15 = new JButton("BAN15");
		BTNAO15.setBackground(Color.WHITE);
		BTNAO15.setBounds(170, 169, 77, 43);
		panel_5.add(BTNAO15);
		BTNAO15.setVisible(false);
		BTNAO16 = new JButton("BAN16");
		BTNAO16.setBackground(Color.WHITE);
		BTNAO16.setBounds(257, 169, 78, 43);
		panel_5.add(BTNAO16);
		BTNAO16.setVisible(false);
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.info);
		panel_2.setBounds(347, 49, 580, 394);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 560, 374);
		panel_2.add(scrollPane);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane.setViewportView(scrollPane_1);

		table = new JTable();
		table.setBackground(SystemColor.info);
		table.setForeground(SystemColor.textHighlight);
		table.addMouseListener(new MouseAdapter() {

		});

		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "\u0110\u1ED3 U\u1ED1ng",
				"GI\u00C1 Ti\u1EC1n", "S\u1ED1 L\u01B0\u1EE3ng", "Th\u00E0nh Ti\u1EC1n" }));
		scrollPane_1.setViewportView(table);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.PINK);
		panel_3.setBounds(344, 447, 583, 160);
		contentPane.add(panel_3);
		panel_3.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Thông Tin");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(30, 10, 129, 30);
		panel_3.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Tổng Tiền:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_1.setBounds(239, 24, 129, 30);
		panel_3.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("Khách Trả:");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_2.setBounds(239, 64, 129, 30);
		panel_3.add(lblNewLabel_1_2);

		JLabel lblNewLabel_1_3 = new JLabel("Tiền Thừa:");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_3.setBounds(239, 104, 129, 30);
		panel_3.add(lblNewLabel_1_3);

		tongtien = new JLabel("");
		tongtien.setFont(new Font("Tahoma", Font.PLAIN, 33));
		tongtien.setForeground(Color.RED);
		tongtien.setBounds(378, 24, 180, 30);

		panel_3.add(tongtien);

		tienthua = new JLabel("");
		tienthua.setFont(new Font("Tahoma", Font.PLAIN, 19));
		tienthua.setForeground(Color.RED);
		tienthua.setBounds(378, 104, 163, 30);
		panel_3.add(tienthua);

		tong = new JButton("TOTAL");
		tong.setIcon(new ImageIcon("D:\\dowload\\money.png"));
		tong.setBackground(Color.WHITE);
		tong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_tong_actionPerformed(e);
			}
		});
		tong.setBounds(10, 44, 95, 60);
		panel_3.add(tong);

		tienkhachtra = new JTextField();
		tienkhachtra.setBounds(378, 64, 163, 30);
		panel_3.add(tienkhachtra);
		tienkhachtra.setColumns(10);

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.YELLOW);
		panel_4.setBounds(347, 617, 582, 143);
		contentPane.add(panel_4);
		panel_4.setLayout(null);

		in = new JButton("in");
		in.setIcon(new ImageIcon("D:\\dowload\\printing.png"));
		in.setBackground(Color.WHITE);
		in.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_in_actionPerformed(e);
			}
		});
		in.setBounds(127, 24, 153, 76);
		panel_4.add(in);

		JCheckBox chckbxNewCheckBox = new JCheckBox("XUẤT HÓA ĐƠN:");
		chckbxNewCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_chckbxNewCheckBox_actionPerformed(e);
			}
		});
		buttonGroup.add(chckbxNewCheckBox);
		chckbxNewCheckBox.setBounds(21, 0, 153, 21);
		panel_4.add(chckbxNewCheckBox);

		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("KHÔNG XUẤT HÓA ĐƠN");
		chckbxNewCheckBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_chckbxNewCheckBox_1_actionPerformed(e);
			}
		});

		buttonGroup.add(chckbxNewCheckBox_1);
		chckbxNewCheckBox_1.setBounds(210, 0, 173, 21);
		panel_4.add(chckbxNewCheckBox_1);
		
		JButton mangve = new JButton("Mang Về");
		mangve.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_mangve_actionPerformed(e);
			}
		});
		mangve.setBackground(Color.WHITE);
		mangve.setBounds(399, 41, 130, 48);
		panel_4.add(mangve);

		JPanel panel_6 = new JPanel();
		panel_6.setBounds(937, 51, 310, 52);
		contentPane.add(panel_6);
		panel_6.setLayout(null);

		comboBox = new JComboBox();
		comboBox.setBackground(Color.WHITE);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_comboBox_actionPerformed(e);
			}
		});
		comboBox.addMouseListener(new MouseAdapter() {

		});
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "đồ uống", "thức ăn", "tráng miệng" }));
		comboBox.setBounds(10, 10, 264, 32);
		panel_6.add(comboBox);

		JPanel panel_7 = new JPanel();
		panel_7.setBackground(Color.CYAN);
		panel_7.setBounds(937, 102, 310, 651);
		contentPane.add(panel_7);
		panel_7.setLayout(null);

		cfsuada = new JButton("caFe Sữa Đá");
		cfsuada.setIcon(new ImageIcon("D:\\dowload\\coffee-cup (2).png"));
		cfsuada.setBackground(Color.WHITE);
		cfsuada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnNewButton_actionPerformed(e);
			}
		});
		cfsuada.setBounds(0, 10, 157, 99);
		panel_7.add(cfsuada);

		JButton btnNewButton_1 = new JButton("TRÀ CHANH");
		btnNewButton_1.setIcon(new ImageIcon("D:\\dowload\\lemonade.png"));
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnNewButton_1_actionPerformed(e);
			}
		});
		btnNewButton_1.setBounds(162, 10, 138, 99);
		panel_7.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("TRÀ ĐÀO");
		btnNewButton_2.setIcon(new ImageIcon("D:\\dowload\\tea.png"));
		btnNewButton_2.setBackground(Color.WHITE);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnNewButton_2_actionPerformed(e);
			}
		});
		btnNewButton_2.setBounds(0, 140, 157, 99);
		panel_7.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("TRÀ TẮC");
		btnNewButton_3.setIcon(new ImageIcon("D:\\dowload\\green-tea.png"));
		btnNewButton_3.setBackground(Color.WHITE);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnNewButton_3_actionPerformed(e);
			}
		});
		btnNewButton_3.setBounds(167, 140, 133, 99);
		panel_7.add(btnNewButton_3);

		JButton btnNewButton_4 = new JButton("SÂM DỨA");
		btnNewButton_4.setIcon(new ImageIcon("D:\\dowload\\plastic.png"));
		btnNewButton_4.setBackground(Color.WHITE);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnNewButton_4_actionPerformed(e);
			}
		});
		btnNewButton_4.setBounds(0, 265, 157, 99);
		panel_7.add(btnNewButton_4);

		JButton btnNewButton_5 = new JButton("CACAO NÓNG");
		btnNewButton_5.setIcon(new ImageIcon("D:\\dowload\\cocoa.png"));
		btnNewButton_5.setBackground(Color.WHITE);
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnNewButton_5_actionPerformed(e);
			}
		});
		btnNewButton_5.setBounds(167, 265, 133, 99);
		panel_7.add(btnNewButton_5);

		JButton btnNewButton_6 = new JButton("CACAO ĐÁ");
		btnNewButton_6.setIcon(new ImageIcon("D:\\dowload\\cocoa (1).png"));
		btnNewButton_6.setBackground(Color.WHITE);
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnNewButton_6_actionPerformed(e);
			}
		});
		btnNewButton_6.setBounds(0, 374, 157, 99);
		panel_7.add(btnNewButton_6);

		JButton btnNewButton_7 = new JButton("KHÔNG ĐỘ");
		btnNewButton_7.setBackground(Color.WHITE);
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnNewButton_7_actionPerformed(e);
			}
		});
		btnNewButton_7.setBounds(167, 374, 133, 99);
		panel_7.add(btnNewButton_7);

		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 23));
		lblNewLabel_2.setBounds(57, 24, 243, 52);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("welcome our staff");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblNewLabel_3.setBounds(28, 24, 269, 37);
		contentPane.add(lblNewLabel_3);
		
		btnNewButton = new JButton("\r\n");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setIcon(new ImageIcon("D:\\dowload\\employees.png"));
		btnNewButton.setBounds(0, 76, 345, 70);
		contentPane.add(btnNewButton);
		
		btnNewButton_8 = new JButton("Rules");
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnNewButton_8_actionPerformed(e);
			}
		});
		btnNewButton_8.setBackground(Color.WHITE);
		btnNewButton_8.setBounds(116, 155, 99, 85);
		contentPane.add(btnNewButton_8);
		
		lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setBounds(1092, 10, 132, 37);
		contentPane.add(lblNewLabel_8);
		this.setLocationRelativeTo(null);
		loaddatatoarraylist();
		loadarraylisttotable();
		calculateAndDisplayTotal();
		in.setVisible(false);updateDateTimeContinuously();
		this.setLocationRelativeTo(null);
	}
	
	private void updateDateTimeContinuously() {
	    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	    Timer timer = new Timer(1000, e -> {
	        String formattedDateTime = dateFormat.format(new Date());
	       
	        lblNewLabel_8.setText(formattedDateTime);
	    });

	    timer.start();
	}
	private void calculateAndDisplayTotal() {
		try {
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url, user, password);

			String sql = "SELECT SUM(moneytotal) AS totalAmount FROM dbo.ban1";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				double totalAmount = rs.getDouble("totalAmount");

				// Format the total amount (you can adjust the formatting as needed)
				decimalFormat = new DecimalFormat("#.###");
				formattedTotalAmount = decimalFormat.format(totalAmount);

				// Display the formatted total amount in the label

			}

			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void loaddatatoarraylist() {
		try {
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url, user, password);

			String sql = "select * from dbo.ban1";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			list.clear();
			while (rs.next()) {
				String douong1 = rs.getString(1);
				double giatien = rs.getDouble(2);
				int soluong = rs.getInt(3);
				thanhtien = rs.getDouble(4);
				douong k = new douong(douong1, giatien, soluong, thanhtien);
				list.add(k);
			}
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void loadarraylisttotable() {
		model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);

		DecimalFormat decimalFormat = new DecimalFormat("#.###");

		for (douong k : list) {

			String formattedGiaTien = decimalFormat.format(k.giatien);
			String formattedThanhTien = decimalFormat.format(k.giatien * k.soluong);

			model.addRow(new Object[] { k.nuoc, formattedGiaTien, k.soluong, formattedThanhTien });
		}
	}

	protected void do_BTN1_actionPerformed(ActionEvent e) {
		BTN1.setVisible(false);
		try {
			int row = 0;
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url, user, password);
			String sql = "DELETE   from dbo.ban1 ";
			model.setRowCount(0);
			PreparedStatement st = conn.prepareStatement(sql);

			row = st.executeUpdate();

		} catch (Exception e2) {
			e2.printStackTrace();
			JOptionPane.showMessageDialog(this, "error");
		}

		panel_5.setVisible(true);
		BTNAO1.setVisible(true);
	}

	protected void do_btnBan2_actionPerformed(ActionEvent e) {
		btnBan2.setVisible(false);
		try {
			int row = 0;
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url, user, password);
			String sql = "DELETE   from dbo.ban1 ";
			model.setRowCount(0);
			PreparedStatement st = conn.prepareStatement(sql);

			row = st.executeUpdate();

		} catch (Exception e2) {
			e2.printStackTrace();
			JOptionPane.showMessageDialog(this, "error");
		}

		panel_5.setVisible(true);
		BTNAO2.setVisible(true);
	}

	protected void do_btnBan3_actionPerformed(ActionEvent e) {

		btnBan3.setVisible(false);
		try {
			int row = 0;
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url, user, password);
			String sql = "DELETE   from dbo.ban1 ";
			model.setRowCount(0);
			PreparedStatement st = conn.prepareStatement(sql);

			row = st.executeUpdate();

		} catch (Exception e2) {
			e2.printStackTrace();
			JOptionPane.showMessageDialog(this, "error");
		}
		panel_5.setVisible(true);
		BTNAO3.setVisible(true);
	}

	protected void do_btnNewButton_actionPerformed(ActionEvent e) {
		CAFESUADA k = new CAFESUADA(this);
		k.setVisible(true);
	

	}

	protected void do_tong_actionPerformed(ActionEvent e) {
		try {
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url, user, password);

			String sql = "SELECT SUM(moneytotal) AS totalAmount FROM dbo.ban1";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				double totalAmount = rs.getDouble("totalAmount");

			
				decimalFormat = new DecimalFormat("#.###");
				formattedTotalAmount = decimalFormat.format(totalAmount);

				
				tongtien.setText(formattedTotalAmount);

				if (!tienkhachtra.getText().isEmpty()) {
					double khachTraAmount = Double.parseDouble(tienkhachtra.getText());

					
					double changeAmount = khachTraAmount - totalAmount;

				
					String formattedChangeAmount = decimalFormat.format(changeAmount);
					tienthua.setText(formattedChangeAmount);
				} else {
					
					tienthua.setText("0");
				}
			}

			conn.close();
		} catch (Exception e1) {
			e1.printStackTrace();
		}

	}

	protected void do_btnNewButton_1_actionPerformed(ActionEvent e) {
		trachanh k = new trachanh(this);
		k.setVisible(true);

	}

	protected void do_btnNewButton_2_actionPerformed(ActionEvent e) {
		tradao k = new tradao(this);
		k.setVisible(true);
	}

	protected void do_btnNewButton_3_actionPerformed(ActionEvent e) {
		tratac k = new tratac(this);
		k.setVisible(true);
	}

	protected void do_btnNewButton_4_actionPerformed(ActionEvent e) {
		samdua k = new samdua(this);
		k.setVisible(true);
	}

	protected void do_btnNewButton_5_actionPerformed(ActionEvent e) {
		cacaonong k = new cacaonong(this);
		k.setVisible(true);

	}

	protected void do_btnNewButton_6_actionPerformed(ActionEvent e) {
		cacaoda k = new cacaoda(this);
		k.setVisible(true);
	}

	protected void do_btnNewButton_7_actionPerformed(ActionEvent e) {
		khongdo k = new khongdo(this);
		k.setVisible(true);
	}

	protected void do_in_actionPerformed(ActionEvent e) {

		generateAndPrintInvoice();
	}

	private void generateAndPrintInvoice() {
	    try {
	        Date currentDate = new Date();
	        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd ,  HH:mm:ss");
	        String formattedDate = dateFormat.format(currentDate);

	        double totalAmount = Double.parseDouble(tongtien.getText());

	        String invoiceContent = "Date: " + formattedDate + "\n";
	        invoiceContent += "Total Amount: " + formattedTotalAmount + "\n";

	        
	        DefaultTableModel model = (DefaultTableModel) table.getModel();
	        for (int i = 0; i < model.getRowCount(); i++) {
	            String drinkName = model.getValueAt(i, 0).toString();
	            String price = model.getValueAt(i, 1).toString();
	            String quantity = model.getValueAt(i, 2).toString();
	            String subtotal = model.getValueAt(i, 3).toString();

	            invoiceContent += "Item: " + drinkName + ", Price: " + price + ", Quantity: "
	                    + quantity + ", Subtotal: " + subtotal + "\n";
	        }

	       
	        String tableNumber = "1"; 
                
	        
	        invoiceContent += "Table Number: " + tableNumber + "\n";

	        String filePath = "C:\\hoadon\\vip.txt";
	        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
	            writer.write(invoiceContent);
	            System.out.println("Invoice saved to: " + filePath);
	        } catch (IOException ex) {
	            ex.printStackTrace();
	            JOptionPane.showMessageDialog(this, "Error while saving the invoice.", "Error",
	                    JOptionPane.ERROR_MESSAGE);
	        }
	    } catch (NumberFormatException e) {
	        JOptionPane.showMessageDialog(this, "Please calculate total amount first.", "Error",
	                JOptionPane.ERROR_MESSAGE);
	    }
	}
	protected void do_chckbxNewCheckBox_actionPerformed(ActionEvent e) {
		in.setVisible(true);
	}

	protected void do_chckbxNewCheckBox_1_actionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(this, "CAM ON QUY KHACH!");
	}

	protected void do_btnBaN4_actionPerformed(ActionEvent e) {
		btnBaN4.setVisible(false);
		try {
			int row = 0;
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url, user, password);
			String sql = "DELETE   from dbo.ban1 ";
			model.setRowCount(0);
			PreparedStatement st = conn.prepareStatement(sql);

			row = st.executeUpdate();

		} catch (Exception e2) {
			e2.printStackTrace();
			JOptionPane.showMessageDialog(this, "error");
		}
		panel_5.setVisible(true);
		BTNAO4.setVisible(true);
	}

	protected void do_btnBan5_actionPerformed(ActionEvent e) {
		btnBan5.setVisible(false);
		try {
			int row = 0;
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url, user, password);
			String sql = "DELETE   from dbo.ban1 ";
			model.setRowCount(0);
			PreparedStatement st = conn.prepareStatement(sql);

			row = st.executeUpdate();

		} catch (Exception e2) {
			e2.printStackTrace();
			JOptionPane.showMessageDialog(this, "error");
		}
		panel_5.setVisible(true);
		BTNAO5.setVisible(true);
	}

	protected void do_btnBan6_actionPerformed(ActionEvent e) {
		btnBan6.setVisible(false);
		try {
			int row = 0;
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url, user, password);
			String sql = "DELETE   from dbo.ban1 ";
			model.setRowCount(0);
			PreparedStatement st = conn.prepareStatement(sql);

			row = st.executeUpdate();

		} catch (Exception e2) {
			e2.printStackTrace();
			JOptionPane.showMessageDialog(this, "error");
		}
		panel_5.setVisible(true);
		BTNAO6.setVisible(true);
	}

	protected void do_btnBan7_actionPerformed(ActionEvent e) {
		btnBan7.setVisible(false);
		try {
			int row = 0;
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url, user, password);
			String sql = "DELETE   from dbo.ban1 ";
			model.setRowCount(0);
			PreparedStatement st = conn.prepareStatement(sql);

			row = st.executeUpdate();

		} catch (Exception e2) {
			e2.printStackTrace();
			JOptionPane.showMessageDialog(this, "error");
		}
		panel_5.setVisible(true);
		BTNAO7.setVisible(true);
	}

	protected void do_btnBan8_actionPerformed(ActionEvent e) {
		btnBan8.setVisible(false);
		try {
			int row = 0;
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url, user, password);
			String sql = "DELETE   from dbo.ban1 ";
			model.setRowCount(0);
			PreparedStatement st = conn.prepareStatement(sql);

			row = st.executeUpdate();

		} catch (Exception e2) {
			e2.printStackTrace();
			JOptionPane.showMessageDialog(this, "error");
		}
		panel_5.setVisible(true);
		BTNAO8.setVisible(true);
	}

	protected void do_btnBan9_actionPerformed(ActionEvent e) {
		btnBan9.setVisible(false);
		try {
			int row = 0;
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url, user, password);
			String sql = "DELETE   from dbo.ban1 ";
			model.setRowCount(0);
			PreparedStatement st = conn.prepareStatement(sql);

			row = st.executeUpdate();

		} catch (Exception e2) {
			e2.printStackTrace();
			JOptionPane.showMessageDialog(this, "error");
		}
		panel_5.setVisible(true);
		BTNAO9.setVisible(true);
	}

	protected void do_btnBan10_actionPerformed(ActionEvent e) {
		btnBan10.setVisible(false);
		try {
			int row = 0;
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url, user, password);
			String sql = "DELETE   from dbo.ban1 ";
			model.setRowCount(0);
			PreparedStatement st = conn.prepareStatement(sql);

			row = st.executeUpdate();

		} catch (Exception e2) {
			e2.printStackTrace();
			JOptionPane.showMessageDialog(this, "error");
		}
		panel_5.setVisible(true);
		BTNAO10.setVisible(true);
	}

	protected void do_btnBan11_actionPerformed(ActionEvent e) {
		btnBan11.setVisible(false);
		try {
			int row = 0;
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url, user, password);
			String sql = "DELETE   from dbo.ban1 ";
			model.setRowCount(0);
			PreparedStatement st = conn.prepareStatement(sql);

			row = st.executeUpdate();

		} catch (Exception e2) {
			e2.printStackTrace();
			JOptionPane.showMessageDialog(this, "error");
		}
		panel_5.setVisible(true);
		BTNAO11.setVisible(true);
	}

	protected void do_btnBan12_actionPerformed(ActionEvent e) {
		btnBan12.setVisible(false);
		try {
			int row = 0;
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url, user, password);
			String sql = "DELETE   from dbo.ban1 ";
			model.setRowCount(0);
			PreparedStatement st = conn.prepareStatement(sql);

			row = st.executeUpdate();

		} catch (Exception e2) {
			e2.printStackTrace();
			JOptionPane.showMessageDialog(this, "error");
		}
		panel_5.setVisible(true);
		BTNAO12.setVisible(true);
	}

	protected void do_btnBan13_actionPerformed(ActionEvent e) {
		btnBan13.setVisible(false);
		try {
			int row = 0;
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url, user, password);
			String sql = "DELETE   from dbo.ban1 ";
			model.setRowCount(0);
			PreparedStatement st = conn.prepareStatement(sql);

			row = st.executeUpdate();

		} catch (Exception e2) {
			e2.printStackTrace();
			JOptionPane.showMessageDialog(this, "error");
		}
		panel_5.setVisible(true);
		BTNAO13.setVisible(true);
	}

	protected void do_btnBan14_actionPerformed(ActionEvent e) {
		btnBan14.setVisible(false);
		try {
			int row = 0;
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url, user, password);
			String sql = "DELETE   from dbo.ban1 ";
			model.setRowCount(0);
			PreparedStatement st = conn.prepareStatement(sql);

			row = st.executeUpdate();

		} catch (Exception e2) {
			e2.printStackTrace();
			JOptionPane.showMessageDialog(this, "error");
		}
		panel_5.setVisible(true);
		BTNAO14.setVisible(true);
	}

	protected void do_btnBan16_actionPerformed(ActionEvent e) {
		btnBan16.setVisible(false);
		try {
			int row = 0;
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url, user, password);
			String sql = "DELETE   from dbo.ban1 ";
			model.setRowCount(0);
			PreparedStatement st = conn.prepareStatement(sql);

			row = st.executeUpdate();

		} catch (Exception e2) {
			e2.printStackTrace();
			JOptionPane.showMessageDialog(this, "error");
		}
		panel_5.setVisible(true);
		BTNAO16.setVisible(true);
	}

	protected void do_btnBan15_actionPerformed(ActionEvent e) {
		btnBan15.setVisible(false);
		try {
			int row = 0;
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url, user, password);
			String sql = "DELETE   from dbo.ban1 ";
			model.setRowCount(0);
			PreparedStatement st = conn.prepareStatement(sql);

			row = st.executeUpdate();

		} catch (Exception e2) {
			e2.printStackTrace();
			JOptionPane.showMessageDialog(this, "error");
		}
		panel_5.setVisible(true);
		BTNAO15.setVisible(true);
	}

	protected void do_comboBox_actionPerformed(ActionEvent e) {
		String selecteditem = (String) comboBox.getSelectedItem();

		if (selecteditem == "thức ăn") {
			hamboger k = new hamboger(this);
			k.setVisible(true);

		}

	}

	protected void do_btnNewButton_8_actionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(this,"Coffee Shop Rules and Regulations\r\n"
				+ "\r\n"
				+ "Welcome to [Coffee Shop Name]! We want to ensure a pleasant experience for all our customers. Please take a moment to familiarize yourself with our rules and regulations.\r\n"
				+ "\r\n"
				+ "1. General Conduct:\r\n"
				+ "\r\n"
				+ "Please be respectful to our staff and fellow customers.\r\n"
				+ "No offensive language or behavior will be tolerated.\r\n"
				+ "Smoking is not allowed inside the coffee shop premises.\r\n"
				+ "2. Seating and Tables:\r\n"
				+ "\r\n"
				+ "Please do not move tables or chairs without staff assistance.\r\n"
				+ "Priority seating may be given to customers purchasing food items during peak hours.\r\n"
				+ "3. Noise Level:\r\n"
				+ "\r\n"
				+ "Keep noise levels to a minimum to maintain a peaceful environment.\r\n"
				+ "Use headphones for personal audio devices.\r\n"
				+ "4. Wi-Fi Usage:\r\n"
				+ "\r\n"
				+ "Free Wi-Fi is available. Please use it responsibly and avoid streaming large files.\r\n"
				+ "No illegal or inappropriate online activities are permitted.\r\n"
				+ "5. Food and Drinks:\r\n"
				+ "\r\n"
				+ "Outside food and drinks are not allowed.\r\n"
				+ "Please return used dishes and utensils to the designated areas.\r\n"
				+ "6. Payment and Ordering:\r\n"
				+ "\r\n"
				+ "Payment is required at the time of ordering.\r\n"
				+ "No credit will be given without management approval.\r\n"
				+ "7. Personal Belongings:\r\n"
				+ "\r\n"
				+ "Keep your belongings with you at all times.\r\n"
				+ "The coffee shop is not responsible for lost or stolen items.\r\n"
				+ "8. Children and Pets:\r\n"
				+ "\r\n"
				+ "Children must be supervised by an adult.\r\n"
				+ "Pets are not allowed inside, with the exception of service animals.\r\n"
				+ "9. Photography:\r\n"
				+ "\r\n"
				+ "Respect the privacy of others; ask for permission before taking photos.\r\n"
				+ "Commercial photography requires prior authorization.\r\n"
				+ "10. Dress Code:\r\n"
				+ "- Please dress appropriately; shirt and footwear are required.\r\n"
				+ "\r\n"
				+ "11. Safety and Emergency:\r\n"
				+ "- Familiarize yourself with emergency exits.\r\n"
				+ "- In case of emergency, follow staff instructions.\r\n"
				+ "\r\n"
				+ "12. Feedback and Suggestions:\r\n"
				+ "- We value your feedback. Share your suggestions or concerns with our staff.\r\n"
				+ "\r\n"
				+ "13. Business Hours:\r\n"
				+ "- Respect our opening and closing hours.\r\n"
				+ "\r\n"
				+ "14. Violation Consequences:\r\n"
				+ "- Failure to comply with these rules may result in being asked to leave.\r\n"
				+ "\r\n"
				+ "Thank you for your cooperation! We hope you enjoy your time at [Coffee Shop Name].");
	}
	

	public JLabel getTongtien() {
		return tongtien;
	}

	public void setTongtien(JLabel tongtien) {
		this.tongtien = tongtien;
	}
	protected void do_mangve_actionPerformed(ActionEvent e) {
		manghangvenha k = new manghangvenha(this);
		k.setVisible(true);
	}
}
