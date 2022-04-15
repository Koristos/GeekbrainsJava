package ru.geekbrains.summer.market;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

// Параметр VM Options для выбора профиля: -Dspring.profiles.active=dev

@SpringBootApplication
@PropertySource("classpath:secret.properties")
public class SummerMarketApplication {
	// Домашнее задание:
	// 1. Добавьте к заказу подробный адрес (сущность), "по требованиям PayPal"
	// 2. Добавьте к заказам статусы и изменения этих статусов в
	// зависимости от PayPal callback'ов +
	// 3. Не надо давать возможность оплачивать оплаченный заказ +
	// 4. * Попробуйте защитить back/front от неправильных действий пользователя
	// (пользователь сможет посмотреть/оплатить не свой заказ, попытаться оплатить
	// оплаченный заказ в обход фронтовой кнопки "оплатить")

	// План по магазину:
	// + Swagger
	// + Платежная система (PayPal)
	// - Картинки
	// - KeyCloak
	// - Регистрация

	// Доп:
	// - Тест PayPal
	// - Dockerfile для сборки нашего приложения + docker-compose для развертывания
	// вашего приложения + всего окружения

	public static void main(String[] args) {
		SpringApplication.run(SummerMarketApplication.class, args);
	}
}
