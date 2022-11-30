package acesso;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import operacao.Food;
import operacao.CRUD;

public class MenuAtualizar extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldNome;
	private JTextField textFieldOrigem;
	private JTextField textFieldUnidade;
	private JTextField textFieldPreco;
	private JTextField textFieldFabricante;
	CRUD crud;
	Food food;

	/**
	 * Create the dialog.
	 */
	public MenuAtualizar(Food food, CRUD crud) {
		this.crud = crud;
		this.food = food;
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNome = new JLabel("Nome");
			lblNome.setBounds(11, 14, 68, 14);
			contentPanel.add(lblNome);
		}
		{
			textFieldNome = new JTextField();
			textFieldNome.setText(food.getNome());
			textFieldNome.setBounds(89, 11, 340, 20);
			contentPanel.add(textFieldNome);
			textFieldNome.setColumns(10);
		}
		{
			JLabel lblOrigem = new JLabel("Origem");
			lblOrigem.setBounds(11, 40, 68, 14);
			contentPanel.add(lblOrigem);
		}
		{
			textFieldOrigem = new JTextField();
			textFieldOrigem.setText(food.getOrigem());
			textFieldOrigem.setBounds(89, 37, 340, 20);
			contentPanel.add(textFieldOrigem);
			textFieldOrigem.setColumns(10);
		}
		{
			JLabel lblUnidade = new JLabel("Unidade");
			lblUnidade.setBounds(11, 66, 68, 14);
			contentPanel.add(lblUnidade);
		}
		{
			textFieldUnidade = new JTextField();
			textFieldUnidade.setText(Integer.toString(food.getUnidade()));
			textFieldUnidade.setBounds(89, 63, 340, 20);
			contentPanel.add(textFieldUnidade);
			textFieldUnidade.setColumns(10);
		}
		{
			JLabel lblPreco = new JLabel("Preço");
			lblPreco.setBounds(11, 92, 68, 14);
			contentPanel.add(lblPreco);
		}
		{
			textFieldPreco = new JTextField();
			textFieldPreco.setText(Double.toString(food.getPreco()));
			textFieldPreco.setBounds(89, 89, 340, 20);
			contentPanel.add(textFieldPreco);
			textFieldPreco.setColumns(10);
		}
		{
			JLabel lblFabricante = new JLabel("Fabricante");
			lblFabricante.setBounds(11, 118, 68, 14);
			contentPanel.add(lblFabricante);
		}
		{
			textFieldFabricante = new JTextField();
			textFieldFabricante.setText(food.getFabricante());
			textFieldFabricante.setBounds(89, 115, 340, 20);
			contentPanel.add(textFieldFabricante);
			textFieldFabricante.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String nome = textFieldNome.getText();
						String origem = textFieldOrigem.getText();
						int unidade = Integer.parseInt(textFieldUnidade.getText());
						double preco = Double.parseDouble(textFieldPreco.getText());
						String fabricante = textFieldFabricante.getText();
						crud.updateById(food.getId(), nome, origem, unidade, preco, fabricante);
						Window w = SwingUtilities.getWindowAncestor(contentPanel);
				        w.setVisible(false);
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Window w = SwingUtilities.getWindowAncestor(contentPanel);
				        w.setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
