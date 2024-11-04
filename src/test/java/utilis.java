import com.github.javafaker.Faker;

public class utilis
{
    public static CharSequence firstname()
    {

        Faker faker=new Faker();

        return faker.name().firstName();
    }

    public static CharSequence lastname()
    {

        Faker faker=new Faker();

        return faker.name().lastName();
    }
    public  static String password()
    {
        Faker faker=new Faker();
        return  faker.internet().password();

    }

    public static String phonenumber()
    {
        Faker faker=new Faker();

        return  faker.phoneNumber().cellPhone();

    }



}
