const date = new Date();
const container = document.querySelector('.container');

const renderCalendar = () => {

date.setDate(1);

const monthDays = document.querySelector('.days');

const lastDay = new Date(date.getFullYear(), date.getMonth() + 1, 0).getDate();

const prevLastDay = new Date(date.getFullYear(), date.getMonth(), 0).getDate();

const firstDayIndex = date.getDay();

const lastDayIndex = new Date(date.getFullYear(), date.getMonth() + 1, 0).getDay();

const nextDays = 7-lastDayIndex-1;

//const container = document.querySelector('.container');


const months = [
  "January",
  "February",
  "March",
  "April",
  "May",
  "June",
  "July",
  "August",
  "September",
  "October",
  "November",
  "December",
];

document.querySelector('.date h1').innerHTML
= months[date.getMonth()];

/*
document.querySelector('.date p').innerHTML
= new Date().toDateString();*/
let days = "";

for(let x = firstDayIndex; x > 0; x--){
  days+= `<div class="prev-date">${prevLastDay -x + 1}</div>`
}

for(let i = 1; i <= lastDay; i++){
  if(i === new Date().getDate() && date.getMonth() === new Date().getMonth()){
    days+=`<div class="today">${i}</div>`;
  }else{
  days+=`<div class="day_s">${i}</div>`;     // I added class="day_s"
  }
}
monthDays.innerHTML = days;

for(let j =1; j <= nextDays; j++){
  days +=`<div class="next-date">${j}</div>`
}
monthDays.innerHTML = days;

}

/*
container.addEventListener('click', e => {
  
  if(e.target.classList.contains('days') && !e.target.classList.contains('occupied')){ //possibly today or prev-date or next-date
    e.target.classList.toggle('selected');
  }
});*/

  var first_day = 0; // 0 is flag for empty, bc 0 date dne
  var last_day = 0; 

container.addEventListener("click", e => {

  /*
  if(e.target.classList.contains('day_s') && !e.target.classList.contains('selected')){
      e.target.classList.toggle('selected');
    }
  else if(e.target.classList.contains('day_s') && e.target.classList.contains('selected')){
    //console.log(e.target.innerText);
    e.target.classList.toggle('selected');
    
  }*/
  if(e.target.classList.contains('day_s') && !e.target.classList.contains('selected')){
      if(first_day == 0 && last_day == 0){
        e.target.classList.toggle('selected');
        first_day = parseInt(e.target.innerHTML);
        console.log("first day = " + first_day);
      }
      else{
        if(first_day != 0 && last_day == 0){
          e.target.classList.toggle('selected');
          last_day = parseInt(e.target.innerHTML);
          console.log("last day = " + last_day);
          
          if(first_day > last_day){
            let ecup;
            ecup = first_day;
            first_day = last_day;
            last_day = ecup;
            console.log("new -> first day = " + first_day + ", last day = " + last_day);
          }
        }
        
      }

      
    }
  else if(e.target.classList.contains('day_s') && e.target.classList.contains('selected')){
    e.target.classList.toggle('selected');
  }

  if(first_day != 0 && last_day != 0){
          console.log("we're here now\n");

          const sel = document.querySelectorAll('.day_s');
          //console.log(sel);
          //sel.forEach(element => element.classList.add('selected'));


          
          sel.forEach(element => {
            if(element.innerHTML > first_day && element.innerHTML < last_day){
              element.classList.add('selected');
              console.log(element.innerHTML);
            }
          });
  }

      
});

document.querySelector(".prev").addEventListener("click", () => {
  date.setMonth(date.getMonth() - 1);
  renderCalendar();
});

document.querySelector(".next").addEventListener("click", () => {
  date.setMonth(date.getMonth() + 1);
  renderCalendar();
});

renderCalendar();


function submitBook(event) {
  event.preventDefault();

        const form = event.target;
        const data = {
          roomNumber: form.roomNumber.value,
          roomName: form.roomName.value,
          availability: form.availability.value === 'true',
        };
        const url = 'https://demo-giancarlo.herokuapp.com/room';
        const options = {
          method: 'POST',
          headers: {
            'Content-Type': 'application/json'
          },
          body: JSON.stringify(data)
        };
        fetch(url, options)
          .then(response => {
              if (response.status === 200) {
                  console.log(`Room posted successfully.`);
              } else {
                  console.error(`Failed to post room ${roomNumber}: ${response.status} ${response.statusText}`);
              }
          })
          .catch(error => console.error(error));
}