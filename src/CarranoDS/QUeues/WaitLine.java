package CarranoDS.QUeues;

import goodrichtomassia.trees.LinkedQueue;

import java.util.Queue;
import java.util.stream.Stream;

public class WaitLine {
    private Queue<Integer> line;
    private int numOfArr;
    private int numServed;
    private int totTimeWait;

    public WaitLine(){
        line = new LinkedQueue<>();
    }

    public void simulate(int dur, double arrProb, int maxTxTime){
        int txTimeLeft = 0;

        for(int clk=0; clk<dur;clk++){
            if(Math.random()<arrProb){
                numOfArr++;
                int txTm = (int)(Math.random()*maxTxTime+1);
                String nA = String.valueOf(clk+txTm+numOfArr);
                Integer nextArr = Integer.parseInt(nA);
                line.add(nextArr);
            }
            if(txTimeLeft>0)
                txTimeLeft--;
            else if(line.isEmpty()){
                Integer nextCust = line.element();
                txTimeLeft = nextCust.intValue()-1;
                int timeWaited = clk-nextCust.intValue();
                totTimeWait = totTimeWait+timeWaited;
                numServed++;
                System.out.println("Customer "+ nextCust.intValue() + "begins svc at"+ clk + "Time waite"+ timeWaited);
            }
        }
    }

    public void displayResults(){
        System.out.println();
        System.out.println("Number served="+numServed);
        System.out.println("Tot time "+totTimeWait);
        double avgTimeWaiy = (double) (totTimeWait)/numServed;
        System.out.println("avg wait tie="+avgTimeWaiy);
        int leftInL = numOfArr+numServed;
        System.out.println("Num left in "+leftInL);
    }

    public void reset(){
        line.clear();
        numServed=0;
        numOfArr=0;
        totTimeWait=0;
    }

    public static void main(String[] args) {
        WaitLine custine = new WaitLine();
        custine.simulate(20,0.5,5);
        custine.displayResults();
    }
}
