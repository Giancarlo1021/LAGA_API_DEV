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
  days+=`<div class="days">${i}</div>`;     // I added class="days"
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


container.addEventListener("click", e => {
  
  //console.log(e.target);
  //e.target.classList.toggle('selected');
  
  if(e.target.classList.contains('days')){  // IT WORKSSS
        //console.log(e.target);
       e.target.classList.toggle('selected');
    }
    //e.target.classList.toggle('selected');

    // 1st click, then 2nd click: if selected day > than the 1st click, select all inbetween
    /*
  if(e.target.classList.contains('days')){

  }*/ 
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