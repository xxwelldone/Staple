package acesso;

import java.util.Scanner;

import operacao.CRUD;
import operacao.Food;



public class Acesso {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		CRUD crud = new CRUD();
		System.out.println("Quantas cadastros?");
		int x = sc.nextInt();
		for (int i = 0; i < x; i++) {

			Food cc = new Food("Laranja", "Brasil", 10, 15.99, "OTS");
			crud.add(cc);
//			System.out.println(cc.getId());
		}
	

//		System.out.println("Quantas cadastros?");
//		int w = sc.nextInt();
//		for (int i = 0; i < w; i++) {
//
//			Food cc = new Food("Melão", "Italia", 10, 10.99, "TTi");
//			crud.add(cc);
////			System.out.println(cc.getId());
//		}
		System.out.println("Informe id: ");
		int id = sc.nextInt();
		crud.getById(id);
//		System.out.println("Informe um id para remover:");
//		int id = sc.nextInt();
//		crud.removeById(id);
//		System.out.println("Informe um index para remover:");
//		crud.getIndex();
//		crud.xx();

//		System.out.println("Informe um id para remover:");
//		int m = sc.nextInt();
//		crud.getbyId(m);

	}

}
