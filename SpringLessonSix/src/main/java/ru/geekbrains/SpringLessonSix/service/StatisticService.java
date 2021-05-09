package ru.geekbrains.SpringLessonSix.service;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geekbrains.SpringLessonSix.dao.PersonDao;
import ru.geekbrains.SpringLessonSix.dao.ProductDao;
import ru.geekbrains.SpringLessonSix.dto.Person;
import ru.geekbrains.SpringLessonSix.dto.Product;

import java.util.*;


@Service
@NoArgsConstructor
@Data
public class StatisticService {
    @Autowired
    private PersonDao personDao;
    @Autowired
    private ProductDao productDao;

    public void printProduct(int productId){
        List<Product> productList =productDao.getProductsById(productId);
        Product product = productList.stream().reduce(
                (a,b)->a.getProductId().getVersion()>b.getProductId().getVersion() ?a:b).get();
        Set<Person> personSet = new HashSet<>();
        for (Product p: productList) {
            personSet.addAll(p.getPersonList());
        }
        product.setPersonList(new ArrayList<>(personSet));
        System.out.println(product.getInfo());
    }

    public void printPerson (int personId){
        System.out.println(personDao.getPerson(personId).getInfo());
    }

}
