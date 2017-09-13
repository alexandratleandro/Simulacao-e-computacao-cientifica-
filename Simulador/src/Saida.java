


public class Saida extends Evento {
    private Servico servico;
	//Construtor
	Saida (double i, Simulador s, Servico servico){
		super(i, s, servico);
                this.servico=servico;
    }

	// Método que executa as acções correspondentes à saída de um cliente
    void executa (){
		// Retira cliente do serviço
        servico.removeServico();
    }

    // Método que descreve o evento.
    // Para ser usado na listagem da lista de eventos.
    public String toString(){
         return "Saída em " + instante;
    }


}