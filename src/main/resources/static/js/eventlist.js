var localDate = document.getElementById('userLocalDate').innerText;

var userEvents = JSON.parse(document.getElementById("userEvents").innerText);
console.log(userEvents);

for(i = 0; i < userEvents.length; i++) {


    var eventName = userEvents[i].name;

    var eventDate = userEvents[i].eventDate;

    var eventDiv = document.createElement("div");
    eventDiv.innerHTML = eventName + " on " + eventDate;
    eventDiv.style.background = '#415A77';
    eventDiv.style.borderRadius = "10px 10px 10px 10px";
    eventDiv.style.margin = "1em";
    eventDiv.style.padding = "5px";

    document.getElementById("eventList").appendChild(eventDiv);

}
