package bibtexToIEEE;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.BoxLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;

public class main {

	private JFrame frame;
	
	BibTexToIEEE BTI = new BibTexToIEEE();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					main window = new main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public main() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextArea txtIeeeOutput;
		txtIeeeOutput = new JTextArea();
		txtIeeeOutput.setText("IEEE output");
		txtIeeeOutput.setToolTipText("IEEE output");
		txtIeeeOutput.setBounds(277, 6, 167, 249);
		frame.getContentPane().add(txtIeeeOutput);
		txtIeeeOutput.setColumns(10);
		
		JTextArea TextBibTex = new JTextArea();
		TextBibTex.setBounds(6, 6, 150, 249);
		frame.getContentPane().add(TextBibTex);
		JButton btnTransfer = new JButton("Transfer");
		btnTransfer.addActionListener(new ActionListener() {

		  
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String BibTex=TextBibTex.getText().toString();
				System.out.println(BibTex);
				String result = BTI.processBibTex(BibTex);
				txtIeeeOutput.setText(result);
				
				
			}
		});
		btnTransfer.setBounds(165, 117, 117, 29);
		frame.getContentPane().add(btnTransfer);
		
	}
}
