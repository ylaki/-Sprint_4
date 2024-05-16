import edu.praktikum.sprint4.pom.MainPage;
import edu.praktikum.sprint4.pom.OrderPage;
import edu.praktikum.sprint4.pom.OrderSuccess;
import edu.praktikum.sprint4.pom.RentPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import static java.time.temporal.ChronoUnit.SECONDS;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.chrome.ChromeOptions;


//Это тест с параметризацией

    @RunWith(Parameterized.class)
    public class PositiveOrderParam {
        private WebDriver webDriver;
        private final String name;
        private final String lastName;
        private final String address;
        private final String metroStationId;
        private final String phoneNumber;
        private final int daysToAdd;
        private final String rentDurationDays;
        private final String scooterColorChoice;
        private final String courierComment;
        private final String expected;
        private final String orderButton;


        public PositiveOrderParam(String orderButton, String name, String lastName, String address, String metroStationId,
                         String phoneNumber, int daysToAdd, String rentDurationDays, String scooterColorChoice, String courierComment, String expected) {
            this.orderButton = orderButton;
            this.name = name;
            this.lastName = lastName;
            this.address = address;
            this.metroStationId = metroStationId;
            this.phoneNumber = phoneNumber;
            this.daysToAdd = daysToAdd;
            this.rentDurationDays = rentDurationDays;
            this.scooterColorChoice = scooterColorChoice;
            this.courierComment = courierComment;
            this.expected = expected;

        }

        // Тестовые данные
        @Parameterized.Parameters
        public static Object[][] getPositiveScenarioOrderData() {
            return new Object[][]{
                    {"top", "Александр", "Пушкин", "Проспект Лермонтова 34", "7", "84951234567", 4, "трое суток", "black", "Привезите быстрее", "Заказ оформлен"},
                    {"bottom", "Иван", "Бунин", "Аллея Есенина 30", "5", "84957654321", 2, "пятеро суток", "grey", "Ждем с нетерпением", "Заказ оформлен"},
            };
        }

        @Before
        public void setup() {
            webDriver = new ChromeDriver();
            webDriver.manage().timeouts().implicitlyWait(Duration.of(3, SECONDS));

            //Maximize current window
            webDriver.manage().window().maximize();
        }

        @Test
        public void checkScooterOrderParam() {

            MainPage mainPage = new MainPage(webDriver);
            mainPage.open();
            mainPage.clickOrderButton(orderButton);

            OrderPage orderFormPage = new OrderPage(webDriver);
            orderFormPage.inputDataToForm(name, lastName, address, phoneNumber);
            orderFormPage.pickMetroFromList(metroStationId);
            orderFormPage.clickNextButton();

            RentPage rentPage = new RentPage(webDriver);
            rentPage.pickDeliveryDate(daysToAdd);

            rentPage.pickScooterColor(scooterColorChoice);
            rentPage.setCourierComment(courierComment);
            rentPage.chooseRentDuration(rentDurationDays);
            rentPage.clickSubmitButton();

            OrderSuccess orderSuccess = new OrderSuccess(webDriver);
            String actual = orderSuccess.orderMessage();
            Assert.assertEquals(expected, actual);
        }
        @After
        public void tearDown() {
            webDriver.quit();
        }
    }


