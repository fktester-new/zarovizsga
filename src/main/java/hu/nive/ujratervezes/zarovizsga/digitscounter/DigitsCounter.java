package hu.nive.ujratervezes.zarovizsga.digitscounter;

import java.util.HashSet;
import java.util.Set;

public class DigitsCounter {

    public int getCountOfDigits(String s){
        Set<Integer> result = new HashSet<>();
        if (! isEmpty(s)){
            String[] chars = s.split("");
            for (int i = 0; i < chars.length; i++){
                if (isNumber(chars[i])){
                    result.add(Integer.parseInt(chars[i]));
                }
            }
            return result.size();
        } else {
            return 0;
        }

    }

    public boolean isEmpty(String s){
        return s == null || "".equals(s);
    }

    private boolean isNumber(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }
}
