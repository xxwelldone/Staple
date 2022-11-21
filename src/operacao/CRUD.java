package operacao;

import java.util.Arrays;
import java.util.Scanner;

public class CRUD {
	// id representa id atribuido a cada objeto cadastrado e espaço consumido
	private int id = 0;
	// Tamanho lógico do array
	private int fixo = 10;

	// Criação do array com tamanho incial 10
	Food[] cc = new Food[fixo];

	// Passa obj com todos os dados da conta, exceto ID

	public void add(Food food) {

		// Se id for maior ou igual a 10, aumenta tamanho do array pra +10
		if (id >= fixo) {
			fixo += 10;
			// Copia array inicial para um novo array
			cc = Arrays.copyOf(cc, fixo);
		}
		// Define um id pra conta +1 (neste momento o id está 0, que corresponde ao
		// indice inicial do array)
		food.setId(id + 1);
		// Atribui conta para indice (0,1,2,3, etc..)
		cc[id] = food;
		// Aumenta id pra +1, seguindo o indice do array (0,1,2,3)
		id++;

	}

	public void removeById(int idx) {

		// Index [0,1,/2/,3,4] = 5
		// Id [1,2,/3/,4,5] = 5

		// i recebe id passado -1 (pesquisa de acordo com index do array)
		// enquanto i menor que total restante do array
		for (int i = idx - 1; i < id - 1; i++) {

			System.out.println(i + " i");
			System.out.println(id - 1 + " index -1");
			System.out.println(String.valueOf(cc[i]));
			// Operação grava posições seguintes do array no lugar no index inicial da
			// pesquisa
			cc[i] = cc[i + 1];

		}
		// Diminui tamanho da variavel que distruibi ids e controla o acesso no array
		id--;

	}

	public void updateById(int idx) {
		for (int i = 0; i < id; i++) {
			if (cc[i].getId() == idx) {
				System.out.println("Informe qual atributo alterar:");
				;
				System.out.println("1 - Nome");
				System.out.println("2 - Origem");
				System.out.println("3 - Unidade");
				System.out.println("4 - Preço (ex: 0,99)");
				System.out.println("5 - Fabricante");
				Scanner sc = new Scanner(System.in);
				int op = sc.nextInt();
				switch (op) {
				case 1:
					System.out.println("Informe nome atualizado:");
					sc.nextLine();
					String nome = sc.nextLine();
					cc[i].setNome(nome);

					break;
				case 2:
					System.out.println("Informe origem atualizada:");
					sc.nextLine();
					String origem = sc.nextLine();
					cc[i].setOrigem(origem);

					break;
				case 3:
					System.out.println("Informe quantidade de unidades atualizada:");
					int unidades = sc.nextInt();
					cc[i].setUnidade(unidades);

					break;
				case 4:
					System.out.println("Informe preço atualizado(ex: 1,99):");
					double preco = sc.nextDouble();
					cc[i].setPreco(preco);
					break;
				case 5:
					System.out.println("Informe fabricante atualizada:");
					sc.nextLine();
					String fabricante = sc.nextLine();
					cc[i].setFabricante(fabricante);

					break;
				default:
					System.out.println("Você não informou uma opção válida");
					break;

				}
				System.out.println("Atualizado:");
				System.out.println(cc[i]);
			}
		}
	}

	// Percorre Array por tamanho de Ids cadastrados
	public void getById(int idx) {
		for (int i = 0; i < id; i++) {
			if (cc[i].getId() == idx) {
				System.out.println(cc[i]);
			}
		}
	}

	// E outro, PRIVATIVO(?), que retorne apenas o índice referente à posição no
	// array

	// Percorre Array por tamanho de Ids cadastrados e retorna id-1 (index do array)
	public void getIndex(int idx) {
		for (int i = 0; i < id; i++) {
			if (cc[i].getId() == idx) {
				System.out.println(String.valueOf(cc[i].getId() - 1));
			}
		}
	}

}
