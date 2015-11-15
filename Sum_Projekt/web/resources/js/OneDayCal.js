var timesarr = ["06:00", "07:00",
    "08:00", "09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00",
    "19:00", "20:00", "21:00", "22:00", "23:00", "00:00", "01:00", "02:00", "03:00", "04:00", "05:00"];

function Activity(start, duration, text) {
    this.start = start;
    this.duration = duration;
    this.text = text;
}
;

Activity.prototype.toString = function () {
    return this.text;
};

var actslist = [
    new Activity("07:00", "00:15", "Vaekning af Anders, skal til tandlaege"),
    new Activity("15:00", "00:30", "Overlap")
];

$(function () {
    console.log("JavaScript loadet");
    var html = "";
    var i;
    for (i = 0; i < timesarr.length; i++) {
        html += "<tr><td>";
        html += timesarr[i];
        html += "</td><td>";
        html += "<div class=\"actClass\">test</div>"; //div som anker til placering af activities
        html += "</td></tr>";
    }
    $("tbody").append(html);
    var j;
    for (j = 0; j < actslist.length; j++) {
        console.log(actslist[j].start + ", " + actslist[j].duration + ", " + actslist[j].toString());
        
       // var startid = "#div" + actslist[j].start;
        //console.log("div valgt: " + $(startid));
    }
});

//var element_pos = 0;
//$(function (){
//    $(function(){
//        $("#testActivity").css({
//            border: '1px dashed', position: 'absolute', left: element_pos, 
//                top: $('#divContainer').height() + 20,
//                width: '120', height: '120', padding: '3', margin: '0'
//        });
//    });
//});