
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Gato {
	
	 public char tablero[][];
	 public char j1;
	 public char j2;
	 public int contador;
	 public boolean turno;
	
	//costructor
	
	public Gato()
	{
		tablero = new char [3][3];
			j1= 'X';
			j2 ='O';
		contador = 0;
		turno= true;
		
		inicializarTablero();  
		
	}
	
	  public void inicializarTablero()
	  {
	        
	        int posicion = 1;
	        
	        for(int x=0;x<3;x++)
	        {
	                
	                for(int y=0; y<3;y++)
	                {
	                        
	                	tablero[x][y] =  Integer.toString(posicion).charAt(0);
	                        
	                        posicion++;
	                }                       
	        }
	    }
	
	
	
	
	// dibujar tablero
	  
	  public void DibujarTablero()
	  {
		  for(int x=0;x<3;x++)
		  {
			  for(int y=0;y<3;y++)
			  {
				  
				  if(y<2)
				  
				  System.out.print(" "+ tablero [x][y]+ "||") ;
				  
				  else
					  
				
					System.out.print(" "+ tablero [x][y]+ " ") ;
				  
			  
			  }
			  if(x<2)
                  
				  System.out.println("\n--++--++--");       
		  }
		  System.out.println();
	        System.out.println();
	        System.out.println();
	  }
	  
	   
	    public void indicarPosicionArreglo (int a, int b, char c) {tablero [a][b]=c;}
	  
	    public void setTurno               (boolean d)            {turno         =d;}
	   
	    public void setContador            (int e)                {contador      =e;} 
	    
	  
	    public char getPosicionArreglo (int a, int b)  {return tablero[a][b];} 
	        
	 
	    public char getJugadorUno      ()  {return j1   ;}            
	   
	  
	    public char getJugadorDos      ()  {return j2   ;}            
	  
	  
	    public boolean getTurno        ()  {return turno        ;}
	          
	    public int getContador         ()  {return contador     ;}           
	    
	    
	 
	    public void indicarTurno(){
	        
	        if(getTurno()==true)
	                
	                System.out.println("JUGADOR 1: Elija Una Casilla Ingresando El Numero Correspondiente.");
	                
	        else
	                
	                System.out.println("JUGADOR 2: Elija Una Casilla Ingresando El Numero Correspondiente.");       
	    }
	    
	
	    public char obtenerFigura(){
	        
	        if(getTurno()==true)
	                
	                return j1;
	                
	        else
	                
	                return j2;      
	    }
	    
	 
	    public void cambiarTurno(){         
	        
	        if(obtenerFigura()=='X') 
	                
	                setTurno(false);
	        
	        else
	                
	                setTurno(true); 
	    }
	      
	  
	    public void comprobarEspacio(char espacio, int posicionUno, int posicionDos){
	      
	      
	        if(espacio!=getJugadorUno()&&espacio!=getJugadorDos()){ 
	                
	           indicarPosicionArreglo(posicionUno, posicionDos,obtenerFigura());
	           cambiarTurno();                                                  
  
	           contador++;                                                                   
	        }
	        
	        else
	         
	                                       
	           System.out.println("La Casilla Esta Ocupada, Elija Otra Por Favor");                 
	    }
	            
	 
	    public void elegirPosicion(int posicion){
	                           
	            switch(posicion){
	                
	                 
	                        case 1:comprobarEspacio(getPosicionArreglo(0,0),0,0);
	                        break;
	                        case 2:comprobarEspacio(getPosicionArreglo(0,1),0,1);
	                        break;
	                        case 3:comprobarEspacio(getPosicionArreglo(0,2),0,2);
	                        break;
	                        case 4:comprobarEspacio(getPosicionArreglo(1,0),1,0);
	                        break;
	                        case 5:comprobarEspacio(getPosicionArreglo(1,1),1,1);
	                        break;
	                        case 6:comprobarEspacio(getPosicionArreglo(1,2),1,2);
	                        break;
	                        case 7:comprobarEspacio(getPosicionArreglo(2,0),2,0);
	                        break;
	                        case 8:comprobarEspacio(getPosicionArreglo(2,1),2,1);
	                        break;
	                        case 9:comprobarEspacio(getPosicionArreglo(2,2),2,2);
	                        break;
	                        default:
	                              
	                                System.out.println("Por Favor, Ingrese Solo Un Digito Del 1 al 9.");
	                                break;                              
	            }           
	    }
	    
	 
	    public void decirGanador(char a){
	        
	        
	        if(a=='X')
	                                
	                System.out.println("FIN DEL JUEGO: FELICIDADES JUGADOR 1!!!");
	        
	                
	        else if(a=='O')
	                            
	                    System.out.println("FIN DEL JUEGO: FELICIDADES JUGADOR 2!!!");                      
	                
	                                
	    }
	    
	
	    public void buscarGanador(){
	                  
	      
	        for(int i=0;i<3;i++){
	                
	                for(int j=1;j<2;j++){
	                        
	                        if(tablero[i][j]==tablero[i][j-1]&&tablero[i][j]==tablero[i][j+1]){
	                                                        
	                           decirGanador(tablero[i][j]);
	                           DibujarTablero();
	                           setContador(10);
	                        }                               
	                }                       
	        }
	   
	      // Ganar De Forma Vertical.  
	        for(int i=0;i<3;i++){
	                
	                for(int j=1;j<2;j++){
	                        
	                        if(tablero[j][i]==tablero[j-1][i]&&tablero[j][i]==tablero[j+1][i]){
	                        
	                           decirGanador(tablero[j][i]);
	                           DibujarTablero();
	                           setContador(10);
	                        }                               
	                }
	        }
	        
	      // Ganar De Forma Diagonal.   
	        if(tablero[1][1]==tablero[0][0]&&tablero[1][1]==tablero[2][2]){
	        
	           decirGanador(tablero[1][1]);
	           DibujarTablero();
	           setContador(10);
	        }   
	           
	      // Ganar De Forma Diagonal Inversa.
	        if(tablero[1][1]==tablero[0][2]&&tablero[1][1]==tablero[2][0]){
	                
	           decirGanador(tablero[1][1]);
	           DibujarTablero();                   
	           setContador(10);
	        }       
	    }    
	        
	  //Metodo Que Contiene El Flujo Y El Orden Del Juego.
	    public void jugarGato(){
	        
	        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
	        
	        System.out.println("BIENVENIDO Al JUEGO DEL  GATO ");       
	                
	        do{
	        
	                indicarTurno();                 
	                DibujarTablero();      
	                try{elegirPosicion(Integer.parseInt(entrada.readLine()));}
	                catch(IOException e){}    
	                catch(NumberFormatException e){
	                        
	                        if(getTurno()==true)
	                           
	                           System.out.println("ERROR ,INTENTE DE NUEVO");
	                        
	                        else
	                                
	                           System.out.println("ERROR INTENTE DE NUEVO");       
	                }
	                         
	                buscarGanador();
	        
	        }while(getContador()<9);
	        
	          if(getContador()==9){
	                
	                System.out.println("¡GATO!¡JUEGO EMPATADO!");                                        
	                DibujarTablero();
	            System.out.println("GRACIAS");              
	          }
	         
	         System.out.println("GRACIAS");             
	    }
	    
	    public static void main(String [] args){
	        
	        Gato Objeto = new Gato();
	        
	        Objeto.jugarGato();     
	                                                                                        
	    }    
	}
	 
	  
	