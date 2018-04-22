package fr.sromain.xspeedit.presentation;

import java.util.List;
import java.util.Scanner;

import fr.sromain.xspeedit.modele.Carton;
import fr.sromain.xspeedit.service.IEmpaquetageService;

public class InterfaceHommeMachine {
	private static final String DEFAULT_INPUT = "163841689525773";

	IEmpaquetageService empaquetageService;

	public InterfaceHommeMachine(IEmpaquetageService empaquetageService) {
		super();
		this.empaquetageService = empaquetageService;
	}

	/**
	 * démarre l'interface homme machine
	 */
	public void demarrer() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Entrez une chaine d'articles (par défaut : " + DEFAULT_INPUT +") :");
		String articlesChaine = scanner.nextLine();
		scanner.close();
		if (articlesChaine.length() == 0) {
			articlesChaine = DEFAULT_INPUT;
		}
		List<Carton> cartons = this.empaquetageService.emballerArticles(articlesChaine);
		System.out.println(cartons + " => " + cartons.size() + " cartons utilisés");
		
	}
}
