package models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.jdbc.*;


public class Personne {
private int id;
private String nom;
private String prenom;
private int age;
private String cin;





public Personne() {
	
}

public Personne(String nom, String prenom, int age, String cin) {
	
	
	this.nom = nom;
	this.prenom = prenom;
	this.age = age;
	this.cin = cin;
}

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getNom() {
	return nom;
}
public void setNom(String nom) {
	this.nom = nom;
}
public String getPrenom() {
	return prenom;
}
public void setPrenom(String prenom) {
	this.prenom = prenom;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public String getCin() {
	return cin;
}
public void setCin(String cin) {
	this.cin = cin;
}

@Override
public String toString() {
	return "id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", age=" + age + ", cin=" + cin ;
}
public static void getAll() {
	
	try {
		Statement stm=(Statement) Connexion.connect().createStatement();
		ResultSet result=stm.executeQuery("select * from personnes");
		 ResultSetMetaData rsmd= (ResultSetMetaData) result.getMetaData();
		 while(result.next()) {
			 for (int i=1;i<=rsmd.getColumnCount();i++) {
				 System.out.print(" "+result.getObject(i).toString()+" ");
			 }
			 System.out.println("\n");
		 }
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
	
}
public static void insert() {
	String nom,prenom,cin;
	int age;
	Scanner s=new Scanner (System.in);
	System.out.println("donner votre cin : ");
	cin=s.nextLine();
	System.out.println("donner votre nom : ");
	nom=s.nextLine();
	System.out.println("donner votre prenom : ");
	prenom=s.nextLine();
	System.out.println("donner votre age: ");
	age=s.nextInt();
	try {
		Statement stm=(Statement) Connexion.connect().createStatement();
		int result=stm.executeUpdate("insert into personnes values(Null,'"+nom+"','"+prenom+"',"+age+",'"+cin+"')");
		if (result==1)
		 System.out.println("personne inserer");
		else
			System.out.println("erreur requete");
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
	
	
}
public static void update() {
	Scanner s = new Scanner(System.in);
	String cin,nom,prenom;
	int age;
	System.out.println("donner votre cin : ");
	cin=s.nextLine();
	System.out.println("donner votre nom : ");
	nom=s.nextLine();
	System.out.println("donner votre prenom : ");
	prenom=s.nextLine();
	System.out.println("donner votre age: ");
	age=s.nextInt();
	
	try {
		Statement stm=(Statement) Connexion.connect().createStatement();
		
		int result=stm.executeUpdate("update personnes set nom='"+nom+"',prenom='"+prenom+"',age="+age+" where cin='"+cin+"'");
		if (result==1)
		 System.out.println("personne mis a jour");
		else
			System.out.println("erreur requete");
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
	
	
	
}
public static void delete() {
	Scanner s = new Scanner(System.in);
	String cin;
	
	System.out.println("donner votre cin : ");
	cin=s.nextLine();
	
	
	try {
		Statement stm=(Statement) Connexion.connect().createStatement();
		
		int result=stm.executeUpdate(" delete from personnes where cin='"+cin+"'");
		if (result==1)
		 System.out.println("c bon tfassakh!");
		else
			System.out.println("erreur requete");
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
	
	
	
}

}
