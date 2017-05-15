package kbb.sortingalgorithms;

import org.junit.Test;
import org.mockito.Mockito;

import Presenters.SelectAlgorithmPresenter;
import kbb.sortingalgorithms.Contracts.SelectAlgorithmPresenterContract;
import kbb.sortingalgorithms.Contracts.SelectAlgorithmViewContract;

import static org.junit.Assert.*;

public class SelectAglorithmTests {
    @Test
    public void givenUserHasStartedApp_WhenTheUserSelectsTheBubbleSortAlgorithm_TheAlgorithmFactoryCreatesBubbleSort() throws Exception {
        //Arrange
        SelectAlgorithmViewContract view = Mockito.mock(SelectAlgorithmViewContract.class);
        SelectAlgorithmPresenterContract presenter = new SelectAlgorithmPresenter(view);

        //Act
        presenter.onBubbleSortAlgorithmButtonClicked();

        //Assert
        Mockito.verify(view,Mockito.times(1)).openAlgorithmPageWithBubbleSort();
    }
}