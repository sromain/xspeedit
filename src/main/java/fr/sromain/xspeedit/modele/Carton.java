package fr.sromain.xspeedit.modele;

import java.util.ArrayList;
import java.util.List;

public class Carton {
	public static final Integer CAPACITE = 10;

	List<Article> articles;
	Integer capaciteCourante;

	public Carton() {
		this.articles = new ArrayList<Article>();
		this.capaciteCourante = 0;
	}

	public Carton(List<Article> articles) {
		this.articles = articles;
		this.capaciteCourante = 0;
		for (Article article : articles) {
			this.capaciteCourante += article.getTaille();
		}
	}

	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}

	public Integer getCapaciteCourante() {
		return this.capaciteCourante;
	}

	public void ajouterArticle(Article article) {
		this.articles.add(article);
		this.capaciteCourante += article.getTaille();
	}

	public String toString() {
		String libelle = "";
		for (Article article : articles) {
			libelle += article.getTaille().toString();
		}
		return libelle; 
	}
}
