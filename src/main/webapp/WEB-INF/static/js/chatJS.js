var messagesTextArea = document.getElementById("messagesTextArea");
var textMessage = document.getElementById("textMessage");
var webSocket = new WebSocket("ws://localhost:8080/chat");
webSocket.onopen = function (message){processOpen(message);};
webSocket.onmessage = function (message){processMessage(message);};
webSocket.onclose = function (message){processClose(message);};
webSocket.onerror = function (message){processError(message);};


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


 function searchValidator() {
   var fulName = document.getElementById('search');
   var filter = /^[a-zA-Z``''0-9-]+ [a-zA-Z``''0-9-]+$/;
   var button = document.getElementById("search-submit");
   if (!filter.test(fulName.value)) {
      fulName.focus;
      fulName.style.backgroundColor = "#ff6666";
       button.disabled = true;
   }else{
       fulName.style.backgroundColor = "#66cc66";
       button.disabled = false;
   }
 }