package ru.netology.javaqa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TasksTest {
    @Test
    public void shouldFindQueryInSimpleTaskIfPresent() {
        Task simpleTask = new SimpleTask(5, "Позвонить родителям");
        boolean expected = true;
        boolean actual = simpleTask.matches("Позвонить");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindQueryInSimpleTaskIfMissing() {
        Task simpleTask = new SimpleTask(5, "Позвонить родителям");
        boolean expected = false;
        boolean actual = simpleTask.matches("Хлеб");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindQueryInEpicIfPresent() {
        String[] subtasks = {"молоко", "яйца", "хлеб"};
        Task epic = new Epic(55, subtasks);
        boolean expected = true;
        boolean actual = epic.matches("хлеб");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindQueryInEpicIfMissing() {
        String[] subtasks = {"молоко", "яйца", "хлеб"};
        Task epic = new Epic(55, subtasks);
        boolean expected = false;
        boolean actual = epic.matches("малако");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindQueryInMitingIfPresent() {
        Task meeting = new Meeting(555, "Выкатка 3-й версии приложения", "приложение Нетобанка", "во вторник после обеда");

        boolean expected = true;
        boolean actual = meeting.matches("3-й");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindQueryInMitingIfMissing() {
        Task meeting = new Meeting(555, "Выкатка 3-й версии приложения", "приложение Нетобанка", "во вторник после обеда");

        boolean expected = false;
        boolean actual = meeting.matches("НетоБанк");
        Assertions.assertEquals(expected, actual);
    }

}
