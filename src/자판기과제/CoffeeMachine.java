/*
종이컵 자판기

필드 변수
- 커피1
- 커피2
- 커피3
- 커피4

메소드 동작

돈을 입력(넣으면)하면
커피자판기 안에 커피 및 종이컵 재고를 파악 후에 제조 가능한 버튼만 활성화 된다
커피1~4까지 버튼을 누를 수 있다
(커피제조1회당 1번만 가능 연속 입력 불가)
만약 커피자판기에 입력한 돈이 부족하면 버튼이 비활성이 되고
디스플레이 문구에 (금액이 부족합니다. 돈이 부족합니다.)라고 뜬다
커피 가격과 동일한 금액 또는 그 이상 금액이 입력되면 버튼이 활성화 된다
원하는 커피 버튼을 누르면 제조 후 커피가 나온다
(커피가 제조시에는 금액을 추가로 넣거나 모든 커피 버튼은 비활성화)
커피 제조 완료 후에 잔액을 반환 받거나 다시 커피 버튼이 활성화 된다.
 */

	// 메뉴 출력 부분
	
	//금액 투입
	
	//커피, 종이컵 무제한 잔돈 무한
	
	//커피1 ~ 커피 4버튼 생성
	
	//금액확인 후
	
	//음료 제조


package 자판기과제;

import java.util.Scanner;

public class CoffeeMachine {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean run = true;
        String [] drinks = {"밀크커피","설탕커피","블랙커피","코코아"};
        int [] prices = {300, 300, 300, 300};
        Drink drink = new Drink(drinks,prices,0);

        boolean[] coffeeButtonActive = {true, true, true, true};
        long[] coffeeButtonTimers = {0, 0, 0, 0};


        // 금액 투입

        System.out.print("자판기를 작동하려면 금액을 투입해주세요");
        int money = scanner.nextInt();
        scanner.nextLine();
        boolean buttonAvailable = true;

        while (money < 100) {

            System.out.println("100원 이상 금액을 투입해주세요");
            money = scanner.nextInt();

            if (money < 100) {
                System.out.println("금액이 부족합니다. 100원이상 투입해주세요");
            }
        }
            drink.setMoney(money);
            System.out.println("커피 버튼을 눌러주세요");

            //메뉴
            while (run) {

                long currentTime = System.currentTimeMillis();
                drink.printMenu();
                String coffeeNum = scanner.next();

                for (int i = 0; i < coffeeButtonActive.length; i++) {
                    if (!coffeeButtonActive[i] && currentTime - coffeeButtonTimers[i] >= 10000) {
                        coffeeButtonActive[i] = true;  // 30초가 지나면 버튼 활성화
                    }
                }

                //음료 선택 및 반환
                switch (coffeeNum) {

                    case "1":

                        if (!coffeeButtonActive[0]) {

                            System.out.println("음료를 만들고있습니다... 10초 기다려주세요.");
                        } else if (money >= prices[0]) {

                            // 금액이 충분한 경우
                            System.out.println("밀크커피를 선택하셨습니다. 커피가 10초 후에 나옵니다.");
                            money -= prices[0];
                            drink.setMoney(money);
                            System.out.println("현재 남은 잔액은 "+ money + "원 입니다");

                            // 버튼 비활성화 및 타이머 설정
                            coffeeButtonActive[0] = false;  // 버튼 비활성화
                            coffeeButtonTimers[0] = currentTime; // 버튼 누른 시간 기록

                        } else {
                            drink.moneyReturn();
                            break;
                        }
                        break;

                    case "2":

                        if (!coffeeButtonActive[0]) {
                            System.out.println("음료를 만들고있습니다... 10초 기다려주세요.");
                        } else if (money >= prices[1]) {
                            System.out.println("설탕커피를 선택하셨습니다. 커피가 10초 후에 나옵니다.");
                            money -= prices[1];
                            drink.setMoney(money);// 금액 차감
                            System.out.println("현재 남은 잔액은 "+ money + "원 입니다");

                            // 버튼 비활성화 및 타이머 설정
                            coffeeButtonActive[0] = false;  // 버튼 비활성화
                            coffeeButtonTimers[0] = currentTime; // 버튼 누른 시간 기록

                        } else {
                            drink.moneyReturn();
                            break;
                        }
                        break;

                    case "3":

                        if (!coffeeButtonActive[0]) {
                            System.out.println("음료를 만들고있습니다... 10초 기다려주세요.");
                        } else if (money >= prices[2]) {
                            System.out.println("블랙커피를 선택하셨습니다. 커피가 10초 후에 나옵니다.");
                            money -= prices[2];
                            drink.setMoney(money);// 금액 차감
                            System.out.println("현재 남은 잔액은 "+ money + "원 입니다");
                            break;
                        } else {
                            drink.moneyReturn();
                            break;
                        }
                        break;

                    case "4":

                        if (!coffeeButtonActive[0]) {
                            System.out.println("음료를 만들고있습니다... 10초 기다려주세요.");
                        } else if (money >= prices[3]) {
                            System.out.println("코코아를 선택하셨습니다. 코코아가 10초 후에 나옵니다.");
                            money -= prices[3];
                            drink.setMoney(money);// 금액 차감
                            System.out.println("현재 남은 잔액은 "+ money + "원 입니다");
                            break;
                        } else {
                            drink.moneyReturn();
                            break;
                        }
                        break;

                    case "5":

                        drink.setMoney(money);// 금액 차감
                        System.out.println("잔액 " + money + "원이 반환되어었습니다.");
                        run = false;
                        break;

                    default:
                        System.out.println("음료는 1번~4번 ( 5.반환 ) 숫자를 다시 입력해주세요.");
                        break;
                }

            }
        }
    }
