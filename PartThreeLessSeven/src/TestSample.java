public class TestSample {

    @Test (priority = 1)
    public void first (){
        System.out.println("Тест три выполнен!");
    }

    public void second (){
        System.out.println("А этого тут быть не должно!");
    }
    @Test(priority = 10)
    public void third (){
        System.out.println("Тест один выполнен!");
    }
    @AfterSuite
    public void fourth (){
        System.out.println("Все тесты завершены!");
    }
    @Test
    public void fifth(){
        System.out.println("Тест два выполнен!");
    }
    @BeforeSuite
    public void sixth (){
        System.out.println("Подготовка к тестам прошла успешно!");
    }

    /* @BeforeSuite
    public void seventh (){
        System.out.println("Дубликат для отлова!");
    }
    */
}
