package 자판기과제;

public class Drink {

    //객체생성
    private String [] drinks;
    private int [] prices;
    private int money;

    public Drink(String [] drinks, int [] prices, int money ) {

        this.drinks = drinks;
        this.prices = prices;
        this.money = 0;

    }
        //메뉴판
        public void printMenu(){
            System.out.println("----------------------------------------------------------------------------------");
            System.out.println("--------------------------------종이컵 자판기 --------------------------------------");
            System.out.println("----------------------------------------------------------------------------------");
            for (int i = 0; i < drinks.length; i++) {
                System.out.printf("| %d.%s %d원 ", i + 1, drinks[i], prices[i]);
            }
            System.out.println("| 5. 잔액반환  |");
            System.out.println("----------------------------------------------------------------------------------");
            System.out.println("------------------------------현재 남은 금액은 : "+ getMoney() + "원----------------------------");
        }

        public void moneyReturn(){
            System.out.println("금액이 부족합니다.");
            System.out.println("현재 남은 잔액은 "+ money+"원 입니다.");
        }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getPrice(int drinkIndex) {
                return (drinkIndex);
            }
        }

