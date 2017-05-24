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
        for (int i = data.size() - 1; i > 0; i--)
        {
            index = random.nextInt(i + 1);
            temp = data.get(index);
            data.set(index, data.get(i));
            data.set(i, temp);

        }

        return data;
    }

    @Override
    public ArrayList<ArrayList<Integer>> bubbleSort(ArrayList<Integer> data) {
        return null;
    }
}
