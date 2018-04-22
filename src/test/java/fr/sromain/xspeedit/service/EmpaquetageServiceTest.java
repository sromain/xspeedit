package fr.sromain.xspeedit.service;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import fr.sromain.xspeedit.modele.Article;
import fr.sromain.xspeedit.modele.Carton;
import fr.sromain.xspeedit.service.impl.EmpaquetageServiceImpl;

public class EmpaquetageServiceTest {
	IEmpaquetageService empaquetageService;

	@Before
	public void implementerService() {
		empaquetageService = new EmpaquetageServiceImpl();
	}

	@Test
	public void emballerArticlesOK() {
		List<Carton> cartons = empaquetageService.emballerArticles("163841689525773");
		Assert.assertEquals("La liste doit contenir 8 cartons", 8, cartons.size());
	}

	@Test
	public void emballerArticlesListeVide() {
		List<Carton> cartons = empaquetageService.emballerArticles("");
		Assert.assertEquals("La liste doit contenir 0 cartons", 0, cartons.size());
	}
}
