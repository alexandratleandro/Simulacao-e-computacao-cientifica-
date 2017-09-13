


public class Saida extends Evento {
    private Servico servico;
	//Construtor
	Saida (double i, Simulador s, Servico servico){
		super(i, s, servico);
                this.servico=servico;
    }

	// M�todo que executa as ac��es correspondentes � sa�da de um cliente
    void executa (){
		// Retira cliente do servi�o
        servico.removeServico();
    }

    // M�todo que descreve o evento.
    // Para ser usado na listagem da lista de eventos.
    public String toString(){
         return "Sa�da em " + instante;
    }


}