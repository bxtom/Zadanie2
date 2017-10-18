package com.tomek;

/*
*
* 2. Napisz​ ​ program,​ ​ który​ ​ po​ ​ wpisaniu​ ​ dowolnej​ ​ liczby​ ​ całkowitej​ ​ (int)​ ​ poda​ ​ najbliższą
* liczbę​ ​ pierwszą.​ ​ W​ ​ przypadku​ ​ pojawienia​ ​ się​ ​ dwóch​ ​ o​ ​ tej​ ​ samej​ ​ bliskości,​ ​ wybierze
* większą.​ ​ np.​ ​ 6​ ​ ->​ ​ 7,​ ​ a​ ​ nie​ ​ 5.
*
* */

import java.util.Scanner;

public class Main {
    private static boolean isPrime(int number) {
        Boolean result = true;

        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                result = false;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            int input = scanner.nextInt();

            int closestPrimeForward = 0;
            int numberOfJumpsForward = 0;
            for (int i = input; i < 100; i++) {
                if (!isPrime(i)) {
                    numberOfJumpsForward++;
                } else {
                    closestPrimeForward = i;
                    break;
                }
            }

            int closestPrimeBackward = 0;
            int numberOfJumpsBackward = 0;
            for (int i = input; i > 0; i--) {
                if (!isPrime(i)) {
                    numberOfJumpsBackward++;
                } else {
                    closestPrimeBackward = i;
                    break;
                }
            }

            if (numberOfJumpsForward == numberOfJumpsBackward) {
                if (closestPrimeForward > closestPrimeBackward) {
                    System.out.println(closestPrimeForward);
                } else {
                    System.out.println(closestPrimeBackward);
                }
            } else if (numberOfJumpsForward < numberOfJumpsBackward) {
                System.out.println(closestPrimeForward);
            } else {
                System.out.println(closestPrimeBackward);
            }
        }
    }
}
