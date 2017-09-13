

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Simulador extends JFrame{
	
    public JPanel jp = new JPanel() ;
	 
    String resultados;

    // Relógio de simulação - variável que contém o valor do tempo em cada instante
    private double instante;
    //+ tempo de simulaçao desejavel;
    private double tempoS;
    // Médias das distribuições de chegadas e de atendimento no serviço
    private double media_cheg;  
    // Serviço - pode haver mais do que um num simulador
    private Servico loja;
    private Servico gasoleo;
    private Servico gasolina;
    private Servico selfService;
    // Lista de eventos - onde ficam registados todos os eventos que vão ocorrer na simulação
    // Cada simulador só tem uma
    private ListaEventos lista;
    private int cenario; // 1 - tres servicos

    // Construtor
    public Simulador(int cenario, int tempo, double media_cheg, double m_servLoja, double desvioLoja,double m_servGasolina, double desvioGasolina,double m_servGasoleo, double desvioGasoleo, int funcL, int funcGasoleo, int funcGasolina ) {   	
    	this.cenario=cenario;
    	// Inicialização de parâmetros do simulador
        this.media_cheg = media_cheg; 
        //n_clientes = 100;
        this.tempoS=tempo;
        // Inicialização do relógio de simulação
        instante = 0;
        // Criação do serviço 
        lista = new ListaEventos(this);
        if(cenario==1){
            loja = new Servico (this,funcL,"LOJA", m_servLoja, desvioLoja, 50);
            gasolina = new Servico (this,funcGasolina,"GASOLINA", m_servGasolina, desvioGasolina, 10);
            gasoleo = new Servico (this,funcGasoleo,"GASOLEO", m_servGasoleo, desvioGasoleo, 30);
            insereEvento (new Chegada(instante, this, gasolina));  
        }
        else{ 
            // postos corresponde ao numero de funcionarios loja
            selfService = new Servico (this,funcL,"SELFSERVICE", m_servLoja, desvioLoja, 30);
            insereEvento (new Chegada(instante, this, selfService)); 
        }                
       
        // + lista de eventos so uma
        // Agendamento da primeira chegada
        // Se não for feito, o simulador não tem eventos para simular
        
        	
        
                 
    }

        // programa principal
        public static void main(String[] args) {
            // Cria um simulador e
            //+ instante esta em que unidade??        	
            Interf inte = new Interf();    
        } 

    // Método que insere o evento e1 na lista de eventos
	void insereEvento (Evento e1){
            lista.insereEvento (e1);
	}

    // Método que actualiza os valores estatísticos do simulador
	private void act_stats(){
            if(cenario==1){
                loja.act_stats();
                gasolina.act_stats();
                gasoleo.act_stats();
            }
            else{
                selfService.act_stats();
            }
	}

    // Método que apresenta os resultados de simulação finais
	private void relat (){
            resultados="";
            /*System.out.println();
            System.out.println("------- Resultados finais -------");
            System.out.println();*/
           // resultados+="Despesa:"+String.format("%.1f" , getDespesas())+" Receita:"+String.format("%.1f" , getReceitas())+"\n";
           // resultados+= "BALANÇO: "+String.format("%.1f" , getLucro())+"\n";
            resultados+=String.format("Despesas: %.1f€" , getDespesas())+String.format("   Receita: %.1f€" , getReceitas())+"\n";            
            resultados+= String.format("BALANÇO: %.1f€" , getLucro())+"\n\n"; 
            if(cenario==1){
                resultados= resultados+""+gasolina.relat();
                resultados= resultados+""+gasoleo.relat();            
                resultados= resultados+""+loja.relat();
                gasolina.act_stats();
                gasoleo.act_stats();
            }
            else{
                resultados= resultados+""+selfService.relat();
                selfService.act_stats();
            }        
	}

    // Método executivo do simulador     
	public void executa (Interf inte){
            Evento e1;
            // Enquanto não atender todos os clientes 
             //+ ciclo corre durante o tempo de execucao definido em cima         
            while (instante< tempoS){ 
            //	lista.print();  // Mostra lista de eventos - desnecessário; é apenas informativo
                e1 = (Evento)(lista.removeFirst());  // Retira primeiro evento (é o mais iminente) da lista de eventos
                instante = e1.getInstante();        // Actualiza relógio de simulação
                act_stats();                       // Actualiza valores estatísticos
                e1.executa();                 // Executa evento  
            };
            relat();  // Apresenta resultados de simulação finais
            inte.resultados=resultados;
	}

    // Método que devolve o instante de simulação corrente
    public double getInstante() {
        return instante;
    }

    // Método que devolve a média dos intervalos de chegada
    public double getMedia_cheg() {
        return media_cheg;
    }   
    public double getReceitas(){
    	// calcula receitas resultantes dos clientes que usaram a estção de serviço
    	double money=0; 
    	if(cenario==1){
    		money=loja.getAtendidos()*1.5;
    	}
    	else{
    		money = selfService.getAtendidos()*1.5;
    	}
    	return money;
    }
    public double getDespesas(){
    	double salarios=0;
		double mes =tempoS/60/24/30;		
		int funcs=0;
		
    	if(cenario==1){
    		funcs= 3*(loja.getFuncionarios()+ gasolina.getFuncionarios()+ gasoleo.getFuncionarios());
    		
    	}
    	else{ 
    		funcs=3* 2;
    	}   
    	salarios = 500*mes*funcs;
    	return salarios;
    }
    public double getLucro(){
    	double saldo=0;
    	double investimento=30000;
    	if(cenario!=1){
    		investimento*=3.5;
    	}
    	saldo=getReceitas()-(getDespesas()+investimento);
    	return saldo;
    	
    }
    public Servico getLoja() {
        return loja;
    }

    public Servico getGasoleo() {
        return gasoleo;
    }
    public Servico getSelfService() {
        return selfService;
    }
    public Servico getGasolina() {
        return gasolina;
    }
    public int getCenario() {
        return cenario;
    }
    public void limpa(){
        if(cenario==1){
            gasolina.clearTudo();
            gasoleo.clearTudo();
            loja.clearTudo();
        }
        else{
            selfService.clearTudo();
        }
    }
    
}