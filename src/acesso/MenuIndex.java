package acesso;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Window;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuIndex extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private String id;
	private String index;

	/**
	 * Create the dialog.
	 */
	public MenuIndex(String id, String index) {
		this.id = id;
		this.index = index;
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblId = new JLabel("Id");
			lblId.setBounds(10, 10, 60, 14);
			contentPanel.add(lblId);
		}
		{
			JLabel lblIdValue = new JLabel(id);
			lblIdValue.setBounds(80, 10, 127, 14);
			contentPanel.add(lblIdValue);
		}
		{
			JLabel lblIndex = new JLabel("Index");
			lblIndex.setBounds(10, 35, 60, 14);
			contentPanel.add(lblIndex);
		}
		{
			JLabel lblIdValue = new JLabel(index);
			lblIdValue.setBounds(80, 35, 127, 14);
			contentPanel.add(lblIdValue);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Window w = SwingUtilities.getWindowAncestor(contentPanel);
				        w.setVisible(false);
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}

}
