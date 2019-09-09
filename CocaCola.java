package Podsumowanie.CocaColaVendingMachine;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CocaCola {


    public static void main(String[] args) {


        List<Integer> coins2 = coins2();

        System.out.println("List of coins that were put into the machine"+coins2);
        System.out.println("Amount of coins in Machine after selling "+coins2.size()+" can of CocaCola");
        System.out.println("Automat provide all attempt of buy coca-cola can: "+vendingMachine(coins2));



    }
/* method vendingMachine return
****true*** if all attempt of buy coca-cola will pass
***false*** if in automat is lack of proper coins to give the change*/
    public static boolean vendingMachine(List<Integer> c) {

        int initialQuantityOf_1 = 100;      //starting amount of coins of 1 value
        int initialQuantityOf_2 = 100;      //starting amount of coins of 2 value
        int initialQuantityOf_5 = 0;        //starting amount of coins of 5 value
        for (int i = 0; i < c.size(); i++) {
            c.get(i);
            switch (c.get(i)) {
                case 1:
                    initialQuantityOf_1 += 1;
                    break;
                case 2:
                    if (initialQuantityOf_1 >= 1) {
                        initialQuantityOf_1 -= 1;
                        initialQuantityOf_2 += 1;
                    } else {
                        System.out.println("1zł: " + initialQuantityOf_1);
                        System.out.println("2zł:" + initialQuantityOf_2);
                        System.out.println("5zł" + initialQuantityOf_5);
                        System.out.println(i);
                        return false;
                    }
                    break;
                case 5:
                    if ((2 * initialQuantityOf_2 + 1 * initialQuantityOf_1) >= 4) {
                        if (2 * initialQuantityOf_2 >= 4) {
                            initialQuantityOf_2 = initialQuantityOf_2 - 2;
                            initialQuantityOf_5 = initialQuantityOf_5 + 1;
                        } else if (initialQuantityOf_2 == 1) {
                            initialQuantityOf_2 = initialQuantityOf_2 - 1;
                            initialQuantityOf_1 = initialQuantityOf_1 - 2;
                            initialQuantityOf_5 = initialQuantityOf_5 + 1;
                        } else {
                            initialQuantityOf_1 = initialQuantityOf_1 - 4;
                            initialQuantityOf_5 = initialQuantityOf_5 + 1;
                        }
                        break;

                    }
                    System.out.println("1zł: " + initialQuantityOf_1);
                    System.out.println("2zł:" + initialQuantityOf_2);
                    System.out.println("5zł" + initialQuantityOf_5);
                    System.out.println(i);
                    return false;

            }
        }
        System.out.println("1zł: " + initialQuantityOf_1);
        System.out.println("2zł: " + initialQuantityOf_2);
        System.out.println("5zł: " + initialQuantityOf_5);
        return true;

    }
    static List<Integer> coins2() {
        Random random = new Random();
        List<Integer> listOfCoins = new ArrayList<>();
        int potentialQuntityOfCoins = random.nextInt(50)+1;

        for (int i = 0; i < potentialQuntityOfCoins; i++) {
            int coinValue = random.nextInt(3);
            switch (coinValue) {
                case 0:
                    listOfCoins.add(1);
                    break;
                case 1:
                    listOfCoins.add(2);
                    break;
                case 2:
                    listOfCoins.add(5);
                    break;

            }
        }

        return listOfCoins;
    }
}
