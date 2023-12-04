package ru.netology.javaqa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TodosTest {
    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");
        String[] subtasks = {"молоко", "яйца", "хлеб"};
        Epic epic = new Epic(55, subtasks);
        Meeting meeting = new Meeting(555, "Выкатка 3-й версии приложения", "приложение Нетобанка", "во вторник после обеда");
        Todos todos = new Todos();
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchInTodos() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");
        String[] subtasks = {"молоко", "яйца", "хлеб"};
        Epic epic = new Epic(55, subtasks);
        Meeting meeting = new Meeting(555, "Выкатка 3-й версии приложения", "приложение Нетобанка", "во вторник после обеда");
        Todos todos = new Todos();
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.search("");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchInMeeting() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");
        String[] subtasks = {"молоко", "яйца", "хлеб"};
        Epic epic = new Epic(55, subtasks);
        Meeting meeting = new Meeting(555, "Выкатка 3-й версии приложения", "приложение Нетобанка", "во вторник после обеда");
        Todos todos = new Todos();
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {meeting};
        Task[] actual = todos.search("приложения");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchInEpic() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");
        String[] subtasks = {"молоко", "яйца", "хлеб"};
        Epic epic = new Epic(55, subtasks);
        Meeting meeting = new Meeting(555, "Выкатка 3-й версии приложения", "приложение Нетобанка", "во вторник после обеда");
        Todos todos = new Todos();
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {epic};
        Task[] actual = todos.search("хлеб");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchInSimpleTask() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");
        String[] subtasks = {"молоко", "яйца", "хлеб"};
        Epic epic = new Epic(55, subtasks);
        Meeting meeting = new Meeting(555, "Выкатка 3-й версии приложения", "приложение Нетобанка", "во вторник после обеда");
        Todos todos = new Todos();
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask};
        Task[] actual = todos.search("родителям");
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldSearchifZoroTask() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");
        String[] subtasks = {"молоко", "яйца", "хлеб"};
        Epic epic = new Epic(55, subtasks);
        Meeting meeting = new Meeting(555, "Выкатка 3-й версии приложения", "приложение Нетобанка", "во вторник после обеда");
        Todos todos = new Todos();
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {};
        Task[] actual = todos.search(meeting.getStart());
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldSearchIfOneTask() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");
        String[] subtasks = {"молоко", "яйца", "хлеб",};
        Epic epic = new Epic(55, subtasks);
        Meeting meeting = new Meeting(555, "Выкатка 3-й версии приложения", "приложение Нетобанка", "во вторник после обеда");
        Todos todos = new Todos();
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask};
        Task[] actual = todos.search(simpleTask.getTitle());
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldSearchIfFSeveralTask() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");
        String[] subtasks = {"молоко", "яйца", "хлеб", "Позвонить родителям"};
        Epic epic = new Epic(55, subtasks);
        Meeting meeting = new Meeting(555, "Выкатка 3-й версии приложения", "приложение Нетобанка", "во вторник после обеда");
        Todos todos = new Todos();
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic};
        Task[] actual = todos.search("Позвонить");
        Assertions.assertArrayEquals(expected, actual);
    }



}
