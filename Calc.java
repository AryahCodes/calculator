import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Calc extends JFrame {

	private JPanel contentPane;
	private JTextField InputNum1;
	private JTextField InputNum2;
	Calculator calculator = new Calculator();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calc frame = new Calc();
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
	public Calc() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		InputNum1 = new JTextField();
		InputNum1.setBounds(20, 54, 64, 26);
		contentPane.add(InputNum1);
		InputNum1.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Calculator");
		lblNewLabel.setBounds(178, 18, 64, 16);
		contentPane.add(lblNewLabel);
		
		JButton button = new JButton("Submit");
		button.setBounds(208, 87, 88, 29);
		contentPane.add(button);
		
		InputNum2 = new JTextField();
		InputNum2.setBounds(208, 54, 77, 26);
		contentPane.add(InputNum2);
		InputNum2.setColumns(10);
		
		JComboBox<String> dropDown = new JComboBox<String>();
		dropDown.setModel(new DefaultComboBoxModel(new String[] {"Add", "Subtract", "Divide", "Multiply"}));
		dropDown.setBounds(96, 55, 108, 27);
		contentPane.add(dropDown);
		
		JLabel answerLabel = new JLabel("");
		answerLabel.setBounds(341, 59, 61, 16);
		contentPane.add(answerLabel);
		
		JLabel lblNewLabel_2 = new JLabel("=");
		lblNewLabel_2.setBounds(300, 59, 18, 16);
		contentPane.add(lblNewLabel_2);
		
		//When the button is pressed 
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if("Add".equals(dropDown.getSelectedItem())) {
					answerLabel.setText("" + calculator.add(Integer.parseInt(InputNum1.getText()), Integer.parseInt(InputNum2.getText())));
				}else if("Subtract".equals(dropDown.getSelectedItem())) {
					answerLabel.setText("" + calculator.subtract(Integer.parseInt(InputNum1.getText()), Integer.parseInt(InputNum2.getText())));
				}else if("Divide".equals(dropDown.getSelectedItem())) {
					answerLabel.setText("" + calculator.divide(Integer.parseInt(InputNum1.getText()), Integer.parseInt(InputNum2.getText())));
				}else {
					answerLabel.setText("" + calculator.mutiply(Integer.parseInt(InputNum1.getText()), Integer.parseInt(InputNum2.getText())));
				}
				
			}
		});
		
		
		
		
		
	}
}
