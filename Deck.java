import java.util.ArrayList;
import java.util.Random;

public class Deck {

	private ArrayList<Card> cards; //所有的牌
	public ArrayList<Card> usedCard;//發過的牌
	public int nUsed;
	Random rnd=new Random();//隨機值
	
	public Deck(int nDeck){//新增撲克牌
		cards=new ArrayList<Card>();
		usedCard=new ArrayList<Card>();			
		for(int d=1;d<=nDeck;d++) { //總共有多少副牌
			 for (Card.Suit s : Card.Suit.values()) {  //4種花色依序餵進s參數
			for(int n=1;n<=13;n++) {  //Ace to K 13種牌
		Card cardcard=new Card(s,n);
		cards.add(cardcard);
		}
		}
		}
		Shuffle();//新增完所有的牌後洗牌
	}	
	
	         
	public void printDeck(){		
		
		for(int c=0;c < cards.size();c++) { //cards ArrayList 的第0位到最後1位
		
			Card cardcard= cards.get(c);
			cardcard.printCard(); //use printCard() print (suit,rank)
		}		

	}
	public ArrayList<Card> getAllCards(){//取得所有的牌
		return cards;
	}
	
	
	public void Shuffle() {//洗牌
		cards.addAll(usedCard);//收回發出去的牌
		usedCard.clear();//重設用過的牌
		nUsed=0;	
		
		for(int i=0;i<cards.size();i++) {
		int j = rnd.nextInt(cards.size());//隨機位置的值依序與第i位調換
		Card temp=cards.get(j);
		cards.set(j,cards.get(i));
		cards.set(i,temp);
		}		
	}
	
	public Card getOneCard(){//發牌
		if(cards.size()==0) {//如果所有的牌發完的話，洗牌
			Shuffle();}
		
		Card cardcard = cards.get(0) ;//拿第一張牌
		cards.remove(0) ;
		usedCard.add(cardcard) ;
		nUsed++ ;
		return cardcard ;
		}
}
