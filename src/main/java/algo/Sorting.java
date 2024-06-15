package algo;

import java.util.List;

public class Sorting {

    private List<Integer> vals;
    private int currentIndex;
    private int nextIndex;

    public Sorting(List<Integer> vals){
        this.vals = vals;
        this.currentIndex = 0;
        this.nextIndex = 0;
    }

    public boolean bubbleSortStep(){
        if(currentIndex < vals.size() - 1){
            if(nextIndex < vals.size() - currentIndex - 1){
                if(vals.get(nextIndex) > vals.get(nextIndex + 1)){
                    int temp = vals.get(nextIndex);
                    vals.set(nextIndex, vals.get(nextIndex + 1));
                    vals.set(nextIndex + 1, temp);
                }
                nextIndex++;
            }
            else{
                nextIndex = 0;
                currentIndex++;
            }
            return true;
        }

        return false;
    }

    public List<Integer> getVals(){
        return vals;
    }
}