package tungloainuoc;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import khachhangvip.khachhangvip;
import quanlidouong.douong;
import view1.GDnhanvien;
import javax.swing.ImageIcon;
import java.awt.Color;

public class CAFESUADA extends JFrame {
    private ArrayList<douong> list;
    private GDnhanvien k;
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textField;
    private JButton btnCancel;
    private JButton btnConfirm;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                GDnhanvien k = new GDnhanvien(); // Replace with your actual instance
                CAFESUADA frame = new CAFESUADA(k);
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    String url = "jdbc:sqlserver://localhost:1433;databaseName=duan";
    String user = "sa";
    String password = "123456789";
    ResultSet rs;
    private AbstractButton table;

    public CAFESUADA(GDnhanvien k ) {
       
        list = new ArrayList<>();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 463, 334);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Thông Tin");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
        lblNewLabel.setBounds(10, 22, 164, 35);
        contentPane.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Tên Sản Phẩm:");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_1.setBounds(10, 67, 136, 35);
        contentPane.add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("Cafe Sữa Đá");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_2.setBounds(176, 74, 238, 21);
        contentPane.add(lblNewLabel_2);

        JLabel lblNewLabel_1_1 = new JLabel("Gía Sản Phẩm :");
        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_1_1.setBounds(10, 112, 136, 35);
        contentPane.add(lblNewLabel_1_1);

        JLabel lblNewLabel_1_2 = new JLabel("Số Lượng:");
        lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_1_2.setBounds(10, 157, 136, 35);
        contentPane.add(lblNewLabel_1_2);

        JLabel lblNewLabel_1_2_1 = new JLabel("25000");
        lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_1_2_1.setBounds(176, 112, 136, 35);
        contentPane.add(lblNewLabel_1_2_1);

        textField = new JTextField();
        textField.setBounds(176, 162, 193, 29);
        contentPane.add(textField);
        textField.setColumns(10);

        JPanel panel = new JPanel();
        panel.setBounds(10, 202, 429, 95);
        contentPane.add(panel);
        panel.setLayout(null);

        JLabel lblNewLabel_3 = new JLabel("THAO TÁC:");
        lblNewLabel_3.setBounds(0, 10, 102, 18);
        panel.add(lblNewLabel_3);

        btnCancel = new JButton("Hủy");
        btnCancel.setBackground(Color.WHITE);
        btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_btnCancel_actionPerformed(e);
            }
        });
        btnCancel.setBounds(195, 35, 102, 50);
        panel.add(btnCancel);

        btnConfirm = new JButton("Xác Nhận");
        btnConfirm.setBackground(Color.WHITE);
        btnConfirm.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_btnConfirm_actionPerformed(e);
            }
        });
        btnConfirm.setBounds(305, 35, 114, 50);
        panel.add(btnConfirm);
        
        JLabel lblNewLabel_4 = new JLabel("");
        lblNewLabel_4.setIcon(new ImageIcon("D:\\dowload\\cold-coffee.png"));
        lblNewLabel_4.setBounds(344, 22, 95, 109);
        contentPane.add(lblNewLabel_4);
        loadDataTableArrayList();
        this.k = k;
    }

    public void loadDataTableArrayList() {
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
                double thanhtien = rs.getDouble(4);
                douong k = new douong(douong1, giatien, soluong, thanhtien);
                list.add(k);
            }
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void do_btnCancel_actionPerformed(ActionEvent e) {
        this.setVisible(false);
    }

    protected void do_btnConfirm_actionPerformed(ActionEvent e) {
        try {
            int row = 0;
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url, user, password);
            String sql = " INSERT INTO dbo.ban1 values(?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "cafe sua da");
            ps.setFloat(2, 25000);
            ps.setInt(3, Integer.parseInt(textField.getText()));
            ps.setDouble(4, 25000 * Integer.parseInt(textField.getText()));

            row = ps.executeUpdate();
            if (row > 0) {
                JOptionPane.showMessageDialog(this, "THÊM THÀNH CÔNG");
            } else {
                JOptionPane.showConfirmDialog(this, "THÊM THẤT BẠI!!");
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            JOptionPane.showMessageDialog(this, "error");
        }
       k.loaddatatoarraylist();
       k.loadarraylisttotable();
    }


}


