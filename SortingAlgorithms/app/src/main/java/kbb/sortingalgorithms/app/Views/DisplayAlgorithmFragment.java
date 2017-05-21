package kbb.sortingalgorithms.app.Views;

import android.annotation.SuppressLint;
import android.databinding.DataBindingUtil;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;

import java.io.Serializable;
import java.util.ArrayList;

import kbb.sortingalgorithms.R;
import kbb.sortingalgorithms.app.Presenters.DisplayAlgorithmPresenter;
import kbb.sortingalgorithms.databinding.FragmentDisplayAlgorithmBinding;

/**
 * Created by Harris on 16/05/2017.
 */

@SuppressLint("ValidFragment")
public class DisplayAlgorithmFragment extends android.support.v4.app.Fragment implements DisplayAlgorithmView{

    private FragmentDisplayAlgorithmBinding binding;

    private DisplayAlgorithmPresenter presenter;

    private String algorithmKey;

    public DisplayAlgorithmFragment(String algorithmKey){
        this.algorithmKey = algorithmKey;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_display_algorithm, container, false);
        this.presenter.onStart(this.algorithmKey);

        return binding.getRoot();
    }

    @Override
    public void setPresenter(DisplayAlgorithmPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void setTitle(String title) {
        binding.title.setPaintFlags(binding.title.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        binding.title.setText(title);

        ArrayList<Integer> integers = new ArrayList<Integer>();
        integers.add(0,24);
        integers.add(1,12);
        integers.add(2,36);
        integers.add(3,65);

        ArrayList<BarEntry> entries = new ArrayList<>();

        for (Integer data : integers) {
            entries.add(new BarEntry(data,1));
        }

        BarEntry entry = new BarEntry(10,4);
        BarData barData = new BarData();
        barData.addEntry(entry,1);

        binding.chart.setData(barData);
        binding.chart.invalidate();
    }
}
