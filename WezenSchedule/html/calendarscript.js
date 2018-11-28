let schedule_url = "https://b3ivwb09fg.execute-api.us-east-1.amazonaws.com/Alpha";
let curr_month = "December";
let curr_day = 1;
let curr_year = 2018;
window.onload = generateCalendar;

  function run(){
    curr_day = document.getElementById("selectDate").value;
    curr_year = document.getElementById("selectyear").value;
    alert("day = "+curr_day + " year= " + curr_year);
    if (document.getElementById("selectmonth").value == "nomonth"){
      curr_month = "December"
    }else {curr_month = document.getElementById("selectmonth").value;}
    updateDisplay();
  }

  function updateDisplay(){
    document.getElementById("showyear").innerHTML = curr_year;
    document.getElementById("displaymonth").innerHTML =curr_month;
  }

  function generateCalendar(){
    document.getElementById("daysview").innerHTML = "";
      let view = document.getElementById("viewselect").value;
      if(view == "week"){weekView();}
      else{monthView();}
  }
  function makeHeader(arr){
    let header = document.createElement("tr");
    document.getElementById("daysview").appendChild(header);
    for(let j=0;j<arr.length;j++){
      let head = document.createElement("td");
      html =  "<b>" + arr[j];
      head.innerHTML = html;
      header.appendChild(head);
    }
  }

  function weekView(){
    let headervals = ["Time","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"];
    makeHeader(headervals);
    let currWeek = document.createElement("tr");
    document.getElementById("daysview").appendChild(currWeek);

    let emptytime = document.createElement("td");
    currWeek.appendChild(emptytime);

    let weekstart = 1;
    let weekend = weekstart + 7;
    for (let i = weekstart; i < weekend; i++){
          let day = document.createElement("td");
          day.className = "day";
          day.innerHTML = i + "<br>";


          if (i == 3 || i == 5) {
            let free = document.createElement("button");
            free.innerText = "Free";
            free.value = i;

            free.addEventListener('click', function(){handleFreeButton(free)});

            day.appendChild(free);
          }
          currWeek.appendChild(day);//only the first row
      }
  }

  function monthView(){
    let monthlength = 31;
    let daysview = document.getElementById("daysview");

    let headervals = ["Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"];
    makeHeader(headervals);
    let currWeek = document.createElement("tr");
    daysview.appendChild(currWeek);

    for (let i = 1; i <= monthlength; i++){
          let day = document.createElement("td");
          day.className = "day";
          day.innerHTML = i + "<br>";

          if (i == 3 || i == 5) {
              let free = document.createElement("button");
              free.innerText = "Free";
              free.value = i;
              free.addEventListener('click', function(){handleFreeButton(free)});
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
    let js = JSON.parse(result);

    let response = js["name"];

    // Update response
    alert("free: Date: " + day + ": " + response);
}

function handleFreeButton(obj){
  promptMeetingName();
    curr_day = obj.value;
    let data = {};
    data["date"] = curr_day;
    let js = JSON.stringify(data);
    console.log("JS:" + js);
    let xhr = new XMLHttpRequest();

    xhr.open("POST", schedule_url, true);
    // send the collected date as JSON
    xhr.send(js);

    // This will process results and update HTML as appropriate
    xhr.onloadend = function() {
        console.log(xhr);
        console.log(xhr.request);
        if(xhr.readyState == XMLHttpRequest.DONE) {
            console.log ("XHR:" + xhr.responseText);
            processDateResponse(name, curr_day, xhr.responseText);
        } else {
            processDateResponse(name, curr_day, "N/A");
        }
    }
}

function promptMeetingName(){
  let label = document.getElementById("mtnglabel");
  label.innerHTML="<b>Name for Meeting on " + curr_day + ", " + curr_month + " " + curr_year + ": <b>";

  let prompt = document.getElementById('mtngPrompt');
  prompt.style.display='block';
  // prompt.style.width='auto';


}
