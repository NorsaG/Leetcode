package edu.leetcode.tasks.medium;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * 2022-08-15
 */
public class ChessGameRound {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("HH:mm");
    private static final LocalTime zero = LocalTime.of(0, 0);

    public int numberOfRounds(String loginTime, String logoutTime) {
        LocalTime from = LocalTime.parse(loginTime, FORMATTER);
        LocalTime to = LocalTime.parse(logoutTime, FORMATTER);

        int minutesFrom = from.getHour() * 60 + from.getMinute();
        int minutesTo = to.equals(zero) ? 24 * 60 : to.getHour() * 60 + to.getMinute();

        int diff = minutesTo - minutesFrom;
        if (diff >= 0 && diff < 15) {
            return 0;
        } else if (diff < 0) {
            minutesFrom = minutesFrom % 15 == 0 ? minutesFrom : minutesFrom + 15 - minutesFrom % 15;
            minutesTo -= minutesTo % 15;
            diff = 24 * 60 - minutesFrom + minutesTo;
        } else {
            minutesFrom = minutesFrom % 15 == 0 ? minutesFrom : minutesFrom + 15 - minutesFrom % 15;
            minutesTo -= minutesTo % 15;
            diff = minutesTo - minutesFrom;
        }

        return diff / 15;
    }


    public static void main(String[] args) {
        ChessGameRound round = new ChessGameRound();
        System.out.println(round.numberOfRounds("00:00", "01:00"));
        System.out.println(round.numberOfRounds("09:31", "10:14"));
        System.out.println(round.numberOfRounds("21:30", "03:00"));
        System.out.println(round.numberOfRounds("00:01", "00:00"));
        System.out.println(round.numberOfRounds("23:59", "00:00"));
        System.out.println(round.numberOfRounds("18:51", "04:54"));
        System.out.println(round.numberOfRounds("04:54", "18:51"));
    }
}
