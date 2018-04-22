package fr.sromain.xspeedit;

import fr.sromain.xspeedit.presentation.InterfaceHommeMachine;
import fr.sromain.xspeedit.service.impl.EmpaquetageServiceImpl;

public class Main {
	public static void main(String[] args) {
		InterfaceHommeMachine ihm = new InterfaceHommeMachine(new EmpaquetageServiceImpl());
		ihm.demarrer();
	}
}
