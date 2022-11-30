package acesso;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import operacao.CRUD;
import operacao.Food;

public class Staple extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldAtualizar;
	private JTextField textFieldBuscar;
	private JTextField textFieldDeletar;
	CRUD crud;
	private JTextField textFieldBuscarPorIndex;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Staple frame = new Staple();
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
	public Staple() {
		this.crud = new CRUD();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 485, 250);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setBounds(313, 11, 96, 23);
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuAdicionar dlg = new MenuAdicionar(crud);
				dlg.setVisible(true);
			}
		});
		
		JLabel lblAtualizar = new JLabel("Atualizar");
		lblAtualizar.setBounds(10, 73, 106, 15);
		
		textFieldAtualizar = new JTextField();
		textFieldAtualizar.setBounds(126, 70, 154, 20);
		textFieldAtualizar.setToolTipText("");
		textFieldAtualizar.setColumns(10);
		
		JLabel lblBuscar = new JLabel("Buscar por Id");
		lblBuscar.setBounds(10, 44, 106, 14);
		
		textFieldBuscar = new JTextField();
		textFieldBuscar.setBounds(126, 41, 154, 20);
		textFieldBuscar.setToolTipText("");
		textFieldBuscar.setColumns(10);
		
		JLabel lblDeletar = new JLabel("Deletar");
		lblDeletar.setBounds(10, 104, 106, 14);
		
		textFieldDeletar = new JTextField();
		textFieldDeletar.setBounds(126, 101, 154, 20);
		textFieldDeletar.setToolTipText("");
		textFieldDeletar.setColumns(10);
		
		JButton btnBuscarConfirmar = new JButton("...");
		btnBuscarConfirmar.setBounds(290, 40, 45, 23);
		btnBuscarConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int receita_id = Integer.parseInt(textFieldBuscar.getText());
				Food food = crud.getById(receita_id);
				if (food != null) {
					MenuBuscar menu_buscar = new MenuBuscar(food);
					menu_buscar.setVisible(true);
				}
			}
		});
		
		JButton btnAtualizarConfirmar = new JButton("...");
		btnAtualizarConfirmar.setBounds(290, 69, 45, 23);
		btnAtualizarConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int receita_id = Integer.parseInt(textFieldAtualizar.getText());
				Food food = crud.getById(receita_id);
				if (food != null) {
					MenuAtualizar menu_atualizar = new MenuAtualizar(food, crud);
					menu_atualizar.setVisible(true);
				}
			}
		});
		
		JButton btnDeletarConfirmar = new JButton("...");
		btnDeletarConfirmar.setBounds(290, 100, 45, 23);
		btnDeletarConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int receita_id = Integer.parseInt(textFieldDeletar.getText());
				Food food = crud.getById(receita_id);
				if (food != null) {
					MenuDeletar menu_deleta = new MenuDeletar(food, crud);
					menu_deleta.setVisible(true);
				}
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnAdicionar);
		contentPane.add(lblBuscar);
		contentPane.add(lblAtualizar);
		contentPane.add(lblDeletar);
		contentPane.add(textFieldDeletar);
		contentPane.add(btnDeletarConfirmar);
		contentPane.add(textFieldBuscar);
		contentPane.add(btnBuscarConfirmar);
		contentPane.add(textFieldAtualizar);
		contentPane.add(btnAtualizarConfirmar);
		
		JLabel lblBuscarPorIndex = new JLabel("Buscar por Index");
		lblBuscarPorIndex.setBounds(10, 135, 106, 14);
		contentPane.add(lblBuscarPorIndex);
		
		textFieldBuscarPorIndex = new JTextField();
		textFieldBuscarPorIndex.setToolTipText("");
		textFieldBuscarPorIndex.setColumns(10);
		textFieldBuscarPorIndex.setBounds(126, 132, 154, 20);
		contentPane.add(textFieldBuscarPorIndex);
		
		JButton btnBuscarPorIndexConfirmar = new JButton("...");
		btnBuscarPorIndexConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String receita_id = textFieldBuscarPorIndex.getText();
				int index = crud.getIndex(Integer.parseInt(receita_id));
				if (index != -1) {
					MenuIndex menu_index = new MenuIndex(receita_id, Integer.toString(index));
					menu_index.setVisible(true);
				} else {
					MenuIndex menu_index = new MenuIndex(receita_id, "Não encontrado.");
					menu_index.setVisible(true);
				}
			}
		});
		btnBuscarPorIndexConfirmar.setBounds(290, 131, 45, 23);
		contentPane.add(btnBuscarPorIndexConfirmar);
	}
}
