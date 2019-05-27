package inscriptions;

import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.Entity;
import javax.persistence.FetchType;

import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.SortNatural;

import hibernate.passerelle;

/**
 * Représente une personne physique pouvant s'inscrire à une compétition.
 */

@Entity
public class Personne extends Candidat
{
	private static final long serialVersionUID = 4434646724271327254L;
	private String prenom, mail;


	@OneToMany(targetEntity=Personne.class, mappedBy = "equipes", fetch=FetchType.EAGER)
	@Cascade(value= { CascadeType.ALL })

	@SortNatural
	private Set<Equipe> equipes;
	
	
	Personne(Inscriptions inscriptions, String nom, String prenom, String mail)
	{
		super(inscriptions, nom);
		this.prenom = prenom;
		this.mail = mail;
		equipes = new TreeSet<>();
	}
	
	Personne()
	{
		
	}

	/**
	 * Retourne le prénom de la personne.
	 * @return
	 */
	
	public String getPrenom()
	{
		return prenom;
	}

	/**
	 * Modifie le prénom de la personne.
	 * @param prenom
	 */
	
	public void setPrenom(String prenom)
	{
		this.prenom = prenom;
	}

	/**
	 * Retourne l'adresse électronique de la personne.
	 * @return
	 */
	
	public String getMail()
	{
		return mail;
	}

	/**
	 * Modifie l'adresse électronique de la personne.
	 * @param mail
	 */
	
	public void setMail(String mail)
	{
		this.mail = mail;
	}

	/**
	 * Retoure les équipes dont cette personne fait partie.
	 * @return
	 */
	
	public Set<Equipe> getEquipes()
	{
		return Collections.unmodifiableSet(equipes);
	}

	/**
	 * Ajoute une équipe à une personne
	 * @param equipe
	 */
	
	boolean add(Equipe equipe)
	{
		equipes.add(equipe);
		passerelle.save(equipe);
		return equipes.add(equipe);
	}

	/**
	 * Supprimer une équipe à une personne
	 * @param equipe
	 */

	boolean remove(Equipe equipe)
	{
		return equipes.remove(equipe);
	}

	/**
	 * Supprime une personne de toutes les équipes.
	 */
	
	public void delete()
	{
		super.delete();
		for (Equipe e : equipes)
			e.remove(this);
	}
//	
//	@Override
//	public String toString()
//	{
//		return super.toString() + " membre de " + equipes.toString();
//	}
//	
	
	@Override
	public String toString() {
		int id = getId();
		String prenom = getPrenom();
		String nom = getNom();
		//String equipe = equipes.toString();
		String email = getMail();
		String resultat;
		//if (equipe.equals("") || equipe == null) {
			if (email.equals("") || email == null)
				resultat = id + ". " + prenom + " " + nom
						+ " n'est membre d'aucune équipe. Il n'a pas souhaité communiquer son adresse-email.";
			else
				resultat = id + ". " + prenom + " " + nom + " n'est membre d'aucune équipe. Son adresse e-mail est: "
						+ email + ".";
//		} else {
//			if (email.equals("") || email == null)
//				resultat = id + ". " + prenom + " " + nom + " est membre de l'équipe " + "\"" + equipe
//						+ "\". Il n'a pas souhaité communiquer son adresse-email.";
//			else
//				resultat = id + ". " + prenom + " " + nom + " est membre de l'équipe " + "\"" + equipe
//						+ "\". Son adresse e-mail est: " + email;
//		}
		return resultat;
	}
		
}
