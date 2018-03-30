//var webSocket = new WebSocket("ws://localhost:8080/mainPage");
//webSocket.Onmessage = function processMessage(message){
//    var jsonData = Json.parse(message.data);
//    if(jsonData.message !=null messageTextArea.value +=jsonData.message + "\n";
//}
//
//function sendMessage(){
////    json = {};
////    json.id = room-id.value;
////    json.message = textMessage.value;
////    webSocket.send(JSON.stringify(json));
//
//webSocket.send(textMessage.value);
//textMessage.value="";
//}

  var messagesTextArea = document.getElementById("messagesTextArea");
  var textMessage = document.getElementById("textMessage");
  var webSocket = new WebSocket("ws:/http://localhost:8080/chat");
   webSocket.Onopen = function Message(){processOpen(message);};

   webSocket.Onmessage = function Message(){processMessage(message);};

   webSocket.Onclose = function Message(){processClose(message);};

   webSocket.Onerror = function Message(){processError(message);};


 function processOpen(message){
    messagesTextArea.value +="server Connected....."+"\n";
 }

 function processMessage(message){
    messagesTextArea.value +="Receive from server....."+message.data+"\n";
 }

 function processClose(message){
     webSocket.send("client disconnected");
     messagesTextArea.value +="server DISConnected....."+"\n";
 }

  function sendMessage(){
    console.log("enter");

     if(textMessage.value!=="close"){
         alert(textMessage.value);
          webSocket.send(textMessage.value);

          alert("2");
          messagesTextArea.value +="send to server....."+textMessage.value()+"\n";
         alert("3");
        textMessage.value="";
       alert("4");
     }
     else{
            alert("else message");
            webSocket.close();
     }

  }

 function processError(message){
     webSocket.send("client disconnected");
     messagesTextArea.value +="error....."+"\n";

 }