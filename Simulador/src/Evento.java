
public abstract class Evento {
    
	protected double instante;  // Instante de ocorrência do evento
	protected Simulador s;      // Simulador onde ocorre o evento
        protected Servico servico;
	//Construtor
    Evento (double i, Simulador s, Servico servico){
        instante = i;
        this.s = s;
        this.servico = servico;
    }

	// Método que determina se o evento corrente ocorre primeiro, ou não, do que o evento e1
	// Se sim, devolve true; se não, devolve false
	// Usado para ordenar por ordem crescente de instantes de ocorrência a lista de eventos do simulador
    public boolean menor (Evento e1){
        return (instante < e1.instante);
    }

	// Método que executa um evento; a ser definido em cada tipo de evento
    abstract void executa ();

    // Método que devolve o instante de ocorrência do evento
    public double getInstante() {
        return instante;
    }

    public Servico getServico() {
        return servico;
    }
    
}