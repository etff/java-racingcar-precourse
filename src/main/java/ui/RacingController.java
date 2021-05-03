package ui;

import domain.Cars;
import domain.Number;
import domain.Record;
import domain.Winners;
import view.InputView;
import view.ResultView;

/**
 * 경기 요청을 처리합니다.
 */
public class RacingController {
    public static final int FIRST_GAME = 1;

    private Cars cars;
    private Record record;

    public RacingController() {
        this.cars = new Cars(InputView.askNameOfCars());
        this.record = new Record();
    }

    public void startGame() {
        moveCars();
        showResult();
    }

    private void showResult() {
        ResultView resultView = new ResultView(getWinner(), record);
        resultView.show();
    }

    private void moveCars() {
        Number count = InputView.askNumberOfTries();
        for (int i = FIRST_GAME; i <= count.getNumber(); i++) {
            this.cars = cars.move();
            record.add(i, this.cars);
        }
    }

    private Cars getWinner() {
        Winners winners = new Winners();
        return winners.findWinners(this.cars);
    }
}
