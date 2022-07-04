import java.util.*;
class Truck{
    int w;
    int l;

    public Truck(int a, int b){
        this.w = a;
        this.l = b;
    }
    public void addlength(){
        this.l++;
    }
}
public class solution {
    public static int aolution(int bridge_length, int weight, int[] truck_weights) {

        int answer = 0;
        int totalWeight = 0;
        ArrayList<Truck> truckList = new ArrayList<>();
        Stack<Integer> truckStack = new Stack<>();
        for(int i = truck_weights.length-1; i >= 0; i--){
            truckStack.push(truck_weights[i]);
        }
        while(!truckStack.isEmpty()){
            if((truckList.isEmpty()) || (totalWeight + truckStack.peek() <= weight)){
                int popTruck = truckStack.pop();
                truckList.add(new Truck(popTruck, 0));
                totalWeight += popTruck;
            }
            if(!truckList.isEmpty()){
                if(truckList.get(0).l >= bridge_length){
                    truckList.remove(0);
                    totalWeight -= truckList.get(0).w;
                }
                for(int i = 0; i < truckList.size(); i++){
                    truckList.get(i).addlength();
                    System.out.println(truckList.get(i).w);
                }
            }
            System.out.println();
            answer ++;

        }
        return answer;
    }
    public static void main(){
        System.out.println(aolution(2, 10, [7, 4, 5, 6]));
    }
}