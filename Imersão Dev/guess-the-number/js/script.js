var number = getRandomInt(10);
var attempts = 3;

function tryGuess() {
    var guess = document.getElementById("guess").value;
    var result = "";

    alert(guess);
    alert(result);
    alert(attempts);

    if (attempts > 0 ) {
        if (guess > number) {
            attempts = attempts - 1;
            result = "To height!";
            printAttempts(attempts);
            printResult(result);
        } else if (guess < number) {
            attempts = attempts - 1;
            result = "To low!";
            printAttempts(attempts);
            printResult(result);
        } else {
            result = "YOU WON !"
            printResult(result);
        }
    }
    if (guess !== number && attempts === 0 ) {
        result = "You have lost :( The number was " + number;
        printAttempts(attempts);
        printResult(result);
    }
}

function getRandomInt(max) {
    return Math.floor(Math.random() * max);
}


function printResult(result){
    document.getElementById("result").innerHTML = result;
}

function printAttempts(attempts){
    document.getElementById("attempts").innerHTML = "You have " + attempts +" attempts.";
}