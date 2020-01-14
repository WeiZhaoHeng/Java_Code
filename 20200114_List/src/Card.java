import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User：WeiZhaoheng
 * Date: 2020/1/14
 * Time: 12:22
 */
class CardKind {
    public String suit;
    public int rank;

    public CardKind(String suit, int rank) {
        this.suit = suit;
        this.rank = rank;
    }

    @Override
    public String toString() {
        return String.format("[%s %d]",suit,rank);
    }
}

class Card{
    public static final String[] suit = {"♥","♦","♣","♠"};

    //新牌
    public static List<CardKind> buyPuke(){
        List<CardKind> deck = new ArrayList<>();
        for(int i = 0; i < 4;i++){
            for(int j = 1;j <= 13;j++){
                CardKind card = new CardKind(suit[i],j);
                deck.add(card);
            }
        }
        return deck;
    }

    //洗牌
    public static void shuffle(List<CardKind> deck){
        Random random = new Random();
        for(int i = deck.size()-1; i > 0;i--){
            int index = random.nextInt(i);
            swap(deck,i,index);
        }
    }
    //交换牌
    public static void swap(List<CardKind> deck,int start,int end){
        CardKind tmp = deck.get(start);
        deck.set(start,deck.get(end));
        deck.set(end,tmp);
    }

    //发牌
    public static void deal(List<CardKind> deck){
        List<List<CardKind>> hands = new ArrayList<>();
        List<CardKind> human1 = new ArrayList<>();
        List<CardKind> human2 = new ArrayList<>();
        List<CardKind> human3 = new ArrayList<>();
        hands.add(human1);
        hands.add(human2);
        hands.add(human3);
        for(int i = 0;i < 5;i++){
            for(int j = 0; j < 3;j++){
                CardKind catchCard = deck.remove(0);
                hands.get(j).add(catchCard);
            }
        }
        System.out.println("第一个人的牌：");
        System.out.println(human1);
        System.out.println("第二个人的牌：");
        System.out.println(human2);
        System.out.println("第三个人的牌：");
        System.out.println(human3);
        System.out.println("剩余的牌：");
        System.out.println(deck);

    }

    public static void main(String[] args) {
        List<CardKind> list = buyPuke();
        System.out.println(list);
        shuffle(list);
        System.out.println(list);
        deal(list);
    }
}
