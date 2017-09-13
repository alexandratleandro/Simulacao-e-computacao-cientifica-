
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;
import javax.swing.JTextArea;
import javax.swing.JCheckBox;
import javax.swing.JSeparator;

public class Interf{

	JFrame frame;
	
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextArea textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
    public int cenario=1;
    public int defau=0;
    public String resultados;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interf window = new Interf();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Interf() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	
	Interf re=this;
	
	
	private void initialize() {
		frame = new JFrame();
		////////////////////
		frame.setTitle("SCC *Estação de Serviço Lda*");
		frame.setBounds(100, 100, 735, 586);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JCheckBox chckbxCenario = new javax.swing.JCheckBox();
		chckbxCenario.setForeground(new Color(255, 99, 71));
		//chckbxCenario.setForeground(new Color(255, 160, 122));
		//chckbxCenario.setForeground(new Color(112, 128, 144));
		chckbxCenario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cenario==1){
					if(defau==0){
						cenario=2;
						textField.setEditable(false);
			            textField_1.setEditable(false);
			            textField_2.setEditable(false);
			            textField_3.setEditable(false);
			            textField_4.setEditable(false);
			            textField_5.setEditable(false);
			            textField_6.setEditable(false);
			            textField_7.setEditable(false);
			            textField_8.setEditable(false);
			            textField_12.setEditable(true);
			            textField_13.setEditable(true);
			            textField_14.setEditable(true);
					}
					else{
						cenario=2;
					}
					
				}
				else{
					if(defau==0){
						cenario=1;
						
			            textField_12.setEditable(false);
			            textField_13.setEditable(false);
			            textField_14.setEditable(false);
			            textField.setEditable(true);
			            textField_1.setEditable(true);
			            textField_2.setEditable(true);
			            textField_3.setEditable(true);
			            textField_4.setEditable(true);
			            textField_5.setEditable(true);
			            textField_6.setEditable(true);
			            textField_7.setEditable(true);
			            textField_8.setEditable(true);
					}
					else{
						cenario=1;
					}
				}
				 
			}
		});
		
		JButton btnOk = new JButton("Validar"); 
		
		btnOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	double desvGasolina=0;
        		double mGasolina=0;
        		int pGasolina=0;
        		double dGasoleo=0;
        		double mGasoleo=0;
        		int pGasoleo=0;
        		double dLoja=0;
        		double mLoja=0;
        		int pLoja=0;
        		
        	    int tempo=0;
        	    double mCheg=0;
        	    
        	    Simulador s ;
        	    
        	    
        	    
        	    String input;
        	    if(cenario==1){
        	    	 if(defau==1){
        	    		 desvGasolina=2.5;
        	        	 mGasolina=4;
        	        	 pGasolina=3;
        	        	 dGasoleo=2.5;
        	        	 mGasoleo=4;
        	        	 pGasoleo=1;
        	        	 dLoja=0.5;
        	        	 mLoja=1;
        	        	 pLoja=1;
        	        	 input = textField_9.getText();
        	        	 ///////////////////////////////////
        	        	 tempo=Integer.parseInt(input)*60;
        	        	 //////////////////////////////////
        	         	 mCheg=1.2;        	    		 
        	    		 
        	    	 }
        	    	 else{
		        		 input = textField.getText();
		                
		                 desvGasolina=Double.parseDouble(input);
		                
		                 input = textField_1.getText();
		                 mGasolina=Double.parseDouble(input);
		                
		                input = textField_2.getText();
		                pGasolina=Integer.parseInt(input);
		                
		                input = textField_3.getText();
		                dGasoleo=Double.parseDouble(input);
		                
		                input = textField_4.getText();
		                mGasoleo=Double.parseDouble(input);
		                
		                input = textField_5.getText();
		                pGasoleo=Integer.parseInt(input);
		                
		                input = textField_6.getText();
		                dLoja=Double.parseDouble(input);
		                
		                input = textField_7.getText();
		                mLoja=Double.parseDouble(input);
		                
		                input = textField_8.getText();
		                pLoja=Integer.parseInt(input);
		                
		                input = textField_9.getText();
		                ///////////////////////////////////
		                tempo=Integer.parseInt(input)*60;
		                //////////////////////////////////
		                
		                input = textField_10.getText();
		                mCheg=Double.parseDouble(input);
	                
        	    	 }
	                
	                
        	    }
        	    else{
        	    	
            		
      
           	    	 if(defau==1){
           	    		 dLoja=2;
           	        	 mLoja=4.5;
           	        	 pLoja=4;
           
           	        	input = textField_9.getText();
           	        	///////////////////////////////////
           	        	tempo=Integer.parseInt(input)*60;
           	        	//////////////////////////////////
        		        
           	         	mCheg=1.2;
           	    		 
           	    		 
           	    	 }
           	    	 
           	    	 else{
           	    		input = textField_12.getText();
    	                dLoja=Double.parseDouble(input);
    	                
    	                input = textField_13.getText();
    	                mLoja=Double.parseDouble(input);
    	                
    	                input = textField_14.getText();
    	                pLoja=Integer.parseInt(input);
    	                
    	                input = textField_9.getText();
    	                ///////////////////////////////////
    	                tempo=Integer.parseInt(input)*60;
    	                //////////////////////////////////
    	                input = textField_10.getText();
    	                mCheg=Double.parseDouble(input);
           	    	 }
            	    
            	    
	                
	               
        	    	
        	    } 
        	    
            	s = new Simulador(cenario,tempo,  mCheg,  mLoja,  dLoja, mGasolina,  desvGasolina, mGasoleo, dGasoleo, pLoja, pGasoleo,  pGasolina );
            	
                s.executa(re);
                s.limpa();
               
            }
        	    
            
        });
		
		btnOk.setBackground(Color.PINK);
	    btnOk.setForeground(Color.GRAY); 
		//btnOk.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		//btnOk.setBackground (new Color(255, 0, 127));
		btnOk.setBounds(49, 513, 77, 23);
		frame.getContentPane().add(btnOk);
		
		JLabel lblGasolina = new JLabel("Gasolina");
		lblGasolina.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblGasolina.setForeground(new Color(255, 0, 127));
		lblGasolina.setBounds(8, 69, 78, 30);
		frame.getContentPane().add(lblGasolina);
		
		JLabel lblGasoleo = new JLabel("Gasoleo");
		lblGasoleo.setForeground(new Color(255, 0, 127));
		lblGasoleo.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblGasoleo.setBounds(8, 204, 72, 23);
		frame.getContentPane().add(lblGasoleo);
		
		JLabel lblLoja = new JLabel("Loja");
		lblLoja.setForeground(new Color(255, 0, 127));
		lblLoja.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblLoja.setBounds(8, 340, 46, 23);
		frame.getContentPane().add(lblLoja);
		
		JLabel lblDesvio = new JLabel("Desvio");
		lblDesvio.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDesvio.setBounds(24, 135, 46, 14);
		frame.getContentPane().add(lblDesvio);
		
		JLabel lblMedia = new JLabel("Media");
		lblMedia.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMedia.setBounds(24, 110, 42, 14);
		frame.getContentPane().add(lblMedia);
		
		JLabel lblPostos = new JLabel("Postos");
		lblPostos.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPostos.setBounds(24, 160, 46, 14);
		frame.getContentPane().add(lblPostos);
		
		JLabel lblDesvio_1 = new JLabel("Desvio");
		lblDesvio_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDesvio_1.setBounds(24, 272, 46, 14);
		frame.getContentPane().add(lblDesvio_1);
		
		JLabel lblMedia_1 = new JLabel("Media");
		lblMedia_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMedia_1.setBounds(24, 244, 46, 14);
		frame.getContentPane().add(lblMedia_1);
		
		JLabel lblPostos_1 = new JLabel("Postos");
		lblPostos_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPostos_1.setBounds(24, 297, 46, 14);
		frame.getContentPane().add(lblPostos_1);
		
		JLabel lblDesvio_2 = new JLabel("Desvio");
		lblDesvio_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDesvio_2.setBounds(24, 417, 46, 14);
		frame.getContentPane().add(lblDesvio_2);
		
		JLabel lblMedia_2 = new JLabel("Media");
		lblMedia_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMedia_2.setBounds(24, 388, 46, 14);
		frame.getContentPane().add(lblMedia_2);
		
		JLabel lblFuncionrios = new JLabel("Postos");
		lblFuncionrios.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblFuncionrios.setBounds(24, 442, 62, 19);
		frame.getContentPane().add(lblFuncionrios);
		
		JLabel lblTempoSimulao = new JLabel("Tempo Simula\u00E7\u00E3o (h):");
		lblTempoSimulao.setForeground(new Color(105, 105, 105));
		lblTempoSimulao.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		lblTempoSimulao.setBounds(165, 384, 141, 23);
		frame.getContentPane().add(lblTempoSimulao);
		
		JLabel lblMediaDeChegada = new JLabel("Media de chegada:");
		lblMediaDeChegada.setForeground(new Color(105, 105, 105));
		lblMediaDeChegada.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		lblMediaDeChegada.setBounds(165, 327, 118, 23);
		frame.getContentPane().add(lblMediaDeChegada);
		
		textField = new JTextField();
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		//textField.setBackground(new Color(255, 255, 240));
		textField.setBounds(76, 133, 46, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		textField_1.setBounds(76, 110, 46, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(76, 158, 46, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(80, 270, 46, 20);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(80, 242, 46, 20);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(80, 297, 46, 20);
		frame.getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(80, 415, 46, 20);
		frame.getContentPane().add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setBounds(80, 386, 46, 20);
		frame.getContentPane().add(textField_7);
		textField_7.setColumns(10);
		
		textField_8 = new JTextField();
		textField_8.setBounds(80, 442, 46, 20);
		frame.getContentPane().add(textField_8);
		textField_8.setColumns(10);
		
		textField_9 = new JTextField();
		textField_9.setBounds(293, 386, 46, 20);
		frame.getContentPane().add(textField_9);
		textField_9.setColumns(10);
		
		textField_10 = new JTextField();
		textField_10.setBounds(293, 329, 46, 20);
		frame.getContentPane().add(textField_10);
		textField_10.setColumns(10);
		
		JLabel lblResultados = new JLabel("Resultados");
		lblResultados.setForeground(Color.PINK);
		lblResultados.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblResultados.setBackground(SystemColor.activeCaption);
		lblResultados.setBounds(496, 24, 132, 23);
		frame.getContentPane().add(lblResultados);
		
		textField_11 = new JTextArea();
		textField_11.setBounds(415, 70, 264, 457);
		///
		textField_11.setFont(new Font("Tahoma", Font.PLAIN, 12));
		frame.getContentPane().add(textField_11);
		textField_11.setColumns(10);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(680, 69, 17, 458);
		frame.getContentPane().add(scrollBar);
		
		chckbxCenario.setText("Cenario 2");
		chckbxCenario.setBounds(209, 206, 118, 23);
		frame.getContentPane().add(chckbxCenario);
		
		JCheckBox chckbxValoresDefault = new JCheckBox("Valores Default");
		chckbxValoresDefault.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(defau==0){
					defau=1;
					textField.setEditable(false);
		            textField_1.setEditable(false);
		            textField_2.setEditable(false);
		            textField_3.setEditable(false);
		            textField_4.setEditable(false);
		            textField_5.setEditable(false);
		            textField_6.setEditable(false);
		            textField_7.setEditable(false);
		            textField_8.setEditable(false);
		            
		            textField_10.setEditable(false);
		            textField_12.setEditable(false);
		            textField_13.setEditable(false);
		            textField_14.setEditable(false);
				}
				else{				
					defau=0;
					if(cenario==1){

						textField.setEditable(true);
			            textField_1.setEditable(true);
			            textField_2.setEditable(true);
			            textField_3.setEditable(true);
			            textField_4.setEditable(true);
			            textField_5.setEditable(true);
			            textField_6.setEditable(true);
			            textField_7.setEditable(true);
			            textField_8.setEditable(true);
			            
			            textField_10.setEditable(true);
					}
					else{
						textField_10.setEditable(true);
			            textField_12.setEditable(true);
			            textField_13.setEditable(true);
			            textField_14.setEditable(true);
					}
				}
			}
		}); 
		chckbxValoresDefault.setForeground(new Color(255, 99, 71));
		//chckbxValoresDefault.setForeground(new Color(0, 128, 128)); 
		//chckbxValoresDefault.setForeground(new Color(112, 128, 144));
		//chckbxValoresDefault.setForeground(new Color(0, 128, 128));
		//chckbxValoresDefault.setFont(new Font("Tahoma", Font.PLAIN, 11));
		chckbxValoresDefault.setBounds(209, 441, 118, 23);
		frame.getContentPane().add(chckbxValoresDefault);
		
		JLabel lblDesvio_3 = new JLabel("Desvio");
		lblDesvio_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDesvio_3.setBounds(209, 135, 46, 14);
		frame.getContentPane().add(lblDesvio_3);
		
		JLabel lblMedia_3 = new JLabel("Media");
		lblMedia_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMedia_3.setBounds(209, 112, 46, 14);
		frame.getContentPane().add(lblMedia_3);
		
		JLabel lblPostos_2 = new JLabel("Postos");
		lblPostos_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPostos_2.setBounds(209, 160, 46, 14);
		frame.getContentPane().add(lblPostos_2);
		
		JLabel lblSelfservice = new JLabel("SelfService");
		lblSelfservice.setForeground(new Color(255, 0, 127));
		lblSelfservice.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSelfservice.setBounds(199, 73, 113, 23);
		frame.getContentPane().add(lblSelfservice);
		
		textField_12 = new JTextField();
		textField_12.setBounds(265, 133, 46, 20);
		frame.getContentPane().add(textField_12);
		textField_12.setColumns(10);
		
		textField_13 = new JTextField();
		textField_13.setBounds(265, 108, 46, 20);
		frame.getContentPane().add(textField_13);
		textField_13.setColumns(10);
		
		textField_14 = new JTextField();
		textField_14.setBounds(265, 160, 46, 20);
		frame.getContentPane().add(textField_14);
		textField_14.setColumns(10);
		textField_12.setEditable(false);
        textField_13.setEditable(false);
        textField_14.setEditable(false);
		
		JButton btnVer = new JButton("Ver");

		//btnVer.setBackground(new Color(255, 0, 127));
		btnVer.setBackground(Color.PINK);
	    btnVer.setForeground(Color.GRAY);
		btnVer.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				textField_11.setText("");
          	  textField_11.append(resultados); 
			}
		});
		btnVer.setBounds(209, 513, 77, 23);
		frame.getContentPane().add(btnVer);
		
		JLabel lblInsiraValoresDe = new JLabel("Insira Valores De Simula\u00E7\u00E3o");
		lblInsiraValoresDe.setForeground(Color.PINK);
		lblInsiraValoresDe.setBackground(new Color(153, 153, 102));
		lblInsiraValoresDe.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblInsiraValoresDe.setBounds(22, 11, 303, 48);
		frame.getContentPane().add(lblInsiraValoresDe);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(404, 69, 1, 2);
		frame.getContentPane().add(separator);
	}
}
