import edu.praktikum.sprint4.pom.MainPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import static java.time.temporal.ChronoUnit.SECONDS;
import static org.junit.Assert.assertEquals;

public class ImportantQuestionsList {

    private WebDriver webDriver;

    @Before
    public void setup() {
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(Duration.of(5, SECONDS));

        //Maximize current window
        webDriver.manage().window().maximize();
    }

    @Test
    public void TextCheck() {

        MainPage mainPage = new MainPage(webDriver);
        mainPage.open();

        for (int i = 0; i <=7; i++) {
            String[] expectedQuestion = {"Сколько это стоит? И как оплатить?",
                    "Хочу сразу несколько самокатов! Так можно?",
                    "Как рассчитывается время аренды?",
                    "Можно ли заказать самокат прямо на сегодня?",
                    "Можно ли продлить заказ или вернуть самокат раньше?",
                    "Вы привозите зарядку вместе с самокатом?",
                    "Можно ли отменить заказ?",
                    "Я жизу за МКАДом, привезёте?"};
            String[] expectedAnswer = {"Сутки — 400 рублей. Оплата курьеру — наличными или картой.",
                    "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.",
                    "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.",
                    "Только начиная с завтрашнего дня. Но скоро станем расторопнее.",
                    "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.",
                    "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.",
                    "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.",
                    "Да, обязательно. Всем самокатов! И Москве, и Московской области."};
            assertEquals(expectedQuestion[i], mainPage.openQuestion(i));
            assertEquals(expectedAnswer[i], mainPage.openAnswer(i));
        }
    }

    @After
    public void tearDown() {
        webDriver.quit();
    }
}
