package kbb.sortingalgorithms;

import android.provider.ContactsContract;

import org.junit.Test;
import org.mockito.InOrder;

import java.util.ArrayList;

import kbb.sortingalgorithms.app.Helpers.DataOrganiser;
import kbb.sortingalgorithms.app.Models.DisplayAlgorithmModel;
import kbb.sortingalgorithms.app.Models.DisplayAlgorithmModelImpl;
import kbb.sortingalgorithms.app.Presenters.DisplayAlgorithmPresenter;
import kbb.sortingalgorithms.app.Presenters.DisplayAlgorithmPresenterImpl;
import kbb.sortingalgorithms.app.Views.DisplayAlgorithmView;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.ArgumentMatchers.anyListOf;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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
        DataOrganiser dataOrganiser = mock(DataOrganiser.class);
        DisplayAlgorithmView view = mock(DisplayAlgorithmView.class);
        DisplayAlgorithmModel model = new DisplayAlgorithmModelImpl(dataOrganiser);
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
        DataOrganiser dataOrganiser = mock(DataOrganiser.class);
        DisplayAlgorithmView view = mock(DisplayAlgorithmView.class);
        DisplayAlgorithmModel model = new DisplayAlgorithmModelImpl(dataOrganiser);
        DisplayAlgorithmPresenter presenter = new DisplayAlgorithmPresenterImpl(view, model);
        String titleKey = "test_title";
        ArrayList<Integer> defaultData = new ArrayList<>();
        for (int i=1;i <= 100; i++){
            defaultData.add(i);
        }

        when(dataOrganiser.shuffle(defaultData)).thenReturn(defaultData);

        //Act
        presenter.onStart(titleKey);

        //Assert
        verify(view).setChartData(defaultData);
    }

    @Test
    public void givenUserHasStartedApp_WhenTheUserEntersDisplayMode_DefaultDataIsShuffled() throws Exception {
        //Arrange
        DataOrganiser dataOrganiser = mock(DataOrganiser.class);
        DisplayAlgorithmView view = mock(DisplayAlgorithmView.class);
        DisplayAlgorithmModel model = new DisplayAlgorithmModelImpl(dataOrganiser);
        DisplayAlgorithmPresenter presenter = new DisplayAlgorithmPresenterImpl(view, model);
        String titleKey = "test_title";
        ArrayList<Integer> defaultData = new ArrayList<>();
        for (int i=1;i <= 100; i++){
            defaultData.add(i);
        }

        //Act
        presenter.onStart(titleKey);

        //Assert
        verify(dataOrganiser).shuffle(defaultData);
    }

    @Test
    public void givenTheUserHasEnteredDisplayMode_whenTheUserPressesTheSortButton_TheModelRecievesACallToSort() throws Exception {
        //Arrange
        DisplayAlgorithmView view = mock(DisplayAlgorithmView.class);
        DisplayAlgorithmModel model = mock(DisplayAlgorithmModel.class);
        DisplayAlgorithmPresenter presenter = new DisplayAlgorithmPresenterImpl(view, model);

        //Act
        presenter.onSortButtonClicked();

        //Assert
        verify(model).sort(any(ArrayList.class));
    }

    @Test
    public void givenTheUserHasEnteredBubbleSortDisplayMode_whenTheUserPressesTheSortButton_TheDataOrganiserBubbleSortsTheData() throws Exception {
        //Arrange
        DataOrganiser dataOrganiser = mock(DataOrganiser.class);
        DisplayAlgorithmView view = mock(DisplayAlgorithmView.class);
        DisplayAlgorithmModel model = new DisplayAlgorithmModelImpl(dataOrganiser);
        DisplayAlgorithmPresenter presenter = new DisplayAlgorithmPresenterImpl(view, model);
        String algorithmKey = "bubble_sort";
        ArrayList<Integer> defaultData = new ArrayList<>();
        for (int i=1;i <= 100; i++){
            defaultData.add(i);
        }

        //Act
        presenter.onStart(algorithmKey);
        presenter.onSortButtonClicked();

        //Assert
        verify(dataOrganiser).bubbleSort(defaultData);
    }

    @Test
    public void givenTheUserHasEnteredBubbleSortDisplayMode_whenTheUserPressesTheSortButton_TheChartDataIsSetToEachIterationInOrder() throws Exception {
        //Arrange
        DisplayAlgorithmView view = mock(DisplayAlgorithmView.class);
        DisplayAlgorithmModel model = mock(DisplayAlgorithmModel.class);
        DisplayAlgorithmPresenter presenter = new DisplayAlgorithmPresenterImpl(view, model);
        String algorithmKey = "bubble_sort";
        ArrayList<Integer> defaultData = new ArrayList<>();
        for (int i=3;i >= 1; i--){
            defaultData.add(i);
        }
        when(model.getDefaultData()).thenReturn(defaultData);

        ArrayList<Integer> firstPass = new ArrayList<>();
        firstPass.add(2);
        firstPass.add(3);
        firstPass.add(1);

        ArrayList<Integer> secondPass = new ArrayList<>();
        secondPass.add(2);
        secondPass.add(1);
        secondPass.add(3);

        ArrayList<Integer> thirdPass = new ArrayList<>();
        thirdPass.add(1);
        thirdPass.add(2);
        thirdPass.add(3);

        ArrayList<ArrayList<Integer>> dataSet = new ArrayList<>();
        dataSet.add(firstPass);
        dataSet.add(secondPass);
        dataSet.add(thirdPass);

        when(model.sort(defaultData)).thenReturn(dataSet);

        //Act
        presenter.onStart(algorithmKey);
        presenter.onSortButtonClicked();

        //Assert
        InOrder inOrder = inOrder(view);

        inOrder.verify(view).setChartData(firstPass);
        inOrder.verify(view).setChartData(secondPass);
        inOrder.verify(view).setChartData(thirdPass);
    }
}
