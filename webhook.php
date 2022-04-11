<?php
$content = \file_get_contents('php://input');
$update = \json_decode($content, true);
define("BOT_TOKEN", "902905540:AAHM34E7qJD9NK9T3MqRYVuduPmBZaubt0o");

if(!$update) {
  exit;
}

$message = isset($update['message']) ? $update['message'] : null;
$messageId = isset($message['message_id']) ? $message['message_id'] : null;
$chatId = isset($message['chat']['id']) ? $message['chat']['id'] : null;
$firstname = isset($message['from']['first_name']) ? $message['from']['first_name'] : null;
$lastname = isset($message['chat']['last_name']) ? $message['chat']['last_name'] : null;
$username = isset($message['chat']['username']) ? $message['chat']['username'] : null;
$date = isset($message['date']) ? $message['date'] : null;
$text = isset($message['text']) ? $message['text'] : null;

$reply = false;

$response = '';

$lowerCaseString = strtolower($text);

if(isset($message['audio']) || isset($message['voice'])){
	$response = "Niente audio, scrivi per Dio!";
	$reply = true;
}else{

	/*
	if (strpos($lowerCaseString, 'volodia') !== false) {
	    $response = 'Quanto odio Volodia';
	}
	*/
	/*
	if ($firstname == 'Simone') {
	    $response = 'Ti odio, merda!';
		$reply = true;
	    
	}
	*/

	if (strpos($lowerCaseString, 'sbragata') !== false) {
	    $response = 'Torna a Padova!';
	}
	
	/*
	if (strpos($lowerCaseString, 'pornhub') !== false) {
	    $response = 'Guardate quante stelline';
	}
	*/
	/*
	if (strpos($lowerCaseString, 'biagio') !== false ) {
	    $response = 'Porcodio!!';
	}
	*/
	/*
	if ($firstname == 'Dolores') {
	    $response = 'In Italiano per favore';
	    $reply = true;
	}
	*/

}


/* ------ SEND CHAT ------ */
if($response !== ''){
	if($reply){
		$parameters = array('chat_id' => $chatId, 'text' => $response, 'method' => 'sendMessage', 'reply_to_message_id' => $messageId);
	}else{
		$parameters = array('chat_id' => $chatId, 'text' => $response, 'method' => 'sendMessage');
	}
	header("Content-Type: application/json");
	echo json_encode($parameters);
}




/* ------ MEDIA ------ */

$botUrl = '';
$postFields = null;

/* ------ VITTORI ------ */
/*
if (strpos($lowerCaseString, 'vittori') !== false ) {

	$botUrl = "https://api.telegram.org/bot" . BOT_TOKEN . "/sendAudio";
	// change image name and path
	$postFields = array('chat_id' => $chatId, 'audio' => new CURLFile(realpath("media/Vittori.m4a")));
	

}
*/

/* ------ SPID ------ */
if (strpos($lowerCaseString, 'spid') !== false ) {

	$botUrl = "https://api.telegram.org/bot" . BOT_TOKEN . "/sendAudio";
	// change image name and path
	$postFields = array('chat_id' => $chatId, 'audio' => new CURLFile(realpath("media/spid.mp3")));
	

}

/* ------ FRIZZANTINA ------ */
if (strpos($lowerCaseString, 'frizzantina') !== false ) {

	$botUrl = "https://api.telegram.org/bot" . BOT_TOKEN . "/sendAudio";
	// change image name and path
	$postFields = array('chat_id' => $chatId, 'audio' => new CURLFile(realpath("media/frizzantina.aac")));
	

}

/* ------ GESTISCO ------ */

if (strpos($lowerCaseString, 'gestisco') !== false) {

	$botUrl = "https://api.telegram.org/bot" . BOT_TOKEN . "/sendVideo";
	// change image name and path
	$postFields = array('chat_id' => $chatId, 'video' => new CURLFile(realpath("media/gestisco.mp4")));

}

/* ------ ALBERTINO ------ */

if (strpos($lowerCaseString, 'albertino') !== false) {

	$botUrl = "https://api.telegram.org/bot" . BOT_TOKEN . "/sendPhoto";
	// change image name and path
	$postFields = array('chat_id' => $chatId, 'photo' => new CURLFile(realpath("media/albertino.jpg")));

}

/* ------ UROGALLO ------ */

if (strpos($lowerCaseString, 'urogallo') !== false) {

	$botUrl = "https://api.telegram.org/bot" . BOT_TOKEN . "/sendVideo";
	// change image name and path
	$postFields = array('chat_id' => $chatId, 'video' => new CURLFile(realpath("media/urogallo.mp4")));

}


/* ------ RAGIONE ------ */
if (strpos($lowerCaseString, 'ragione') !== false) {
    $botUrl = "https://api.telegram.org/bot" . BOT_TOKEN . "/sendPhoto";

    $photoArray = array(realpath("media/ragione1.jpeg"), realpath("media/ragione2.jpeg"), realpath("media/ragione3.jpeg"), realpath("media/ragione4.jpeg"), realpath("media/ragione5.jpeg"));
    $arrayIndex = rand(0, 4);
	// change image name and path
	$postFields = array('chat_id' => $chatId, 'photo' => new CURLFile($photoArray[$arrayIndex]));
}

/* ------ DUGA ------ */
if (strpos($lowerCaseString, 'duga') !== false) {
    $botUrl = "https://api.telegram.org/bot" . BOT_TOKEN . "/sendPhoto";

    $photoArray = array(realpath("media/ItaliaViva.png"), realpath("media/Azione.png"), realpath("media/PD.png"), realpath("media/Europa.png"));
    $arrayIndex = rand(0, 3);
	// change image name and path
	$postFields = array('chat_id' => $chatId, 'photo' => new CURLFile($photoArray[$arrayIndex]));
}

/* ------ REDENZIONE ------ */
if (strpos($lowerCaseString, 'redenzione') !== false) {
    $botUrl = "https://api.telegram.org/bot" . BOT_TOKEN . "/sendPhoto";

    $photoArray = array(realpath("media/poggio2.jpg"), realpath("media/poggio1.jpg"));
	
	$arrayIndex = rand(0, 2);
	// change image name and path
	$postFields = array('chat_id' => $chatId, 'photo' => new CURLFile($photoArray[$arrayIndex]));
}

/*----- PEPITINO -----*/
if ( strpos($lowerCaseString, 'pepito') !== false || strpos($lowerCaseString, 'pepitino') !== false ) {
    $botUrl = "https://api.telegram.org/bot" . BOT_TOKEN . "/sednAnimation";

	// change image name and path
	$postFields = array('chat_id' => $chatId, 'animation' => new CURLFile(realpath("media/pepito.gif")));
}


$ch = curl_init(); 
curl_setopt($ch, CURLOPT_HTTPHEADER, array("Content-Type:multipart/form-data"));
curl_setopt($ch, CURLOPT_URL, $botUrl); 
curl_setopt($ch, CURLOPT_RETURNTRANSFER, 1); 
curl_setopt($ch, CURLOPT_POSTFIELDS, $postFields);
// read curl response
$output = curl_exec($ch);





