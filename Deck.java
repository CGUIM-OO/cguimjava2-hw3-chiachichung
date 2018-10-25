import java.util.ArrayList;
import java.util.Random;

public class Deck {

	private ArrayList<Card> cards; //�Ҧ����P
	public ArrayList<Card> usedCard;//�o�L���P
	public int nUsed;
	Random rnd=new Random();//�H����
	
	public Deck(int nDeck){//�s�W���J�P
		cards=new ArrayList<Card>();
		usedCard=new ArrayList<Card>();			
		for(int d=1;d<=nDeck;d++) { //�`�@���h�ְƵP
			 for (Card.Suit s : Card.Suit.values()) {  //4�ت��̧����is�Ѽ�
			for(int n=1;n<=13;n++) {  //Ace to K 13�صP
		Card cardcard=new Card(s,n);
		cards.add(cardcard);
		}
		}
		}
		Shuffle();//�s�W���Ҧ����P��~�P
	}	
	
	         
	public void printDeck(){		
		
		for(int c=0;c < cards.size();c++) { //cards ArrayList ����0���̫�1��
		
			Card cardcard= cards.get(c);
			cardcard.printCard(); //use printCard() print (suit,rank)
		}		

	}
	public ArrayList<Card> getAllCards(){//���o�Ҧ����P
		return cards;
	}
	
	
	public void Shuffle() {//�~�P
		cards.addAll(usedCard);//���^�o�X�h���P
		usedCard.clear();//���]�ιL���P
		nUsed=0;	
		
		for(int i=0;i<cards.size();i++) {
		int j = rnd.nextInt(cards.size());//�H����m���Ȩ̧ǻP��i��մ�
		Card temp=cards.get(j);
		cards.set(j,cards.get(i));
		cards.set(i,temp);
		}		
	}
	
	public Card getOneCard(){//�o�P
		if(cards.size()==0) {//�p�G�Ҧ����P�o�����ܡA�~�P
			Shuffle();}
		
		Card cardcard = cards.get(0) ;//���Ĥ@�i�P
		cards.remove(0) ;
		usedCard.add(cardcard) ;
		nUsed++ ;
		return cardcard ;
		}
}