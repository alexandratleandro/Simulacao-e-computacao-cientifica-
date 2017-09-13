

public class Aleatorio { 
    // Gera um número segundo uma distribuição exponencial negativa de média m
    static public int flag=0; // indicador se existe algum valor guardado
    static public double v1, v2, w, valor;
    
    static double exponencial (double m){
        return (-m*Math.log(RandomGenerator.rand64(40)));
    }
    /**/
    static double [] normal (double m,double d, int seed){
    	
    	double [] y = new double [2];
                y[0]=-1;
                y[1]=-1;
        
    
    		while(y[0]<0 || y[1]<0){ // enquanto valores negativos
	    		do {
                    v1=2*RandomGenerator.rand64(seed)-1;
                    v2= 2*RandomGenerator.rand64(seed)-1;
    
                    w= Math.pow(v1, 2)+Math.pow(v2, 2);
                } while(w>1);
                    y[0]=v1 * Math.sqrt(-2*Math.log(w)/w);
	        	    y[1]= v2 * Math.sqrt(-2*Math.log(w)/w);
	        	    y[0]=m+y[0]*d; 
	        	    y[1]=m+y[1]*d;	        	    
	        	}
    		
            return y;
    		
    	}  
    }   	 

