package kbb.sortingalgorithms;

import org.junit.Test;
import org.mockito.Mockito;

import kbb.sortingalgorithms.app.Models.SelectAlgorithmModel;
import kbb.sortingalgorithms.app.Presenters.SelectAlgorithmPresenterImpl;
import kbb.sortingalgorithms.app.Presenters.SelectAlgorithmPresenter;
import kbb.sortingalgorithms.app.Views.SelectAlgorithmView;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class SelectAlgorithmTests {
    @Test
    public void givenUserHasStartedApp_WhenTheUserSelectsTheBubbleSortAlgorithm_TheDisplayAlgorithmIsOpenedWithBubbleSort() throws Exception {
        //Arrange
        SelectAlgorithmModel model = mock(SelectAlgorithmModel.class);
        SelectAlgorithmView view = mock(SelectAlgorithmView.class);
        SelectAlgorithmPresenter presenter = new SelectAlgorithmPresenterImpl(view,model);

        //Act
        presenter.onBubbleSortAlgorithmButtonClicked();

        //Assert
        Mockito.verify(view, Mockito.times(1)).openAlgorithmPageWithBubbleSort();
    }


    @Test
    public void givenUserHasStartedApp_WhenTheUserSelectsTheBubbleSortAlgorithm_TheAlgorithmFactoryCreatesBubbleSort() throws Exception {
        //Arrange
        SelectAlgorithmModel model = mock(SelectAlgorithmModel.class);
        SelectAlgorithmView view = mock(SelectAlgorithmView.class);
        SelectAlgorithmPresenter presenter = new SelectAlgorithmPresenterImpl(view, model);

        //Act
        presenter.onBubbleSortAlgorithmButtonClicked();

        //Assert
        verify(model).getBubbleSortAlgorithm();
    }
}