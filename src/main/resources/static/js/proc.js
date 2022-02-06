document.addEventListener("DOMContentLoaded", function(event) {
    console.log('test2');
});


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


var _video_play = false;
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


        if (_video_play == false){
            // https://cly7796.net/blog/javascript/manipulating-youtube-iframes-written-directly-in-html-with-javascript/
            // API読み込み
            var tag = document.createElement('script');
            tag.src = "https://www.youtube.com/iframe_api";
            var firstScriptTag = document.getElementsByTagName('script')[0];
            firstScriptTag.parentNode.insertBefore(tag, firstScriptTag);
        }
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

var ytPlayer;
// https://cly7796.net/blog/javascript/manipulating-youtube-iframes-written-directly-in-html-with-javascript/
// https://web-no-hito.com/youtube_ios_autoplay/
function onYouTubeIframeAPIReady() {
  
  var videoUrl = document.getElementById("youtube_url");
//   player = new YT.Player('player', {
//     height: '360',
//     width: '640',
//     videoId: videoUrl.innerText,
//     events: {
//       'onReady': onPlayerReady,
//       'onStateChange': onPlayerStateChange
//     }
//   });

    ytPlayer = new YT.Player(
    "player", // 埋め込む場所の指定
    {
      videoId: videoUrl.innerText, // YouTubeのID,
      playerVars: {
        // height: '180',
        width: '50',
        height: '50',
        loop: 1,
        autoplay: 0,
        rel: 0,
        controls: 1,
        modestbranding: 1,
        widgetid: 1,
        playlist:videoUrl.innerText,
        playsinline: 1, // スマホでも自動再生
        showinfo: 0,
        fs: 0,
      },
    events: {
        onReady: onPlayerReady,　// プレーヤーの準備ができたとき
        onStateChange: onPlayerStateChange,　// プレーヤーの再生、一時停止、終了したとき
      },
  });
}

// 4. The API will call this function when the video player is ready.
function onPlayerReady(event) {
    // event.target.playVideo();　// 動画再生
}

// 5. The API calls this function when the player's state changes.
//    The function indicates that when playing a video (state=1),
//    the player should play for six seconds and then stop.
var done = false;
function onPlayerStateChange(event) {
//   if (event.data == YT.PlayerState.PLAYING && !done) {
//     setTimeout(stopVideo, 6000);
//     done = true;
//   }

    // if (event.data == YT.PlayerState.ENDED) {
    //     event.target.playVideo();
    // }

    // 現在のプレーヤーの状態を取得

    // var aaa = document.getElementById("player");

    document.getElementById("testtest").style.display ="none";

    // YT.controls = 0;
    var ytStatus = event.data;
    // 再生終了したとき
    if (ytStatus == YT.PlayerState.ENDED) {
        console.log('再生終了');
        // 動画再生
        event.target.playVideo();
    }
    // 再生中のとき
    if (ytStatus == YT.PlayerState.PLAYING) {
        console.log('再生中');
    }
    // 停止中のとき
    if (ytStatus == YT.PlayerState.PAUSED) {
        console.log('停止中');
    }
    // バッファリング中のとき
    if (ytStatus == YT.PlayerState.BUFFERING) {
        console.log('バッファリング中');
    }
    // 頭出し済みのとき
    if (ytStatus == YT.PlayerState.CUED) {
        console.log('頭出し済み');
    }
}
function stopVideo() {
//   player.stopVideo();
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

	var aaaaa = "";
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
