let schedule_url = "https://b3ivwb09fg.execute-api.us-east-1.amazonaws.com/Alpha";

window.onload = getSchedules;

function getSchedules(){
  let schedulelist = ["im a schedule","another schedule"];
  for(let i=0; i<schedulelist.length;i++){
    let list = document.getElementById("scheduleList");
    let curr_sched = document.createElement("li");
    // curr_sched.className = "schedules";
    let deletebtn = document.createElement("button");
    deletebtn.innerText = "Delete";
    curr_sched.listval = schedulelist[i];
    deletebtn.addEventListener('click',function(){handleDeleteSchedule(curr_sched)});
    curr_sched.innerHTML = curr_sched.listval + "  ";
    curr_sched.appendChild(deletebtn);
    list.appendChild(curr_sched);
  }
}

function handleDeleteSchedule(sched){
  alert("Im gonna delete schedule called "+ sched.listval );
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
