package com.discord.servicos;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;
import org.springframework.stereotype.Component;

@Component
public class DiscordServico {

	
	private final LocalDate meuAniversario = LocalDate.of(LocalDate.now().getYear(), 8, 18);

	public DiscordServico() {
		
		DiscordApi api = new DiscordApiBuilder().setToken(Chaves.token).login().join();
		api.addMessageCreateListener(event -> {
			if (event.getMessageContent().equalsIgnoreCase("olá")) {
				event.getChannel().sendMessage("Olá " + event.getMessageAuthor().getName());
			}
			if (event.getMessageContent().equalsIgnoreCase("Quantos dias faltam para meu aniversário?")) {
				long diasFaltantes;				
				if(meuAniversario.isBefore(LocalDate.now())) {
					diasFaltantes =  ChronoUnit.DAYS.between(LocalDate.now(), meuAniversario.plusYears(1));
				}else {
					diasFaltantes = ChronoUnit.DAYS.between(LocalDate.now(), meuAniversario);					
				}				
				event.getChannel().sendMessage("Olá "
						+ event.getMessageAuthor().getName() + " faltam exatamente " + diasFaltantes
						+ " dias.");
			}

		});

	}

}
