
package resumes;

import entites.Fonction;

public class ResumeFonction {

    private Fonction fonction;
    
    Double   moyenne;
    
    Long     nbSalaries;

    public ResumeFonction(Fonction fonction, Double moyenne, Long nbSalaries) {
        this.fonction = fonction;
        this.moyenne = moyenne;
        this.nbSalaries = nbSalaries;
    }
    
    
    //<editor-fold defaultstate="collapsed" desc="Get Set">
    
    public Fonction getFonction() {
        return fonction;
    }
    
    public void setFonction(Fonction fonction) {
        this.fonction = fonction;
    }
    
    public Double getMoyenne() {
        return moyenne;
    }
    
    public void setMoyenne(Double moyenne) {
        this.moyenne = moyenne;
    }
    
    public Long getNbSalaries() {
        return nbSalaries;
    }
    
    public void setNbSalaries(Long nbSalaries) {
        this.nbSalaries = nbSalaries;
    }
    //</editor-fold>
   
    
}
