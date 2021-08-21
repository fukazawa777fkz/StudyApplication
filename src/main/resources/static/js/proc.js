


function onclickButton(engWord,userData,index){

    var elem = document.getElementsByName("mondai")[index];
    if (elem.value == engWord.mondai){
        document.getElementsByName("ansComment")[index].innerHTML = "正解だぜ。" + userData.first_name;
        document.getElementsByName('ansOkImg')[index].style.display = 'inline';
        document.getElementsByName('ansNGImg')[index].style.display = 'none';

    }else{
        document.getElementsByName("ansComment")[index].innerHTML = "間違ってるゼ。" + userData.first_name;
        document.getElementsByName('ansOkImg')[index].style.display = 'none';
        document.getElementsByName('ansNGImg')[index].style.display = 'inline';
    }
}


function onClickGoogleTeacher(engWord,userData,index){
    var googlePath = 'https://translate.google.co.jp/?hl=ja&tab=TT&sl=en&tl=ja&text=';
    // nWin = window.open(googlePath + engWord.mondai, '_blank'); // 新しいタブを開き、ページを表示
    var top = window.innerHeight / 2;
    var left = window.innerWidth / 2;
    var WIDTH = window.innerWidth / 2;
    var HEIGHT = window.innerHeight / 2;;
    var x = left - (WIDTH / 2);
    var y = top - (HEIGHT / 2);
    googleEiyaku = window.open(googlePath + engWord.mondai,null, 'top=' + y + ',left=' + x + ',width=' + WIDTH + ',height=' + HEIGHT );
    googleEiyaku.focus();

}

function exec1() {
    var elem = document.getElementById("q1");
    var o1 = document.getElementById("o1");
    // var now = new Date();
    // var hour = now.getHours();
    // var min = now.getMinutes();

    if ((elem.value == "You bought a TV.") || (elem.value == "You bought a tv.")){
        o1.innerHTML = "正解だぜ。はるな。";
        document.getElementById('img1').style.display = 'inline';
        document.getElementById('img1hazure1').style.display = 'none';

    }else{
        o1.innerHTML = "はずれだぜ。はるな。";
        document.getElementById('img1').style.display = 'none';
        document.getElementById('img1hazure1').style.display = 'inline';
    }
}

function exec2() {
    var elem = document.getElementById("q2");
    var o2 = document.getElementById("o2");
    // var now = new Date();
    // var hour = now.getHours();
    // var min = now.getMinutes();

    if ((elem.value == "Did you buy a TV?") || (elem.value == "Did you buy a tv?")){
        o2.innerHTML = "正解だぜ。はるな。";
        document.getElementById('img2').style.display = 'inline';
        document.getElementById('img1hazure2').style.display = 'none';

    }else{
        o2.innerHTML = "はずれだぜ。はるな。";
        document.getElementById('img2').style.display = 'none';
        document.getElementById('img1hazure2').style.display = 'inline';
    }
}

function exec3() {
    var elem = document.getElementById("q3");
    var o3 = document.getElementById("o3");
    // var now = new Date();
    // var hour = now.getHours();
    // var min = now.getMinutes();

    if ((elem.value == "You are watching TV.") || (elem.value == "You are watching tv.") ){
        o3.innerHTML = "正解だぜ。はるな。";
        document.getElementById('img3').style.display = 'inline';
        document.getElementById('img1hazure3').style.display = 'none';

    }else{
        o3.innerHTML = "はずれだぜ。はるな。";
        document.getElementById('img3').style.display = 'none';
        document.getElementById('img1hazure3').style.display = 'inline';
    }
}

function exec4() {
    var elem = document.getElementById("q4");
    var o4 = document.getElementById("o4");
    // var now = new Date();
    // var hour = now.getHours();
    // var min = now.getMinutes();

    if ((elem.value == "Did you watch TV yesterday?") || (elem.value == "Did you watch tv yesterday?")){
        o4.innerHTML = "正解だぜ。はるな。";
        document.getElementById('img4').style.display = 'inline';
        document.getElementById('img1hazure4').style.display = 'none';

    }else{
        o4.innerHTML = "はずれだぜ。はるな。";
        document.getElementById('img4').style.display = 'none';
        document.getElementById('img1hazure4').style.display = 'inline';
    }
}

function exec5() {
    var elem = document.getElementById("q5");
    var o5 = document.getElementById("o5");
    // var now = new Date();
    // var hour = now.getHours();
    // var min = now.getMinutes();

    if ((elem.value == "You will watch TV tomorrow.") || (elem.value == "You will watch tv tomorrow.")){
        o5.innerHTML = "正解だぜ。はるな。";
        document.getElementById('img5').style.display = 'inline';
        document.getElementById('img1hazure5').style.display = 'none';

    }else{
        o5.innerHTML = "はずれだぜ。はるな。";
        document.getElementById('img5').style.display = 'none';
        document.getElementById('img1hazure5').style.display = 'inline';
    }
}

function execHint1(){
    var elem = document.getElementById("q1");
    // help('https://translate.google.co.jp/?hl=ja&tab=TT&sl=en&tl=ja&text=did%20you%20watch%20tv%3F&op=translate');
    help(elem.value);
}


function help(line){
    var googlePath = 'https://translate.google.co.jp/?hl=ja&tab=TT&sl=en&tl=ja&text=';
    nWin = window.open(googlePath + line, '_blank'); // 新しいタブを開き、ページを表示
}
