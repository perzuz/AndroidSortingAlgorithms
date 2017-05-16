package kbb.sortingalgorithms.app;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.ActionMenuItemView;
import android.view.View;
import android.widget.Toast;

import kbb.sortingalgorithms.R;
import kbb.sortingalgorithms.app.Presenters.SelectAlgorithmPresenter;
import kbb.sortingalgorithms.databinding.ActivityMainBinding;

public class SelectAlgorithmActivity extends AppCompatActivity implements SelectAlgorithmViewContract{

    ActivityMainBinding binding;

    SelectAlgorithmPresenterContract presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        presenter = new SelectAlgorithmPresenter(this);

        binding.buttonBubbleSort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onBubbleSortAlgorithmButtonClicked();
            }
        });
    }

    @Override
    public void openAlgorithmPageWithBubbleSort() {

    }
}
