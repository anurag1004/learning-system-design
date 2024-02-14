package splitwise.strategies.printer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ConsolePrinter implements BalancePrinter{
    @Override
    public void print(Map<String, Map<String, Float>> balanceSheet, String userId) {
        Map<String, Set<String>> printedMap = new HashMap<>();
        boolean hasNonZeroBalance = false;
        if(userId.isEmpty()){
            // show complete balance sheet
            for(String user1: balanceSheet.keySet()){
                for(String user2: balanceSheet.get(user1).keySet()){
                    if(balanceSheet.get(user1).get(user2)!=0f){
                        hasNonZeroBalance = true;
                        printHelper(user1, user2, balanceSheet.get(user1).get(user2), printedMap);
                    }
                }
            }
        }else{
            // show for this user
            Map<String, Float> balances = balanceSheet.get(userId);
            for(String otherUser: balances.keySet()){
                if(balances.getOrDefault(otherUser, 0f)!=0f) {
                    hasNonZeroBalance = true;
                    printHelper(userId, otherUser, balances.get(otherUser), printedMap);
                }
            }
        }
        if(!hasNonZeroBalance){
            System.out.println("-------No balances-------");
        }
    }
    private void printHelper(String user1, String user2, float amount, Map<String, Set<String>> printedMap){
        printedMap.putIfAbsent(user1, new HashSet<>());
        printedMap.putIfAbsent(user2, new HashSet<>());
        if(amount<0 && (!printedMap.containsKey(user1) || !printedMap.get(user1).contains(user2))){
            System.out.printf("%s owes %s : $%.2f\n", user1, user2, -amount);
            printedMap.get(user1).add(user2);
        }else if(amount>0 && (!printedMap.containsKey(user2) || !printedMap.get(user2).contains(user1))){
            System.out.printf("%s owes %s : $%.2f\n", user2, user1, amount);
            printedMap.get(user2).add(user1);
        }
    }
}
