package com.drh.api.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="Employee")
public class Employee {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="nom")
    @Size(max = 15, message="Pas plus de 15 caractères")
    @NotNull(message="Le nom est Obligatoire")
    private String nom;
    @Column(name="prenom")
    @Size(max = 20)
    @NotNull(message="Le prénom est Obligatoire")
    private String prenom;
    
    private int anneedenaissance; 
    private String fonction;
    private String addresse;
    private String email;
    public Employee() {
    }
    public Employee(int id, String nom, String prenom, int anneedenaissance, String fonction, String addresse,
            String email) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.anneedenaissance = anneedenaissance;
        this.fonction = fonction;
        this.addresse = addresse;
        this.email = email;
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
    public int getAnneNaissance() {
        return anneedenaissance;
    }
    public void setAnneNaissance(int anneedenaissance) {
        this.anneedenaissance = anneedenaissance;
    }
    public String getFonction() {
        return fonction;
    }
    public void setFonction(String fonction) {
        this.fonction = fonction;
    }
    public String getAdresse() {
        return addresse;
    }
    public void setAdresse(String addresse) {
        this.addresse = addresse;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    @Override
    public String toString() {
        return "Employee [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", anneedenaissance=" + anneedenaissance
                + ", fonction=" + fonction + ", adresse=" + addresse + ", email=" + email + "]";
    }
	
	

}
