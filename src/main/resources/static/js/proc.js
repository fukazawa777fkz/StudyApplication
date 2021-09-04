function formSubmit(button,form, user_no) {
    var baseAction = "/eng";
	var selectWordType  = document.getElementById('selectWordType').selectedIndex;
    var selectSchoolType =   document.getElementById('selectschoolType').selectedIndex;
    var selectSchoolYear =   document.getElementById('selectschoolYear').selectedIndex;
    baseAction = baseAction + '?user_no=' + user_no;
    baseAction = baseAction + '&engWordType=' + selectWordType;
    baseAction = baseAction + '&schoolType=' + selectSchoolType;
    baseAction = baseAction + '&schoolYear=' + selectSchoolYear;

    form.method = "get"
    location.href = baseAction;
}

function onclickButton(form,engWord,userData,index){
    var elem = document.getElementsByName("mondai")[index];
    if (elem.value.toLowerCase() == engWord.mondai.toLowerCase()){
        if (engWord.ok_comment == null){
            document.getElementsByName("ansComment")[index].innerHTML = "正解だぜ。" + userData.first_name;
        }
        else{
            document.getElementsByName("ansComment")[index].innerHTML = engWord.ok_comment + userData.first_name;
        }

        var audio_media = document.getElementById("seikai");
        audio_media.volume = audio_media.volume * 0.5;
        audio_media.play();
        document.getElementsByName('ansOkImg')[index].style.display = 'inline';
        document.getElementsByName('ansOkImg')[index].WIDTH = 200;
        document.getElementsByName('ansNGImg')[index].style.display = 'none';
        resultCommit(form,engWord,userData,1);

    }else{
        if (engWord.ng_comment == null){
            document.getElementsByName("ansComment")[index].innerHTML = "間違ってるゼ。" + userData.first_name;
        }
        else{
            document.getElementsByName("ansComment")[index].innerHTML = engWord.ng_comment + userData.first_name;
        }
        document.getElementsByName('ansOkImg')[index].style.display = 'none';
        document.getElementsByName('ansNGImg')[index].style.display = 'inline';
        document.getElementsByName('ansNGImg')[index].HEIGHT = 100;
        resultCommit(form,engWord,userData,0);
    }
}

function resultCommit(form,engWord,userData,judgResult) {

    var data = new FormData(form);
    $.ajax({
     url: "/eng/resultCommit/" + userData.user_no + "/" + engWord.mondai_id + "/" + judgResult ,
     method: "POST",
      dataType: "json",
      data: data,
      processData: false,
      contentType: false
    }).then(function(result) {
        // var cls = $('[data-id=' + candidateShohinNo + '-' + candidateOptionShohinNo + '-' + columnId + ']');
        // if ("hasError" == result) {
        //   cls.show();
        // } else if ("" != result) {
        //   cls.html(result);
        //   cls.show();
        // } else {
        //   cls.hide();
        // }
    });

}

function updateEngWordInfo(form,userData) {

	var selectWordType  = document.getElementById('selectWordType').selectedIndex;
    var data = new FormData(form);
    $.ajax({
     url: "/eng/resultCommit/" + userData.user_no + "/" + selectWordType,
     method: "POST",
      dataType: "json",
      data: data,
      processData: false,
      contentType: false
    }).then(function(result) {
    });

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
