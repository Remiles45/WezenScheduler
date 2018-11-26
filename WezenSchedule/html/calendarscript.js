  window.onload = setUpCalendar;

  function run(){
    var month = document.getElementById("selectmonth").value;
    if (month == "nomonth"){
      month = "November"
    }
    document.getElementById("displaymonth").innerHTML = month;
  }

  function setUpCalendar(){
    generateCalendar();
  }

  function generateCalendar(){
    document.getElementById("daysview").innerHTML = "";


      var view = document.getElementById("viewselect").value;
      if(view == "week"){weekView();}
      else{monthView();}
  }
  function makeHeader(arr){
      var header = document.createElement("tr");
    document.getElementById("daysview").appendChild(header);
    for(let j=0;j<arr.length;j++){
      let head = document.createElement("td");
      html =  "<b>" + arr[j];
      head.innerHTML = html;
      header.appendChild(head);
    }
  }

  function weekView(){
    var headervals = ["Time","Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"];
    makeHeader(headervals);
    var currWeek = document.createElement("tr");
    document.getElementById("daysview").appendChild(currWeek);

    var emptytime = document.createElement("td");
    currWeek.appendChild(emptytime);

    var weekstart = 1;
    var weekend = weekstart + 7;
    for (let i = weekstart; i < weekend; i++){
          let day = document.createElement("td");
          day.className = "day";
          day.innerHTML = i + "<br>";
          day.addEventListener('click', selectDate(i));

          if (i == 3 || i == 5) {
              var free = document.createElement("button");
              free.innerText = "Free";
              free.addEventListener('click', handleFreeButton(i));
              day.appendChild(free);
          }
          currWeek.appendChild(day);//only the first row
      }
  }

  function monthView(){
    var monthlength = 31;
    var daysview = document.getElementById("daysview");

    var headervals = ["Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"];
    makeHeader(headervals);
      var currWeek = document.createElement("tr");
      daysview.appendChild(currWeek);

    for (let i = 1; i <= monthlength; i++){
          let day = document.createElement("td");
          day.className = "day";
          day.innerHTML = i + "<br>";
          day.addEventListener('click', selectDate(i));

          if (i == 3 || i == 5) {
              var free = document.createElement("button");
              free.innerText = "Free";
              free.addEventListener('click', handleFreeButton(i));
              day.appendChild(free);
          }

          if(i%7 == 0){
            currWeek.appendChild(day)
            currWeek = document.createElement("tr");
            daysview.appendChild(currWeek);
          } else {currWeek.appendChild(day);}
      }
  }

  function processDateResponse(name, day, result) {
    // Can grab any DIV or SPAN HTML element and can then manipulate its
    // contents dynamically via javascript
    console.log("result:" + result);
    var js = JSON.parse(result);

    var response = js["name"];

    // Update response
    alert("free: Date: " + day + ": " + response);
}

function handleFreeButton(day){
    var data = {};
    data["date"] = day;

    var js = JSON.stringify(data);
    console.log("JS:" + js);
    var xhr = new XMLHttpRequest();
    xhr.open("POST", schedule_url, true);

    // send the collected date as JSON
    xhr.send(js);

    // This will process results and update HTML as appropriate
    xhr.onloadend = function() {
        console.log(xhr);
        console.log(xhr.request);
        if(xhr.readyState == XMLHttpRequest.DONE) {
            console.log ("XHR:" + xhr.responseText);
            processDateResponse(name, day, xhr.responseText);
        } else {
            processDateResponse(name, day, "N/A");
        }
    }
}

  function selectDate(day){
      return function() {
          alert(day);
      }
  }
