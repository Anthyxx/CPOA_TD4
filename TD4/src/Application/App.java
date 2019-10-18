package Application;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import Factory.DAOFactory;
import Outils.Persistance;
import objetMetier.*;


public class App {
	
	public static DAOFactory daos;
	public static boolean premier = true;
	
	
	
public static void lancer() {
		
		if (premier) lancerChoixGestion(false); 
		premier =false;
		int choix;
		Scanner sc = new Scanner(System.in);
		
		
		choix=0;
		
		System.out.println("Choisissez l'unite a gerer :");
		System.out.println("1-Periodicite");
		System.out.println("2-Revues");
		System.out.println("3-Clients");
		System.out.println("4-Abonnements");
		System.out.println("5-Changement de gestionnaire");
		System.out.println("6-Quitter");
		
		
		do {
			choix = sc.nextInt();
		}while ((choix!=1)&&(choix!=2)&&(choix!=3)&&(choix!=4)&&(choix!=5)&&(choix!=6));
		
		switch(choix) {
		case 1:
			lancerPerio();break;
		case 2:
			lancerRevue();break;
		case 3:
			lancerClient();break;
		case 4:
			lancerAbo();break; 
		case 6: System.exit(0);
			break; 
		case 5: lancerChoixGestion(true);
		}
	}
	
	public static void  lancerPerio() {
		
		Scanner sc = new Scanner(System.in);
		int choix;
		int id;
		String lbl;
		Periodicite P;
		
		System.out.println("Periodicite");
		System.out.println("Choisissez l'operation :");
		System.out.println("1-Ajout");
		System.out.println("2-Suppression");
		System.out.println("3-Modification");
		System.out.println("4-Sélection");
		System.out.println("5-Retour");
		
		do {
			choix = sc.nextInt();
		}while ((choix!=1)&&(choix!=2)&&(choix!=3)&&(choix!=4)&&(choix!=5));
		
		switch(choix) {
		case 1:
			System.out.println("Ajout");
			System.out.println("Entrer l'id:");
			id=sc.nextInt();
			System.out.println("Entrer le libelle:");
			lbl=sc.next();
			P = new Periodicite(id,lbl);
			if(daos.getPeriodiciteDAO().create(P)) System.out.println("Opération terminée avec succès");
			else System.out.println("Opération échouée \n");
			lancerPerio(); break;
			
		case 2:
			System.out.println("Suppression");
			System.out.println("Entrer l'id:");
			id=sc.nextInt();
			System.out.println("Entrer le libelle:");
			lbl=sc.next();
			P = new Periodicite(id,lbl);
			//P = new Periodicite(id,"");
			if(daos.getPeriodiciteDAO().delete(P)) System.out.println("Opération terminée avec succès");
			else System.out.println("Opération échouée \n"); 
			lancerPerio(); break;
			
		case 3:
			System.out.println("Modifier");
			System.out.println("Entrer l'id:");
			id=sc.nextInt();
			System.out.println("Entrer le libelle:");
			lbl=sc.next();
			P = new Periodicite(id,lbl);
			if(daos.getPeriodiciteDAO().update(P))System.out.println("Opération terminée avec succès");
			else System.out.println("Opération échouée \n");;
			lancerPerio(); break;
		case 5:
			lancer();break;
			
		case 4: lancerSelectPerio();
		}
	}
	
