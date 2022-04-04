<?php
$content = \file_get_contents('php://input');
$update = \json_decode($content, true);
define("BOT_TOKEN", "5177210114:AAF227Tf8gPJ1v5kK2VNkA9VNl9x6ZrybEk");

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


/* ------ SONDAGGIO ALLENAMENTO ------ */
if (date("l") == 'Monday' || date("l") == 'Thursday') {

	$optionsArray = array("presente", "assente", "coach");
	$botUrl = "https://api.telegram.org/bot" . BOT_TOKEN . "/sendPoll";
	// change image name and path
	$postFields = array('chat_id' => $chatId, 'question' => 'Stasera allenamento 20.00 - 22.30', 'options' => $optionsArray, 'is_anonymous' => false);
	

}

/


$ch = curl_init(); 
curl_setopt($ch, CURLOPT_HTTPHEADER, array("Content-Type:multipart/form-data"));
curl_setopt($ch, CURLOPT_URL, $botUrl); 
curl_setopt($ch, CURLOPT_RETURNTRANSFER, 1); 
curl_setopt($ch, CURLOPT_POSTFIELDS, $postFields);
// read curl response
$output = curl_exec($ch);





