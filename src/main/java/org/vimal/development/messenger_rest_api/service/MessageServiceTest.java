package org.vimal.development.messenger_rest_api.service;

import java.text.Format;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.junit.jupiter.api.Test;

class MessageServiceTest {

	@Test
	void test() {
		LocalDate localDate = LocalDate.parse("2020-02-05");
		//String localDate = new LocalDateTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS"));
		
		
		System.out.println("" + localDate.getYear());
	}

}
