package fr.sromain.xspeedit.modele;

import java.util.ArrayList;
import java.util.List;

public class Carton {
	public static final Integer CAPACITE = 10;

	List<Article> articles;

	public Carton() {
		super();
		articles = new ArrayList<Article>();
	}

	public Carton(List<Article> articles) {
		super();
		this.articles = articles;
	}

	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}

	public Integer getCapaciteCourante() {
		Integer capaciteCourante = 0;
		for (Article article : articles) {
			capaciteCourante += article.getTaille();
		}
		return capaciteCourante;
	}

	public String toString() {
		String libelle = "";
		for (Article article : articles) {
			libelle += article.getTaille().toString();
		}
		return libelle; 
	}
}
