import java.util.*;
public class maxhp {
    List<Integer> array = new ArrayList<Integer>();
    public void Heap(Integer key) {
        array.add(key);
        int i = array.size()-1;
        while (i > 0 && array.get(i/2) < array.get(i)) {
            int x = array.get(i);
            array.set(i,array.get(i/2));
            array.set(i/2,x);
            i = i/2;
        }
    }
    public void Heap_deletion(Integer Index) {
        if(array.size()-1 == 0){
            array.remove(array.get(0));
        } else {
            int x = array.get(array.size()-1);
            array.remove(array.size()-1);
            System.out.println(array.get(0)+" is removed");
            array.set(0,x);
            int indexx = 0;
            while((indexx*2)+1 <= array.size()-1 || ((indexx*2)+2 <= array.size()-1)) {
                if ((indexx * 2) + 2 > array.size() - 1) {
                    if (array.get((indexx * 2) + 1) > array.get(indexx)) {
                        x = array.get(indexx);
                        array.set(indexx, array.get((indexx * 2) + 1));
                        array.set((indexx * 2) + 1, x);
                        indexx = (indexx * 2) + 1;
                    } else {
                        return;
                    }
                } else if (array.get((indexx * 2) + 1) > array.get((indexx * 2) + 2)) {
                    if (array.get((indexx*2)+1) > array.get(indexx)){
                        x = array.get(indexx);
                        array.set(indexx, array.get((indexx * 2) + 1));
                        array.set((indexx * 2) + 1, x);
                        indexx = (indexx * 2) + 1;
                    } else {
                        return;
                    }
                } else if (array.get((indexx * 2) + 1) < array.get((indexx * 2) + 2)) {
                    if (array.get((indexx*2)+2) > array.get(indexx)){
                        x = array.get(indexx);
                        array.set(indexx, array.get((indexx * 2) + 2));
                        array.set((indexx * 2) + 2, x);
                        indexx = (indexx * 2) + 2;
                    } else {
                        return;
                    }
                }
            }
        }
        System.out.println(array);
    }
    public static void main(String[] args) {
        maxhp obj = new maxhp();
        Integer[] arr = {5,2,4,1,6,8,1,0,10,11,3};
        for(int j: arr) {
            obj.Heap(j);
        }
        System.out.println(obj.array);
        int y = obj.array.size();
        for(int i=0; i < y;i++) {
            obj.Heap_deletion(0);
        }
    }
}
