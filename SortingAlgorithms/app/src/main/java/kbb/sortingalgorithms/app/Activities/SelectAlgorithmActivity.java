package kbb.sortingalgorithms.app.Activities;

import android.databinding.DataBindingUtil;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import kbb.sortingalgorithms.R;
import kbb.sortingalgorithms.app.Presenters.SelectAlgorithmPresenter;
import kbb.sortingalgorithms.app.Presenters.SelectAlgorithmPresenterImpl;
import kbb.sortingalgorithms.app.Views.DisplayAlgorithmFragment;
import kbb.sortingalgorithms.app.Views.SelectAlgorithmFragment;
import kbb.sortingalgorithms.databinding.ActivityMainBinding;

public class SelectAlgorithmActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    SelectAlgorithmPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        SelectAlgorithmFragment view = new SelectAlgorithmFragment();

        presenter = new SelectAlgorithmPresenterImpl(view);

        view.setPresenter(presenter);

        FragmentManager manager = getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(binding.getRoot().getId(), view).commit();
    }

    public void startFragment(DisplayAlgorithmFragment fragment){
        // do something similar here as to the method above where you set everything up for the frag

        //Make sure tests are as up to date aas possible and make sure you do some refactoring here

        FragmentManager manager = getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(binding.getRoot().getId(), fragment).addToBackStack(fragment.getTag()).commit();
    }
}
