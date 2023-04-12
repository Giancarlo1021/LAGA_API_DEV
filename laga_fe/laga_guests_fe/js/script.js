
// calendar UI
const date = new Date();
const container = document.querySelector('.container');

const renderCalendar = () => {

//date.setDate(1);

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
  days+=`<div class="days day_s">${i}</div>`;     // I added class="day_s"
  }
}
monthDays.innerHTML = days;

for(let j =1; j <= nextDays; j++){
  days +=`<div class="next-date">${j}</div>`
}
monthDays.innerHTML = days;

}




/*
function submitInitForm(event) {
  event.preventDefault();

  let check_in = document.querySelector("#check_in");
  let check_out = document.querySelector("#check_out");
  let room_what = document.querySelector("#roomName");
  let numRooms = document.querySelector("#rooms");
  let numAdults = document.querySelector("#adults");
  let numChild = document.querySelector("#children");

  console.log("Check in: " + check_in);
  console.log("Check in: " + check_out);
  console.log("Check in: " + room_what);
  console.log("Check in: " + numRooms);
  console.log("Check in: " + numAdults);
  console.log("Check in: " + numChild);

}



  console.log("Check in: " + check_in);
  console.log("Check in: " + check_out);
  console.log("Check in: " + room_what);
  console.log("Check in: " + numRooms);
  console.log("Check in: " + numAdults);
  console.log("Check in: " + numChild);*/

/*
container.addEventListener('click', e => {
  
  if(e.target.classList.contains('days') && !e.target.classList.contains('occupied')){ //possibly today or prev-date or next-date
    e.target.classList.toggle('selected');
  }
});*/

/*
  var first_day = 0; // 0 is flag for empty, bc 0 date dne
  var last_day = 0; 

container.addEventListener("click", e => {

  
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

  const check_in = document.getElementById('check_in');
  const check_out = document.getElementById('check_out');

  check_in.value = date.getFullYear() + '-0' + (date.getMonth() + 1) + '-0' + first_day;
  check_out.value = date.getFullYear() + '-0' + (date.getMonth() + 1) + '-0' + last_day;
  //console.log(date.getFullYear() + '-' + (date.getMonth() + 1) + '-' + first_day);
});*/

document.querySelector(".prev").addEventListener("click", () => {
  date.setMonth(date.getMonth() - 1);
  renderCalendar();
});

document.querySelector(".next").addEventListener("click", () => {
  date.setMonth(date.getMonth() + 1);
  renderCalendar();
});

renderCalendar();




// information handling

const check_in = document.getElementById('check_in');
const check_out = document.getElementById('check_out');
//const highDay = document.getElementById('days');
// const dateTarget = document.querySelector('.days'); -> monthDays above
const monthDays = document.querySelector('.days');
const daysInMonth = monthDays.querySelector('.day_s');


check_in.addEventListener('change', e => {
  const dateParts = check_in.value.split('-');
  const day = parseInt(dateParts[2]); // actual day
  console.log('The check_in date has been changed. Value: ' + day);

  //daysInMonth.classList.toggle('selected');
  //if(e.target.classList.contains('days')){
  console.log("asdas: ", monthDays);
  //document.querySelector('.days').innerHTML === 
  //console.log("asdas: ", daysInMonth);
  //}
  //highDay.classList.add('.selected');
});


check_out.addEventListener('change', function() {
  console.log('The check_out date has been changed.');

});

const initForm = document.querySelector('#initForm');

initForm.addEventListener('submit', e => {
  e.preventDefault();
  let check_in = document.querySelector("#check_in").value;
  let check_out = document.querySelector("#check_out").value;
  let room_price = document.querySelector("#roomName").value;
  //let room_what = document.querySelector("#roomName option[value='${room_price}']").innerHTML;
  let numRooms = document.querySelector("#rooms").value;
  let numAdults = document.querySelector("#adults").value;
  let numChild = document.querySelector("#children").value;

  console.log("Check in: " + check_in);
  console.log("Check out: " + check_out);
  //console.log("Room: " + room_what);
  console.log("Number of Rooms: " + numRooms);
  console.log("Adults: " + numAdults);
  console.log("Children: " + numChild);

  //local for now, will use node.js and express to connect with heroku
  localStorage.setItem('check_in', check_in);
  localStorage.setItem('check_out', check_out);
  //localStorage.setItem('room_what', room_what);
  localStorage.setItem('room_price', room_price);
  localStorage.setItem('numRooms', numRooms);
  localStorage.setItem('numAdults', numAdults);
  localStorage.setItem('numChild', numChild);

  window.location.href = 'details.html';
  //window.location.href = 'confirmation.html'
});