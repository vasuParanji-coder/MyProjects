let userScore = 0;
let compScore = 0;
const userScore_span = document.getElementById('user_score');
const compScore_span = document.getElementById('comp_score');
const scoreboard_div = document.querySelector('.scoreboard');
const result_div = document.querySelector('.result > p');
const rock_div = document.getElementById('rock_');
const paper_div = document.getElementById('paper_');
const scissors_div = document.getElementById('scissors_');
const lizard_div = document.getElementById('lizard_');
const spock_div = document.getElementById('spock_');

function getCompChoice(){
  const choices = ['Rock', 'Paper', 'Scissors', 'Lizard', 'Spock']
  const ranNum = (Math.floor(Math.random()* 5));
  return choices[ranNum];
}

function win(userChoice, computerChoice){
  userScore++;
  userScore_span.innerHTML = userScore;
  compScore_span.innerHTML = compScore;
  result_div.innerHTML = userChoice + '(User)'.fontsize(3).sub() + " beats " + computerChoice + '(Computer)'.fontsize(3).sub() + ". You Win!"
}


function lose(userChoice, computerChoice){
  compScore++;
  userScore_span.innerHTML = userScore;
  compScore_span.innerHTML = compScore;
  result_div.innerHTML = computerChoice + '(Computer)'.fontsize(3).sub() + " beats " + userChoice + '(User)'.fontsize(3).sub() + ". You Lost!"
}

function draw(userChoice, computerChoice){
  result_div.innerHTML = userChoice + '(User)'.fontsize(3).sub() + " is same as " + computerChoice + '(Computer)'.fontsize(3).sub() + ". It's a Draw!"
}

function game(userChoice){
  const computerChoice = getCompChoice();
  switch(userChoice + computerChoice){
    case "RockScissors":
    case "ScissorsPaper":
    case "PaperRock":
    case "RockLizard":
    case "LizardSpock":
    case "SpockScissors":
    case "ScissorsLizard":
    case "LizardPaper":
    case "PaperSpock":
    case "SpockRock":
      win(userChoice, computerChoice)
      break;

    case "ScissorsRock":
    case "PaperScissors":
    case "RockPaper":
    case "LizardRock":
    case "SpockLizard":
    case "ScissorsSpock":
    case "LizardScissors":
    case "PaperLizard":
    case "SpockPaper":
    case "RockSpock":
      lose(userChoice, computerChoice)
      break;

    case "ScissorsScissors":
    case "PaperPaper":
    case "RockRock":
    case "LizardLizard":
    case "SpockSpock":
      draw(userChoice, computerChoice)
      break;
  }
}

function main(){
    rock_div.addEventListener('click', function(){
      game("Rock")
    })

    paper_div.addEventListener('click', function(){
      game("Paper")
    })

    scissors_div.addEventListener('click', function(){
      game("Scissors")
    })

    lizard_div.addEventListener('click', function(){
      game("Lizard")
    })

    spock_div.addEventListener('click', function(){
      game("Spock")
    })
}
main();
