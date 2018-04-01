var messagesTextArea = document.getElementById("messagesTextArea");
var textMessage = document.getElementById("textMessage");
var webSocket = new WebSocket("http://localhost:8080/chat");
webSocket.onopen = function Message(){processOpen(message);};
webSocket.onmessage = function Message(){processMessage(message);};
webSocket.onclose = function Message(){processClose(message);};
webSocket.onerror = function Message(){processError(message);};


 function processOpen(message){
    messagesTextArea.value += "server Connected....." + "\n";
 }

 function processMessage(message){
    messagesTextArea.value += "Receive from server....." + message.data + "\n";
 }

 function processClose(message){
     webSocket.send("client disconnected");
     messagesTextArea.value += "server DISConnected....." + "\n";
 }

  function sendMessage(){
     if(textMessage.value !== "close") {
        webSocket.send(textMessage.value);
        messagesTextArea.value += "send to server....." + textMessage.value() + "\n";
        textMessage.value = "";
     } else {
        alert("else message");
        webSocket.close();
     }
  }

 function processError(message){
     webSocket.send("client disconnected");
     messagesTextArea.value += "error....." + "\n";

 }