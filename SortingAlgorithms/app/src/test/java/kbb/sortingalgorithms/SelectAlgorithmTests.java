package kbb.sortingalgorithms;

import org.junit.Test;
import org.mockito.Mockito;

import kbb.sortingalgorithms.app.Presenters.SelectAlgorithmPresenter;
import kbb.sortingalgorithms.app.SelectAlgorithmPresenterContract;
import kbb.sortingalgorithms.app.SelectAlgorithmViewContract;

public class SelectAlgorithmTests {
    @Test
    public void givenUserHasStartedApp_WhenTheUserSelectsTheBubbleSortAlgorithm_TheAlgorithmFactoryCreatesBubbleSort() throws Exception {
        //Arrange
        SelectAlgorithmViewContract view = Mockito.mock(SelectAlgorithmViewContract.class);
        SelectAlgorithmPresenterContract presenter = new SelectAlgorithmPresenter(view);

        //Act
        presenter.onBubbleSortAlgorithmButtonClicked();

        //Assert
        Mockito.verify(view, Mockito.times(1)).openAlgorithmPageWithBubbleSort();
    }
}