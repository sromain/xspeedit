package fr.sromain.xspeedit.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import fr.sromain.xspeedit.modele.Article;
import fr.sromain.xspeedit.modele.Carton;
import fr.sromain.xspeedit.service.IEmpaquetageService;

public class EmpaquetageServiceImpl implements IEmpaquetageService {
	/**
	 * {@link fr.sromain.xspeedit.service.IEmpaquetageService#emballerArticles(String)}
	 */
	public List<Carton> emballerArticles(String articlesChaine) {
		List<Article> articles = creerListeArticleDepuisChaine(articlesChaine);
		articles = trierArticlesParTailleDecroissante(articles);
		return emballerArticles(articles);
	}

	/**
	 * crée la liste des cartons à partir d'une liste d'articles
	 * @param articles
	 * @return
	 */
	private List<Carton> emballerArticles(List<Article> articles) {
		List<Carton> cartons = new ArrayList<Carton>();
		while (!articles.isEmpty()) {
			Carton carton = new Carton();
			for (Integer index = 0; index < articles.size(); index++) {
				Article articleCourant = articles.get(index);
				if (carton.getCapaciteCourante() + articleCourant.getTaille() <= Carton.CAPACITE) {
					carton.getArticles().add(articleCourant);
					articles.remove(articleCourant);
					index--;
				}
			}
			cartons.add(carton);
		}
		return cartons;
	}

	/**
	 * crée une liste d'articles à partir d'une chaine de caractere
	 * @param articlesChaine
	 * @return
	 */
	private List<Article> creerListeArticleDepuisChaine(String articlesChaine) {
		List<Article> articles = new ArrayList<Article>();
		for (char caractere: articlesChaine.toCharArray()) {
			try {				
				int taille = Integer.parseInt(String.valueOf(caractere));
				articles.add(new Article(taille));
			} catch (NumberFormatException e) {
				System.out.println("Article ignoré - taille article incorrecte : " + caractere);				
			}
		}
		return articles;
	}

	/**
	 * trie une liste d'article par taille décroissante
	 * @param articlesNonTries
	 * @return
	 */
	private List<Article> trierArticlesParTailleDecroissante(List<Article> articles) {
		Collections.sort(articles, new Comparator<Article>() {
	        public int compare(Article article1, Article article2)
	        {
	            return  article2.getTaille().compareTo(article1.getTaille());
	        }
	    });
		return articles;
	}
}
