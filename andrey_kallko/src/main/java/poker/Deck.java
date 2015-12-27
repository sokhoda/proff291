package poker;

/**
 * Создание и перемешивание колоды карт.
 * пика 401 - 413
 * чирва 301 - 313
 * бубна 201 - 212
 * трефа 101 - 113
 */
public class Deck {
    private  Integer[] deck = new Integer[52];

    public Deck(){
        int i=0;
        while (i<13){
            deck[i]=101+i;
            deck[i+13] = 201+i;
            deck[i+26] = 301+i;
            deck[i+39] = 401+i;
            i=i+1;
        }
    }

    public static void main(String[] args) {
        Deck proba = new Deck();
        proba.printDeck();
        proba.shuffleDeck();
        System.out.println();
        proba.printDeck();
        proba.printOneCard(101);
        proba.printOneCard(201);
        proba.printOneCard(301);
        proba.printOneCard(401);

    }


    public void shuffleDeck(){
        int i=0;
        Integer transit=0;
        while (i<1000){
            int firstCard= (int) (Math.random()*52);
            int secondCard = (int) (Math.random()*52);
            transit = this.getCard(firstCard);
            this.setCard(firstCard, this.getCard(secondCard));
            this.setCard(secondCard, transit);
            i++;
        }
    }

    public void printOneCard(int value){
        char suit=(char)0;
        char rank=(char)0;
        if (value<200) {suit=(char)9827;}
        if ((value<300)&&(value>200)){suit=(char)9826;}
        if ((value>300)&&(value<400)){suit=(char)9825;}
        if (value>400){suit=(char)9824;}
        System.out.println(suit+""+rank);

    }

    public void printDeck(){
        int i=0;
        while (i<52){
            System.out.println(i + " = " + this.getCard(i));
            i++;
        }
    }

    public Integer[] getDeck() {
        return deck;
    }

    public Integer getCard(int i){
        return deck[i];
    }

    public void setCard(int number, Integer value){
        this.deck[number]=value;
    }

    public void setDeck(Integer[] deck) {
        this.deck = deck;
    }
}
