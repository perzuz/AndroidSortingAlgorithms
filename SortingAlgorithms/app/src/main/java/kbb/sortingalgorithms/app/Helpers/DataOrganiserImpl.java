package kbb.sortingalgorithms.app.Helpers;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Harris on 23/05/2017.
 */

public class DataOrganiserImpl implements DataOrganiser {

    @Override
    public ArrayList<Integer> shuffle(ArrayList<Integer> data) {
        int index, temp;
        Random random = new Random();
        for (int i = data.size() - 1; i > 0; i--) {
            index = random.nextInt(i + 1);
            temp = data.get(index);
            data.set(index, data.get(i));
            data.set(i, temp);

        }

        return data;
    }

    @Override
    public ArrayList<ArrayList<Integer>> bubbleSort(ArrayList<Integer> data) {

        ArrayList<ArrayList<Integer>> states = new ArrayList<>();

        int n = data.size();
        int temp = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (data.get(j - 1) > data.get(j)) {
                    temp = data.get(j - 1);
                    data.set(j - 1, data.get(j));
                    data.set(j, temp);
                    states.add(data);
                }

            }
        }
        return states;
    }
}