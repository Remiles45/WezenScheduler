let schedule_url = "https://b3ivwb09fg.execute-api.us-east-1.amazonaws.com/Alpha";

window.onload = getSchedules;

function getSchedules(){
  let schedulelist = ["im a schedule","another schedule"];
  for(let i=0; i<schedulelist.length;i++){
    let list = document.getElementById("scheduleList");
    let curr_sched = document.createElement("li");
    curr_sched.innerHTML = schedulelist[i];
    list.appendChild(curr_sched);
  }
}


function toggleSort(){
    let selection = document.getElementById("viewMenu");
    if(selection.value == "hr"){
      document.getElementById("sortForm").style.visibility = "visible";
      document.getElementById("sortlabel").innerHTML = " Hours";
    }else if(selection.value == "day"){
      document.getElementById("sortForm").style.visibility = "visible";
      document.getElementById("sortlabel").innerHTML = " Days";
    }else{
      document.getElementById("sortForm").style.visibility = "hidden";
    }
}
