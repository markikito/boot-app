import java.util.List;

import com.julienvey.trello.Trello;
import com.julienvey.trello.domain.Action;
import com.julienvey.trello.domain.Board;
import com.julienvey.trello.domain.Card;
import com.julienvey.trello.impl.TrelloImpl;

public class EjemploApiTrello {

	private static Integer tiempoConsumido;
	private static Integer tiempoTotal;

	public static void main(String[] args) {
		/*nos conectamos a la api de trello, necesitamos ir al chrome , 
		 *logearnos en el trello y acceder a este enlace 
		 *https://trello.com/app-key donde nos daran el key y el token*/
										            /*key*/	                                          /*token*/
		Trello trelloApi=new TrelloImpl("af49a748d4013363909c90dec242f44a", "87c61d6f9a2ce79214ac352826623be985154c27b4cea430e2258ebe2bbc6e1f");
		
		/*Una vez conectados recuperaremos el tablero con el que queremos trabajar , en este caso trabajaremos con EuroGiro -SGTC- PBC para lo cual necesitaremos el id del tablero
		 *El id sera el penultimo valor de la direccion https
		 *https://trello.com/b/maaVe0xe/eurogiro-sgtc-pbc*/
		
		Board board=trelloApi.getBoard("maaVe0xe");
		
		/*A continuacion recuperaremos las tarjetas que tiene un miembro especifico en el tablero*/
		List<Card> tarjetas = board.fetchMemberCards("omarserafin");
		
		/* Recorremos todas las targetas y cogeremos el ultimo  comentario realizado que comienza con 'plus!'
		 * Despues tabajaermos con el comenterio para coger los valores que necesitamos, en este caso tiempoConsumido;
	       y tiempoTotal;
		 */
		 
		for (Card card : tarjetas) {
			if (card.getName().equals("Lista Negra ONU")) {
				List<Action> action = card.getActions();
				for (Action action2 : action) {
					String comentario= action2.getData().getText();
					if(comentario!=null){
						if (comentario.startsWith("plus!")) {
							String[] partes = comentario.split("/");
							String[] parte1 = partes[0].split("!");
							tiempoConsumido=Integer.valueOf(parte1[1].trim());
							tiempoTotal=Integer.valueOf(partes[1].trim());
							break;
						}
					}
					
				}
				/*Si queremos hacer alguna modificacion tenderemos que ejecutar el metodo update despues de realizarla */
//				card.setName("Lista Negra ONU");
//				card.update();
			}
			
		}	
		System.out.println("tiempo consumido = "+tiempoConsumido);
		System.out.println("tiempo total = "+tiempoTotal);
		System.out.println("tiempo restante = "+ (tiempoTotal-tiempoConsumido));
	}

}
