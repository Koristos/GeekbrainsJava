import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManagerFactory;
import java.util.List;
import java.util.Random;

public class Main {

	public static void main(String[] args) {
		EntityManagerFactory emFactory = new Configuration()
				.configure("hibernate.cfg.xml")
				.buildSessionFactory();

		StudentRepo repo = new StudentRepo(emFactory);

		List<String> firstNames = List.of("Саша", "Володя", "Тарас", "Сергей", "Егор", "Афоня", "Билл", "Бен", "Арнольд", "Итакдалее");
		List<String> lastNmes = List.of("Иванов", "Петров", "Вачечкин", "Череззабугорногузедерищенский", "Круглов", "Квадартов", "Треугольников", "Ромбов", "Сферов", "Итакдалее");

		Random rnd = new Random();

		for (int i = 0; i < 100; i++) {
			repo.insert(new Student(firstNames.get(rnd.nextInt(firstNames.size())), lastNmes.get(rnd.nextInt(lastNmes.size())), rnd.nextInt(5)));
		}

		repo.findAll().forEach(Student::print);
		Student student= repo.findById(20).get();
		student.print();
		student.setFirstName("Али-Баба");
		repo.update(student);

	}
}
