package com.discord.servicos;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;
import org.springframework.stereotype.Component;

@Component
public class DiscordServico {

	private final String token = "OTA3Nzc0NTIxOTIxMTIyMzY0.YYsE5w.v2SJOoN2GeJ-2UAkUsQpGHFQm5Y";

	public DiscordServico() {
		System.out.println(LocalDate.of(LocalDate.now().plusYears(1).getYear(), 8, 18));
		DiscordApi api = new DiscordApiBuilder().setToken(token).login().join();
		api.addMessageCreateListener(event -> {
			if (event.getMessageContent().equalsIgnoreCase("olá")) {
				event.getChannel().sendMessage("Olá " + event.getMessageAuthor().getName());
			}
			if (event.getMessageContent().equalsIgnoreCase("Quantos dias faltam para meu aniversario?")) {
				event.getChannel().sendMessage("Olá "
						+ event.getMessageAuthor().getName() + " faltam exatamente " + ChronoUnit.DAYS
								.between(LocalDate.now(), LocalDate.of(LocalDate.now().plusYears(1).getYear(), 8, 18))
						+ " dias.");
			}

		});

	}

}
