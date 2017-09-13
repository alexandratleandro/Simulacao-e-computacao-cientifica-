
//+++++++
//+ Classe que transfere clientes de um evento para outro gasolina/gasoleo para pagamento(?)


 
public class Transfere extends Evento{
    private Servico servico;
    private Cliente cl;
    public Transfere(double i, Simulador s, Servico servico, Cliente cl) {
        super(i, s, servico);
        this.cl = cl;
        this.servico=servico;
    }

    @Override
    void executa() {
        //retirar serviço atual que já foi feito
        Cliente cl = servico.removeServico();        
        //se cliente estiver numa das bombas vai passar para a loja para pagar 
        s.getLoja().insereServico(cl); 
    }
    
}
