var orig = [];
var startTime;

function runTest(level) {
    var checkout = document.getElementById("checkout");
    checkout.style.display = "none";
    var countLetters = [2, 3, 3, 4, 4];
    var countNumbers = [2, 2, 3, 3, 4];
    var lett = makeLetters(countLetters[level]);
    var numbr = makeNumbers(countNumbers[level]);
    var original = [];
    for (var i = 0; i < Math.floor((level + 4) / 2); i++) {
        original.push(lett[i]);
        original.push(numbr[i]);
    }
    original = shuffler(original);
    orig = original;
    document.getElementById("mixed").innerHTML = original.toString();
    window.setTimeout(hideStart, 3000);
    startTime = Date.now();
}

function check() {
    var guess = document.getElementById("guess").value;
    var sorted = sorter(orig);
    if (isSameSequence(sorted, guess)) {
    var g = guess.split(",");
        var timeLapse = startTime - Date.now();
        document.getElementById("original").innerHTML = "Well done!" +
            g.toString() +
            sorted.toString() +
            timeLapse;
        showResult();
    }
}

function isSameSequence(sorted, guess) {
    var g = guess.split(",");
    return (sorted.length === g.length &&
    sorted.toString() === g.toString());
}

function hideStart() {
    var start = document.getElementById("start");
    start.style.display = "none";
    //show checkout
    var checkout = document.getElementById("checkout");
    checkout.style.display = "block";
}

function showResult() {
    document.getElementById("sorted").innerHTML = sorted;
}

function shuffler(original) {
    shuffle(original);
    return original;
}

function sorter(original) {
    return original.sort();
}

function makeLetters(count) {
    var letters = ["A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K",
        "L", "M", "N", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"];
    var listL = [];
    var letters2 = shuffle(letters);
    for (var i = 0; i < count; i++) {
        listL.push(letters2[i]);
    }
    return listL;
}

function shuffle(array) {
    var currentIndex = array.length;
    var temporaryValue, randomIndex;

    // While there remain elements to shuffle...
    while (0 !== currentIndex) {

        // Pick a remaining element...
        randomIndex = Math.floor(Math.random() * currentIndex);
        currentIndex -= 1;

        // And swap it with the current element.
        temporaryValue = array[currentIndex];
        array[currentIndex] = array[randomIndex];
        array[randomIndex] = temporaryValue;
    }

    return array;
}

function makeNumbers(count) {
    var numbers = ["1", "2", "3", "4", "5", "6", "7", "8", "9"];
    var listN = [];
    numbers2 = shuffle(numbers);
    for (var i = 0; i < count; i++) {

        listN.push(numbers2[i]);
    }
    //document.getElementById("original").innerHTML = listN.toString();
    return listN;
}
