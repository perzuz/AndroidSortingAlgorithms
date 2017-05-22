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
import com.github.mikephil.charting.data.BarDataSet;
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

        binding.chart.setData(getExampleBarData());

    }

    private BarData getExampleBarData(){
        ArrayList<BarEntry> entries = new ArrayList<>();

        entries.add(new BarEntry(0,4f));
        entries.add(new BarEntry(1,8f));
        entries.add(new BarEntry(2,6f));
        entries.add(new BarEntry(3,12f));
        entries.add(new BarEntry(4,18f));
        entries.add(new BarEntry(5,9f));

        BarDataSet dataSet = new BarDataSet(entries,"LABEL");

        ArrayList<String> labels = new ArrayList<>();
        labels.add("January");
        labels.add("February");
        labels.add("March");
        labels.add("April");
        labels.add("May");
        labels.add("June");

        return new BarData(dataSet);
    }
}
