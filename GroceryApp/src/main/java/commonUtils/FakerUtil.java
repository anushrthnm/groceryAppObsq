package commonUtils;

import com.github.javafaker.Faker;

public class FakerUtil 
{
	Faker faker = new Faker();

	public String creatARandomFirstName() 
	{
		return faker.name().firstName();
	}

	public String creatARandomLastName() 
	{
		return faker.name().lastName();
	}

	public String generateAddress() 
	{
		return faker.address().fullAddress();
	}

	public String generateEmail() 
	{
		return faker.internet().emailAddress();
	}
}
