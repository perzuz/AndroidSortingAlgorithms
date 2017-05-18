package kbb.sortingalgorithms;

import org.junit.Test;

import kbb.sortingalgorithms.app.Presenters.SelectAlgorithmPresenterImpl;
import kbb.sortingalgorithms.app.Presenters.SelectAlgorithmPresenter;
import kbb.sortingalgorithms.app.Views.SelectAlgorithmView;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class SelectAlgorithmTests {
    @Test
    public void givenUserHasStartedApp_WhenTheUserSelectsAnAlgorithm_TheDisplayAlgorithmScreenIsOpened() throws Exception {
        //Arrange
        SelectAlgorithmView view = mock(SelectAlgorithmView.class);
        SelectAlgorithmPresenter presenter = new SelectAlgorithmPresenterImpl(view);

        //Act
        presenter.onBubbleSortAlgorithmButtonClicked();

        //Assert
        verify(view).showDisplayView(any(String.class));
    }

    @Test
    public void givenUserHasStartedApp_WhenTheUserSelectsBubbleSortAlgorithm_TheDisplayAlgorithmScreenIsOpenedWithBubbleSort() throws Exception {
        //Arrange
        SelectAlgorithmView view = mock(SelectAlgorithmView.class);
        SelectAlgorithmPresenter presenter = new SelectAlgorithmPresenterImpl(view);

        //Act
        presenter.onBubbleSortAlgorithmButtonClicked();

        //Assert
        verify(view).showDisplayView("bubble_sort");
    }
}