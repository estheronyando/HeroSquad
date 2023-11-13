$(document).ready(function(){
// Animations init
new WOW().init();

var typed=new Typed(`#type`,{
     strings:[" Create a Well balanced Squad of Heroes "," At the very least, they should have a name, age, special power and weakness. could be freely assignable or you may offer users a pre-determined set to choose from. "],
     backSpeed:70,
     typeSpeed:80,
     smartBackspace:true,
     loop: true,
   })
   var typed =new Typed(`#msg`,{
        strings:[" Your Squad has been saved ! "],
        backSpeed:70,
        typeSpeed:80,
        smartBackspace:true,
      })
})


function btnClick(){
timer:4000
Swal.fire(
  'View squad List?',
  'question'
)
}

function firstClick(){
timer:4000
Swal.fire(
  'Add new squad?',
  'question'
)
}