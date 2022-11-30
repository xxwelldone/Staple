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

import operacao.Food;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuBuscar extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private Food food;
	/**
	 * Create the dialog.
	 */
	public MenuBuscar(Food food) {
		this.food = food;
		setBounds(100, 100, 615, 250);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblId = new JLabel("Id");
		lblId.setBounds(10, 11, 154, 14);
		contentPanel.add(lblId);
		
		JLabel lblIdValue = new JLabel(Integer.toString(food.getId()));
		lblIdValue.setBounds(202, 11, 222, 14);
		contentPanel.add(lblIdValue);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(10, 36, 154, 14);
		contentPanel.add(lblNome);
		
		JLabel lblNomeValue = new JLabel(food.getNome());
		lblNomeValue.setBounds(202, 36, 222, 14);
		contentPanel.add(lblNomeValue);
		
		JLabel lblOrigem = new JLabel("Origem");
		lblOrigem.setBounds(10, 61, 154, 14);
		contentPanel.add(lblOrigem);
		
		JLabel lblOrigemValue = new JLabel(food.getOrigem());
		lblOrigemValue.setBounds(202, 61, 222, 14);
		contentPanel.add(lblOrigemValue);
		
		JLabel lblUnidade = new JLabel("Quantidade em estoque");
		lblUnidade.setBounds(10, 86, 154, 14);
		contentPanel.add(lblUnidade);
		
		JLabel lblUnidadeValue = new JLabel(Integer.toString(food.getUnidade()));
		lblUnidadeValue.setBounds(202, 86, 222, 14);
		contentPanel.add(lblUnidadeValue);
		
		JLabel lblPreco = new JLabel("Preço unitário");
		lblPreco.setBounds(10, 111, 154, 14);
		contentPanel.add(lblPreco);
		
		JLabel lblPrecoValue = new JLabel(Double.toString(food.getPreco()));
		lblPrecoValue.setBounds(202, 111, 222, 14);
		contentPanel.add(lblPrecoValue);
		
		JLabel lblFabricante = new JLabel("Produzido por");
		lblFabricante.setBounds(10, 136, 154, 14);
		contentPanel.add(lblFabricante);
		
		JLabel lblFabricanteValue = new JLabel(food.getFabricante());
		lblFabricanteValue.setBounds(202, 136, 222, 14);
		contentPanel.add(lblFabricanteValue);
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
