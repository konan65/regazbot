package it.ivannotar.regazbot;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.*;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class RegazBotComponent extends TelegramLongPollingBot {
	
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
			var msg = update.getMessage();
			var chatId = msg.getChatId();
			try {
				//AUDIO
				if(msg.hasAudio()){
					var reply = "Niente audio, scrivi cazzo!";
					sendTextReply(String.valueOf(chatId), reply);
				}
				
				//SBRAGATA
				else if(msg.getText().toLowerCase().contains("sbragata")){
					var reply = "Torna a Padova";
					sendTextReply(String.valueOf(chatId), reply);
				}
				
				//SPID
				else if(msg.getText().toLowerCase().contains("spid")){
					File file = new File(MEDIA_DIR + "spid.mp3");
					var reply = new InputFile(file);
					sendAudioReply(String.valueOf(chatId), reply);
				}
				
				//FRIZZANTINA
				else if(msg.getText().toLowerCase().contains("frizzantina")){
					File file = new File(MEDIA_DIR + "frizzantina.aac");
					var reply = new InputFile(file);
					sendAudioReply(String.valueOf(chatId), reply);
				}
				
				//GESTISCO
				else if(msg.getText().toLowerCase().contains("gestisco")){
					File file = new File(MEDIA_DIR + "gestisco.mp4");
					var reply = new InputFile(file);
					sendVideoReply(String.valueOf(chatId), reply);
				}
				
				//ALBERTINO
				else if(msg.getText().toLowerCase().contains("albertino")){
					File file = new File(MEDIA_DIR + "albertino.jpg");
					var reply = new InputFile(file);
					sendPhotoReply(String.valueOf(chatId), reply);
				}
				
				//UROGALLO
				else if(msg.getText().toLowerCase().contains("urogallo")){
					File file = new File(MEDIA_DIR + "urogallo.mp4");
					var reply = new InputFile(file);
					sendVideoReply(String.valueOf(chatId), reply);
				}
				
				//COMPAGNO
				else if(msg.getText().toLowerCase().contains("compagno")){
					File file = new File(MEDIA_DIR + "compagno.jpeg");
					var reply = new InputFile(file);
					sendPhotoReply(String.valueOf(chatId), reply);
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
					int randomitem = r.nextInt(ragioneList.size());
					String randomElement = ragioneList.get(randomitem);
					
					File file = new File(MEDIA_DIR + randomElement);
					var reply = new InputFile(file);
					sendPhotoReply(String.valueOf(chatId), reply);
				}
				
				//DUGA
				else if(msg.getText().toLowerCase().contains("duga")){
					List<String> dugaList = new ArrayList<>();
					dugaList.add("ragione1.jpeg");
					dugaList.add("ragione2.jpeg");
					dugaList.add("ragione3.jpeg");
					dugaList.add("ragione4.jpeg");
					r = new Random();
					int randomitem = r.nextInt(dugaList.size());
					String randomElement = dugaList.get(randomitem);
					
					File file = new File(MEDIA_DIR + randomElement);
					var reply = new InputFile(file);
					sendPhotoReply(String.valueOf(chatId), reply);
				}
				
				//REDENZIONE
				else if(msg.getText().toLowerCase().contains("redenzione")){
					List<String> redenzioneList = new ArrayList<>();
					redenzioneList.add("poggio1.jpg");
					redenzioneList.add("poggio2.jpg");
					r = new Random();
					int randomitem = r.nextInt(redenzioneList.size());
					String randomElement = redenzioneList.get(randomitem);
					
					File file = new File(MEDIA_DIR + randomElement);
					var reply = new InputFile(file);
					sendPhotoReply(String.valueOf(chatId), reply);
				}
				
				//PEPITO
				else if(msg.getText().toLowerCase().contains("pepito")){
					File file = new File(MEDIA_DIR + "pepito.gif");
					var reply = new InputFile(file);
					sendAnimationReply(String.valueOf(chatId), reply);
				}
				
				//BECCO
				else if(msg.getText().toLowerCase().contains("becco")){
					List<String> beccoList = new ArrayList<>();
					beccoList.add("becco1.gif");
					beccoList.add("becco2.gif");
					r = new Random();
					int randomitem = r.nextInt(beccoList.size());
					String randomElement = beccoList.get(randomitem);
					
					File file = new File(MEDIA_DIR + randomElement);
					var reply = new InputFile(file);
					sendAnimationReply(String.valueOf(chatId), reply);
				}
				
			} catch (TelegramApiException e) {
				throw new RuntimeException(e);
			}
		}
	}
	
	private void sendTextReply(String chatId, String msg) throws TelegramApiException {
		var response = new SendMessage(chatId, msg);
		execute(response);
	}
	
	private void sendAudioReply(String chatId, InputFile audio) throws TelegramApiException {
		var response = new SendAudio(chatId, audio);
		execute(response);
	}
	
	private void sendPhotoReply(String chatId, InputFile photo) throws TelegramApiException {
		var response = new SendPhoto(chatId, photo);
		execute(response);
	}
	
	private void sendVideoReply(String chatId, InputFile video) throws TelegramApiException {
		var response = new SendVideo(chatId, video);
		execute(response);
	}
	
	private void sendAnimationReply(String chatId, InputFile animation) throws TelegramApiException {
		var response = new SendAnimation(chatId, animation);
		execute(response);
	}
}
