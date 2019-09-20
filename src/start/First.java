package start;

import java.util.Scanner;

import models.Personne;

public class First {

	public static void main(String[] args) {
		Scanner s =new Scanner(System.in);
		String nom,prenom,cin;
		int age;
		int choix,choixx;
		do {
		do {
		System.out.println("ajouter une personne");
		System.out.println("modifier une personne");
		System.out.println("supprimer une personne");
		System.out.println("Afficher tous");
	    System.out.println(" donner votre choix");
	    choix=s.nextInt();
		}while (choix<1||choix>4);
		switch(choix) {
		case 1:
			Personne.insert();
			break;
		case 2:
			Personne.update();
			break;
		case 3:
			Personne.delete();
			break;
		case 4:
			Personne.getAll();
			break;
			default: System.out.println("choix invalide!!");
		}
		System.out.println("tapez 0 pour revenir au menu des choix");
		choixx=s.nextInt();
		}while(choixx==0);
	}

}
