import edu.praktikum.sprint4.pom.MainPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import static java.time.temporal.ChronoUnit.SECONDS;
import static org.junit.Assert.assertEquals;


    @RunWith(Parameterized.class)
    public class ImportantQuestionsList {
        private WebDriver webDriver;
        private final int questionIndex;
        private final String expectedQuestion;
        private final String expectedAnswer;


        public ImportantQuestionsList(int questionIndex, String expectedQuestion, String expectedAnswer) {
            this.questionIndex = questionIndex;
            this.expectedQuestion = expectedQuestion;
            this.expectedAnswer = expectedAnswer;
        }

        // Тестовые данные
        @Parameterized.Parameters
        public static Object[][] getImportantQuestionsData() {
            return new Object[][]{
                    {0, "Сколько это стоит? И как оплатить?", "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                    {1, "Хочу сразу несколько самокатов! Так можно?", "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
                    {2, "Как рассчитывается время аренды?", "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
                    {3, "Можно ли заказать самокат прямо на сегодня?", "Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
                    {4, "Можно ли продлить заказ или вернуть самокат раньше?", "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."},
                    {5, "Вы привозите зарядку вместе с самокатом?", "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."},
                    {6, "Можно ли отменить заказ?", "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."},
                    {7, "Я живу за МКАДом, привезёте?", "Да, обязательно. Всем самокатов! И Москве, и Московской области."},
            };
        }

        @Before
        public void setup() {
            webDriver = new ChromeDriver();
            webDriver.manage().window().maximize();
            webDriver.manage().timeouts().implicitlyWait(Duration.of(5, SECONDS));
        }

        @Test
        public void checkAnswerOnImportantQuestion() {
            MainPage mainPage = new MainPage(webDriver);
            mainPage.open();
            String actualOpenQuestion = mainPage.openQuestion(questionIndex);
            String actualOpenAnswer = mainPage.openAnswer(questionIndex);
            assertEquals(expectedQuestion, actualOpenQuestion);
            assertEquals(expectedAnswer, actualOpenAnswer);
        }

        @After
        public void tearDown() {
            webDriver.quit();
        }
    }
