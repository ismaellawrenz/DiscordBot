package com.discord;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.discord.servicos.DiscordServico;

@SpringBootApplication
public class BotDiscordApplication {

	public static void main(String[] args) {
		SpringApplication.run(BotDiscordApplication.class, args);
	}

}
