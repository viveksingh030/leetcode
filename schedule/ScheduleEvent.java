import java.util.*;

public class ScheduleEvent {
    public static void main(String[] args) {
        List<List<Pair>> events=new ArrayList<>();
        List<Pair> list = Arrays.asList(new Pair(630, 685), new Pair(690, 740), new Pair(885, 945),
                new Pair(960, 1005));
        List<Pair> list1 = Arrays.asList(new Pair(570, 595), new Pair(690, 720));
        List<Pair> list2 = Arrays.asList(new Pair(690, 775), new Pair(885, 945), new Pair(945, 1005),
                new Pair(960, 1005));
        events.add(list);
        events.add(list1);
        events.add(list2);
        List<Pair> freeSlots = findFreeSlots(events);
        for (Pair freeSlot : freeSlots) {
            int hourS=freeSlot.start/60;
            int minuteS=freeSlot.start%60;
            int hourE=freeSlot.end/60;
            int minuteE=freeSlot.end%60;
            System.out.println(hourS+":"+minuteS+"->"+hourE+":"+minuteE);
        }
    }
    
    
    static List<Pair> findFreeSlots(List<List<Pair>> userEvetns){
        if(userEvetns.isEmpty()){
            return new ArrayList<>();
        }
        List<Pair> result=new ArrayList<>();
        PriorityQueue<Pair> priorityQueue=new PriorityQueue<>(Comparator.comparingInt(a -> a.start));
        for(int i=0;i<userEvetns.size();i++){
            for(Pair pair:userEvetns.get(i)){
                priorityQueue.add(pair);
            }
        }
        int startTime=priorityQueue.poll().end;
        while(!priorityQueue.isEmpty()){
            Pair pair=priorityQueue.poll();
            if(pair.start<(startTime+15)){
                startTime=Math.max(startTime, pair.end);
            }else{
                result.add(new Pair(startTime,pair.start));
                startTime=pair.end;
            }
        }
        //result.add(new Pair(startTime,startTime+15));
        return result;
    }
    
    
    static class Pair{
        int start;
        int end;
        Pair(int start,int end){
            this.start=start;
            this.end=end;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }
    
    
}