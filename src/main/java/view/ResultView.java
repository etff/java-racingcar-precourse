package view;

import domain.Car;
import domain.Cars;
import domain.Record;

/**
 * 경기 결과를 출력한다.
 */
public class ResultView {
    public static final int FIRST_GAME = 1;
    public static final int MARGIN = 1;
    public static final int START_TEXT_INDEX = 0;
    public static final String DASH = "-";
    public static final String COLUMN = ": ";
    public static final String COMMA = ",";
    public static final String GAME_RESULT = "실행결과";
    public static final String WINNER_MESSAGE = "가 최종 우승했습니다.";

    private Cars winners;
    private Record record;

    public ResultView(Cars winners, Record record) {
        this.winners = winners;
        this.record = record;
    }

    public void show() {
        System.out.println(GAME_RESULT);
        for (int count = FIRST_GAME; count <= record.size(); count++) {
            Cars record = this.record.getRecord(count);
            showCarPositions(record);
            System.out.println();
        }
        showWinner();
    }

    private String showGraph(int position) {
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < position; j++) {
            sb.append(DASH);
        }
        return sb.toString();
    }

    private void showCarPositions(Cars cars) {
        for (Car car : cars.getCars()) {
            final String playerName = car.getName();
            final String position = showGraph(car.getPosition());
            System.out.println(playerName + COLUMN + position);
        }
    }

    private void showWinner() {
        StringBuilder sb = new StringBuilder();
        for (Car car : winners.getCars()) {
            sb.append(car.getName() + COMMA);
        }
        final String winners = sb.substring(START_TEXT_INDEX, sb.length() - MARGIN);
        System.out.println(winners + WINNER_MESSAGE);
    }
}
