package fr.sromain.xspeedit.service;

import java.util.List;

import fr.sromain.xspeedit.modele.Carton;

public interface IEmpaquetageService {
	/**
	 * crée la liste des cartons à partir d'une chaine de caracteres 
	 * @param articles
	 * @return
	 */
	List<Carton> emballerArticles(String articlesChaine);
}
