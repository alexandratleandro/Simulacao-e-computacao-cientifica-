

public class Cliente {
// + agora fica assim, ma sdepois temos de distinguir quais vao para gasolina e quais para gasoleo
    private int tipo; // tipo 1= gasolina, tipo 2= gasoleo
    
    Cliente(){
        tipo=setTipo();
    }
    private int setTipo(){
        double var=0;
        //RandomGenerator random = new RandomGenerator();
        var=RandomGenerator.rand(0);
        if(var<0.2){
            return 2;
        }
        else{
            return 1;
        }
    }
    public int getTipo(){
        return tipo;
    }
    
} 