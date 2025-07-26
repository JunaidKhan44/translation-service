package com.digitaltolk;

import com.digitaltolk.entity.Translation;
import com.digitaltolk.repo.TranslationRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;
import org.modelmapper.ModelMapper;

@SpringBootApplication
public class TranslationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TranslationServiceApplication.class, args);
	}


	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	@Bean
	CommandLineRunner runner(TranslationRepository repo) {
		return args -> {
			if (repo.count() == 0) {
				for (int i = 0; i < 100; i++) {
					Translation t = new Translation();
					t.setLocale(i % 3 == 0 ? "en" : i % 3 == 1 ? "fr" : "es");
					t.setKey("key_" + i);
					t.setContent("Content " + UUID.randomUUID());
					t.setTags(Set.of("tag" + ThreadLocalRandom.current().nextInt(1, 5)));
					repo.save(t);
				}
			}
		};
	}

}
