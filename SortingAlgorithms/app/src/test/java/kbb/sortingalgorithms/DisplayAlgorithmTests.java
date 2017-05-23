package kbb.sortingalgorithms;

import org.junit.Test;

import java.util.ArrayList;

import kbb.sortingalgorithms.app.Models.DisplayAlgorithmModel;
import kbb.sortingalgorithms.app.Models.DisplayAlgorithmModelImpl;
import kbb.sortingalgorithms.app.Presenters.DisplayAlgorithmPresenter;
import kbb.sortingalgorithms.app.Presenters.DisplayAlgorithmPresenterImpl;
import kbb.sortingalgorithms.app.Views.DisplayAlgorithmView;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by Harris on 18/05/2017.
 */

public class DisplayAlgorithmTests {
    @Test
    public void givenUserHasStartedApp_WhenTheUserSelectsBubbleSortAlgorithm_TheModelRetrievesATitleFromTheAlgorithmStringKey() throws Exception {
        //Arrange
        DisplayAlgorithmView view = mock(DisplayAlgorithmView.class);
        DisplayAlgorithmModel model = mock(DisplayAlgorithmModel.class);
        DisplayAlgorithmPresenter presenter = new DisplayAlgorithmPresenterImpl(view, model);
        String titleKey = "test_title";

        //Act
        presenter.onStart(titleKey);

        //Assert
        verify(model).getTitleFromAlgorithmKey(titleKey);
    }

    @Test
    public void givenUserHasStartedApp_WhenTheUserSelectsBubbleSortAlgorithm_TheTitleOfTheDisplayFragmentIsSetToBubbleSort() throws Exception {
        //Arrange
        DisplayAlgorithmView view = mock(DisplayAlgorithmView.class);
        DisplayAlgorithmModel model = new DisplayAlgorithmModelImpl();
        DisplayAlgorithmPresenter presenter = new DisplayAlgorithmPresenterImpl(view, model);
        String titleKey = "test_title";
        String expectedTitle = "test title";

        //Act
        presenter.onStart(titleKey);

        //Assert
        verify(view).setTitle(expectedTitle);
    }

    @Test
    public void givenUserHasStartedApp_WhenTheUserEntersDisplayMode_ThePresenterGetsTheDefaultDataFromTheModel() throws Exception {
        //Arrange
        DisplayAlgorithmView view = mock(DisplayAlgorithmView.class);
        DisplayAlgorithmModel model = mock(DisplayAlgorithmModel.class);
        DisplayAlgorithmPresenter presenter = new DisplayAlgorithmPresenterImpl(view, model);
        String titleKey = "test_title";

        //Act
        presenter.onStart(titleKey);


        //Assert
        verify(model).getDefaultData();
    }

    @Test
    public void givenUserHasStartedApp_WhenTheUserEntersDisplayMode_TheBarChartDisplaysDefaultData() throws Exception {
        //Arrange
        DisplayAlgorithmView view = mock(DisplayAlgorithmView.class);
        DisplayAlgorithmModel model = new DisplayAlgorithmModelImpl();
        DisplayAlgorithmPresenter presenter = new DisplayAlgorithmPresenterImpl(view, model);
        String titleKey = "test_title";
        ArrayList<Integer> defaultData = new ArrayList<>();
        for (int i=1;i <= 100; i++){
            defaultData.add(i);
        }

        //Act
        presenter.onStart(titleKey);

        //Assert
        verify(view).setChartData(defaultData);
    }
}
