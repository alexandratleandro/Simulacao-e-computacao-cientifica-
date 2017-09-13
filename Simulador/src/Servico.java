

import java.util.*;
// + classe para a loja?
// Classe que representa um serviço com uma fila de espera associada

//+ representa toda a seçao - fila e o tempo de serviço, neste caso com 1 atendedor

public class Servico {
    private String nome;
    private int estado; // Variável que regista o estado do serviço: 0 - livre; 1 - ocupado
    private int atendidos; // Número de clientes atendidos até ao momento
    private double temp_ult, soma_temp_esp, soma_temp_serv; // Variáveis para cálculos estatísticos
    private int maxFila;
    private Vector<Cliente> fila; // Fila(s) de espera do serviço
    private Simulador s; // Referência para o simulador a que pertence o serviço
    private int funcionarios; 
    //private int tempoServico; // da classe aleatoria, que la da negativo
    private double med_serv, desvio;
    private int seed;
    private double [] v = new double [2];
    private boolean calc = true;
    // verificar se valor � positivo ou negativo
    
	//+ colocar numero de atendores 
	
	// Construtor
    Servico (Simulador s, int funcionarios, String nome, double med_serv, double desvio, int seed){
    	this.s = s;
        this.nome = nome;
        fila = new Vector<Cliente>(); // Cria fila(s) de espera
        estado = 0; // Livre
        temp_ult = s.getInstante(); // Tempo que passou desde o último evento. Neste caso 0, porque a simulação ainda não começou.
        atendidos = 0;  // Inicialização de variáveis
        soma_temp_esp = 0;
        soma_temp_serv = 0;
        this.funcionarios = funcionarios;
        this.seed= seed;
        this.med_serv=med_serv;
        this.desvio=desvio;
        this.maxFila=0;
        
    }

	// Método que insere cliente (c) no serviço 
    public void insereServico (Cliente c){       
        if (estado < funcionarios) { // Se algum funcionario estiver livre
            estado ++;    
            if(s.getCenario()==1){ 
                if("LOJA".equals(nome)){// se o cliente estiver na loja, paga e sai
                    if (calc){
                        v = Aleatorio.normal(med_serv,desvio,seed);
                        calc = false;
                       }
                    else {
                        calc = true;
                        v[0] = v[1];
                    }
                    s.insereEvento (new Saida(s.getInstante()+v[0], s, this));
                }
                else{
                    // se cliente estiver na gasolina ou gasoleo vai ser transferido para a loja        
                    if (calc){
                        v = Aleatorio.normal(med_serv,desvio,seed);
                        calc = false;
                       }
                    else {
                        calc = true;
                        v[0] = v[1];
                    }
                    s.insereEvento (new Transfere(s.getInstante()+ v[0], s, this, c)); 
                }
            }
            else{ // cenario self servico
                if (calc){
                    if(c.getTipo()==1){
                        v = Aleatorio.normal(med_serv,desvio,10);
                    }
                    else{
                        v = Aleatorio.normal(med_serv,desvio,20);
                    }
                    calc = false;
                   }
                else {
                    calc = true;
                    v[0] = v[1];
                }
                s.insereEvento (new Saida(s.getInstante()+v[0], s, this));   
            }
        } 
        else{ // se servi�o estiver ocupado - todos os funcionarios estao a atender -> o cliente tera de ir fila de espera
            if(fila.size()>maxFila){
                maxFila=fila.size();
            }
            fila.addElement(c); // Se serviço ocupado, o cliente vai para a fila de espera
        } 
        
    }

	// Método que remove cliente do serviço
	//+ corresponde a fim de serviço
    public Cliente removeServico (){
        
        atendidos++; // Regista que acabou de atender + 1 cliente
        if (fila.isEmpty()) estado --; // Se fila está vazia, liberta o serviço
        else { // Se não,
        // vai buscar próximo cliente à fila de espera e
            Cliente c = (Cliente)fila.firstElement();
            fila.removeElementAt(0);
            // agenda a sua saida para daqui a s.getMedia_serv() instantes
            if(s.getCenario()==1){
                if("LOJA".equals(nome)){// se o cliente estiver na loja, paga e sai
                   if (calc){
                       v = Aleatorio.normal(med_serv,desvio,seed);
                       calc = false;
                    }
                    else {
                       calc = true;
                       v[0] = v[1];
                    }
                   s.insereEvento (new Saida(s.getInstante()+v[0], s, this));
               } 
               else{
                   // se cliente estiver na gasolina ou gasoleo vai ser transferido para a loja        
                    if (calc){
                       v = Aleatorio.normal(med_serv,desvio,seed);
                       calc = false;
                    }
                    else {
                       calc = true;
                       v[0] = v[1];
                    }
                   s.insereEvento (new Transfere(s.getInstante()+ v[0], s, this, c)); 
               }
            }
            else{
                if (calc){
                    if(c.getTipo()==1){
                        v = Aleatorio.normal(med_serv,desvio,10);
                    }
                    else{
                        v = Aleatorio.normal(med_serv,desvio,20);
                    }
                    calc = false;
                   }
                else {
                    calc = true;
                    v[0] = v[1];
                }
                s.insereEvento (new Saida(s.getInstante()+v[0], s, this));   
            }
         
            return c;
           
        }
        return null;
    }

