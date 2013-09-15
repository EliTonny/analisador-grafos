package analisadorgrafos.model;

/**
 *
 * @author Eli T. de Souza
 */
public abstract class Modelo {
    private int id;
    private static int idGeral = 0;
    
    public Modelo(){
        idGeral++;
        this.id = idGeral;
    }
    
    public int getId(){
        return this.id;
    }
    
    @Override
    public boolean equals(Object o){
        if (o instanceof Modelo){
            return ((Modelo) o).getId() == this.getId();
        }
        return false;
    }
}
