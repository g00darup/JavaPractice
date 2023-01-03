package main.java.com.testplayground.MoreAnimals;

import javax.sound.midi.*;

class Primate {
    public boolean hasHair() {
        return true;
    }
    public Tail tail;
}

interface HasTail {
   public boolean isTailStriped();
}

public class Lemur extends Primate implements HasTail {
    public int age = 10;

    public boolean isTailStriped() {
        return false;
    }

    public static void main(String[] args) {
        Lemur lemur = new Lemur();
        System.out.println(lemur.age);

        HasTail hasTail = lemur;
        System.out.println(hasTail.isTailStriped());

        Primate primate = lemur;
        System.out.println(primate.hasHair());

//        System.out.println(hasTail.age);              // DOES NOT COMPILE
//
//        System.out.println(primate.isTailStriped());  // DOES NOT COMPILE

        Object lemurAsObject = lemur;
        Primate primate1 = lemur;
        //Lemur lemur1 = primate1;
        Lemur lemur2 = (Lemur)primate1;
        Primate primate2 = new Primate();

        //Lemur lemur3 = (Lemur) primate2;

        System.out.println(++lemur2.age);

        HayStorage hayStorage1 = HayStorage.getInstance();
        HayStorage hayStorage2 = HayStorage.getInstance();

        if(hayStorage1.equals(hayStorage2))
            System.out.println("values are equal");

        if(hayStorage1.hashCode()==hayStorage2.hashCode()){
            System.out.println("ye");
        }



//        if(hayStorage1.hashCode()==hayStorage2.hashCode()){
//            ShortMessage myMsg = new ShortMessage();
//            // Play the note Middle C (60) moderately loud
//            // (velocity = 93)on channel 4 (zero-based).
//            try {
//                myMsg.setMessage(ShortMessage.NOTE_ON, 4, 60, 93) ;
//                Synthesizer synth = MidiSystem.getSynthesizer();
//                Receiver synthRcvr = synth.getReceiver();
//                synthRcvr.send(myMsg, -1); // -1 means no time stamp
//            } catch (InvalidMidiDataException e) {
//                e.printStackTrace();
//            } catch (MidiUnavailableException e) {
//                e.printStackTrace();
//            }
//
//        }

    }
}

class Tail{

}

 class Monkey extends Primate { // Monkey has-a Tail since it is-a Primate
}
 class Chimpanzee extends Primate { // Chimpanzee has-a Tail since it is-a Primate
}

 class Rodent {
}

 class Capybara extends Rodent {
    public static void main(String[] args) {
        Rodent rodent = new Rodent();
         // Throws ClassCastException at  // runtime

        if(rodent instanceof Capybara){
            Capybara capybara = (Capybara)rodent;
        }
    }
}

 class Flippers {
    public void flap() {
        System.out.println("The flippers flap back and forth");
    }
}

 class WebbedFeet {
    public void kick() {
        System.out.println("The webbed feet kick to and fro");
    }
}

 class Penguin {
    private final Flippers flippers;
    private final WebbedFeet webbedFeet;

    public Penguin() {
        this.flippers = new Flippers();
        this.webbedFeet = new WebbedFeet();
    }

    public void flap() {
        this.flippers.flap();
    }
    public void kick() {
        this.webbedFeet.kick();
    }
}