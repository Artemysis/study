package ru.tinkoff.edu.java.bot;

import java.util.List;

import org.telegram.telegrambots.meta.api.objects.Message;

public record LinkUpdate(long id, String url, String description, List<Long> tgChatIds) {

	public Message getMessage() {
		// TODO Auto-generated method stub
		return null;
	}}
