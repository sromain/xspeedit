package fr.sromain.xspeedit.service;

import java.util.List;

import fr.sromain.xspeedit.modele.Carton;

public interface IEmpaquetageService {
	/**
	 * cr�e la liste des cartons � partir d'une chaine de caracteres 
	 * @param articles
	 * @return
	 */
	List<Carton> emballerArticles(String articlesChaine);
}