	// Método que calcula valores para estatísticas, em cada passo da simulação ou evento
    public void act_stats(){
        // Calcula tempo que passou desde o último evento
        double temp_desde_ult = s.getInstante() - temp_ult;
        // Actualiza variável para o próximo passo/evento
        temp_ult = s.getInstante();
        // Contabiliza tempo de espera na fila
        // para todos os clientes que estiveram na fila durante o intervalo
        soma_temp_esp += fila.size() * temp_desde_ult;
        // Contabiliza tempo de atendimento
        soma_temp_serv += estado * temp_desde_ult;
    }

	// Método que calcula valores finais estatísticos 
	//+ contas finais, fazer medias e tretas
    public String relat (){
        // Tempo médio de espera na fila
        //+ alterar contas no caso dos atendedores 1
        double temp_med_fila = soma_temp_esp / (atendidos+fila.size());
        // Comprimento médio da fila de espera
        // s.getInstante() neste momento é o valor do tempo de simulação,
        // uma vez que a simulação começou em 0 e este método só é chamdo no fim da simulação
        double comp_med_fila = soma_temp_esp / s.getInstante();
        // Tempo médio de atendimento no serviço
        double utilizacao_serv = soma_temp_serv / s.getInstante();
        // Apresenta resultados
        String resul="";

        resul=resul+nome+"\n"+"Tempo medio espera: "+String.format("%.3f" , temp_med_fila)+"\n Comp. medio fila: "+String.format("%.3f" , comp_med_fila)+"\n Comp. maximo fila: "+maxFila+"\n Utiliza��o Serv: "+String.format("%.3f" , (utilizacao_serv/funcionarios)*100)+"%"+"\n Numero de Clientes atendidos: "+atendidos+"\n Numero de Clientes na fila:"+fila.size()+"\nTempo de Simula��o:"+String.format("%.3f" , s.getInstante())+"\n\n";
        //resul=resul+nome+"\n"+"Tempo medio espera: "+String.format("%.3f" , temp_med_fila)+"\n Comp. medio fila: "+String.format("%.3f" , comp_med_fila)+"\n Comp. maximo fila: "+maxFila+"\n Utiliza��o Serv: "+String.format("%.3f" , (utilizacao_serv/funcionarios)*100)+"%"+"\n Numero de Clientes atendidos: "+atendidos+"\n Numero de Clientes na fila:"+fila.size()+"\n\n";

        //resul=resul+nome+"\n"+"Tempo medio espera: "+String.format("%.3f" , temp_med_fila)+"\n Comp. medio fila: "+String.format("%.3f" , comp_med_fila)+"\n Comp. maximo fila: "+maxFila+"\n Utiliza��o Serv: "+String.format("%.3f" , (utilizacao_serv/funcionarios)*100)+"%"+"\n Numero de Clientes atendidos: "+atendidos+"\n\n";
        //resul=resul+nome+"\n"+"Tempo medio espera:"+temp_med_fila+"\n Comp. medio fila:"+comp_med_fila+"\n Comp. maximo fila:"+maxFila+"\n Utiliza��o Serv:"+utilizacao_serv/funcionarios+"\n Tempo simulacao:"+s.getInstante()+"\n Numero de Clientes atendidos:"+atendidos+"\n Numero de Clientes na fila:"+fila.size()+"\n\n";
         
        
        return resul;
    }

    // Método que devolve o número de clientes atendidos no serviço até ao momento
    public int getAtendidos() {
        return atendidos;
    }

    public String getNome() {
        return nome;
    }
    public int getFuncionarios(){
    	return funcionarios;
    }

    public Vector<Cliente> getFila() {
        return fila;
    }
    public void clearTudo(){
        fila.clear();
        atendidos=0;
        temp_ult=0.0;
        soma_temp_esp=0;
        soma_temp_serv=0; 
        maxFila=0; 
    }
    
}