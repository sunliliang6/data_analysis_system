
function formatDate(datetime) {
    function addDateZero(num) {
        return (num < 10 ? "0" + num : num);
    }
    let d = new Date(datetime);
    let formatdatetime = d.getFullYear() + '-' + addDateZero(d.getMonth() + 1) + '-' + addDateZero(d.getDate()) + ' ' + addDateZero(d.getHours()) + ':' + addDateZero(d.getMinutes()) + ':' + addDateZero(d.getSeconds());
    return formatdatetime;
}

function dateDay(dateChange) {
    let date1 = new Date(dateChange);
    var year = date1.getFullYear();
    var month = date1.getMonth() + 1;//js从0开始取
    var date = date1.getDate();
    var hour = date1.getHours();
    var minutes = date1.getMinutes();
    var second = date1.getSeconds();

    if (month < 10) {
        month = "0" + month;
    }
    if (date < 10) {
        date = "0" + date;
    }
    if (hour < 10) {
        hour = "0" + hour;
    }
    if (minutes < 10) {
        minutes = "0" + minutes;
    }
    if (second < 10) {
        second = "0" + second;
    }

    var time = year+month+date;
    return time;
}
function getNowFormatDate() {
    //获取当前的日期时间 格式“yyyy-MM-dd HH:MM”
    var date = new Date();
    var seperator1 = "-";
    var seperator2 = ":";
    var month = date.getMonth() + 1;
    var strDate = date.getDate();
    if (month >= 1 && month <= 9) {
        month = "0" + month;
    }

    var hour = date.getHours();
    var minute = date.getMinutes();
    if (parseInt(hour) < 10)
        hour = "0" + hour;
    if (parseInt(minute) < 10)
        minute = "0" + minute;
    var curT = hour + ':' + minute;

    if (strDate >= 0 && strDate <= 9) {
        strDate = "0" + strDate;
    }
    var currentdate = month + "-" + strDate
    // + seperator2 + date.getSeconds();
    return currentdate;
}

//时间转换成字符串
function dateTo(dateChange) {
    let date1 = new Date(dateChange);
    // var year = date1.getFullYear();
    var month = date1.getMonth() + 1;//js从0开始取
    var date = date1.getDate();
    var hour = date1.getHours();
    var minutes = date1.getMinutes();
    var second = date1.getSeconds();

    if (month < 10) {
        month = "0" + month;
    }
    if (date < 10) {
        date = "0" + date;
    }
    if (hour < 10) {
        hour = "0" + hour;
    }
    if (minutes < 10) {
        minutes = "0" + minutes;
    }
    if (second < 10) {
        second = "0" + second;
    }

    var time = date+"日"+hour + ":" + minutes;
    return time;
}

var timerRunning = false;
function checkDateTime() {
    if (timerRunning) {
        clearTimeout(updatetime);
        timerRunning = false;
    }
    for (var i = 1; i <= 1; i++) {
        var today = new Date();
        var month = today.getMonth() + 1;
        var date = today.getDate();
        var year = today.getYear() + 0;
        month = today.getMonth() + 1;
        date = today.getDate();
        var day = today.getDay();
        var hour = today.getHours();
        var minute = today.getMinutes();
        var second = today.getSeconds();
        var dateTime = addZero(hour) + ":" + addZero(minute) + ":" + addZero(second) + "," + addZero(month) + "/" + addZero(date);
        if (i == 1) //北京时间
            $("#bj_time").text(dateTime);
    }
    updatetime = setTimeout("checkDateTime()", 1000);
    timerRunning = true;
}
function addZero(num, end) {
    return num < 10 ? "0" + num : num;
}
/* 得到日期年月日等加数字后的日期 */
Date.prototype.dateAdd = function (interval, number) {
    var d = this;
    var k = { 'y': 'FullYear', 'q': 'Month', 'm': 'Month', 'w': 'Date', 'd': 'Date', 'h': 'Hours', 'n': 'Minutes', 's': 'Seconds', 'ms': 'MilliSeconds' };
    var n = { 'q': 3, 'w': 7 };
    eval('d.set' + k[interval] + '(d.get' + k[interval] + '()+' + ((n[interval] || 1) * number) + ')');
    return d;
}
function dateToStr(dateChange) {
    let date1 = new Date(dateChange);
    // var year = date1.getFullYear();
    var month = date1.getMonth() + 1;//js从0开始取
    var date = date1.getDate();
    var hour = date1.getHours();
    var minutes = date1.getMinutes();
    var second = date1.getSeconds();
    if (month < 10) {
        month = "0" + month;
    }
    if (date < 10) {
        date = "0" + date;
    }
    if (hour < 10) {
        hour = "0" + hour;
    }
    if (minutes < 10) {
        minutes = "0" + minutes;
    }
    if (second < 10) {
        second = "0" + second;
    }
    var time = hour + ":" + minutes;
    return time;
}

function dateHour(dateChange) {
    var year = dateChange.getFullYear();
    var month = dateChange.getMonth() + 1;//js从0开始取
    var date = dateChange.getDate();
    var hour = dateChange.getHours();
    var minutes = dateChange.getMinutes();
    var second = dateChange.getSeconds();
    if (month < 10) {
        month = "0" + month;
    }
    if (date < 10) {
        date = "0" + date;
    }
    if (hour < 10) {
        hour = "0" + hour;
    }
    if (minutes < 10) {
        minutes = "0" + minutes;
    }
    if (second < 10) {
        second = "0" + second;
    }
    var time = year + "/" + month + "/" + date + "\t" + hour + ":" + minutes + ":" + second;
    return time;
}
