package it.ivannotar.regazbot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.polls.SendPoll;
import org.telegram.telegrambots.meta.api.methods.send.*;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class RegazBotComponent extends TelegramLongPollingBot {
	
	private static final Logger logger = LoggerFactory.getLogger(RegazBotComponent.class);
	
	private final String MEDIA_DIR = "src/main/resources/media/";
	
	@Override
	public String getBotUsername() {
		return "RegazBot";
	}
	
	@Override
	public String getBotToken() {
		return "902905540:AAF7kpiSgb3vp4DVGPiqmDNIHhaPA7PA1GE";
	}
	
	@Override
	public void onUpdateReceived(Update update) {
		if (update.hasMessage()){
			Random r;
			int randomItem;
			String randomElement;
			
			Message msg = update.getMessage();
			var chatId = msg.getChatId();
			var messageId = msg.getMessageId();
			try {
				
//				logger.info("Audio: " + msg.toString());
				logger.info(String.valueOf(chatId));
				
				//AUDIO
				if(msg.hasVoice() && msg.getVoice() != null){
					var reply = "Niente audio, scrivi cazzo!";
					sendTextReply(String.valueOf(chatId), reply, messageId);
				}
				
				//SBRAGATA
				else if(msg.getText().toLowerCase().contains("sbragata")){
					var reply = "Torna a Padova";
					sendTextReply(String.valueOf(chatId), reply, messageId);
				}
				
				//SPID
				else if(msg.getText().toLowerCase().contains("spid")){
					File file = new File(MEDIA_DIR + "spid.mp3");
					var reply = new InputFile(file);
					sendAudioReply(String.valueOf(chatId), reply, messageId);
				}
				
				//FRIZZANTINA
				else if(msg.getText().toLowerCase().contains("frizzantina")){
					File file = new File(MEDIA_DIR + "frizzantina.aac");
					var reply = new InputFile(file);
					sendAudioReply(String.valueOf(chatId), reply, messageId);
				}
				
				//GESTISCO
				else if(msg.getText().toLowerCase().contains("gestisco")){
					File file = new File(MEDIA_DIR + "gestisco.mp4");
					var reply = new InputFile(file);
					sendVideoReply(String.valueOf(chatId), reply, messageId);
				}
				
				//ALBERTINO
				else if(msg.getText().toLowerCase().contains("albertino")){
					File file = new File(MEDIA_DIR + "albertino.jpg");
					var reply = new InputFile(file);
					sendPhotoReply(String.valueOf(chatId), reply, messageId);
				}
				
				//UROGALLO
				else if(msg.getText().toLowerCase().contains("urogallo")){
					File file = new File(MEDIA_DIR + "urogallo.mp4");
					var reply = new InputFile(file);
					sendVideoReply(String.valueOf(chatId), reply, messageId);
				}
				
				//COMPAGNO
				else if(msg.getText().toLowerCase().contains("compagno")){
					File file = new File(MEDIA_DIR + "compagno.jpeg");
					var reply = new InputFile(file);
					sendPhotoReply(String.valueOf(chatId), reply, messageId);
				}
				
				//RAGIONE
				else if(msg.getText().toLowerCase().contains("ragione")){
					List<String> ragioneList = new ArrayList<>();
					ragioneList.add("ragione1.jpeg");
					ragioneList.add("ragione2.jpeg");
					ragioneList.add("ragione3.jpeg");
					ragioneList.add("ragione4.jpeg");
					ragioneList.add("ragione4.jpeg");
					ragioneList.add("ragione5.jpeg");
					ragioneList.add("ragione7.jpg");
					ragioneList.add("ragione8.jpg");
					ragioneList.add("ragione9.jpg");
					ragioneList.add("ragione10.jpg");
					r = new Random();
					randomItem = r.nextInt(ragioneList.size());
					randomElement = ragioneList.get(randomItem);
					
					File file = new File(MEDIA_DIR + randomElement);
					var reply = new InputFile(file);
					sendPhotoReply(String.valueOf(chatId), reply, messageId);
				}
				
				//DUGA
				else if(msg.getText().toLowerCase().contains("duga")){
					List<String> dugaList = new ArrayList<>();
					dugaList.add("Azione.png");
					dugaList.add("Europa.png");
					dugaList.add("PD.png");
					dugaList.add("ItaliaViva.png");
					r = new Random();
					randomItem = r.nextInt(dugaList.size());
					randomElement = dugaList.get(randomItem);
					
					File file = new File(MEDIA_DIR + randomElement);
					var reply = new InputFile(file);
					sendPhotoReply(String.valueOf(chatId), reply, messageId);
				}
				
				//REDENZIONE
				else if(msg.getText().toLowerCase().contains("redenzione")){
					List<String> redenzioneList = new ArrayList<>();
					redenzioneList.add("poggio1.jpg");
					redenzioneList.add("poggio2.jpg");
					r = new Random();
					randomItem = r.nextInt(redenzioneList.size());
					randomElement = redenzioneList.get(randomItem);
					
					File file = new File(MEDIA_DIR + randomElement);
					var reply = new InputFile(file);
					sendPhotoReply(String.valueOf(chatId), reply, messageId);
				}
				
				//PEPITO
				else if(msg.getText().toLowerCase().contains("pepito") || msg.getText().toLowerCase().contains("pepitino") || msg.getText().toLowerCase().contains("bibi")){
					File file = new File(MEDIA_DIR + "pepito.gif");
					var reply = new InputFile(file);
					sendAnimationReply(String.valueOf(chatId), reply, messageId);
				}
				
				//BECCO
				else if(msg.getText().toLowerCase().contains("becco")){
					List<String> beccoList = new ArrayList<>();
					beccoList.add("becco1.gif");
					beccoList.add("becco2.mp4");
					r = new Random();
					randomItem = r.nextInt(beccoList.size());
					randomElement = beccoList.get(randomItem);
					
					File file = new File(MEDIA_DIR + randomElement);
					var reply = new InputFile(file);
					if(randomElement.contains("gif")){
						sendAnimationReply(String.valueOf(chatId), reply, messageId);
					}else{
						sendVideoReply(String.valueOf(chatId), reply, messageId);
					}
					
				}
				
			} catch (TelegramApiException e) {
				throw new RuntimeException(e);
			}
		}
	}
	
	private void sendTextReply(String chatId, String msg, Integer messageId) throws TelegramApiException {
		var response = new SendMessage(chatId, msg, null, null, false, messageId, null, null, true, null);
		execute(response);
	}
	
	private void sendAudioReply(String chatId, InputFile audio, Integer messageId) throws TelegramApiException {
		var response = new SendAudio(chatId, audio, messageId, false, null, null, null, null, null, null, null, null, null, null);
		execute(response);
	}
	
	private void sendPhotoReply(String chatId, InputFile photo, Integer messageId) throws TelegramApiException {
		var response = new SendPhoto(chatId, photo, null, null, messageId, null, null, null, true, null);
		execute(response);
	}
	
	private void sendVideoReply(String chatId, InputFile video, Integer messageId) throws TelegramApiException {
		var response = new SendVideo(chatId, video, null, null, null, null, null, false, messageId, null, null, null, null, null, null);
		execute(response);
	}
	
	private void sendAnimationReply(String chatId, InputFile animation, Integer messageId) throws TelegramApiException {
		var response = new SendAnimation(chatId, animation, null, null, null, null, false, messageId, null, null, null, null, null, null);
		execute(response);
	}
	
	
	@Scheduled(fixedRate = 10000000)
	private void sendMondayPoll(){
		logger.info("Entro nel send poll");
		
		String question = "Oggi allenamento dalle 20.00 alle 22.45";
		List<String> options = new ArrayList<>();
		options.add("Presente");
		options.add("Assente");
		options.add("Coach");
		var response = new SendPoll("-769495246", question, options, false, "regular", false, null, false, false, null, null, null, null, null, null, null, null, null);
		
		try {
			execute(response);
		} catch (TelegramApiException e) {
			throw new RuntimeException(e);
		}
	}
}
