import sun.awt.geom.AreaOp;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User：WeiZhaoheng
 * Date: 2019/12/15
 * Time: 15:17
 */
class Card{
    public String suit;
    public int rank;
    public Card(String suit,int rank){
        this.suit = suit;
        this.rank = rank;
    }

    @Override
    public String toString() {
        return String.format("[%s %d]",suit,rank);
    }
}

public class CardDemo {


    public static final String[] suits = {"♥","♦","♣","♠"};
    //新牌
    public static List<Card> buyPuke(){
        List<Card> deck = new ArrayList<>();
        for(int i = 0;i < 4;i++){
            for (int j = 1; j <= 13 ; j++) {
                Card card = new Card(suits[i],j);
                deck.add(card);
            }
        }
        return deck;
    }
    //洗牌
    public static void shuffle(List<Card> deck){
        Random random = new Random();
        for (int i = deck.size()-1;i>0;i--) {
            int index = random.nextInt(i);//随机取[0,i)范围内的下标
            swap(deck,i,index);
        }
    }
        //交换
        public static void swap(List<Card> deck,int start,int end){
            Card tmp = deck.get(start);
            deck.set(start,deck.get(end));
            deck.set(end,tmp);
        }
    //发牌,3个人，每人5张牌
    public static void deal(List<Card> deck){
        List<List<Card>> hands = new ArrayList<>();
        List<Card> human1 = new ArrayList<>();
        List<Card> human2 = new ArrayList<>();
        List<Card> human3 = new ArrayList<>();
        hands.add(human1);
        hands.add(human2);
        hands.add(human3);
        for(int i = 0;i < 5;i++){
            for(int j = 0 ;j < 3;j++){
                Card catchCard = deck.remove(0);//拿牌的时候拿一张少一张，使用remove（）
                hands.get(j).add(catchCard);
            }
        }
        System.out.println("第一个人的牌：");
        System.out.println(human1);
        System.out.println("第二个人的牌：");
        System.out.println(human2);
        System.out.println("第三个人的牌：");
        System.out.println(human3);
        System.out.println("剩余的牌");
        System.out.println(deck);
    }

    public static void main(String[] args) {
        List<Card> list = buyPuke();
        System.out.println(list);
        shuffle(list);
        System.out.println(list);
        deal(list);


    }
}
