import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class FormularDB_1 extends JFrame {

	private JPanel contentPane;
	private JTextField txtTxtname;
	private JComboBox comboBoxNamen;
	private DBConnector meineDB;
	private JComboBox comboBoxNameVonDB;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormularDB_1 frame = new FormularDB_1();
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
	public FormularDB_1() {
		meineDB = new DBConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtTxtname = new JTextField();
		txtTxtname.setText("txtName");
		txtTxtname.setBounds(25, 164, 114, 19);
		contentPane.add(txtTxtname);
		txtTxtname.setColumns(10);
		
		JButton btnEinfuegen = new JButton("einfügen");
		btnEinfuegen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBoxNamen.addItem(txtTxtname.getText().toString());
				meineDB.addDaten(txtTxtname.getText().toString());
			}
		});
		btnEinfuegen.setBounds(162, 161, 117, 25);
		contentPane.add(btnEinfuegen);
		
		JButton btnLesen = new JButton("lesen");
		btnLesen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtTxtname.setText("lesen");
				List listNames = meineDB.getDaten();
				comboBoxNamen.removeAllItems();
				for(int i = 0; i < listNames.size(); i++)
				{
					
					comboBoxNameVonDB.addItem(listNames.get(i).toString());
				}
				//comboBoxNameVonDB.addItem(meineDB.getDaten());
			}
		});
		btnLesen.setBounds(311, 161, 117, 25);
		contentPane.add(btnLesen);
		
		JList listNamen = new JList();
		listNamen.setBounds(387, 61, -145, 35);
		contentPane.add(listNamen);
		
		comboBoxNamen = new JComboBox();
		comboBoxNamen.setBounds(12, 27, 159, 24);
		contentPane.add(comboBoxNamen);
		
		comboBoxNameVonDB = new JComboBox();
		comboBoxNameVonDB.setBounds(247, 27, 159, 24);
		contentPane.add(comboBoxNameVonDB);
	}
}