	public static void lancerRevue() {
		
		Scanner sc = new Scanner(System.in);
		int choix;
		int id;
		String titre;
		String desc;
		double tarif;
		String visuel;
		int perio;
		Revue R;
		
		System.out.println("Revue");
		System.out.println("Choisissez l'opÃ©ration :");
		System.out.println("1-Ajout");
		System.out.println("2-Suppression");
		System.out.println("3-Modification");
		System.out.println("4-Sélection");
		System.out.println("5-Retour");
		
		do {
			choix = sc.nextInt();
		}while ((choix!=1)&&(choix!=2)&&(choix!=3)&&(choix!=4)&&(choix!=5));
		
		switch(choix) {
		case 1:
			System.out.println("Ajout");
			System.out.println("Entrer l'id:");
			id=sc.nextInt();
			System.out.println("Entrer le titre:");
			titre=sc.next();
			System.out.println("Entrer la description:");
			desc=sc.next();
			System.out.println("Entrer le tarif:");
			tarif=sc.nextDouble();
			System.out.println("Entrer le visuel:");
			visuel=sc.next();
			System.out.println("Entrer l'id de periodicite:");
			perio=sc.nextInt();
			R = new Revue(id,titre,desc,tarif,visuel,perio);
			if(daos.getRevueDAO().create(R))System.out.println("Opération terminée avec succès");
			else System.out.println("Opération échouée \n");;
			lancerRevue(); break;
			
		case 2:
			System.out.println("Suppression");
			System.out.println("Entrer l'id:");
			id=sc.nextInt();
			R = new Revue(id,"","",0,"",0);
			if(daos.getRevueDAO().delete(R))System.out.println("Opération terminée avec succès");
			else System.out.println("Opération échouée \n");;
			lancerRevue();break;
			
		case 3:
			System.out.println("Modifier");
			System.out.println("Entrer l'id:");
			id=sc.nextInt();
			System.out.println("Entrer le titre:");
			titre=sc.next();
			System.out.println("Entrer la description:");
			desc=sc.next();
			System.out.println("Entrer le tarif:");
			tarif=sc.nextDouble();
			System.out.println("Entrer le visuel:");
			visuel=sc.next();
			System.out.println("Entrer l'id de periodicite:");
			perio=sc.nextInt();
			R = new Revue(id,titre,desc,tarif,visuel,perio);
			if(daos.getRevueDAO().update(R))System.out.println("Opération terminée avec succès");
			else System.out.println("Opération échouée \n");;
			lancerRevue(); break;
		case 5:
			lancer();break;
		case 4 :
			lancerSelectRevue();break;
		}
		
	}
	
public static void lancerClient() {
		
		Scanner sc = new Scanner(System.in);
		int choix;
		int id;
		String nom;
		String prenom;
		String no_rue;
		String voie;
		String code_postal;
		String ville;
		String pays;
		Client C;
		
		System.out.println("Client");
		System.out.println("Choisissez l'opÃ©ration :");
		System.out.println("1-Ajout");
		System.out.println("2-Suppression");
		System.out.println("3-Modification");
		System.out.println("4-Sélection");
		System.out.println("5-Retour");
		
		do {
			choix = sc.nextInt();
		}while ((choix!=1)&&(choix!=2)&&(choix!=3)&&(choix!=4)&&(choix!=5));
		
		switch(choix) {
		case 1:
			System.out.println("Ajout");
			System.out.println("Entrer l'id:");
			id=sc.nextInt();
			System.out.println("Entrer le nom:");
			nom=sc.next();
			System.out.println("Entrer le prÃ©nom:");
			prenom=sc.next();
			System.out.println("Entrer le nÂ° de rue:");
			no_rue=sc.next();
			System.out.println("Entrer la voie:");
			voie=sc.next();
			System.out.println("Entrer le code postal:");
			code_postal=sc.next();
			System.out.println("Entrer la ville:");
			ville=sc.next();
			System.out.println("Entrer le pays:");
			pays=sc.next();
			C = new Client(id,nom,prenom,no_rue,voie,code_postal,ville,pays);
			if(daos.getClientDAO().create(C))System.out.println("Opération terminée avec succès");
			else System.out.println("Opération échouée \n");;
			lancerClient(); break;
			
		case 2:
			System.out.println("Suppression");
			System.out.println("Entrer l'id:");
			id=sc.nextInt();
			C=new Client(id,"","","","","","","");
			daos.getClientDAO().delete(C);
			lancerClient();break;
		case 3:
			System.out.println("Entrer l'id:");
			id=sc.nextInt();
			System.out.println("Entrer le nom:");
			nom=sc.next();
			System.out.println("Entrer le prÃ©nom:");
			prenom=sc.next();
			System.out.println("Entrer le nÂ° de rue:");
			no_rue=sc.next();
			System.out.println("Entrer la voie:");
			voie=sc.next();
			System.out.println("Entrer le code postal:");
			code_postal=sc.next();
			System.out.println("Entrer la ville:");
			ville=sc.next();
			System.out.println("Entrer le pays:");
			pays=sc.next();
			C = new Client(id,nom,prenom,no_rue,voie,code_postal,ville,pays);
			if(daos.getClientDAO().update(C))System.out.println("Opération terminée avec succès");
			else System.out.println("Opération échouée \n");;
			lancerClient(); break;
		case 5:
			lancer();break;
		case 4:
			lancerSelectClient();
		}
		
	}

public static void  lancerAbo() {
	
	Scanner sc = new Scanner(System.in);
	int choix;
	int id_client;
	int id_revue;
	String date_deb;
	String date_fin;
	Date date_D;
	Date date_F;
	Abonnement A;
	
	System.out.println("Abonnement");
	System.out.println("Choisissez l'opÃ©ration :");
	System.out.println("1-Ajout");
	System.out.println("2-Suppression");
	System.out.println("3-Modification");
	System.out.println("4-Sélection");
	System.out.println("5-Retour");
	
	do {
		choix = sc.nextInt();
	}while ((choix!=1)&&(choix!=2)&&(choix!=3)&&(choix!=4)&&(choix!=5));
	
	switch(choix) {
	case 1:
		System.out.println("Ajout");
		System.out.println("Entrer l'id_client:");
		id_client=sc.nextInt();
		System.out.println("Entrer l'id_revue:");
		id_revue=sc.nextInt();
		System.out.println("Entrer la date de dÃ©but au format AAAA-MM-JJ");
		date_deb = sc.next();
		date_D = Date.valueOf(date_deb);
		System.out.println("Entrer la date de fin au format AAAA-MM-JJ");
		date_fin = sc.next();
		date_F=Date.valueOf(date_fin);
		A=new Abonnement(id_client,id_revue,date_D,date_F);
		if(daos.getAbonnementDAO().create(A))System.out.println("Opération terminée avec succès");
		else System.out.println("Opération échouée \n");;
		lancerAbo(); break;
		
	case 2:
		System.out.println("Suppression");
		System.out.println("Entrer l'id de client:");
		id_client=sc.nextInt();
		System.out.println("Entrer l'id de revue:");
		id_revue=sc.nextInt();
		A=new Abonnement(id_client,id_revue,Date.valueOf(LocalDate.now()),Date.valueOf(LocalDate.now()));
		if(daos.getAbonnementDAO().delete(A))System.out.println("Opération terminée avec succès");
		else System.out.println("Opération échouée \n");;
		lancerAbo();break;
	case 3:
		System.out.println("Modifier");
		System.out.println("Entrer l'id_client:");
		id_client=sc.nextInt();
		System.out.println("Entrer l'id_revue:");
		id_revue=sc.nextInt();
		System.out.println("Entrer la date de dÃ©but au format AAAA-MM-JJ");
		date_deb = sc.next();
		date_D = Date.valueOf(date_deb);
		System.out.println("Entrer la date de fin au format AAAA-MM-JJ");
		date_fin = sc.next();
		date_F=Date.valueOf(date_fin);
		A=new Abonnement(id_client,id_revue,date_D,date_F);
		if(daos.getAbonnementDAO().update(A))System.out.println("Opération terminée avec succès");
		else System.out.println("Opération échouée \n");;
		lancerAbo(); break;
	case 5:
		lancer();break;
	case 4 :
		lancerSelectAbo();
	}
}

public static void lancerChoixGestion(boolean Renvoie) {
	int choix;
	Scanner sc = new Scanner(System.in);
	System.out.println("Choisissez le mode de gestion :");
	System.out.println("1-MySQL");
	System.out.println("2-Liste MÃ©moire");
	do {
		choix = sc.nextInt();
	}while ((choix!=1)&&(choix!=2));
	
	switch(choix) {
	case 1:
		 daos=DAOFactory.getDAOFactory(Persistance.MySQL);
		 System.out.print("MySQL séléctionné \n");break;
	case 2:
		 daos=DAOFactory.getDAOFactory(Persistance.ListeMemoire);
		 System.out.print("Liste Mémoire séléctionné \n");break;
	}
	if(Renvoie) lancer();
}

public static void lancerSelectPerio() {
	Scanner sc = new Scanner(System.in);
	int choix;
	int id;
	String lbl;
	Periodicite P;
	ArrayList<Periodicite> Ps;
	
	System.out.println("Sélection périodicité");
	System.out.println("1-Par Id");
	System.out.println("2-Par libelle");
	System.out.println("3-Retour");
	
	do {
		choix = sc.nextInt();
	}while ((choix!=1)&&(choix!=2)&&(choix!=3));
	
	switch(choix) {
	case 1:
		System.out.println("Par Id");
		System.out.println("Entrer l'id:");
		id=sc.nextInt();
		P = daos.getPeriodiciteDAO().getById(id);
		if (P!=null)System.out.print(P.toString());
		System.out.print("Sélection terminée");
		lancerSelectPerio(); break;
		
	case 2:
		System.out.println("Par libellé");
		System.out.println("Entrer le libellÃ©:");
		lbl=sc.next();
		Ps = daos.getPeriodiciteDAO().getByLibelle(lbl);
		if(Ps!=null) {
		for(Periodicite p : Ps) {
			System.out.print(p.toString()+"\n");
		}
		}
		System.out.print("Sélection terminée \n");
		lancerSelectPerio(); break;
		
	case 3:
		lancerPerio(); break;
	
		

	}
	
}

public static void lancerSelectClient() {
	Scanner sc = new Scanner(System.in);
	int choix;
	int id;
	String str;
	Client C;
	ArrayList<Client> Cs;
	
	System.out.println("Sélection client");
	System.out.println("1-Par Id");
	System.out.println("2-Par nom");
	System.out.println("3-Par ville");
	System.out.println("4-Par code postal");
	System.out.println("5-Par pays");
	System.out.println("6-Retour");
	
	do {
		choix = sc.nextInt();
	}while ((choix!=1)&&(choix!=2)&&(choix!=3)&&(choix!=4)&&(choix!=5)&&(choix!=6));
	
	switch(choix) {
	case 1:
		System.out.println("Par Id");
		System.out.println("Entrer l'id:");
		id=sc.nextInt();
		C = daos.getClientDAO().getById(id);
		if (C!=null)System.out.print(C.toString());
		System.out.print("Sélection terminée");
		lancerSelectClient(); break;
		
	case 2:
		System.out.println("Par nom");
		System.out.println("Entrer le nom:");
		str=sc.next();
		Cs = daos.getClientDAO().getByNom(str);
		if(Cs!=null) {
		for(Client c : Cs) {
			System.out.print(c.toString()+"\n");
		}
		}
		System.out.print("Sélection terminée \n");
		lancerSelectClient(); break;
		
	case 3:
		System.out.println("Par ville");
		System.out.println("Entrer la ville:");
		str=sc.next();
		Cs = daos.getClientDAO().getByVille(str);
		if(Cs!=null) {
		for(Client c : Cs) {
			System.out.print(c.toString()+"\n");
		}
		}
		System.out.print("Sélection terminée \n");
		lancerSelectClient(); break;
		
	case 4:
		System.out.println("Par code postal");
		System.out.println("Entrer le code postal:");
		str=sc.next();
		Cs = daos.getClientDAO().getByCode_postal(str);
		if(Cs!=null) {
		for(Client c : Cs) {
			System.out.print(c.toString()+"\n");
		}
		}
		System.out.print("Sélection terminée \n");
		lancerSelectClient(); break;
		
	case 5: 
		System.out.println("Par pays");
		System.out.println("Entrer le pays:");
		str=sc.next();
		Cs = daos.getClientDAO().getByPays(str);
		if(Cs!=null) {
		for(Client c : Cs) {
			System.out.print(c.toString()+"\n");
		}
		}
		System.out.print("Sélection terminée \n");
		lancerSelectClient(); break;
	case 6: lancerClient();
	}
	
}

public static void lancerSelectRevue() {
	Scanner sc = new Scanner(System.in);
	int choix;
	int id;
	String str;
	double dbl;
	Revue R;
	ArrayList<Revue> Rs;
	
	System.out.println("Sélection revue");
	System.out.println("1-Par Id");
	System.out.println("2-Par periodicite");
	System.out.println("3-Par tarif");
	System.out.println("4-Par titre");
	System.out.println("5-Retour");
	
	do {
		choix = sc.nextInt();
	}while ((choix!=1)&&(choix!=2)&&(choix!=3)&&(choix!=4)&&(choix!=5));
	
	switch(choix) {
	case 1:
		System.out.println("Par Id");
		System.out.println("Entrer l'id:");
		id=sc.nextInt();
		R = daos.getRevueDAO().getById(id);
		if (R!=null)System.out.print(R.toString());
		System.out.print("Sélection terminée");
		lancerSelectRevue(); break;
		
	case 2:
		System.out.println("Par periodicite");
		System.out.println("Entrer l id de periodicite:");
		id=sc.nextInt();
		Rs = daos.getRevueDAO().getById_periodicite(id);
		if(Rs!=null) {
		for(Revue r : Rs) {
			System.out.print(r.toString()+"\n");
		}
		}
		System.out.print("Sélection terminée \n");
		lancerSelectRevue(); break;
		
	case 3:
		System.out.println("Par tarif");
		System.out.println("Entrer le tarif:");
		dbl=sc.nextDouble();
		Rs = daos.getRevueDAO().getByTarif_numero(dbl);
		if(Rs!=null) {
		for(Revue r : Rs) {
			System.out.print(r.toString()+"\n");
		}
		}
		System.out.print("Sélection terminée \n");
		lancerSelectRevue(); break;
		
	case 4:
		System.out.println("Par titre");
		System.out.println("Entrer le titre:");
		str=sc.next();
		Rs = daos.getRevueDAO().getByTitre(str);
		if(Rs!=null) {
		for(Revue r : Rs) {
			System.out.print(r.toString()+"\n");
		}
		}
		System.out.print("Sélection terminée \n");
		lancerSelectRevue(); break;
		
	case 5: 
		lancerRevue();
	}
	
}

public static void lancerSelectAbo() {
	Scanner sc = new Scanner(System.in);
	int choix;
	int id1;
	int id2;
	Date date;
	Abonnement A;
	ArrayList<Abonnement> As;
	
	System.out.println("Sélection abonnement");
	System.out.println("1-Par Id Client et Id Revue");
	System.out.println("2-Par Id Client");
	System.out.println("3-Par Id Revue");
	System.out.println("4-Par date de début");
	System.out.println("5-Par date de fin");
	System.out.println("6-Retour");
	
	do {
		choix = sc.nextInt();
	}while ((choix!=1)&&(choix!=2)&&(choix!=3)&&(choix!=4)&&(choix!=5)&&(choix!=6));
	
	switch(choix) {
	case 1:
		System.out.println("Par Id Client et Id Revue");
		System.out.println("Entrer l'id Client:");
		id1=sc.nextInt();
		System.out.println("Entrer l'id Revue:");
		id2=sc.nextInt();
		A = daos.getAbonnementDAO().getById(id1,id2);
		if (A!=null)System.out.print(A.toString());
		System.out.print("Sélection terminée");
		lancerSelectAbo(); break;
		
	case 2:
		System.out.println("Par Id Client");
		System.out.println("Entrer l id Client:");
		id1=sc.nextInt();
		As = daos.getAbonnementDAO().getById_client(id1);
		if(As!=null) {
		for(Abonnement a : As) {
			System.out.print(a.toString()+"\n");
		}
		}
		System.out.print("Sélection terminée \n");
		lancerSelectAbo(); break;
		
	case 3:
		System.out.println("Par Id Revue");
		System.out.println("Entrer l id Revue:");
		id1=sc.nextInt();
		As = daos.getAbonnementDAO().getById_revue(id1);
		if(As!=null) {
		for(Abonnement a : As) {
			System.out.print(a.toString()+"\n");
		}
		}
		System.out.print("Sélection terminée \n");
		lancerSelectAbo(); break;
		
	case 4:
		System.out.println("Par date de début");
		System.out.println("Entrer la date de dÃ©but au format AAAA-MM-JJ");
		date = Date.valueOf(sc.next());
		As = daos.getAbonnementDAO().getByDate_deb(date);
		if(As!=null) {
		for(Abonnement a : As) {
			System.out.print(a.toString()+"\n");
		}
		}
		System.out.print("Sélection terminée \n");
		lancerSelectAbo(); break;
	case 5:
		System.out.println("Par date de fin");
		System.out.println("Entrer la date de fin au format AAAA-MM-JJ");
		date = Date.valueOf(sc.next());
		As = daos.getAbonnementDAO().getByDate_fin(date);
		if(As!=null) {
		for(Abonnement a : As) {
			System.out.print(a.toString()+"\n");
		}
		}
		System.out.print("Sélection terminée \n");
		lancerSelectAbo(); break;
		
	case 6: 
		lancerAbo();
	}
	
}
}
