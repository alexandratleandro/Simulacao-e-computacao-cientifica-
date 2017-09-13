
public class Chegada extends Evento { 
     
    //Construtor
    Chegada (double i, Simulador s, Servico servico){
        super (i, s, servico); 
    }

	// Método que executa as acções correspondentes à chegada de um cliente
    void executa (){
        // Coloca cliente no serviço - na fila ou a ser atendido, conforme o caso
        Cliente cl= new Cliente();
        // verifica-se o tipo do cliente e coloca-se no servico correto
        if(s.getCenario()==1){
            if(cl.getTipo()==1){
                s.getGasolina().insereServico(cl);
            }
            else{
                s.getGasoleo().insereServico(cl);
            } 
        }
        else{
            s.getSelfService().insereServico(cl);
        }
        
        
        // Agenda nova chegada para daqui a Aleatorio.exponencial(s.media_cheg) instantes
        s.insereEvento (new Chegada(s.getInstante()+Aleatorio.exponencial(s.getMedia_cheg()), s, servico));
    }

    // Método que descreve o evento.
    // Para ser usado na listagem da lista de eventos.
    public String toString(){
        return "Chegada em " + instante;
    } 
}