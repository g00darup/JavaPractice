package goodrichtomassia.chap01;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;

public class P13BirthdayParadox {

    HashMap<Date,Integer> measureBirthdayParadoxValues(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        HashMap<Date,Integer> dateHashMap = new HashMap<>();

        for (int count = 0; count < 21; count++){
            dateHashMap.put(getRandomDate(2000,count),count);
        }

        return dateHashMap;
    }

    private Date getRandomDate(int year,int month) {
        return new Date(year,Math.abs(new Random().nextInt()) % 12, month % 2 ==0 ? Math.abs(new Random().nextInt()) % 30 :
                Math.abs(new Random().nextInt()) % 31);
    }

    public static void main(String[] args) {
        P13BirthdayParadox bp = new P13BirthdayParadox();
        HashMap<Date,Integer> map = bp.measureBirthdayParadoxValues();
        map.entrySet().stream().forEach(System.out::println);

        int count = 21;

        while(true){
            Date randomDate = bp.getRandomDate(2000, count);
            System.out.println(randomDate);
            if (!map.containsKey(randomDate)) {
                map.put(randomDate, count);
                count++;
            }
            else
                break;

        }

        System.out.println("Birthday paradox resolves at: " + count + " trials");
    }
}
