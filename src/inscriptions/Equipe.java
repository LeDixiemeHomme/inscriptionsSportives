package inscriptions;

import java.util.Collections;
import java.util.SortedSet;
import java.util.TreeSet;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.SortNatural;

import hibernate.passerelle;

/**
 * Repr�sente une Equipe. C'est-�-dire un ensemble de personnes pouvant 
 * s'inscrire � une comp�tition.
 * 
 */

@Entity
public class Equipe extends Candidat
{
	private static final long serialVersionUID = 4147819927233466035L;
	
	@ManyToMany
	@Cascade(value = { CascadeType.ALL })
	@SortNatural
	private SortedSet<Personne> membres = new TreeSet<>();
		
	Equipe(Inscriptions inscriptions, String nom)
	{
		super(inscriptions, nom);
	}
	
	Equipe()
	{
		
	}

	/**
	 * Retourne l'ensemble des personnes formant l'�quipe.
	 */
	
	public SortedSet<Personne> getMembres()
	{
		return Collections.unmodifiableSortedSet(membres);
	}
	
	/**
	 * Ajoute une personne dans l'�quipe.
	 * @param membre
	 * @return
	 */

	public boolean add(Personne membre)
	{
		membre.add(this);
		return membres.add(membre);
	}

	/**
	 * Supprime une personne de l'�quipe. 
	 * @param membre
	 * @return
	 */
	
	public boolean remove(Personne membre)
	{
		membre.remove(this);	
		return membres.remove(membre);
	}
	
	@Override
	public void delete()
	{
		super.delete();
	}
	
	@Override
    public String toString() {
    	if(getCompetitions().size() > 1)
    		return "L'�quipe "+getNom()+" est inscrite aux comp�titions "+getCompetitions() + "\n";
    	else
    		return "L'�quipe "+getNom()+" est inscrite � la comp�tition "+getCompetitions() + "\n";
    	
    }
}
