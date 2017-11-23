
package resumes;

import entites.Client;

public class ResumeClient {

    private Client client;
  
    private Double sommeDevis;
    
    private Long   nbProjets;

    public ResumeClient(Client client, Double sommeDevis, Long nbProjets) {
        this.client = client;
        this.sommeDevis = sommeDevis;
        this.nbProjets = nbProjets;
    }

    //<editor-fold defaultstate="collapsed" desc="gets & sets">
    public Client getClient() {
        return client;
    }
    
    public void setClient(Client client) {
        this.client = client;
    }
    
    public Double getSommeDevis() {
        return sommeDevis;
    }
    
    public void setSommeDevis(Double sommeDevis) {
        this.sommeDevis = sommeDevis;
    }
    
    public Long getNbProjets() {
        return nbProjets;
    }
    
    public void setNbProjets(Long nbProjets) {
        this.nbProjets = nbProjets;
    }
    
    //</editor-fold>
    
  

    
}
