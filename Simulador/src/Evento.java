
public abstract class Evento {
    
	protected double instante;  // Instante de ocorr�ncia do evento
	protected Simulador s;      // Simulador onde ocorre o evento
        protected Servico servico;
	//Construtor
    Evento (double i, Simulador s, Servico servico){
        instante = i;
        this.s = s;
        this.servico = servico;
    }

	// M�todo que determina se o evento corrente ocorre primeiro, ou n�o, do que o evento e1
	// Se sim, devolve true; se n�o, devolve false
	// Usado para ordenar por ordem crescente de instantes de ocorr�ncia a lista de eventos do simulador
    public boolean menor (Evento e1){
        return (instante < e1.instante);
    }

	// M�todo que executa um evento; a ser definido em cada tipo de evento
    abstract void executa ();

    // M�todo que devolve o instante de ocorr�ncia do evento
    public double getInstante() {
        return instante;
    }

    public Servico getServico() {
        return servico;
    }
    
}