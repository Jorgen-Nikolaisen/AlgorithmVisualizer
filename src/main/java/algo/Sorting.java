package algo;

import java.util.List;

public class Sorting {

    private List<Integer> vals;
    private int currentIndex;
    private int nextIndex;
    private boolean insertionSort;

    public Sorting(List<Integer> vals){
        this.vals = vals;
        this.currentIndex = 1;
        this.nextIndex = 0;
        this.insertionSort = false;
    }

    public void setInsertionSort(boolean insertionSort){
        this.insertionSort = insertionSort;
    }

    public boolean bubbleSortStep(int[] indices){
        if(currentIndex < vals.size() - 1){
            if(nextIndex < vals.size() - currentIndex - 1){
                indices[0] = nextIndex;
                indices[1] = nextIndex + 1;
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

    public boolean insertionSortStep(int[] indices){
        if(currentIndex <  vals.size()){
            int key = vals.get(currentIndex);
            int j = currentIndex - 1;
            indices[0] = currentIndex;
            indices[1] = j;
            while(j >= 0 && vals.get(j) > key){
                vals.set(j + 1, vals.get(j));
                j--;
            }
            vals.set(j + 1, key);
            currentIndex++;
            return true;
        }
        return false;

    }


    public List<Integer> getVals(){
        return vals;
    }
}
