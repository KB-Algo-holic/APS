class Solution {
    int[] maxSale = {0, 0}; // 전역 변수로 선언

    public int[] solution(int[][] users, int[] prices) {
        int[] discounts = {10, 20, 30, 40};
        Emoticon[] emoticons = new Emoticon[prices.length];
        dfs(0, discounts, prices, emoticons, users);
        return maxSale;
    }

    public void dfs(int emoticonIdx, int[] discounts, int[] prices, Emoticon[] emoticons, int[][] users) {
        if (emoticonIdx == prices.length) {
            int[] currentTotal = calculateTotal(users, emoticons);
            // 조건에 따른 최대값 갱신
            if (currentTotal[0] > maxSale[0]) {
                maxSale[0] = currentTotal[0];
                maxSale[1] = currentTotal[1];
            } else if (currentTotal[0] == maxSale[0] && currentTotal[1] > maxSale[1]) {
                maxSale[1] = currentTotal[1];
            }
            return;
        }

        for (int discount : discounts) {
            emoticons[emoticonIdx] = new Emoticon(prices[emoticonIdx], discount);
            dfs(emoticonIdx + 1, discounts, prices, emoticons, users);
        }
    }

    public int[] calculateTotal(int[][] users, Emoticon[] emoticons) {
        int currentSubscribers = 0;
        int currentTotalSales = 0;

        for (int[] user : users) {
            int userMinDiscountRate = user[0];
            int userMaxPurchaseCost = user[1];

            int userPurchaseAmount = 0;

            for (Emoticon emoticon : emoticons) {
                if (emoticon.discount >= userMinDiscountRate) {
                    userPurchaseAmount += emoticon.price;
                }
            }

            if (userPurchaseAmount >= userMaxPurchaseCost) {
                currentSubscribers++;
            } else {
                currentTotalSales += userPurchaseAmount;
            }
        }
        return new int[]{currentSubscribers, currentTotalSales};
    }
}

class Emoticon {
    int price;
    int discount;

    Emoticon(int price, int discount) {
        this.discount = discount;
        this.price = (int)(price * (100 - discount) / 100.0);
    }
}