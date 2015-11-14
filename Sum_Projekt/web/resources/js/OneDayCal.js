var timesarr = ["06:00", "07:00",
            "08:00", "09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00",
            "19:00", "20:00", "21:00", "22:00", "23:00", "00:00", "01:00", "02:00", "03:00", "04:00", "05:00"];
        
$(function () {
    console.log("JavaScript loadet");
    var html = "";
    var i;
    for(i=0; i<timesarr.length; i++){
        html+="<tr><td>";
        html+=timesarr[i];
        html+="</td><td></td></tr>";
    }
//    console.log(html);
    $("tbody").append(html);
});