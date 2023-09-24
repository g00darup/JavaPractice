package CarranoDS.Chap01.Projects;

public class WeekDemo1 {
    public enum Day {MON,TUE,WED,THU,FRI,SAT,SUN};
    public static void main(String[] args){
        Day d = Day.MON;
        System.out.println("Initial day is:"+generateComment(d));
        Day t = Day.WED;
        System.out.println("Now day is:"+generateComment(t));
        System.out.println("Are days d and t same? "+(d==t));
    }

    public static String generateComment(Day day){
        switch(day){

            case MON -> {
                return("Monday");
            }
            case TUE -> {
                return("Tue");
            }
            case WED -> {
                return("Wed");
            }
            case THU -> {
                return("thu");
            }
            case FRI -> {
                return("fri");
            }
            case SAT -> {
                return("sat");
            }
            case SUN -> {
                return("sun");
            }
        }
        return null;
    }
}
