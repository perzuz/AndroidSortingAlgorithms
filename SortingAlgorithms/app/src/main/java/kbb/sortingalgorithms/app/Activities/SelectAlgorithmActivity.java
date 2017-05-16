package kbb.sortingalgorithms.app.Activities;

import android.databinding.DataBindingUtil;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import kbb.sortingalgorithms.R;
import kbb.sortingalgorithms.app.Models.SelectAlgorithmModel;
import kbb.sortingalgorithms.app.Models.SelectAlgorithmModelImpl;
import kbb.sortingalgorithms.app.Presenters.SelectAlgorithmPresenter;
import kbb.sortingalgorithms.app.Presenters.SelectAlgorithmPresenterImpl;
import kbb.sortingalgorithms.app.Views.SelectAlgorithmFragment;
import kbb.sortingalgorithms.databinding.ActivityMainBinding;

public class SelectAlgorithmActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    SelectAlgorithmPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        SelectAlgorithmModel model = new SelectAlgorithmModelImpl();

        SelectAlgorithmFragment view = new SelectAlgorithmFragment();

        presenter = new SelectAlgorithmPresenterImpl(view,model);

        view.setPresenter(presenter);

        FragmentManager manager = getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(binding.getRoot().getId(), view).commit();
    }
}
