package MenuInscri;

import commandLineMenus.Action;
import commandLineMenus.Menu;
import commandLineMenus.Option;
import commandLineMenus.rendering.examples.util.InOut;
import commandLineMenus.*;
import commandLineMenus.rendering.examples.util.InOut;


public class Menus {

	static Menu getMainMenu()
	{
		Menu mainMenu = new Menu("Main Menu");
		
		mainMenu.add(getPersonneMenu());
		mainMenu.add(getCompetitionMenu());
		mainMenu.add(getEquipeMenu());
		mainMenu.addQuit("q");
		return mainMenu;
	}
	
    static Menu getPersonneMenu()
	{
		Menu personneMenu = new Menu("Personne Menu", "Gérer personne", "gp");
		personneMenu.add(getManaPersonneOption());
		personneMenu.add(getModPersonneOption());
		personneMenu.add(getAddPersonneOption());
		personneMenu.add(getDelPersonneOption());
		personneMenu.addBack("r");;
		personneMenu.setAutoBack(true);
		return personneMenu;
	}
    
    static Option getManaPersonneOption()
    {
        return new Option("Afficher", "af", getAffPersonneAction());
    }
    
    static Option getModPersonneOption()
    {
        return new Option("Modifier", "m", getModPersonneAction());
    }    
    
    static Option getAddPersonneOption()
    {
        return new Option("Ajouter", "ad", getAddPersonneAction());
    }
    
    static Option getDelPersonneOption()
    {
        return new Option("Supprimer", "s", getDelPersonneAction());
    }
	
	static Action getAffPersonneAction()
	{
		return new Action()
		{
			public void optionSelected()
			{
				System.out.println("liste de personne : - ...");				
				// boucle affichant liste des personnes
			}
		};
	}
	
	static Action getModPersonneAction()
	{
		return new Action()
		{
			public void optionSelected()
			{
				System.out.println("Quel modif ?");				
				// requete pour modifier une personne
			}
		};
    }    

	
	static Action getAddPersonneAction()
	{
		return new Action()
		{
			public void optionSelected()
			{
				System.out.println("Qui ajouter ?");				
				// requete pour ajouter une personne
			}
		};
    }    

	
	static Action getDelPersonneAction()
	{
		return new Action()
		{
			public void optionSelected()
			{
				System.out.println("Qui supprimer ?");				
				// requete pour supprimer une personne
			}
		};
    }    
	
    static Menu getCompetitionMenu()
	{
		Menu competitionMenu = new Menu("competition Menu", "Gérer competition", "gc");
		competitionMenu.add(getManacompetitionOption());
		competitionMenu.add(getModcompetitionOption());
		competitionMenu.add(getAddcompetitionOption());
		competitionMenu.add(getDelcompetitionOption());
		competitionMenu.addBack("r");;
		competitionMenu.setAutoBack(true);
		return competitionMenu;
	}
    
    static Option getManacompetitionOption()
    {
        return new Option("Afficher", "af", getAffcompetitionAction());
    }
    
    static Option getModcompetitionOption()
    {
        return new Option("Modifier", "m", getModcompetitionAction());
    }    
    
    static Option getAddcompetitionOption()
    {
        return new Option("Ajouter", "ad", getAddcompetitionAction());
    }
    
    static Option getDelcompetitionOption()
    {
        return new Option("Supprimer", "s", getDelcompetitionAction());
    }
	
	static Action getAffcompetitionAction()
	{
		return new Action()
		{
			public void optionSelected()
			{
				System.out.println("liste de competition : - ...");				
				// boucle affichant liste des competitions
			}
		};
	}
	
	static Action getModcompetitionAction()
	{
		return new Action()
		{
			public void optionSelected()
			{
				System.out.println("Quel modif ?");				
				// requete pour modifier une competition
			}
		};
    }    

	
	static Action getAddcompetitionAction()
	{
		return new Action()
		{
			public void optionSelected()
			{
				System.out.println("Qui ajouter ?");				
				// requete pour ajouter une competition
			}
		};
    }    

	
	static Action getDelcompetitionAction()
	{
		return new Action()
		{
			public void optionSelected()
			{
				System.out.println("Qui supprimer ?");				
				// requete pour supprimer une competition
			}
		};
    }    
	
    static Menu getEquipeMenu()
	{
		Menu equipeMenu = new Menu("equipe Menu", "Gérer equipe", "ge");
		equipeMenu.add(getManaequipeOption());
		equipeMenu.add(getModequipeOption());
		equipeMenu.add(getAddequipeOption());
		equipeMenu.add(getDelequipeOption());
		equipeMenu.addBack("r");;
		equipeMenu.setAutoBack(true);
		return equipeMenu;
	}
    
    static Option getManaequipeOption()
    {
        return new Option("Afficher", "af", getAffequipeAction());
    }
    
    static Option getModequipeOption()
    {
        return new Option("Modifier", "m", getModequipeAction());
    }    
    
    static Option getAddequipeOption()
    {
        return new Option("Ajouter", "ad", getAddequipeAction());
    }
    
    static Option getDelequipeOption()
    {
        return new Option("Supprimer", "s", getDelequipeAction());
    }
	
	static Action getAffequipeAction()
	{
		return new Action()
		{
			public void optionSelected()
			{
				System.out.println("liste de equipe : - ...");				
				// boucle affichant liste des equipes
			}
		};
	}
	
	static Action getModequipeAction()
	{
		return new Action()
		{
			public void optionSelected()
			{
				System.out.println("Quel modif ?");				
				// requete pour modifier une equipe
			}
		};
    }    

	
	static Action getAddequipeAction()
	{
		return new Action()
		{
			public void optionSelected()
			{
				System.out.println("Qui ajouter ?");				
				// requete pour ajouter une equipe
			}
		};
    }    

	
	static Action getDelequipeAction()
	{
		return new Action()
		{
			public void optionSelected()
			{
				System.out.println("Qui supprimer ?");				
				// requete pour supprimer une equipe
			}
		};
    }    

	public static void main(String[] args)
	{
		Menu menu = getMainMenu();
		menu.start();
	}
	

	
}
