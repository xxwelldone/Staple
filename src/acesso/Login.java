package acesso;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;



public class Login {
	public void show() {
		// Setting Frame and Panel that's going above the frame
		JFrame frame = new JFrame("Login");
		frame.setSize(250, 180);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);

		JPanel panel = new JPanel();
		panel.setLayout(null);

		// Fields for Panel's display
		JLabel userLogin = new JLabel("Usuario");
		userLogin.setBounds(10, 20, 80, 25);

		JTextField userLoginText = new JTextField();
		userLoginText.setBounds(70, 20, 150, 25);

		JLabel pwLogin = new JLabel("Senha");
		pwLogin.setBounds(10, 60, 80, 25);

		JPasswordField pwLoginText = new JPasswordField();
		pwLoginText.setBounds(70, 60, 150, 25);

		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(70, 100, 100, 25);
		btnLogin.addActionListener(evento -> {
			String user = userLoginText.getText();
			String pass = String.valueOf(pwLoginText.getPassword());

			if ("teste@ulife.com".equals(user) && "123456".equals(pass)) {
				//Staple staple = new Staple();
				//staple.show();
				frame.setVisible(false);
			} else {
				JOptionPane.showMessageDialog(null, "Make sure you typed everything correctly");
			}
		});

		// Mostrar no painel
		panel.add(userLogin);
		panel.add(userLoginText);
		panel.add(pwLogin);
		panel.add(pwLoginText);
		panel.add(btnLogin);
		frame.add(panel);
		frame.getRootPane().setDefaultButton(btnLogin);

		frame.setVisible(true);
	}
}
